package stepdefinition;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditLeadDefinition extends BaseClass{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	
	@When("The User enters {string}")
	public void enterCredentials(String fName) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='firstName'])[3]"))).sendKeys(fName+Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='"+fName+"'])[1]"))).click();
	}
	@When("The User updates to {string}")
	public void updateCompany(String newCName) {
		WebElement textBox = driver.findElement(By.id("updateLeadForm_companyName"));
		textBox.clear();
		textBox.sendKeys(newCName);
	}
	@When("The User clicks Update")
	public void updateButton() {
		driver.findElement(By.className("smallSubmit")).click();
	}
	@Then("The Update of Lead is Verified {string}")
	public void verifyLeadUpdation(String newCName) {
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if(text.contains(newCName)) {
			System.out.println("Lead Updation is successful!");
		}else {
			System.out.println("not successful");
			}
		}
}
