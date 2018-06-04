package hu.tarnai.minerva.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GetDateByDayNameClass {
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	private DateFormat df2 = new SimpleDateFormat("EEEE");
    private Calendar cal = Calendar.getInstance();
    private DateToStringClass dateConverter = null;

    public GetDateByDayNameClass(){}
    
    public String getDateByDay(String day){
    	String currentDay = df2.format(cal.getTime());
    	int curentDayCounter = getDayCounterNumber(currentDay);
    	int dayCounter = getDayCounterNumber(day);
    	int dayDiferent = dayCounter - curentDayCounter;
    	
    	dateConverter = new DateToStringClass(df.format(cal.getTime()));
    	
    	if(dayDiferent<0){
    		dateConverter.educeDaysTheDate(dayDiferent*(-1));
    	}else{
    		dateConverter.addDaysTheDate(dayDiferent);
    	}
    	
    	String dayDate = dateConverter.getDateToString();
    	
    	return dayDate;
    }
    
    private int getDayCounterNumber(String currentDay){
    	int dayCounter = 0;
    	currentDay = currentDay.toLowerCase();
    	
    	if(currentDay.equals("hétfő")){
    		dayCounter = 0;
    	}else if(currentDay.equals("kedd")){
    		dayCounter = 1;
    	}else if(currentDay.equals("szerda")){
    		dayCounter = 2;
    	}else if(currentDay.equals("csütörtök")){
    		dayCounter = 3;
    	}else if(currentDay.equals("péntek")){
    		dayCounter = 4;
    	}else if(currentDay.equals("szombat")){
    		dayCounter = 5;
    	}else if(currentDay.equals("vasárnap")){
    		dayCounter = 6;
    	}
    	return dayCounter;
    }
}
