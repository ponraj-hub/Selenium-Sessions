package seleniumPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class crossBrowserUtilityTest {
	
    static WebDriver driver;
	public static void main(String[] args) {
	
		crossBrowserUtilityTest.opensessionof("Chrome");
		driver.get("http:\\www.google.com");
		driver.findElement(By.id("hplogo"));
		System.out.println("Google title is :" +driver.getTitle());
		driver.close();	
	}
	
	public static void opensessionof(String browserName) {	
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver","E:\\chrome drivers\\chromedriver.exe");
		     driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.gecko.driver","E:\\chrome drivers\\geckodriver.exe");
		     driver=new FirefoxDriver();
		}else {
			try {
				System.out.println("invalid browser name");
			}catch(Exception e) {
				e.printStackTrace();
			}			
		}			
	}
}

