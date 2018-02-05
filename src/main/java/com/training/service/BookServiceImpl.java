package com.training.service;

import java.util.List;
import com.training.bean.Book;
import com.training.exception.AuthorNotFoundException;
import com.training.exception.BookNotFoundException;
import com.training.exception.CategoryNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.training.dao.*;

public class BookServiceImpl implements BookService {
	private final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	BookDAO bookDAO = new BookImpl();
	
	
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		logger.info("in service: adding book {}", book);
		bookDAO.addBook(book);
	}

	
	public boolean deleteBook(int bookid) throws BookNotFoundException {
		// TODO Auto-generated method stub
		logger.info("in service: deleting bookid {}", bookid);
		bookDAO.deleteBook(bookid);
		return false;
	}

	
	public Book getBookById(int bookid) throws BookNotFoundException {
		// TODO Auto-generated method stub
		logger.info("in service: fetching bookid {}", bookid);
		Book book = bookDAO.getBookById(bookid);
		if(book == null){
			logger.error("in service: exception occurred");
			throw new BookNotFoundException("Book not found");			
		}
		return book;
	}

	
	public boolean updateBook(int bookid, int price) {
		// TODO Auto-generated method stub
		logger.info("in service: updaing bookid {} with price {}", bookid, price);
		boolean res = bookDAO.updateBook(bookid, price);
		return res;
	}

	
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		logger.info("in service: Fetching all books");
		return bookDAO.getAllBooks();
	}

	
	public List<Book> getBookbyAuthor(String author) throws AuthorNotFoundException {
		// TODO Auto-generated method stub
		logger.info("in service: Fetching books by author name {}", author);
		return bookDAO.getBookbyAuthor(author);
	}

	
	public List<Book> getBookbycategory(String category) throws CategoryNotFoundException {
		// TODO Auto-generated method stub
		return bookDAO.getBookbycategory(category);
	}

}
