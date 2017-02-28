package com.hard.factory;

import com.hard.interpreter.Expression;
import com.hard.interpreter.UsernameDateRangeExpression;

public class UsernameDateRangeExpressionFactory implements ExpressionFactory {
	@Override
	public Expression getExpression(String data) {
		return new UsernameDateRangeExpression(data);
	}
}