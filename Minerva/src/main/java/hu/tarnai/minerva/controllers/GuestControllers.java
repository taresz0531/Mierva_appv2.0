package hu.tarnai.minerva.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import hu.tarnai.minerva.entity.Galeria;
import hu.tarnai.minerva.objects.EtlapObject;
import hu.tarnai.minerva.objects.HetimenuObject;
import hu.tarnai.minerva.utility.Message;
import hu.tarnai.minerva.utility.Nyelv;
import hu.tarnai.minerva.utility.PageName;

@Controller
public class GuestControllers {
	
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
			
			List<EtlapObject> etlapObject = EtlapObject.get();
			
			model.addAttribute("etlapObject", etlapObject);
			
			return Nyelv.getRedirectURL(request);
		}
		
		//---------------heti menü--------------------//
		@RequestMapping(value = "/hetimenu", method = RequestMethod.GET)
		public String hetiMenu(Model model, HttpServletRequest request){
			PageName.save(request, HETI_MENU_PAGE_NAME);
			
			model.addAttribute("hetiMenuObj", HetimenuObject.get());
			
			return Nyelv.getRedirectURL(request);
		}
		
		//---------------kép lekérése--------------------//
		@RequestMapping(value = "/getImage", method = RequestMethod.GET)
		public void getImage(@RequestParam(value = "fileId") int fileId, @RequestParam(value = "who") String who,Model model, HttpServletRequest request, HttpServletResponse response){
			GetImagesBo bo = new GetImagesBo();
			bo.getImage(fileId, who, response);
		}
}
