package hu.tarnai.minerva.languages;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.util.ResourceUtils;

import hu.tarnai.minerva.enums.NyelvEnum;


public class LangSetter {
	private HashMap<String, String> langMap;

	public LangSetter(NyelvEnum nyelv) {
		String pre = "";
		if(nyelv == NyelvEnum.HUN) {
			pre = "hun";
		}else {
			pre = "eng";
		}
		
		langMap = new HashMap<String, String>();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(ResourceUtils.getFile("classpath:static/properties/" + pre + ".lang")), "UTF-8"));
			String line = reader.readLine();
			
			while(line != null) {
				if(line.split("=").length>1) {
					langMap.put(line.split("=")[0], line.split("=")[1]);
				}
				line = reader.readLine();
			}
			
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void set(HttpSession session, NyelvEnum nyelv) {
		LangSetter lang = new LangSetter(nyelv);
		for(String key:lang.langMap.keySet()) {
			session.setAttribute(key, lang.getHun().get(key));
		}
	}

	public HashMap<String, String> getHun() {
		return langMap;
	}

	public void setHun(HashMap<String, String> hun) {
		this.langMap = hun;
	}
	
	
	
	
}
