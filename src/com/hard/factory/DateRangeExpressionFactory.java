package com.hard.factory;

import com.hard.interpreter.DateRangeExpression;
import com.hard.interpreter.Expression;

public class DateRangeExpressionFactory implements ExpressionFactory {
	@Override
	public Expression getExpression(String data) {
		return new DateRangeExpression(data);
	}
}