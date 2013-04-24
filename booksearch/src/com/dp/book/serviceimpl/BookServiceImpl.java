package com.dp.book.serviceimpl;

import java.util.List;
import java.util.Map;

import com.dp.book.dao.BookDao;
import com.dp.book.daoimpl.BookDaoImpl;
import com.dp.book.domain.Book;
import com.dp.book.service.BookService;

public class BookServiceImpl implements BookService {

	public List<Book> loadAll() {
		BookDao bookDao = new BookDaoImpl();
		
		return bookDao.loadAll();
	}
	
	public List<String> loadType() {
		BookDao bookDao = new BookDaoImpl();

		
		return bookDao.loadType();
	}
	public List<Map<String, Object>> getBooksByType(String type) {
		
		BookDao bookDao = new BookDaoImpl();

		return bookDao.getBooksByType(type);
	}
}
