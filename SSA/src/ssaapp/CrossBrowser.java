package ssaapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {
	
	WebDriver driver;

	@Test
	
	@Parameters("browser")
	public void verifypageTitle(String browserName){
		
		if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "F:\\Workspace for projects\\Interact\\lib\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}else if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "F:\\Workspace for projects\\Interact\\lib\\chromedriver.exe");
			driver=new ChromeDriver();
		
		}else if(browserName.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", "F:\\Workspace for projects\\Interact\\lib\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
