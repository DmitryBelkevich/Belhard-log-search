package com.hard.factory;

import com.hard.interpreter.DateEqualsExpression;
import com.hard.interpreter.Expression;

public class DateExpressionFactory implements ExpressionFactory {
	@Override
	public Expression getExpression(String data) {
		return new DateEqualsExpression(data);
	}
}