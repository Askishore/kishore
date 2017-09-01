package ssaapp;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownVerifications {
	WebDriver driver;
	int i;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Workspace for projects\\Interact\\lib\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
	}
		
	@Test (priority = 0, enabled = false)
	public void singleDropDown() throws InterruptedException
	{	driver.get("https://www.facebook.com");	
	//Identifying the Month Dropdown in Facebook Page & Storing in Select Builtin Class
		WebElement month_dropdown=driver.findElement(By.id("month"));
		Select month_dd=new Select(month_dropdown);
	
	//It selects using by Index   &    To print Selected option
		month_dd.selectByIndex(3);
		WebElement sel1=month_dd.getFirstSelectedOption();
		System.out.println("Selected option name using By Index is :" + sel1.getText());
		Thread.sleep(3000);
	
	//It selects using by value    &    To print Selected option
		month_dd.selectByValue("4");
		WebElement sel2=month_dd.getFirstSelectedOption();
		System.out.println("Selected option name using  By Value is :" + sel2.getText());
		Thread.sleep(3000);
			
	//It selects using by VisibleText    &    To print Selected option
		month_dd.selectByVisibleText("May");
		WebElement sel3=month_dd.getFirstSelectedOption();
		System.out.println("Selected option name using By Visibletext is :" + sel3.getText());
		Thread.sleep(3000);
	}
	
	@Test (priority = 1, enabled = false)
	public void amezonsearchDropdown()
	{	driver.get("http://amazon.in");
		driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");
		driver.findElement(By.className("nav-input")).click();
		
		String actual_title=driver.getTitle();
		String exp_title="Amazon.in: Harry Potter: Books";
		
		Assert.assertEquals(actual_title, exp_title);
	}
	
	@Test (priority = 2, enabled = false)
	public void amezonsearchDropdown2()
	{	driver.get("http://amazon.in");
		Select sel=new Select(driver.findElement(By.id("searchDropdownBox")));
		sel.selectByVisibleText("Books");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");
		driver.findElement(By.className("nav-input")).click();
		
		String actual_title=driver.getTitle();
		String exp_title="Amazon.in: Harry Potter: Books";
		
		Assert.assertEquals(actual_title, exp_title);
	}
	
	@Test (priority = 3, enabled = false)
	public void amazonsearchdropdownprinting()
	{	driver.get("http://amazon.in");
		WebElement drop=driver.findElement(By.id("searchDropdownBox"));
		List<WebElement> dropdown=drop.findElements(By.tagName("option"));
				
		System.out.println(dropdown.size());
		for(int i=0;i<dropdown.size();i++)
		{
			System.out.println(dropdown.get(i).getText());
	    }
	}
		
		
	@Test (priority = 4, enabled = false)
	public void amazonsearchdropdownprinting2()
	{	driver.get("http://amazon.in");
		WebElement drop=driver.findElement(By.id("searchDropdownBox"));
		Select sel=new Select(drop);
		List<WebElement> items=sel.getOptions();
		
		System.out.println(items.size());
		for(int i=0;i<items.size();i++)
		{
			System.out.println(items.get(i).getText());
		}
	}
	
	@Test (priority = 5)//, enabled = false)
	public void countryitemsSelection1()
	{	
		driver.get("http://newtours.demoaut.com");
		driver.findElement(By.linkText("REGISTER")).click();
		WebElement drop=driver.findElement(By.name("country"));
		List<WebElement> dropdown=drop.findElements(By.tagName("option"));
		System.out.println(dropdown.size());
	    for(int i=0;i<dropdown.size();i++)
	    {
		   dropdown.get(i).click();
		   System.out.println(dropdown.get(i).getText());
		   if(dropdown.get(i).isSelected())
		   {
			   System.out.println(dropdown.get(i).getText()+" --> is Active");
		   }
		   else
		   {
			   System.out.println(dropdown.get(i).getText()+" --> is Inactive");
		   }
	   }  
	}
	
	@Test (priority = 6, enabled = false)
	public void countryitemsSelection2()
	{	driver.get("http://newtours.demoaut.com");
		driver.findElement(By.linkText("REGISTER")).click();
		WebElement drop=driver.findElement(By.name("country"));
		Select sel=new Select(drop);
		List<WebElement> items=sel.getOptions();
		System.out.println(items.size());
		for(int j=0;j<items.size();j++)
		{
			items.get(j).click();
			if(items.get(j).isSelected())
			   {
				   System.out.println(items.get(j).getText()+" --> is Active");
			   }
			   else
			   {
				   System.out.println(items.get(j).getText()+" --> is Inactive");
			   }
		}
		
		
	}
	@Test (priority = 7, enabled = false)
	public void twoDropdownSelection1() throws InterruptedException
	{	driver.get("http://goair.in");
		
		WebElement fdrop=driver.findElement(By.id("departureCitysearchBoxUserControlCriteriaBox"));
		List<WebElement> list1=fdrop.findElements(By.tagName("option"));
		System.out.println(list1.size());
		
		for(int i=1;i<list1.size();i++){
			String fcity=list1.get(i).getText();
			list1.get(i).click();
			Thread.sleep(5000);
			
			WebElement sdrop=driver.findElement(By.id("toCitysearchBoxUserControlCriteriaBox"));
			List<WebElement> list2=sdrop.findElements(By.tagName("option"));
			System.out.println(list2.size());
			
			for(int j=0;j<list2.size();j++)
			{
				String scity=list2.get(j).getText();
				list2.get(j).click();
				
				if(scity.equals(fcity))
				{
					System.out.println(fcity+ "Is not functioning properly");
					break;
				}
				else
				{
					System.out.println(fcity+ " Is working Properly");
				}
			}
		}	
	}
	
	@Test (priority = 8, enabled = false)
	public void twoDropdownSelection2() throws InterruptedException 
	{	driver.get("http://goair.in");

		WebElement fdrop1=driver.findElement(By.id("departureCitysearchBoxUserControlCriteriaBox"));
		Select list3=new Select(fdrop1);
		List<WebElement> items1=list3.getOptions();
		System.out.println("Total elements in First Dropdown is..: " + items1.size());
		
		for(int k=1;k<items1.size();k++){
			String fcity1=items1.get(k).getText();
			items1.get(k).click();
			Thread.sleep(5000);
			
			
			WebElement sdrop1=driver.findElement(By.id("toCitysearchBoxUserControlCriteriaBox"));
			Select list4=new Select(sdrop1);
			List<WebElement> items2=list4.getOptions();
			System.out.println("Total elements in second Dropdown is..: " + items2.size());
			
			for(int l=0;l<items2.size();l++)
			{
				String scity1=items2.get(l).getText();
				items2.get(l).click();
				
				if(scity1.equals(fcity1))
				{
					System.out.println("Selected cities :" + fcity1+ "--->" +  scity1 +   "Is not functioning properly");
					break;
				}
				else 
				{
					System.out.println("Selected cities :" + fcity1+ "--->" +  scity1 +   " Is working Properly");
				}
			}
		}	
	}
	
	@AfterMethod
	public void browserclose()
	{
		driver.close();
	}
}
