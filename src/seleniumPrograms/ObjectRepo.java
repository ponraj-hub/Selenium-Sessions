package seleniumPrograms;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ObjectRepo {
	static WebDriver driver=null;
	public static void main(String[] args) throws IOException {
		Properties props=new Properties();
		FileInputStream ip=new FileInputStream("F:\\Automation Projects\\ProjectAutomation\\SeleniumSession\\src\\seleniumPrograms\\config.properties");
		props.load(ip);
		String url=props.getProperty("url");
		System.out.println("URL is" +url);
		String browsername=props.getProperty("browser");
		System.out.println("Browser Name is " +browsername);
		
		if(driver==null) {
		if(browsername.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver","F:\\chrome drivers\\chromedriver.exe");
		     driver=new ChromeDriver();  
		}else if(browsername.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.gecko.driver","F:\\chrome drivers\\geckodriver.exe");
		     driver=new FirefoxDriver();
		}else {
			try {
				System.out.println("invalid browser name");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		driver.get(url);
		try {
			Thread.sleep(2000);
		driver.findElement(By.xpath(props.getProperty("firstname_xpath"))).sendKeys(props.getProperty("firstname"));
		driver.findElement(By.xpath(props.getProperty("lastname_xpath"))).sendKeys(props.getProperty("lastname"));
		driver.findElement(By.xpath(props.getProperty("city_xpath"))).sendKeys(props.getProperty("city"));
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Recoreds updated");
		}
		driver.quit();	
	}
	}
}
