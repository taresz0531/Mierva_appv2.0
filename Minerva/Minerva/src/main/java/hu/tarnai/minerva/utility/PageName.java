package hu.tarnai.minerva.utility;

import javax.servlet.http.HttpServletRequest;

public class PageName {
	public static void save(HttpServletRequest request ,String name){
		request.getSession().setAttribute("pageName", name);
		Message.reset(request);
		ResultSession.delet(request);
	}
	
	public static void saveAdmin(HttpServletRequest request ,String name){
		request.getSession().setAttribute("pageNameAdmin", name);
		Message.reset(request);
		ResultSession.delet(request);
	}
	
	public static String get(HttpServletRequest request){
		return request.getSession().getAttribute("pageName")!=null?request.getSession().getAttribute("pageName").toString():null;
	}
	
	public static void deletAdmin(HttpServletRequest request){
		request.getSession().removeAttribute("pageNameAdmin");
	}
	
	public static String getAdmin(HttpServletRequest request){
		if(request.getSession().getAttribute("pageNameAdmin")!=null){
			return request.getSession().getAttribute("pageNameAdmin").toString();
		}
		
		return null;
	}
}
