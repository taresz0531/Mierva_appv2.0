package hu.tarnai.minerva.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import hu.tarnai.minerva.entity.Permission;
import hu.tarnai.minerva.enums.ErrorCodeEnum;
import hu.tarnai.minerva.utility.SqlConnector;
import hu.tarnai.minerva.utility.UserSession;

public class PermissionBo extends SqlConnector{

	public List<Permission> getAll() {
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		try{
			cstm = conn.prepareCall("{call PERMISSION_GAT_ALL()}");
			rs = cstm.executeQuery();
			
			List<Permission> perm = new ArrayList<Permission>();

			while(rs.next()) {
				Permission p = new Permission();
				p.setId(rs.getInt("id"));
				p.setMenuCode(rs.getInt("menu_code"));
				p.setDescription(rs.getString("description"));
				perm.add(p);
			}
			return perm;
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
	
	public Permission getById(int id) {
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		try{
			cstm = conn.prepareCall("{call PERMISSION_GET_BY_ID(?)}");
			cstm.setInt(1, id);
			rs = cstm.executeQuery();
			

			if(rs.next()) {
				Permission p = new Permission();
				p.setId(rs.getInt("id"));
				p.setMenuCode(rs.getInt("menu_code"));
				p.setDescription(rs.getString("description"));
				return p;
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
	
	public String getByUser(int userId) {
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		try{
			cstm = conn.prepareCall("{call PERMISSION_GET_BY_USER(?)}");
			cstm.setInt(1, userId);
			rs = cstm.executeQuery();
			

			if(rs.next()) {
				String p = rs.getString("permission");
				return p;
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
}
