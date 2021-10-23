package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePackage.CommonMethods;
import pages.LoginPage;

public class MergeLeadcase extends CommonMethods {
	@BeforeClass
	public void setFileName() {
		excelName="Lead";
		sheetName="Sheet4";
	}
	@Test(dataProvider="Data" )
	public void runMergeLead(String fromName, String toName) throws InterruptedException {
		  new LoginPage(driver).enterUsername(prop.getProperty("username")).
		  enterPassword(prop.getProperty("password")).
		  clickLogin().clickCRMLink().clickLeads().clickMergeLead().
		  fromLead(fromName).toLead(toName).clickMerge().verifyLeadID();
		 
	
	}
}
