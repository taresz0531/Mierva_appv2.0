package hu.tarnai.minerva.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import hu.tarnai.minerva.entity.Menu;
import hu.tarnai.minerva.entity.Users;
import hu.tarnai.minerva.enums.ErrorCodeConverter;
import hu.tarnai.minerva.enums.ErrorCodeEnum;
import hu.tarnai.minerva.utility.SqlConnector;
import hu.tarnai.minerva.utility.UserSession;

public class UserBo extends SqlConnector{

	public int loginUser(String userName,String pass,  HttpServletRequest request){
		if(connectDB() == ErrorCodeEnum.ERROR){
			UserSession.setUserId(-1, request);
			return -4;
		}
		try{
			cstm = conn.prepareCall("{call USERS_LOGIN(?,?,?)}");
			cstm.setString(1, userName);
			cstm.setString(2, pass);
			cstm.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstm.executeUpdate();

			int id = cstm.getInt(3);
			if(id>-1){
				UserSession.setUserId(id, request);
				UserSession.setCurrentUser(getUser(id, request), request);
				return id;
			}else if(id == -1){
				UserSession.setUserId(-1, request);
				return id;
			}else if(id == -2){
				UserSession.setUserId(-1, request);
				return -2;
			}else{
				return -3;
			}
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			UserSession.setUserId(-1, request);
			return -5;
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (cstm != null) cstm.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
	
	public Users getUser(int id, HttpServletRequest request) {
		if(connectDB() == ErrorCodeEnum.ERROR){
			UserSession.setUserId(-1, request);
			return null;
		}
		try{
			cstm = conn.prepareCall("{call USERS_GET_USER_DATA_BY_ID(?)}");
			cstm.setInt(1, id);
			rs = cstm.executeQuery();
			
			Users u = new Users();

			if(rs.next()) {
				u.setId(rs.getInt("id"));
				u.setNev(rs.getString("nev"));
				u.setFnev(rs.getString("fnev"));
				u.setEmail(rs.getString("email"));
				u.setHkor(rs.getString("hkor"));
				u.setMenu(rs.getString("menu"));
				u.setStat(rs.getString("stat"));
			}
			return u;
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
	
	//---------------a user összes fő menüje-----------------
	public List<String> getUserMainMenus(HttpServletRequest request){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		int id = UserSession.getUserId(request);
		
		if(id<0){
			return null;
		}
		
		try{
			cstm = conn.prepareCall("{call USERS_GET_ALL_MAIN_MENU(?)}");
			cstm.setInt(1, id);
			rs = cstm.executeQuery();
			List<String> menus = new ArrayList<String>();

			while(rs.next()){
				String m = new String();
				m = rs.getString("main");
				menus.add(m);
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
	
	//---------------az összes fő menü-----------------
	public List<String> getAllMainMenus(){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		try{
			cstm = conn.prepareCall("{call MENU_GET_ALL_MAIN()}");
			rs = cstm.executeQuery();
			List<String> menus = new ArrayList<String>();

			while(rs.next()){
				String m = new String();
				m = rs.getString("main");
				menus.add(m);
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
	
	//-----------visszaadja a user összes sub menüjét
	public List<Menu> getUserSubMenus(HttpServletRequest request){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		int id = UserSession.getUserId(request);
		
		if(id<0){
			return null;
		}
		
		try{
			cstm = conn.prepareCall("{call USERS_GET_ALL_SUB_MENU(?)}");
			cstm.setInt(1, id);
			rs = cstm.executeQuery();
			List<Menu> menus = new ArrayList<Menu>();

			while(rs.next()){
				Menu m = new Menu();
				m.setNev(rs.getString("nev"));
				m.setUrl(rs.getString("url"));
				m.setMain(rs.getString("main"));
				menus.add(m);
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
	
	//-----------visszaadja az összes sub menüt
	public List<Menu> getAllSubMenus(){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		try{
			cstm = conn.prepareCall("{call MENU_GET_ALL_SUB_MENU()}");
			rs = cstm.executeQuery();
			List<Menu> menus = new ArrayList<Menu>();

			while(rs.next()){
				Menu m = new Menu();
				m.setNev(rs.getString("nev"));
				m.setUrl(rs.getString("url"));
				m.setCode(rs.getString("code"));
				m.setMain(rs.getString("main"));
				menus.add(m);
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
	
	//-----------új felhasználó------------------------------
	public int add(String nev,String menu, String email){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return -3;
		}
		
		try{
			cstm = conn.prepareCall("{call USERS_ADD_NEW(?,?,?,?)}");
			cstm.setString(1, nev);
			cstm.setString(2, menu);
			cstm.setString(3, email);
			cstm.registerOutParameter(4, java.sql.Types.INTEGER);
			
			cstm.executeUpdate();
	
			try {
				int id = cstm.getInt(4);
				return id;
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
				return -1;
			}
			
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			return -4;
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (cstm != null) cstm.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
	
	//-----------felhasználó aktiválása------------------------------
	public ErrorCodeEnum actival(int id, String fnev, String pw){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		
		try{
			cstm = conn.prepareCall("{call USER_ACTIVATE(?,?,?,?)}");
			cstm.setInt(1, id);
			cstm.setString(2, fnev);
			cstm.setString(3, pw);
			cstm.registerOutParameter(4, java.sql.Types.INTEGER);
			
			cstm.executeUpdate();
	
			return ErrorCodeConverter.getErrorCode(cstm.getInt(4));
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
	
	//-----------összes aktív felhasználó------------------------------
	public Users getUserById(int id){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		try{
			cstm = conn.prepareCall("{call USERS_GET_USER_DATA_BY_ID(?)}");
			cstm.setInt(1, id);
			rs = cstm.executeQuery();
			List<Users> users = new ArrayList<Users>();

			if(rs.next()){
				Users u = new Users();
				u.setNev(rs.getString("nev"));
				u.setFnev(rs.getString("fnev"));
				u.setEmail(rs.getString("email"));
				u.setHkor(rs.getString("hkor"));
				u.setId(rs.getInt("id"));
				u.setJelszo(rs.getString("jelszo"));
				u.setStat(rs.getString("stat"));
				u.setMenu(rs.getString("menu"));
				return u;
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
	
	//-----------összes aktív felhasználó------------------------------
	public List<Users> getActive(int id){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		try{
			cstm = conn.prepareCall("{call USERS_GET_ACTIVE(?)}");
			cstm.setInt(1, id);
			rs = cstm.executeQuery();
			List<Users> users = new ArrayList<Users>();

			while(rs.next()){
				Users u = new Users();
				u.setNev(rs.getString("nev"));
				u.setFnev(rs.getString("fnev"));
				u.setEmail(rs.getString("email"));
				u.setHkor(rs.getString("hkor"));
				u.setId(rs.getInt("id"));
				u.setJelszo(rs.getString("jelszo"));
				u.setStat(rs.getString("stat"));
				u.setMenu(rs.getString("menu"));
				users.add(u);
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
	
	//-----------összes felhasználó------------------------------
	public List<Users> getAll(int id){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		try{
			cstm = conn.prepareCall("{call USERS_GET_ALL(?)}");
			cstm.setInt(1, id);
			rs = cstm.executeQuery();
			List<Users> users = new ArrayList<Users>();

			while(rs.next()){
				Users u = new Users();
				u.setNev(rs.getString("nev"));
				u.setFnev(rs.getString("fnev"));
				u.setEmail(rs.getString("email"));
				u.setHkor(rs.getString("hkor"));
				u.setId(rs.getInt("id"));
				u.setJelszo(rs.getString("jelszo"));
				u.setStat(rs.getString("stat"));
				u.setMenu(rs.getString("menu"));
				users.add(u);
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
	
	//-----------felhasználó funkció módosít------------------------------
	public ErrorCodeEnum menuModif(int id, String menus){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		
		try{
			cstm = conn.prepareCall("{call USERS_MODIF_MENU(?,?)}");
			cstm.setInt(1, id);
			cstm.setString(2, menus);
			
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
	
	//-----------felhasználó státusz csere------------------------------
	public ErrorCodeEnum changeStat(int id){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		
		try{
			cstm = conn.prepareCall("{call USERS_CHANGE_STAT(?)}");
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
	
	//---------------------felhasználó módosít--------------------------
	public ErrorCodeEnum dataModif(int id, String fnev, String pw, boolean isNew){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		
		try{
			cstm = conn.prepareCall("{call USERS_MODIF_DATA(?,?,?,?,?)}");
			cstm.setInt(1, id);
			cstm.setString(2, fnev);
			cstm.setString(3, pw);
			cstm.setString(4, isNew?"i":"n");
			cstm.registerOutParameter(5, java.sql.Types.INTEGER);
			
			cstm.executeUpdate();
	
			return ErrorCodeConverter.getErrorCode(cstm.getInt(5));
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
