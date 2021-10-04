package week5.leaftaps;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class DeleteLead extends BaseClass {
	@Test(dataProvider="deleteData")
	public void runDeleteLead(String name) throws InterruptedException {
	driver.findElement(By.linkText("Find Leads")).click();
	driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(name);
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(2000);
	String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.findElement(By.linkText("Delete")).click();
	driver.findElement(By.linkText("Find Leads")).click();
	driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(1000);
	String text = driver.findElement(By.className("x-paging-info")).getText();
	if (text.equals("No records to display")) {
		System.out.println("Text matched");
	} else {
		System.out.println("Text not matched");
	}
}
	@DataProvider(name="deleteData")
	public String[][] deleteLeadData() throws IOException{
		return DataStash.runDeleteLead("DeleteLead","Sheet1");
	}
}
