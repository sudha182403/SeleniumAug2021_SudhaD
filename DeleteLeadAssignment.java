package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLeadAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();
		
		//wait for 10 secs 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//locate the username and enter value in it
				WebElement webUser = driver.findElement(By.id("username"));
				webUser.sendKeys("demosalesmanager");
				
				//locate password and enter value in it
				driver.findElement(By.id("password")).sendKeys("crmsfa");
				
				//locate submit button and click
				driver.findElement(By.className("decorativeSubmit")).click();
				
				//locate CRM/SFA link and click
				driver.findElement(By.partialLinkText("SFA")).click();
				
				//click leads tab
				driver.findElement(By.linkText("Leads")).click();
				
				//Click Find leads
				driver.findElement(By.linkText("Find Leads")).click();
				
				//Click on Phone tab
				driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[2]")).click();
				
				//Enter phone number
				driver.findElement(By.name("phoneNumber")).sendKeys("12345678");
				
				//Click Find leads button
				driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
				
				//Capture lead ID of First Resulting lead
				WebElement id = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
				String text = id.getText();
				id.click();
				
				//Click Delete				
				driver.findElement(By.linkText("Delete")).click();	
				
				//	Click Find leads				
				driver.findElement(By.linkText("Find Leads")).click();
				
				//	Enter captured lead ID
				driver.findElement(By.id("id")).sendKeys(text);
				
				//Click Find leads button
				driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
				
				// Verify message "No records to display" in the Lead List. This message confirms the successful deletion
				String noRec = driver.findElement(By.className("x-paging-info")).getText();
				if(noRec == "No records to display") {
					System.out.println("Record deleted successfully");
				}				
				
				//	Close the browser (Do not log out)
				driver.close();				
				
	}

}
