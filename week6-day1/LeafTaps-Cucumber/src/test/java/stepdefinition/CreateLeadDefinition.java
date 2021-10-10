package stepdefinition;
import org.openqa.selenium.By;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLeadDefinition extends BaseClass{

@When("The User enters Mandatory Credentials {string} {string} {string}")
public void leadFillUp(String cName, String fName, String lName) {
	driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
	driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
	driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
}
@When("The User clicks Submit")
public void submitButton() {
	driver.findElement(By.className("smallSubmit")).click();
}
@Then("Lead Creation is verified {string}")
 public void verifyLeadCreation(String fName) {
	String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
	if(text.contains(fName)) {
		System.out.println("Lead Creation is successful!");
	}else {
		System.out.println("not successful");
		}
	}
}
