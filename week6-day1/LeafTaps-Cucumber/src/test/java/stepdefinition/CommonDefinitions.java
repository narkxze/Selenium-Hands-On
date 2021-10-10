package stepdefinition;
import org.openqa.selenium.By;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonDefinitions extends BaseClass{
	@Given("The User enters {string} and {string}")
	 public void enterUserName(String uName, String uPass) {
	driver.findElement(By.id("username")).sendKeys(uName);
	driver.findElement(By.id("password")).sendKeys(uPass);
	 }
	@When("The User clicks Login")
	 public void clickLogin() {
	driver.findElement(By.className("decorativeSubmit")).click();
	 }
	@When("The User clicks {string}")
	public void clickButton(String buttonName) {
		driver.findElement(By.partialLinkText(buttonName)).click();
}
}
