package com.chainsys.jdbc.test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.chainsys.jdbc.Book;
import com.chainsys.jdbc.BookDAO;
import com.chainsys.jdbc.BookValidation;

public class TestBookDAO {

	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);

		BookDAO bookDAO = new BookDAO();
		BookValidation bookvalidation = new BookValidation();
		Book book = new Book();

		System.out.println("Enter the number to search");
		int number = scanner.nextInt();
		switch (number) {
		case 1:
			System.out.println("Enter id ,name,price,publishingdate to add");
			int id = scanner.nextInt();
			String name = scanner.next();
			int price = scanner.nextInt();
			book.id = id;
			book.name = name;
			book.price = price;
			String date=scanner.next();
			book.publishingdate=LocalDate.parse(date);
			try {
				bookvalidation.validationBook(book);
				bookDAO.addBook(book);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bookDAO.findAll(book);
			break;

		case 2:
			System.out.println("Enter id and name to update");

			book.name = scanner.next();
			book.id = scanner.nextInt();
			try {
				bookvalidation.validateUpdate(book);
				bookDAO.updateBook(book);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			bookDAO.findAll(book);
			break;

		case 3:
			System.out.println("Enter id to delete book");
			book.id = scanner.nextInt();
			try {
				bookvalidation.delete(book);
				
				bookDAO.deleteBook(book);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// bookDAO.findAll();
			break;
		case 4:
			ArrayList<Book> list = bookDAO.findAll(book);
			if (list.size() == 0) {
				System.out.println("empty");
			} else {
				for (Book b : list) {
					System.out.println(b.id + "  " + b.name + "  " + b.price);
				}
			}
			bookDAO.findAll(book);
			break;
		case 5:
			System.out.println("Enter id to display");

			int id3 = scanner.nextInt();
			book.id = id3;
			try {
				bookvalidation.validateUpdate(book);
				bookDAO.findAll(book);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Book book1 = bookDAO.findById(book);
			if (book1 != null) {
				System.out.println(book1.id);
				System.out.println(book1.name);
				System.out.println(book1.price);
			}
			//bookDAO.findAll(book);
			break;

		}

		scanner.close();

	}

}
