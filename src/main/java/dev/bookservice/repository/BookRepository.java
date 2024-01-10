package dev.bookservice.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
        
    public Book findBookLambda(Predicate<Book> oper) throws Exception {
    	for (int i = 0; i < bookList.size(); i++) {
			if(oper.test(bookList.get(i)))
				return bookList.get(i);
		}

    	throw new Exception("Book을 찾을수 없습니다.");
    }
}
