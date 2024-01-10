package dev.bookservice.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import dev.bookservice.BookServiceApplication;
import dev.bookservice.model.Book;

public class BookInfoParser {
    private final String RESOURCES = "src/main/resources/";
   
    public List<Book> parseFromTxtFileToBookList() {
    	  List<Book> bookList = new ArrayList<Book>();
    	  List<String> lines = new ArrayList<>();


//        try (InputStream inputStream = BookServiceApplication.class.getResourceAsStream("/resources/" + "book-data.txt");
//				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"))) {
//			String line;
//			
//			while ((line = reader.readLine()) != null) {
//				lines.add(line);
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
    	  
        try {
        	final Path path = Paths.get(RESOURCES + "book-data.txt");
        	lines = Files.readAllLines(path);
        } catch (IOException e) {
			e.printStackTrace();
		}
      
        for (String line : lines) {
            String[] columns = line.split("-");
            String title = columns[0];
            String author = columns[1];
            int numberOfBook = Integer.parseInt(columns[2]);

            bookList.add(new Book(title, author, numberOfBook));
        }
        return bookList;
    }
}
