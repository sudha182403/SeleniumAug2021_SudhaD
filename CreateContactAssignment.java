package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//locate CRM/SFA link and click
		driver.findElement(By.partialLinkText("SFA")).click();
		
		//Click on Contacts menu
		driver.findElement(By.linkText("Contacts")).click();
		
		//Click on Create Contact - Create Contact
		driver.findElement(By.linkText("Create Contact")).click();
		
		//Enter FirstName Field Using id Locator
		driver.findElement(By.id("firstNameField")).sendKeys("UnameOne");
		
		//Enter LastName Field Using id Locator
		driver.findElement(By.id("lastNameField")).sendKeys("LnameTwo");
		
		//Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("FLone");
		
		//Enter LastName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("LLone");
		
		//Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("QA");
		
		//Enter Description Field Using any Locator of your choice 
		driver.findElement(By.id("createContactForm_description")).sendKeys("Sample Description");
		
		//Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("sudha@gmail.com");
		
		//Select State/Province as NewYork Using Visible Text
		WebElement elem = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select s1 = new Select(elem);
		s1.selectByValue("AZ");
		
		//Click on Create Contact
		//Create Contact
		driver.findElement(By.className("smallSubmit")).click();
		
		//Click on edit button 
		driver.findElement(By.linkText("Edit")).click();
		
		//Clear the Description Field using .clear
		driver.findElement(By.id("updateContactForm_description")).clear();
		
		//Fill ImportantNote Field with Any text
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Important announcement");
		
		//Click on update button using Xpath locator
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		//Get the Title of Resulting Page.
		String title = "View Contact | opentaps CRM";
		String homeTitle = driver.getTitle();
		
		if(title.equalsIgnoreCase(homeTitle)) {
			System.out.println("Contact updated successfully");
		}else {
			System.out.println("Contact update failed");
		}		
		
	}

}
