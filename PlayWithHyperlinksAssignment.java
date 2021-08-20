package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PlayWithHyperlinksAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		
		driver.findElement(By.linkText("Go to Home Page")).click();
		
		driver.findElement(By.linkText("HyperLink")).click();
		
		WebElement link = driver.findElement(By.partialLinkText("Find where am supposed to go"));
		String x = link.getAttribute("href");
		System.out.println("href value is "+x);
		
		WebElement errLink = driver.findElement(By.xpath("//a[contains(text(),'Verify am I broken?')]"));
		String errVal = errLink.getAttribute("href");
		if(errVal == "error.html") {
			System.out.println("Link is broken");
		}
		
		driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns'])[4]/a")).click();
		driver.findElement(By.linkText("HyperLink")).click();
		
		driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns'])[5]/a")).click();
		
		List<WebElement> links = driver.findElements(By.xpath("//div[@class='large-6 small-12 columns']"));
		System.out.println("Total number of links in this page are "+links.size());
	}

}
