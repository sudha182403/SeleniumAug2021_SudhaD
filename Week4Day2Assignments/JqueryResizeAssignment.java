package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryResizeAssignment {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		
		WebElement frame1 = driver.findElementByXPath("//div[@id='content']/iframe");
		driver.switchTo().frame(frame1);
		WebElement mouse = driver.findElement(By.xpath("//div[contains(@class,'ui-icon-gripsmall-diagonal-se')]"));
		WebElement box = driver.findElement(By.id("resizable"));
		
		Actions builder=new Actions(driver);
		//builder.clickAndHold(mouse).moveToElement(box, 100, 100).release().perform();
		builder.dragAndDropBy(box, 100, 150).perform();
	}

}
