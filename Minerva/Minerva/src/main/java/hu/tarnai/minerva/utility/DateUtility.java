package hu.tarnai.minerva.utility;

import java.util.Date;

public class DateUtility {
	
	private static int ONE_DAY = 24*60*60*1000;
	
	public static boolean isOlderThanCurrently(Date date, int days) {
		if(date.getTime() < (ONE_DAY * days)) {
			return true;
		}
		
		return false;
	}
}
