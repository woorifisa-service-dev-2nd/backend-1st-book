package dev.bookservice.model;

public class Book {
    private String title;
    private String author;
    private int numberOfBook;
    
    public Book() {
    	
    }

    public Book(String title, String author, int numberOfBook) {
        this.title = title;
        this.author = author;
        this.numberOfBook = numberOfBook;
    }
    
    public static class Builder {
    		private String title;
    	    private String author;
    	    private int numberOfBook;
    	   
    	    public Builder title(String title) {
    	    	this.title = title;
    	    	return this;
    	    }
    	    
    	    public Builder author(String author) {
    	    	this.author = author;
    	    	return this;
    	    }
    	    
    	    public Builder numberOfBook(int numberOfBook) {
    	    	this.numberOfBook = numberOfBook;
    	    	return this;
    	    }
    	    
    	    public Book build() {
    	    	return new Book(title, author, numberOfBook);
    	    }
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }


    public int getNumberOfBook() {
        return numberOfBook;
    }

    public void selling() throws Exception {
    	if(this.numberOfBook <= 0) throw new Exception("재고가 부족함");
    	
    	System.out.println("구매됨 " + this.title);
    	this.numberOfBook -= 1;
    }
    
    public void printInfo() {
    	 System.out.printf("[제목: %s, 저자: %s, 개수: %d]\n", this.title, this.author, this.numberOfBook);
    }
    
    
    
    
}
