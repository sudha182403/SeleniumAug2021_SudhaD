package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JquerySelectableAssignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		
		//class=ui-widget-content ui-selectee
		
		Actions builder=new Actions(driver);
		driver.switchTo().frame(0);
		
		WebElement item1 = driver.findElement(By.xpath("(//li[@class='ui-widget-content ui-selectee'])[1]"));
		WebElement item5 = driver.findElementByXPath("(//li[@class='ui-widget-content ui-selectee'])[5]");
		
		builder.clickAndHold(item1).moveToElement(item5).release().perform();
		driver.switchTo().defaultContent();
	}

}
