package com.gmail.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	WebDriver driver;
	
	By username=By.xpath("//input[@id='Email']");
	By next=By.xpath("//input[@id='next']");
	By Password=By.xpath("//input[@id='Passwd']");
	By signin=By.xpath("//input[@id='signIn']");
	By signout1=By.xpath("//a[@class='gb_b gb_eb gb_R']");
	By signout2=By.linkText("Sign out");
	
	
	public LoginPage(WebDriver driver1)
	{
		this.driver=driver1;
	}
	
	
	public void gmailLogin(String user,String pwd) throws InterruptedException
	{
		driver.findElement(username).sendKeys(user);
		driver.findElement(next).click();
		driver.findElement(Password).sendKeys(pwd);
		driver.findElement(signin).click();
		Thread.sleep(7000);
		driver.findElement(signout1).click();
		driver.findElement(signout2).click();
	}
	
	
	/*public void gmailuname()
	{
		driver.findElement(username).sendKeys("***********");
	}
	
	public void gmailnext()
	{
		driver.findElement(next).click();
	}
	
	
	public void  gmailpassword()
	{
		driver.findElement(Password).sendKeys("***********");
	}
	
	public void gmailsignin()
	{
		driver.findElement(signin).click();
	}
	
	 
	public void gmaillogout() throws InterruptedException
	{
		driver.findElement(signout1).click();
		Thread.sleep(8000);
		driver.findElement(signout2).click();
		
	}*/
}
