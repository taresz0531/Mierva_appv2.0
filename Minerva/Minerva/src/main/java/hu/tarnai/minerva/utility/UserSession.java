package hu.tarnai.minerva.utility;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import hu.tarnai.minerva.entity.Users;
import hu.tarnai.minerva.enums.PermissionCodeEnum;
import hu.tarnai.minerva.objects.UserMenusObject;

public class UserSession {

	public static void setUserId(int id, HttpServletRequest request){
		request.getSession().setAttribute("userId", id);
	}
	
	public static int getUserId(HttpServletRequest request){
		return (int) (request.getSession().getAttribute("userId")!=null?request.getSession().getAttribute("userId"):-1);
	}
	
	public static void setCurrentUser(Users user, HttpServletRequest request){
		request.getSession().setAttribute("currentUser", user);
	}
	
	public static Users getCurrentUser(HttpServletRequest request){
		return (Users) (request.getSession().getAttribute("currentUser")!=null?request.getSession().getAttribute("currentUser"):null);
	}
	
	public static String checkUser(HttpServletRequest request,String pageName, Model model){
		if((request.getSession().getAttribute("userId")==null||(int)request.getSession().getAttribute("userId")<0)){
			Message.error(request, "Kérem jelentkezzen be a folytatás előtt");
			return "admin/login";
		}
		model.addAttribute("menus", UserMenusObject.get(request));
		return "admin/" + pageName;
	}
	
	public static PermissionCodeEnum userHasPermission(HttpServletRequest request, int permId, String pageName, Model model) {
		if(checkUser(request, pageName, model).equals("admin/login")) {
			return PermissionCodeEnum.LOGOUT;
		}
		Users user = getCurrentUser(request);
		if(user.getHkor().equals("S") || user.getHkor().equals("A")) {
			return PermissionCodeEnum.ENABLE;
		}
		
		String[] perm = user.getPermission().split(",");
		for(String p:perm) {
			if(permId == Integer.parseInt(p)) {
				return PermissionCodeEnum.ENABLE;
			}
		}
		
		return PermissionCodeEnum.DISABLE;
	}
	
}
