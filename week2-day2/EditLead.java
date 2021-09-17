package week2.day2.assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {
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
		driver.findElement(By.linkText("Find Leads")).click(); 
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Naresh");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.findElement(By.linkText("10651")).click();
		System.out.println(driver.getTitle());
		String unchangedCompanyName = driver.findElement(By.xpath("(//span[@class='tabletext'])[3]")).getText();
		System.out.println(unchangedCompanyName);
		driver.findElement(By.linkText("Edit")).click();
		WebElement companyName = driver.findElement(By.id("updateLeadForm_companyName"));
		companyName.clear();
		companyName.sendKeys("Nordex");
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		String updatedCompanyName = driver.findElement(By.xpath("(//span[@class='tabletext'])[3]")).getText();
		System.out.println(updatedCompanyName);
		if(unchangedCompanyName != updatedCompanyName) {
			System.out.println("Company Name is Changed!");
		}else {
			System.out.println("No Change in Company Name!!");
		}
		driver.close();
	
		
			
		
	}	
}
