package week3.day2.assignments;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailUniqueSort {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://erail.in/");
		
		WebElement fromLocation =driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
		fromLocation.clear();
		fromLocation.sendKeys("Chennai E"+Keys.ENTER);
		
		WebElement toLocation = driver.findElement(By.xpath("//input[@id='txtStationTo']"));
		toLocation.clear();
		toLocation.sendKeys("Madurai J"+Keys.ENTER);
		
		driver.findElement(By.xpath("//input[@id='buttonFromTo']")).click();
		
		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
		
		Thread.sleep(2000);
		List <WebElement> totalTrains = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//td[2]"));
		System.out.println("Size of the list: "+totalTrains.size());
		
		Set<WebElement> setTotalTrains = new HashSet<WebElement>(totalTrains);
		Set<String> trainNames = new HashSet<String>(); 
		for(WebElement s: setTotalTrains) {
			trainNames.add(s.getText());
			}
		Thread.sleep(2000);
		System.out.println("Size of the set: "+trainNames.size());
	
		}
	}

