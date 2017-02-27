package com.hard.factory;

import com.hard.interpreter.Expression;
import com.hard.interpreter.UsernameExpression;

public class UsernameExpressionFactory implements ExpressionFactory {
	@Override
	public Expression getExpression(String data) {
		return new UsernameExpression(data);
	}
}