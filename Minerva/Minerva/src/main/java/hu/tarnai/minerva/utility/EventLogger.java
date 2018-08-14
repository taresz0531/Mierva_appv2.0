package hu.tarnai.minerva.utility;

import javax.servlet.http.HttpServletRequest;

import hu.tarnai.minerva.bo.EventLogBo;
import hu.tarnai.minerva.enums.EventLogEnum;

public class EventLogger {

	public static void add(String event, HttpServletRequest request, EventLogEnum type) {
		String prefix = "[SUCCESS] ";
		if(type == EventLogEnum.SUCCESS) {
			prefix = "[SUCCESS] ";
		}else if(type == EventLogEnum.ERROR) {
			prefix = "[ERROR] ";
		}else if(type == EventLogEnum.WARNING) {
			prefix = "[WARNING] ";
		}
		
		EventLogBo bo = new EventLogBo();
		bo.add(UserSession.getUserId(request), prefix + event);
	}
}
