package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraClassAssignment {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement elem = driver.findElement(By.xpath("//a[text()='Men']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(elem).perform();
		
		driver.findElement(By.xpath("//a[text()='Jackets']")).click();
		
		String items = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		
		//The [^0-9] expression is used to find any character that is NOT a digit.
		String jacketCount = items.replaceAll("[^0-9]", "");	
		int jc1 = Integer.parseInt(jacketCount);
		System.out.println("Count of jackets: "+jc1);
		
		String itemsCount = driver.findElement(By.xpath("//span[@class='categories-num']")).getText();
		String jacketCatCount = itemsCount.replaceAll("[^0-9]", "");
		int jc2 = Integer.parseInt(jacketCatCount);
		System.out.println("jacket count in category: "+jc2);
		
		String rainJktItemsCount = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		String rainJacketCatCount = rainJktItemsCount.replaceAll("[^0-9]", "");
		int jc3 = Integer.parseInt(rainJacketCatCount);
		System.out.println("rain jacket count in category: "+jc3);
		
		int overallJktCnt = jc2+jc3;
		System.out.println("Total jacket count in category: "+overallJktCnt);
		
		if(jc1 == overallJktCnt) {
			System.out.println("Total jackets matches");
		}else {
			System.out.println("Total jacket count not matched");
		}
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//label[contains(text(),'Jackets')]")).click();
		
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		
		driver.findElement(By.className("FilterDirectory-searchInput")).sendKeys("Duke");
		driver.findElement(By.xpath("//label[contains(text(),'Duke')]")).click();
		
		driver.findElement(By.xpath("//span[contains(@class,'sprites-remove')]")).click();
		
		//List<WebElement> brandList = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		List<WebElement> brandList = driver.findElements(By.tagName("h3"));
		for (int i = 0; i < brandList.size(); i++) {
			String brandVal = brandList.get(i).getText();
			if(brandVal.equals("Duke")) {
				System.out.println("Its a Duke Product");
			}else {
				System.out.println("This is not a Duke Product");
			}
			
		}
		
		WebElement webMen = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(webMen).perform();
		
		driver.findElement(By.xpath("//input[@value='discount']"));
		
		String firstJacketPrice = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
		System.out.println("firstJacketPrice: "+firstJacketPrice);
		
		//String firstJacketPriceModf = firstJacketPrice.replaceAll("[^0-9]", "");
		driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).click();
		
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);
		
		driver.switchTo().window(windowHandlesList.get(1));
		System.out.println("New window opened and its title is: "+driver.getTitle());
		
		File src1 = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/myntra1.png");
		FileUtils.copyFile(src1, dst);
		
		driver.findElement(By.xpath("//div[contains(@class,'pdp-add-to-wishlist')]")).click();		
		
		//to close the current window
		driver.close();
		
	}

}
