package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();	
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		//1. UserName Text Box
		WebElement usernameBox = driver.findElement(By.id("username"));
		usernameBox.sendKeys("demosalesmanager");
		//2..Password Text Box
		WebElement passwordBox = driver.findElement(By.id("password"));
		passwordBox.sendKeys("crmsfa");
		//3.. Login Button
		WebElement loginButton = driver.findElement(By.className("decorativeSubmit"));
		loginButton.click();
		//4. Link Interaction
		WebElement crmsfaHyperLink = driver.findElement(By.linkText("CRM/SFA"));
		crmsfaHyperLink.click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		
				
		driver.findElement(By.id("firstNameField")).sendKeys("Naresh");
		driver.findElement(By.id("lastNameField")).sendKeys("Karthi");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Naresh");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Karthi");
		driver.findElement(By.id("createContactForm_personalTitle")).sendKeys("Mr.");
		driver.findElement(By.id("createContactForm_birthDate")).sendKeys("08/08/99");
		driver.findElement(By.id("createContactForm_generalProfTitle")).sendKeys("B.E");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Automation Testing");
		
		WebElement currencyDropdown = driver.findElement(By.id("createContactForm_preferredCurrencyUomId"));
		Select Currency = new Select(currencyDropdown);
		Currency.selectByValue("INR");
		
		driver.findElement(By.id("createContactForm_description")).sendKeys("NIL");
		driver.findElement(By.id("createContactForm_importantNote")).sendKeys("NONE");
		
		WebElement countryCode = driver.findElement(By.id("createContactForm_primaryPhoneCountryCode"));
		countryCode.clear();
		countryCode.sendKeys("+91");
		
		driver.findElement(By.id("createContactForm_primaryPhoneNumber")).sendKeys("9566110384");
		driver.findElement(By.id("createContactForm_primaryPhoneAreaCode")).sendKeys("14");
		driver.findElement(By.id("createContactForm_primaryPhoneAskForName")).sendKeys("Karthi");
		driver.findElement(By.id("createContactForm_primaryPhoneExtension")).sendKeys("001");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("ennkaeyy@gmail.com");
		driver.findElement(By.id("generalToNameField")).clear();
		driver.findElement(By.id("generalToNameField")).sendKeys("Naresh Karthi");
		driver.findElement(By.id("createContactForm_generalAttnName")).sendKeys("NK");
		driver.findElement(By.id("createContactForm_generalAddress1")).sendKeys("1,Eldams Road");
		driver.findElement(By.id("createContactForm_generalAddress2")).sendKeys("Teynampet");
		
		WebElement countryDropdown = driver.findElement(By.id("createContactForm_generalCountryGeoId"));
		Select Country = new Select(countryDropdown);
		Country.selectByValue("USA");
		
		WebElement stateDropdown = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select State = new Select(stateDropdown);
		State.selectByValue("NY");
		driver.findElement(By.id("createContactForm_generalCity")).sendKeys("NewYork");
		driver.findElement(By.id("createContactForm_generalPostalCode")).sendKeys("600010");
		driver.findElement(By.id("createContactForm_generalPostalCodeExt")).sendKeys("14");
		
		driver.findElement(By.name("submitButton")).click();		
		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateContactForm_importantNote")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("This is an Important Note!");
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		System.out.println(driver.getTitle());
		
		

	}

}
