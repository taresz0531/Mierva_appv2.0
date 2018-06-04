package hu.tarnai.minerva.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.tarnai.minerva.entity.Galeria;
import hu.tarnai.minerva.enums.ErrorCodeConverter;
import hu.tarnai.minerva.enums.ErrorCodeEnum;
import hu.tarnai.minerva.utility.SqlConnector;

public class GalleryBo extends SqlConnector{

	public List<Galeria> getAll(){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		try{
			cstm = conn.prepareCall("{call GALERIA_GET_ALL()}");
			rs = cstm.executeQuery();
			List<Galeria> at = new ArrayList<Galeria>();
			while(rs.next()){
				Galeria temp = new Galeria();
				temp.setId(rs.getInt("id"));
				temp.setLeiras(rs.getString("leiras"));
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
	
	public ErrorCodeEnum add(Galeria galeria){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		
		try{
			cstm = conn.prepareCall("{call GALERIA_ADD_NEW(?,?,?,?)}");
			cstm.setString(1, galeria.getNev());
			cstm.setString(2, galeria.getLeiras());
			cstm.setBytes(3, galeria.getKep());
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
	
	public ErrorCodeEnum delet(int id){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		
		try{
			cstm = conn.prepareCall("{call GALERIA_DELET(?)}");
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
}
