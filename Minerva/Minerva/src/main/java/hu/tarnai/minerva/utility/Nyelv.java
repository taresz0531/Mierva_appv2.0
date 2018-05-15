package hu.tarnai.minerva.utility;

import javax.servlet.http.HttpServletRequest;

import hu.tarnai.minerva.enums.NyelvEnum;

public class Nyelv {
	
	public static String getRedirectURL(HttpServletRequest request){
		if(request.getSession().getAttribute("nyelv") == null){
			Nyelv.setNyelv(request, NyelvEnum.HUN);
			return "hun" + "/" + PageName.get(request);
		}
		return request.getSession().getAttribute("nyelv").toString() + "/" + PageName.get(request);
	}
	
	public static void setNyelv(HttpServletRequest request, NyelvEnum nyelv){
		request.getSession().setAttribute("nyelv", nyelv == NyelvEnum.HUN?"hun":"eng");
	}
	
	public static NyelvEnum getNyelv(HttpServletRequest request){
		if(request.getSession().getAttribute("nyelv") == null){
			return NyelvEnum.HUN;
		}
		return request.getSession().getAttribute("nyelv").toString().equals("hun")?NyelvEnum.HUN:NyelvEnum.ENG;
	}
}
