package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContactAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
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
		driver.findElement(By.linkText("Contacts")).click();
		
		//click merge contacts menu
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		//Click on Widget of From Contact
		driver.findElement(By.xpath("//img[@alt='Lookup'][1]")).click();
		
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);
		
		driver.switchTo().window(windowHandlesList.get(1));
		String findCont = driver.getTitle();
		
		if(findCont.equals("Find Contacts")) {
			System.out.println("Inside Find Contacts new window");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Click on First Resulting Contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])/a")).click();
		
		Thread.sleep(1000);
		driver.switchTo().window(windowHandlesList.get(0));
		
		//Click on Widget of To Contact
		driver.findElement(By.xpath("//a[contains(@href,'partyIdTo')]/img")).click();
		
		Set<String> windowHandlesSet1 = driver.getWindowHandles();
		List<String> windowHandlesList1 = new ArrayList<String>(windowHandlesSet1);
		driver.switchTo().window(windowHandlesList1.get(1));

		String findCont1 = driver.getTitle();
		
		if(findCont1.equals("Find Contacts")) {
			System.out.println("Inside Find Contacts window2");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Click on second Resulting Contact
		driver.findElement(By.xpath("((//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])/a)[2]")).click();
		Thread.sleep(5000);
		driver.switchTo().window(windowHandlesList1.get(0));
		
		//click merge button
		driver.findElement(By.linkText("Merge")).click();
		System.out.println("clicked merge");
		Alert alert = driver.switchTo().alert();		
		alert.accept();
		System.out.println("alert accepted");
		// opentaps CRM
		String mainPg = driver.getTitle();

		if(mainPg.equals("View Contact | opentaps CRM")) {
			System.out.println("In opentaps CRM page");
		}
		
	}

}
