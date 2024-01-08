package dev.bookservice.repository;

import java.util.ArrayList;
import java.util.List;

import dev.bookservice.model.Book;
import dev.bookservice.parser.BookInfoParser;

public class BookRepository {
    private List<Book> bookList = new ArrayList<>();

    public BookRepository() {
	    final BookInfoParser bookInfoParser = new BookInfoParser();
	    bookList = bookInfoParser.parseFromTxtFileToBookList();
	}
    
    public List<Book> getBookList() {
        return bookList;
    }
    
    public Book findByIndex(int index) {
    	return bookList.get(index);
    }
    
    public Book findByTitle(String title) throws Exception {
    	for (int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getTitle().equals(title))
				return bookList.get(i);
		}
    	throw new Exception("검색 결과가 없습니다.");
    }
    
    public Book findByAuthor(String author) throws Exception {
    	for (int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getAuthor().equals((author)))
				return bookList.get(i);
		}
    	throw new Exception("검색 결과가 없습니다.");
    }
}
