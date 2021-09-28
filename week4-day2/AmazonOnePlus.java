package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonOnePlus {
	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro "+Keys.ENTER);
		//Price 
		WebElement priceWE = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		String price = priceWE.getText();
		System.out.println("Price of the product: Rs."+price);
		//Total Ratings
		String totalRatings = driver.findElement(By.xpath("(//a[@class='a-link-normal'])[2]/span")).getText();
		System.out.println("No. of ratings found for the product: "+totalRatings);
		//Popup
		driver.findElement(By.xpath("//a[@class='a-popover-trigger a-declarative']/i")).click();
		//Thread.sleep(3000);
		//Getting the Percentage
		String topPercent= driver.findElement(By.xpath("//table[@id='histogramTable']//tr[1]/td[3]//a")).getText();
		System.out.println("Percentage of 5Star Ratings: " +topPercent);
		
		driver.findElement(By.xpath("(//span[contains(@class,'a-size-medium a-color-base')])[1]")).click();
		Set<String> totalWindows = driver.getWindowHandles();
		for(String eachWindow: totalWindows) {
			driver.switchTo().window(eachWindow);
		}
		//Screenshot
		File imgsrc = driver.getScreenshotAs(OutputType.FILE);
		File imgdstn = new File("./snaps/amazonSS");
		FileHandler.copy(imgsrc, imgdstn);
	
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(2000);
		String subTotal = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
		//Verification
		if (subTotal.contains(price)){
			System.out.println("Price Matched!");
		}
		driver.quit();
	}
}

