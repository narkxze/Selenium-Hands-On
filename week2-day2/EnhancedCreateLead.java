package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EnhancedCreateLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();	
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//1. UserName Text Box
		System.out.println(driver.getTitle());
		WebElement usernameBox = driver.findElement(By.id("username"));
		usernameBox.sendKeys("demosalesmanager");
		//2..Password Text Box
		WebElement passwordBox = driver.findElement(By.id("password"));
		passwordBox.sendKeys("crmsfa");
		//3.. Login Button
		WebElement loginButton = driver.findElement(By.className("decorativeSubmit"));
		loginButton.click();
		System.out.println(driver.getTitle());
		//4. Link Interaction
		WebElement crmsfaHyperLink = driver.findElement(By.linkText("CRM/SFA"));
		crmsfaHyperLink.click();
		System.out.println(driver.getTitle());
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		System.out.println(driver.getTitle());
				
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("NARESH");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("KARTHI");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Naresh");
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("Karthi");
		
		WebElement SourceDropDown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select source = new Select(SourceDropDown);
		source.selectByValue("LEAD_EMPLOYEE");
		
		WebElement marCampDropdown = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select marketingCamp = new Select(marCampDropdown);
		marketingCamp.selectByIndex(1);
		
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Mr.");
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("08/08/99");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("B.E");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Automation Testing");
		
		WebElement industryDropdown = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select Industry = new Select(industryDropdown);
		Industry.selectByVisibleText("Manufacturing");
		
		WebElement currencyDropdown = driver.findElement(By.id("createLeadForm_currencyUomId"));
		Select Currency = new Select(currencyDropdown);
		Currency.selectByValue("INR");
		
		WebElement ownershipDropdown = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select Ownership = new Select(ownershipDropdown);
		Ownership.selectByIndex(1);
		
		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("4LPA");
		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("69");
		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("123");
		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("NIL");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("NIL");
		driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("NONE");
		
		WebElement countryCode = driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode"));
		countryCode.clear();
		countryCode.sendKeys("+91");
		
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9566110384");
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("14");
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Karthi");
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("001");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("ennkaeyy@gmail.com");
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("testleaf.com");
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Naresh Karthi");
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("NK");
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("1,Eldams Road");
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("Teynampet");
		
		WebElement stateDropdown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select State = new Select(stateDropdown);
		State.selectByVisibleText("Florida");
		
		WebElement countryDropdown = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select Country = new Select(countryDropdown);
		Country.selectByValue("IND");
		
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Chennai");
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("600010");
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("14");
		
		driver.findElement(By.name("submitButton")).click();
		 String firstName= driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println("First name: "+firstName);
		
		System.out.println(driver.getTitle());

	}

}
