package hu.tarnai.minerva.controllers.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hu.tarnai.minerva.bo.EventLogBo;
import hu.tarnai.minerva.utility.PageName;
import hu.tarnai.minerva.utility.UserSession;

@Controller
public class EventLogController {
	private static String EVENT_LOG_URL = "eventLogList";
	
	@RequestMapping(value = "/eventLogList", method = RequestMethod.GET)
	public String bookingTableGet(Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, EVENT_LOG_URL);
		
		EventLogBo bo = new EventLogBo();
		
		model.addAttribute("users", bo.getUserList());
		
		return  UserSession.checkUser(request, EVENT_LOG_URL, model);
	}

}
