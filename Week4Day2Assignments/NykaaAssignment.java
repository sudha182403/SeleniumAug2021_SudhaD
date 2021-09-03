package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//mouse hover on brands menu
		WebElement webMen = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(webMen).perform();
		
		//mouse hover on popular menu
		WebElement webPop = driver.findElement(By.xpath("//a[text()='Popular']"));
		Actions builder2 = new Actions(driver);
		builder2.moveToElement(webPop).perform();
		
		//Click L'Oreal Paris
		driver.findElement(By.xpath("//div[@id='brandCont_Popular']//a[contains(@href,'loreal-paris')]")).click();
		
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);
		
		//Go to the newly opened window 
		driver.switchTo().window(windowHandlesList.get(1));
		System.out.println("Opened new window name is : "+driver.getTitle());
		
		//check the title contains L'Oreal Paris
		WebElement e1 = driver.findElement(By.xpath("//title[contains(text(),'Oreal Paris')]"));
		System.out.println("title get: "+e1.getText());
		
		// Click sort By and select customer top rated
		driver.findElement(By.xpath("//div[@class='sort-wrapper closed']")).click();//click sort by drop-down
		driver.findElement(By.xpath("//span[contains(text(),'customer top rated')]")).click();
		Thread.sleep(1000);
		
		////Click Category and click Shampoo		
		driver.findElement(By.xpath("//div[contains(text(),'Category')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Personal Care')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Shower')]")).click();		
		driver.findElement(By.xpath("//span[text()='Shampoo']//following::div[1]")).click();
		
		WebElement shampoo = driver.findElement(By.xpath("//div[@class='filter-applied']//following::li[1]"));
		String shampooFilterVal = shampoo.getText();
		
		if(shampooFilterVal.contains("Shampoo")) {
			System.out.println("Filter contains Shampoo");
		}else {
			System.out.println("Filter does not contain shampoo");
		}
		
		//Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("(//div[@class='clearfix'])[2]")).click();
		driver.findElement(By.xpath("(//div[@class='clearfix'])[8]")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']//following::div")).click();
		Thread.sleep(1000);
		
		//GO to the new window and select size as 175ml
		driver.findElementByXPath("(//div[@class='m-content__product-list__title'])[1]/h2").click();
		Set<String> windowHandlesSet1 = driver.getWindowHandles();
		List<String> windowHandlesList1 = new ArrayList<String>(windowHandlesSet1);
		
		driver.switchTo().window(windowHandlesList1.get(2));
		System.out.println("Opened new window name for colour protect shampoo is : "+driver.getTitle());
		
		driver.findElement(By.xpath("//span[text()='175ml']")).click();
		
		//Print the MRP of the product
		String shampooPrice = driver.findElement(By.xpath("//span[@class='post-card__content-price-offer']")).getText();
		String shampooTrim = shampooPrice.replaceAll("[^0-9]", "");			
		System.out.println("Shampoo price is: "+shampooTrim);
		
		//Click on ADD to BAG
		driver.findElement(By.xpath("//button[contains(@class,'product-list__cart-btn')]")).click();
		driver.findElement(By.xpath("//div[@class='AddBagIcon']")).click();
		Thread.sleep(1000);
		
		//print the grand total
		WebElement grandTotal = driver.findElement(By.xpath("//div[@class='value medium-strong']"));
		Thread.sleep(1000);
		String grandTotVal=grandTotal.getText();
		String grandCount = grandTotVal.replaceAll("[^0-9]", "");	
		System.out.println("Grand total is : "+grandCount);
		Thread.sleep(7000);
		
		//Click Proceed
		driver.findElement(By.xpath("//div[@class='second-col']")).click();
		
		//Click on Continue as Guest
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		
		//Check if this grand total value is same as above
		String pymtGrandTotal = driver.findElement(By.xpath("//div[text()='Grand Total']/following::div")).getText();
		String pymtGrandCount = pymtGrandTotal.replaceAll("[^0-9]", "");	
		System.out.println("Grand total in shipping page: "+pymtGrandCount);
		
		if(grandCount.equals(pymtGrandCount)) {
			System.out.println("Grand Total matches in both places");
		}else {
			System.out.println("Grand total mismatches. Pls check once.");
		}
		
		driver.switchTo().window(windowHandlesList.get(0));
	}

}
