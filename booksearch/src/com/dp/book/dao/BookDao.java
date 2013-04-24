package com.dp.book.dao;

import java.util.List;
import java.util.Map;

import com.dp.book.domain.Book;

public interface BookDao {

	List<Book> loadAll();
	
	List<String> loadType();
	
	List<Map<String, Object>> getBooksByType(String type);
}
