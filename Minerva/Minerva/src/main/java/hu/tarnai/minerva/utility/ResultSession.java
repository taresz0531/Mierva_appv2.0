package hu.tarnai.minerva.utility;

import javax.servlet.http.HttpServletRequest;

public class ResultSession {
	public static Object get(HttpServletRequest request){
		return request.getSession().getAttribute("result");
	}
	
	public static void delet(HttpServletRequest request){
		request.getSession().removeAttribute("result");
	}
	
	public static void set(HttpServletRequest request, Object result){
		request.getSession().setAttribute("result", result);
	}
	
	public static Object getModel(HttpServletRequest request){
		return request.getSession().getAttribute("resultModel");
	}
	
	public static void deletModel(HttpServletRequest request){
		request.getSession().removeAttribute("resultModel");
	}
	
	public static void setModel(HttpServletRequest request, Object resultModel){
		request.getSession().setAttribute("resultModel", resultModel);
	}
}
