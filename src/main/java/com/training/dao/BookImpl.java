package com.training.dao;

import com.training.bean.*;
import com.training.exception.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookImpl implements BookDAO {

	public void addBook(Book book) {
		try {
			PreparedStatement preparedStatementDB = ModelDAO.connection.prepareStatement("use dbtraining;");
			preparedStatementDB.execute();

			PreparedStatement preparedStatement = ModelDAO.connection
					.prepareStatement("insert into library values(?, ?, ?, ?, ?);");
			preparedStatement.setInt(1, book.getBookid());
			preparedStatement.setString(2, book.getTitle());
			preparedStatement.setString(3, book.getAuthor());
			preparedStatement.setString(4, book.getCategory());
			preparedStatement.setInt(5, book.getPrice());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * Connection connection = ModelDAO.openConnection(); PreparedStatement
		 * st = connection.prepareStatement(sql); st.execute();
		 */
	}

	public boolean deleteBook(int bookid) throws BookNotFoundException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatementDB = ModelDAO.connection.prepareStatement("use dbtraining;");
			preparedStatementDB.execute();
			PreparedStatement preparedStatement = ModelDAO.connection
					.prepareStatement("delete from library where book_id = ?;");
			preparedStatement.setInt(1, bookid);
			return preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Book getBookById(int bookid) throws BookNotFoundException {
		// TODO Auto-generated method stub
		Book book = null;
		try {
			PreparedStatement preparedStatementDB = ModelDAO.connection.prepareStatement("use dbtraining;");
			preparedStatementDB.execute();
			PreparedStatement preparedStatement = ModelDAO.connection
					.prepareStatement("select * from library where book_id = ?;");
			preparedStatement.setInt(1, bookid);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				book = new Book();
				book.setBookid(resultSet.getInt(1));
				book.setTitle(resultSet.getString(2));
				book.setAuthor(resultSet.getString(3));
				book.setCategory(resultSet.getString(4));
				book.setPrice(resultSet.getInt(5));
				return book;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (book == null) {
			throw new BookNotFoundException("Book not found !!");
		}
		return null;
	}

	public boolean updateBook(int bookid, int price) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatementDB = ModelDAO.connection.prepareStatement("use dbtraining;");
			preparedStatementDB.execute();
			PreparedStatement preparedStatement = ModelDAO.connection
					.prepareStatement("update library set price = ? where book_id = ?;");
			preparedStatement.setInt(1, price);
			preparedStatement.setInt(2, bookid);
			return preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		List<Book> tem = new ArrayList<Book>();

		try {
			PreparedStatement preparedStatementDB = ModelDAO.connection.prepareStatement("use dbtraining;");
			preparedStatementDB.execute();
			PreparedStatement preparedStatement = ModelDAO.connection.prepareStatement("select * from library;");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				book.setBookid(resultSet.getInt(1));
				book.setTitle(resultSet.getString(2));
				book.setAuthor(resultSet.getString(3));
				book.setCategory(resultSet.getString(4));
				book.setPrice(resultSet.getInt(5));
				tem.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tem;
	}

	public List<Book> getBookbyAuthor(String author) throws AuthorNotFoundException {
		// TODO Auto-generated method stub
		List<Book> tem = new ArrayList<Book>();
		try {
			PreparedStatement preparedStatementDB = ModelDAO.connection.prepareStatement("use dbtraining;");
			preparedStatementDB.execute();
			PreparedStatement preparedStatement = ModelDAO.connection
					.prepareStatement("select * from library where author = ?");
			preparedStatement.setString(1, author);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				book.setBookid(resultSet.getInt(1));
				book.setTitle(resultSet.getString(2));
				book.setAuthor(resultSet.getString(3));
				book.setCategory(resultSet.getString(4));
				book.setPrice(resultSet.getInt(5));
				tem.add(book);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (tem.isEmpty()) {
			throw new AuthorNotFoundException("Author not found");
		}
		return tem;
	}

	public List<Book> getBookbycategory(String category) throws CategoryNotFoundException {
		// TODO Auto-generated method stub
		List<Book> tem = new ArrayList<Book>();
		try {
			PreparedStatement preparedStatementDB = ModelDAO.connection.prepareStatement("use dbtraining;");
			preparedStatementDB.execute();
			PreparedStatement preparedStatement = ModelDAO.connection
					.prepareStatement("select * from library where category = ?");
			preparedStatement.setString(1, category);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				book.setBookid(resultSet.getInt(1));
				book.setTitle(resultSet.getString(2));
				book.setAuthor(resultSet.getString(3));
				book.setCategory(resultSet.getString(4));
				book.setPrice(resultSet.getInt(5));
				tem.add(book);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (tem.isEmpty()) {
			throw new CategoryNotFoundException("Category not found");
		}
		return tem;
	}

}
