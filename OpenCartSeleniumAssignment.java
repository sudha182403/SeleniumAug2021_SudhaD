package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCartSeleniumAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com/index.php?route=account/register");
		
		//input-username
		driver.findElement(By.id("input-username")).sendKeys("SudhaD");
		
		//input-firstname
		driver.findElement(By.id("input-firstname")).sendKeys("Sudha");
		
		//input-lastname
		driver.findElement(By.id("input-lastname")).sendKeys("Dharma");
		
		//input-email
		driver.findElement(By.id("input-email")).sendKeys("sudha@gmail.com");
		
		//input-country
		WebElement drp1 = driver.findElement(By.id("input-country"));
		Select s1 = new Select(drp1);
		s1.selectByIndex(99);
		
		//input-password
		driver.findElement(By.id("input-password")).sendKeys("password.1");
		
		//button-register
		//driver.findElement(By.id("button-register")).click();
		
	}

}
