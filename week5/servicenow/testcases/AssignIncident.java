package servicenow;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AssignIncident extends BaseClass {
	@Test(dataProvider="AssignData")
	public void runAssignIncident(String groups, String workNotes) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[text()='Incidents'])[2]"))).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//button[@name='vcr_last'])[1]")).click();
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//table[@id='incident_table']/tbody[1]/tr[20]/td[3]/a[1]")).click();
		//wait.until(ExpectedConditions.visibilityOf(lastPage)).click();
		//wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(lastPage))).click();
		String incidentNo = driver.findElement(By.id("incident.number")).getAttribute("value");
		driver.findElement(By.id("lookup.incident.assignment_group")).click();
		Set<String> groupWindowsSet = driver.getWindowHandles();
		List<String> groupWindows = new ArrayList<String>(groupWindowsSet);
		driver.switchTo().window(groupWindows.get(1));
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys(groups+Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
		driver.switchTo().window(groupWindows.get(0));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys(workNotes);
		driver.findElement(By.id("sysverb_update")).click();
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys(incidentNo+Keys.ENTER);
		String groupStatus = driver.findElement(By.xpath("//table[@id='incident_table']/tbody[1]/tr[1]/td[10]/a[1]")).getText();
		if(groups.equals(groupStatus)) {
			System.out.println("Incident assignment is Successful!");
		}
		
	}
	@DataProvider(name="AssignData")
	public String[][] assignData() throws IOException {
		return DataStash.assignData("AssignIncident", "Sheet1");
	}
}
