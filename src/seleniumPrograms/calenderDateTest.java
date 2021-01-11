package seleniumPrograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calenderDateTest {
   static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","F:\\chrome drivers\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http:\\www.spicejet.com");
		Thread.sleep(5000);
		WebElement element =driver.findElement(By.id("ctl00_mainContent_view_date1"));
		String dateVal="20/10/2020";
		System.out.println("Depature date is : "+dateVal);
		
		selectDateByJS(driver,element,dateVal); 
		driver.close();
	}
	public static void selectDateByJS(WebDriver driver,WebElement element,String dateVal) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"')", element);
	}
}
