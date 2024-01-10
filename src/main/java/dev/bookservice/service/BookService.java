package dev.bookservice.service;

import java.util.List;

import dev.bookservice.model.Book;
import dev.bookservice.repository.BookRepository;

public class BookService {
	BookRepository bookRepository = new BookRepository();
	
    public void findAllBooks() {
        List<Book> bookList = bookRepository.getBookList();
        for (Book book : bookList) {
        	book.printInfo();
        }
    }

    public void findBookByTitle(String title) throws Exception  {
    	try {
    		Book book = bookRepository.findBookLambda((bookInfo) -> title.replaceAll(" ","").contains(bookInfo.getTitle().replaceAll(" ","")));
    		System.out.println("찾은 book 정보 :" );
    		book.printInfo();
    	} catch (Exception e) {
    		throw new Exception("제목 - '"+ title+ "'로 Book을 찾을수 없습니다." );
    	}
    }
    
    public void findBookByAuthor(String author) throws Exception {
    	try {
    		Book book = bookRepository.findBookLambda((bookInfo) -> author.replaceAll(" ","").contains(bookInfo.getAuthor().replaceAll(" ","")));
    		System.out.println("찾은 book 정보 :" );
    		book.printInfo();
    	}catch (Exception e) {
    		throw new Exception("저자 - '"+ author+ "'로 Book을 찾을수 없습니다." );
    	}
    }

    public void buyBook(String title) throws Exception {
    	try {
    		Book book = bookRepository.findBookLambda((bookInfo) -> title.replaceAll(" ","").contains(bookInfo.getTitle().replaceAll(" ","")));
    		book.selling();
    		System.out.printf("<구매 완료> \n제목: %s\n저자: %s\n", book.getTitle(), book.getAuthor());
    	} catch (Exception e) {
    		throw new Exception("구매하기전에 에러발생 제목 - '"+ title+ "'로 Book을 찾을수 없습니다." );
    	}
    }
}
