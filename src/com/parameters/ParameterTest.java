package com.parameters;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ParameterTest {
	WebDriver driver;
	@Test	
	@Parameters({"env","browser","url","username","password"})
	public void loginTest(String env,String browser,String url,String username,String password) {
		
		if(browser.equalsIgnoreCase("chrome")) {
	System.setProperty("webdriver.chrome.driver","F:\\chrome drivers\\chromedriver.exe");
    driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("FF")) {
	System.setProperty("webdriver.gecko.driver","F:\\chrome drivers\\geckodriver.exe");
    driver=new FirefoxDriver();
		}else {
			System.out.println("not valid browser given");
		}
		
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(url);
	
	driver.findElement(By.id("identifierId")).clear();
	driver.findElement(By.id("identifierId")).sendKeys(username);
	driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
	
	driver.findElement(By.xpath("//input[@type='password']")).clear();
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
	driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
	
     }
}