package hu.tarnai.minerva.controllers.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate.BooleanOperator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hu.tarnai.minerva.bo.EtlapBo;
import hu.tarnai.minerva.bo.EtlapKategoriaBo;
import hu.tarnai.minerva.bo.HetimenuBo;
import hu.tarnai.minerva.entity.Etlap;
import hu.tarnai.minerva.entity.Etlapkategoria;
import hu.tarnai.minerva.entity.Napimenu;
import hu.tarnai.minerva.enums.ErrorCodeEnum;
import hu.tarnai.minerva.objects.EtlapObject;
import hu.tarnai.minerva.objects.NapimenuJasperObj;
import hu.tarnai.minerva.utility.DateToStringClass;
import hu.tarnai.minerva.utility.ImageUpload;
import hu.tarnai.minerva.utility.JasperUtil;
import hu.tarnai.minerva.utility.Message;
import hu.tarnai.minerva.utility.PageName;
import hu.tarnai.minerva.utility.ResultSession;
import hu.tarnai.minerva.utility.StringValidator;
import hu.tarnai.minerva.utility.UserSession;


@Controller
public class EtlapController {
	
	static String ETLAP_UJ_URL = "etlapUj";
	static String ETLAP_MODOSIT_URL = "etlapModosit";
	static String ETLAP_KATEGORIA_UJ = "ujEtlapKategoria";
	static String ETLAP_KATEGORIA_MODIF = "etlapKategoriaModif";
	static String ETLAP_KATEGORIA_SORREND = "etlapKategoriaSorrendRendez";
	static String NAPI_MENU_UJ = "napiMenuUj";
	static String NAPI_MENU_MODOSIT = "napimenuNextModosit";
	static String ACTUAL_NAPI_MENU_MODOSIT = "napimenuActualModosit";
	
	//---------------új étel----------------------
	@RequestMapping(value = "/etlapUj", method = RequestMethod.GET)
	public String etlapUjGet(Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, ETLAP_UJ_URL);
		
		EtlapKategoriaBo bo = new EtlapKategoriaBo();
		
		model.addAttribute("kategoria", bo.getActive());
		return UserSession.checkUser(request, ETLAP_UJ_URL, model);
	}
	
	//---------------új étel----------------------
	@RequestMapping(value = "/etlapUj", method = RequestMethod.POST)
	public String etlapUjPost(@RequestParam(name = "nev_hu") String nev_hu,
							  @RequestParam(name = "nev_en") String nev_en,
							  @RequestParam(name = "leiras_hu") String leiras_hu,
							  @RequestParam(name = "leiras_en") String leiras_en,
							  @RequestParam(name = "kategoria") int kategoria,
							  @RequestParam(name = "ar") String ar,
							  Model model, HttpServletRequest request, RedirectAttributes redirect,MultipartHttpServletRequest requestPicture){
		
		PageName.saveAdmin(request, ETLAP_UJ_URL);
		
		EtlapBo bo = new EtlapBo();
		EtlapKategoriaBo kBo = new EtlapKategoriaBo();
		
		Etlap e = new Etlap();
		byte[] kep = ImageUpload.getImage(requestPicture);
		
		e.setNev(nev_hu + "/" + nev_en);
		e.setLeiras(leiras_hu + "/" + leiras_en);
		e.setKategoria(kategoria);
		e.setAr(ar);
		e.setKep(kep);
		
		if(kep !=null){
			e.setIs_kep(1);
		}
		
		ErrorCodeEnum error = bo.add(e, request);
		if(error == ErrorCodeEnum.SUCCESS){
			Message.success(request);
		}else if(error == ErrorCodeEnum.NAME_NOT_VALID_ERROR){
			Message.errorNameValid(request);
			e.setIs_kep(0);
			ResultSession.set(request, e);
		}else if(error == ErrorCodeEnum.ERROR){
			Message.error(request);
			e.setIs_kep(0);
			ResultSession.set(request, e);
		}else{
			Message.errorDb(request);
			e.setIs_kep(0);
			ResultSession.set(request, e);
		}
		
		model.addAttribute("kategoria", kBo.getActive());
		
		return UserSession.checkUser(request, ETLAP_UJ_URL, model);
	}
	
	//---------------étel módosít----------------------
	@RequestMapping(value = "/etlapModosit", method = RequestMethod.GET)
	public String etlapModositGet(Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, ETLAP_MODOSIT_URL);
		
		EtlapBo bo = new EtlapBo();
		EtlapKategoriaBo kBo = new EtlapKategoriaBo();
		
		model.addAttribute("kategoria", kBo.getActive());
		model.addAttribute("etlapList", bo.getAll());
		
		return UserSession.checkUser(request, ETLAP_MODOSIT_URL, model);
	}
	
	@RequestMapping(value = "/etlapModosit", method = RequestMethod.POST)
	public String etlapModositPost(@RequestParam(name = "id") int id,
								   @RequestParam(name = "nev_hu") String nev_hu,
								   @RequestParam(name = "nev_en") String nev_en,
								   @RequestParam(name = "originalNev") String originalNev,
								   @RequestParam(name = "leiras_hu") String leiras_hu,
								   @RequestParam(name = "leiras_en") String leiras_en,
								   @RequestParam(name = "kategoria") int kategoria,
								   @RequestParam(name = "is_kep") int is_kep,
								   @RequestParam(name = "ar") String ar,Model model, HttpServletRequest request, RedirectAttributes redirect, MultipartHttpServletRequest requestPicture){
		
		PageName.saveAdmin(request, ETLAP_MODOSIT_URL);
		
		EtlapBo bo = new EtlapBo();
		EtlapKategoriaBo kBo = new EtlapKategoriaBo();
		boolean isOriginal = true;
		
		
		Etlap e = new Etlap();
		byte[] kep = ImageUpload.getImage(requestPicture);
		
		e.setId(id);
		e.setNev(nev_hu + "/" + nev_en);
		
		if(!originalNev.equals(e.getNev())) {
			isOriginal = false;
		}
		
		e.setLeiras(leiras_hu + "/" + leiras_en);
		e.setKategoria(kategoria);
		e.setAr(ar);
		e.setIs_kep(is_kep);
		
		if(kep == null && is_kep == 1){
			e.setIs_kep(-1);
			e.setKep(null);
		}else if(kep != null){
			e.setKep(kep);
			e.setIs_kep(1);
		}else if(is_kep == 0){
			e.setIs_kep(0);
			e.setKep(null);
		}
		
		ErrorCodeEnum error = bo.modif(e,isOriginal);
		if(error == ErrorCodeEnum.SUCCESS){
			Message.success(request);
		}else if(error == ErrorCodeEnum.NAME_NOT_VALID_ERROR){
			Message.errorNameValid(request);
		}else if(error == ErrorCodeEnum.ERROR){
			Message.error(request);
		}else{
			Message.error(request);
		}
		
		model.addAttribute("kategoria", kBo.getActive());
		model.addAttribute("etlapList", bo.getAll());
		
		return UserSession.checkUser(request, ETLAP_MODOSIT_URL, model);
	}
	
	//--------------------------stat módosít-----------------------
	@RequestMapping(value = "/etlapChangeStat", method = RequestMethod.POST)
	public String etlapChangeStatPost(@RequestParam(name = "id") int id,Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, ETLAP_MODOSIT_URL);
		
		EtlapBo bo = new EtlapBo();
		EtlapKategoriaBo kBo = new EtlapKategoriaBo();
		
		ErrorCodeEnum error = bo.changeStat(id);
		
		if(error == ErrorCodeEnum.SUCCESS){
			Message.success(request);
		}else{
			Message.error(request);
		}
		
		model.addAttribute("kategoria", kBo.getActive());
		model.addAttribute("etlapList", bo.getAll());
		
		return UserSession.checkUser(request, ETLAP_MODOSIT_URL, model);
	}
	
	//--------------------------törlés-----------------------
	@RequestMapping(value = "/etlapDelet", method = RequestMethod.POST)
	public String etlapDeletPost(@RequestParam(name = "id") int id,Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, ETLAP_MODOSIT_URL);
		
		EtlapBo bo = new EtlapBo();
		EtlapKategoriaBo kBo = new EtlapKategoriaBo();
		
		ErrorCodeEnum error = bo.delet(id,request);
		
		if(error == ErrorCodeEnum.SUCCESS){
			Message.success(request);
		}else{
			Message.error(request);
		}
		
		model.addAttribute("kategoria", kBo.getActive());
		model.addAttribute("etlapList", bo.getAll());
		
		return UserSession.checkUser(request, ETLAP_MODOSIT_URL, model);
	}
	
	//---------------------új étlap kategória---------------------
	@RequestMapping(value = "/ujEtlapKategoria", method = RequestMethod.GET)
	public String ujEtlapKategoriaGet(Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, ETLAP_KATEGORIA_UJ);
		
		return UserSession.checkUser(request, ETLAP_KATEGORIA_UJ, model);
	}
	
	@RequestMapping(value = "/ujEtlapKategoria", method = RequestMethod.POST)
	public String ujEtlapKategoriaPost(@RequestParam(name = "nev_hu") String nev_hu, @RequestParam(name = "nev_en") String nev_en,Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, ETLAP_KATEGORIA_UJ);
		
		EtlapKategoriaBo bo = new EtlapKategoriaBo();
		Etlapkategoria kat = new Etlapkategoria();
		
		kat.setNev(nev_hu + "/" + nev_en);
		
		ErrorCodeEnum error = bo.add(kat.getNev());
		if(error == ErrorCodeEnum.SUCCESS){
			Message.success(request);
		}else if(error == ErrorCodeEnum.NAME_NOT_VALID_ERROR){
			Message.errorNameValid(request);
			ResultSession.set(request, kat);
		}else{
			Message.error(request);
			ResultSession.set(request, kat);
		}
		
		return UserSession.checkUser(request, ETLAP_KATEGORIA_UJ, model);
	}
	
	//---------------------étlap kategória módosít---------------------
	@RequestMapping(value = "/etlapKategoriaModif", method = RequestMethod.GET)
	public String etlapKategoriaModifGet(Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, ETLAP_KATEGORIA_UJ);
		
		EtlapKategoriaBo bo = new EtlapKategoriaBo();
		
		model.addAttribute("katList", bo.getAll());
		
		return UserSession.checkUser(request, ETLAP_KATEGORIA_MODIF, model);
	}
	
	//---------------------étlap kategória módosít---------------------
	@RequestMapping(value = "/etlapKategoriaModif", method = RequestMethod.POST)
	public String etlapKategoriaModifPost(@RequestParam(name = "id") int id, @RequestParam(name = "nev_hu") String nev_hu, @RequestParam(name = "nev_en") String nev_en, Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, ETLAP_KATEGORIA_UJ);
		
		EtlapKategoriaBo bo = new EtlapKategoriaBo();
		Etlapkategoria kat = new Etlapkategoria();
		
		kat.setId(id);
		kat.setNev(nev_hu + "/" + nev_en);
		
		ErrorCodeEnum error = bo.modif(kat);
		
		if(error == ErrorCodeEnum.SUCCESS){
			Message.success(request);
		}else if(error == ErrorCodeEnum.NAME_NOT_VALID_ERROR){
			Message.errorNameValid(request);
		}else{
			Message.error(request);
		}
		
		model.addAttribute("katList", bo.getAll());
		
		return UserSession.checkUser(request, ETLAP_KATEGORIA_MODIF, model);
	}
	
	//---------------------étlap kategória stat csere---------------------
	@RequestMapping(value = "/etlapKategoriaChangeStat", method = RequestMethod.POST)
	public String etlapKategoriaChangeStatPost(@RequestParam(name = "id") int id, Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, ETLAP_KATEGORIA_UJ);
		
		EtlapKategoriaBo bo = new EtlapKategoriaBo();
		
		ErrorCodeEnum error = bo.changeStat(id);
		
		if(error == ErrorCodeEnum.SUCCESS){
			Message.success(request);
		}else{
			Message.error(request);
		}
		
		model.addAttribute("katList", bo.getAll());
		
		return UserSession.checkUser(request, ETLAP_KATEGORIA_MODIF, model);
	}
	
	//---------------------étlap kategória töröl---------------------
	@RequestMapping(value = "/etlapKategoriaDelet", method = RequestMethod.POST)
	public String etlapKategoriaDeletPost(@RequestParam(name = "id") int id, Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, ETLAP_KATEGORIA_UJ);
		
		EtlapKategoriaBo bo = new EtlapKategoriaBo();
		
		ErrorCodeEnum error = bo.delet(id);
		
		if(error == ErrorCodeEnum.SUCCESS){
			Message.success(request);
		}else{
			Message.error(request);
		}
		
		model.addAttribute("katList", bo.getAll());
		
		return UserSession.checkUser(request, ETLAP_KATEGORIA_MODIF, model);
	}
	
	//---------------------étlap kategória sorrend---------------------
	@RequestMapping(value = "/etlapKategoriaSorrendRendez", method = RequestMethod.GET)
	public String etlapKategoriaSorrendRendezGet(Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, ETLAP_KATEGORIA_SORREND);
		
		EtlapKategoriaBo bo = new EtlapKategoriaBo();
		
		model.addAttribute("katList", bo.getAll());
		
		return UserSession.checkUser(request, ETLAP_KATEGORIA_SORREND, model);
	}
	
	//---------------------étlap kategória sorrend---------------------
	@RequestMapping(value = "/etlapKategoriaSorrendRendez", method = RequestMethod.POST)
	public String etlapKategoriaSorrendRendezPost(@RequestParam(name="id") int[] id,Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, ETLAP_KATEGORIA_SORREND);
		
		EtlapKategoriaBo bo = new EtlapKategoriaBo();
		
		boolean error = true;
		
		for(int i=0;i<id.length;i++){
			error &= bo.setSorrend(id[i], i);
		}
		
		if(error){
			Message.success(request);
		}else{
			Message.error(request);
		}
		
		model.addAttribute("katList", bo.getAll());
		
		return UserSession.checkUser(request, ETLAP_KATEGORIA_SORREND, model);
	}
	//---------------------jövőheti menük---------------------
	@RequestMapping(value = "/napiMenuUj", method = RequestMethod.GET)
	public String napiMenuUjGet(Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, NAPI_MENU_UJ);
		
		EtlapBo bo = new EtlapBo();

		model.addAttribute("days", DateToStringClass.getDaysName());
		model.addAttribute("etelek", EtlapObject.get());
		
		return UserSession.checkUser(request, NAPI_MENU_UJ, model);
	}
	
	//---------------------jövőheti menük---------------------
	@RequestMapping(value = "/napiMenuUj", method = RequestMethod.POST)
	public String napiMenuUjPost(@RequestParam(name="leves_hu") String[] leves_hu,
								 @RequestParam(name="leves_en") String[] leves_en,
								 @RequestParam(name="foetel_hu") String[] foetel_hu,
								 @RequestParam(name="foetel_en") String[] foetel_en,
								 @RequestParam(name="koret_hu") String[] koret_hu,
								 @RequestParam(name="koret_en") String[] koret_en,
								 Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, NAPI_MENU_UJ);
		
		EtlapBo bo = new EtlapBo();
		HetimenuBo hBo = new HetimenuBo();
		List<String> days = DateToStringClass.getDaysName();
		List<Napimenu> menus = new ArrayList<Napimenu>();
		
		String[] levesek = new String[7];
		String[] foetelek = new String[7];
		String[] koretek = new String[7];
		
		for(int i=0;i<7;i++){
			if(StringValidator.isNotEmpty(leves_hu[i])&&StringValidator.isNotEmpty(leves_en[i])){
				levesek[i] = leves_hu[i] + "/" + leves_en[i];
			}else if(StringValidator.isNotEmpty(leves_hu[i])&&StringValidator.isEmpty(leves_en[i])){
				levesek[i] = leves_hu[i] + "/" + leves_hu[i];
			}else if(StringValidator.isEmpty(leves_hu[i])&&StringValidator.isNotEmpty(leves_en[i])){
				model.addAttribute("days", days);
				model.addAttribute("etelek", EtlapObject.get());
				Message.error(request, "Kérem adja meg a magyar nevét is a levesnek (" + days.get(i) + ")");
				return UserSession.checkUser(request, NAPI_MENU_UJ, model);
			}
		}
		
		for(int i=0;i<7;i++){
			if(StringValidator.isNotEmpty(foetel_hu[i])&&StringValidator.isNotEmpty(foetel_en[i])){
				foetelek[i] = foetel_hu[i] + "/" + foetel_en[i];
			}else if(StringValidator.isNotEmpty(foetel_hu[i])&&StringValidator.isEmpty(foetel_en[i])){
				foetelek[i] = foetel_hu[i] + "/" + foetel_hu[i];
			}else if(StringValidator.isEmpty(foetel_hu[i])&&StringValidator.isNotEmpty(foetel_en[i])){
				model.addAttribute("days", days);
				model.addAttribute("etelek", EtlapObject.get());
				Message.error(request, "Kérem adja meg a magyar nevét is a főételnek (" + days.get(i) + ")");
				return UserSession.checkUser(request, NAPI_MENU_UJ, model);
			}
		}
		
		for(int i=0;i<7;i++){
			if(StringValidator.isNotEmpty(koret_hu[i])&&StringValidator.isNotEmpty(koret_en[i])){
				koretek[i] = koret_hu[i] + "/" + koret_en[i];
			}else if(StringValidator.isNotEmpty(koret_hu[i])&&StringValidator.isEmpty(koret_en[i])){
				koretek[i] = koret_hu[i] + "/" + koret_hu[i];
			}else if(StringValidator.isEmpty(koret_hu[i])&&StringValidator.isNotEmpty(koret_en[i])){
				model.addAttribute("days", days);
				model.addAttribute("etelek", EtlapObject.get());
				Message.error(request, "Kérem adja meg a magyar nevét is a köretnek (" + days.get(i) + ")");
				return UserSession.checkUser(request, NAPI_MENU_UJ, model);
			}
		}
		
		for(int i=0;i<7;i++){
			if(StringValidator.isNotEmpty(levesek[i])||StringValidator.isNotEmpty(foetelek[i])||StringValidator.isNotEmpty(koretek[i])){
				Napimenu n = new Napimenu();
				n.setLeves(levesek[i]);
				n.setFoetel(foetelek[i]);
				n.setKoret(koretek[i]);
				n.setNap(days.get(i));
				menus.add(n);
			}
		}
		
		ErrorCodeEnum error = hBo.saveWeekDays(menus, false);
		
		if(error == ErrorCodeEnum.SUCCESS){
			Message.success(request);
		}else if(error == ErrorCodeEnum.ERROR){
			Message.error(request);
		}else{
			Message.errorDb(request);
		}
		
		model.addAttribute("days", days);
		model.addAttribute("etelek", EtlapObject.get());
		
		return UserSession.checkUser(request, NAPI_MENU_UJ, model);
	}
	
	//---------------------jövőheti menük módosít---------------------
	@RequestMapping(value = "/napimenuNextModosit", method = RequestMethod.GET)
	public String napimenuNextModositGet(Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, NAPI_MENU_MODOSIT);
		
		EtlapBo bo = new EtlapBo();
		
		List<Napimenu> menus = getNexWeekMenus();
		
		model.addAttribute("etelek", EtlapObject.get());
		model.addAttribute("hetiMenu", menus);
		
		return UserSession.checkUser(request, NAPI_MENU_MODOSIT, model);
	}

	//---------------------jövőheti menük modosit---------------------
	@RequestMapping(value = "/napimenuNextModosit", method = RequestMethod.POST)
	public String napimenuNextModositPost(@RequestParam(name="leves_hu") String[] leves_hu,
								 @RequestParam(name="leves_en") String[] leves_en,
								 @RequestParam(name="foetel_hu") String[] foetel_hu,
								 @RequestParam(name="foetel_en") String[] foetel_en,
								 @RequestParam(name="koret_hu") String[] koret_hu,
								 @RequestParam(name="koret_en") String[] koret_en,
								 Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, NAPI_MENU_MODOSIT);
		
		EtlapBo bo = new EtlapBo();
		HetimenuBo hBo = new HetimenuBo();
		List<String> days = DateToStringClass.getDaysName();
		List<Napimenu> menus = new ArrayList<Napimenu>();
		
		String[] levesek = new String[7];
		String[] foetelek = new String[7];
		String[] koretek = new String[7];
		
		for(int i=0;i<7;i++){
			if(StringValidator.isNotEmpty(leves_hu[i])&&StringValidator.isNotEmpty(leves_en[i])){
				levesek[i] = leves_hu[i] + "/" + leves_en[i];
			}else if(StringValidator.isNotEmpty(leves_hu[i])&&StringValidator.isEmpty(leves_en[i])){
				levesek[i] = leves_hu[i] + "/" + leves_hu[i];
			}else if(StringValidator.isEmpty(leves_hu[i])&&StringValidator.isNotEmpty(leves_en[i])){
				List<Napimenu> m = getNexWeekMenus();
				model.addAttribute("hetiMenu", m);
				model.addAttribute("etelek", EtlapObject.get());
				Message.error(request, "Kérem adja meg a magyar nevét is a levesnek (" + days.get(i) + ")");
				return UserSession.checkUser(request, NAPI_MENU_UJ, model);
			}
		}
		
		for(int i=0;i<7;i++){
			if(StringValidator.isNotEmpty(foetel_hu[i])&&StringValidator.isNotEmpty(foetel_en[i])){
				foetelek[i] = foetel_hu[i] + "/" + foetel_en[i];
			}else if(StringValidator.isNotEmpty(foetel_hu[i])&&StringValidator.isEmpty(foetel_en[i])){
				foetelek[i] = foetel_hu[i] + "/" + foetel_hu[i];
			}else if(StringValidator.isEmpty(foetel_hu[i])&&StringValidator.isNotEmpty(foetel_en[i])){
				List<Napimenu> m = getNexWeekMenus();
				model.addAttribute("hetiMenu", m);
				model.addAttribute("etelek", EtlapObject.get());
				Message.error(request, "Kérem adja meg a magyar nevét is a főételnek (" + days.get(i) + ")");
				return UserSession.checkUser(request, NAPI_MENU_UJ, model);
			}
		}
		
		for(int i=0;i<7;i++){
			if(StringValidator.isNotEmpty(koret_hu[i])&&StringValidator.isNotEmpty(koret_en[i])){
				koretek[i] = koret_hu[i] + "/" + koret_en[i];
			}else if(StringValidator.isNotEmpty(koret_hu[i])&&StringValidator.isEmpty(koret_en[i])){
				koretek[i] = koret_hu[i] + "/" + koret_hu[i];
			}else if(StringValidator.isEmpty(koret_hu[i])&&StringValidator.isNotEmpty(koret_en[i])){
				List<Napimenu> m = getNexWeekMenus();
				model.addAttribute("hetiMenu", m);
				model.addAttribute("etelek", EtlapObject.get());
				Message.error(request, "Kérem adja meg a magyar nevét is a köretnek (" + days.get(i) + ")");
				return UserSession.checkUser(request, NAPI_MENU_UJ, model);
			}
		}
		
		for(int i=0;i<7;i++){
			if(StringValidator.isNotEmpty(levesek[i])||StringValidator.isNotEmpty(foetelek[i])||StringValidator.isNotEmpty(koretek[i])){
				Napimenu n = new Napimenu();
				n.setLeves(levesek[i]);
				n.setFoetel(foetelek[i]);
				n.setKoret(koretek[i]);
				n.setNap(days.get(i));
				menus.add(n);
			}
		}
		
		ErrorCodeEnum error = hBo.saveWeekDays(menus, false);
		
		if(error == ErrorCodeEnum.SUCCESS){
			Message.success(request);
		}else if(error == ErrorCodeEnum.ERROR){
			Message.error(request);
		}else{
			Message.errorDb(request);
		}
		
		List<Napimenu> m = getNexWeekMenus();
		model.addAttribute("hetiMenu", m);
		model.addAttribute("etelek", EtlapObject.get());
		
		return UserSession.checkUser(request, NAPI_MENU_MODOSIT, model);
	}
		
	//---------------------aktuális menük módosít---------------------
	@RequestMapping(value = "/napimenuActualModosit", method = RequestMethod.GET)
	public String napimenuActualModositGet(Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, ACTUAL_NAPI_MENU_MODOSIT);
		
		EtlapBo bo = new EtlapBo();
		
		List<Napimenu> menus = getActualWeekMenus();
		
		model.addAttribute("etelek", EtlapObject.get());
		model.addAttribute("hetiMenu", menus);
		
		return UserSession.checkUser(request, ACTUAL_NAPI_MENU_MODOSIT, model);
	}
	
	//---------------------jövőheti menük modosit---------------------
	@RequestMapping(value = "/napimenuActualModosit", method = RequestMethod.POST)
	public String napimenuActualModositPost(@RequestParam(name="leves_hu") String[] leves_hu,
								 @RequestParam(name="leves_en") String[] leves_en,
								 @RequestParam(name="foetel_hu") String[] foetel_hu,
								 @RequestParam(name="foetel_en") String[] foetel_en,
								 @RequestParam(name="koret_hu") String[] koret_hu,
								 @RequestParam(name="koret_en") String[] koret_en,
								 Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, ACTUAL_NAPI_MENU_MODOSIT);
		
		EtlapBo bo = new EtlapBo();
		HetimenuBo hBo = new HetimenuBo();
		List<String> days = DateToStringClass.getDaysName();
		List<Napimenu> menus = new ArrayList<Napimenu>();
		
		String[] levesek = new String[7];
		String[] foetelek = new String[7];
		String[] koretek = new String[7];
		
		for(int i=0;i<7;i++){
			if(StringValidator.isNotEmpty(leves_hu[i])&&StringValidator.isNotEmpty(leves_en[i])){
				levesek[i] = leves_hu[i] + "/" + leves_en[i];
			}else if(StringValidator.isNotEmpty(leves_hu[i])&&StringValidator.isEmpty(leves_en[i])){
				levesek[i] = leves_hu[i] + "/" + leves_hu[i];
			}else if(StringValidator.isEmpty(leves_hu[i])&&StringValidator.isNotEmpty(leves_en[i])){
				List<Napimenu> m = getActualWeekMenus();
				model.addAttribute("hetiMenu", m);
				model.addAttribute("etelek", EtlapObject.get());
				Message.error(request, "Kérem adja meg a magyar nevét is a levesnek (" + days.get(i) + ")");
				return UserSession.checkUser(request, NAPI_MENU_UJ, model);
			}
		}
		
		for(int i=0;i<7;i++){
			if(StringValidator.isNotEmpty(foetel_hu[i])&&StringValidator.isNotEmpty(foetel_en[i])){
				foetelek[i] = foetel_hu[i] + "/" + foetel_en[i];
			}else if(StringValidator.isNotEmpty(foetel_hu[i])&&StringValidator.isEmpty(foetel_en[i])){
				foetelek[i] = foetel_hu[i] + "/" + foetel_hu[i];
			}else if(StringValidator.isEmpty(foetel_hu[i])&&StringValidator.isNotEmpty(foetel_en[i])){
				List<Napimenu> m = getActualWeekMenus();
				model.addAttribute("hetiMenu", m);
				model.addAttribute("etelek", EtlapObject.get());
				Message.error(request, "Kérem adja meg a magyar nevét is a főételnek (" + days.get(i) + ")");
				return UserSession.checkUser(request, NAPI_MENU_UJ, model);
			}
		}
		
		for(int i=0;i<7;i++){
			if(StringValidator.isNotEmpty(koret_hu[i])&&StringValidator.isNotEmpty(koret_en[i])){
				koretek[i] = koret_hu[i] + "/" + koret_en[i];
			}else if(StringValidator.isNotEmpty(koret_hu[i])&&StringValidator.isEmpty(koret_en[i])){
				koretek[i] = koret_hu[i] + "/" + koret_hu[i];
			}else if(StringValidator.isEmpty(koret_hu[i])&&StringValidator.isNotEmpty(koret_en[i])){
				List<Napimenu> m = getActualWeekMenus();
				model.addAttribute("hetiMenu", m);
				model.addAttribute("etelek", EtlapObject.get());
				Message.error(request, "Kérem adja meg a magyar nevét is a köretnek (" + days.get(i) + ")");
				return UserSession.checkUser(request, NAPI_MENU_UJ, model);
			}
		}
		
		for(int i=0;i<7;i++){
			if(StringValidator.isNotEmpty(levesek[i])||StringValidator.isNotEmpty(foetelek[i])||StringValidator.isNotEmpty(koretek[i])){
				Napimenu n = new Napimenu();
				n.setLeves(levesek[i]);
				n.setFoetel(foetelek[i]);
				n.setKoret(koretek[i]);
				n.setNap(days.get(i));
				menus.add(n);
			}
		}
		
		ErrorCodeEnum error = hBo.saveWeekDays(menus, true);
		
		if(error == ErrorCodeEnum.SUCCESS){
			Message.success(request);
		}else if(error == ErrorCodeEnum.ERROR){
			Message.error(request);
		}else{
			Message.errorDb(request);
		}
		
		List<Napimenu> m = getActualWeekMenus();
		model.addAttribute("hetiMenu", m);
		model.addAttribute("etelek", EtlapObject.get());
		
		return UserSession.checkUser(request, ACTUAL_NAPI_MENU_MODOSIT, model);
	}
		
//	@RequestMapping(value = "/printNapimenu", method = RequestMethod.POST)
//	public String printNapimenuPost(Model model, HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirect){
//		PageName.saveAdmin(request, NAPI_MENU_MODOSIT);
//		
//		EtlapBo bo = new EtlapBo();
//		
//		List<Napimenu> menus = getNexWeekMenus();
//		List<NapimenuJasperObj> jaspObj = convertNapimenuToJasperOb(menus);
//		
//		JasperUtil jasperUtil = new JasperUtil("hetiMenu.jasper");
//		
//		jasperUtil.printNapimenu("2018.május 04-től - 2018.május 10-ig", jaspObj, response);
//		
//		model.addAttribute("etelek", EtlapObject.get());
//		model.addAttribute("hetiMenu", menus);
//		
//		return UserSession.checkUser(request, NAPI_MENU_MODOSIT, model);
//	}
	
	//--------------jövőheti menüket adja vissza (teljes hét!)
	public List<Napimenu> getNexWeekMenus() {
		HetimenuBo hBo = new HetimenuBo();
		List<String> days = DateToStringClass.getDaysName();
		List<Napimenu> menus = new ArrayList<Napimenu>();
		List<Napimenu> mm = hBo.getNext();
		
		for(String d:days){
			boolean isCorrect = false;
			Napimenu n = new Napimenu();
			for(Napimenu nn:mm){
				nn.setNap(HetimenuBo.getDayName(nn.getNap()));
				if(nn.getNap().equals(d)){
					menus.add(nn);
					isCorrect = true;
					break;
				}
			}
			if(!isCorrect){
				n.setNap(d);
				menus.add(n);
			}
		}
		return menus;
	}
	
	//--------------aktuális menüket adja vissza (teljes hét!)
	public List<Napimenu> getActualWeekMenus() {
		HetimenuBo hBo = new HetimenuBo();
		List<String> days = DateToStringClass.getDaysName();
		List<Napimenu> menus = new ArrayList<Napimenu>();
		List<Napimenu> mm = hBo.getActual();
		
		for(String d:days){
			boolean isCorrect = false;
			Napimenu n = new Napimenu();
			for(Napimenu nn:mm){
				nn.setNap(HetimenuBo.getDayName(nn.getNap()));
				if(nn.getNap().equals(d)){
					menus.add(nn);
					isCorrect = true;
					break;
				}
			}
			if(!isCorrect){
				n.setNap(d);
				menus.add(n);
			}
		}
		return menus;
	}
	
	public List<NapimenuJasperObj> convertNapimenuToJasperOb(List<Napimenu> napi){
		List<NapimenuJasperObj> jasper = new ArrayList<NapimenuJasperObj>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		int index = 0;
		for(Napimenu n:napi) {
			jasper.add(new NapimenuJasperObj("" + index, n.getNap(), n.getLeves(), n.getFoetel(), n.getKoret()));
		}
		
		return jasper;
	}
}
