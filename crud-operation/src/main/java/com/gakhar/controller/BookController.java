package com.gakhar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gakhar.dto.Book;
import com.gakhar.service.BookService;

@RestController
@RequestMapping("rest")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
		return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookById(id));
	}

	@PostMapping("/books")
	public ResponseEntity<Book> saveBook(@RequestBody Book book) {
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(book));
	}

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks() {
		return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
	}

	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBookById(@PathVariable("id") int id, @RequestBody Book book) {
		return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBookById(book, id));
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<?> deleteBookById(@PathVariable("id") int id) {
		bookService.deleteBookById(id);
		 return new ResponseEntity(HttpStatus.ACCEPTED);
	}
}
