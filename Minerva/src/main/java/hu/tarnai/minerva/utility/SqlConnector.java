package hu.tarnai.minerva.utility;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;

import hu.tarnai.minerva.enums.ErrorCodeEnum;


public class SqlConnector {
	
	protected Connection conn = null;
	
	protected CallableStatement cstm = null;
	protected ResultSet rs = null;
	
	protected ErrorCodeEnum connectDB(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/minerva?characterEncoding=UTF-8", "taresz", "taresz.0531");
			return ErrorCodeEnum.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ErrorCodeEnum.ERROR;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return ErrorCodeEnum.ERROR;
		}
	}

}
