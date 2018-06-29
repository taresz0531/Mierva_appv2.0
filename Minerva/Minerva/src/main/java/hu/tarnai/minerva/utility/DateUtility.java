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
}
