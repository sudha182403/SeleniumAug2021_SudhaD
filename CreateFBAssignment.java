package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateFBAssignment {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//click create new account button
		driver.findElement(By.linkText("Create New Account")).click();
		
		//enter firstname
		driver.findElement(By.name("firstname")).sendKeys("Sudha");
		
		//enter lastname
		driver.findElement(By.name("lastname")).sendKeys("V");
		
		//enter mobile number - u_i_g_NC
		driver.findElement(By.name("reg_email__")).sendKeys("1234567890");
		
		//password_step_input
		driver.findElement(By.id("password_step_input")).sendKeys("Password.1");
		
		//DOB - date field
		WebElement drop1 = driver.findElement(By.name("birthday_day")); 
		Select drpDwn = new Select(drop1);				
		drpDwn.selectByValue("18");
		
		//DOB - month field
		WebElement drop2 = driver.findElement(By.id("month")); 
		Select drpDwn1 = new Select(drop2);				
		drpDwn1.selectByIndex(3);
		
		//DOB - year field
		WebElement drop3 = driver.findElement(By.id("year")); 
		Select drpDwn2 = new Select(drop3);				
		drpDwn2.selectByVisibleText("1986");
		
		//Gender id - u_i_4_gz
		//driver.findElement(By.id("u_i_4_gz")).click();
		driver.findElement(By.className("_58mt")).click();
		
		//submit
		driver.findElement(By.name("websubmit")).click();
		
		
		

	}

}
