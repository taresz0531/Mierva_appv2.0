package hu.tarnai.minerva.utility;

import java.util.Date;

public class DateUtility {
	
	private static long ONE_DAY = (long) (24*60*60*1000);
	
	public static boolean isOlderThanCurrently(Date date, int days) {
		if(date.getTime() < (new Date().getTime() - (ONE_DAY * (long)days))) {
			return true;
		}
		
		return false;
	}
	
	public static String convertHungariDayToEnglish(String day){
		if(day.toLowerCase().contains("hétfő")){
			return "Monday";
		}else if(day.toLowerCase().contains("kedd")){
			return "Tuesday";
		}else if(day.toLowerCase().contains("szerda")){
			return "Wednesday";
		}else if(day.toLowerCase().contains("csütörtök")){
			return "Thursday";
		}else if(day.toLowerCase().contains("péntek")){
			return "Friday";
		}else if(day.toLowerCase().contains("szombat")){
			return "Saturday";
		}else if(day.toLowerCase().contains("vasárnap")){
			return "Sunday";
		}else{
			return day;
		}
	}
}
