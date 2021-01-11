package seleniumPrograms;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapConcepts {
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","F:\\chrome drivers\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.findElement(By.xpath("//button[@type='button']")).click();
		List<WebElement>list=driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//li//a//label"));
		System.out.println(list.size());
		for(int i =0;i<list.size();i++) {
			if(list.get(i).getText().contains("Angular")) {
				list.get(i).click();
				break;
			}
			System.out.println(list.get(i).getText());
			list.get(i).click();
         }	
		System.out.println("Printed Angular");
		driver.quit();
		
}
}