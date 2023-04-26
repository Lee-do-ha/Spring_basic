package com.ssafy.book.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.book.model.BookDto;

public interface BookService {
	int registBook(BookDto bookDto) throws SQLException;

	List<BookDto> getListBook() throws SQLException;

	void deleteBook(String isbn) throws SQLException;
	
	BookDto viewBook(String isbn) throws SQLException;
	
	void updateBook(BookDto bookDto) throws SQLException;
}
