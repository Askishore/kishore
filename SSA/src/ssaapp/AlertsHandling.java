package ssaapp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class AlertsHandling {
	
	WebDriver driver;
	public static void m1 (String[] arg) {
		System.out.println("Hi I am m1 from SSA");
		
	}
  @BeforeMethod
  public void beforeMethod() 
  {
	  	System.setProperty("webdriver.chrome.driver","c:\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://infinity.icicibank.com/corp/AuthenticationController?FORMSGROUP_ID__=AuthenticationFG&__START_TRAN_FLAG__=Y&FG_BUTTONS__=LOAD&ACTION.LOAD=Y&AuthenticationFG.LOGIN_FLAG=1&BANK_ID=ICI&_ga=1.189013163.1271626329.1488956347");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  
  @Test
  public void alertsHandling()
  {
	 driver.findElement(By.name("AuthenticationFG.USER_PRINCIPAL")).sendKeys("selenium"); 
	 driver.findElement(By.id("VALIDATE_CREDENTIALS1")).click();
	 
	 Alert al=driver.switchTo().alert();
	 System.out.println(al.getText());
	 al.accept();
	 al.dismiss();
  }
  
  @AfterMethod
  public void afterMethod() 
  {
	driver.quit();  
  }

}
