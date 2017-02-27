package com.hard.interpreter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateLessExpression implements Expression {
	private String data;
	
	public DateLessExpression(String data) {
		this.data = data;
	}
	
	@Override
	public boolean interpret(String context) {
		// get hh:mm:ss from Data
		Pattern p = Pattern.compile("([0-9]{2}):([0-9]{2}):([0-9]{2})");
		Matcher m = p.matcher(data);
		
		int hh = 0;
		int mm = 0;
		int ss = 0;
		
		while (m.find()) {
			hh = Integer.parseInt(m.group(1));
			mm = Integer.parseInt(m.group(2));
			ss = Integer.parseInt(m.group(3));
		}
		
		// get hh:mm:ss from Context
		Pattern pCtx = Pattern.compile("([0-9]{2}):([0-9]{2}):([0-9]{2})" + " \\[.*");
		Matcher mCtx = pCtx.matcher(context);
		
		int hhCtx = 0;
		int mmCtx = 0;
		int ssCtx = 0;
		
		while (mCtx.find()) {
			hhCtx = Integer.parseInt(mCtx.group(1));
			mmCtx = Integer.parseInt(mCtx.group(2));
			ssCtx = Integer.parseInt(mCtx.group(3));
		}
		
		// comparison
		//if (hhCtx <= hh && mmCtx <= mm && ssCtx < ss)
		//	return true;
		
		if (hhCtx < hh) {
			return true;
		} else if (hhCtx == hh) {
			if (mmCtx < mm) {
				return true;
			} else if (mmCtx == mm) {
				if (ssCtx < ss) {	// если хотим включительно, то ставим <=
					return true;
				}
			}
		}
		
		return false;
	}
}