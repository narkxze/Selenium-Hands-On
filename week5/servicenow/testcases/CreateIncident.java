package servicenow;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateIncident extends BaseClass {
	
	@Test(dataProvider = "FetchData")
	public void runCreateIncident(String lookUp, String shortdescr, String category, String impact, String urgency, String group) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[text()='Create New'])[1]"))).click();
		driver.switchTo().frame("gsft_main");
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		Set<String> lookUpWindowsSet = driver.getWindowHandles();
		List<String> lookUpWindows= new ArrayList<String>(lookUpWindowsSet);
		driver.switchTo().window(lookUpWindows.get(1));
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(lookUp+Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='"+lookUp+"']")).click();
		driver.switchTo().window(parentWindow);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("lookup.incident.short_description")).click();
		Set<String> shordescrWindowsSet = driver.getWindowHandles();
		List<String> shortdescrWindows = new ArrayList<String>(shordescrWindowsSet);
		driver.switchTo().window(shortdescrWindows.get(1));
		driver.findElement(By.xpath("//a[text()='"+shortdescr+"']")).click();
		driver.switchTo().window(parentWindow);
		driver.switchTo().frame("gsft_main");
		WebElement categoryDropdown = driver.findElement(By.id("incident.category"));
		categoryDropdown.click();
		Select categoryOptions = new Select(categoryDropdown);
		categoryOptions.selectByVisibleText(category);
		WebElement impactDropdown = driver.findElement(By.id("incident.impact"));
		impactDropdown.click();
		Select impactOptions = new Select(impactDropdown);
		impactOptions.selectByVisibleText(impact);
		WebElement urgencyDropdown = driver.findElement(By.id("incident.urgency"));
		urgencyDropdown.click();
		Select urgencyOptions = new Select(urgencyDropdown);
		urgencyOptions.selectByVisibleText(urgency);
		driver.findElement(By.id("lookup.incident.assignment_group")).click();
		Set<String> groupsWindowsSet = driver.getWindowHandles();
		List<String> groupsWindows = new ArrayList<String>(groupsWindowsSet);
		driver.switchTo().window(groupsWindows.get(1));
		driver.findElement(By.linkText(group)).click();
		driver.switchTo().window(parentWindow);
		driver.switchTo().frame("gsft_main");
		String incidentNo = driver.findElement(By.id("incident.number")).getAttribute("value");
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='form-control'])[1]"))).sendKeys(incidentNo+Keys.ENTER);
		String incidentNoCheck = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='linked formlink']"))).getText();
		if(incidentNo.equals(incidentNoCheck)) {
			System.out.println("Incident is Created ");
			System.out.println("************");
			System.out.println("Name: "+lookUp+"\n Incident Number: "+incidentNo+"\n");
		}	
	}
	@DataProvider(name="FetchData")
	public String[][] excelData() throws IOException {
		return DataStash.readData("CreateIncident", "CreateInc.");
		
		
		
	}
}
