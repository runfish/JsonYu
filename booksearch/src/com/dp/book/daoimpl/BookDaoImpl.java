package com.dp.book.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dp.book.dao.BookDao;
import com.dp.book.domain.Book;
import com.dp.book.utils.JDBCUtils;

public class BookDaoImpl implements BookDao {
	public List<Book> loadAll() {
		// TODO Auto-generated method stub
		Connection conn = null;

		Statement statement = null;

		ResultSet rs = null;

		String sql = null;

		List<Book> listBook = new ArrayList<Book>();

		try {

			conn = JDBCUtils.getConn();

			statement = conn.createStatement();

			sql = "select * from book ";

			rs = statement.executeQuery(sql);

			while (rs.next()) {

				Book book = new Book();

				book.setTitleId(rs.getString("title_id"));
				book.setTitle(rs.getString("title"));
				book.setType(rs.getString("type"));
				book.setSale(rs.getInt("sales"));
				book.setPrice(rs.getDouble("price"));
				book.setPubdate(rs.getString("pubdate"));

				listBook.add(book);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			JDBCUtils.closeConn();
			JDBCUtils.closeRes(statement, rs);
		}

		return listBook;
	}

	public List<String> loadType() {

		Connection conn = null;

		Statement statement = null;

		ResultSet rs = null;

		String sql = null;

		List<String> typelist = new ArrayList<String>();

		try {

			conn = JDBCUtils.getConn();

			statement = conn.createStatement();

			sql = "select distinct type from book ";

			rs = statement.executeQuery(sql);

			while (rs.next()) {

				String type = rs.getString(1);

				typelist.add(type);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			JDBCUtils.closeConn();
			JDBCUtils.closeRes(statement, rs);
		}

		return typelist;
	}

	public List<Map<String, Object>> getBooksByType(String type) {

		Connection conn = null;

		Statement statement = null;

		ResultSet rs = null;

		String sql = null;
        Map<String, Object> map= null;
        
		List<Map<String, Object>> booklist = new ArrayList<Map<String, Object>>();

		try {

			conn = JDBCUtils.getConn();

			statement = conn.createStatement();

			sql = "select * from book  where type ='" + type + "'";

			rs = statement.executeQuery(sql);

			while (rs.next()) {

				map = new HashMap<String, Object>();
			
				map.put("titleId", rs.getString("title_id"));
				map.put("title", rs.getString("title"));
				map.put("type", rs.getString("type"));
				map.put("price", rs.getInt("price"));
				map.put("sales", rs.getInt("sales"));
				map.put("pubdate", rs.getString("pubdate"));
				
				booklist.add(map);
			
				

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			JDBCUtils.closeConn();
			JDBCUtils.closeRes(statement, rs);
		}

		return booklist;

	}
}
