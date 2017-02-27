package com.hard.interpreter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernameExpression implements Expression {
	private String data;
	
	public UsernameExpression(String data) {
		this.data = data;
	}
	
	@Override
	public boolean interpret(String context) {
		Pattern p = Pattern.compile(".*\\[" + data + "\\].*");
		Matcher m = p.matcher(context);
		
		return m.matches();
	}
}