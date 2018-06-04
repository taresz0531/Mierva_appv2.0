package hu.tarnai.minerva.utility;

import java.util.HashMap;

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
}
