package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CherCherFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//navigate to frame
		driver.switchTo().frame(driver.findElement(By.id("frame1")));
		//enter value in the textbox
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Sample");
		
		//switch to inner frame
		driver.switchTo().frame(driver.findElement(By.id("frame3")));
		//click the checkbox
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		//switch back to main window
		driver.switchTo().defaultContent();
		
		//switch to frame2
		driver.switchTo().frame(driver.findElement(By.id("frame2")));
		WebElement s1 = driver.findElement(By.id("animals"));
		Select s = new Select(s1);
		s.selectByIndex(2);
		
		//switch back to main window
		driver.switchTo().defaultContent();
	}

}
