package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseClass;

public class LoginPage extends BaseClass {
 
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public HomePage passloginCredentials(String uName, String uPass) {
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys(uName);
		driver.findElement(By.id("user_password")).sendKeys(uPass);
		driver.findElement(By.id("sysverb_login")).click();
		return new HomePage(driver);
	}
	
}
