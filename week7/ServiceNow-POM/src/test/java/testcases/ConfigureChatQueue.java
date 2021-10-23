package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.LoginPage;


public class ConfigureChatQueue extends BaseClass {
	@BeforeClass
	public void setFileName() {
		workBook = "Configure Chat Queue";
		sheetName = "Sheet1";
	}
	@Test(dataProvider = "fetchData")
	public void runConfigureChat(String configName, String priorityInput, String stateInput) throws IOException, InterruptedException {
		System.out.println("The Thread-ID for Update Chat Queue is: "
				+Thread.currentThread().getId());
		FileInputStream fis = new FileInputStream("./src/test/resources/utils/config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		  new LoginPage(driver).passloginCredentials(prop.getProperty("username"), prop.getProperty("pass")). 
		  enterFilterText(prop.getProperty("filter")).selectWork().selectQueueEntry().
		  configurationItems(configName).priorityInput(priorityInput).
		  stateField(stateInput).verifyConfiguration(configName, priorityInput, stateInput);
		 
		
	}

}
