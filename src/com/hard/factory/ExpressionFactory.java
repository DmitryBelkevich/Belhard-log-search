package com.hard.factory;

import com.hard.interpreter.Expression;

public interface ExpressionFactory {
	public Expression getExpression(String data);
}