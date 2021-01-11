package com.dataprovider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HalfEbayTest {
  WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","F:\\chrome drivers\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://scgi.half.ebay.com/ws/eBay.ISAPI.dll?RegisterEnterInfo&usage-2943&ru=");
	}
	
	@Test
	public void halfEbaytest(String firstname,String lastname,String address1,String address2,String city,String state,
			String zipcode,String emailAddress) {
		driver.findElement(By.xpath("//*[@id='firstname']")).clear();
		driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys(firstname);
		driver.findElement(By.xpath("//*[@id='lastname']")).clear();
		driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys(lastname);
		driver.findElement(By.xpath("//*[@id='address1']")).clear();
		driver.findElement(By.xpath("//*[@id='address1']")).sendKeys(address1);
		driver.findElement(By.xpath("//*[@id='address1']")).clear();
		driver.findElement(By.xpath("//*[@id='address1']")).sendKeys(address2);
		driver.findElement(By.xpath("//*[@id='city']")).clear();
		driver.findElement(By.xpath("//*[@id='city']")).sendKeys(city);
		Select select=new Select(driver.findElement(By.xpath("//*[@id='state']")));
		select.selectByVisibleText(state);
		driver.findElement(By.xpath("//*[@id='zip']")).clear();
		driver.findElement(By.xpath("//*[@id='zip']")).sendKeys(zipcode);
		driver.findElement(By.xpath("//*[@id='email']")).clear();
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//*[@id='retype_email']")).clear();
		driver.findElement(By.xpath("//*[@id='retype_email']")).sendKeys(emailAddress);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
