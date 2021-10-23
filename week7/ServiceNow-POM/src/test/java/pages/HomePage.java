package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.BaseClass;

public class HomePage extends BaseClass {

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage enterFilterText(String filterText) {
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys(filterText+Keys.ENTER);
		return this;
				
	}
	
	public TasksPage selectWork() {
		Actions builder = new Actions(driver);
		WebElement myWork = driver.findElement(By.linkText("My Work"));
		builder.moveToElement(myWork).click().build().perform();
		return new TasksPage(driver);
	}
}
