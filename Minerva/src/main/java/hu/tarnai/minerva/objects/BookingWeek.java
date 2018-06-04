package hu.tarnai.minerva.objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hu.tarnai.minerva.bo.SzobaBo;
import hu.tarnai.minerva.entity.Booking;
import hu.tarnai.minerva.entity.Calendar;
import hu.tarnai.minerva.entity.Room;

public class BookingWeek {

	public List<BookingCell> cells = new ArrayList<BookingCell>();
	public List<Booking> books = new ArrayList<Booking>();
	public List<Calendar> calendars = new ArrayList<Calendar>();
	public List<Room> rooms = new ArrayList<Room>();
	public List<Day> weekDays = new ArrayList<Day>();
	public SzobaBo bo = new SzobaBo();
	
	public BookingWeek(Date now) {
		books = bo.bookingGetWeek(now);
		calendars = bo.calendarGetWeek(now);
		rooms = bo.roomGet();
		weekDays = Day.getWeekDays(now);
	}
	
	public List<BookingCell> getCells(){
		for(Day d:weekDays) {
			for(Room r:rooms) {
				 BookingCell c = new BookingCell(d.getDate());
				 c.setRoom(r);
				 cells.add(c);
			}
		}
		
		for(int i=0;i<cells.size();i++) {
			BookingCell c = cells.get(i);
			for(Calendar cal:calendars) {
				if(Day.isIntervalDay(cal.getDateFrom(), cal.getDateTo(), c.getDay().getDate())&&c.getRoom().getType()==cal.getRoomType()) {
					cells.get(i).setCalendar(cal);
				}
			}
		}
		
		return cells;
	}

	public List<Booking> getBooks() {
		return books;
	}

	public void setBooks(List<Booking> books) {
		this.books = books;
	}

	public List<Calendar> getCalendars() {
		return calendars;
	}

	public void setCalendars(List<Calendar> calendars) {
		this.calendars = calendars;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public List<Day> getWeekDays() {
		return weekDays;
	}

	public void setWeekDays(List<Day> weekDays) {
		this.weekDays = weekDays;
	}
}
