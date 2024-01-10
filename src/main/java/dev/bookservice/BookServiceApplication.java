package dev.bookservice;

import java.util.Scanner;

import org.apache.logging.log4j.Logger;

import dev.bookservice.service.BookService;
import dev.bookservice.util.Color;
import dev.bookservice.util.MyLogger;


public class BookServiceApplication {
    public static void main(String[] args) {
    	BookService bookService = null;

	    Logger logger = new MyLogger().getLogger();
    	   
    	try {
    	    bookService = new BookService();
    	} catch (Exception e) {
    	    System.out.println("파일 읽지 못했습니다. 애플리케이션이 종료됩니다.");
    	    System.exit(0);
    	}
        
        controllPrint();
        Scanner sc = new Scanner(System.in,"Euc-kr");
        while(true) {
            String input = sc.nextLine();
            try {
	            switch (input) {
	                case "1":
	                    // 목록 조회
	                    bookService.findAllBooks();
	                    break;
	                case "2": // 책 검색
	            		String titleOrAuthor = scanInput(sc,"1: 제목으로 검색\n2: 저자로 검색");
	                    if (titleOrAuthor.equals("1")) {
	                        bookService.findBookByTitle(scanInput(sc, "제목을 입력하세요."));
	                    } else if (titleOrAuthor.equals("2")) {
	                        bookService.findBookByAuthor(scanInput(sc, "저자를 입력하세요."));
	                    }                    
	                    break;
	                case "3":                	
	                	String title = scanInput(sc,"구매할 책의 제목을 적어주세요.\n");
	               
	                    bookService.buyBook(title);         	
	                	
	                    System.out.println("\n남은 현황");
	                    bookService.findAllBooks();
	                    break; 
	                case "4":
	                    System.exit(0);
	                default:
	                    System.out.println("1, 2, 3 중에 입력해주세요.");
	            }}
	            catch(Exception e) {
	             	logger.warn(e.getMessage());
	            	System.out.println("\n"+Color.RED +e.getMessage()+ Color.RESET);
	            }
	            controllPrint();
        }
    }
    
    static void controllPrint() {
    	System.out.print(Color.BLUE +"메뉴를 선택하세요.\n" +
                "1: 책 목록 보기\n" +
                "2: 책 검색하기\n" +
                "3: 책 구매하기\n" +
                "4: 종료하기\n" + Color.RESET);
    }
    static String scanInput(Scanner sc ,String msg) {
    	 System.out.println(msg);
         return sc.nextLine();
    }
}
