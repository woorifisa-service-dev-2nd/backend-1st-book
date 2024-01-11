package dev.bookservice.model;

public class BookBuilder {
	 private String title;
    private String author;
    private int numberOfBook;
   
    public BookBuilder BookBuilder() {
    	return this;
    }
    
    public BookBuilder title(String title) {
    	this.title = title;
    	return this;
    }
    
    public BookBuilder author(String author) {
    	this.author = author;
    	return this;
    }
    
    public BookBuilder numberOfBook(int numberOfBook) {
    	this.numberOfBook = numberOfBook;
    	return this;
    }
    
    public Book build() {
    	return new Book(title, author, numberOfBook);
    }
}
