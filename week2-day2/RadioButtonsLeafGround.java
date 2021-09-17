package week2.day2.assignments;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonsLeafGround {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://leafground.com/pages/radio.html");
		//Selecting a Radio Button
		driver.findElement(By.id("yes")).click();
		
		//Checking the Status of Radio Buttons
		WebElement Unchecked = driver.findElement(By.xpath("(//input[@name='news'])"));
		WebElement Checked = driver.findElement(By.xpath("(//input[@name='news'])[2]"));
		boolean Status1 = Unchecked.isSelected();
		boolean Status2 = Checked.isSelected();
		System.out.println("The Selection of Button 1 is "+Status1);
		System.out.println("The Selection of Button 2 is "+Status2);
		
		// Selecting a Radio Button
		WebElement Below20 = driver.findElement(By.name("age"));
		Below20.click();

	}

}
