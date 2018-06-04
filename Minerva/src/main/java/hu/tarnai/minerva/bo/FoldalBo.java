package hu.tarnai.minerva.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.tarnai.minerva.entity.Foldal;
import hu.tarnai.minerva.enums.ErrorCodeEnum;
import hu.tarnai.minerva.enums.NyelvEnum;
import hu.tarnai.minerva.utility.SqlConnector;
import hu.tarnai.minerva.enums.ErrorCodeConverter;

public class FoldalBo extends SqlConnector {

	public ErrorCodeEnum foldalAdd(Foldal foldal){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.ERROR;
		}
		try{
			cstm = conn.prepareCall("{call FOLDAL_ADD(?,?,?,?,?,?,?)}");
			cstm.setString(1, foldal.getCim());
			cstm.setString(2, foldal.getLeiras());
			cstm.setString(3, foldal.getNyelv());
			cstm.setString(4, foldal.getDate());
			cstm.setString(5, foldal.getDateTo());
			cstm.setInt(6, foldal.getAutoOpen());
			
			cstm.registerOutParameter(7, java.sql.Types.INTEGER);
			
			cstm.executeUpdate();
			
			return ErrorCodeConverter.getErrorCode(cstm.getInt(7));
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			return ErrorCodeEnum.DBERROR;
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (cstm != null) cstm.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
	
	public List<Foldal> foldalGetAllActive(NyelvEnum leng){
		List<Foldal> foldal = new ArrayList<Foldal>();
		
		try{
			connectDB();
			cstm = conn.prepareCall("{call FOLDAL_GET_ACTIVE(?)}");
			cstm.setString(1, leng == NyelvEnum.HUN?"hun":"eng");
			rs = cstm.executeQuery();
			
			while(rs.next()){
				Foldal fl = Foldal.covertResultToFoldal(rs);
				foldal.add(fl);
			}
			
			return foldal;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (cstm != null) cstm.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
	
	public ErrorCodeEnum foldalModif(Foldal foldal,boolean isOriginal){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		try{
			cstm = conn.prepareCall("{call FOLDAL_MODIFY(?,?,?,?,?,?,?,?,?)}");
			cstm.setInt(1, foldal.getId());
			cstm.setString(2, foldal.getCim());
			cstm.setString(3, foldal.getLeiras());
			cstm.setString(4, foldal.getNyelv());
			cstm.setString(5, foldal.getDate());
			cstm.setString(6, foldal.getDateTo());
			cstm.setInt(7, foldal.getAutoOpen());
			cstm.setInt(9, isOriginal?1:0);
			
			cstm.registerOutParameter(8, java.sql.Types.INTEGER);
			
			cstm.executeUpdate();
			
			return ErrorCodeConverter.getErrorCode(cstm.getInt(8));
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
	
	public List<Foldal> foldalGetAll(){
		List<Foldal> foldal = new ArrayList<Foldal>();
		
		try{
			connectDB();
			cstm = conn.prepareCall("{call FOLDAL_GET_ALL()}");
			rs = cstm.executeQuery();
			
			while(rs.next()){
				Foldal fl = Foldal.covertResultToFoldal(rs);
				foldal.add(fl);
			}
			
			return foldal;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (cstm != null) cstm.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
	
	public ErrorCodeEnum foldalChangeStat(int id){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.ERROR;
		}
		try{
			cstm = conn.prepareCall("{call FOLDAL_CHANGE_STAT(?)}");
			cstm.setInt(1, id);
			cstm.executeUpdate();
			
			return ErrorCodeEnum.SUCCESS;
		}catch (Exception e){
			e.printStackTrace();
			return ErrorCodeEnum.ERROR;
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (cstm != null) cstm.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
	
	public ErrorCodeEnum foldalDelet(int id){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.ERROR;
		}
		try{
			cstm = conn.prepareCall("{call FOLDAL_DELET(?)}");
			cstm.setInt(1, id);
			cstm.executeUpdate();
			
			return ErrorCodeEnum.SUCCESS;
		}catch (Exception e){
			e.printStackTrace();
			return ErrorCodeEnum.ERROR;
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (cstm != null) cstm.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
}