package basePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcel;

public class CommonMethods {
	
	public  ChromeDriver driver;
	public String excelName;
	public String sheetName;
	public static Properties prop;
	@DataProvider(name="Data", indices = 0)
	public String[][] createLeadData() throws IOException{
		return ReadExcel.excelData(excelName,sheetName);
	}
	
	@Parameters ({"Language"})
	@BeforeMethod
	public void preCondition(String lang) throws IOException {
		FileInputStream fis = new FileInputStream("./src/main/resources/"+lang+".properties");
		 prop = new Properties();
		prop.load(fis);
		WebDriverManager.chromedriver().setup();	 
		driver = new ChromeDriver();
		System.out.println(driver);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
