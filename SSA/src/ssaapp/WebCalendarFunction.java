package ssaapp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebCalendarFunction {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver", "F:\\Workspace for projects\\Interact\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//CheckIn
		driver.get("https://www.tripadvisor.in/");
		driver.findElement(By.xpath("//span[@id='date_picker_in_1']")).click();
		String date="8-Aug 2017";
		String splitter[]=date.split("-");
		String checkInday=splitter[0];
		String checkInMonth =splitter[1];
		
		selectDate(checkInMonth,checkInday);
		
		//CheckOut
		driver.findElement(By.xpath("//span[@id='date_picker_out_1']")).click();
		String date1="10-Aug 2017";
		String splitter1[]=date1.split("-");
		String checkOutday=splitter1[0];
		String checkOutMonth =splitter1[1];
		
		selectDate(checkOutMonth,checkOutday);
		
		
	}
	
	

		public static void selectDate(String month_year,String day) throws InterruptedException
		{
			
			List<WebElement> elements= driver.findElements(By.xpath("//div[@class='calendar']/div[@class='month']/table/thead/tr/th[@class='caption']"));
			for(int i=0;i<elements.size();i++)
			{
				System.out.println(elements.get(i).getText());
				if(elements.get(i).getText().equals(month_year))
				{
					List<WebElement> days=driver.findElements(By.xpath("//div[@class='calendar']/div[@class='month']["+(i+1)+"]/table/tbody/tr/td"));
					for(WebElement d: days)
					{
						System.out.println(d.getText());
						if(d.getText().equals(day))
						{
							d.click();
							return;
						}
					}
				}
			}
			driver.findElement(By.xpath("//span[@class='next sprite-date_picker-btnRightIdle']")).click();
			driver.findElement(By.xpath("//span[@class='next sprite-date_picker-btnRightIdle']")).click();
			Thread.sleep(6000);
			selectDate(month_year,day);
		}
}
