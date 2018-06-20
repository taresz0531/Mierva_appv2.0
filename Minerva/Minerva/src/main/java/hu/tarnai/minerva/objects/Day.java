package hu.tarnai.minerva.objects;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Day{

	public String name;
	public Date date = new Date();
	
	public Day(String name, Date date) {
		this.name = name;
		this.date = date;
	}
	
	public Day(Date date) {
		this.name = getDayName(date);
		this.date = date;
	}
	
	public static boolean isIntervalDay(Date df, Date dt, Date d) {
		if(d.compareTo(df)>=0 && d.compareTo(dt)<=0) {
			return true;
		}
		return false;
	}
	
	public static boolean isWeekDay(Date wd, Date d) {
		List<Day> days = Day.getWeekDays(wd);
		
		for(Day dd:days) {
			if(dd.equals(d)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static List<Day> getWeekDays(Date c){
		
		List<Day> days = new ArrayList<Day>();
		
		int dayNum = c.getDay()-1;
		if(c.getDay() == 0) {
			dayNum = 6;
		}
		Date curentDate = new Date(c.getTime() -dayNum*(24*60*60*1000));
		
		for(int i=0;i<7;i++){
			Date temp = new Date(curentDate.getTime());
			temp.setTime(temp.getTime() + i*(24*60*60*1000));
			switch (i) {
				case 0:{
					days.add(new Day("Hétfő",temp));
					break;
				}
				case 1:{
					days.add(new Day("Kedd",temp));
					break;
				}
				case 2:{
					days.add(new Day("Szerda",temp));
					break;
				}
				case 3:{
					days.add(new Day("Csütörtök",temp));
					break;
				}
				case 4:{
					days.add(new Day("Péntek",temp));
					break;
				}
				case 5:{
					days.add(new Day("Szombat",temp));
					break;
				}
				case 6:{
					days.add(new Day("Vasárnap",temp));
					break;
				}
			}
		}
		
		return days;
	}
	
	public static String getDayName(Date c) {
		int dayNum = c.getDay();
		
		switch (dayNum) {
		case 1:{
			return "Hétfő";
		}
		case 2:{
			return "Kedd";
		}
		case 3:{
			return "Szerda";
		}
		case 4:{
			return "Csütörtök";
		}
		case 5:{
			return "Péntek";
		}
		case 6:{
			return "Szomba";
		}
		case 7:{
			return "Vasárnap";
		}
		default :
			return "";			
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
}
