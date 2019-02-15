package com.chainsys.jdbc;

public class BookValidation {
	public void validationBook(Book book) throws Exception {

		if (book.name == null) {
			throw new Exception("Invalid name please enter correct name");
		}
		if (book.price <= 0) {
			throw new Exception("Invalid price please enter correct price");
		}

	}

	public void validateUpdate(Book book) throws Exception {
		if (book.id <= 0) {
			throw new Exception("Invalid id number please enter correct id");
		}
		if (book.name == null) {
			throw new Exception("Invalid name please enter correct name");
		}
	}

	public void delete(Book book) throws Exception {
		if (book.id <= 0) {
			throw new Exception("Invalid id number please enter correct id");
		}

	}

	public void findById(Book book) throws Exception {
		if (book.id <= 0) {
			throw new Exception("Invalid id");
		}
	}

}
