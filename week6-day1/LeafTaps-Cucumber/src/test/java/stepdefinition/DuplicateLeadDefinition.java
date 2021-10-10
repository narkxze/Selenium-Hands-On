package stepdefinition;
import org.openqa.selenium.By;
import io.cucumber.java.en.Then;

public class DuplicateLeadDefinition extends BaseClass{
	@Then("Verification of Duplication Lead {string}")
public void duplicateLeadVerify(String name) {
	String text = driver.findElement(By.id("viewLead_firstName_sp")).getText();
	if(text.contains(name)) {
		System.out.println("Duplication of Lead is successful!");
	}
}
}
