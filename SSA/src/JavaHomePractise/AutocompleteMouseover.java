package JavaHomePractise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

public class AutocompleteMouseover {
  WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  	System.setProperty("webdriver.chrome.driver", "F:\\Workspace for projects\\Interact\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }
  
  @Test (priority = 0)
  public void autocomplete() throws InterruptedException {
	  
		driver.get("http://jqueryui.com/autocomplete/");
		driver.switchTo().frame(0);
		
		driver.findElement(By.id("tags")).sendKeys("b");
		List<WebElement> s=driver.findElements(By.className("ui-menu-item"));
		System.out.println(s.size());
		
		for(WebElement e:s)
		{
			System.out.println(e.getText());
		}
		
			for(int i=0;i<3;i++)
			{
				driver.findElement(By.id("tags")).sendKeys(Keys.ARROW_DOWN);
				Thread.sleep(1000);
				
			}
			driver.findElement(By.id("tags")).sendKeys(Keys.ENTER);
			
  }
  
  @Test (priority =1)
	public void Mouseover() throws InterruptedException
	{
		//moveToElement(WebElement target)
		driver.get("https://aptransport.in/tgcfstonline");
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.linkText("ALTERNATE ADDRESS ENTRY"))).perform();
		driver.findElement(By.linkText("License Alternate Address Entry")).click();
		Thread.sleep(3000);
	}
		
	@Test (priority =2)
	public void DragAnddrop() throws InterruptedException
	{
		//dragAndDrop(WebElement source, WebElement target)
				driver.get("http://jqueryui.com/droppable/");
				driver.switchTo().frame(0);
				
				Actions a=new Actions(driver);
				
				a.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).perform();
				Thread.sleep(4000);
	}
		
	@Test (priority =3)
	public void slider() throws InterruptedException
	{
		//a.dragAndDropBy(WebElement source, int xOffset, int yOffset)
		
				driver.get("http://jqueryui.com/slider/");
				driver.switchTo().frame(0);
				
				Actions a=new Actions(driver);
				
				a.dragAndDropBy(driver.findElement(By.xpath("//div[@id='slider']/span")), 100, 0).perform();
				Thread.sleep(4000);	
	}
		
	@Test (priority =4 )
	public void Browserslider() throws InterruptedException
	{
		
		//Windows Scroll Method
		driver.get("http://www.seleniumhq.org/download/");	
		
		for(int i=0;i<10;i++)
		{
			((RemoteWebDriver)driver).executeScript("window.scrollBy(0,400)");
			Thread.sleep(2000);
		}
	}
	
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
