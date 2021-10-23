package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import basePackage.CommonMethods;

public class LoginPage extends CommonMethods {
	
	public LoginPage(ChromeDriver driver) {
		this.driver = driver;
	}
	public LoginPage enterUsername(String uName) {
		driver.findElement(By.id("username")).sendKeys(uName);
		//Control stays in the same page, so return value is directed to the current class 
		//.class file is returned here, that can be achieved by using "this" keyword
		// "this" will create an object of current class which would be reused for all the 'this' usage in this class.
		return this; 
		
		
	}
	public LoginPage  enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
		return this;
	}
	public  CRMPage clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
		//Object of nextPage
		return new CRMPage(driver);
		
	}
}
