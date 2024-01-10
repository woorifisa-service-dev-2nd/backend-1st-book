package dev.bookservice.util;

import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import dev.bookservice.BookServiceApplication;

public class MyLogger {
	
	private static final Logger logger = LogManager.getLogger(BookServiceApplication.class.getName());
	
	public MyLogger(){
//			FileHandler file = null;
//			try {
//				file = new FileHandler("service-log.txt");
//				
//				logger.addHandler(file);
//				
//				Formatter logFormatter = new CoustomFormatter();
//				
//				file.setFormatter(logFormatter);
//				
//			} catch (SecurityException | IOException  e) {
//				e.printStackTrace();
//			}
			
		}
	public Logger getLogger() {
		return logger;
	}
}
class CoustomFormatter extends Formatter{
				
	@Override
	public String format(LogRecord record) {
		return  new Date(record.getMillis()).toString() + "::\n" + record.getLevel() + " : "  + record.getMessage() + "\n";
	}
	
	
}
