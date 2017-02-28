package com.hard.tests.interpreter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hard.interpreter.DateLessExpression;

public class TestDateLessExpression {
	private DateLessExpression dateLessExpression;
	
	@Before
	public void init() {
		dateLessExpression = new DateLessExpression("10:00:00");
	}
	
	@After
	public void destroy() {
		dateLessExpression = null;
	}
	
	@Test
	public void testInterpret() {
		boolean b;
		
		b = dateLessExpression.interpret("09:00:01 [user1] Hello World");
		Assert.assertTrue(b);
		
		b = dateLessExpression.interpret("10:00:00 [user1] Hello World");
		Assert.assertFalse(b);
		
		b = dateLessExpression.interpret("10:00:01 [user1] Hello World");
		Assert.assertFalse(b);
	}
}