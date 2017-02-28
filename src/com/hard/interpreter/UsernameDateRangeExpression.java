package com.hard.interpreter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernameDateRangeExpression implements Expression {
	private String data;
	
	public UsernameDateRangeExpression(String data) {
		this.data = data;
	}
	
	@Override
	public boolean interpret(String context) {
		// separation
		Pattern p = Pattern.compile("([0-9]{2}:[0-9]{2}:[0-9]{2} *- *[0-9]{2}:[0-9]{2}:[0-9]{2}) *" + "\\[" + "(.*)" + "\\]");
		Matcher m = p.matcher(data);
		
		String username = null;
		String dateRange = null;
		while (m.find()) {
			username = m.group(2);
			dateRange = m.group(1);
		}
		
		// combination
		Expression expression = new AndExpression(new UsernameExpression(username), new DateRangeExpression(dateRange));
		
		return expression.interpret(context);
	}
}