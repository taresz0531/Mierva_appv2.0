package hu.tarnai.minerva.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.tarnai.minerva.entity.Napimenu;
import hu.tarnai.minerva.enums.ErrorCodeEnum;
import hu.tarnai.minerva.utility.SqlConnector;

public class HetimenuBo extends SqlConnector{
	
	public List<Napimenu> getActual(){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		List<Napimenu> menus = new ArrayList<Napimenu>();
		try{
			cstm = conn.prepareCall("{call NAPIMENU_GET_CURRENT_WEEK()}");
			
			rs = cstm.executeQuery();
			
			while(rs.next()){
				Napimenu nm = new Napimenu();
				nm.setLeves(rs.getString("leves"));
				nm.setFoetel(rs.getString("foetel"));
				nm.setKoret(rs.getString("koret"));
				nm.setNap(getDayName(rs.getString("nap")));
				nm.setId(rs.getInt("id"));
				menus.add(nm);
			}
			
			
			return menus;
			
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
	
	public List<Napimenu> getNext(){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		List<Napimenu> menus = new ArrayList<Napimenu>();
		try{
			cstm = conn.prepareCall("{call NAPIMENU_GET_NEXT_WEEK()}");
			
			rs = cstm.executeQuery();
			
			while(rs.next()){
				Napimenu nm = new Napimenu();
				nm.setLeves(rs.getString("leves"));
				nm.setFoetel(rs.getString("foetel"));
				nm.setKoret(rs.getString("koret"));
				nm.setNap(getDayName(rs.getString("nap")));
				nm.setId(rs.getInt("id"));
				menus.add(nm);
			}
			
			
			return menus;
			
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
	
	public Napimenu getCurrentDayMenu(){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		Napimenu n = new Napimenu();
		
		try{
			cstm = conn.prepareCall("{call NAPIMENU_GET_CURRENT_DAY_MENU()}");
			
			rs = cstm.executeQuery();
			
			try{
				while(rs.next()){
					n.setLeves(rs.getString("leves"));
					n.setFoetel(rs.getString("foetel"));
					n.setKoret(rs.getString("koret"));
					n.setNap(getDayName(rs.getString("nap")));
					n.setId(rs.getInt("id"));
				}
				return n;
			}catch(SQLException s){
				return null;
			}
			
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
	
	public int getCurrentWeekNum(){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return -1;
		}
		
		
		try{
			cstm = conn.prepareCall("{call NAPIMENU_GET_ACTUAL_WEEK_NUM()}");
			
			rs = cstm.executeQuery();
			
			if(rs.next()){
				return rs.getInt("aktual");
			}
			return -1;
			
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			return -1;
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (cstm != null) cstm.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
	
	public ErrorCodeEnum setDayMenu(Napimenu menu){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		
		try{
			cstm = conn.prepareCall("{call NAPIMENU_SET_DAY_MENU(?,?,?,?)}");
			cstm.setString(1, menu.getNap());
			cstm.setString(2, menu.getLeves());
			cstm.setString(3, menu.getFoetel());
			cstm.setString(4, menu.getKoret());
			
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
	
	public ErrorCodeEnum saveWeekDays(List<Napimenu> menus, boolean isCurrent){
		int currentWeekNum = getCurrentWeekNum();
		
		if(currentWeekNum<0){
			return ErrorCodeEnum.ERROR;
		}
		
		if(currentWeekNum==2 && isCurrent){
			for(int i=0;i<menus.size();i++){
				menus.get(i).nap = menus.get(i).nap + "2";
			}
		}else if(currentWeekNum==1&&!isCurrent){
			for(int i=0;i<menus.size();i++){
				menus.get(i).nap = menus.get(i).nap + "2";
			}
		}
		
		String daysConCut = "";
		
		for(int i=0;i<menus.size();i++){
			daysConCut += menus.get(i).nap + (i<menus.size()-1?",":"");
		}
		
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		try{
			cstm = conn.prepareCall("{call NAPIMENU_UPDATE_WEEK_DAYS(?,?)}");
			cstm.setString(1, daysConCut);
			cstm.setString(2, isCurrent?"c":"n");
			
			cstm.executeUpdate();
			
			for(Napimenu n:menus){
				setDayMenu(n);
			}
			
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
	
	public static String getDayName(String day){
		if(day.equals("Hétfő2")){
			return ("Hétfő");
		}else if(day.equals("Kedd2")){
			return ("Kedd");
		}else if(day.equals("Szerda2")){
			return ("Szerda");
		}else if(day.equals("Csütörtök2")){
			return ("Csütörtök");
		}else if(day.equals("Péntek2")){
			return ("Péntek");
		}else if(day.equals("Szombat2")){
			return ("Szombat");
		}else if(day.equals("Vasárnap2")){
			return ("Vasárnap");
		}else{
			return day;
		}
	}

}
