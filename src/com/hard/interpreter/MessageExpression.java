package com.hard.interpreter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageExpression implements Expression {
	private String data;
	
	public MessageExpression(String data) {
		this.data = data;
	}
	
	@Override
	public boolean interpret(String context) {
		Pattern p = Pattern.compile(".*\\] " + ".*" + data + ".*");
		Matcher m = p.matcher(context);
		
		return m.matches();
	}
}