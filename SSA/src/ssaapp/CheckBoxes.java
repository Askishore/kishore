package ssaapp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxes {
WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","F:\\Workspace for projects\\Interact\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test (priority = 1)
	public void checkboxTest()
	{	driver.get("http://echoecho.com/htmlforms09.htm");
		List<WebElement> check=driver.findElements(By.xpath("//td[@class='table5']/input[@type='checkbox']"));
		for(int i=0;i<check.size();i++)
		{
			System.out.println(check.get(i).getAttribute("value")+"--"+check.get(i).getAttribute("checked"));
		}
	}
	
	@Test (priority = 2)
	public void checkingCheckBox() throws Exception
	{	driver.get("http://echoecho.com/htmlforms09.htm");
		List<WebElement> check=driver.findElements(By.xpath("//td[@class='table5']/input[@type='checkbox']"));
		System.out.println(check.size());
		for(int i=0;i<check.size();i++)
		{
			if(!check.get(i).isSelected())
			{
				System.out.println("Slected option is :" +check.get(i).getAttribute("value"));
				check.get(i).click();
				Thread.sleep(3000);
			}
			
			
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}



