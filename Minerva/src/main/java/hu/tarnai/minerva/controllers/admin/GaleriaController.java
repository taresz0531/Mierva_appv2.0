package hu.tarnai.minerva.controllers.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hu.tarnai.minerva.bo.EtlapBo;
import hu.tarnai.minerva.bo.EtlapKategoriaBo;
import hu.tarnai.minerva.bo.GalleryBo;
import hu.tarnai.minerva.entity.Etlap;
import hu.tarnai.minerva.entity.Galeria;
import hu.tarnai.minerva.enums.ErrorCodeEnum;
import hu.tarnai.minerva.utility.ImageUpload;
import hu.tarnai.minerva.utility.Message;
import hu.tarnai.minerva.utility.PageName;
import hu.tarnai.minerva.utility.ResultSession;
import hu.tarnai.minerva.utility.UserSession;

@Controller
public class GaleriaController {

	private static String GALERIA_UJ_URL = "galeriaUj";
	private static String GALERIA_TOROL_URL = "galeriaTorol";
	
	//---------------új kép feltöltés----------------------
	@RequestMapping(value = "/galeriaUj", method = RequestMethod.GET)
	public String galeriaUjGet(Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, GALERIA_UJ_URL);
		
		return UserSession.checkUser(request, GALERIA_UJ_URL, model);
	}
	
	//---------------új kép feltöltése----------------------
	@RequestMapping(value = "/galeriaUj", method = RequestMethod.POST)
	public String galeriaUjPost(@RequestParam(name = "leiras") String leiras, Model model, HttpServletRequest request, RedirectAttributes redirect,MultipartHttpServletRequest requestPicture){
		PageName.saveAdmin(request, GALERIA_UJ_URL);
		
		GalleryBo bo = new GalleryBo();
		Galeria galeria = new Galeria();
		byte[] kep = ImageUpload.getImage(requestPicture);
		
		galeria.setNev(ImageUpload.GetFileName(requestPicture));
		galeria.setLeiras(leiras);
		galeria.setKep(kep);
		
		ErrorCodeEnum error = bo.add(galeria);
		if(error == ErrorCodeEnum.SUCCESS){
			Message.success(request);
		}else if(error == ErrorCodeEnum.NAME_NOT_VALID_ERROR){
			Message.errorNameValid(request);
			ResultSession.set(request, galeria);
		}else if(error == ErrorCodeEnum.ERROR){
			Message.error(request);
			ResultSession.set(request, galeria);
		}else{
			Message.errorDb(request);
			ResultSession.set(request, galeria);
		}
		
		return UserSession.checkUser(request, GALERIA_UJ_URL, model);
	}
	
	//---------------kép töröl----------------------
	@RequestMapping(value = "/galeriaTorol", method = RequestMethod.GET)
	public String galeriaTorolGet(Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, GALERIA_TOROL_URL);
		
		GalleryBo bo = new GalleryBo();
		
		model.addAttribute("galeria", bo.getAll());
		
		return UserSession.checkUser(request, GALERIA_TOROL_URL, model);
	}
	
	//---------------kép töröl----------------------
	@RequestMapping(value = "/galeriaTorol", method = RequestMethod.POST)
	public String galeriaTorolPost(@RequestParam(name = "id") int id, Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, GALERIA_TOROL_URL);
		
		GalleryBo bo = new GalleryBo();
		
		ErrorCodeEnum error = bo.delet(id);
		
		if(error == ErrorCodeEnum.SUCCESS){
			Message.success(request);
		}else if(error == ErrorCodeEnum.ERROR){
			Message.error(request);
		}else{
			Message.errorDb(request);
		}
		
		model.addAttribute("galeria", bo.getAll());
		
		return UserSession.checkUser(request, GALERIA_TOROL_URL, model);
	}
}
