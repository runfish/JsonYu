package com.dp.action;

import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.text.StrBuilder;

import com.dp.utils.BaseAction;
import com.dp.utils.JDBCUtils;
import com.dp.utils.JsonInfo;
import com.dp.utils.JsonUtil;
import com.opensymphony.xwork2.ActionContext;

public class DeptACtion extends BaseAction {
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String list() {
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		String sql = null;
		Map<String, Object> deptMap = null;
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		try {
			conn = JDBCUtils.getConn();
			statement = conn.createStatement();
			sql = "select * from t_dept order by dept_id asc";
			rs = statement.executeQuery(sql);

			while (rs.next()) {
				deptMap = new HashMap<String, Object>();
				String dept_id = rs.getString("dept_id");
				String dept_name = rs.getString("dept_name");
				String parentid = rs.getString("parentid");
				int grade = rs.getInt("grade");
				int isleaf = rs.getInt("isleaf");

				deptMap.put("id", dept_id);
				deptMap.put("name", dept_name);
				deptMap.put("pId", parentid);

				if (grade == 1) {
					deptMap.put("open", true);
				}

				listMap.add(deptMap);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtils.closeConn();
			JDBCUtils.closeRes(statement, rs);
		}

		ActionContext actionContext = ActionContext.getContext();
		String jsonStr = JsonUtil.objectToJson(listMap);
		actionContext.put("jsonStr", jsonStr);

		return "list";
	}

	public String list2() {

		return "list2";
	}

	public String list_json() {
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		String sql = null;
		Map<String, Object> deptMap = null;
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		System.out.println(id);
		System.out.println(name);
		try {
			conn = JDBCUtils.getConn();
			statement = conn.createStatement();
			if (id == null || id.equals("") || id.equalsIgnoreCase("null")) {
				sql = "select * from t_dept where parentid='0' order by dept_id asc";
			} else {
				sql = "select * from t_dept where parentid=" + id
						+ " order by dept_id asc";
			}
			rs = statement.executeQuery(sql);

			while (rs.next()) {
				deptMap = new HashMap<String, Object>();
				String dept_id = rs.getString("dept_id");
				String dept_name = rs.getString("dept_name");
				String parentid = rs.getString("parentid");
				int grade = rs.getInt("grade");
				int isleaf = rs.getInt("isleaf");

				deptMap.put("id", dept_id);
				deptMap.put("name", dept_name);
				deptMap.put("pId", parentid);

				if (grade == 1) {
					deptMap.put("open", true);
				}
				if (isleaf == 0) {
					deptMap.put("isParent", true);
				} else {
					deptMap.put("isParent", false);
				}

				listMap.add(deptMap);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtils.closeConn();
			JDBCUtils.closeRes(statement, rs);
		}

		ActionContext actionContext = ActionContext.getContext();
		String jsonStr = JsonUtil.objectToJson(listMap);

		return this.NONE;
	}

	public String getChilds() {
		String parentId = request.getParameter("parentid");
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		Map<String, Object> deptMap = null;
		List<Map<String, Object>> deptList = new ArrayList<Map<String, Object>>();
		try {
			conn = JDBCUtils.getConn();
			statement = conn.createStatement();
			StringBuffer querySQL = new StringBuffer();
			querySQL.append("select * from t_dept");
			querySQL.append("  where 1=1 ");
			querySQL.append(" and dept_id like '" + parentId + "%'");
			querySQL.append("  order by dept_id asc");
			rs = statement.executeQuery(querySQL.toString());
			while (rs.next()) {
				deptMap = new HashMap<String, Object>();
				String dept_id = rs.getString("dept_id");
				String dept_name = rs.getString("dept_name");
				String parentid = rs.getString("parentid");
				int grade = rs.getInt("grade");
				int isleaf = rs.getInt("isleaf");
				for (int i = 1; i <= grade; i++) {
					dept_name = "&nbsp;&nbsp;&nbsp;&nbsp;" + dept_name;

				}

				deptMap.put("dept_id", dept_id);
				deptMap.put("dept_name", dept_name);
				deptMap.put("parentid", parentid);
				deptMap.put("grade", grade);
				deptMap.put("isleaf", isleaf);
				deptList.add(deptMap);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtils.closeConn();
			JDBCUtils.closeRes(statement, rs);
		}

		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("deptList", deptList);
		return "getchild";
	}

	public String deleteDept() {

		String deptId = request.getParameter("dept_id");
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		JsonInfo jsonInfo = new JsonInfo();
		try {
			conn = JDBCUtils.getConn();
			statement = conn.createStatement();
			StringBuffer querySQL = new StringBuffer();
			String parentId = null;

			querySQL.append("  select parentid from t_dept ");
			querySQL.append("  where 1=1 ");
			querySQL.append("  and dept_id = '" + deptId + "'");

			System.out.println(querySQL.toString());
			conn.setAutoCommit(false);
			rs = statement.executeQuery(querySQL.toString());
			while (rs.next()) {

				parentId = rs.getString(1);

			}
			querySQL.setLength(0);

			querySQL.append("select count(1) childcount  from t_dept");
			querySQL.append("  where 1=1 ");
			querySQL.append("  and parentid='" + parentId + "'");

			System.out.println(querySQL);
			rs = statement.executeQuery(querySQL.toString());
			int childCount = 0;
			while (rs.next()) {

				childCount = rs.getInt("childcount");

			}

			StringBuffer deleteSQL = new StringBuffer();

			deleteSQL.append("delete from  t_dept ");
			deleteSQL.append(" where 1=1 ");
			deleteSQL.append("  and dept_id ='" + deptId + "'");
			statement.executeUpdate(deleteSQL.toString());

			if (childCount == 1) {

				StringBuffer updateSQL = new StringBuffer();
				updateSQL.append("update t_dept ");
				updateSQL.append(" set isleaf = 1");
				updateSQL.append(" where 1=1");
				updateSQL.append(" and dept_id='" + parentId + "'");

				statement.executeUpdate(updateSQL.toString());

			}

			conn.commit();

			jsonInfo.setFlag(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				conn.rollback();
				jsonInfo.setFlag(false);
				jsonInfo.setMessage(e.getMessage());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			JDBCUtils.closeConn();
			JDBCUtils.closeRes(statement, rs);
		}

		String jsoninfo = JsonUtil.objectToJson(jsonInfo);
		System.out.println(jsoninfo);
		out.print(jsoninfo);
		out.flush();
		out.close();

		return this.NONE;

	}

	public String update() {
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		String sql = null;
		Map<String, Object> deptMap = null;
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		try {
			conn = JDBCUtils.getConn();
			statement = conn.createStatement();
			sql = "select * from t_dept order by dept_id asc";
			rs = statement.executeQuery(sql);

			while (rs.next()) {
				deptMap = new HashMap<String, Object>();
				String dept_id = rs.getString("dept_id");
				String dept_name = rs.getString("dept_name");
				String parentid = rs.getString("parentid");
				int grade = rs.getInt("grade");
				int isleaf = rs.getInt("isleaf");

				deptMap.put("id", dept_id);
				deptMap.put("name", dept_name);
				deptMap.put("pId", parentid);

				if (grade == 1) {
					deptMap.put("open", true);
				}

				listMap.add(deptMap);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtils.closeConn();
			JDBCUtils.closeRes(statement, rs);
		}

		String jsonStr = JsonUtil.objectToJson(listMap);
		out.print(jsonStr);
		out.flush();
		out.close();

		return this.NONE;
	}

	public String addDept() {
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		StringBuffer SQL = new StringBuffer();
		JsonInfo jsonInfo = new JsonInfo();
		try {
			String deptId = request.getParameter("dept_id");
			String grade = request.getParameter("grade");
			String deptName = request.getParameter("dept_name");
			deptName = URLDecoder.decode(deptName, "UTF-8");
			int newGrade = Integer.parseInt(grade)+1;
			System.out.println(deptName);
			conn = JDBCUtils.getConn();
			statement = conn.createStatement();
			conn.setAutoCommit(false);
			SQL.append("select count(*) from t_dept ");
			SQL.append(" where 1=1");
			SQL.append(" and dept_id like'"+deptId+"0%'");
			SQL.append(" and grade ="+newGrade);
			rs = statement.executeQuery(SQL.toString());
			int count = 0;
			if(rs.next()){
				count = rs.getInt(1);
				System.out.println(count);
			}
			
			String newDeptId = deptId+0+(count+1);
			System.out.println(newDeptId);
			
			SQL.setLength(0);
			
			SQL.append("insert into t_dept values(?,?,?,?,?)");
			PreparedStatement pstmt = conn.prepareStatement(SQL.toString());
			
			pstmt.setString(1, newDeptId);
			pstmt.setString(2, deptName);
			pstmt.setString(3, deptId);
			pstmt.setInt(4, newGrade);
			pstmt.setInt(5, 1);
			pstmt.execute();
		
		    if(count==0){
		    	SQL.setLength(0);
		    	SQL.append("update t_dept");
		    	SQL.append("  set isleaf = 0");
		    	SQL.append(" where 1=1");
		    	SQL.append("  and dept_id="+deptId);
				
		    	statement.execute(SQL.toString());
			}
			
		    conn.commit();
		    jsonInfo.setFlag(true);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				conn.rollback();
				jsonInfo.setFlag(false);
				jsonInfo.setMessage(e.getMessage());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			JDBCUtils.closeConn();
			JDBCUtils.closeRes(statement, rs);
		}
		
		String jsonStr = JsonUtil.objectToJson(jsonInfo);
		out.print(jsonStr);
		out.flush();
		out.close();
		return this.NONE;
	}
	public String modifyDept() {
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		StringBuffer SQL = new StringBuffer();
		JsonInfo jsonInfo = new JsonInfo();
		try {
			String deptId = request.getParameter("dept_id");
			String deptName = request.getParameter("dept_name");
			deptName = URLDecoder.decode(deptName, "UTF-8");
			conn = JDBCUtils.getConn();
			statement = conn.createStatement();
			SQL.append("update t_dept set");
			SQL.append("  dept_name='"+deptName+"'");
			SQL.append("  where 1=1");
			SQL.append("  and dept_id="+deptId);
			System.out.println(SQL.toString());
			statement.execute(SQL.toString());
		    jsonInfo.setFlag(true);

		} catch (Exception e) {
			// TODO: handle exception
			    e.printStackTrace();
				jsonInfo.setFlag(false);
				jsonInfo.setMessage(e.getMessage());
		} finally {
			JDBCUtils.closeConn();
			JDBCUtils.closeRes(statement, rs);
		}
		
		String jsonStr = JsonUtil.objectToJson(jsonInfo);
		out.print(jsonStr);
		out.flush();
		out.close();
		return this.NONE;
	}
}
