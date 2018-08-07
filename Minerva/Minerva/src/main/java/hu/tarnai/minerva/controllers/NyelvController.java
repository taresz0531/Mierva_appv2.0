package hu.tarnai.minerva.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hu.tarnai.minerva.enums.NyelvEnum;
import hu.tarnai.minerva.utility.Nyelv;
import hu.tarnai.minerva.utility.PageName;
import hu.tarnai.minerva.utility.StringUtils;

@Controller
public class NyelvController {
	
	@RequestMapping(value = "hun", method = RequestMethod.GET)
	public String nyelvHUN(Model model, HttpServletRequest request, HttpServletResponse response){
		Nyelv.setNyelv(request, response, NyelvEnum.HUN);
		if(StringUtils.isEmptyString(PageName.get(request))) {
			return "redirect:/foldal";
		}
		return "redirect:" + PageName.get(request);
	}
	
	@RequestMapping(value = "eng", method = RequestMethod.GET)
	public String nyelvENG(Model model, HttpServletRequest request, HttpServletResponse response){
		Nyelv.setNyelv(request, response, NyelvEnum.ENG);
		if(StringUtils.isEmptyString(PageName.get(request))) {
			return "redirect:/foldal";
		}
		return "redirect:" + PageName.get(request);
	}
}
