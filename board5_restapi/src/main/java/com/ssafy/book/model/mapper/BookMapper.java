package com.ssafy.book.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.book.model.BookDto;

@Mapper
public interface BookMapper {
	int registBook(BookDto bookDto) throws SQLException;

	List<BookDto> getListBook() throws SQLException;

	void deleteBook(String isbn) throws SQLException;
	
	BookDto viewBook(String isbn) throws SQLException;
	
	void updateBook(BookDto bookDto) throws SQLException;
}
