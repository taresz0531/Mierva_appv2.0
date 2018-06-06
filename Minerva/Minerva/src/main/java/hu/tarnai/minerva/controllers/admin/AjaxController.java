package hu.tarnai.minerva.controllers.admin;

import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hu.tarnai.minerva.bo.EtlapBo;
import hu.tarnai.minerva.bo.HetimenuBo;
import hu.tarnai.minerva.bo.SzobaBo;
import hu.tarnai.minerva.entity.Napimenu;
import hu.tarnai.minerva.enums.ErrorCodeEnum;
import hu.tarnai.minerva.objects.NapimenuJasperObj;
import hu.tarnai.minerva.utility.DateToStringClass;
import hu.tarnai.minerva.utility.JasperUtil;
import hu.tarnai.minerva.utility.JsonCreator;
import hu.tarnai.minerva.utility.StringValidator;

@RestController
public class AjaxController {
	
	@RequestMapping(value = "/ajaxSessionSet", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public String ajaxSessionSetPost(@RequestParam(name = "name") String name, @RequestParam(name = "param") String param, HttpServletRequest request){
		request.getSession().setAttribute(name, param);
		HashMap<String, Object> json = new HashMap<String,Object>();
		json.put("errorCode", 1);
		JsonObject code = Json.createReader(new StringReader(JsonCreator.jsonBuilder(json))).readObject();
		
		return code.toString();
	}
	
	@RequestMapping(value = "/ajaxSaveCalendar", method = RequestMethod.POST)
	public String ajaxSaveCalendarPost(@RequestParam(name = "calId") int calId, @RequestParam(name = "roomType") int roomType, @RequestParam(name = "date") String date, HttpServletRequest request){
		
		HashMap<String, Object> json = new HashMap<String,Object>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		ErrorCodeEnum error;
		SzobaBo bo = new SzobaBo();
		
		try {
			error = bo.calendarChange(calId, format.parse(date), roomType);
			if(error == ErrorCodeEnum.SUCCESS) {
				json.put("errorCode", 1);
			}else {
				json.put("errorCode", 0);
			}
		} catch (ParseException e) {
			json.put("errorCode", -1);
			e.printStackTrace();
		}
		
		JsonObject code = Json.createReader(new StringReader(JsonCreator.jsonBuilder(json))).readObject();
		
		return code.toString();
	}
}
 