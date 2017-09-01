package JavaHomePractise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RandomNumberSelection {
	WebDriver driver;
	int i;
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Workspace for projects\\Interact\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
	}
		
	@Test
	public void randomSelection()
	{	driver.get("http://newtours.demoaut.com");
		driver.findElement(By.linkText("REGISTER")).click();
		WebElement drop=driver.findElement(By.name("country"));
		List<WebElement> listdrop=drop.findElements(By.tagName("option"));
		System.out.println("Total No.of Countries in a List : " + listdrop.size());
		
		int a=myRandomNo(listdrop.size()-1);
		System.out.println("Random Number is : "+ a);
		listdrop.get(a).click();
		if(listdrop.get(a).isSelected())
		{
			System.out.println(listdrop.get(a).getText()+ "is Selected & Enabled");
		}
	}
	
	
	public static int myRandomNo(int x)
	{
		double b=Math.random()*x;
		int c=(int)b;
		return c;
	}
	
	@AfterMethod
	public void browserclose()
	{
		driver.quit();
	}
	
}
