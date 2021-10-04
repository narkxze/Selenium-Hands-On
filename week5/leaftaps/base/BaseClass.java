package week5.leaftaps;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ChromeDriver driver;
	ChromeOptions options;
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void baseMethod(String url, String username, String password) {
		options = new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//div[@id='label']//a[1]")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
}
