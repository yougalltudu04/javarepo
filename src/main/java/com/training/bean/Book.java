package com.training.bean;

public class Book {
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	String title,author,category;
	int bookid;
	int price;
	
	public Book(String title, String author, String category, int bookid, int price) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.bookid = bookid;
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", category=" + category + ", bookid=" + bookid
				+ ", price=" + price + "]";
	}
	

}
