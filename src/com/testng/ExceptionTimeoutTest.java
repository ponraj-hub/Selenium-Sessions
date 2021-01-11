package com.testng;

import org.testng.annotations.Test;

public class ExceptionTimeoutTest { 
	/*@Test(invocationTimeOut=1000,expectedExceptions=NumberFormatException.class)
	public void infiniteloop() {
		int i=1;
		while(i==1) {
			System.out.println(i);
		}*/
	@Test(expectedExceptions=NumberFormatException.class)
	public void sum() {
		String x="100A";
		Integer.parseInt(x);
	}
	
}
