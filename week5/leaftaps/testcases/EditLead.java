package week5.leaftaps;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditLead extends BaseClass {
	@Test(dataProvider = "EditData")
	public void runEditLead(String name, String company) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.findElement(By.xpath("(//ul[@class='shortcuts']//a)[3]")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(name);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a[1]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='subMenuButton'])[3]"))).click();
		WebElement companyName = driver.findElement(By.id("updateLeadForm_companyName"));
		companyName.clear();
		companyName.sendKeys(company);
		driver.findElement(By.className("smallSubmit")).click(); 
		String companyFinal = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		companyFinal.replaceAll("/w", "");;
		if(companyFinal.contains(company)){
			System.out.println("Lead Updated Successfully!");
		}
		
	}
	@DataProvider(name="EditData")
	public String[][] editLeadData() throws IOException{
		return DataStash.runEditLead("EditLead","Sheet1");
	}

}
