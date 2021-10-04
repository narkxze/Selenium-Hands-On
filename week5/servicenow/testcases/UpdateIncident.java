package servicenow;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UpdateIncident extends BaseClass{
	
	@Test(dataProvider="UpdateData")
	public void runUpdateIncident(String state, String urgency, String impact, String priority) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[text()='Incidents'])[2]"))).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//button[@name='vcr_last'])[1]")).click();
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//table[@id='incident_table']/tbody[1]/tr[20]/td[3]/a[1]")).click();
		//wait.until(ExpectedConditions.visibilityOf(lastPage)).click();
		//wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(lastPage))).click();
		String incidentNo = driver.findElement(By.id("incident.number")).getAttribute("value");
		WebElement stateDropdown = driver.findElement(By.id("incident.state"));
		stateDropdown.click();
		Select stateOptions = new Select(stateDropdown);
		stateOptions.selectByVisibleText(state);
		WebElement urgencyDropdown = driver.findElement(By.id("incident.urgency"));
		urgencyDropdown.click();
		Select urgencyOptions = new Select(urgencyDropdown);
		urgencyOptions.selectByVisibleText(urgency);
		/*
		 * WebElement priorityBox =
		 * driver.findElement(By.xpath("label.incident.priority")); Select
		 * priorityOptions = new Select(priorityBox);
		 * priorityOptions.selectByVisibleText(priority);
		 */
		WebElement impactDropdown = driver.findElement(By.id("incident.impact"));
		impactDropdown.click();
		Select impactOptions = new Select(impactDropdown);
		impactOptions.selectByVisibleText(impact);
		driver.findElement(By.id("sysverb_update")).click();
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys(incidentNo+Keys.ENTER);
		
		String stateStatus = driver.findElement(By.xpath("//table[@id='incident_table']/tbody[1]/tr[1]/td[8]")).getText();
		String priorityStatus = driver.findElement(By.xpath("//table[@id='incident_table']/tbody[1]/tr[1]/td[7]")).getText();
		if((state.equals(stateStatus)) && priority.equals(priorityStatus)) {
			System.out.println("Incident Updated Successfully");	
		}	
	}
	@DataProvider(name="UpdateData")
	public String[][] updateData() throws IOException {
		return DataStash.updateData("UpdateIncident", "Sheet1");
	}
}
