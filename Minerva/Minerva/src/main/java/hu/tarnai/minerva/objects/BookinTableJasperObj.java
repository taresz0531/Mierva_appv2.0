package hu.tarnai.minerva.objects;

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
		int row = 0;
		int col = 0;
		String cellName = "";
		boolean isSearch = false;
		
		for(Room r:rooms) {
			for(Day d:weekDays) {
				cellName = "cela" + row + col;
				for(BookingCell c:cells) {
					if(c.getDay().getName().equals(d.getName()) && c.getRoom().equals(r)) {
						map.put(cellName, c.getCalendar().getName() + "#" + c.getCalendar().getPhone());
						isSearch = true;
						break;
					}
					if(!isSearch) {
						map.put(cellName, "");
					}
					col++;
					isSearch = false;;
				}
				row++;
				
				switch (d.getName().toLowerCase()) {
				case "hétfő":
					for(Booking b:booking) {
						if(b.getDate().getTime() == d.getDate().getTime()) {
							map.put("bookingHe", b.getBed1() + "#" + b.getBed2() + "#" + b.getBed3() + "#" + b.getBed4() + "#" + b.getBedAttic2());
							break;
						}
					}
					break;
				case "kedd":
					for(Booking b:booking) {
						if(b.getDate().getTime() == d.getDate().getTime()) {
							map.put("bookingKe", b.getBed1() + "#" + b.getBed2() + "#" + b.getBed3() + "#" + b.getBed4() + "#" + b.getBedAttic2());
							break;
						}
					}
					break;
				case "szerda":
					for(Booking b:booking) {
						if(b.getDate().getTime() == d.getDate().getTime()) {
							map.put("bookingSze", b.getBed1() + "#" + b.getBed2() + "#" + b.getBed3() + "#" + b.getBed4() + "#" + b.getBedAttic2());
							break;
						}
					}
					break;
				case "csütörtök":
					for(Booking b:booking) {
						if(b.getDate().getTime() == d.getDate().getTime()) {
								map.put("bookingCso", b.getBed1() + "#" + b.getBed2() + "#" + b.getBed3() + "#" + b.getBed4() + "#" + b.getBedAttic2());
								break;
						}
					}
					break;
				case "péntek":
					for(Booking b:booking) {
						if(b.getDate().getTime() == d.getDate().getTime()) {
							map.put("bookingPe", b.getBed1() + "#" + b.getBed2() + "#" + b.getBed3() + "#" + b.getBed4() + "#" + b.getBedAttic2());
							break;
						}
					}
					break;
				case "szombat":
					for(Booking b:booking) {
						if(b.getDate().getTime() == d.getDate().getTime()) {
							map.put("bookingSzo", b.getBed1() + "#" + b.getBed2() + "#" + b.getBed3() + "#" + b.getBed4() + "#" + b.getBedAttic2());
							break;
						}
					}
					break;
				case "vasárnap":
					for(Booking b:booking) {
						if(b.getDate().getTime() == d.getDate().getTime()) {
							map.put("bookingVa", b.getBed1() + "#" + b.getBed2() + "#" + b.getBed3() + "#" + b.getBed4() + "#" + b.getBedAttic2());
							break;
						}
					}
					break;
				default:
					break;
				}
			}
		}
		
		return map;
	}
}
