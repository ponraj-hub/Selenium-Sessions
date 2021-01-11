package seleniumPrograms;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverConcepts {
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","F:\\chrome drivers\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("http:\\www.spicejet.com");
		Actions action=new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(driver.findElement(By.id("highlight-addons"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'Visa Services')]")).click();
		String text=driver.findElement(By.xpath("//div[@class='traveller-details-heading about-heading-title']")).getText();
		Assert.assertEquals("VISA APPLICATION, NOW JUST A CLICK AWAY!", text);
		System.out.println("application closed");
        driver.quit();
	}
}
