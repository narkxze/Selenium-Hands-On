package stepdefinition;

import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteLeadDefinition extends BaseClass {
	String leadID;
@When("The ID Information is Extracted")
public void userInformation() {
	 leadID = driver.findElement(By.id("viewLead_companyName_sp")).getText();
	leadID = leadID.replaceAll("[\\D]", "");
}
@Then("Deletion of Lead is Verified")
public void deleteLeadVerify() throws InterruptedException {
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
}
