package JavaHomePractise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class SingleDatePicker {
  WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  	System.setProperty("webdriver.chrome.driver", "F:\\Workspace for projects\\Interact\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }
  
  @Test
  public void DatePicker() {
	  	driver.get("https://www.redbus.in/");
		driver.findElement(By.xpath(".//*[@id='search']/div/div[3]/span")).click();
		String date="8-Apr 2017";
		String splitter[]=date.split("-");
		String checkInday=splitter[0];
		String checkInMonth =splitter[1];
		System.out.println("Month to Select is :" +checkInMonth);
		System.out.println("Date to Slect is : " +checkInday);
		
		WebElement element= driver.findElement(By.xpath("//div[@id='rb-calendar_return_cal']/table/tbody/tr[1]/td[2]"));
		
			System.out.println(element.getText());
			if(element.getText().equals(checkInMonth))
			{
				List<WebElement> days=driver.findElements(By.xpath("//div[@id='rb-calendar_return_cal']/table/tbody/tr/td"));
				for(WebElement d: days)
				{	
					System.out.println(d.getText());
					if(d.getText().equals(checkInday))
					{
						d.click();
						return;
					}
				}
			}
		
		
	}
	  
  
  
  @AfterMethod
  public void afterMethod() {
  }

}
