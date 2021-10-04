package servicenow;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DeleteIncident extends BaseClass {
	@Test
	public void runDeleteIncident() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[text()='Incidents'])[2]"))).click();
	driver.switchTo().frame("gsft_main");
	driver.findElement(By.xpath("(//button[@name='vcr_last'])[1]")).click();
	Thread.sleep(2000);
	 driver.findElement(By.xpath("//table[@id='incident_table']/tbody[1]/tr[20]/td[3]/a[1]")).click();
	String incidentNo = driver.findElement(By.id("incident.number")).getAttribute("value");
	driver.findElement(By.id("sysverb_delete")).click();
	driver.findElement(By.id("ok_button")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys(incidentNo+Keys.ENTER);
	String emptyMessage = driver.findElement(By.xpath("//table[@id='incident_table']/tbody[1]/tr[1]/td[1]")).getText();
	if(emptyMessage.equals("No records to display")) {
		System.out.println("Incident deleted successfully!");
	}
	
	}
}
