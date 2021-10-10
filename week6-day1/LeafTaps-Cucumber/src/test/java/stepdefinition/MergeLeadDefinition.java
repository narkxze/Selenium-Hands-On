package stepdefinition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MergeLeadDefinition extends BaseClass {
String leadID1;
List<String> fromWindows;
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
@When("The User enters to From Leads Window")
public void fromLeadsImage() {
	driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
	Set<String> fromWindowsSet = driver.getWindowHandles();
	 fromWindows = new ArrayList<String>(fromWindowsSet);
	driver.switchTo().window(fromWindows.get(1));
}
@When("The User enters the {string}")
public void fromLead(String Name) {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='firstName'])"))).sendKeys(Name+Keys.ENTER);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='"+Name+"'])[1]"))).click();
	driver.switchTo().window(fromWindows.get(0));
}
@When("The User enters to To Leads Window")
public void toLeadsImage() throws InterruptedException {
	Actions builder = new Actions(driver);
	WebElement toMergeTB = driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdTo']"));
	builder.click(toMergeTB);
	 leadID1= driver.findElement(By.id("ComboBox_partyIdFrom")).getAttribute("value");
	 driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	Set<String> toWindowsSet = driver.getWindowHandles();
	List<String> toWindows = new ArrayList<String>(toWindowsSet);
	driver.switchTo().window(toWindows.get(1));

}
@When("The User clicks {string} button")
public void mergeButton(String merge) {
	driver.findElement(By.linkText(merge)).click(); 
}
@When("The Alert is Handled")
public void handleAlert() throws InterruptedException {
	driver.switchTo().alert().accept();
	}
@Then("The Merge of Leads is Verified")
public void verifyMerge() throws InterruptedException {
	driver.findElement(By.linkText("Find Leads")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID1);
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(1000);
	String text = driver.findElement(By.className("x-paging-info")).getText();

	if (text.contains("No records to display") ) {
		System.out.println("Text matched");
	} else {
		System.out.println("Text not matched");
	}
}

}
