package com.dp.book.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dp.book.service.BookService;
import com.dp.book.serviceimpl.BookServiceImpl;

public class IndexServlet extends HttpServlet {

	public IndexServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTf-8");

		BookService bookService = new BookServiceImpl();

		request.setAttribute("booklist", bookService.loadAll());
		request.setAttribute("typelist", bookService.loadType());

		request.getRequestDispatcher("/jsps/listbook.jsp").forward(request,
				response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
