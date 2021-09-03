package week4.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropAssignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		WebElement frame1 = driver.findElementByXPath("//div[@id='content']/iframe");
		
		driver.switchTo().frame(frame1);
		WebElement item1 = driver.findElementById("draggable");
		WebElement item2 = driver.findElementById("droppable");
		
		Actions builder=new Actions(driver);
		
		builder.dragAndDrop(item1, item2).perform();
		driver.switchTo().defaultContent();
	}

}
