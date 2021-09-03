package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAssignment {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement srch = driver.findElement(By.id("twotabsearchtextbox"));
		srch.sendKeys("oneplus 9 pro");
		srch.sendKeys(Keys.ENTER);
		
		JavascriptExecutor kse = (JavascriptExecutor) driver;	
		
		String firstProdPrice = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		String firstProdPriceTrim = firstProdPrice.replaceAll("$", "");
		System.out.println("Price of the first product in search result: "+firstProdPriceTrim);
		
		//Print the number of customer ratings for the first displayed product
		WebElement custRat = driver.findElement(By.xpath("//a[@class='a-link-normal']/span[@class='a-size-base']"));
		System.out.println("Customer rating: "+custRat.getText());
		
		// Mouse Hover on the stars
		WebElement elem = driver.findElement(By.xpath("//i[@class='a-icon a-icon-star-small a-star-small-4 aok-align-bottom']"));
		Actions b1 = new Actions(driver);
		b1.moveToElement(elem).click().perform();
		System.out.println("mouse over on ratings");
		
		// Get the percentage of ratings for the 5 star.
		WebElement star = driver.findElement(By.xpath("(//span[@class='a-size-base'])[22]"));
		System.out.println("% of 5 star rating of 1st product is: "+star.getText());
		
		// Click the first text link of the first image
		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
		
		//switch to newly opened window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandle = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowHandle.get(1));
		
		// Take a screen shot of the product displayed
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dtn = new File("./snaps/Amazon1.png");
		FileUtils.copyFile(src, dtn);
		
		// Click 'Add to Cart' button
		kse.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(3000);
		
		// Get the cart subtotal and verify if it is correct.		
		String cartProdPrice = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println("cart price before regex: "+cartProdPrice);
		String cartProdPriceTrim = cartProdPrice.replaceAll("$", "");
		System.out.println("Price of the first product in Cart: "+cartProdPriceTrim);
		
		if(firstProdPriceTrim.equals(cartProdPriceTrim)) {
			System.out.println("Price matches in both places");
		}else {
			System.out.println("Price not matched");
		}
		
		Thread.sleep(3000);
		
		//switch back to main window
		driver.switchTo().window(windowHandle.get(0));
	}

}
