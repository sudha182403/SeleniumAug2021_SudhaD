package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateLeadAssignment extends BaseClassAssignment{
	
	@Test
	public  void Createlead() {		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Sudha");
		driver.findElement(By.id("lastNameField")).sendKeys("Vijay");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("SudhaV");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Vijayakumar");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("IT");
		driver.findElement(By.id("createContactForm_description")).sendKeys("test");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("sudha@gmail.com");

		WebElement Drop = driver.findElement(By.name("generalStateProvinceGeoId"));
		Select drpDwn1 = new Select(Drop);
		drpDwn1.selectByVisibleText("New York");

		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Sample");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String Title = driver.getTitle();
		System.out.println("The title of the page is:"+Title);

	}
}
