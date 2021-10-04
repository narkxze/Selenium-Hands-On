package week5.leaftaps;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass{
	
	@Test(dataProvider="CreateData")
	public void runCreateLead(String cName, String fName, String lName, 
			 String salutation, String Title, String dept, String sicCode, String email) {
		
		driver.findElement(By.xpath("(//ul[@class='shortcuts']//a)[2]")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName); 
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys(salutation);
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys(Title);
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys(dept);
		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys(sicCode);
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(email);
		driver.findElement(By.name("submitButton")).click();
		System.out.println("Lead Created Successfully!");
		System.out.println("********************");
		System.out.println("Name: "+fName);
		System.out.println("E-Mail: "+email);
		System.out.println("Company: "+cName);
	}

@DataProvider(name="CreateData")
public String[][] createLeadData() throws IOException{
	return DataStash.runCreateLead("createLead","Sheet1");
}
}