package week2.day2.assignments;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownsLeafGround {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://www.leafground.com/pages/Dropdown.html");

		//1. Selection through Index
		WebElement selecIndex = driver.findElement(By.id("dropdown1"));
		Select select1 = new Select(selecIndex);
		select1.selectByIndex(1);
		
		//2. Selection through Text
		WebElement selecText = driver.findElement(By.name("dropdown2"));
		Select select2 = new Select(selecText);
		select2.selectByVisibleText("Appium");
		
		//3. Selection through Value
		WebElement selectValue = driver.findElement(By.id("dropdown3"));
		Select select3 = new Select(selectValue);
		select3.selectByValue("3");
		
		//4. Get Number of Options.
		List <WebElement> noOfOptions = select3.getOptions(); 
		int size = noOfOptions.size();
		//5. Retrieving the size of the dropdown
		System.out.println("Total options are" +size);
		
		//5. Selection through SendKeys.
		WebElement select5 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[5]/select"));
		select5.sendKeys("A");
		
		//6. Selection through Multiple Selectable Dropdowns.
		WebElement select6 = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[6]/select"));
		Select multiselect = new Select(select6);
		multiselect.selectByIndex(1);
		multiselect.selectByIndex(3);
		multiselect.selectByIndex(4);
		
		
		
		
	}

}
