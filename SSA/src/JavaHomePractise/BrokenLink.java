package JavaHomePractise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
 
	  import java.net.HttpURLConnection;
	  import java.net.URL;
	  import java.util.List;
	  import java.util.concurrent.TimeUnit;

	  import org.openqa.selenium.By;
	  import org.openqa.selenium.WebDriver;
	  import org.openqa.selenium.WebElement;
	  import org.openqa.selenium.chrome.ChromeDriver;

	  public class BrokenLink {
	    
	  WebDriver driver;  
	    
	    @BeforeMethod
	    public void setup() 
	    {
	  	  System.setProperty("webdriver.chrome.driver", "F:\\Workspace for projects\\Interact\\lib\\chromedriver.exe");
	  	  driver=new ChromeDriver();
	  	  //driver.manage().window().maximize();
	  	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
	    }
	    
	    @Test
	    public void brokenLinks() 
	    {
	  	 driver.get("https://www.google.com");
	  	 List<WebElement> links=driver.findElements(By.tagName("a"));
	  	 System.out.println("Total Links :" + links.size());
	  	 
	  	 for(int i=0;i<links.size();i++)
	  	 {
	  		 /*WebElement ele=links.get(i);
	  		 String url=ele.getAttribute("href");*/	
	  		 
	  		 String url=links.get(i).getAttribute("href");
	  		 
	  		 verifyLinkActive(url);
	  	 }
	    }
	    
	    public static void verifyLinkActive(String linkUrl)
	  	 {
	  		  try 
	  	      {
	  	         URL url = new URL(linkUrl);
	  	         
	  	         HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
	  	         
	  	         httpURLConnect.setConnectTimeout(3000);
	  	         
	  	         httpURLConnect.connect();
	  	         
	  	         if(httpURLConnect.getResponseCode()==200)
	  	         {
	  	             System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
	  	          }
	  	        if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND) ; 
	  	         {
	  	             System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
	  	          }
	  	      } 
	  		  catch (Exception e) {
	  	         
	  	      }
	  	 }
	    
	    
	    

	    @AfterMethod
	    public void teardown() 
	    {
	  	  driver.quit();
	    }

	  }



