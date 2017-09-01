/**
 * 
 */
package interactapp;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Mahalakshmi Voona
 *
 */
public class DepositAccount {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Workspace for projects\\Interact\\lib\\chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		
		
		// Gmail sign in and sign out
		
		driver.get("https:\\www.gmail.com");
		Thread.sleep(5000);
		driver.findElement(By.id("Email")).sendKeys("satyakishore2k5@gmail.com");
		driver.findElement(By.id("next")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("Passwd")).sendKeys("maha1981");
		driver.findElement(By.id("signIn")).click();
		driver.findElement(By.xpath(".//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
		driver.findElement(By.id("gb_71")).click();
		
		
		
		//eenadu pellipandiri registration
		
		/*driver.get("https://eenadupellipandiri.net/");
		Thread.sleep(4000);
		driver.findElement(By.id("name")).sendKeys("satyakishore");
		driver.findElement(By.id("registered_by")).click();
		String name_Value = driver.findElement(By.xpath(".//*[@id='name']")).getText();
		System.out.println(name_Value);
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("registered_by")).click();
		String Value = driver.findElement(By.xpath(".//*[@id='err_name2']")).getText();
		System.out.println("Error is  "+ Value);
		System.out.println(driver.findElement(By.xpath(".//*[@id='err_name2']")).getAttribute("innerHTML"));
		
		String actual=driver.getPageSource();
		String expected="* Please enter correct name";
		if(actual.contains(expected))
		{
			System.out.println("Text contains");
		}
		else
		{
			System.out.println("Text not contains");
		}
		driver.findElement(By.id("name")).sendKeys("satyakishore");
		System.out.println(driver.findElement(By.id("name")).getText());*/
		
		
	}
}
