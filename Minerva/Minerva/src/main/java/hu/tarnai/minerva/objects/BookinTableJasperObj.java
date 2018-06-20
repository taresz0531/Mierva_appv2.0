package hu.tarnai.minerva.objects;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hu.tarnai.minerva.entity.Booking;
import hu.tarnai.minerva.entity.Room;

public class BookinTableJasperObj {

	private HashMap<String, Object> map = new HashMap<String,Object>();
	private List<Booking> booking = new ArrayList<Booking>();
	private List<BookingCell> cells = new ArrayList<BookingCell>();
	private List<Day> weekDays = new ArrayList<Day>();
	private List<Room> rooms = new ArrayList<Room>();
	
	public BookinTableJasperObj(Date date) {
		BookingWeek week = new BookingWeek(date);
		
		booking = week.getBooks();
		cells = week.getCells();
		weekDays = week.getWeekDays();
		rooms = week.getRooms();
	}
	
	public HashMap<String, Object> get(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
		List<Integer> temp = new ArrayList<Integer>();
		int row = 0;
		int col = 0;
		String cellName = "";
		boolean isSearch = false;
		for(Day d:weekDays) {
			switch (d.getName().toLowerCase()) {
			case "hétfő":
				map.put("dateHe", format.format(d.getDate()));
				break;
			case "kedd":
				map.put("dateKe", format.format(d.getDate()));
				break;
			case "szerda":
				map.put("dateSze", format.format(d.getDate()));
				break;
			case "csütörtök":
				map.put("dateCsu", format.format(d.getDate()));
				break;
			case "péntek":
				map.put("datePe", format.format(d.getDate()));
				break;
			case "szombat":
				map.put("dateSzo", format.format(d.getDate()));
				break;
			case "vasárnap":
				map.put("dateVa", format.format(d.getDate()));
				break;
			default:
				break;
			}
		}
		
		for(Room r:rooms) {
			col = 0;
			for(Day d:weekDays) {
				cellName = "cela" + row + col;
				for(BookingCell c:cells) {
					if(c.getDay().getName().equals(d.getName()) && c.getRoom().equals(r) && c.getCalendar().getId()!=0&&!isContain(temp, c.getCalendar().getId())) {
						map.put(cellName, c.getCalendar().getName() + "#" + c.getCalendar().getPhone());
						temp.add(c.getCalendar().getId());
						isSearch = true;
						break;
					} else if(c.getDay().getName().equals(d.getName()) && c.getRoom().equals(r) && c.getCalendar().getId()!=0&&isContain(temp, c.getCalendar().getId())) {
						map.put(cellName, "----------------------------#----------------------------");
						isSearch = true;
						break;
					}
					if(!isSearch) {
						map.put(cellName, " # ");
					}
					isSearch = false;;
				}
				col++;
				
				boolean isBook = false;
				switch (d.getName().toLowerCase()) {
				case "hétfő":
					for(Booking b:booking) {
						if(b.getDate().getTime() == d.getDate().getTime()) {
							map.put("bookingHe", b.getBed1() + "#" + b.getBed2() + "#" + b.getBed3() + "#" + b.getBed4() + "#" + b.getBedAttic2());
							isBook = true;
							break;
						}
					}
					if(!isBook) {
						map.put("bookingHe", "0#0#0#0#  0");
					}
					break;
				case "kedd":
					for(Booking b:booking) {
						if(b.getDate().getTime() == d.getDate().getTime()) {
							map.put("bookingKe", b.getBed1() + "#" + b.getBed2() + "#" + b.getBed3() + "#" + b.getBed4() + "#" + b.getBedAttic2());
							isBook = true;
							break;
						}
					}
					if(!isBook) {
						map.put("bookingKe", "0#0#0#0#  0");
					}
					break;
				case "szerda":
					for(Booking b:booking) {
						if(b.getDate().getTime() == d.getDate().getTime()) {
							map.put("bookingSze", b.getBed1() + "#" + b.getBed2() + "#" + b.getBed3() + "#" + b.getBed4() + "#" + b.getBedAttic2());
							isBook = true;
							break;
						}
					}
					if(!isBook) {
						map.put("bookingSze", "0#0#0#0#  0");
					}
					break;
				case "csütörtök":
					for(Booking b:booking) {
						if(b.getDate().getTime() == d.getDate().getTime()) {
							map.put("bookingCso", b.getBed1() + "#" + b.getBed2() + "#" + b.getBed3() + "#" + b.getBed4() + "#" + b.getBedAttic2());
							isBook = true;
							break;
						}
					}
					if(!isBook) {
						map.put("bookingCso", "0#0#0#0#  0");
					}
					break;
				case "péntek":
					for(Booking b:booking) {
						if(b.getDate().getTime() == d.getDate().getTime()) {
							map.put("bookingPe", b.getBed1() + "#" + b.getBed2() + "#" + b.getBed3() + "#" + b.getBed4() + "#" + b.getBedAttic2());
							isBook = true;
							break;
						}
					}
					if(!isBook) {
						map.put("bookingPe", "0#0#0#0#  0");
					}
					break;
				case "szombat":
					for(Booking b:booking) {
						if(b.getDate().getTime() == d.getDate().getTime()) {
							map.put("bookingSzo", b.getBed1() + "#" + b.getBed2() + "#" + b.getBed3() + "#" + b.getBed4() + "#" + b.getBedAttic2());
							isBook = true;
							break;
						}
					}
					if(!isBook) {
						map.put("bookingSzo", "0#0#0#0#  0");
					}
					break;
				case "vasárnap":
					for(Booking b:booking) {
						if(b.getDate().getTime() == d.getDate().getTime()) {
							map.put("bookingVa", b.getBed1() + "#" + b.getBed2() + "#" + b.getBed3() + "#" + b.getBed4() + "#" + b.getBedAttic2());
							isBook = true;
							break;
						}
					}
					if(!isBook) {
						map.put("bookingVa", "0#0#0#0#  0");
					}
					break;
				default:
					break;
				}
			}
			row++;
		}
		
		return map;
	}
	
	public boolean isContain(List<Integer> list, int num) {
		for(Integer l:list) {
			if(l.intValue() == num) {
				return true;
			}
		}
		
		return false;
	}
}
