package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePackage.CommonMethods;
import pages.LoginPage;

public class DuplicateLeadCase extends CommonMethods {
	@BeforeClass
	public void setFileName() {
		excelName="Lead";
		sheetName="Sheet5";
	}
	@Test(dataProvider = "Data")
	public void runDuplicateLead(String name) throws InterruptedException {
		new LoginPage(driver).enterUsername(prop.getProperty("username")).
		enterPassword(prop.getProperty("password")).clickLogin().clickCRMLink().
		clickLeads().clickFindLead().enterName(name).clickfirstLead().clickEdit().
		clickUpdate().verifyFirstName().clickOpenTaps().clickLogOut();
	}
}
