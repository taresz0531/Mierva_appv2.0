package hu.tarnai.minerva.utility;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.tarnai.minerva.enums.NyelvEnum;
import hu.tarnai.minerva.languages.EngLang;
import hu.tarnai.minerva.languages.HunLang;

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

		if(nyelv == NyelvEnum.HUN) {
			HunLang.set(request.getSession());
		}else if(nyelv == NyelvEnum.ENG) {
			EngLang.set(request.getSession());
		}
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
}
