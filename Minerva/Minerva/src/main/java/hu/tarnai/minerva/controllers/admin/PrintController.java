package hu.tarnai.minerva.controllers.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hu.tarnai.minerva.bo.HetimenuBo;
import hu.tarnai.minerva.entity.Napimenu;
import hu.tarnai.minerva.objects.BookinTableJasperObj;
import hu.tarnai.minerva.objects.DayString;
import hu.tarnai.minerva.objects.NapimenuJasperObj;
import hu.tarnai.minerva.utility.GetDateByDayNameClass;
import hu.tarnai.minerva.utility.JasperUtil;
import hu.tarnai.minerva.utility.StringValidator;

@RestController
public class PrintController {
	
	@RequestMapping(value = "/printNapimenu", method = RequestMethod.POST)
	public void printNapimenuPost(HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirect){
		
		List<Napimenu> menus = HetimenuBo.getNexWeekMenus();
		List<NapimenuJasperObj> jaspObj = convertNapimenuToJasperOb(menus);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		GetDateByDayNameClass dateClass = new GetDateByDayNameClass();
		
		JasperUtil jasperUtil = new JasperUtil("hetiMenu2.jasper");
		
		String dateMonday = dateClass.getDateByDay("hétfő");
		String dateSunday = dateClass.getDateByDay("vasárnap");
		
		Date calMonday = new Date();
		Date calszunday = new Date();
		
		try {
			calMonday = new Date(format.parse(dateMonday).getTime() + (7*24*60*60*1000));
			calszunday = new Date(format.parse(dateMonday).getTime() + (13*24*60*60*1000));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		dateMonday = format.format(calMonday);
		dateSunday = format.format(calszunday);
		
		DayString monday = new DayString(dateMonday.split("-")[0], dateMonday.split("-")[1], dateMonday.split("-")[2]);
		DayString szunday = new DayString(dateSunday.split("-")[0], dateSunday.split("-")[1], dateSunday.split("-")[2]);
		
		String dateFromTo = monday.getYear() + ". " + dateClass.getMonthName(monday.getMonth()) + " " + monday.getDay() + dateClass.getPosFixDate(Integer.parseInt(monday.getDay())) + "-" + szunday.getYear() + ". " + dateClass.getMonthName(szunday.getMonth()) + szunday.getDay() + "-ig";
		
		jasperUtil.printNapimenu(dateFromTo, jaspObj, response);
		
	}
	
	@RequestMapping(value = "/printBookingTable", method = RequestMethod.POST)
	public void printBookingTablePost(@RequestParam("date") String date , HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirect){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		BookinTableJasperObj bookingTable;
		
		try {
			bookingTable = new BookinTableJasperObj(new Date(format.parse(date).getTime()));
		} catch (ParseException e) {
			bookingTable = new BookinTableJasperObj(new Date());
			e.printStackTrace();
		}
		
		JasperUtil jasperUtil = new JasperUtil("bookingTable.jasper");
		
		jasperUtil.printBookingTable(bookingTable.get(), response);
	}
	
	public List<NapimenuJasperObj> convertNapimenuToJasperOb(List<Napimenu> napi){
		List<NapimenuJasperObj> jasper = new ArrayList<NapimenuJasperObj>();
		int index = 0;
		String nap = "";
		String leves = "";
		String foetel = "";
		String koret = "";
		for(Napimenu n:napi) {
			if(n.getId()>0) {
				nap = StringValidator.isNotEmpty(n.getNap())?n.getNap().split("/")[0]:"";
				leves = StringValidator.isNotEmpty(n.getLeves())?n.getLeves().split("/")[0]:"";
				foetel = StringValidator.isNotEmpty(n.getFoetel())?n.getFoetel().split("/")[0]:"";
				koret = StringValidator.isNotEmpty(n.getKoret())?n.getKoret().split("/")[0]:"";
				
				jasper.add(new NapimenuJasperObj("" + index, nap, leves, foetel, koret));
				if(index==0) {
					index=1;
				}else {
					index=0;
				}
			}
		}
		
		return jasper;
	}

}
