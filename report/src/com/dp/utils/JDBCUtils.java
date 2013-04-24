package com.dp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	private static final ThreadLocal<Connection> t = new ThreadLocal<Connection>();
	private static String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private static String user = "scott";
	private static String password = "xiaoyu";
	
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static Connection getConn(){
		Connection conn = null;
		
		
		if(t.get()==null){
			try {
				conn = DriverManager.getConnection(url, user, password);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			t.set(conn);
		}else{
			conn =t.get();
		}
		
		
		
		
		return conn;
	}
	
	public static void closeConn(){
		Connection conn = null;
		
		if(t.get()!=null){
			conn = t.get();
			try {
				conn.close();
				t.remove();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = null;
		}
		
		
	}
	
	
	public static void closeRes(Statement statement,ResultSet rs){
		
		
			try {
				if(statement!=null) statement.close();
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
	}
	

}
