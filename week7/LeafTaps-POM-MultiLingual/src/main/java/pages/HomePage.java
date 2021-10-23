package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import basePackage.CommonMethods;

public class HomePage extends CommonMethods {
	public HomePage(ChromeDriver driver) {
		this.driver = driver; 
	}

	public LeadsPage clickLeads() {
		driver.findElement(By.linkText(prop.getProperty("HomePage.Leads.LinkText"))).click();
		return new LeadsPage(driver);
	}
}
