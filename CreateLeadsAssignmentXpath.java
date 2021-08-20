package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadsAssignmentXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  WebDriverManager.chromedriver().setup(); 
		  ChromeDriver driver=new ChromeDriver();
			
				driver.get("http://leaftaps.com/opentaps/control/main");
				//max the browser
				driver.manage().window().maximize();
				
				//wait for 10 secs 
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//locate the username and enter value in it
				WebElement webUser = driver.findElement(By.xpath("//input[@id='username']"));				
				webUser.sendKeys("demosalesmanager");
				
				//locate password and enter value in it
				driver.findElement(By.id("password")).sendKeys("crmsfa");
				
				//locate submit button and click
				driver.findElement(By.className("decorativeSubmit")).click();
				
				//locate CRM/SFA link and click
				//driver.findElement(By.partialLinkText("SFA")).click();
				driver.findElement(By.xpath("//a[contains(text(),'/SFA'")).click();
                
				String title = "My Home | opentaps CRM";
				String homeTitle = driver.getTitle();
				
				if(title.equalsIgnoreCase(homeTitle)) {
					System.out.println("Logged in successfully");
				}else {
					System.out.println("Authentication failed");
				}
				
				
				//click leads tab
				//driver.findElement(By.linkText("Leads")).click();
				//Leads
				driver.findElement(By.xpath("//a[contains(text(),'Leads'")).click();
				
				//click Create lead button
				//driver.findElement(By.linkText("Create Lead")).click();
				driver.findElement(By.xpath("//a[contains(text(),'Create Lead'")).click();
				
				//enter company name
				//driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Test User1");
				
				driver.findElement(By.xpath("//form[@id='createLeadForm_companyName'")).sendKeys("Test User2");
				
				
				//enter first name
				//createLeadForm_firstName
				driver.findElement(By.xpath("//form[@id='createLeadForm_firstName'")).sendKeys("UserTwo");
				
				
				//enter last name
				driver.findElement(By.xpath("//form[@id='createLeadForm_lastName'")).sendKeys("LTwo");		
						
				
	}

}
