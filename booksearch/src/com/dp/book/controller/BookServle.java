package com.dp.book.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dp.book.domain.Book;
import com.dp.book.service.BookService;
import com.dp.book.serviceimpl.BookServiceImpl;
import com.dp.book.utils.JsonUtil;

public class BookServle extends HttpServlet {

	public BookServle() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
	
		BookService bookService = new BookServiceImpl();
		
		List<Map<String, Object>> bookList = bookService.getBooksByType(type);
		String jsonStr = JsonUtil.objectToJson(bookList);
		System.out.println(jsonStr);
		out.print(jsonStr);
		out.flush();
		out.close();
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
