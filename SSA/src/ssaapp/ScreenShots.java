package ssaapp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ScreenShots {
	
  WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() {
	  	System.setProperty("webdriver.chrome.driver","F:\\Workspace for projects\\Interact\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @Test (priority = 0, enabled = false)
  public void ssforgmail() throws IOException {
	  	driver.get("https://www.gmail.com");
	  	File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
		//FileUtils is a predefined class in java & copyFile is a predefined method
		FileUtils.copyFile(scrFile, new File ("C:\\Users\\Mahalakshmi Voona\\Desktop\\BBC.png"));
  }
  
  @Test (priority = 1, enabled = false)
  public void ssforlink() throws IOException {
	  
	  	driver.get("https://google.com");
		List<WebElement> links=driver.findElements(By.linkText("Rajanikanth"));
		System.out.println(links.size());
	
		if(links.size()==0)
		{
			File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			//FileUtils is a predefined class in java & copyFile is a predefined method
			FileUtils.copyFile(scrFile, new File("C:\\Users\\Mahalakshmi Voona\\Desktop\\google.png"));
		}
		
  }
  
  @Test (priority = 2, enabled = false)
  public void ssforalllinks() throws IOException {
	  	driver.get("http://newtours.demoaut.com");
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());

		for(int i=0;i<links.size();i++)
		{
			if(!links.get(i).getText().isEmpty())
			{
			   String linkname=links.get(i).getText();
			   links.get(i).click();
			   File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			   FileUtils.copyFile(srcFile,new File("C:\\Users\\Mahalakshmi Voona\\Desktop\\screenshots\\"+linkname+".png"));
			   driver.navigate().back();
			   links=driver.findElements(By.tagName("a"));
		    }
		}
  }
  
  @Test (priority = 3)
  
  public void sswithdate() throws InterruptedException, IOException
	{
		
		driver.get("https://www.gmail.com/");
		
		DateFormat dateFormat=new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date dt=new Date();
		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//FileUtils is a predefined class in java & copyFile is a predefined method
		FileUtils.copyFile(scrFile,new File("C:\\Users\\Mahalakshmi Voona\\Desktop\\"+dateFormat.format(dt)+".png"));
	}
  
  @Test (priority = 4, enabled = false)
	public void sswithlinknameanddate() throws Exception
	{
			driver.get("http://newtours.demoaut.com");	
			List<WebElement> links=driver.findElements(By.tagName("a"));
			System.out.println(links.size());

			for(int i=0;i<links.size();i++)
			{
				if(!links.get(i).getText().isEmpty())
				{
				   String linkname=links.get(i).getText();
				   links.get(i).click();
				   
				   if(driver.getTitle().contains("404"))
				   {
					   DateFormat dateFormat=new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
					   Date dt=new Date();
					   
					   File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					   FileUtils.copyFile(srcFile,new File("C:\\Users\\Mahalakshmi Voona\\Desktop\\Screenshots2\\"+linkname+"_"+dateFormat.format(dt)+".png"));
				   }
				   
				   driver.navigate().back();
				   links=driver.findElements(By.tagName("a"));
			    }
			}
	}
	
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
