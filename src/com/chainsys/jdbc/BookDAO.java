package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {

	public void addBook(Book book) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "insert into books(id,name,price,publishing_date) values(?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setInt(1, book.id);
		preparedStatement.setString(2, book.name);
		preparedStatement.setInt(3, book.price);
		preparedStatement.setDate(4, Date.valueOf(book.publishingdate));
		int rows = preparedStatement.executeUpdate();
		System.out.println("Rows inserted " + rows);
		ConnectionUtil.close(connection, preparedStatement, null);
	}

	public void updateBook(Book book) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "update books set name=? where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, book.name);
		 preparedStatement.setInt(2, book.id);
		preparedStatement.setInt(2, book.id);

		int rows = preparedStatement.executeUpdate();
		System.out.println("Rows inserted " + rows);
		ConnectionUtil.close(connection, preparedStatement, null);

	}

	public void deleteBook(Book book) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "delete from books where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setInt(1, book.id);
		int rows = preparedStatement.executeUpdate();
		System.out.println("Rows inserted " + rows);
		ConnectionUtil.close(connection, preparedStatement, null);

	}

	public ArrayList<Book> findAll(Book book) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select id,name,price from books";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultset = preparedStatement.executeQuery();
		ArrayList<Book> booklist = new ArrayList<Book>();

		while (resultset.next()) {

			Book book1 = new Book();
			book1.id = resultset.getInt("id");
			book1.name = resultset.getString("name");
			book1.price = resultset.getInt("price");
			booklist.add(book1);

		}
		return booklist;
	// ConnectionUtil.close(connection, preparedStatement,resultset);

	}

	public Book findById(Book book) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select id,name,price from books where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, book.id);
		ResultSet resultset = preparedStatement.executeQuery();
		Book bookdetails = null;

		if (resultset.next()) {
			bookdetails = new Book();
			bookdetails.id = resultset.getInt("id");
			bookdetails.name = resultset.getString("name");
			bookdetails.price = resultset.getInt("price");

		}
		return bookdetails;
		
	}

}
