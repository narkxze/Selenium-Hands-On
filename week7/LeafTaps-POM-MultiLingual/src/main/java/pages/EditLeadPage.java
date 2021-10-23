package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import basePackage.CommonMethods;

public class EditLeadPage extends CommonMethods {
	
 public EditLeadPage(ChromeDriver driver) {
	 this.driver = driver;
 }
 public EditLeadPage updateCompanyName(String cName) {
	WebElement companyTextBox = driver.findElement(By.id("updateLeadForm_companyName"));
	companyTextBox.clear();
	companyTextBox.sendKeys(cName);
	return this;
 }
 
 public ViewLeadPage clickUpdate() {
	 driver.findElement(By.name("submitButton")).click();
	 return new ViewLeadPage(driver);
 }
}
