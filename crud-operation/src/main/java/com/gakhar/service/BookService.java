package com.gakhar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.gakhar.dto.Book;
import com.gakhar.exception.BookNotFound;

@Service
public class BookService {

	List<Book> bookList = new ArrayList<>();

	public Book saveBook(Book book) {
		bookList.add(book);
		return book;
	}

	public Book getBookById(int id) {
		return bookList.stream().filter(s -> s.id() == id).findFirst().orElseThrow(() -> new BookNotFound(id));

	}

	public List<Book> getAllBooks() {
		return bookList;
	}

	public Book updateBookById(Book book, int bookId) {

		AtomicInteger i = new AtomicInteger();
		int index = bookList.stream().peek(v -> i.incrementAndGet()).anyMatch(b -> b.id() == bookId) ? i.get() - 1
				: -1;

		if (index == -1) {
			throw new BookNotFound(book.id());
		}
		
		bookList.set(index, book);
		return book;
	}
	
	public void deleteBookById(int bookId) {

		AtomicInteger i = new AtomicInteger();
		int index = bookList.stream().peek(v -> i.incrementAndGet()).anyMatch(book -> book.id() == bookId) ? i.get() - 1
				: -1;

		if (index == -1) {
			throw new BookNotFound(bookId);
		}
		bookList.remove(index);		
	}

}
