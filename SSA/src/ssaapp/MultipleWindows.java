package ssaapp;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindows {

WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Workspace for projects\\Interact\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
		
	@Test 
	public void testMultiwindows() throws InterruptedException
	{
		
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		Assert.assertEquals("IRCTC Next Generation eTicketing System",driver.getTitle(),"Title compared sucessfully......");
		String ParentWindow=driver.getWindowHandle();
		System.out.println(ParentWindow);
				
		//Click on Food-on-Track
		driver.findElement(By.linkText("E-Catering")).click();
		Set<String> h=driver.getWindowHandles();
		System.out.println("No of Handles : " + h.size());
		
		String handle[]=new String[h.size()];
		int i=0;
				
		for(String s:h)
		{
			System.out.println(s);
			handle[i]=s;
			i++;
		}
		
		//Switch driver focus to e-Catering
		driver.switchTo().window(handle[1]);
		Assert.assertTrue(driver.findElement(By.id("stnCode")).isDisplayed());
		System.out.println("Child Window Title : " + driver.getTitle());
		driver.findElement(By.linkText("Search By PNR")).click();
		
		Thread.sleep(6000);
		driver.close();

		//Switch driver focus to irctc window
		driver.switchTo().window(handle[0]);
		Assert.assertTrue(driver.findElement(By.id("usernameId")).isDisplayed());
		System.out.println("Parent Window Title : " + driver.getTitle());
		driver.findElement(By.id("usernameId")).sendKeys("selenium");
		Thread.sleep(4000);
				
	}
	@Test (priority = 0, enabled = false)
	public void multiwindows() throws InterruptedException {
		driver.get("http://www.hdfcbank.com/");
		
		driver.switchTo().frame(driver.findElement(By.className("vizury-notification")));
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='ctaButtonDiv']/div[1]")));
		driver.findElement(By.id("closeImage")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("loginsubmit")).click();
		
		Set<String> w = driver.getWindowHandles();
		String Mw[] = new String[w.size()];
		int i = 0;
		
		for (String e:w)
				{
			System.out.println(e);
			Mw[i] = e;
			i++;
		}
		driver.switchTo().window(Mw[1]);
		driver.findElement(By.linkText("Continue to NetBanking")).click();
		
	}
	@AfterMethod
	public void teradown()
	{
		//driver.quit();
	}
	
}
