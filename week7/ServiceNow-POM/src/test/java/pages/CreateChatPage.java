package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class CreateChatPage extends BaseClass {
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	public CreateChatPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public CreateChatPage configurationItems(String configName) {
		driver.findElement(By.id("lookup.chat_queue_entry.cmdb_ci")).click();
		Set<String> allHandlesSet = driver.getWindowHandles();
		List<String> allHandles = new ArrayList<String>(allHandlesSet);
		driver.switchTo().window(allHandles.get(1));
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys(configName+Keys.ENTER);
		driver.findElement(By.linkText(configName)).click();
		driver.switchTo().window(allHandles.get(0));
		driver.switchTo().frame("gsft_main");
		return this;
	}
	
	public CreateChatPage ownerTable(String ownerTable) {
		 driver.findElement(By.className("select2-arrow")).click();
		driver.findElement(By.className("select2-input")).sendKeys(ownerTable);
		driver.findElement(By.id("select2-results-1")).click();
		return this;
	}
	
	public CreateChatPage priorityInput(String priority) {
		WebElement priority_dropdown = driver.findElement(By.id("chat_queue_entry.priority"));
		priority_dropdown.click();
		Select select = new Select(priority_dropdown);
		select.selectByVisibleText(priority);
		return this;
	}
	
	public TasksPage stateField(String state) {
		WebElement state_dropdown = driver.findElement(By.id("chat_queue_entry.state"));
		Select select = new Select(state_dropdown);
		select.selectByVisibleText(state);
		String entryNumber = driver.findElement(By.id("chat_queue_entry.number")).getAttribute("value");
		driver.findElement(By.id("sysverb_update")).click();
		return new TasksPage(driver,entryNumber);
	}
	
	public TasksPage submitbutton() {
		String entryNumber = driver.findElement(By.id("chat_queue_entry.number")).getAttribute("value");
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		return new TasksPage(driver,entryNumber);
		
	}
	
	public TasksPage deleteChat() {
		String entryNumber = driver.findElement(By.id("chat_queue_entry.number")).getAttribute("value");
		driver.findElement(By.id("sysverb_delete")).click();
		driver.findElement(By.id("ok_button")).click();
		return new TasksPage(driver, entryNumber);
	}

}
