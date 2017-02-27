package com.hard.interpreter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateRangeExpression implements Expression {
	private String data;
	
	public DateRangeExpression(String data) {
		this.data = data;
	}
	
	@Override
	public boolean interpret(String context) {
		// separation
		Pattern p = Pattern.compile("([0-9]{2}:[0-9]{2}:[0-9]{2}) *- *([0-9]{2}:[0-9]{2}:[0-9]{2})");
		Matcher m = p.matcher(data);
		
		String from = null;
		String to = null;
		while (m.find()) {
			from = m.group(1);
			to = m.group(2);
		}
		
		// combination
		Expression expression = new AndExpression(new DateGreaterExpression(from), new DateLessExpression(to));
		
		return expression.interpret(context);
	}
}