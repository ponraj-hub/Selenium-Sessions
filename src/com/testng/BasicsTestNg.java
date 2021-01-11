package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicsTestNg {
	//PreRequisites
	@BeforeSuite 
		public void setup() {
			System.out.println(" Before Suite --- Setup the browser ");
	}

	@BeforeTest 
	public void launchBrowser () {
		System.out.println("Before Test --- launch the browser");
	}

	@BeforeClass 
	public void enterURL () {
		System.out.println("Before Class --- Enter the URL");
	}

	@BeforeMethod 
	public void enterLogin() {
		System.out.println("Before Method --- Enter the Login");
	}

	@Test 
	public void GoogleTitleTest() {
		System.out.println("Test1 --- Google Title Test");
	}

	@Test
	public void searchData() {
			System.out.println("Test2 --- Searching the data");
	}

	@Test
	public void verifyData() {
		System.out.println("Test3 --- veriy the data");
	}

	//PostRequisites
	@AfterMethod 
	public void logout() {
		System.out.println("AfterMetod --- logout from the aplication");
	}

	@AfterClass() 
	public void closeBrowser() {
		System.out.println("AfterClass --- close the browser");
	}

	@AfterTest  
	public void deleteCookies() {
		System.out.println("AfterTest --- Delete all cookies");
	}

}
