package hu.tarnai.minerva.utility;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.tarnai.minerva.enums.NyelvEnum;
import hu.tarnai.minerva.languages.LangSetter;

public class Nyelv {
	
	public static String getRedirectURL(HttpServletRequest request, HttpServletResponse response){
		if(request.getSession().getAttribute("nyelv") == null){
			NyelvEnum nyelv = Nyelv.getNyelv(request);
			Nyelv.setNyelv(request, response, nyelv);
		}
		
		return "views" + "/" + PageName.get(request);
	}
	
	public static void setNyelv(HttpServletRequest request, HttpServletResponse response, NyelvEnum nyelv){
		request.getSession().setAttribute("nyelv", nyelv == NyelvEnum.HUN?"hun":"eng");
		Cookie c = new Cookie("nyelv", nyelv == NyelvEnum.HUN?"hun":"eng");
		response.addCookie(c);

		LangSetter.set(request.getSession(),nyelv);
		
	}
	
	public static NyelvEnum getNyelv(HttpServletRequest request){
		if(request.getSession().getAttribute("nyelv") == null){
			Cookie[] cookies = request.getCookies();
		    if (cookies != null) {
		      for (int i = 0; i < cookies.length; i++) {
		        if (cookies[i].getName().equals("nyelv")) {
		          String ny = cookies[i].getValue();
		          return ny.equals("hun")?NyelvEnum.HUN:NyelvEnum.ENG;
		        }
		      }
		    }

			return NyelvEnum.HUN;
		}
		return request.getSession().getAttribute("nyelv").toString().equals("hun")?NyelvEnum.HUN:NyelvEnum.ENG;
	}
	
	public static String getKey(HttpServletRequest request, String key) {
		return (String) request.getSession().getAttribute(key);
	}
}
