package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDragAssignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drag.html");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement e1 = driver.findElement(By.id("content"));
		
		Point pos=e1.getLocation();
		int x=(pos.getX());
		int y=(pos.getY());
		
		Actions builder=new Actions(driver);
		WebElement drag = driver.findElement(By.id("draggable"));
		builder.dragAndDropBy(drag, x, y).perform();	

	}

}
