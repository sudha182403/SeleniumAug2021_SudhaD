package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithDropdownsAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		
		//id="dropdown1"
		WebElement elem1 = driver.findElement(By.id("dropdown1"));
		Select s1 = new Select(elem1);
		s1.selectByIndex(1);
		
		//name="dropdown2"
		WebElement elem2 = driver.findElement(By.name("dropdown2"));
		Select s2 = new Select(elem2);
		s2.selectByVisibleText("Appium");
		
		//id="dropdown3"
		WebElement elem3 = driver.findElement(By.id("dropdown3"));
		Select s3 = new Select(elem3);
		s3.selectByValue("3");
		
		//dropdown-4
		WebElement elem4 = driver.findElement(By.className("dropdown"));
		Select s4 = new Select(elem4);
		//List<WebElement> listS4 = s4.getOptions();
		System.out.println("Number of options in the dropdown is "+s4.getOptions().size());
		
		//dropdown 5
		driver.findElement(By.xpath("(//div[@class='example'])[5]/select")).sendKeys("Loadrunner");
		
		//(//div[@class='example'])[6]
		WebElement elem5 = driver.findElement(By.xpath("(//div[@class='example'])[6]/select"));
		Select s5 = new Select(elem5);
		s5.selectByIndex(1);
		s5.selectByIndex(2);		
		
	}

}
