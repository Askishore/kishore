package com.gmail.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.gmail.page.LoginPage;

public class VerifyGmailLogin 
{

	WebDriver driver;
	@Test
	public void verifygmailogin() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","F:\\Workspace for projects\\Interact\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.gmail.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		LoginPage login=new LoginPage(driver);
		
		login.gmailLogin("satyakishore2k5@gmail.com","password");
		
		/*login.gmailuname();
		login.gmailnext();
		login.gmailpassword();
		login.gmailsignin();
		login.gmaillogout();*/
	
		
	
			
	}
}
