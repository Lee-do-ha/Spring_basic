package com.ssafy.book.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.book.model.BookDto;
import com.ssafy.book.model.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@GetMapping(value = "/view/{id}")
	public ResponseEntity<?> viewBook(@PathVariable("id") String isbn){
		try {
			System.out.println(isbn);
			BookDto bookDto = bookService.viewBook(isbn);
			if(bookDto != null) {
				return new ResponseEntity<BookDto>(bookDto, HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@GetMapping(value = "/list")
	public ResponseEntity<?> getListBook(){
		try {
			List<BookDto> list = bookService.getListBook();
			if(list != null && !list.isEmpty()) {
				return new ResponseEntity<List<BookDto>>(list, HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}

	@PostMapping(value = "/regist")
	public ResponseEntity<?> registBook(@RequestBody BookDto bookdto){
		try {
			bookService.registBook(bookdto);
			List<BookDto> list = bookService.getListBook();
			return new ResponseEntity<List<BookDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<?> updateBook(@RequestBody BookDto bookdto){
		System.out.println(bookdto);
		try {
			bookService.updateBook(bookdto);
			List<BookDto> list = bookService.getListBook();
			return new ResponseEntity<List<BookDto>>(list, HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable("id") String isbn){
		try {
			bookService.deleteBook(isbn);
			List<BookDto> list = bookService.getListBook();
			return new ResponseEntity<List<BookDto>>(list, HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
