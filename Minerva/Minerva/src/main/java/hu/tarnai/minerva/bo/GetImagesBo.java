package hu.tarnai.minerva.bo;

import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import hu.tarnai.minerva.enums.ErrorCodeEnum;
import hu.tarnai.minerva.utility.SqlConnector;

public class GetImagesBo extends SqlConnector{
	
	public ErrorCodeEnum getImage(int fileId, String who, HttpServletResponse response){
		Blob img ;
		byte[] imgData = null ;
		
		if(connectDB() == ErrorCodeEnum.ERROR){
			return ErrorCodeEnum.ERROR;
		}
		
		try{
			if(who.equals("g")){
				cstm = conn.prepareCall("{call GALERIA_GET_BY_ID(?)}");
			}
			else{
				cstm = conn.prepareCall("{call ETLAP_KEP_GET_BY_ID(?)}");
			}
			cstm.setInt(1, fileId);
	
		    rs = cstm.executeQuery();
		    while(rs.next()){
		    	img = rs.getBlob("kep");
		        imgData = img.getBytes(1,(int)img.length());
		        OutputStream o = response.getOutputStream();
		        o.write(imgData);
		        o.flush(); 
		        o.close();
		    }
		    
			conn.close();
			cstm.close();
			
			return ErrorCodeEnum.SUCCESS;
			
		}catch(Exception e){
			System.out.println("Error: " + e.getMessage());
			return ErrorCodeEnum.ERROR;
		}
		finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (cstm != null) cstm.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
}
