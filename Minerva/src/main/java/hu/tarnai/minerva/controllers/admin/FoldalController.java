package hu.tarnai.minerva.controllers.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hu.tarnai.minerva.bo.FoldalBo;
import hu.tarnai.minerva.entity.Foldal;
import hu.tarnai.minerva.enums.ErrorCodeEnum;
import hu.tarnai.minerva.objects.UserMenusObject;
import hu.tarnai.minerva.utility.AdminSettings;
import hu.tarnai.minerva.utility.Message;
import hu.tarnai.minerva.utility.PageName;
import hu.tarnai.minerva.utility.ResultSession;
import hu.tarnai.minerva.utility.UserSession;

@Controller
public class FoldalController {

	static String FOLDAL_UJ_URL = "foldalUj";
	static String FOLDAL_MODOSIT_URL = "foldalModosit";
	
	//---------------új bejegyzés----------------------
	@RequestMapping(value = "/foldalUj", method = RequestMethod.GET)
	public String foldalUjGet(Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, FOLDAL_UJ_URL);
		
		return UserSession.checkUser(request, FOLDAL_UJ_URL, model);
	}
	
	@RequestMapping(value = "/foldalUj", method = RequestMethod.POST)
	public String foldalUjPost(@ModelAttribute("foldal") Foldal foldal, @RequestParam(name = "autoO") Optional<String> autoO,Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, FOLDAL_UJ_URL);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Foldal result = new Foldal();
		
		if(foldal.getDate() == null || foldal.getDate().equals("")){
			foldal.setDate(format.format(Calendar.getInstance().getTime()));
		}
		
		if(foldal.getDateTo() == null || foldal.getDateTo().equals("")){
			foldal.setDateTo("0");
		}
		try {
			if(autoO!=null&&autoO.get().equals("on")){
				foldal.setAutoOpen(1);
			}else{
				foldal.setAutoOpen(0);
			}
			
		} catch (Exception e) {
			foldal.setAutoOpen(0);
		}
		
		result = foldal;
		
		FoldalBo bo = new FoldalBo();
		ErrorCodeEnum errorCode = bo.foldalAdd(foldal);
		
		if(errorCode == ErrorCodeEnum.SUCCESS){
			Message.success(request, "Sikeres feltöltés!");
		}else if(errorCode == ErrorCodeEnum.NAME_NOT_VALID_ERROR){
			Message.errorNameValid(request);
			ResultSession.set(request, result);
		}else{
			Message.error(request, "Ismeretlen hiba!");
			ResultSession.set(request, result);
		}

		
		return UserSession.checkUser(request, FOLDAL_UJ_URL,model);
	}
	
	//------------------------bejegyzés módosít------------------------
	@RequestMapping(value = "/foldalModosit", method = RequestMethod.GET)
	public String foldalModifGet(Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, FOLDAL_MODOSIT_URL);
		
		FoldalBo bo = new FoldalBo();

		model.addAttribute("foldalList", bo.foldalGetAll());
		
		return UserSession.checkUser(request, FOLDAL_MODOSIT_URL, model);
	}
	
	@RequestMapping(value = "/foldalModosit", method = RequestMethod.POST)
	public String foldalModifPOST(@ModelAttribute("foldal") Foldal foldal, @RequestParam(name = "autoO") Optional<String> autoO, @RequestParam(name = "originalCim") String originalCim,Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, FOLDAL_MODOSIT_URL);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		boolean isOriginalCim = true;
		
		if(foldal.getDate() == null || foldal.getDate().equals("")){
			foldal.setDate(format.format(Calendar.getInstance().getTime()));
		}
		
		if(foldal.getDateTo() == null || foldal.getDateTo().equals("")){
			foldal.setDateTo("0");
		}
		try {
			if(autoO!=null&&(autoO.get().equals("on")||autoO.get().equals("0"))){
				foldal.setAutoOpen(1);
			}else{
				foldal.setAutoOpen(0);
			}
			
		} catch (Exception e) {
			foldal.setAutoOpen(0);
		}
		
		if(!originalCim.equals(foldal.getCim())) {
			isOriginalCim = true;
		}
		
		String leiras = foldal.getLeiras();

		leiras = leiras.substring(18, leiras.length()-6);
		
		foldal.setLeiras(leiras);
		
		FoldalBo bo = new FoldalBo();
		ErrorCodeEnum errorCode = bo.foldalModif(foldal,isOriginalCim);
		
		if(errorCode == ErrorCodeEnum.SUCCESS){
			Message.success(request, "Sikeres módosítás!");
		}else if(errorCode == ErrorCodeEnum.NAME_NOT_VALID_ERROR){
			Message.errorNameValid(request);
		}else{
			Message.error(request);
		}

		model.addAttribute("foldalList", bo.foldalGetAll());
		
		return UserSession.checkUser(request, FOLDAL_MODOSIT_URL, model);
	}
	
	//------------------------bejegyzés stat csere------------------------
	@RequestMapping(value = "/foldalChangeStat", method = RequestMethod.POST)
	public String foldalChangeStatPost(@RequestParam(name = "id") int id,@RequestParam(name = "stat") String stat,Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, FOLDAL_MODOSIT_URL);
		
		FoldalBo bo = new FoldalBo();
		
		if(bo.foldalChangeStat(id)==ErrorCodeEnum.SUCCESS){
			if(stat.equals("A")){
				Message.success(request, "A bejegyzés inaktiválva lett!");
			}else{
				Message.success(request, "A bejegyzés aktiválva lett!");
			}
		}else{
			Message.error(request);
		}
		model.addAttribute("foldalList", bo.foldalGetAll());
		return UserSession.checkUser(request, FOLDAL_MODOSIT_URL, model);
	}
	
	//------------------------bejegyzés töröl------------------------
	@RequestMapping(value = "/foldalDelet", method = RequestMethod.POST)
	public String foldalDeletPost(@RequestParam(name = "id") int id,Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, FOLDAL_MODOSIT_URL);
		
		FoldalBo bo = new FoldalBo();
		
		if(bo.foldalDelet(id)==ErrorCodeEnum.SUCCESS){
			Message.success(request, "A bejegyzés törölve lett!");
		}
		
		model.addAttribute("foldalList", bo.foldalGetAll());
		return UserSession.checkUser(request, FOLDAL_MODOSIT_URL, model);
	}
	
}
