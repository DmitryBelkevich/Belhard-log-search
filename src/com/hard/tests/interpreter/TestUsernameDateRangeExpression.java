package com.hard.tests.interpreter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hard.interpreter.UsernameDateRangeExpression;

public class TestUsernameDateRangeExpression {
	private UsernameDateRangeExpression usernameDateRangeExpression;
	
	@Before
	public void init() {
		String data = "10:00:00-11:00:00 [user1]";
		usernameDateRangeExpression = new UsernameDateRangeExpression(data);
	}
	
	@After
	public void destory() {
		usernameDateRangeExpression = null;
	}
	
	@Test
	public void testInterpret() {
		boolean b;
		
		b = usernameDateRangeExpression.interpret("10:00:00 [user1] Hello World");
		Assert.assertTrue(b);
		
		b = usernameDateRangeExpression.interpret("09:00:00 [user1] Hello World");
		Assert.assertFalse(b);
		
		b = usernameDateRangeExpression.interpret("10:00:00 [user2] Hello World");
		Assert.assertFalse(b);
	}
}