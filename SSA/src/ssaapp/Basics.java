/**
 * 
 */
package ssaapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Basics {

	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Workspace for projects\\Interact\\lib\\chromedriver.exe");
		driver =new ChromeDriver();
		
	}
	
		@Test
		public void pageVerification()
		{
			driver.get("https:\\www.gmail.com");
			String actual = driver.getTitle();
			String expected = "Gmail";
			Assert.assertEquals(actual, expected);
		
			String actual2 = driver.getTitle();
			String expected2 = "mail";
			Assert.assertTrue(actual2.contains(expected2));
		
		}
		
		@Test
		public void pageVerification2()
		
		{	driver.get("https:\\www.gmail.com");
			String actual_pagesou = driver.getPageSource();
			String expected3 = "Gmail";
			Assert.assertTrue(actual_pagesou.contains(expected3));
			
		}
		 
		@Test
		public void errormessageVerification() throws InterruptedException
		{
			driver.get("https:\\www.gmail.com");
			driver.findElement(By.id("next")).click();
			Thread.sleep(2000);
			String errormessage = driver.findElement(By.id("errormsg_0_Email")).getText();
			String expected4 = "Please enter your email.";
			Assert.assertEquals(errormessage, expected4);
			Assert.assertTrue(errormessage.contains("Please enter your "));
		}
		
		@Test
		public void bygetattribute () throws InterruptedException
		{
			driver.get("https:\\www.gmail.com");
			driver.findElement(By.id("next")).click();
			Thread.sleep(2000);
			String errormessage2 = driver.findElement(By.xpath(".//*[@id='errormsg_0_Email']")).getAttribute("innerHTML");
			Assert.assertEquals(errormessage2, "Please enter your email. ");
			Assert.assertTrue(errormessage2.contains("Please enter your "));
		}
		
		@Test
		public void gettingtotallinks ()
		{	driver.get("https:\\www.google.com.com");
			String expval=driver.findElement(By.linkText("Images")).getAttribute("href");
			System.out.println(expval);
			driver.findElement(By.linkText("Images")).click();
			String actval=driver.getCurrentUrl();
			if(actval.contains(expval)){
				System.out.println("Images links are same \n"+ actval+"\n"+ expval);
			}else{
				System.out.println("Images links are different \n"+actval+"\n"+ expval);
			}
		}
		
		@AfterMethod
		public void closebrowser()
		{
			driver.close();
		}
		
}
