package hu.tarnai.minerva.controllers.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping(value = "/bookingTable", method = RequestMethod.POST)
	public String bookingTablePost(Model model, HttpServletRequest request, RedirectAttributes redirect){
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
	public String bookingWeekPost(@RequestParam(name = "dateT") String dateT, Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, BOOKING_TABLE);
		if(StringValidator.isNotEmpty(dateT)) {
			java.util.Calendar cld = java.util.Calendar.getInstance();
			cld.set(java.util.Calendar.YEAR, Integer.parseInt(dateT.split("-W")[0]));
			cld.set(java.util.Calendar.WEEK_OF_YEAR, Integer.parseInt(dateT.split("-W")[1]));
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
	
	@RequestMapping(value = "/bookingBook", method = RequestMethod.POST)
	public String bookingBookPost(Model model, HttpServletRequest request, RedirectAttributes redirect){
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
	public String bookingBookSave(@RequestParam(name = "id") int id,
								  @RequestParam(name = "bed1") int bed1,
								  @RequestParam(name = "bed2") int bed2,
								  @RequestParam(name = "bed3") int bed3,
								  @RequestParam(name = "bed4") int bed4,
								  @RequestParam(name = "bedAttic2") int bedAttic2,
								  @RequestParam(name = "date") String date,
								  Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, BOOKING_BOOK);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SzobaBo bo = new SzobaBo();
		Booking booking;
		BookingWeek week;

		try {
			booking = new Booking(id, format.parse(date), bed1, bed2, bed3, bed4, bedAttic2);
		} catch (ParseException e1) {
			Message.error(request, "Ismeretlen hiba!");
			week = new BookingWeek(new Date());
			model.addAttribute("weekDays", week.getWeekDays());
			model.addAttribute("monday", week.getWeekDays().get(0).date);
			model.addAttribute("bookingRooms", week.getBooks());
			e1.printStackTrace();
			
			return  UserSession.checkUser(request, BOOKING_BOOK, model);
		}
		
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
			week = new BookingWeek(new Date(booking.getDate().getTime()));
		} catch (Exception e) {
			e.printStackTrace();
			Message.error(request, "Ismeretlen hiba!");
			week = new BookingWeek(new Date());
			model.addAttribute("weekDays", week.getWeekDays());
			model.addAttribute("monday", week.getWeekDays().get(0).date);
			model.addAttribute("bookingRooms", week.getBooks());
			
			return  UserSession.checkUser(request, BOOKING_BOOK, model);
			
		}
		model.addAttribute("weekDays", week.getWeekDays());
		model.addAttribute("monday", week.getWeekDays().get(0).date);
		model.addAttribute("bookingRooms", week.getBooks());
		
		return  UserSession.checkUser(request, BOOKING_BOOK, model);
	}
	
	@RequestMapping(value = "/bookingBookSaveAll", method = RequestMethod.POST)
	public String bookingBookSaveAllPost(@RequestParam(name = "id") String id,
								  @RequestParam(name = "bed1") String bed1,
								  @RequestParam(name = "bed2") String bed2,
								  @RequestParam(name = "bed3") String bed3,
								  @RequestParam(name = "bed4") String bed4,
								  @RequestParam(name = "bedAttic2") String bedAttic2,
								  @RequestParam(name = "date") String date,
								  Model model, HttpServletRequest request, RedirectAttributes redirect){
		PageName.saveAdmin(request, BOOKING_BOOK);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SzobaBo bo = new SzobaBo();
		List<Booking> booking = new ArrayList<Booking>();
		BookingWeek week;
		
		String[] ids = id.split("#");
		String[] bed1s = bed1.split("#");
		String[] bed2s = bed2.split("#");
		String[] bed3s = bed3.split("#");
		String[] bed4s = bed4.split("#");
		String[] bedAttic2s = bedAttic2.split("#");
		String[] dates = date.split("#");
		
		for(int i=0;i<7;i++) {
			try {
				booking.add(new Booking(Integer.parseInt(ids[i]), format.parse(dates[i]), Integer.parseInt(bed1s[i]), Integer.parseInt(bed2s[i]), Integer.parseInt(bed3s[i]), Integer.parseInt(bed4s[i]), Integer.parseInt(bedAttic2s[i])));
			} catch (NumberFormatException | ParseException e) {
				Message.error(request, "Ismeretlen hiba!");
				week = new BookingWeek(new Date());
				model.addAttribute("weekDays", week.getWeekDays());
				model.addAttribute("monday", week.getWeekDays().get(0).date);
				model.addAttribute("bookingRooms", week.getBooks());
				e.printStackTrace();
				
				return  UserSession.checkUser(request, BOOKING_BOOK, model);
			}
		}
		
		for(Booking b:booking) {
			ErrorCodeEnum error = ErrorCodeEnum.ERROR;
			if(b.getId()>0) {
				error = bo.bookingModif(b);
			}else {
				error = bo.bookingAdd(b, b.getDate());
			}
			
			if(error == ErrorCodeEnum.SUCCESS) {
				Message.success(request);
			}else {
				Message.error(request);
			}
		}
		
		week = new BookingWeek(new Date(booking.get(0).getDate().getTime()));

		model.addAttribute("weekDays", week.getWeekDays());
		model.addAttribute("monday", week.getWeekDays().get(0).date);
		model.addAttribute("bookingRooms", week.getBooks());
		
		return  UserSession.checkUser(request, BOOKING_BOOK, model);
	}
}
