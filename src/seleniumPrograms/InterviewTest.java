package seleniumPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InterviewTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\chrome drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("samsung tv");
        driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']")).click();
	}

}
