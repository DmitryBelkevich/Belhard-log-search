package com.hard.factory;

import com.hard.interpreter.DateLessExpression;
import com.hard.interpreter.Expression;

public class DateLessExpressionFactory implements ExpressionFactory {
	@Override
	public Expression getExpression(String data) {
		return new DateLessExpression(data);
	}
}