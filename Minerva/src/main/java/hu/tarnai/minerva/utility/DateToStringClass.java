package hu.tarnai.minerva.utility;

import java.util.ArrayList;
import java.util.List;

public class DateToStringClass {
	private String ev;
	private String ho;
	private String nap;
	
	public DateToStringClass(String date){
		String[] temp = date.split("-");
		ev = new String(temp[0]);
		ho = new String(temp[1]);
		nap = new String(temp[2]);
	}
	
	public DateToStringClass(){
	}
	
	public String addDaysTheDate(int days){
		int nap = getNapInt();
		int ho = getHoInt();
		int ev = getEvInt();
		
		
		if((nap+days)<getMonthDaysNum(ho, ev) && days<28){
			nap += days;
		}else{
			if(ho<12){
				ho += 1;
				nap = (getMonthDaysNum((ho-1)>=1?ho-1:12, ev)-(nap += days))*(-1);
			}
			else{
				ev +=1;
				ho = 1;
				nap = (getMonthDaysNum(12, ev)-(nap += days))*(-1);
			}
		}
		
		this.ev = String.valueOf(ev);
		this.ho = ho<10?"0" + String.valueOf(ho):String.valueOf(ho);
		this.nap = nap<10?"0" + String.valueOf(nap):String.valueOf(nap);
		
		return creatStringInIntDate(ev, ho, nap);
	}
	
	public String educeDaysTheDate(int days){
		int nap = getNapInt();
		int ho = getHoInt();
		int ev = getEvInt();
		
		
		if((nap-days)>1 && days<28){
			nap -= days;
		}else{
			if(ho>1){
				ho -= 1;
				nap = getMonthDaysNum(ho, ev)+(nap-days);
			}
			else{
				ev -=1;
				ho = 12;
				nap = getMonthDaysNum(ho, ev)+(nap-days);
			}
		}
		this.ev = String.valueOf(ev);
		this.ho = ho<10?"0" + String.valueOf(ho):String.valueOf(ho);
		this.nap = nap<10?"0" + String.valueOf(nap):String.valueOf(nap);
		
		return creatStringInIntDate(ev, ho, nap);
	}
	
	public int getMonthDaysNum(int mo,int ev){
		if(mo==1||mo==3||mo==5||mo==7||mo==8||mo==10||mo==12){
			return 31;
		}else if(mo==4||mo==6||mo==9||mo==11){
			return 30;
		}else{
			if(ev%400==0){
				return 29;
			}
			else if(ev%100!=0&&ev%4==0){
				return 29;
			}
			else{
				return 28;
			}
		}
	}
	
	public String creatStringInIntDate(int ev,int ho,int nap){
		String date = new String(String.valueOf(ev));
		if(ho<10){
			date = date + "-0" + ho;
		}
		else{
			date = date + "-" + ho;
		}
		
		if(nap<10){
			date = date + "-0" + nap;
		}
		else{
			date = date + "-" + nap;
		}
		
		return date;
	}
	
	public String convertEnglisDayToHungary(String day){
		if(day.contains("Monday")){
			return day.replaceAll("Monday", "Hétfő");
		}else if(day.contains("Tuesday")){
			return day.replaceAll("Tuesday", "Kedd");
		}else if(day.contains("Wednesday")){
			return day.replaceAll("Wednesday", "Szerda");
		}else if(day.contains("Thursday")){
			return day.replaceAll("Thursday", "Csütörtök");
		}else if(day.contains("Friday")){
			return day.replaceAll("Friday", "Péntek");
		}else if(day.contains("Saturday")){
			return day.replaceAll("Saturday", "Szombat");
		}else if(day.contains("Monday")){
			return day.replaceAll("Sunday", "Vasárnap");
		}else{
			return day;
		}
	}
	
	public static List<String> getDaysName(){
		List<String> days = new ArrayList<String>();
		
		days.add("Hétfő");
		days.add("Kedd");
		days.add("Szerda");
		days.add("Csütörtök");
		days.add("Péntek");
		days.add("Szombat");
		days.add("Vasárnap");
		
		return days;
	}
	
	public String getDateToString(){
		return creatStringInIntDate(getEvInt(),getHoInt(),getNapInt());
	}
	
	public int getEvInt(){
		return Integer.parseInt(ev);
	}
	
	public int getHoInt(){
		return Integer.parseInt(ho);
	}
	
	public int getNapInt(){
		return Integer.parseInt(nap);
	}
	
	public String getEvString(){
		return ev;
	}
	
	public String getHoString(){
		return ho;
	}
	
	public String getNapString(){
		return nap;
	}
}
