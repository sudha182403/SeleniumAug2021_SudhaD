package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapdealAssignment {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");	
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(1000);
		
		//Go to Mens Fashion
		WebElement elem = driver.findElement(By.xpath("(//span[@class='catText'])[6]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(elem).perform();
		
		//Go to Sports Shoes
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		
		//Get the count of the sports shoes
		WebElement w1 = driver.findElement(By.xpath("//h1[@category='Sports Shoes']/span"));
		String shoeCount = w1.getText();
		String shoeCountNum = shoeCount.replaceAll("[^0-9]", "");
		int count = Integer.parseInt(shoeCountNum);
		System.out.println("Sports shoes count: "+count);
		
		//Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
		//Sort by Low to High
		driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
		driver.findElement(By.xpath("//li[@class='search-li']")).click();
		Thread.sleep(1000);
		
		//Check if the items displayed are sorted correctly
		List<WebElement> prodPrice = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<String> prodPriceLinkLst = new ArrayList<String>();
		
		for (int i = 0; i < prodPrice.size(); i++) {
			prodPriceLinkLst.add(prodPrice.get(i).getText());
		}
		System.out.println("prodPriceLinkLst: "+prodPriceLinkLst);
		
		List<String> tempList = new ArrayList<String>(prodPriceLinkLst);		
		Collections.sort(tempList);
		
		System.out.println("templist: "+tempList);
		
		
		if(tempList.equals(prodPriceLinkLst)) {
			System.out.println("the products in this page are sorted from low to high");
		}else {
			System.out.println("the products in this page are not sorted from low to high");
		}
		
		JavascriptExecutor kse = (JavascriptExecutor) driver;
		
		//Mouse Hover on VSS Blue Training shoes
		kse.executeScript("window.scrollBy(0,400)");
		driver.findElementByXPath("//label[@for='Color_s-Blue']").click();
		Thread.sleep(3000);
		
		WebElement blueShoe = driver.findElement(By.xpath("//img[@title='VSS Blue Training Shoes']"));
		Actions b = new Actions(driver);
		kse.executeScript("window.scrollBy(0,400)");
		b.moveToElement(blueShoe).perform();
		
		//click QuickView button
	
		driver.findElementByXPath("//div[contains(text(),'Quick View')]").click();
		Thread.sleep(5000);
		
		//Print the cost and the discount percentage
		String blueShoePrice = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		blueShoePrice = blueShoePrice.replaceAll("[^\\d.]", "");
		System.out.println("Price of the blue shoes: "+blueShoePrice);
		
		String blueShoeDiscount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("Discount of the blue shoes: "+blueShoeDiscount);
		
		//Take snapshot of the shoes
		File src1 = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/snapdeal1.png");
		FileUtils.copyFile(src1, dst);
		
		//close
		driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click();
		
		Thread.sleep(1000);
		
		//Close the main window
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		
		//select the brand Puma
		driver.findElement(By.xpath("//label[@for='Brand-VSS']")).click();
	}
}
