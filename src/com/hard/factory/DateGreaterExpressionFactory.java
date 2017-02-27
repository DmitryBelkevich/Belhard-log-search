package com.hard.factory;

import com.hard.interpreter.DateGreaterExpression;
import com.hard.interpreter.Expression;

public class DateGreaterExpressionFactory implements ExpressionFactory {
	@Override
	public Expression getExpression(String data) {
		return new DateGreaterExpression(data);
	}
}