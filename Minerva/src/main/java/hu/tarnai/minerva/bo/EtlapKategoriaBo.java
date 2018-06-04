package hu.tarnai.minerva.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.tarnai.minerva.entity.Etlapkategoria;
import hu.tarnai.minerva.enums.ErrorCodeConverter;
import hu.tarnai.minerva.enums.ErrorCodeEnum;
import hu.tarnai.minerva.utility.SqlConnector;

public class EtlapKategoriaBo extends SqlConnector{
	
	public ErrorCodeEnum add(String nev){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		
		
		try{
			cstm = conn.prepareCall("{call ETLAPKATEGORIA_ADD(?,?)}");
			cstm.setString(1, nev);
			cstm.registerOutParameter(2, java.sql.Types.INTEGER);
			
			cstm.executeUpdate();
			
			
			return ErrorCodeConverter.getErrorCode(cstm.getInt(2));
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
			cstm = conn.prepareCall("{call ETLAPKATEGORIA_DELET(?)}");
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

	public List<Etlapkategoria> getActive(){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		List<Etlapkategoria> kat = new ArrayList<Etlapkategoria>();
		
		try{
			cstm = conn.prepareCall("{call ETLAPKATEGORIA_GET_ACTIVE()}");
			rs = cstm.executeQuery();
			
			while(rs.next()){
				Etlapkategoria e = new Etlapkategoria();
				e.setId(rs.getInt("id"));
				e.setNev(rs.getString("nev"));
				e.setSorrend(rs.getInt("sorrend"));
				e.setStat(rs.getString("stat"));
				kat.add(e);
			}
			
			
			return kat;
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
	
	public List<Etlapkategoria> getAll(){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		
		List<Etlapkategoria> kat = new ArrayList<Etlapkategoria>();
		
		try{
			cstm = conn.prepareCall("{call ETLAPKATEGORIA_GET_ALL()}");
			rs = cstm.executeQuery();
			
			while(rs.next()){
				Etlapkategoria e = new Etlapkategoria();
				e.setId(rs.getInt("id"));
				e.setNev(rs.getString("nev"));
				e.setSorrend(rs.getInt("sorrend"));
				e.setStat(rs.getString("stat"));
				kat.add(e);
			}
			
			return kat;
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
	
	public Etlapkategoria getById(int id){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return null;
		}
		Etlapkategoria kat = new Etlapkategoria();
		
		try{
			cstm = conn.prepareCall("{call ETLAPKATEGORIA_GET_BY_ID(?)}");
			cstm.setInt(1, id);
			rs = cstm.executeQuery();
			
			if(rs.next()){
				kat.setId(rs.getInt("id"));
				kat.setNev(rs.getString("nev"));
				kat.setSorrend(rs.getInt("sorrend"));
				kat.setStat(rs.getString("stat"));
			}
			
			return kat;
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
	
	public ErrorCodeEnum modif(Etlapkategoria kat){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.DBERROR;
		}
		
		
		try{
			cstm = conn.prepareCall("{call ETLAPKATEGORIA_MODIF(?,?,?)}");
			cstm.setInt(1, kat.getId());
			cstm.setString(2, kat.getNev());
			cstm.registerOutParameter(3, java.sql.Types.INTEGER);
			
			cstm.executeUpdate();
			
			
			return ErrorCodeConverter.getErrorCode(cstm.getInt(3));
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
			cstm = conn.prepareCall("{call ETLAPKATEGORIA_CHANGE_STAT(?)}");
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
	
	public boolean setSorrend(int id,int sorrend){
		if(connectDB() == ErrorCodeEnum.ERROR){
			return false;
		}
		
		
		try{
			cstm = conn.prepareCall("{call ETLAPKATEGORIA_SET_SORREND(?,?)}");
			cstm.setInt(1, id);
			cstm.setInt(2, sorrend);
			
			cstm.executeUpdate();
			
			
			return true;
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			return false;
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (cstm != null) cstm.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
}
