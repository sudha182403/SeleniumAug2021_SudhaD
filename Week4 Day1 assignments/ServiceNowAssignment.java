package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowAssignment {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev113545.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='gsft_main']")));	
		
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("w6hnF2FRhwLC");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		driver.findElement(By.id("filter")).sendKeys("incident");
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='gsft_main']")));	
		
		driver.findElement(By.xpath("//button[text()='New']")).click();
		System.out.println("new button is clicked");
		
		//click search icon of caller id
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);
		
		driver.switchTo().window(windowHandlesList.get(1));		
		
		//click first record
		driver.findElement(By.xpath("(//a[@role='button'])[7]")).click();
		System.out.println("first record in user list clicked");
		Thread.sleep(5000);
		driver.switchTo().window(windowHandlesList.get(0));
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='gsft_main']")));	
		
		//incident.short_description
		driver.findElement(By.id("incident.short_description")).sendKeys("sample desc");
		
		String incID = driver.findElement(By.id("incident.number")).getAttribute("value");
		
		//click submit button
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='gsft_main']")));	
		System.out.println("created incident id is "+incID);
		
		WebElement e1 = driver.findElement(By.xpath("//input[contains(@id,'_text')]"));
		e1.sendKeys(incID);
		e1.sendKeys(Keys.ENTER);
		
		String createdIncID = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		if(createdIncID.equals(incID)) {
			System.out.println("Incident created successfully for: "+incID);
		}
		
		File src1 = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/servicenow1.png");
		FileUtils.copyFile(src1, dst);
		
	}

}
