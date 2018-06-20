package hu.tarnai.minerva.objects;

public class EventLogObject {
	public int id;
	public String name;
	public String date;
	public String event;
	
	public EventLogObject(int id, String name, String date, String event) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.event = event;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
}
