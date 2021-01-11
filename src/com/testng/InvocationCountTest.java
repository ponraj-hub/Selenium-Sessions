package com.testng;

import org.testng.annotations.Test;

public class InvocationCountTest {

	@Test(invocationCount=5)
	public void sum() {
		int a=10;
		int b=10;
		int c=a+b;
		System.out.println("sum is :"+c);
	}
}
