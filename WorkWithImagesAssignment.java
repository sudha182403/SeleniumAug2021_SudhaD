package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithImagesAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		
		//Click 1st image
		driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns'])/img")).click();
		
		driver.findElement(By.linkText("Image")).click();
		
		WebElement errLink = driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns'])[2]/img"));
		String errVal = errLink.getAttribute("src");
		if(errVal == "error.html") {
			System.out.println("Image is broken");
		}else {
			System.out.println("Image is not broken");
		}
	}

}
