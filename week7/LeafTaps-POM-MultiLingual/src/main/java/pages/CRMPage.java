package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import basePackage.CommonMethods;

public class CRMPage extends CommonMethods {
	public CRMPage(ChromeDriver driver) {
		this.driver = driver;
	}

	public HomePage clickCRMLink(){
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new HomePage(driver);
	}
	public LoginPage clickLogOut() throws InterruptedException {
		driver.findElement(By.className("decorativeSubmit")).click();
		Thread.sleep(2000);
		return new LoginPage(driver);
	}
}
