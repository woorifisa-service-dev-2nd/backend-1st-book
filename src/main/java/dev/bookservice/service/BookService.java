package dev.bookservice.service;

import dev.bookservice.model.Book;
import dev.bookservice.parser.BookInfoParser;
import dev.bookservice.repository.BookRepository;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookService {
	BookRepository bookRepository = new BookRepository();
	
    public void findAllBooks() {
        List<Book> bookList = bookRepository.getBookList();
        for (Book book : bookList) {
        	book.printInfo();
        }
    }

    public void findBookByTitle(String title) throws Exception {
        Book book = bookRepository.findByTitle(title);
        System.out.println("찾은 book 정보 :" );
        book.printInfo();
        
    }

    public void findBookByAuthor(String author) throws Exception {
    	 Book book = bookRepository.findByAuthor(author);
         System.out.println("찾은 book 정보 :" );
         book.printInfo();
    	
    }

    public void buyBook(String title) throws Exception {
    	 Book book = bookRepository.findByTitle(title);
         
         book.selling();
         System.out.printf("<구매 완료> \n제목: %s\n저자: %s\n", book.getTitle(), book.getAuthor());
    
    }
}
