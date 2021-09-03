package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JquerySortableAssignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.switchTo().frame(0);
		WebElement frm = driver.findElementByXPath("//li[text()='Item 1']");
		WebElement to = driver.findElementByXPath("//li[text()='Item 5']");
		
		Point p=to.getLocation();
		int x=p.getX();
		int y=p.getY();
		
		Actions builder=new Actions(driver);
		builder.dragAndDropBy(frm, x, y).perform();
		
	}

}
