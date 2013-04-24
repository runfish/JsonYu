package com.xiaoyu.oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ResultSet rs = null;
//		Connection connection = null;
//		try {
//			// 加载驱动
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			// 获取链接
//			connection = DriverManager.getConnection(
//					"jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "xiaoyu");
//
//			Statement statement = connection.createStatement();
//
//			rs = statement.executeQuery("select * from emp");
//
//			while (rs.next()) {
//				System.out.println(rs.getString(2));
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//
//			try {
//				rs.close();
//				connection.close();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}

		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","SCOTT", "xiaoyu");
			
			CallableStatement callableStatement = conn.prepareCall("{ call sp_pro2(?,?)}");
//			callableStatement.setString(1, "SMITH");
//			callableStatement.setInt(2, 100);
//			callableStatement.execute();
			callableStatement.setInt(1, 10);
			callableStatement.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
			callableStatement.execute();
			ResultSet rs = (ResultSet)callableStatement.getObject(2);
			while(rs.next()){
				System.out.println(rs.getInt(1)+rs.getString(2));
			}
			
			
			
			/**
			 * 调用有返回值的过程
			 * 
			 */
//			callableStatement.setInt(1, 1123);
//			callableStatement.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
//			callableStatement.execute();
//			String name = callableStatement.getString(2);
//			/**
//			 * 去返回值需要注意问号的顺序
//			 * 
//			 */
			
			
			
		} catch (Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
