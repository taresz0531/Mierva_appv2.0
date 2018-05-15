package hu.tarnai.minerva.controllers.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hu.tarnai.minerva.bo.UserBo;
import hu.tarnai.minerva.entity.Users;
import hu.tarnai.minerva.enums.ErrorCodeEnum;
import hu.tarnai.minerva.objects.UserMenusObject;
import hu.tarnai.minerva.utility.EmailSend;
import hu.tarnai.minerva.utility.Message;
import hu.tarnai.minerva.utility.PageName;
import hu.tarnai.minerva.utility.StringValidator;
import hu.tarnai.minerva.utility.UserSession;

@Controller
public class UserController {
	private static String FELHASZNALO_UJ_URL = "userUj";
	private static String FELHASZNALO_ACTIVAL_URL = "activalForm";
	private static String FELHASZNALO_MENU_MODIF_URL = "userMenuModif";
	private static String FELHASZNALO_DELET_URL = "userDelet";
	private static String FELHASZNALO_DATA_MODIF_URL = "userModif";
	
	//---------------Új felhasználó----------------------
	@RequestMapping(value = "/userUj", method = RequestMethod.GET)
	public String userUjGet(Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, FELHASZNALO_UJ_URL);
		
		model.addAttribute("newUserMenus", UserMenusObject.getAll(request));
		return UserSession.checkUser(request, FELHASZNALO_UJ_URL, model);
	}
	
	//---------------Új felhasználó----------------------
	@RequestMapping(value = "/userUj", method = RequestMethod.POST)
	public String userUjPost(@RequestParam(name = "nev") String nev,
							 @RequestParam(name = "email") String email,
							 @RequestParam(name = "menus") List<String> menus,
							 Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, FELHASZNALO_UJ_URL);
		
		UserBo bo = new UserBo();
		String menusConCat = "";
		
		for(int i=0;i<menus.size();i++){
			menusConCat = menusConCat + menus.get(i).toString() + (((menus.size()-1)>i)?",":"");
		}
		
		int res= bo.add(nev, menusConCat, email);
		
		if(res >-1 ){
			Message.success(request);
			String[] m = {email};
			String message = "<center><h1>Kedves " + nev + "!</h1></center>" +
							 "<br/><p>Sikeresen regisztráltak a Minerva panzió alkalmazásba. Az alábbi linkre kattintva tudod magad aktiválni és utána belépni az alkalmazásba.</p>" + 
							 "<p>Kattincs <a href=\"http://localhost:8081/Minerva/actival?activeUserId=" + res + "\"><i>ide</i></a>.</p>" +
							 "<br/><br/><p>Ez egy automatikus üzenet kérjük, hogy erre az emailre ne válaszolj.</p>" + 
							 "<p style=\"font-size: 10px;\"><i>Minerva Panzió app álltal küldve.</i></p>";
			
			EmailSend.sendMail(m, "Aktivációs email, Minerva Panzió!", message);
		}else if(res == -1){
			Message.error(request, "Ezzel az email címmel már létezik felhasználó");
		}else{
			Message.error(request);
		}
		
		model.addAttribute("newUserMenus", UserMenusObject.getAll(request));
		return UserSession.checkUser(request, FELHASZNALO_UJ_URL, model);
	}
	
	//---------------Új felhasználó aktiválása----------------------
	@RequestMapping(value = "/actival", method = RequestMethod.GET)
	public String activalGet(@RequestParam(name = "activeUserId") int id, Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, FELHASZNALO_ACTIVAL_URL);
		
		model.addAttribute("activeUserId", id);
		return UserSession.checkUser(request, FELHASZNALO_ACTIVAL_URL, model);
	}
	
	//---------------Új felhasználó aktiválása----------------------
	@RequestMapping(value = "/actival", method = RequestMethod.POST)
	public String activalPost(@RequestParam(name = "id") int id, 
							  @RequestParam(name = "fnev") String fnev,
							  @RequestParam(name = "pw") String pw,
							  @RequestParam(name = "pw_re") String pw_re,
							  Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, FELHASZNALO_ACTIVAL_URL);
		UserBo bo = new UserBo();
		
		if(!pw.equals(pw_re)){
			model.addAttribute("activeUserId", id);
			model.addAttribute("fnev", fnev);
			Message.error(request, "A jelszavak nem eggyeznek meg!");
			return UserSession.checkUser(request, FELHASZNALO_ACTIVAL_URL, model);
		}
		
		ErrorCodeEnum error = bo.actival(id, fnev, pw);
		if(error == ErrorCodeEnum.SUCCESS){
			Message.success(request, "Sikeres aktiválás! Mostmár bejelentkezhet.");
			model.addAttribute("activeUserId", id);
			model.addAttribute("fnev", fnev);
			return UserSession.checkUser(request, "login", model);
		}else if(error == ErrorCodeEnum.NAME_NOT_VALID_ERROR){
			Message.error(request, "Ez a fálhasználó név már foglalt!");
			model.addAttribute("activeUserId", id);
			model.addAttribute("fnev", fnev);
			return UserSession.checkUser(request, FELHASZNALO_ACTIVAL_URL, model);
		}else{
			Message.error(request);
			model.addAttribute("activeUserId", id);
			model.addAttribute("fnev", fnev);
			return UserSession.checkUser(request, FELHASZNALO_ACTIVAL_URL, model);
		}
	}
	
	//---------------Felhasználó menü módosít----------------------
	@RequestMapping(value = "/userMenuModif", method = RequestMethod.GET)
	public String userMenuModifGet(Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, FELHASZNALO_MENU_MODIF_URL);
		UserBo bo = new UserBo();
		
		model.addAttribute("users", bo.getActive(UserSession.getUserId(request)));
		model.addAttribute("newUserMenus", UserMenusObject.getAll(request));
		return UserSession.checkUser(request, FELHASZNALO_MENU_MODIF_URL, model);
	}
	
	//---------------Felhasználó menü módosít----------------------
	@RequestMapping(value = "/userMenuModif", method = RequestMethod.POST)
	public String userMenuModifPost(@RequestParam(name = "id") int id, @RequestParam(name = "menus") List<String> menus,Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, FELHASZNALO_MENU_MODIF_URL);
		UserBo bo = new UserBo();
		
		String menusConCat = "";
		
		for(int i=0;i<menus.size();i++){
			menusConCat = menusConCat + menus.get(i).toString() + (((menus.size()-1)>i)?",":"");
		}
		
		ErrorCodeEnum error = bo.menuModif(id, menusConCat);
		if(error == ErrorCodeEnum.SUCCESS){
			Message.success(request);
		}else if(error == ErrorCodeEnum.ERROR){
			Message.error(request);
		}else{
			Message.errorDb(request);
		}
		
		model.addAttribute("users", bo.getActive(UserSession.getUserId(request)));
		model.addAttribute("newUserMenus", UserMenusObject.getAll(request));
		return UserSession.checkUser(request, FELHASZNALO_MENU_MODIF_URL, model);
	}
	
	//----------------------felhasználó státusz váltás--------------------
	@RequestMapping(value = "/userDelet", method = RequestMethod.GET)
	public String userDeletGet(Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, FELHASZNALO_DELET_URL);
		UserBo bo = new UserBo();
		
		model.addAttribute("users", bo.getAll(UserSession.getUserId(request)));
		return UserSession.checkUser(request, FELHASZNALO_DELET_URL, model);
	}
	
	//----------------------felhasználó státusz váltás--------------------
	@RequestMapping(value = "/userDelet", method = RequestMethod.POST)
	public String userDeletPost(@RequestParam(name = "id") int id, Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, FELHASZNALO_DELET_URL);
		UserBo bo = new UserBo();
		
		ErrorCodeEnum error = bo.changeStat(id);
		
		if(error == ErrorCodeEnum.SUCCESS){
			Message.success(request);
		}else if(error == ErrorCodeEnum.ERROR){
			Message.error(request);
		}else{
			Message.errorDb(request);
		}
		
		model.addAttribute("users", bo.getAll(UserSession.getUserId(request)));
		return UserSession.checkUser(request, FELHASZNALO_DELET_URL, model);
	}
	
	//----------------------saját adat módosít--------------------
	@RequestMapping(value = "/userModif", method = RequestMethod.GET)
	public String userModifGet(Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, FELHASZNALO_DATA_MODIF_URL);
		UserBo bo = new UserBo();
		
		model.addAttribute("user", bo.getUserById(UserSession.getUserId(request)));
		return UserSession.checkUser(request, FELHASZNALO_DATA_MODIF_URL, model);
	}
	
	//----------------------saját adat módosít--------------------
	@RequestMapping(value = "/userModif", method = RequestMethod.POST)
	public String userModifPost(@RequestParam(name = "fnev") String fnev, 
								@RequestParam(name = "pw") String pw,
								@RequestParam(name = "pw_new_1") String pw1,
								@RequestParam(name = "pw_new_2") String pw2,
								Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, FELHASZNALO_DATA_MODIF_URL);
		UserBo bo = new UserBo();
		boolean isNew = false;
		Users actualUser = bo.getUserById(UserSession.getUserId(request));
		
		if(!pw.equals(actualUser.getJelszo())){
			Message.error(request, "Helytelen jelszó!");
			
			model.addAttribute("user", bo.getUserById(UserSession.getUserId(request)));
			return UserSession.checkUser(request, FELHASZNALO_DATA_MODIF_URL, model);
		}
		
		if(!actualUser.getFnev().equals(fnev)){
			isNew = true;
		}
		
		if(StringValidator.isNotEmpty(pw1) && !pw1.equals(pw2)){
			Message.error(request, "A jelszavak nem eggyeznek meg!");
			
			model.addAttribute("user", bo.getUserById(UserSession.getUserId(request)));
			return UserSession.checkUser(request, FELHASZNALO_DATA_MODIF_URL, model);
		}else if(StringValidator.isNotEmpty(pw1) && pw1.equals(pw2)){
			pw = pw1;
		}
		
		ErrorCodeEnum error = bo.dataModif(UserSession.getUserId(request), fnev, pw, isNew);
		
		if(error == ErrorCodeEnum.SUCCESS){
			Message.success(request);
		}else if(error == ErrorCodeEnum.NAME_NOT_VALID_ERROR){
			Message.errorNameValid(request);
		}else if(error == ErrorCodeEnum.ERROR){
			Message.error(request);
		}else{
			Message.errorDb(request);
		}
		
		model.addAttribute("user", bo.getUserById(UserSession.getUserId(request)));
		return UserSession.checkUser(request, FELHASZNALO_DATA_MODIF_URL, model);
	}
}
