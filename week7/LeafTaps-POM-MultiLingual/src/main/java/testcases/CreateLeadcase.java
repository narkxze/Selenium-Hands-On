package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePackage.CommonMethods;
import pages.LoginPage;

public class CreateLeadcase extends CommonMethods {
	@BeforeClass
	public void setFileName() {
		excelName="Lead";
		sheetName="Sheet2";
	}

	@Test(dataProvider = "Data")
	public void runCreateLead(String cName, String fName, String lName) throws InterruptedException {
		new LoginPage(driver).enterUsername(prop.getProperty("username")).
		enterPassword(prop.getProperty("password")).
		 clickLogin().clickCRMLink().
		 clickLeads().clickCreateLead().enterCompanyName(cName).
		enterFirstName(fName).enterLastName(lName).clickCreateLead().
		verifyFirstName().clickOpenTaps().clickLogOut();
	}
}
