package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DependsMethodsInNG {
 static WebDriver driver; 
	 
	 @BeforeMethod
	 public void setUpTest() {
		 System.setProperty("webdriver.chrome.driver","F:\\chrome drivers\\chromedriver.exe");
		    driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http:\\www.google.com");		
	 }
	 
	 @Test()
	 public void verifyGoogleTitleTest() {
		String title =driver.getTitle();
		System.out.println("Tile is :"+title);
	 }
	 
	 @Test(dependsOnMethods="verifyGoogleTitleTest")
	 public void verifyGoogleLogoTest() {
		boolean b= driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
		Assert.assertTrue(b);
	 }
	 
	 @Test(dependsOnMethods="verifyGoogleLogoTest")
	 public void verifyGoogleLinkTest() {
		 boolean b=driver.findElement(By.linkText("Gmail")).isDisplayed();
	Assert.assertTrue(b);
	 }
	 
	 @AfterMethod()
	 public void close(){
		 driver.quit();
	 }
}
