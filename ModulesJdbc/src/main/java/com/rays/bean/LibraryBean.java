package com.rays.bean;

public class LibraryBean {
/*# Field, Type, Null, Key, Default, Extra
'book_id', 'int', 'NO', 'PRI', NULL, ''
'title', 'varchar(255)', 'YES', '', NULL, ''
'author', 'varchar(32)', 'YES', '', NULL, ''
'price', 'double', 'YES', '', NULL, ''
'availability', 'tinyint', 'YES', '', NULL, ''
 * */
	private int bookId;
	private String title;
	private String author;
	private double price;
	private boolean availability;
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getBookId() {
		return bookId;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean getAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
}
