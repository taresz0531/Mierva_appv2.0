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
    
    public String getMonthName(String m) {
    	if("01".equals(m)) {
    		return "január";
    	} else if("02".equals(m)) {
    		return "február";
    	} else if("03".equals(m)) {
    		return "március";
    	} else if("04".equals(m)) {
    		return "április";
    	} else if("05".equals(m)) {
    		return "május";
    	} else if("06".equals(m)) {
    		return "június";
    	} else if("07".equals(m)) {
    		return "július";
    	} else if("08".equals(m)) {
    		return "augusztus";
    	} else if("09".equals(m)) {
    		return "szeptember";
    	} else if("10".equals(m)) {
    		return "október";
    	} else if("11".equals(m)) {
    		return "november";
    	} else if("12".equals(m)) {
    		return "december";
    	}else {
    		return m;
    	}
    }
    
    public String getPosFixDate(int d) {
    	if(d==2||d==3||d==6||d==8||d==13||d==16||d==18||d==20||d==23||d==26||d==28||d==30) {
    		return "-tól";
    	}else {
    		return "-től";
    	}
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
