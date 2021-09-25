package week4.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChercherFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		//1. IFrame
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[@id='topic']//following::input")).sendKeys("Not a Friendly Topic");
		//2. Nested IFrame
		driver.switchTo().frame("frame3");
		driver.findElement(By.id("a")).click();
		driver.switchTo().defaultContent();
		//3. Drop downs in Frame
		driver.switchTo().frame("frame2");
		WebElement dropdowns = driver.findElement(By.id("animals"));
		Select options = new Select(dropdowns);
		options.selectByIndex(2);
		

	}

}
