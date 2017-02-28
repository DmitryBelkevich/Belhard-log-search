package com.hard.tests.interpreter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hard.interpreter.DateGreaterExpression;

public class TestDateGreaterExpression {
	private DateGreaterExpression dateGreaterExpression;
	
	@Before
	public void init() {
		dateGreaterExpression = new DateGreaterExpression("10:00:00");
	}
	
	@After
	public void destroy() {
		dateGreaterExpression = null;
	}
	
	@Test
	public void testInterpret() {
		boolean b;
		
		b = dateGreaterExpression.interpret("09:00:01 [user1] Hello World");
		Assert.assertFalse(b);
		
		b = dateGreaterExpression.interpret("10:00:00 [user1] Hello World");
		Assert.assertTrue(b);
		
		b = dateGreaterExpression.interpret("10:00:01 [user1] Hello World");
		Assert.assertTrue(b);
	}
}