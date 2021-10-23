package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.LoginPage;

class CreateChatQueue extends BaseClass{
	@BeforeClass
	public void setFileName() {
		workBook= "Create Chat Queue";
		sheetName = "Sheet1";
	}
	
	@Test(dataProvider = "fetchData")
	public void runCreateChat(String configName, String ownerTable, String priority) throws IOException {
		System.out.println("The Thread ID for Create Chat Queue is: "+Thread.currentThread().getId());
		FileInputStream fis = new FileInputStream("./src/test/resources/utils/config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		new LoginPage(driver).passloginCredentials(prop.getProperty("username"), prop.getProperty("pass")).
		enterFilterText(prop.getProperty("filter")).selectWork().createQueue().
		create_Chat_Queueue_Entry().configurationItems(configName).
		ownerTable(ownerTable).priorityInput(priority).
		submitbutton().verifyEntryNumber();
	}

}
