package com.homework.demo.interceptor;

import java.sql.Connection;
import java.sql.SQLException;
import com.homework.demo.utils.JDBCUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TransactionInteractor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		String result = "";
		try {
			
			conn = JDBCUtils.getConn();
			conn.setAutoCommit(false);
			result =invocation.invoke();
			conn.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			conn.rollback();
		}finally{
			JDBCUtils.closeConn();
		}
		
		
		return result;
	}

}
