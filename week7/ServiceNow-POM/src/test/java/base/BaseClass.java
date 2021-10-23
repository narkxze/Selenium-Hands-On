package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcel;

public class BaseClass {
	public static String workBook;
	public static String sheetName;
	public WebDriver driver;	
	@DataProvider(name="fetchData", indices =0 )
public String[][] readData() throws IOException{
	return ReadExcel.runReadExcel (workBook, sheetName);
	}
	
	@BeforeMethod
	public void preCondition() throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/utils/config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(45));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop.getProperty("url"));
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
