package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithRadioButtonAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/radio.html");
		
		driver.findElement(By.id("yes")).click();
		
		//news		
		Boolean a = driver.findElement(By.xpath("(//input[@name='news'])[2]")).isSelected();
		if(a==true) {
			System.out.println("Checked option is selected");
		}else {
			System.out.println("Unchecked option is selected");
		}		
		
		driver.findElement(By.xpath("//label[contains(text(),'Select your age group')]")).click();
		
	}

}
