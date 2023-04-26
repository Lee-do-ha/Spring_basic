package com.ssafy.book.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.book.model.BookDto;
import com.ssafy.book.model.mapper.BookMapper;

@Service
public class BookServiceImpl implements BookService{
	
	private BookMapper bookMapper;
	
	@Autowired
	public BookServiceImpl(BookMapper bookMapper) {
		super();
		this.bookMapper = bookMapper;
	}

	@Override
	public int registBook(BookDto bookDto) throws SQLException {
		return bookMapper.registBook(bookDto);
	}

	@Override
	public List<BookDto> getListBook() throws SQLException {
		return bookMapper.getListBook();
	}

	@Override
	public void deleteBook(String isbn) throws SQLException {
		bookMapper.deleteBook(isbn);
	}

	@Override
	public BookDto viewBook(String isbn) throws SQLException {
		return bookMapper.viewBook(isbn);
	}

	@Override
	public void updateBook(BookDto bookDto) throws SQLException {
		bookMapper.updateBook(bookDto);
	}



}
