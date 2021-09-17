package week2.day2.assignments;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksLeafGround {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://www.leafground.com/pages/Link.html");

		//  Guessing the Destination
		String destination_Link = driver.findElement(By.linkText("Find where am supposed to go without clicking me?"))
				.getAttribute("href");
		System.out.println(destination_Link);

		// Verify Broken
		String linkStatus = driver.findElement(By.linkText("Verify am I broken?")).getAttribute("href");
		boolean result = linkStatus.contains("error");
		if (result) {
			System.out.println("Broken Link");
		} else {
			System.out.println("Legit Link");
		}
		// Collect all links
		List<WebElement> totalLinks = driver.findElements(By.tagName("a"));
		int count = 0;
		for (int i = 0; i < totalLinks.size(); i++) {
			count = count + 1;
		}
		System.out.println("Total no.of link in this page: " + count);
		
		// Partial Link Test
				driver.findElement(By.partialLinkText("Home")).click(); // executes 1st link only
	}

}
