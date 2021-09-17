package week2.day2.assignments;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxesLeafGround {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://leafground.com/pages/checkbox.html");
		
		//1. Selection of JAVA
		driver.findElement(By.xpath("//div[@class='example']//input")).click();
	
		//2. Status Check.
		WebElement SeleniumButton = driver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']/following::input"));
		boolean isSelected = SeleniumButton.isSelected();
		System.out.println("The state of Checkbox is"+isSelected);
		
		//3. Status Check and De-select.
		WebElement Button3_1 = driver.findElement(By.xpath("//label[text()='DeSelect only checked']/following::input"));
		boolean firstbutton = Button3_1.isSelected();
		WebElement Button3_2 = driver.findElement(By.xpath("(//label[text()='DeSelect only checked']/following::input)[2]"));
		if(firstbutton) {
			Button3_1.click();
		}else{
			Button3_2.click();
		}
		
		//4. Check every element
		driver.findElement(By.xpath("//label[text()='Select all below checkboxes ']/following::input")).click();
		driver.findElement(By.xpath("(//label[text()='Select all below checkboxes ']/following::input)[2]")).click();
		driver.findElement(By.xpath("(//label[text()='Select all below checkboxes ']/following::input)[3]")).click();
		driver.findElement(By.xpath("(//label[text()='Select all below checkboxes ']/following::input)[4]")).click();
		driver.findElement(By.xpath("(//label[text()='Select all below checkboxes ']/following::input)[5]")).click();
	}

}
