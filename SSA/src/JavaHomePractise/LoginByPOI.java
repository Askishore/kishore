package JavaHomePractise;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class LoginByPOI 
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
		
		FileInputStream fis=new FileInputStream("F:\\LoginPoi.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet s=wb.getSheetAt(0);
		for(int i=0;i<s.getLastRowNum()+1;i++)
		{
			//Enter user name
			d.findElement(By.id("cyclosUsername")).clear();
			d.findElement(By.id("cyclosUsername")).sendKeys(s.getRow(i).getCell(0).getStringCellValue());
			String uname=d.findElement(By.id("cyclosUsername")).getAttribute("value");
			
			//Enter password
			d.findElement(By.id("cyclosPassword")).clear();
			d.findElement(By.id("cyclosPassword")).sendKeys(s.getRow(i).getCell(0).getStringCellValue());
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
		wb.close();
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
