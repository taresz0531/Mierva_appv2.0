package hu.tarnai.minerva.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.tarnai.minerva.entity.Ajanlat;
import hu.tarnai.minerva.enums.ErrorCodeEnum;
import hu.tarnai.minerva.utility.SqlConnector;

public class AjanlatBo extends SqlConnector {

	public int sendAjanlat(Ajanlat at){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return -9;
		}
		try{
			cstm = conn.prepareCall("{call AJANLAT_ADD(?,?,?,?,?,?,?,?,?,?,?)}");
			cstm.setString(1, "A");
			cstm.setString(2, at.getNev());
			cstm.setDate(3, new java.sql.Date(at.getTol().getTime()));
			cstm.setDate(4, new java.sql.Date(at.getIg().getTime()));
			cstm.setInt(5, at.getSzszam());
			cstm.setString(6, at.getEmail());
			cstm.setString(7, at.getMobil());
			cstm.setString(8, at.getSzoba());
			cstm.setString(9, at.getReggeli());
			cstm.setString(10, at.getMegjegyzes());
			cstm.registerOutParameter(11, java.sql.Types.INTEGER);
			
			cstm.executeUpdate();
			
			
			return cstm.getInt(11);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			return -10;
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (cstm != null) cstm.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
	
	public List<Ajanlat> getActiveBejegyzes(){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		try{
			cstm = conn.prepareCall("{call AJANLAT_GET_ACTIVE()}");
			rs = cstm.executeQuery();
			List<Ajanlat> at = new ArrayList<Ajanlat>();
			while(rs.next()){
				Ajanlat temp = new Ajanlat();
				temp.setId(rs.getInt("id"));
				temp.setEmail(rs.getString("email"));
				temp.setIg(rs.getDate("ig"));
				temp.setMegjegyzes(rs.getString("megjegyzes"));
				temp.setMobil(rs.getString("mobil"));
				temp.setNev(rs.getString("nev"));
				temp.setReggeli(rs.getString("reggeli"));
				temp.setStat(rs.getString("stat"));
				temp.setSzoba(rs.getString("szoba"));
				temp.setSzszam(rs.getInt("szszam"));
				temp.setTol(rs.getDate("tol"));
				at.add(temp);
			}
				
			return at;
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
	
	public List<Ajanlat> getRegeiBejegyzes(){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		try{
			cstm = conn.prepareCall("{call AJANLAT_GET_OLD()}");
			rs = cstm.executeQuery();
			List<Ajanlat> at = new ArrayList<Ajanlat>();
			while(rs.next()){
				Ajanlat temp = new Ajanlat();
				temp.setId(rs.getInt("id"));
				temp.setEmail(rs.getString("email"));
				temp.setIg(rs.getDate("ig"));
				temp.setMegjegyzes(rs.getString("megjegyzes"));
				temp.setMobil(rs.getString("mobil"));
				temp.setNev(rs.getString("nev"));
				temp.setReggeli(rs.getString("reggeli"));
				temp.setStat(rs.getString("stat"));
				temp.setSzoba(rs.getString("szoba"));
				temp.setSzszam(rs.getInt("szszam"));
				temp.setTol(rs.getDate("tol"));
				temp.setAutodelet(rs.getInt("autodelet"));
				temp.setValasz(rs.getString("valasz"));
				at.add(temp);
			}
				
			return at;
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
	
	public String getEmailById(int id){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		String email = new String();
	    
		try{
			cstm = conn.prepareCall("{call AJANLAT_GET_EMAIL_BY_ID(?)}");
			cstm.setInt(1, id);
			rs = cstm.executeQuery();
			
			while(rs.next()){
				email = rs.getString("email");
			}
			
				
			return email;
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
	
	public ErrorCodeEnum ajanlatSetRead(int id, String val, int autoDelet){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		try{
			cstm = conn.prepareCall("{call AJANLAT_SET_READ(?,?,?)}");
			cstm.setInt(1, id);
			cstm.setString(2, val);
			cstm.setInt(3, autoDelet);
			
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
	public List<Ajanlat> getReadBejegyzes(){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		List<Ajanlat> at = new ArrayList<Ajanlat>();
	    
		try{
			cstm = conn.prepareCall("{call AJANLAT_GET_READ()}");
			rs = cstm.executeQuery();
			
			while(rs.next()){
				Ajanlat temp = new Ajanlat();
				temp.setId(rs.getInt("id"));
				temp.setEmail(rs.getString("email"));
				temp.setIg(rs.getDate("ig"));
				temp.setMegjegyzes(rs.getString("megjegyzes"));
				temp.setMobil(rs.getString("mobil"));
				temp.setNev(rs.getString("nev"));
				temp.setReggeli(rs.getString("reggeli"));
				temp.setStat(rs.getString("stat"));
				temp.setSzoba(rs.getString("szoba"));
				temp.setSzszam(rs.getInt("szszam"));
				temp.setTol(rs.getDate("tol"));
				temp.setValasz(rs.getString("valasz"));
				temp.setAutodelet(rs.getInt("autodelet"));
				at.add(temp);
			}
				
			return at;
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
	
	public String[] getAjanlatStat(){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		String[] stat = {"",""};
	    
		try{
			cstm = conn.prepareCall("{call AJANLAT_GET_STAT()}");
			rs = cstm.executeQuery();
			
			while(rs.next()){
				stat[0] = rs.getString("ujj");
				stat[1] = rs.getString("osszes");
			}
			
				
			return stat;
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
	
	public ErrorCodeEnum delet(int id){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		try{
			cstm = conn.prepareCall("{call AJANLAT_DELET(?)}");
			cstm.setInt(1,id);
			
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
	
	public ErrorCodeEnum changeAutodelet(int id){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		try{
			cstm = conn.prepareCall("{call AJANLAT_CHANGE_AUTODELET(?)}");
			cstm.setInt(1,id);
			
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
}
