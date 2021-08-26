package week3.day2;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AjioAssignment {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		//ChromeDriver driver = new ChromeDriver();
		
		//Create a map to store  preferences 
				Map<String, Object> prefs = new HashMap<String, Object>();

				//add key and value to map as follow to switch off browser notification
				//Pass the argument 1 to allow and 2 to block
				prefs.put("profile.default_content_setting_values.notifications", 2);

				//Create an instance of ChromeOptions 
				ChromeOptions options = new ChromeOptions();

				// set ExperimentalOption - prefs 
				options.setExperimentalOption("prefs", prefs);

				//Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome driver which will switch off this browser notification on the chrome browser
				WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.ajio.com/");
		
		//search for bags and press enter button
		WebElement e1 = driver.findElement(By.name("searchVal"));
		e1.sendKeys("bags");
		e1.sendKeys(Keys.ENTER);		
		
		//select Men gender checkbox
		driver.findElement(By.xpath("//label[contains(text(),'Men')]")).click();
		
		//select fashion bags under category
		driver.findElement(By.xpath("//label[contains(text(),'Fashion Bags')]")).click();
		
		Thread.sleep(5000);
		
		String items = driver.findElement(By.xpath("//div[@class='length']")).getText();
		System.out.println("Items found: "+items);		
				
		List<WebElement> brandName = driver.findElements(By.xpath("//div[@class='brand']"));	
		
		for (WebElement brandList:brandName) {
            System.out.println("Name of Brands: "+brandList.getText());               
        }		
		
		List<WebElement> prodName = driver.findElements(By.xpath("//div[@class='name']"));
		
		for(WebElement prodList:prodName) {
			System.out.println("Product Names: "+prodList.getText());
		}		
		
	}
}
