package hu.tarnai.minerva.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hu.tarnai.minerva.entity.Booking;
import hu.tarnai.minerva.entity.Calendar;
import hu.tarnai.minerva.entity.Room;
import hu.tarnai.minerva.enums.ErrorCodeConverter;
import hu.tarnai.minerva.enums.ErrorCodeEnum;
import hu.tarnai.minerva.utility.SqlConnector;

public class SzobaBo extends SqlConnector{
	
	/*
	 * TODO Booking bo
	 */
	
	public ErrorCodeEnum bookingAdd(Booking b, Date d){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		
		try{
			cstm = conn.prepareCall("{call BOOKING_ADD(?,?,?,?,?,?,?)}");
			cstm.setDate(1, new java.sql.Date(d.getTime()));
			cstm.setInt(2, b.getBed1());
			cstm.setInt(3, b.getBed2());
			cstm.setInt(4, b.getBed3());
			cstm.setInt(5, b.getBed4());
			cstm.setInt(6, b.getBedAttic2());
			
			cstm.registerOutParameter(7, java.sql.Types.INTEGER);
			
			cstm.executeUpdate();
			
			return ErrorCodeConverter.getErrorCodeRoom(cstm.getInt(7));
	
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
	
	public List<Booking> bookingGetWeek(Date d){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		List<Booking> b = new ArrayList<Booking>();
		
		try{
			cstm = conn.prepareCall("{call BOOKING_GET_WEEK(?)}");
			cstm.setDate(1, new java.sql.Date(d.getTime()));
			
			rs = cstm.executeQuery();
			
			while(rs.next()) {
				Booking bb = new Booking();
				bb.setId(rs.getInt("id"));
				bb.setDate(new Date(rs.getDate("date").getTime()));
				bb.setBed1(rs.getInt("bed_1"));
				bb.setBed2(rs.getInt("bed_2"));
				bb.setBed3(rs.getInt("bed_3"));
				bb.setBed4(rs.getInt("bed_4"));
				bb.setBedAttic2(rs.getInt("bed_attic_2"));
				b.add(bb);
			}
			
			return b;
	
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
	
	public ErrorCodeEnum bookingModif(Booking b){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		
		try{
			cstm = conn.prepareCall("{call BOOKING_MODIF(?,?,?,?,?,?)}");
			cstm.setInt(1, b.getId());
			cstm.setInt(2, b.getBed1());
			cstm.setInt(3, b.getBed2());
			cstm.setInt(4, b.getBed3());
			cstm.setInt(5, b.getBed4());
			cstm.setInt(6, b.getBedAttic2());
			
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
	
	public ErrorCodeEnum bookingDelet(int id){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		
		try{
			cstm = conn.prepareCall("{call BOOKING_DELET(?)}");
			cstm.setInt(1, id);
			
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
	
	/*
	 * TODO Calendar bo
	 */
	
	public ErrorCodeEnum calendarAdd(Calendar c) {
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		
		try{
			cstm = conn.prepareCall("{call CALENDAR_ADD(?,?,?,?,?,?,?,?,?,?,?)}");
			cstm.setDate(1, new java.sql.Date(c.getDateFrom().getTime()));
			cstm.setDate(2, new java.sql.Date(c.getDateTo().getTime()));
			cstm.setInt(3, c.getRoomType());
			cstm.setString(4, c.getName());
			cstm.setString(5, c.getPhone());
			cstm.setInt(6, c.getAdultsNum());
			cstm.setInt(7, c.getChildrenNum());
			cstm.setString(8, c.getPayType());
			cstm.setInt(9, c.getPrice());
			cstm.setString(10, c.getComment());
			
			cstm.registerOutParameter(11, java.sql.Types.INTEGER);
			
			cstm.executeUpdate();
			
			return ErrorCodeConverter.getErrorCodeRoom(cstm.getInt(11));
	
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
	
	public List<Calendar> calendarGetWeek(Date d){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		List<Calendar> r = new ArrayList<Calendar>();
		
		try{
			cstm = conn.prepareCall("{call CALENDAR_GET_WEEK(?)}");
			cstm.setDate(1, new java.sql.Date(d.getTime()));
			
			rs = cstm.executeQuery();
			
			while(rs.next()) {
				Calendar cc = new Calendar();
				cc.setId(rs.getInt("id"));
				cc.setDateFrom(new Date(rs.getDate("date_from").getTime()));
				cc.setDateTo(new Date(rs.getDate("date_to").getTime()));
				cc.setRoomType(rs.getInt("room_type"));
				cc.setName(rs.getString("name"));
				cc.setPhone(rs.getString("phone"));
				cc.setAdultsNum(rs.getInt("adults_num"));
				cc.setChildrenNum(rs.getInt("children_num"));
				cc.setPayType(rs.getString("pay_type"));
				cc.setPrice(rs.getInt("price"));
				cc.setComment(rs.getString("comment"));
				cc.setColor(rs.getString("color"));
				r.add(cc);
			}
			
			return r;
	
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
	
	public ErrorCodeEnum calendarChange(int id, Date newDateFrom, int newRoomType){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		
		try{
			cstm = conn.prepareCall("{call CALENDAR_CHANGE_BOOK(?,?,?,?)}");
			cstm.setInt(1, id);
			cstm.setDate(2, new java.sql.Date(newDateFrom.getTime()));
			cstm.setInt(3, newRoomType);
			
			cstm.registerOutParameter(4, java.sql.Types.INTEGER);
			
			cstm.executeUpdate();
			
			return ErrorCodeConverter.getErrorCodeRoom(cstm.getInt(4));
	
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
	
	public ErrorCodeEnum calendarModif(Calendar c) {
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		
		try{
			cstm = conn.prepareCall("{call CALENDAR_ADD(?,?,?,?,?,?,?,?,?,?,?)}");
			cstm.setDate(1,  new java.sql.Date(c.getDateFrom().getTime()));
			cstm.setDate(2,  new java.sql.Date(c.getDateTo().getTime()));
			cstm.setInt(3, c.getRoomType());
			cstm.setString(4, c.getName());
			cstm.setString(5, c.getPhone());
			cstm.setInt(6, c.getAdultsNum());
			cstm.setInt(7, c.getChildrenNum());
			cstm.setString(8, c.getPayType());
			cstm.setInt(9, c.getPrice());
			cstm.setString(10, c.getComment());
			cstm.registerOutParameter(11, java.sql.Types.INTEGER);
			
			cstm.executeUpdate();
			
			return ErrorCodeConverter.getErrorCodeRoom(cstm.getInt(11));
	
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
	
	public ErrorCodeEnum calendarModifComment(int id, String comment) {
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		
		try{
			cstm = conn.prepareCall("{call CALENDAR_MODIF_COMMENT(?,?)}");
			cstm.setInt(1, id);
			cstm.setString(2, comment);
			
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
	
	public Calendar calendarGetById(int id){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		try{
			cstm = conn.prepareCall("{call CALENDAR_GET_BY_ID(?)}");
			cstm.setInt(1, id);
			
			rs = cstm.executeQuery();
			
			if(rs.next()) {
				Calendar cc = new Calendar();
				cc.setId(rs.getInt("id"));
				cc.setDateFrom(new Date(rs.getDate("date_from").getTime()));
				cc.setDateTo(new Date(rs.getDate("date_to").getTime()));
				cc.setRoomType(rs.getInt("room_type"));
				cc.setName(rs.getString("name"));
				cc.setPhone(rs.getString("phone"));
				cc.setAdultsNum(rs.getInt("adults_num"));
				cc.setChildrenNum(rs.getInt("children_num"));
				cc.setPayType(rs.getString("pay_type"));
				cc.setPrice(rs.getInt("price"));
				cc.setComment(rs.getString("comment"));
				cc.setColor(rs.getString("color"));
				return cc;
			}
			
			return null;
	
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
	
	public ErrorCodeEnum calendarDelet(int id) {
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		
		try{
			cstm = conn.prepareCall("{call CALENDAR_DELET(?)}");
			cstm.setInt(1, id);
			
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
	
	/*
	 * TODO Room bo
	 */
	
	public List<Room> roomGet(){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		List<Room> r = new ArrayList<Room>();
		
		try{
			cstm = conn.prepareCall("{call ROOM_GET()}");
			
			rs = cstm.executeQuery();
			
			while(rs.next()) {
				Room cc = new Room();
				cc.setId(rs.getInt("id"));
				cc.setName(rs.getString("name"));
				cc.setDescription(rs.getString("description"));
				cc.setType(rs.getInt("type"));
				
				r.add(cc);
			}
			
			return r;
	
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
