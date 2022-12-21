package com.gakhar.service.exception;

public class BookNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BookNotFound(int id) {
		super("Book with id " + id + " not found");
	}
}
