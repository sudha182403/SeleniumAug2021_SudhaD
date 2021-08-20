package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLeadAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*http://leaftaps.com/opentaps/control/main
		 
		1	Launch the browser
		2	Enter the username
		3	Enter the password
		4	Click Login
		5	Click crm/sfa link
		6	Click Leads link
		7	Click Find leads
		8	Click on Email
		9	Enter Email
		10	Click find leads button
		11	Capture name of First Resulting lead
		12	Click First Resulting lead
		13	Click Duplicate Lead
		14	Verify the title as 'Duplicate Lead'
		15	Click Create Lead
		16	Confirm the duplicated lead name is same as captured name
		17	Close the browser (Do not log out)
		
		*/
		
		
		 WebDriverManager.chromedriver().setup(); 
		  ChromeDriver driver=new ChromeDriver();
			
				driver.get("http://leaftaps.com/opentaps/control/main");
				//max the browser
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
				
				//Click on Email tab
				driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[3]")).click();
				
				//Enter Email
				////input[@name='emailAddress']
				driver.findElement(By.name("emailAddress")).sendKeys("sudha@gmail.com");
				
				//Click find leads button
				driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
				
				//Capture name of First Resulting lead and click it
				WebElement fname = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])/a");
				String text1 = fname.getText();
				System.out.println("Name of the 1st result is "+text1);
				fname.click();
				
				//Click Duplicate Lead
				driver.findElement(By.xpath("//button[text()='Duplicate Lead']")).click();
				
				//Verify the title as 'Duplicate Lead'
				String title = "Duplicate Lead | opentaps CRM";
				String homeTitle = driver.getTitle();
				
				if(title.equalsIgnoreCase(homeTitle)) {
					System.out.println("Duplicate lead page loaded");
				}
				
				//Click Create Lead
				driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
				
				//Confirm the duplicated lead name is same as captured name
				String text2 = driver.findElement(By.id("createLeadForm_firstName")).getAttribute("value");
				driver.findElementByClassName("smallSubmit").click();
				if (text1.equals(text2)) {
					System.out.println("The lead is duplicate");
				}
				
				//Close the browser (Do not log out)
				driver.close();				
				
	}

}
