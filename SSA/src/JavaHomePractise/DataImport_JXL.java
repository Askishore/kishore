package JavaHomePractise;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class DataImport_JXL {

WebDriver driver;

	@BeforeMethod
	public void setUp()
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver", "F:\\Workspace for projects\\Interact\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}


	@Test
	public void testLogin() throws Exception
	{
		//Load web page
		driver.get("https://www.google.co.in/");
		assertEquals("Google",driver.getTitle());
		
		//Read data from excel using JXL
		FileInputStream fis=new FileInputStream("F:\\Google.xls");
		Workbook wb=Workbook.getWorkbook(fis);
		Sheet s=wb.getSheet(0);
		System.out.println(s.getRows());
		for(int i=0;i<s.getRows();i++)
		{
			driver.findElement(By.id("lst-ib")).clear();
			driver.findElement(By.id("lst-ib")).sendKeys(s.getCell(0,i).getContents());
			driver.findElement(By.name("btnG")).click();
			Thread.sleep(2000);
		}
		Thread.sleep(2000);
	}	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
