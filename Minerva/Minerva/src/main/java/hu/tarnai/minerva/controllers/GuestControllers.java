package hu.tarnai.minerva.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hu.tarnai.minerva.bo.AjanlatBo;
import hu.tarnai.minerva.bo.FoldalBo;
import hu.tarnai.minerva.bo.GalleryBo;
import hu.tarnai.minerva.bo.GetImagesBo;
import hu.tarnai.minerva.bo.HetimenuBo;
import hu.tarnai.minerva.entity.Ajanlat;
import hu.tarnai.minerva.entity.Etlap;
import hu.tarnai.minerva.entity.Galeria;
import hu.tarnai.minerva.entity.Napimenu;
import hu.tarnai.minerva.enums.NyelvEnum;
import hu.tarnai.minerva.objects.EtlapObject;
import hu.tarnai.minerva.objects.HetimenuObject;
import hu.tarnai.minerva.utility.DateUtility;
import hu.tarnai.minerva.utility.Message;
import hu.tarnai.minerva.utility.Nyelv;
import hu.tarnai.minerva.utility.PageName;

@Controller
public class GuestControllers {
	
	static String VAROSINFO_PAGE_NAME = "varosinfo"
			+ "";
	static String MAIN_PAGE_NAME = "foldal";
	static String SZOLGALTATAS_PAGE_NAME = "szolgaltatas";
	static String ARAK_PAGE_NAME = "arak";
	static String GYIK_PAGE_NAME = "gyik";
	static String KAPCSOLATOK_PAGE_NAME = "kapcsolatok";
	static String AJANLAT_PAGE_NAME = "ajanlat";
	static String GALLERY_PAGE_NAME = "gallery";
	static String ETLAP_PAGE_NAME = "etlap";
	static String HETI_MENU_PAGE_NAME = "hetimenu";
	
	//---------------foldal--------------------//
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String guestMainPage1(Model model, HttpServletRequest request){
		PageName.save(request, MAIN_PAGE_NAME);
		
		FoldalBo bo = new FoldalBo();
		
		model.addAttribute("MainPageObject", bo.foldalGetAllActive(Nyelv.getNyelv(request)));
		model.addAttribute("hetimenu", HetimenuObject.getCurrentDayMenu());
		
		return Nyelv.getRedirectURL(request);
	}

	@RequestMapping(value = "/foldal", method = RequestMethod.GET)
	public String guestMainPage2(Model model, HttpServletRequest request){
		PageName.save(request, MAIN_PAGE_NAME);
		
		FoldalBo bo = new FoldalBo();
		HetimenuBo hBo = new HetimenuBo();
		model.addAttribute("MainPageObject", bo.foldalGetAllActive(Nyelv.getNyelv(request)));
		model.addAttribute("hetimenu", hBo.getCurrentDayMenu());
		
		return Nyelv.getRedirectURL(request);
	}
	
	//---------------szolgáltatás--------------------//
	@RequestMapping(value = "/szolgaltatas", method = RequestMethod.GET)
	public String szolgaltatas(Model model, HttpServletRequest request){
		PageName.save(request, SZOLGALTATAS_PAGE_NAME);
		
		return Nyelv.getRedirectURL(request);
	}
	
	//---------------árak--------------------//
	@RequestMapping(value = "/arak", method = RequestMethod.GET)
	public String arak(Model model, HttpServletRequest request){
		PageName.save(request, ARAK_PAGE_NAME);
		
		return Nyelv.getRedirectURL(request);
	}
	
	//---------------várósinfó--------------------//
	@RequestMapping(value = "/varosinfo", method = RequestMethod.GET)
	public String varosinfo(Model model, HttpServletRequest request){
		PageName.save(request, VAROSINFO_PAGE_NAME);
		
		return Nyelv.getRedirectURL(request);
	}
	
	//---------------gyik--------------------//
	@RequestMapping(value = "/gyik", method = RequestMethod.GET)
	public String gyik(Model model, HttpServletRequest request){
		PageName.save(request, GYIK_PAGE_NAME);
		
		return Nyelv.getRedirectURL(request);
	}
	
	//---------------kapcsolatok--------------------//
	@RequestMapping(value = "/kapcsolatok", method = RequestMethod.GET)
	public String kapcsolatok(Model model, HttpServletRequest request){
		PageName.save(request, KAPCSOLATOK_PAGE_NAME);
		
		return Nyelv.getRedirectURL(request);
	}
	
	//---------------ajánlatok--------------------//
	@RequestMapping(value = "/ajanlat", method = RequestMethod.GET)
	public String ajanlat(Model model, HttpServletRequest request){
		PageName.save(request, AJANLAT_PAGE_NAME);
		
		return Nyelv.getRedirectURL(request);
	}
	
	@RequestMapping(value = "/ajanlat", method = RequestMethod.POST)
	public String ajanlatPost(@RequestParam(value = "nev") String nev, 
			@RequestParam(value = "email") String email,
			@RequestParam(value = "szszam") int szszam,
			@RequestParam(value = "tol") String tol,
			@RequestParam(value = "ig") String ig,
			@RequestParam(value = "szoba") String szoba,
			@RequestParam(value = "reggeli", defaultValue = "false") boolean reggeli,
			@RequestParam(value = "megjegyzes") String megjegyzes,
			Model model, HttpServletRequest request){
		
		PageName.save(request, AJANLAT_PAGE_NAME);
		
		Ajanlat ajanlat = new Ajanlat();
		AjanlatBo bo = new AjanlatBo();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		ajanlat.setNev(nev);
		ajanlat.setSzszam(szszam);
		try {
			ajanlat.setTol(format.parse(tol));
			ajanlat.setIg(format.parse(ig));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try{
			ajanlat.setSzoba(szoba);
		} catch (NumberFormatException e) {
			Message.error(request, "A személyek számához nem számot adott meg!");
		}
			ajanlat.setMegjegyzes(megjegyzes);
		
		if(email!=null && email.contains("@") && email.contains(".")){
			ajanlat.setEmail(email);
			ajanlat.setMobil("xxxx");
		}else{
			ajanlat.setMobil(email);
			ajanlat.setEmail("xxxx");
		}
		
		if(reggeli){
			ajanlat.setReggeli("i");
		}else{
			ajanlat.setReggeli("n");
		}
		
		int res = bo.sendAjanlat(ajanlat);
		if(res > -1){
			Message.success(request, "Ajánlatkérését megkaptuk. Hamarosan jelentkezünk az ön által megadott elérhetőségen. Köszönjük, hogy hozzánkfordúlt.");
		}else if(res == -1){
			Message.error(request, "Az érkezés dátuma hamarabb van mint a mai nap!");
		}else if(res == -2){
			Message.error(request, "A távozás dátuma hamarabb van vagy ugyanarra a napra esik mint az érkezés dátuma!");
		}else{
			Message.error(request, "Ismeretlen Hiba történt küldés közben, kérjük vegye fel a kapcsolatot velünk telefonon vagy e-mail-ben. Megértését köszönjük.");
		}
		
		return Nyelv.getRedirectURL(request);
	}
	
		//---------------galéria--------------------//
		@RequestMapping(value = "/gallery", method = RequestMethod.GET)
		public String gallery(Model model, HttpServletRequest request){
			PageName.save(request, GALLERY_PAGE_NAME);
			GalleryBo bo = new GalleryBo();
			List<Galeria> galeria = bo.getAll();
			
			if(galeria != null){
				model.addAttribute("gallery", galeria);
			}
			
			return Nyelv.getRedirectURL(request);
		}
		
		//---------------étlap--------------------//
		@RequestMapping(value = "/etlap", method = RequestMethod.GET)
		public String etlap(Model model, HttpServletRequest request){
			PageName.save(request, ETLAP_PAGE_NAME);
			
			List<EtlapObject> etlapObject = new ArrayList<EtlapObject>();
			for(EtlapObject o:EtlapObject.get()) {
				if(Nyelv.getNyelv(request) == NyelvEnum.HUN) {
					EtlapObject et = new EtlapObject();
					List<Etlap> etlap = new ArrayList<Etlap>();
					String[] n = o.getNev().split("/");
					
					for(Etlap e:o.getEtelek()) {
						Etlap ee = new Etlap();
						String[] etel = e.getNev().split("/");
						String[] leir = e.getLeiras().split("/");
						
						ee.setNev(etel!=null&&etel.length>0?etel[0]:null);
						ee.setLeiras(leir!=null&&leir.length>0?leir[0]:null);
						ee.setAr(e.getAr());
						ee.setId(e.getId());
						ee.setIs_kep(e.getIs_kep());
						ee.setKategoria(e.getKategoria());
						ee.setKep(e.getKep());
						ee.setStat(e.getStat());
						etlap.add(ee);
					}
					
					et.setNev(n[0]);
					et.setEtelek(etlap);
					et.setId(o.id);
					et.setSorrend(o.getSorrend());
					etlapObject.add(et);
				}else {
					EtlapObject et = new EtlapObject();
					List<Etlap> etlap = new ArrayList<Etlap>();
					String[] n = o.getNev().split("/");
					
					for(Etlap e:o.getEtelek()) {
						Etlap ee = new Etlap();
						String[] etel = e.getNev().split("/");
						String[] leir = e.getLeiras().split("/");
						
						ee.setNev(etel!=null&&etel.length>1?etel[1]:(etel!=null&&etel.length>0?etel[0]:null));
						ee.setLeiras(leir!=null&&leir.length>1?leir[1]:(leir!=null&&leir.length>0?leir[0]:null));
						ee.setAr(e.getAr());
						ee.setId(e.getId());
						ee.setIs_kep(e.getIs_kep());
						ee.setKategoria(e.getKategoria());
						ee.setKep(e.getKep());
						ee.setStat(e.getStat());
						etlap.add(ee);
					}
					
					et.setNev(n!=null&&n.length>1?n[1]:(n!=null&&n.length>0?n[0]:null));
					et.setEtelek(etlap);
					et.setId(o.id);
					et.setSorrend(o.getSorrend());
					etlapObject.add(et);
				}
			}
			
			model.addAttribute("etlapObject", etlapObject);
			
			return Nyelv.getRedirectURL(request);
		}
		
		//---------------heti menü--------------------//
		@RequestMapping(value = "/hetimenu", method = RequestMethod.GET)
		public String hetiMenu(Model model, HttpServletRequest request){
			PageName.save(request, HETI_MENU_PAGE_NAME);
			List<HetimenuObject> heti = new ArrayList<HetimenuObject>();
			for( HetimenuObject o:HetimenuObject.get()) {
				if(Nyelv.getNyelv(request) == NyelvEnum.HUN) {
					HetimenuObject ho = new HetimenuObject();
					Napimenu nm = new Napimenu();
					
					String[] leves =  o.getNapimenu().getLeves().split("/");
					String[] fo =  o.getNapimenu().getFoetel().split("/");
					String[] koret =  o.getNapimenu().getKoret().split("/");
					
					nm.setLeves(leves!=null&&leves.length>0?leves[0]:null);
					nm.setFoetel(fo!=null&&fo.length>0?fo[0]:null);
					nm.setKoret(koret!=null&&koret.length>0?koret[0]:null);
					ho.setNapimenu(nm);
					ho.setDate(o.getDate());
					ho.setDayName(o.getDayName());
					
					heti.add(ho);
				}else {
					HetimenuObject ho = new HetimenuObject();
					Napimenu nm = new Napimenu();
					
					String[] leves =  o.getNapimenu().getLeves().split("/");
					String[] fo =  o.getNapimenu().getFoetel().split("/");
					String[] koret =  o.getNapimenu().getKoret().split("/");
					
					nm.setLeves(leves!=null&&leves.length>1?leves[1]:(leves!=null&&leves.length>0?leves[0]:null));
					nm.setFoetel(fo!=null&&fo.length>1?fo[1]:(fo!=null&&fo.length>0?fo[0]:null));
					nm.setKoret(koret!=null&&koret.length>1?koret[1]:(koret!=null&&koret.length>0?koret[0]:null));
					ho.setNapimenu(nm);
					ho.setDate(o.getDate());
					ho.setDayName(DateUtility.convertHungariDayToEnglish(o.getDayName()));
					
					heti.add(ho);
				}
			}
			
			model.addAttribute("hetiMenuObj", heti);
			
			return Nyelv.getRedirectURL(request);
		}
		
		//---------------kép lekérése--------------------//
		@RequestMapping(value = "/getImage", method = RequestMethod.GET)
		public void getImage(@RequestParam(value = "fileId") int fileId, @RequestParam(value = "who") String who,Model model, HttpServletRequest request, HttpServletResponse response){
			GetImagesBo bo = new GetImagesBo();
			bo.getImage(fileId, who, response);
		}
}
