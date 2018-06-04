package hu.tarnai.minerva.controllers.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hu.tarnai.minerva.bo.SzobaBo;
import hu.tarnai.minerva.entity.Booking;
import hu.tarnai.minerva.entity.Calendar;
import hu.tarnai.minerva.enums.ErrorCodeEnum;
import hu.tarnai.minerva.objects.BookingWeek;
import hu.tarnai.minerva.utility.Message;
import hu.tarnai.minerva.utility.PageName;
import hu.tarnai.minerva.utility.StringValidator;
import hu.tarnai.minerva.utility.UserSession;

@Controller
public class BookingController {
	private static String BOOKING_TABLE = "bookingTable";
	private static String BOOKING_BOOK = "bookingBook";
	private static int ONE_DAY = 24*60*60*1000;

	// TODO Foglasás
	@RequestMapping(value = "/bookingTable", method = RequestMethod.GET)
	public String bookingTableGet(Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, BOOKING_TABLE);
		
		BookingWeek week = new BookingWeek(new Date());
		model.addAttribute("weekDays", week.getWeekDays());
		model.addAttribute("monday", week.getWeekDays().get(0).date);
		model.addAttribute("bookingRooms", week.getBooks());
		model.addAttribute("roomTypes", week.getRooms());
		model.addAttribute("cells", week.getCells());
		
		return  UserSession.checkUser(request, BOOKING_TABLE, model);
	}
	
	@RequestMapping(value = "/bookingSave", method = RequestMethod.POST)
	public String bookingSavePost(@RequestParam(name = "dateFrom") String datefrom, 
								  @RequestParam(name = "roomType") int roomType,
								  @RequestParam(name = "dateTo") String dateTo,
								  @RequestParam(name = "name") String name,
								  @RequestParam(name = "phone") String phone,
								  @RequestParam(name = "adultsNum") int adultsNum,
								  @RequestParam(name = "childrenNum") int childrenNum,
								  @RequestParam(name = "payType") String payType,
								  @RequestParam(name = "price") int price,
								  @RequestParam(name = "comment") String comment,
								  Model model, HttpServletRequest request, RedirectAttributes redirect){
		
		PageName.saveAdmin(request, BOOKING_TABLE);
		
		Calendar calendar = new Calendar();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date saveDate = new Date();
		try {
			saveDate = format.parse(datefrom);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		try {
			calendar.setDateFrom(format.parse(datefrom));
			if(dateTo == null || dateTo.equals("")){
				calendar.setDateTo(new Date(calendar.getDateFrom().getTime() + ONE_DAY));
			}else {
				calendar.setDateTo(format.parse(dateTo));
			}
		} catch (ParseException e) {
			e.printStackTrace();
			Message.error(request, "Ismeretlen hiba!");
			BookingWeek week = new BookingWeek(new Date());
			model.addAttribute("weekDays", week.getWeekDays());
			model.addAttribute("bookingRooms", week.getBooks());
			model.addAttribute("monday", week.getWeekDays().get(0).date);
			model.addAttribute("roomTypes", week.getRooms());
			model.addAttribute("cells", week.getCells());
			
			return  UserSession.checkUser(request, BOOKING_TABLE, model);
		}
		
		calendar.setRoomType(roomType);
		calendar.setName(name);
		calendar.setPhone(phone);
		calendar.setAdultsNum(adultsNum);
		calendar.setChildrenNum(childrenNum);
		calendar.setPayType(payType);
		calendar.setPrice(price);
		
		SimpleDateFormat formatH = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if(StringValidator.isNotEmpty(comment)) {
			String commentWhitName = "<i style='font-size: 10px; color: black;'>>> " + formatH.format(new Date()) + ", " + UserSession.getCurrentUser(request).getNev() + ":</i><br/>" + comment + "<br/>";
			calendar.setComment(commentWhitName);
		}else {
			calendar.setComment("");
		}
		
		SzobaBo bo = new SzobaBo();

		
		ErrorCodeEnum error = bo.calendarAdd(calendar);
		
		if(error == ErrorCodeEnum.DATE_NOT_VALID) {
			Message.error(request, "A foglalások között átfedés van!");
		}else if(error == ErrorCodeEnum.SUCCESS) {
			Message.success(request);
		}else {
			Message.error(request);
		}
		
		BookingWeek week = new BookingWeek(saveDate);
		model.addAttribute("weekDays", week.getWeekDays());
		model.addAttribute("bookingRooms", week.getBooks());
		model.addAttribute("roomTypes", week.getRooms());
		model.addAttribute("monday", week.getWeekDays().get(0).date);
		model.addAttribute("cells", week.getCells());
		
		return  UserSession.checkUser(request, BOOKING_TABLE, model);
	}
	
	@RequestMapping(value = "/bookingPrev", method = RequestMethod.POST)
	public String bookingPrevPost(@RequestParam(name = "date") String date, Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, BOOKING_TABLE);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		BookingWeek week;
		try {
			week = new BookingWeek(new Date(format.parse(date).getTime() - ONE_DAY));
		} catch (ParseException e) {
			e.printStackTrace();
			Message.error(request, "Ismeretlen hiba!");
			week = new BookingWeek(new Date());
			model.addAttribute("weekDays", week.getWeekDays());
			model.addAttribute("bookingRooms", week.getBooks());
			model.addAttribute("monday", week.getWeekDays().get(0).date);
			model.addAttribute("roomTypes", week.getRooms());
			model.addAttribute("cells", week.getCells());
			
			return  UserSession.checkUser(request, BOOKING_TABLE, model);
			
		}
		model.addAttribute("weekDays", week.getWeekDays());
		model.addAttribute("monday", week.getWeekDays().get(0).date);
		model.addAttribute("bookingRooms", week.getBooks());
		model.addAttribute("roomTypes", week.getRooms());
		model.addAttribute("cells", week.getCells());
		
		return  UserSession.checkUser(request, BOOKING_TABLE, model);
	}
	
	@RequestMapping(value = "/bookingNext", method = RequestMethod.POST)
	public String bookingNextPost(@RequestParam(name = "date") String date, Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, BOOKING_TABLE);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		BookingWeek week;
		try {
			week = new BookingWeek(new Date(format.parse(date).getTime() + (7*ONE_DAY)));
		} catch (ParseException e) {
			e.printStackTrace();
			Message.error(request, "Ismeretlen hiba!");
			week = new BookingWeek(new Date());
			model.addAttribute("weekDays", week.getWeekDays());
			model.addAttribute("monday", week.getWeekDays().get(0).date);
			model.addAttribute("bookingRooms", week.getBooks());
			model.addAttribute("roomTypes", week.getRooms());
			model.addAttribute("cells", week.getCells());
			
			return  UserSession.checkUser(request, BOOKING_TABLE, model);
			
		}
		model.addAttribute("weekDays", week.getWeekDays());
		model.addAttribute("monday", week.getWeekDays().get(0).date);
		model.addAttribute("bookingRooms", week.getBooks());
		model.addAttribute("roomTypes", week.getRooms());
		model.addAttribute("cells", week.getCells());
		
		return  UserSession.checkUser(request, BOOKING_TABLE, model);
	}
	
	@RequestMapping(value = "/bookingWeek", method = RequestMethod.POST)
	public String bookingWeekPost(@RequestParam(name = "date") String date, Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, BOOKING_TABLE);
		if(StringValidator.isNotEmpty(date)) {
			java.util.Calendar cld = java.util.Calendar.getInstance();
			cld.set(java.util.Calendar.YEAR, Integer.parseInt(date.split("-W")[0]));
			cld.set(java.util.Calendar.WEEK_OF_YEAR, Integer.parseInt(date.split("-W")[1]));
			Date result = cld.getTime();
			BookingWeek week = new BookingWeek(new Date(result.getTime()));
			
			model.addAttribute("weekDays", week.getWeekDays());
			model.addAttribute("monday", week.getWeekDays().get(0).date);
			model.addAttribute("bookingRooms", week.getBooks());
			model.addAttribute("roomTypes", week.getRooms());
			model.addAttribute("cells", week.getCells());
		}else {
			BookingWeek week = new BookingWeek(new Date());
			
			model.addAttribute("weekDays", week.getWeekDays());
			model.addAttribute("monday", week.getWeekDays().get(0).date);
			model.addAttribute("bookingRooms", week.getBooks());
			model.addAttribute("roomTypes", week.getRooms());
			model.addAttribute("cells", week.getCells());
			
			Message.error(request, "Elöbb válasszo egy hetet a dátumválasztóval!");
		}
		
		return  UserSession.checkUser(request, BOOKING_TABLE, model);
	}
	
	@RequestMapping(value = "/bookingAddComment", method = RequestMethod.POST)
	public String bookingAddCommentPost(@RequestParam(name = "date") String date, @RequestParam(name = "addCommentId") int id, @RequestParam(name = "comment") String comment, @RequestParam(name = "addComment") String originalComment, Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, BOOKING_TABLE);
		
		SzobaBo bo = new SzobaBo();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatH = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String commentWhitName = "<i style='font-size: 10px; color: black;'>>> " + formatH.format(new Date()) + ", " + UserSession.getCurrentUser(request).getNev() + ":</i><br/>" + comment + "<br/>";
		String modifComment = originalComment + commentWhitName;
		
		ErrorCodeEnum error = bo.calendarModifComment(id, modifComment);
		if(error == ErrorCodeEnum.SUCCESS) {
			Message.success(request, "A megjegyzés sikeresen hozzá lett adva.");
		}else {
			Message.error(request);
		}
		
		Date saveDate = new Date();
		try {
			saveDate = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		BookingWeek week = new BookingWeek(saveDate);
		model.addAttribute("weekDays", week.getWeekDays());
		model.addAttribute("monday", week.getWeekDays().get(0).date);
		model.addAttribute("bookingRooms", week.getBooks());
		model.addAttribute("roomTypes", week.getRooms());
		model.addAttribute("cells", week.getCells());
		
		return  UserSession.checkUser(request, BOOKING_TABLE, model);
	}
	
	@RequestMapping(value = "/bookingChange", method = RequestMethod.POST)
	public String bookingChangePost(@RequestParam(name = "date") String date, @RequestParam(name = "change_id") int id, @RequestParam(name = "change_roomType") int roomType, @RequestParam(name = "change_dateFrom") String dateFrom, Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, BOOKING_TABLE);
		
		SzobaBo bo = new SzobaBo();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Date saveDate = new Date();
		try {
			saveDate = format.parse(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		ErrorCodeEnum error;
		try {
			error = bo.calendarChange(id, format.parse(dateFrom), roomType);
			if(error == ErrorCodeEnum.SUCCESS) {
				Message.success(request, "Sikeres áthelyezés");
			}else if(error == ErrorCodeEnum.DATE_NOT_VALID) {
				Message.error(request, "Ide nem helyezheti át a foglalást! Időpont ütközés.");
			}else {
				Message.error(request);
			}
		} catch (ParseException e) {
			e.printStackTrace();
			Message.error(request);
			
			BookingWeek week = new BookingWeek(saveDate);
			model.addAttribute("weekDays", week.getWeekDays());
			model.addAttribute("monday", week.getWeekDays().get(0).date);
			model.addAttribute("bookingRooms", week.getBooks());
			model.addAttribute("roomTypes", week.getRooms());
			model.addAttribute("cells", week.getCells());
			
			return  UserSession.checkUser(request, BOOKING_TABLE, model);
		}
		
		BookingWeek week = new BookingWeek(saveDate);
		model.addAttribute("weekDays", week.getWeekDays());
		model.addAttribute("monday", week.getWeekDays().get(0).date);
		model.addAttribute("bookingRooms", week.getBooks());
		model.addAttribute("roomTypes", week.getRooms());
		model.addAttribute("cells", week.getCells());
		
		return  UserSession.checkUser(request, BOOKING_TABLE, model);
	}
	
	// TODO booking-os szobák
	@RequestMapping(value = "/bookingBook", method = RequestMethod.GET)
	public String bookingBookGet(Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, BOOKING_BOOK);
		
		BookingWeek week = new BookingWeek(new Date());
		model.addAttribute("weekDays", week.getWeekDays());
		model.addAttribute("monday", week.getWeekDays().get(0).date);
		model.addAttribute("bookingRooms", week.getBooks());
		
		return  UserSession.checkUser(request, BOOKING_BOOK, model);
	}
	
	@RequestMapping(value = "/bookingBookPrev", method = RequestMethod.POST)
	public String bookingBookPrevPost(@RequestParam(name = "date") String date, Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, BOOKING_BOOK);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		BookingWeek week;
		try {
			week = new BookingWeek(new Date(format.parse(date).getTime() - ONE_DAY));
		} catch (ParseException e) {
			e.printStackTrace();
			Message.error(request, "Ismeretlen hiba!");
			week = new BookingWeek(new Date());
			model.addAttribute("weekDays", week.getWeekDays());
			model.addAttribute("bookingRooms", week.getBooks());
			model.addAttribute("monday", week.getWeekDays().get(0).date);
			
			return  UserSession.checkUser(request, BOOKING_BOOK, model);
			
		}
		model.addAttribute("weekDays", week.getWeekDays());
		model.addAttribute("monday", week.getWeekDays().get(0).date);
		model.addAttribute("bookingRooms", week.getBooks());
		
		return  UserSession.checkUser(request, BOOKING_BOOK, model);
	}
	
	@RequestMapping(value = "/bookingBookNext", method = RequestMethod.POST)
	public String bookingBookNextPost(@RequestParam(name = "date") String date, Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, BOOKING_BOOK);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		BookingWeek week;
		try {
			week = new BookingWeek(new Date(format.parse(date).getTime() + (7*ONE_DAY)));
		} catch (ParseException e) {
			e.printStackTrace();
			Message.error(request, "Ismeretlen hiba!");
			week = new BookingWeek(new Date());
			model.addAttribute("weekDays", week.getWeekDays());
			model.addAttribute("monday", week.getWeekDays().get(0).date);
			model.addAttribute("bookingRooms", week.getBooks());
			
			return  UserSession.checkUser(request, BOOKING_TABLE, model);
			
		}
		model.addAttribute("weekDays", week.getWeekDays());
		model.addAttribute("monday", week.getWeekDays().get(0).date);
		model.addAttribute("bookingRooms", week.getBooks());
		
		return  UserSession.checkUser(request, BOOKING_BOOK, model);
	}
	
	@RequestMapping(value = "/bookingBookWeek", method = RequestMethod.POST)
	public String bookingBookWeekPost(@RequestParam(name = "date") String date, Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, BOOKING_BOOK);
		if(StringValidator.isNotEmpty(date)) {
			java.util.Calendar cld = java.util.Calendar.getInstance();
			cld.set(java.util.Calendar.YEAR, Integer.parseInt(date.split("-W")[0]));
			cld.set(java.util.Calendar.WEEK_OF_YEAR, Integer.parseInt(date.split("-W")[1]));
			Date result = cld.getTime();
			BookingWeek week = new BookingWeek(new Date(result.getTime()));
			
			model.addAttribute("weekDays", week.getWeekDays());
			model.addAttribute("monday", week.getWeekDays().get(0).date);
			model.addAttribute("bookingRooms", week.getBooks());
		}else {
			BookingWeek week = new BookingWeek(new Date());
			
			model.addAttribute("weekDays", week.getWeekDays());
			model.addAttribute("monday", week.getWeekDays().get(0).date);
			model.addAttribute("bookingRooms", week.getBooks());
			
			Message.error(request, "Elöbb válasszo egy hetet a dátumválasztóval!");
		}
		
		return  UserSession.checkUser(request, BOOKING_BOOK, model);
	}
	
	@RequestMapping(value = "/bookingBookSave", method = RequestMethod.POST)
	public String bookingBookSave(@RequestParam(name = "date") String date, @ModelAttribute("booking") Booking booking, Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, BOOKING_BOOK);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SzobaBo bo = new SzobaBo();
		
		BookingWeek week;
		try {
			ErrorCodeEnum error = ErrorCodeEnum.ERROR;

			if(booking!=null && booking.getId()==0) {
				error = bo.bookingAdd(booking, booking.getDate());
			}else if(booking != null && booking.getId() != 0){
				error = bo.bookingModif(booking);
			}
			
			if(error == ErrorCodeEnum.SUCCESS) {
				Message.success(request);
			}else {
				Message.error(request);
			}
			week = new BookingWeek(new Date(format.parse(date).getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
			Message.error(request, "Ismeretlen hiba!");
			week = new BookingWeek(new Date());
			model.addAttribute("weekDays", week.getWeekDays());
			model.addAttribute("monday", week.getWeekDays().get(0).date);
			model.addAttribute("bookingRooms", week.getBooks());
			
			return  UserSession.checkUser(request, BOOKING_TABLE, model);
			
		}
		model.addAttribute("weekDays", week.getWeekDays());
		model.addAttribute("monday", week.getWeekDays().get(0).date);
		model.addAttribute("bookingRooms", week.getBooks());
		
		return  UserSession.checkUser(request, BOOKING_BOOK, model);
	}
}
