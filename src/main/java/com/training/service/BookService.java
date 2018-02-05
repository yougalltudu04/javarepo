package com.training.service;

import java.util.List;

import com.training.bean.Book;
import com.training.exception.AuthorNotFoundException;
import com.training.exception.BookNotFoundException;
import com.training.exception.CategoryNotFoundException;

public interface BookService {
	//called by admin
			void addBook(Book book);
			boolean deleteBook(int bookid) throws BookNotFoundException;
			Book getBookById(int bookid) throws BookNotFoundException;
			boolean updateBook(int bookid,int price);
			
			// called by customer
			List<Book> getAllBooks();
			List<Book> getBookbyAuthor(String author) throws AuthorNotFoundException;;
			List<Book> getBookbycategory(String category)throws CategoryNotFoundException;;
		

}
