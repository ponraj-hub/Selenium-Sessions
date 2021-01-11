package seleniumPrograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		 
			System.setProperty("webdriver.chrome.driver","F:\\chrome drivers\\chromedriver.exe");
		    driver=new ChromeDriver();
		    driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://html.com/input-type-file/");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@id='fileupload']")).sendKeys("C:\\Users\\HI\\Desktop");
			Thread.sleep(5000);
			System.out.println("File Has Attached Successfully");
			driver.quit();

	}

}
