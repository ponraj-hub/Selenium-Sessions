package seleniumPrograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessConcept {
static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\chrome drivers\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("Window-size=1360,768");
		option.addArguments("headless");
	    driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http//:www.gmail.com");
		System.out.println("gmail opened");
		driver.quit();
		
		
	}

}
