package JavaHomePractise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AjaxControls {
	WebDriver driver;
	int i;
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Workspace for projects\\Interact\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
	}
		
	@Test (priority = 0)
	public void testAjax1()
	{	driver.get("http://www.veethi.com/places/india_banks-ifsc-micr-codes.html");
		
		Select bank=new Select(driver.findElement(By.id("selBank")));
		bank.selectByIndex(4);
				
		Select state=new Select(driver.findElement(By.id("selState")));
		state.selectByVisibleText("Andhra Pradesh");
		
		Select city=new Select(driver.findElement(By.id("selCity")));
		city.selectByVisibleText("Hyderabad");
		
		Select branch=new Select(driver.findElement(By.id("selBranch")));
		branch.selectByVisibleText("Gachibowli");
		
	}
	
	@Test (priority = 1)
	public void testAjax2()
	{
		driver.get("http://www.veethi.com/places/india_banks-ifsc-micr-codes.html");
		
		selectOption(driver.findElement(By.id("selBank")),"Andhra Bank");
		selectOption(driver.findElement(By.id("selState")),"Andhra Pradesh");
		selectOption(driver.findElement(By.id("selCity")),"Hyderabad");
		selectOption(driver.findElement(By.id("selBranch")),"Gachibowli");
		
	}
	public void selectOption(WebElement e,String optionname)
	{
		Select dd=new Select(e);
		dd.selectByVisibleText(optionname);
	}
	
	@Test (priority = 2)
	public void testAjax3()
	{
		driver.get("http://www.veethi.com/places/india_banks-ifsc-micr-codes.html");
		
		selectOptionIndex(driver.findElement(By.id("selBank")),3);
		selectOptionText(driver.findElement(By.id("selState")),"Andhra Pradesh");
		selectOptionText(driver.findElement(By.id("selCity")),"Hyderabad");
		selectOptionValue(driver.findElement(By.id("selBranch")),"3295");
	}
	//Method Selecting Using By Index
	public void selectOptionIndex(WebElement e,int optionname)
	{
		Select dd=new Select(e);
		dd.selectByIndex(optionname);
	}
	//Method Selecting Using By VisibleText
	public void selectOptionText(WebElement e,String optionname)
	{
		Select dd=new Select(e);
		dd.selectByVisibleText(optionname);
	}
	//Method Selecting Using By Value
	public void selectOptionValue(WebElement e,String optionname)
	{
		Select dd=new Select(e);
		dd.selectByValue(optionname);
	}
		
	@Test (priority = 3)
	public void testSyncExplicit() throws InterruptedException
	{
		//Launch Google Home Page
		driver.get("https://www.google.com");
		
		//identify the Google Search Text Editor
		driver.findElement(By.id("lst-ib")).sendKeys("selenium");
		
		//Click on Search Button
		driver.findElement(By.name("btnG")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Selenium - Web Browser Automation")));
		
		
		driver.findElement(By.linkText("Selenium - Web Browser Automation")).click();	
		
		driver.findElement(By.linkText("Projects")).click();
		System.out.println("done");
	}
	
	@Test (priority = 4)
	public void syncronization() throws InterruptedException
	{	driver.get("http://www.google.com");
		driver.findElement(By.id("lst-ib")).sendKeys("Selenium");
		
		driver.findElement(By.name("btnG")).click();
		//Thread.sleep(1000);
		
		driver.findElement(By.linkText("Selenium - Web Browser Automation")).click();
		
		driver.findElement(By.xpath(".//*[@id='menu_download']/a")).click();
		
		driver.findElement(By.linkText("Source Code")).click();
		
		driver.findElement(By.xpath(".//*[@id='topics-list-container']/div/a[1]")).click();	
	}
	
	@AfterMethod
	public void browserclose()
	{
		driver.quit();
	}
	
}
