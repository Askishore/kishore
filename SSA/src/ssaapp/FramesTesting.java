package ssaapp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTesting {

WebDriver driver;

	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Workspace for projects\\Interact\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		//driver.manage().window().maximize();
		
	}
	
	@Test (priority = 1)
	public void clickingFrame()
	{	driver.get("http://www.angelfire.com/super/badwebs/");
		List<WebElement> myframes=driver.findElements(By.tagName("frame"));
		System.out.println(myframes.size());
		String wh=driver.getWindowHandle();
		for(int i=0;i<myframes.size();i++)
		{
		    driver.switchTo().frame(i);
		    try
		    {
		    	driver.findElement(By.xpath("html/body/p[5]/b/a/font")).click();
		    	
		    	break;
		    }
		    catch(Exception e)
		    {
		    	driver.switchTo().window(wh);
		    }
		}
	}

	@Test (priority = 2)
	  public void singleFrame() 
	  {	driver.get("http://jqueryui.com/autocomplete/");
		List<WebElement> frames=driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		for(WebElement e:frames)
		{
			System.out.println(e.getTagName());
		}
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		driver.findElement(By.id("tags")).sendKeys("Selenium");
		
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Button")).click();
		
	  }
	
	@Test (priority = 3)
	public void testMultiFrame() throws InterruptedException
	{
		
		driver.get("http://seleniumhq.github.io/selenium/docs/api/java/index.html");
		List<WebElement> f=driver.findElements(By.tagName("frame"));
		System.out.println("No of Frames : "+f.size());
		
		//Switch driver focus to 1st frame
		driver.switchTo().frame(0);
		driver.findElement(By.linkText("com.thoughtworks.selenium")).click();
		
		//Switch driver focus outside frame
		driver.switchTo().defaultContent();
		
		//Switch driver focus to 2nd frame
		driver.switchTo().frame(1);
		driver.findElement(By.linkText("Selenium")).click();
		
		//Switch driver focus outside frame
		driver.switchTo().defaultContent();
		
		//Switch driver focus to 3rd frame
		driver.switchTo().frame(2);
		driver.findElement(By.linkText("DefaultSelenium")).click();
	}
	  
	@AfterMethod
	  public void teardown()
	  {
		  driver.quit();
	  }
	
}

