package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	
	 static WebDriver driver; 
	 
	 @BeforeMethod
	 public void setUpTest() {
		 System.setProperty("webdriver.chrome.driver","E:\\chrome drivers\\chromedriver.exe");
		    driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http:\\www.google.com");		
	 }
	 
	 @Test(priority=1,groups="Title",enabled=false)
	 public void verifyGoogleTitleTest() {
		String title =driver.getTitle();
		System.out.println("Title is :"+title);
		Assert.assertEquals(title,"Google","Title is Wrong");
	 }
	 
	 @Test(priority=2,groups="Logo")
	 public void verifyGoogleLogoTest() {
		boolean b= driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
		Assert.assertTrue(b);
		Assert.assertEquals(b,true);
	 }
	 
	 @Test(priority=3,groups="Link",enabled=false)
	 public void verifyGoogleLinkTest() {
		 boolean b=driver.findElement(By.linkText("Gmail")).isDisplayed();
	Assert.assertEquals(b,true);
	 }
	 
	 @AfterMethod()
	 public void close(){
		 driver.quit();
	 }
}
