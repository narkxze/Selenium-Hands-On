package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Implicit wait
		
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");
		
		driver.findElement(By.name("UserFirstName")).sendKeys("Naresh");
		driver.findElement(By.name("UserLastName")).sendKeys("Karthi");
		driver.findElement(By.name("UserEmail")).sendKeys("snareshkarthi@gmail.com");
		driver.findElement(By.name("CompanyName")).sendKeys("TestLeaf");
		driver.findElement(By.name("UserPhone")).sendKeys("987654321");
		
		WebElement jobTitleDropdown = driver.findElement(By.name("UserTitle"));
		Select jobTitle = new Select(jobTitleDropdown);
		jobTitle.selectByValue("Student / Personal Interest");
		
		WebElement employeesDropdown = driver.findElement(By.name("CompanyEmployees"));
		Select employees = new Select(employeesDropdown);
		employees.selectByIndex(3);
		
		driver.findElement(By.xpath("//div[@class='checkbox-ui']")).click();
		driver.close();
		
		

	}

}
