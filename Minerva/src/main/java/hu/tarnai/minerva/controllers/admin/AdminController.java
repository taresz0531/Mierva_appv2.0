package hu.tarnai.minerva.controllers.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hu.tarnai.minerva.bo.UserBo;
import hu.tarnai.minerva.enums.NyelvEnum;
import hu.tarnai.minerva.objects.UserMenusObject;
import hu.tarnai.minerva.utility.Message;
import hu.tarnai.minerva.utility.Nyelv;
import hu.tarnai.minerva.utility.PageName;
import hu.tarnai.minerva.utility.ResultSession;
import hu.tarnai.minerva.utility.UserSession;

@Controller
public class AdminController {
	
	static String ADMIN_PAGE_NAME = "admin";
	static String LOGIN_PAGE_NAME = "login";
	
		//---------------admin--------------------//
		@RequestMapping(value = "/admin", method = RequestMethod.GET)
		public String admin(@RequestParam(name = "pageName") String pageName,Model model, HttpServletRequest request){
			PageName.save(request, ADMIN_PAGE_NAME);
			Nyelv.setNyelv(request, NyelvEnum.HUN);
			
			
			if(UserSession.getUserId(request)>-1){
				if(pageName.equals("0")){
					Message.success(request, "Sikeres Bejelentkezés");
				}else if(pageName.equals("1")) {
					
				}
				model.addAttribute("menus", UserMenusObject.get(request));
				model.addAttribute("pageName", (pageName.equals("1")?"0":pageName));
				if(ResultSession.get(request)!=null){
					model.addAttribute("result", ResultSession.get(request));
				}
				
				return "admin/" + ADMIN_PAGE_NAME;
			}
			
			Message.error(request, "Kérem jelentkezzen be a folytatáshoz!");
			return "admin/" + LOGIN_PAGE_NAME;
		}
		
		//---------------admin--------------------//
		@RequestMapping(value = "/adminRedirect", method = RequestMethod.GET)
		public String adminRedirect(Model model, HttpServletRequest request, RedirectAttributes redirect){
			
			if(UserSession.getUserId(request)<0){
				Message.error(request,"Kérem jelentkezzen be a folytatáshoz!");
				return "admin/" + LOGIN_PAGE_NAME;
			}
			
			if(PageName.getAdmin(request)!=null){
				return "redirect:" + PageName.getAdmin(request);
			}
			
			redirect.addAttribute("pageName", "0");
			return "redirect:/admin";
		}
		
		//---------------login--------------------//
		@RequestMapping(value = "/login", method = RequestMethod.GET)
		public String login(Model model, HttpServletRequest request){
			PageName.save(request, LOGIN_PAGE_NAME);
			Nyelv.setNyelv(request, NyelvEnum.HUN);
			
			return "admin/" + LOGIN_PAGE_NAME;
		}
		
		@RequestMapping(value = "/login", method = RequestMethod.POST)
		public String loginPost(@RequestParam(value = "fnev") String fnev,
								@RequestParam(value = "jelszo") String jelszo,
								Model model, HttpServletRequest request, RedirectAttributes redirect){
			
			PageName.save(request, LOGIN_PAGE_NAME);
			PageName.deletAdmin(request);
			Nyelv.setNyelv(request, NyelvEnum.HUN);
			
			UserBo bo = new UserBo();
			int res = bo.loginUser(fnev, jelszo, request);
			
			if(res  > -1){
				Message.success(request, "Sikeres Bejelentkezés");
				redirect.addAttribute("pageName", "0");
				return "redirect:/admin";
			}else if(res == -1){
				Message.error(request, "Még nem aktiválta az email címét!");
			}else if(res == -2){
				Message.error(request, "Hibás felhasználónév vagy jelszó!");
			}else{
				Message.error(request, "Ismeretlen hiba történt.");
			}
			
			return "admin/" + LOGIN_PAGE_NAME;
		}
		
		//---------------kijelentkezés--------------------//
		@RequestMapping(value = "/logOut", method = RequestMethod.GET)
		public String logOut(Model model, HttpServletRequest request){
			PageName.save(request, LOGIN_PAGE_NAME);
			Nyelv.setNyelv(request, NyelvEnum.HUN);
			
			UserSession.setUserId(-1, request);
			Message.success(request, "Sikeresen kijelentkezett!");
			
			return "admin/" + LOGIN_PAGE_NAME;
		}

}
