package com.training.main;

import java.util.List;
import java.util.Scanner;
import com.training.bean.*;
import com.training.service.*;
import com.training.exception.*;
import com.training.dao.*;

public class Client {
	public static void main(String[] args) {
		boolean ext = false;
		Scanner sc = new Scanner(System.in);
		BookService bookInter = new BookServiceImpl();
		ModelDAO.openConnection();
		while (!ext) {
			System.out.println(
					"Enter the operation: \n1.Add book\n2.get all books\n3.remove book\n4.search by category\n5.search by author\n6.search by id\n7.exit");
			int c = sc.nextInt();
			sc.nextLine();
			switch (c) {
			case 1:
				Book book = new Book();
				System.out.println("Enter book title, author, category, id, price - ");
				book.setTitle(sc.nextLine());
				book.setAuthor(sc.nextLine());
				book.setCategory(sc.nextLine());
				book.setBookid(sc.nextInt());
				sc.nextLine();
				book.setPrice(sc.nextInt());
				sc.nextLine();
				bookInter.addBook(book);
				break;
			case 2:
				List<Book> res = bookInter.getAllBooks();
				for (Book bk : res) {
					System.out.println("book id = " + bk.getBookid());
					System.out.println("book title = " + bk.getTitle());
					System.out.println("book author = " + bk.getAuthor());
					System.out.println("book category = " + bk.getCategory());
					System.out.println("book price = " + bk.getPrice());
					System.out.println();
				}
				break;
			case 3:
				System.out.println("Enter book id - ");
				int id = sc.nextInt();
				sc.nextLine();
				try {
					boolean del = bookInter.deleteBook(id);
					if (del) {
						System.out.println("book deleted successfully");
					}
				} catch (BookNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("Enter category - ");
				String cat = sc.nextLine();
				try {
					List<Book> rep = bookInter.getBookbycategory(cat);
					for (Book bk : rep) {
						System.out.println("book id = " + bk.getBookid());
						System.out.println("book title = " + bk.getTitle());
						System.out.println("book author = " + bk.getAuthor());
						System.out.println("book category = " + bk.getCategory());
						System.out.println("book price = " + bk.getPrice());
						System.out.println();
					}
				} catch (CategoryNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				System.out.println("Enter author - ");
				String cat1 = sc.nextLine();
				try {
					List<Book> rep = bookInter.getBookbyAuthor(cat1);
					for (Book bk : rep) {
						System.out.println("book id = " + bk.getBookid());
						System.out.println("book title = " + bk.getTitle());
						System.out.println("book author = " + bk.getAuthor());
						System.out.println("book category = " + bk.getCategory());
						System.out.println("book price = " + bk.getPrice());
						System.out.println();
					}
				} catch (AuthorNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				System.out.println("enter book id");
				int id1 = sc.nextInt();
				sc.nextLine();
				try {
					Book book1 = bookInter.getBookById(id1);
					System.out.println("book id = " + book1.getBookid());
					System.out.println("book title = " + book1.getTitle());
					System.out.println("book author = " + book1.getAuthor());
					System.out.println("book category = " + book1.getCategory());
					System.out.println("book price = " + book1.getPrice());
					System.out.println();

				} catch (BookNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				ext = true;
				ModelDAO.closeConnection();
				break;
			default:
				System.out.println("Enter a valid choice");
				break;
			}
		}
		sc.close();

	}

}
