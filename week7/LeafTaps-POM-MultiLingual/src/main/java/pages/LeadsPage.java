package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import basePackage.CommonMethods;

public class LeadsPage extends CommonMethods {

	public LeadsPage(ChromeDriver driver) {
		this.driver = driver;
	}


	public CreateLeadPage clickCreateLead() {
		driver.findElement(By.xpath(prop.getProperty("LeadsPage.CreateLead.xPath"))).click();
		return new CreateLeadPage(driver);
	}
	
	public FindLeadPage clickFindLead() {
		driver.findElement(By.linkText(prop.getProperty("FindLeadPage.FindLead.xPath"))).click();
		return new FindLeadPage(driver);
	}
	
	public MergeLeadsPage clickMergeLead() {
		driver.findElement(By.linkText("Merge Leads")).click();
		return new MergeLeadsPage(driver);
	}
	
}
