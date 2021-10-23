package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import basePackage.CommonMethods;

public class ViewLeadPage extends CommonMethods {
	String leadID;
	
	public ViewLeadPage(ChromeDriver driver) {
		this.driver = driver;
	}

	public ViewLeadPage verifyFirstName() throws InterruptedException {
		Thread.sleep(3000);
		boolean text = driver.findElement(By.id("viewLead_firstName_sp")).isDisplayed();
		Assert.assertTrue(text);
		return this;
	}

	public CRMPage clickOpenTaps() {
		driver.findElement(By.linkText("opentaps")).click();
		return new CRMPage(driver);
		
	}
	public EditLeadPage clickEdit() {
		driver.findElement(By.xpath("(//a[@class='subMenuButton'])[3]")).click();
		return new EditLeadPage(driver);
	}
	
	public EditLeadPage clickDuplicate(){
		driver.findElement(By.xpath("(//a[@class='subMenuButton'])[1]")).click();
		return new EditLeadPage(driver);
	}
	
	public ViewLeadPage verifyCompanyName(String string) {
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		text = text.replaceAll("[^A-Za-z]+", "");
		Assert.assertEquals(string, text);
		return this;
	
	}
	
	

}
