package hu.tarnai.minerva.utility;

import javax.servlet.http.HttpServletRequest;

import hu.tarnai.minerva.bo.EventLogBo;

public class EventLogger {

	public static void add(String event, HttpServletRequest request) {
		EventLogBo bo = new EventLogBo();
		bo.add(UserSession.getUserId(request), event);
	}
}
