package hu.tarnai.minerva.utility;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hu.tarnai.minerva.enums.ErrorCodeEnum;

public class AdminSettings {

	public static void set(HttpServletRequest request, RedirectAttributes redirect,String pageName, Object resultObject, String message, ErrorCodeEnum code){
		if(code == ErrorCodeEnum.SUCCESS){
			Message.success(request, message);
		}else{
			Message.error(request, message);
		}
		
		redirect.addAttribute("pageName", pageName);
		ResultSession.set(request, resultObject);
	}
	
	public static void set(HttpServletRequest request, RedirectAttributes redirect,String pageName, Object resultObject){
		Message.reset(request);
		
		redirect.addAttribute("pageName", pageName);
		ResultSession.set(request, resultObject);
	}
	
	public static void set(HttpServletRequest request, RedirectAttributes redirect,String pageName, String message, ErrorCodeEnum code){
		if(code == ErrorCodeEnum.SUCCESS){
			Message.success(request, message);
		}else{
			Message.error(request, message);
		}
		
		redirect.addAttribute("pageName", pageName);
		ResultSession.delet(request);
	}
	
	public static void set(HttpServletRequest request, RedirectAttributes redirect,String pageName){
		Message.reset(request);
		
		redirect.addAttribute("pageName", pageName);
		ResultSession.delet(request);
	}
	
	public static void setWhitModel(HttpServletRequest request, RedirectAttributes redirect,String pageName,Object model){
		Message.reset(request);
		
		redirect.addAttribute("pageName", pageName);
		ResultSession.setModel(request, model);
		ResultSession.delet(request);
	}
	
	public static void setWhitModelAndMessage(HttpServletRequest request, RedirectAttributes redirect,String pageName,Object model){
			
		redirect.addAttribute("pageName", pageName);
		ResultSession.delet(request);
		ResultSession.setModel(request, model);
	}
	
	public static void setWhitResultAndModelAndMessage(HttpServletRequest request, RedirectAttributes redirect,String pageName, Object result,Object model){
		
		redirect.addAttribute("pageName", pageName);
		ResultSession.set(request, result);
		ResultSession.setModel(request, model);
	}
	
	public static void setWhitMessage(HttpServletRequest request, RedirectAttributes redirect,String pageName, Object resultObject){
		
		redirect.addAttribute("pageName", pageName);
		ResultSession.set(request, resultObject);
	}
}
