package JavaHomePractise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class AutoIt {
 
WebDriver driver;	

  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.chrome.driver", "F:\\Workspace for projects\\Interact\\lib\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("C:\\Users\\Mahalakshmi Voona\\Desktop\\autoit.html");
  }
  
  @Test
  public void fileupload() throws IOException 
  {
	  driver.findElement(By.name("fileupload")).click();
	  Runtime.getRuntime().exec("C:\\Users\\Mahalakshmi Voona\\Desktop\\Autoit\\autoitex.exe");
	  
	  Runtime.getRuntime().exec("C:\\Users\\Mahalakshmi Voona\\Desktop\\Autoit\\downloadfile.exe");
  }

  @AfterMethod
  public void afterMethod()
  {
	  driver.quit();
  }

}
