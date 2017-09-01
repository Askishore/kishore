package ssaapp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class BootStrapDropDown 
{
	
WebDriver driver;
  
	  @BeforeMethod
	  public void beforeMethod() 
	  {
		  System.setProperty("webdriver.chrome.driver", "F:\\Workspace for projects\\Interact\\lib\\chromedriver.exe");
			driver=new ChromeDriver();
			//driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
	  }
	  	  
	  @Test (priority = 0)
	  public void bootStrapDropDown()
	  {	 driver.get("http://www.bbc.com/");
		 driver.findElement(By.xpath(".//*[@id='orb-nav-more']/a")).click();
		 WebElement item=driver.findElement(By.xpath(".//*[@id='orb-panel-more']/div"));
		 List<WebElement> items=item.findElements(By.tagName("a"));
		 System.out.println(items.size());
		 
		 for(int i=0;i<items.size();i++)
		 {
			 String actual_value=items.get(i).getAttribute("innerHTML");
			 System.out.println(actual_value);
			 if(actual_value.contentEquals("Food"))
			 {
				 items.get(i).click();
				 break;
			 }
		 }
			 
	  }
	  
	  @Test (priority = 1)
		public void multiDropDown() throws InterruptedException
		{
		  	driver.get("https://eenadupellipandiri.net/register");	
			WebElement speak_languages=driver.findElement(By.id("can_speak_lang"));
			Select select_multi=new Select(speak_languages);
			
			//Loop to select first 3 items in MultiDropdown List
			for(int i=0;i<3;i++)
			{
				select_multi.selectByIndex(i);
				
			}
						
			//Loop to display for selected in MultiDropdown list
			List<WebElement> display=select_multi.getAllSelectedOptions();
			/*for (int j = 0; j<3; j++) {
				System.out.println(display.get(j).getText());
			}*/
			for(WebElement s:display)
			{
				System.out.println(s.getText());			
			}
		}
		
	  @AfterMethod
	  public void afterMethod()
	  {
		  driver.quit();
	  }

}
