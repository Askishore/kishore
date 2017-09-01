package com.gmail.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.browserfactory.CommonBrowsers;
import com.gmail.page.LoginPageNew;

public class VerifyGmailLoginNew 
{
	@Test
	public void verifyLogin1() throws InterruptedException
	{
		//This will launch browser & URL
		WebDriver driver=CommonBrowsers.startBrowser("Chrome", "https://www.gmail.com");
		
		//Creating Page Object using Page Factory
		LoginPageNew login_page=PageFactory.initElements(driver, LoginPageNew.class);
		
		//calls the Login gmail Method
		login_page.loginGmail("satyakishore2k5@gmail.com","password");
		
	}
	
}

