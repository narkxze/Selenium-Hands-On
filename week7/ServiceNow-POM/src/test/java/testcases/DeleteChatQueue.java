package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;
import base.BaseClass;
import pages.LoginPage;

public class DeleteChatQueue extends BaseClass {

	@Test
	public void runDeleteChat() throws IOException, InterruptedException {
		System.out.println("The Thread ID for Create Chat Queue is: "+Thread.currentThread().getId());
		FileInputStream fis = new FileInputStream("./src/test/resources/utils/config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		new LoginPage(driver).passloginCredentials(prop.getProperty("username"), prop.getProperty("pass")).
		enterFilterText(prop.getProperty("filter")).selectWork().selectQueueEntry().deleteChat().verifyDelete();
	}
}
