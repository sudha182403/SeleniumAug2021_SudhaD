package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverActionAssignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/mouseOver.html");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement webMen = driver.findElement(By.className("btnMouse"));
		Actions builder = new Actions(driver);
		builder.moveToElement(webMen).perform();
		
		//String e1 = driver.findElement(By.linkText("Selenium")).getText();
		//driver.findElement(By.xpath("//a[@class='listener']"))
		List<WebElement> list1 = driver.findElements(By.xpath("//a[@class='listener']"));
		List<String> list2 = new ArrayList<String>();
		
		for (int i = 0; i < list1.size(); i++) {
			list2.add(list1.get(i).getText());
		}
		
		System.out.println("List of menus when mouse over"+list2);
		
		driver.findElement(By.linkText("Selenium")).click();
		
		Alert alert = driver.switchTo().alert();			
		System.out.println("Content in alert: "+alert.getText());
		alert.accept();
		
		
	}

}
