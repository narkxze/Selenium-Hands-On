package week5.leaftaps;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DuplicateLead extends BaseClass{
	@Test(dataProvider="duplicateData")
	public void runDuplicateLead(String eMail) throws InterruptedException {
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys(eMail);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.name("submitButton")).click();
		System.out.println("Lead is Duplicated!");
	}
	
	@DataProvider(name="duplicateData")
	public String[][] duplicateLeadData() throws IOException{
		return DataStash.runDuplicateLead("DuplicateLead","Sheet1");
	}


}
