package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePackage.CommonMethods;
import pages.LoginPage;

public class EditLeadcase extends CommonMethods{
	@BeforeClass
	public void setFileName() {
		excelName="Lead";
		sheetName="Sheet3";
	}
	@Test(dataProvider="Data")
	public void runEditLead(String firstName, String updatedCName) throws InterruptedException {
		
		new LoginPage(driver).enterUsername(prop.getProperty("username")).enterPassword(prop.getProperty("password")).
		clickLogin().clickCRMLink().clickLeads().clickFindLead().
		enterName(firstName).clickfirstLead().clickEdit().
		updateCompanyName(updatedCName).clickUpdate().
		verifyCompanyName(updatedCName).clickOpenTaps().clickLogOut();
	}

}
