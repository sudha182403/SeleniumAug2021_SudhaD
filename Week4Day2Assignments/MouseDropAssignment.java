package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class MouseDropAssignment {

	public static void main(String[] args) {
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drop.html");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement dragEl = driver.findElementById("draggable");
		System.out.println(dragEl.getText());
		
		WebElement dropEl = driver.findElementById("droppable");
		System.out.println(dropEl.getText());
		
		Actions builder= new Actions(driver);
		builder.dragAndDrop(dragEl,dropEl).perform();
		System.out.println(dropEl.getText());

	}

}
