package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLeafSortableAssignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sortable.html");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		
		WebElement item1 = driver.findElement(By.xpath("//li[@class='ui-state-default ui-sortable-handle']"));
		WebElement item5 = driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-arrowthick-2-n-s'])[5]"));
		
		Point p=item5.getLocation();
		int x=p.getX();
		int y=p.getY();
		System.out.println(p);
		
		Actions builder= new Actions(driver);
		builder.dragAndDropBy(item1, x, y).perform();
		
	}

}
