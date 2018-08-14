package hu.tarnai.minerva.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import hu.tarnai.minerva.entity.Etlap;
import hu.tarnai.minerva.entity.Etlapkategoria;
import hu.tarnai.minerva.entity.Foldal;
import hu.tarnai.minerva.enums.ErrorCodeConverter;
import hu.tarnai.minerva.enums.ErrorCodeEnum;
import hu.tarnai.minerva.enums.EventLogEnum;
import hu.tarnai.minerva.utility.EventLogger;
import hu.tarnai.minerva.utility.SqlConnector;

public class EtlapBo extends SqlConnector{
	
	public ErrorCodeEnum add(Etlap etlap, HttpServletRequest request){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		try{
			cstm = conn.prepareCall("{call ETLAP_ADD(?,?,?,?,?,?,?)}");
			cstm.setString(1, etlap.getNev());
			cstm.setInt(2, etlap.getKategoria());
			cstm.setString(3, etlap.getLeiras());
			cstm.setBytes(4, etlap.getKep());
			cstm.setInt(5, etlap.getIs_kep());
			cstm.setString(6, etlap.getAr());
			
			cstm.registerOutParameter(7, java.sql.Types.INTEGER);
			
			cstm.executeUpdate();
			
			EventLogger.add("Étlap mentés: " + etlap.getNev(), request, EventLogEnum.SUCCESS);
			
			return ErrorCodeConverter.getErrorCode(cstm.getInt(7));
		}catch (Exception e){
			e.printStackTrace();
			EventLogger.add("Étlap mentés: " + etlap.getNev(), request, EventLogEnum.ERROR);
			return ErrorCodeEnum.ERROR;
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (cstm != null) cstm.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
	
	public ErrorCodeEnum delet(int id, HttpServletRequest request){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		try{
			cstm = conn.prepareCall("{call ETLAP_DELET(?)}");
			cstm.setInt(1, id);
			
			cstm.executeUpdate();
			
			EventLogger.add("Étlap törlés: " + id, request, EventLogEnum.SUCCESS);
			
			return ErrorCodeEnum.SUCCESS;
		}catch (Exception e){
			e.printStackTrace();
			EventLogger.add("Étlap törlés: " + id, request, EventLogEnum.ERROR);
			return ErrorCodeEnum.ERROR;
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (cstm != null) cstm.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
	
	public List<Etlap> getActive(){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		List<Etlap> etlap = new ArrayList<Etlap>();
		
		try{
			cstm = conn.prepareCall("{call ETLAP_GET_ACTIVE()}");
			rs = cstm.executeQuery();
			
			while(rs.next()){
				Etlap e = new Etlap();
				e.setId(rs.getInt("id"));
				e.setNev(rs.getString("nev"));
				e.setKategoria(rs.getInt("kategoria"));
				e.setLeiras(rs.getString("leiras"));
				e.setAr(rs.getString("ar"));
				e.setIs_kep(rs.getInt("isKep"));
				etlap.add(e);
			}
			
			return etlap;
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

	public List<Etlap> getAll(){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		List<Etlap> etlap = new ArrayList<Etlap>();
		
		try{
			cstm = conn.prepareCall("{call ETLAP_GET_ALL()}");
			rs = cstm.executeQuery();
			
			while(rs.next()){
				Etlap e = new Etlap();
				e.setId(rs.getInt("id"));
				e.setNev(rs.getString("nev"));
				e.setKategoria(rs.getInt("kategoria"));
				e.setLeiras(rs.getString("leiras"));
				e.setAr(rs.getString("ar"));
				e.setIs_kep(rs.getInt("isKep"));
				e.setStat(rs.getString("stat"));
				etlap.add(e);
			}
			
			return etlap;
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
	
	public ErrorCodeEnum modif(Etlap etlap, boolean isOriginal){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		try{
			cstm = conn.prepareCall("{call ETLAP_MODIF(?,?,?,?,?,?,?,?,?)}");
			cstm.setInt(1, etlap.getId());
			cstm.setString(2, etlap.getNev());
			cstm.setInt(3, etlap.getKategoria());
			cstm.setString(4, etlap.getLeiras());
			cstm.setString(5, etlap.getAr());
			cstm.setBytes(6, etlap.getKep());
			cstm.setInt(7, etlap.getIs_kep());
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
	
	public ErrorCodeEnum changeStat(int id){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		try{
			cstm = conn.prepareCall("{call ETLAP_CHANGE_STAT(?)}");
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
