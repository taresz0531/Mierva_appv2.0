package hu.tarnai.minerva.utility;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hu.tarnai.minerva.objects.EventLogObject;

public class JsonCreator {
	private static String A = "\"";
	public static String jsonBuilder(HashMap<String, Object> map) {
		String json = "{";
		for(String key:map.keySet()) {
			Object value = map.get(key);
			json = json + A + key + A + ":" + value + ",";
		}
		if(json.length()>2){
			json = json.substring(0, json.length()-1);
		}
		json = json + "}";
		return json;
	}
	
	public static String creatJsonArrayFromList(List<EventLogObject> list) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			return mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			System.out.println("json converter error: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}
