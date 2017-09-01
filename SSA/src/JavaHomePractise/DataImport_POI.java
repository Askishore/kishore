package JavaHomePractise;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class DataImport_POI {
	
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
		d.get("https://www.google.co.in/");
		assertEquals("Google",d.getTitle());
		//Read data from excel using JXL
		FileInputStream fis=new FileInputStream("F:\\Google1.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet s=wb.getSheetAt(0);
		System.out.println(s.getLastRowNum());
		for(int i=0;i<s.getLastRowNum()+1;i++)
		{
			d.findElement(By.id("lst-ib")).clear();
			d.findElement(By.id("lst-ib")).sendKeys(s.getRow(i).getCell(0).getStringCellValue());
			//d.findElement(By.id("lst-ib")).clear();
			//d.findElement(By.className("lsb")).click();
			Thread.sleep(1000);
		}
		Thread.sleep(2000);
		wb.close();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		//Close browser
		//d.quit();
	}

}
