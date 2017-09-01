package com.gmail.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageNew 
{
	WebDriver driver;
	
	
	public LoginPageNew(WebDriver driver1)
	{
		this.driver=driver1;
	}
	
	
	@FindBy(xpath="//input[@id='Email']") WebElement username;
	@CacheLookup
	
	@FindBy(how=How.XPATH,using="//input[@id='next']") WebElement next;
	@CacheLookup
	
	@FindBy(xpath="//input[@id='Passwd']") WebElement password;
	@CacheLookup
	
	@FindBy(xpath="//input[@id='signIn']") WebElement signin;
	@CacheLookup
	
	@FindBy(xpath="//a[@class='gb_b gb_eb gb_R']") WebElement signout1;
	@CacheLookup
	
	@FindBy(linkText="Sign out") WebElement signout2;
	
	
	public void loginGmail(String user,String pwd) throws InterruptedException
	{
		username.sendKeys(user);
		next.click();
		Thread.sleep(2000);
		password.sendKeys(pwd);
		signin.click();
		Thread.sleep(5000);
		signout1.click();
		waitElement();
		signout2.click();
	}
	
	public void waitElement()
	{
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(signout2));
	}
	
	
}