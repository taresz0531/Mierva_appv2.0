package hu.tarnai.minerva.controllers.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hu.tarnai.minerva.bo.AjanlatBo;
import hu.tarnai.minerva.enums.ErrorCodeEnum;
import hu.tarnai.minerva.utility.EmailSend;
import hu.tarnai.minerva.utility.Message;
import hu.tarnai.minerva.utility.PageName;
import hu.tarnai.minerva.utility.StringValidator;
import hu.tarnai.minerva.utility.UserSession;

@Controller
public class AjanlatController {
	
	private static String AJANLAT_UJ_URL = "ajanlatOlvas";
	private static String AJANLAT_OLVASOTT_URL = "ajanlatOlvasott";

	//---------------Bejövő ajánlatok----------------------
	@RequestMapping(value = "/ajanlatOlvas", method = RequestMethod.GET)
	public String ajanlatOlvasGet(Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, AJANLAT_UJ_URL);
		
		AjanlatBo bo = new AjanlatBo();
		
		model.addAttribute("ajanlatok", bo.getActiveBejegyzes());
		return UserSession.checkUser(request, AJANLAT_UJ_URL, model);
	}
	
	//---------------Válasz---------------------
	@RequestMapping(value = "/valasz", method = RequestMethod.POST)
	public String valaszPost(@RequestParam(name = "id") int id,
							 @RequestParam(name = "leiras") String leiras,
							 @RequestParam(name = "emailCim") String emailCim,
							 @RequestParam(name = "autodelet",defaultValue = "false") boolean autodelet,
							 Model model, HttpServletRequest request, RedirectAttributes redirect){
		
		PageName.saveAdmin(request, AJANLAT_UJ_URL);
		AjanlatBo bo = new AjanlatBo();
		
		if(StringValidator.isEmpty(leiras)){
			Message.error(request, "Kérem írjon valamit az email elküldéséhez!");
			model.addAttribute("ajanlatok", bo.getActiveBejegyzes());
			return UserSession.checkUser(request, AJANLAT_UJ_URL, model);
		}
		
		String[] to = {emailCim}; 
		ErrorCodeEnum error = EmailSend.sendMail(to, "Ajánlat a Minerva Panziótól", leiras);
		
		if(error == ErrorCodeEnum.SUCCESS){
			ErrorCodeEnum errorDb = bo.ajanlatSetRead(id, leiras, autodelet?1:0);
			if(errorDb != ErrorCodeEnum.SUCCESS){
				Message.error(request, "Az email el lett küldve, de a mentés nem sikerült!");
			}else{
				Message.success(request, "Az email sikeresen ell lett küldve!");
			}
		}else{
			Message.error(request, "Az email nem lett elküldve!");
		}
		
		model.addAttribute("ajanlatok", bo.getActiveBejegyzes());
		return UserSession.checkUser(request, AJANLAT_UJ_URL, model);
	}
	
	//---------------Válasz olvasott---------------------
	@RequestMapping(value = "/valaszOlvasott", method = RequestMethod.POST)
	public String valaszOlvasottPost(@RequestParam(name = "id") int id,
							 @RequestParam(name = "leiras") String leiras,
							 @RequestParam(name = "emailCim") String emailCim,
							 Model model, HttpServletRequest request, RedirectAttributes redirect){
		
		PageName.saveAdmin(request, AJANLAT_OLVASOTT_URL);
		AjanlatBo bo = new AjanlatBo();
		
		if(StringValidator.isEmpty(leiras)){
			Message.error(request, "Kérem írjon valamit az email elküldéséhez!");
			model.addAttribute("old",bo.getRegeiBejegyzes());
			model.addAttribute("read", bo.getReadBejegyzes());
			return UserSession.checkUser(request, AJANLAT_UJ_URL, model);
		}
		
		String[] to = {emailCim}; 
		ErrorCodeEnum error = EmailSend.sendMail(to, "Minerva Panzió", leiras);
		
		if(error == ErrorCodeEnum.SUCCESS){
			ErrorCodeEnum errorDb = bo.ajanlatSetRead(id, leiras, -1);
			if(errorDb != ErrorCodeEnum.SUCCESS){
				Message.error(request, "Az email el lett küldve, de a mentés nem sikerült!");
			}else{
				Message.success(request, "Az email sikeresen ell lett küldve!");
			}
		}else{
			Message.error(request, "Az email nem lett elküldve!");
		}
		
		model.addAttribute("old",bo.getRegeiBejegyzes());
		model.addAttribute("read", bo.getReadBejegyzes());
		return UserSession.checkUser(request, AJANLAT_OLVASOTT_URL, model);
	}
		
	//---------------Olvasva----------------------
	@RequestMapping(value = "/olvasva", method = RequestMethod.POST)
	public String olvasvaPost(@RequestParam(name = "id") int id, @RequestParam(name = "autodelet", defaultValue = "false") boolean autodelet, Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, AJANLAT_UJ_URL);
		
		AjanlatBo bo = new AjanlatBo();
		
		ErrorCodeEnum error= bo.ajanlatSetRead(id, "Telefonon felhívva!", autodelet?1:0);
		
		if(error == ErrorCodeEnum.SUCCESS){
			Message.success(request);
		}else{
			Message.error(request);
		}
		
		model.addAttribute("ajanlatok", bo.getActiveBejegyzes());
		return UserSession.checkUser(request, AJANLAT_UJ_URL, model);
	}
	
	//---------------Olasott ajánlatok----------------------
	@RequestMapping(value = "/ajanlatOlvasott", method = RequestMethod.GET)
	public String ajanlatOlvasottGet(Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, AJANLAT_OLVASOTT_URL);
		
		AjanlatBo bo = new AjanlatBo();
		
		model.addAttribute("old",bo.getRegeiBejegyzes());
		model.addAttribute("read", bo.getReadBejegyzes());
		
		return UserSession.checkUser(request, AJANLAT_OLVASOTT_URL, model);
	}
	
	//---------------Olasott törlése----------------------
	@RequestMapping(value = "/ajanlatDelet", method = RequestMethod.POST)
	public String ajanlatDeletPost(@RequestParam(name = "id") int id, Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, AJANLAT_OLVASOTT_URL);
		
		AjanlatBo bo = new AjanlatBo();
		
		ErrorCodeEnum error = bo.delet(id);
		
		if(error == ErrorCodeEnum.SUCCESS){
			Message.success(request);
		}else if(error == ErrorCodeEnum.ERROR){
			Message.error(request);
		}else{
			Message.errorDb(request);
		}
		
		model.addAttribute("old",bo.getRegeiBejegyzes());
		model.addAttribute("read", bo.getReadBejegyzes());
		
		return UserSession.checkUser(request, AJANLAT_OLVASOTT_URL, model);
	}
	
	//---------------Olasott törlése----------------------
	@RequestMapping(value = "/ajanlatAutoDelet", method = RequestMethod.POST)
	public String ajanlatAutoDeletPost(@RequestParam(name = "id") int id, Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, AJANLAT_OLVASOTT_URL);
		
		AjanlatBo bo = new AjanlatBo();
		
		ErrorCodeEnum error = bo.changeAutodelet(id);
		
		if(error == ErrorCodeEnum.SUCCESS){
			Message.success(request);
		}else if(error == ErrorCodeEnum.ERROR){
			Message.error(request);
		}else{
			Message.errorDb(request);
		}
		
		model.addAttribute("old",bo.getRegeiBejegyzes());
		model.addAttribute("read", bo.getReadBejegyzes());
		
		return UserSession.checkUser(request, AJANLAT_OLVASOTT_URL, model);
	}
}
