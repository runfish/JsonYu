package com.homework.demo.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		Statement statement = null;
		ResultSet rset = null;
		String sql = null;
		
		try {
			conn = JDBCUtils.getConn();
			sql = "select * from menu";
			statement = conn.createStatement();
			rset =statement.executeQuery(sql);
			while(rset.next()){
				System.out.println(rset.getString(2));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		
		

	}

}
