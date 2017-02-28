package com.hard.tests.interpreter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hard.interpreter.DateEqualsExpression;

public class TestDateEqualsExpression {
	private DateEqualsExpression dateEqualsExpression;
	
	@Before
	public void init() {
		dateEqualsExpression = new DateEqualsExpression("10:00:00");
	}
	
	@After
	public void destroy() {
		dateEqualsExpression = null;
	}
	
	@Test
	public void testInterpret() {
		boolean b;
		
		b = dateEqualsExpression.interpret("09:00:01 [user1] Hello World");
		Assert.assertFalse(b);
		
		b = dateEqualsExpression.interpret("10:00:00 [user1] Hello World");
		Assert.assertTrue(b);
		
		b = dateEqualsExpression.interpret("10:00:01 [user1] Hello World");
		Assert.assertFalse(b);
	}
}