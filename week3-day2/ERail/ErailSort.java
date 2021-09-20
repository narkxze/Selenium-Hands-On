package week3.day2.assignments;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSort {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("https://erail.in/");
		
		WebElement fromStation = driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
		fromStation.clear();
		fromStation.sendKeys("Chennai Egmore"+Keys.ENTER);
		
		WebElement toStation = driver.findElement(By.xpath("//input[@id='txtStationTo']"));
		toStation.clear(); 
		toStation.sendKeys("Madurai Jn."+Keys.ENTER);
		
		driver.findElement(By.id("buttonFromTo")).click();
		
		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
		Thread.sleep(4000);
		
		List<WebElement> totalTrains =  driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//td[2]"));
		List<String>Trains = new ArrayList<String>();
		for(WebElement a: totalTrains) {
			Trains.add(a.getText());
		}
		//Java Collections Used
		Collections.sort(Trains); 
		for(String s: Trains) {
			System.out.println(s);
		}
		}

	}


