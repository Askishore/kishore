package JavaHomePractise;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;



public class LoginByJXL 
{

WebDriver d;
	
	@BeforeMethod
	public void setUp()
	{
		//Launch browser		
		System.setProperty("webdriver.chrome.driver", "F:\\Workspace for projects\\Interact\\lib\\chromedriver.exe");
		d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
	
	
	
	@Test
	public void testLogin() throws Exception
	{
		//Load web page
		d.get("http://183.82.118.175:8080/Cyclos/do/login");
		Assert.assertEquals("City Bank of Japan",d.getTitle());
		
		FileInputStream fis=new FileInputStream("F:\\Login.xls");
		Workbook wb=Workbook.getWorkbook(fis);
		Sheet s=wb.getSheet(0);
		for(int i=1;i<s.getRows();i++)
		{
			//Enter user name
			d.findElement(By.id("cyclosUsername")).clear();
			d.findElement(By.id("cyclosUsername")).sendKeys(s.getCell(0,i).getContents());
			String uname=d.findElement(By.id("cyclosUsername")).getAttribute("value");
			
			//Enter password
			d.findElement(By.id("cyclosPassword")).clear();
			d.findElement(By.id("cyclosPassword")).sendKeys(s.getCell(1,i).getContents());
			String password=d.findElement(By.id("cyclosPassword")).getAttribute("value");
			
			//Click on Login
			d.findElement(By.xpath("//input[@value='Submit']")).click();
			Thread.sleep(1000);
			
			//Blank user & Blank password
			if(uname.equals("") && password.equals(""))
			{
				Alert al=d.switchTo().alert();
				assertEquals("Login name is required\nPassword is required\n",al.getText());
				al.accept();
			}
			//Blank user name & Valid/invalid password
			else if(uname.equals("") && !(password.equals("")))
			{
				Alert al=d.switchTo().alert();
				assertEquals("Login name is required\n",al.getText());
				al.accept();
			}
			//Blank password & Valid/Invalid user name
			else if(password.equals("") && !(uname.equals("")))
			{
				Alert al=d.switchTo().alert();
				assertEquals("Password is required\n",al.getText());
				al.accept();
			}
			//Valid user name & valid password
			else if(isElementPresent(d,By.xpath("//span[text()='Logout']")))
			{
				d.findElement(By.xpath("//span[text()='Logout']")).click();
				//Switch driver focus to alert
				Alert al=d.switchTo().alert();
				al.accept();
			}
			//Invalid user name & invalid password
			/*else if(isElementPresent(d,By.id("btn")))
			{
				d.findElement(By.id("btn")).click();
			}
			Thread.sleep(1000);*/
		}
		Thread.sleep(3000);
	}
	
	
	 private boolean isElementPresent(WebDriver driver,By by)
	 {
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);   
		 try 
		 {
		      driver.findElement(by);
		      return true;
		 } 
		 catch (NoSuchElementException e) 
		 {
		      return false;
		 }
	 }
	 
	
	@AfterMethod
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
