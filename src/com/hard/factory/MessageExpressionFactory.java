package com.hard.factory;

import com.hard.interpreter.Expression;
import com.hard.interpreter.MessageExpression;

public class MessageExpressionFactory implements ExpressionFactory {
	@Override
	public Expression getExpression(String data) {
		return new MessageExpression(data);
	}
}