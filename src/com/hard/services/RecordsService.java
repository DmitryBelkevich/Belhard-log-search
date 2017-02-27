package com.hard.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.hard.dao.RecordDao;
import com.hard.factory.DateExpressionFactory;
import com.hard.factory.DateGreaterExpressionFactory;
import com.hard.factory.DateLessExpressionFactory;
import com.hard.factory.DateRangeExpressionFactory;
import com.hard.factory.ExpressionFactory;
import com.hard.factory.MessageExpressionFactory;
import com.hard.factory.UsernameExpressionFactory;
import com.hard.interpreter.Expression;

public class RecordsService {
	private RecordDao recordDao = new RecordDao();
	
	public List<String> getAllRecords(File file) {
		return recordDao.getAllRecords(file);
	}
	
	public List<String> getAllRecordsByDate(File file, String data) {
		List<String> allRecords = recordDao.getAllRecords(file);
		List<String> filteredRecords = new ArrayList<>();
		
		ExpressionFactory expressionFactory = getExpressionFactoryByName("Date");
		
		Expression expression = expressionFactory.getExpression(data);
		
		for (String record : allRecords) {
			if (expression.interpret(record))
				filteredRecords.add(record);
		}
		
		return filteredRecords;
	}
	
	public List<String> getAllRecordsByDateGreater(File file, String data) {
		List<String> allRecords = recordDao.getAllRecords(file);
		List<String> filteredRecords = new ArrayList<>();
		
		ExpressionFactory expressionFactory = getExpressionFactoryByName("DateGreater");
		
		Expression expression = expressionFactory.getExpression(data);
		
		for (String record : allRecords) {
			if (expression.interpret(record))
				filteredRecords.add(record);
		}
		
		return filteredRecords;
	}
	
	public List<String> getAllRecordsByDateLess(File file, String data) {
		List<String> allRecords = recordDao.getAllRecords(file);
		List<String> filteredRecords = new ArrayList<>();
		
		ExpressionFactory expressionFactory = getExpressionFactoryByName("DateLess");
		
		Expression expression = expressionFactory.getExpression(data);
		
		for (String record : allRecords) {
			if (expression.interpret(record))
				filteredRecords.add(record);
		}
		
		return filteredRecords;
	}
	
	public List<String> getAllRecordsByDateRange(File file, String data) {
		List<String> allRecords = recordDao.getAllRecords(file);
		List<String> filteredRecords = new ArrayList<>();
		
		ExpressionFactory expressionFactory = getExpressionFactoryByName("DateRange");
		
		Expression expression = expressionFactory.getExpression(data);
		
		for (String record : allRecords) {
			if (expression.interpret(record))
				filteredRecords.add(record);
		}
		
		return filteredRecords;
	}
	
	public List<String> getAllRecordsByUsername(File file, String data) {
		List<String> allRecords = recordDao.getAllRecords(file);
		List<String> filteredRecords = new ArrayList<>();
		
		ExpressionFactory expressionFactory = getExpressionFactoryByName("Username");
		
		Expression expression = expressionFactory.getExpression(data);
		
		for (String record : allRecords) {
			if (expression.interpret(record))
				filteredRecords.add(record);
		}
		
		return filteredRecords;
	}
	
	public List<String> getAllRecordsByMessage(File file, String data) {
		List<String> allRecords = recordDao.getAllRecords(file);
		List<String> filteredRecords = new ArrayList<>();
		
		ExpressionFactory expressionFactory = getExpressionFactoryByName("Message");
		
		Expression expression = expressionFactory.getExpression(data);
		
		for (String record : allRecords) {
			if (expression.interpret(record))
				filteredRecords.add(record);
		}
		
		return filteredRecords;
	}
	
	private static ExpressionFactory getExpressionFactoryByName(String expressionFactoryName) {
		switch (expressionFactoryName) {
		case "Date":
			return new DateExpressionFactory();
		case "DateGreater":
			return new DateGreaterExpressionFactory();
		case "DateLess":
			return new DateLessExpressionFactory();
		case "DateRange":
			return new DateRangeExpressionFactory();
		case "Username":
			return new UsernameExpressionFactory();
		case "Message":
			return new MessageExpressionFactory();
		default:
			throw new RuntimeException(expressionFactoryName + " is not exist");
		}
	}
	
	public void addRecords(File file, String content) {
		recordDao.addRecords(file, content);
	}
}