package hu.tarnai.minerva.bo;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hu.tarnai.minerva.enums.ErrorCodeEnum;
import hu.tarnai.minerva.objects.EventLogObject;
import hu.tarnai.minerva.objects.EventLogUsers;
import hu.tarnai.minerva.utility.SqlConnector;
import hu.tarnai.minerva.utility.StringValidator;

public class EventLogBo  extends SqlConnector{
	private static int ONE_YEAR = 365*24*60*60*100;
	
	public ErrorCodeEnum add(int userId, String event) {
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		
		try{
			cstm = conn.prepareCall("{call EVENTLOG_ADD(?,?)}");
			cstm.setInt(1,userId);
			cstm.setString(2, event);
			
			cstm.executeUpdate();
			
			
			return ErrorCodeEnum.SUCCESS;
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			return ErrorCodeEnum.ERROR;
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (cstm != null) cstm.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
	
	public List<EventLogUsers> getUserList() {
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		List<EventLogUsers> users = new ArrayList<EventLogUsers>();
		
		try{
			cstm = conn.prepareCall("{call EVENTLOG_GET_ALL_USER()}");
			
			rs = cstm.executeQuery();
			
			while(rs.next()) {
				users.add(new EventLogUsers(rs.getInt("userId"), rs.getString("nev")));
			}
			
			
			return users;
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			return null;
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (cstm != null) cstm.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
	
	public List<EventLogObject> getAll(String tol, String ig) {
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		List<EventLogObject> events = new ArrayList<EventLogObject>();
		
		try{
			cstm = conn.prepareCall("{call EVENTLOG_GET_ALL(?,?)}");
			if(StringValidator.isNotEmpty(tol)) {
				cstm.setString(1,format.format(format.parse(tol)));
			}else {
				cstm.setString(1, format.format(new Date().getTime() - ONE_YEAR));
			}
			
			if(StringValidator.isNotEmpty(ig)) {
				cstm.setString(2, format.format(format.parse(ig)));
			}else {
				cstm.setString(2, format.format(new Date().getTime()));
			}
			
			rs = cstm.executeQuery();
			
			while(rs.next()) {
				events.add(new EventLogObject(rs.getInt("userId"), rs.getString("nev"), format.format(new Date(rs.getDate("date").getTime())),rs.getString("event")));
			}
			
			return events;
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			return null;
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (cstm != null) cstm.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
	
	public List<EventLogObject> getAllEventForUser(int id, String tol, String ig) {
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		List<EventLogObject> events = new ArrayList<EventLogObject>();
		
		try{
			cstm = conn.prepareCall("{call EVENTLOG_GET_USER_LOG(?,?,?)}");
			cstm.setInt(1, id);
			if(StringValidator.isNotEmpty(tol)) {
				cstm.setDate(2, new java.sql.Date(format.parse(tol).getTime()));
			}else {
				cstm.setString(2, "0000-00-00 00:00:00");
			}
			
			if(StringValidator.isNotEmpty(ig)) {
				cstm.setDate(3, ig!=null?new java.sql.Date(format.parse(ig).getTime()):null);
			}else {
				cstm.setString(3, "0000-00-00 00:00:00");
			}
			
			rs = cstm.executeQuery();
			
			while(rs.next()) {
				events.add(new EventLogObject(rs.getInt("userId"), rs.getString("nev"), format.format(new Date(rs.getDate("date").getTime())),rs.getString("event")));
			}
			
			
			return events;
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			return null;
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (cstm != null) cstm.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
}
