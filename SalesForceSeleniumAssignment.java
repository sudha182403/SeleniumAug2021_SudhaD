package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceSeleniumAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");
		
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//FirstName
		driver.findElement(By.name("UserFirstName")).sendKeys("Sudha");
		
		//Last name
		driver.findElement(By.name("UserLastName")).sendKeys("Dharma");
		
		//work email
		driver.findElement(By.name("UserEmail")).sendKeys("sudha@gmail.com");
		
		WebElement elem1 = driver.findElement(By.name("UserTitle"));
		Select drp1 = new Select(elem1);
		drp1.selectByValue("IT_Manager_AP");
		
		//CompanyName-CC6l
		driver.findElement(By.name("CompanyName")).sendKeys("ABC Pvt Ltd");
		
		//Employees
		WebElement elem2 = driver.findElement(By.name("CompanyEmployees"));
		Select drp2 = new Select(elem2);
		drp2.selectByIndex(2);
		
		//UserPhone-NNG8
		driver.findElement(By.name("UserPhone")).sendKeys("1234567890");
		
		//CompanyCountry-eYpM
		WebElement elem3 = driver.findElement(By.name("CompanyCountry"));
		Select drp3 = new Select(elem3);
		drp3.selectByIndex(5);
		
		//SubscriptionAgreement
		driver.findElement(By.className("checkbox-ui")).click();
		
		driver.close();
		
		
	}

}
