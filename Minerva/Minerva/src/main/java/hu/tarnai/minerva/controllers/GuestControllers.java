package hu.tarnai.minerva.controllers;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hu.tarnai.minerva.bo.AjanlatBo;
import hu.tarnai.minerva.bo.FoldalBo;
import hu.tarnai.minerva.bo.GalleryBo;
import hu.tarnai.minerva.bo.GetImagesBo;
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
	
	static String VAROSINFO_PAGE_NAME = "varosinfo";
	static String MAIN_PAGE_NAME = "foldal";
	static String SZOLGALTATAS_PAGE_NAME = "szolgaltatas";
	static String ARAK_PAGE_NAME = "arak";
	static String GYIK_PAGE_NAME = "gyik";
	static String KAPCSOLATOK_PAGE_NAME = "kapcsolatok";
	static String AJANLAT_PAGE_NAME = "ajanlat";
	static String GALLERY_PAGE_NAME = "gallery";
	static String ETLAP_PAGE_NAME = "etlap";
	static String HETI_MENU_PAGE_NAME = "hetimenu";
	static String HAZIREND_PAGE_NAME = "hazirend";
	
	//---------------foldal--------------------//
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String guestMainPage1(Model model, HttpServletRequest request, HttpServletResponse response){
		PageName.save(request, MAIN_PAGE_NAME);
		
		FoldalBo bo = new FoldalBo();
		HetimenuObject hobj = HetimenuObject.getCurrentDayMenu();
		HetimenuObject tobj = new HetimenuObject();
		
		if(hobj != null) {
			String[] leves = hobj.getNapimenu().getLeves().split("/");
			String[] foetel = hobj.getNapimenu().getFoetel().split("/");
			String[] koret = hobj.getNapimenu().getKoret().split("/");
			
			if(Nyelv.getNyelv(request) == NyelvEnum.HUN) {
				Napimenu nm = new Napimenu();
				if(leves!=null && leves.length>0) {
					nm.setLeves(leves[0]);
				}
				
				if(foetel!=null && foetel.length>0) {
					nm.setFoetel(foetel[0]);
				}
				
				if(koret!=null && koret.length>0) {
					nm.setKoret(koret[0]);
				}
				tobj.setNapimenu(nm);
				tobj.setDate(hobj.getDate());
				tobj.setDayName(hobj.getDayName());
			}else {
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
				Napimenu nm = new Napimenu();
				String date;
				String dayName;
				
				try {
					date = format.format(format2.parse(hobj.getDate()));
					dayName = DateUtility.convertHungariDayToEnglish(hobj.getDayName());
				} catch (ParseException e) {
					date = hobj.getDate();
					dayName = hobj.getDayName();
					e.printStackTrace();
				}
				
				if(leves!=null && leves.length>1) {
					nm.setLeves(leves[1]);
				}else {
					if(leves!=null && leves.length>0) {
						nm.setLeves(leves[0]);
					}
				}
				
				if(foetel!=null && foetel.length>1) {
					nm.setFoetel(foetel[1]);
				}else {
					if(foetel!=null && foetel.length>0) {
						nm.setFoetel(foetel[0]);
					}
				}
				
				if(koret!=null && koret.length>1) {
					nm.setKoret(koret[1]);
				}else {
					if(koret!=null && koret.length>0) {
						nm.setKoret(koret[0]);
					}
				}
				
				tobj.setNapimenu(nm);
				tobj.setDate(date);
				tobj.setDayName(dayName);
			}
		}else {
			tobj = null;
		}
		
		
		model.addAttribute("MainPageObject", bo.foldalGetAllActive(Nyelv.getNyelv(request)));
		model.addAttribute("hetimenu", tobj);
		
		return Nyelv.getRedirectURL(request, response);
	}

	@RequestMapping(value = "/foldal", method = RequestMethod.GET)
	public String guestMainPage2(Model model, HttpServletRequest request, HttpServletResponse response){
		PageName.save(request, MAIN_PAGE_NAME);
		
		FoldalBo bo = new FoldalBo();
		HetimenuObject hobj = HetimenuObject.getCurrentDayMenu();
		HetimenuObject tobj = new HetimenuObject();
		
		if(hobj != null) {
			String[] leves = hobj.getNapimenu().getLeves().split("/");
			String[] foetel = hobj.getNapimenu().getFoetel().split("/");
			String[] koret = hobj.getNapimenu().getKoret().split("/");
			
			if(Nyelv.getNyelv(request) == NyelvEnum.HUN) {
				Napimenu nm = new Napimenu();
				if(leves!=null && leves.length>0) {
					nm.setLeves(leves[0]);
				}
				
				if(foetel!=null && foetel.length>0) {
					nm.setFoetel(foetel[0]);
				}
				
				if(koret!=null && koret.length>0) {
					nm.setKoret(koret[0]);
				}
				tobj.setNapimenu(nm);
				tobj.setDate(hobj.getDate());
				tobj.setDayName(hobj.getDayName());
			}else {
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
				Napimenu nm = new Napimenu();
				String date;
				String dayName;
				
				try {
					date = format.format(format2.parse(hobj.getDate()));
					dayName = DateUtility.convertHungariDayToEnglish(hobj.getDayName());
				} catch (ParseException e) {
					date = hobj.getDate();
					dayName = hobj.getDayName();
					e.printStackTrace();
				}
				
				if(leves!=null && leves.length>1) {
					nm.setLeves(leves[1]);
				}else {
					if(leves!=null && leves.length>0) {
						nm.setLeves(leves[0]);
					}
				}
				
				if(foetel!=null && foetel.length>1) {
					nm.setFoetel(foetel[1]);
				}else {
					if(foetel!=null && foetel.length>0) {
						nm.setFoetel(foetel[0]);
					}
				}
				
				if(koret!=null && koret.length>1) {
					nm.setKoret(koret[1]);
				}else {
					if(koret!=null && koret.length>0) {
						nm.setKoret(koret[0]);
					}
				}
				
				tobj.setNapimenu(nm);
				tobj.setDate(date);
				tobj.setDayName(dayName);
			}
		}else {
			tobj = null;
		}
		
		
		model.addAttribute("MainPageObject", bo.foldalGetAllActive(Nyelv.getNyelv(request)));
		model.addAttribute("hetimenu", tobj);
		
		return Nyelv.getRedirectURL(request, response);
	}
	
	//---------------szolgáltatás--------------------//
	@RequestMapping(value = "/szolgaltatas", method = RequestMethod.GET)
	public String szolgaltatas(Model model, HttpServletRequest request, HttpServletResponse response){
		PageName.save(request, SZOLGALTATAS_PAGE_NAME);
		
		return Nyelv.getRedirectURL(request, response);
	}
	
	//---------------árak--------------------//
	@RequestMapping(value = "/arak", method = RequestMethod.GET)
	public String arak(Model model, HttpServletRequest request, HttpServletResponse response){
		PageName.save(request, ARAK_PAGE_NAME);
		
		return Nyelv.getRedirectURL(request, response);
	}
	
	//---------------várósinfó--------------------//
	@RequestMapping(value = "/varosinfo", method = RequestMethod.GET)
	public String varosinfo(Model model, HttpServletRequest request, HttpServletResponse response){
		PageName.save(request, VAROSINFO_PAGE_NAME);
		
		return Nyelv.getRedirectURL(request, response);
	}
	
	//---------------házirend--------------------//
	@RequestMapping(value = "/hazirend", method = RequestMethod.GET)
	public String hazi(Model model, HttpServletRequest request, HttpServletResponse response){
		PageName.save(request, HAZIREND_PAGE_NAME);
		
		return Nyelv.getRedirectURL(request, response);
	}
	
	//---------------gyik--------------------//
	@RequestMapping(value = "/gyik", method = RequestMethod.GET)
	public String gyik(Model model, HttpServletRequest request, HttpServletResponse response){
		PageName.save(request, GYIK_PAGE_NAME);
		
		return Nyelv.getRedirectURL(request, response);
	}
	
	//---------------kapcsolatok--------------------//
	@RequestMapping(value = "/kapcsolatok", method = RequestMethod.GET)
	public String kapcsolatok(Model model, HttpServletRequest request, HttpServletResponse response){
		PageName.save(request, KAPCSOLATOK_PAGE_NAME);
		
		return Nyelv.getRedirectURL(request, response);
	}
	
	//---------------ajánlatok--------------------//
	@RequestMapping(value = "/ajanlat", method = RequestMethod.GET)
	public String ajanlat(Model model, HttpServletRequest request, HttpServletResponse response){
		PageName.save(request, AJANLAT_PAGE_NAME);
		model.addAttribute("ajanlat", new Ajanlat());
		return Nyelv.getRedirectURL(request, response);
	}
	
	@RequestMapping(value = "/ajanlat", method = RequestMethod.POST)
	public String ajanlatPost(@RequestParam(value = "nev") String nev, 
			@RequestParam(value = "email") String email,
			@RequestParam(value = "szszam") int szszam,
			@RequestParam(value = "tol") String tol,
			@RequestParam(value = "ig") String ig,
			@RequestParam(value = "szoba") String szoba,
			@RequestParam(value = "reggeli", defaultValue = "false") boolean reggeli,
			@RequestParam(value = "adat", defaultValue = "false") boolean adat,
			@RequestParam(value = "megjegyzes") String megjegyzes,
			Model model, HttpServletRequest request, HttpServletResponse response){
		
		PageName.save(request, AJANLAT_PAGE_NAME);
		
		Ajanlat ajanlat = new Ajanlat();
		AjanlatBo bo = new AjanlatBo();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		boolean isSave = true;
		int res = -6;
		String recaptcha = request.getParameter("g-recaptcha-response");
		
		if(recaptcha==null||recaptcha.length()<=1) {
			isSave = false;
			res = -5;
		}
		
		ajanlat.setNev(nev);
		ajanlat.setSzoba(szoba);
		try {
			ajanlat.setTol(format.parse(tol));
			ajanlat.setIg(format.parse(ig));
		} catch (ParseException e) {
			e.printStackTrace();
			
		}
		try{
			ajanlat.setSzszam(szszam);
		} catch (NumberFormatException e) {
			isSave = false;
			res = -3;
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
		
		if(!adat){
			isSave = false;
			res = -4;
		}
		
		if(isSave) {
			res = bo.sendAjanlat(ajanlat);
		}
		if(res > -1){
			Message.success(request, Nyelv.getKey(request, "message_ajanlatsuccess"));
		}else if(res == -1){
			Message.error(request, Nyelv.getKey(request, "message_date"));
			model.addAttribute("ajanlat", ajanlat);
		}else if(res == -2){
			Message.error(request, Nyelv.getKey(request, "message_date2"));
			model.addAttribute("ajanlat", ajanlat);
		}else if(res == -3){
			Message.error(request, Nyelv.getKey(request, "message_nemszam"));
			model.addAttribute("ajanlat", ajanlat);
		}else if(res == -4){
			Message.error(request, Nyelv.getKey(request, "message_adatvedelmi"));
			model.addAttribute("ajanlat", ajanlat);
		}else if(res == -5){
			Message.error(request, Nyelv.getKey(request, "message_robot"));
			model.addAttribute("ajanlat", ajanlat);
		}else{
			Message.error(request, Nyelv.getKey(request, "message_unknowerror"));
			model.addAttribute("ajanlat", ajanlat);
		}
		
		return Nyelv.getRedirectURL(request, response);
	}
	
	//---------------galéria--------------------//
	@RequestMapping(value = "/gallery", method = RequestMethod.GET)
	public String gallery(Model model, HttpServletRequest request, HttpServletResponse response){
		PageName.save(request, GALLERY_PAGE_NAME);
		GalleryBo bo = new GalleryBo();
		List<Galeria> galeria = bo.getAll();
		
		if(galeria != null){
			model.addAttribute("gallery", galeria);
		}
		
		return Nyelv.getRedirectURL(request, response);
	}
	
	//---------------étlap--------------------//
	@RequestMapping(value = "/etlap", method = RequestMethod.GET)
	public String etlap(Model model, HttpServletRequest request, HttpServletResponse response){
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
		
		return Nyelv.getRedirectURL(request, response);
	}
	
	//---------------heti menü--------------------//
	@RequestMapping(value = "/hetimenu", method = RequestMethod.GET)
	public String hetiMenu(Model model, HttpServletRequest request, HttpServletResponse response){
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
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
				HetimenuObject ho = new HetimenuObject();
				Napimenu nm = new Napimenu();
				
				String[] leves =  o.getNapimenu().getLeves().split("/");
				String[] fo =  o.getNapimenu().getFoetel().split("/");
				String[] koret =  o.getNapimenu().getKoret().split("/");
				
				nm.setLeves(leves!=null&&leves.length>1?leves[1]:(leves!=null&&leves.length>0?leves[0]:null));
				nm.setFoetel(fo!=null&&fo.length>1?fo[1]:(fo!=null&&fo.length>0?fo[0]:null));
				nm.setKoret(koret!=null&&koret.length>1?koret[1]:(koret!=null&&koret.length>0?koret[0]:null));
				ho.setNapimenu(nm);
				try {
					ho.setDate(format.format(format2.parse(o.getDate())));
				} catch (ParseException e) {
					ho.setDate(o.getDate());
					e.printStackTrace();
				}
				ho.setDayName(DateUtility.convertHungariDayToEnglish(o.getDayName()));
				
				heti.add(ho);
			}
		}
		
		model.addAttribute("hetiMenuObj", heti);
		
		return Nyelv.getRedirectURL(request, response);
	}
	
	//---------------kép lekérése--------------------//
	@RequestMapping(value = "/getImage", method = RequestMethod.GET)
	public void getImage(@RequestParam(value = "fileId") int fileId, @RequestParam(value = "who") String who,Model model, HttpServletRequest request, HttpServletResponse response){
		GetImagesBo bo = new GetImagesBo();
		bo.getImage(fileId, who, response);
	}
	
	public boolean isCaptchaValid(String secretKey, String response) {
	    try {
	        String url = "https://www.google.com/recaptcha/api/siteverify?"
	                + "secret=" + secretKey
	                + "&response=" + response;
	        InputStream res = new URL(url).openStream();
	        BufferedReader rd = new BufferedReader(new InputStreamReader(res, Charset.forName("UTF-8")));

	        StringBuilder sb = new StringBuilder();
	        int cp;
	        while ((cp = rd.read()) != -1) {
	            sb.append((char) cp);
	        }
	        String jsonText = sb.toString();
	        res.close();

	        JSONObject json = new JSONObject(jsonText);
	        return json.getBoolean("success");
	    } catch (Exception e) {
	        return false;
	    }
	}
}
