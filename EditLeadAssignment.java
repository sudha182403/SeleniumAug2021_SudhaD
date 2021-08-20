package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLeadAssignment {

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
		
		//Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Test User1");		
		
		//Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//Click on first resulting lead
		//driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		//driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		driver.findElementByXPath("//a[text()='Test User1']").click();
		
		
		//Verify title of the page
		String title = "View Lead | opentaps CRM";
		String homeTitle = driver.getTitle();
		
		if(title.equalsIgnoreCase(homeTitle)) {
			System.out.println("View lead page loaded");
		}
		
		//Click Edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		//Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("testleafnew");
		
		//Click Update
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		//Confirm the changed name appears
		String s = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("Updated Lead company name is "+s);
		
		//Close the browser (Do not log out)
		driver.close();
		
		
	}

}
