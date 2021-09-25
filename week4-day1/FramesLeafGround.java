package week4.day1.assignments;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesLeafGround{

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/frame.html");
		//1. IFrame
		driver.switchTo().frame(0);
		WebElement firstButton = driver.findElement(By.id("Click"));
		firstButton.click();
		//2. Screenshot of the Element
		File imgsrc =firstButton.getScreenshotAs(OutputType.FILE);
		File imgdstn = new File("./snaps/elmntimage.png");	
		FileHandler.copy(imgsrc, imgdstn);
		//2. Nested Frame
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		driver.findElement(By.id("Click1")).click();
		//3. Identifying total number of frames
		driver.switchTo().defaultContent();
		List<WebElement> totalFrames =driver.findElements(By.tagName("iframe"));
		System.out.println("Total Count of Frames: "+totalFrames.size());
		
		
	}

}
