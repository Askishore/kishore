package ssaapp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class RadioButtons {
  WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  	System.setProperty("webdriver.chrome.driver","F:\\Workspace for projects\\Interact\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
  }
  
  
  @Test (priority = 1)
  public void radiobutton() throws InterruptedException {
	  driver.get("http://echoecho.com/htmlforms10.htm");
		
		
		WebElement radio = driver.findElement(By.xpath("html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td"));
		List<WebElement> rbutton=radio.findElements(By.name("group1"));
		for(int i=0;i<rbutton.size();i++){
			System.out.println(rbutton.get(i).getAttribute("value")+"----"+ rbutton.get(i).getAttribute("checked"));
			Thread.sleep(4000);
		}
  }
  
  @Test (priority = 2)
  public void clinkingRadioButton() {
	  driver.get("http://echoecho.com/htmlforms10.htm");
		
		WebElement block=driver.findElement(By.xpath("html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td"));
		for(int k=1;k<2;k++){
			List<WebElement> radio=block.findElements(By.name("group"+k));
			for(int i=0;i<radio.size();i++)
			{
				radio.get(i).click();
				for(int j=0;j<radio.size();j++)
				{
					System.out.println(radio.get(j).getAttribute("value")+"--"+radio.get(j).getAttribute("checked"));
				}
				System.out.println("\n");
			}
		}
  }
  
		
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
