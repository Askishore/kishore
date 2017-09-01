package ssaapp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class AutoIt2 {
 
WebDriver driver;	

  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.chrome.driver", "F:\\Workspace for projects\\Interact\\lib\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://www.engprod-charter.net/");
  }
  
  @Test
  public void handlewindow() throws IOException  
  {
	  
	  Runtime.getRuntime().exec("C:\\Users\\Mahalakshmi Voona\\Desktop\\Autoit\\AuthenticationWindow.exe");  
  }

  @AfterMethod
  public void afterMethod()
  {
	  driver.quit();
  }

}
