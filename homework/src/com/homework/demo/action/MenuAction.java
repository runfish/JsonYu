package com.homework.demo.action;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import com.homework.demo.bean.MenuBean;
import com.homework.demo.utils.BaseAction;
import com.homework.demo.utils.JDBCUtils;

public class MenuAction extends BaseAction {

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String list() {
		Connection conn = null;
		Statement statement = null;
		String sql = "";
		ResultSet rs = null;

		List<String> listMenu = new ArrayList<String>();
		try {
			conn = JDBCUtils.getConn();
			sql = "select * from menu";
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);

			while (rs.next()) {

				StringBuffer sb = new StringBuffer();
				sb.append("{");
				sb.append("id:" + rs.getString("menu_id") + ",");
				sb.append("pId:" + rs.getString("menu_pid") + ",");
				sb.append("name:" + "\"" + rs.getString("menu_name") + "\""
						+ ",");
				sb.append("open:" + "true"+"}");
				listMenu.add(sb.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {

			JDBCUtils.closeRes(statement, rs);
		}

		ObjectMapper objectMapper = new ObjectMapper();
		StringWriter stringWriter = new StringWriter();
		String result = "";
		try {
			JsonGenerator jsonGenerator = objectMapper.getJsonFactory()
					.createJsonGenerator(stringWriter);
			jsonGenerator.writeObject(listMenu);
			result = stringWriter.toString();
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.print(result);
		out.flush();
		out.close();

		return this.NONE;
	}
}
