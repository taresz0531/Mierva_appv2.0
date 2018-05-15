package hu.tarnai.minerva.objects;

import java.util.ArrayList;
import java.util.List;

import hu.tarnai.minerva.bo.HetimenuBo;
import hu.tarnai.minerva.entity.Napimenu;
import hu.tarnai.minerva.utility.GetDateByDayNameClass;

public class HetimenuObject {
	
	public String date;
	public Napimenu napimenu;
	public String dayName;
	
	public static List<HetimenuObject> get(){
		GetDateByDayNameClass dateNameConverter = new GetDateByDayNameClass();
		HetimenuBo bo = new HetimenuBo();
		List<Napimenu> heti = bo.getActual();
		List<HetimenuObject> hObj = new ArrayList<HetimenuObject>();
		String date;
		String dayName;
		
		for(Napimenu n : heti){
			HetimenuObject h = new HetimenuObject();
			
			if(n.getNap().contains("2")){
				dayName = n.getNap().substring(0, n.getNap().length()-1);
			}else{
				dayName = n.getNap();
			}
			date = dateNameConverter.getDateByDay(dayName);
			
			h.setDate(date);
			h.setDayName(dayName);
			h.setNapimenu(n);
			hObj.add(h);
		}
		
		return hObj;
	}
	
	public static HetimenuObject getCurrentDayMenu(){
		GetDateByDayNameClass dateNameConverter = new GetDateByDayNameClass();
		HetimenuBo bo = new HetimenuBo();
		Napimenu heti = bo.getCurrentDayMenu();
		HetimenuObject hObj = new HetimenuObject();
		String date;
		String dayName;
		
		if(heti!=null){
			if(heti.getNap().contains("2")){
				dayName = heti.getNap().substring(0, heti.getNap().length()-1);
			}else{
				dayName = heti.getNap();
			}
			date = dateNameConverter.getDateByDay(dayName);
			
			hObj.setDate(date);
			hObj.setDayName(dayName);
			hObj.setNapimenu(heti);
			return hObj;
		}else{
			return null;
		}
		
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Napimenu getNapimenu() {
		return napimenu;
	}

	public void setNapimenu(Napimenu napimenu) {
		this.napimenu = napimenu;
	}

	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}
	
}
