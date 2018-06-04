package hu.tarnai.minerva.utility;

import javax.servlet.http.HttpServletRequest;

public class Message {
	
	public static void reset(HttpServletRequest request){
		request.getSession().setAttribute("message", "");
	}
	
	public static void success(HttpServletRequest request){
		request.getSession().setAttribute("message", "success");
		request.getSession().setAttribute("msg", "Sikeres művelet!");
	}
	
	public static void success(HttpServletRequest request, String msg){
		request.getSession().setAttribute("message", "success");
		request.getSession().setAttribute("msg", msg);
	}
	
	public static void error(HttpServletRequest request){
		request.getSession().setAttribute("message", "error");
		request.getSession().setAttribute("msg", "Sikertelen művelet!");
	}
	
	public static void errorNameValid(HttpServletRequest request){
		request.getSession().setAttribute("message", "error");
		request.getSession().setAttribute("msg", "Ilyen névvel már szerepel bejegyzés az adatbázisban!");
	}
	
	public static void errorDb(HttpServletRequest request){
		request.getSession().setAttribute("message", "error");
		request.getSession().setAttribute("msg", "Adatkapcsolati hiba!");
	}
	
	public static void error(HttpServletRequest request, String msg){
		request.getSession().setAttribute("message", "error");
		request.getSession().setAttribute("msg", msg);
	}
	
	public static void warning(HttpServletRequest request){
		request.getSession().setAttribute("message", "warning");
		request.getSession().setAttribute("msg", "A művelet sikeressége nem biztos!");
	}
	
	public static void warning(HttpServletRequest request, String msg){
		request.getSession().setAttribute("message", "warning");
		request.getSession().setAttribute("msg", msg);
	}
}
