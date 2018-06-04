package hu.tarnai.minerva.objects;

import java.util.Date;

import hu.tarnai.minerva.entity.Calendar;
import hu.tarnai.minerva.entity.Room;

public class BookingCell {

	public Room room = new Room();
	public Day day;
	public Calendar calendar = new Calendar();
	
	public BookingCell(Date c) {
		this.day = new Day(c);
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

}
