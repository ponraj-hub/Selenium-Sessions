package seleniumPrograms;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandlerTest {
       static WebDriver driver;
       
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","F:\\chrome drivers\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("http:\\popuptest.com/goodpopups.html");
		driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td/font/b/a[1]")).click();
		driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td/font/b/a[3]")).click();
		Thread.sleep(2000);
		
		Set<String>handler=driver.getWindowHandles();
		Iterator<String>it=handler.iterator();
		
		String parentWindowId=it.next();
		System.out.println("parent windowId :" + parentWindowId);
		
		String childWindowId=it.next();
		System.out.println("child windowId :" + childWindowId);
		
		String childWindowId2=it.next();
		System.out.println("third windowId :" + childWindowId2);
		
		driver.switchTo().window(childWindowId2);
		Thread.sleep(2000);
		System.out.println("third windowId popup title  is :"+driver.getTitle());
		driver.close();
		
		driver.switchTo().window(childWindowId);
		Thread.sleep(2000);
		System.out.println("Child WidowID popup title is :"+driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		Thread.sleep(2000);
		System.out.println("parent windowID popup title is :"+driver.getTitle());
		driver.quit();
		
	}

}
