package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.BaseClass;

public class TasksPage extends BaseClass {
	String entryNumber;
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	public TasksPage(WebDriver driver) {
		this.driver = driver;
	}
	public TasksPage(WebDriver driver, String entryNumber) {
		this.driver = driver;
		this.entryNumber = entryNumber;
		
	}
	public TasksPage createQueue() {
		driver.switchTo().frame("gsft_main");
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("sysverb_new"))).click();
		driver.findElement(By.id("sysverb_new")).click();
		return this;
	}
	public CreateChatPage create_Chat_Queueue_Entry() {
		//driver.switchTo().frame("gsft_main");
	//	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Chat_queue_entry"))).click();
		driver.findElement(By.linkText("Chat_queue_entry")).click();
		return new CreateChatPage(driver);
	}
	
	public void verifyEntryNumber() {
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys(entryNumber+Keys.ENTER);
		boolean verify = driver.findElement(By.xpath("//a[text()='"+entryNumber+"']")).isDisplayed();
		Assert.assertTrue(verify);
	}
	
	public void verifyUpdation(String priority, String state) {
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys(entryNumber+Keys.ENTER);
		String state_check = driver.findElement(By.xpath("//table[@id='task_table']/tbody[1]/tr[1]/td[5]")).getText();
		String priority_check = driver.findElement(By.xpath("//table[@id='task_table']/tbody[1]/tr[1]/td[4]")).getText();
		Assert.assertEquals(state_check, state);
		Assert.assertEquals(priority_check, priority);
	}	
	
	public CreateChatPage selectQueueEntry() throws InterruptedException {
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//a[@data-list_id='task'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]")).click();
		return new CreateChatPage(driver);
	}
	public void verifyConfiguration(String configName, String priority, String state) {
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys(entryNumber+Keys.ENTER);
		driver.findElement(By.xpath("//a[@data-type='list2_popup']")).click();
		String config_check = driver.findElement(By.name("chat_queue_entry.cmdb_ci_label")).getAttribute("value");
		String state_check = driver.findElement(By.xpath("//input[@id='sys_readonly.chat_queue_entry.state']")).getAttribute("value");
		String priority_check = driver.findElement(By.xpath("//input[@id='sys_readonly.chat_queue_entry.priority']")).getAttribute("value");
		Assert.assertEquals(config_check, configName);
		Assert.assertEquals(state_check, state);
		Assert.assertEquals(priority_check, priority);	
	}
	
	public void verifyDelete() {
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys(entryNumber+Keys.ENTER);
		String text = driver.findElement(By.xpath("//table[@id='task_table']/tbody[1]/tr[1]/td[1]")).getText();
		Assert.assertEquals(text, "No records to display");
	
	}


}
