package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithEditFieldsAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		
		driver.findElement(By.id("email")).sendKeys("sudha@gmail.com");
		
		WebElement ele = driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns'])[2]/input"));
		ele.sendKeys("testleaf");
		ele.sendKeys(Keys.TAB);
		
		//username
		WebElement ele1 = driver.findElement(By.name("username"));
		String uname = ele1.getAttribute("value");
		System.out.println("Default text entered is "+uname);
		
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();
		
		Boolean b1 = driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns'])[5]/input")).isEnabled();
		System.out.println("Confirm that edit field is enabled: "+b1);
		
	}

}
