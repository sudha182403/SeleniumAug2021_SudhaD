package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadsAssignment {

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
				WebElement webUser = driver.findElement(By.id("username"));
				webUser.sendKeys("demosalesmanager");
				
				//locate password and enter value in it
				driver.findElement(By.id("password")).sendKeys("crmsfa");
				
				//locate submit button and click
				driver.findElement(By.className("decorativeSubmit")).click();
				
				//locate CRM/SFA link and click
				driver.findElement(By.partialLinkText("SFA")).click();
                
				String title = "My Home | opentaps CRM";
				String homeTitle = driver.getTitle();
				
				if(title.equalsIgnoreCase(homeTitle)) {
					System.out.println("Logged in successfully");
				}else {
					System.out.println("Authentication failed");
				}
				
				
				//click leads tab
				driver.findElement(By.linkText("Leads")).click();
				
				//click Create lead button
				driver.findElement(By.linkText("Create Lead")).click();
				
				//enter company name
				driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Test User1");
				
				//enter first name
				WebElement fDriver = driver.findElement(By.id("createLeadForm_firstName"));
				fDriver.sendKeys("UserOne");
				
				//enter last name
				driver.findElement(By.id("createLeadForm_lastName")).sendKeys("LOne");
				
				//source drop-down
				WebElement drop1 = driver.findElement(By.id("createLeadForm_dataSourceId"));
				Select drpDwn = new Select(drop1);				
				drpDwn.selectByValue("LEAD_EMPLOYEE");
				
				//marketingCampaign drop-down
				WebElement drop2 = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
				Select drpDwn1 = new Select(drop2);
				drpDwn1.selectByIndex(3);
				
				//createLeadForm_industryEnumId
				WebElement drop3 = driver.findElement(By.id("createLeadForm_industryEnumId"));
				Select drpDwn2 = new Select(drop3);
				drpDwn2.selectByVisibleText("Media");
				
				//enter createLeadForm_primaryPhoneCountryCode
				WebElement countryCode = driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode"));
				countryCode.clear();
				countryCode.sendKeys("5");
				
				
				//enter DOB field
				driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("01/18/1988");
				
				//Area code - createLeadForm_primaryPhoneAreaCode
				driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("044");
				
				//Phone number - createLeadForm_primaryPhoneNumber
				driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("26820442");
				
				//Extension - createLeadForm_primaryPhoneExtension
				driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("1234");
				
				//Primary Ask for name - createLeadForm_primaryPhoneAskForName
				driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Vijay");
				
				//email - createLeadForm_primaryEmail
				driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("sudha@gmail.com");
				
				//web url - createLeadForm_primaryWebUrl
				driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("www.xyz.com");				
				
				//Enter all the text fields in primary address
				
				//To Name - createLeadForm_generalToName
				driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("SudhaD");	
				
				//Attention Name - createLeadForm_generalAttnName
				driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Vijay");	
				
				//Address Line1 - createLeadForm_generalAddress1
				driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("No.123, ABC apartments");	
				
				//Address Line2 - createLeadForm_generalAddress2
				driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("Houston");	
				
				//City - createLeadForm_generalCity
				driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("WA");	
				
				//State drop-down - createLeadForm_generalStateProvinceGeoId
				WebElement dropState = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
				Select drpDwnState = new Select(dropState);
				drpDwnState.selectByIndex(5);	
				
				//zip code - createLeadForm_generalPostalCode
				driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("45678");	
				
				//Country drop-down createLeadForm_generalCountryGeoId
				WebElement dropCountry = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
				Select drpDwCountry = new Select(dropCountry);
				drpDwCountry.selectByIndex(3);	
				
				//Zip code extn - createLeadForm_generalPostalCodeExt
				driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("4344");
				
				//get firstname and print	
				String fname = fDriver.getAttribute("value"); 
				System.out.println("First name value is "+fname);
				
				//click create lead button
				driver.findElement(By.name("submitButton")).click();
				
				//Get and Verify the Title of the resulting Page(View Lead)
				String viewLeadTitle = "View Lead | opentaps CRM";
				String viewLeadPgTitle = driver.getTitle();
				
				if(viewLeadTitle.equalsIgnoreCase(viewLeadPgTitle)) {
					System.out.println("Lead created successfully");
				}else {
					System.out.println("Lead creation failed");
				}				
				
	}

}
