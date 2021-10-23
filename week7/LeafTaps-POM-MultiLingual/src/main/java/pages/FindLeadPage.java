package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import basePackage.CommonMethods;

public class FindLeadPage extends CommonMethods {
	String leadID;

	public FindLeadPage(ChromeDriver driver) {
		this.driver = driver;
	}
	

	public FindLeadPage(ChromeDriver driver, String leadID) {
		this.driver=driver;
		this.leadID=leadID;
	}


	public FindLeadPage enterName(String fName) {
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(fName+Keys.ENTER);
		return this;
	}
	public ViewLeadPage clickfirstLead() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		return new ViewLeadPage(driver);
	}
	public void verifyLeadID() throws InterruptedException {
		
		  driver.findElement(By.linkText(prop.getProperty("FindLeadPage.FindLead.xPath"))).click(); 
		  Thread.sleep(2000);
		  driver.findElement(By.name("id")).sendKeys(leadID);
		  driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		  Thread.sleep(1000);
		  String text = driver.findElement(By.className("x-paging-info")).getText();
		  Assert.assertEquals(text,"No records to display");
		 
		
	}
	
}
