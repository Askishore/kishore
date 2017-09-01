package ssaapp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksVerification {
	WebDriver driver;
	int i;
	
	@BeforeMethod
	public void bgoogleimagelinkchecking ()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Workspace for projects\\Interact\\lib\\chromedriver.exe");
		driver =new ChromeDriver();
	}
	@Test (priority = 1, enabled = false)
	public void tgoogleimagelinkchecking ()
	{	driver.get("https:\\www.google.com");
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
	@Test (priority = 2, enabled = false)
	public void thdfcvisablelinksgetting ()
	{	driver.get("http://www.hdfcbank.com/");
		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		System.out.println("All links are " + alllinks.size());
		int count=0;
		for ( i=0; i<alllinks.size(); i++) {
			if (!alllinks.get(i).getText().isEmpty()) {
				count++;
				System.out.println(alllinks.get(i).getText());
			}
		} 
		System.out.println("All visable links " + count);
	}
	@Test (priority = 3, enabled = false)
	public void tbinglinkschecking()
	{	driver.get("https://bing.com");
		WebElement blink = driver.findElement(By.id("sc_hdu"));
		List<WebElement> blinks = blink.findElements(By.tagName("a"));
		System.out.println("Total links are " + blinks.size());
		int count=0;
		for (i=0; i<blinks.size(); i++) {
			if (!blinks.get(i).getText().isEmpty()) {
				count ++;
				System.out.println(blinks.get(i).getText());
			}
		} System.out.println("all visable links are " + count);
	}
	@Test (priority = 4)
	public void tbbclinkverification() 
	{	driver.get("https://bbc.com");	
		WebElement dlink =	driver.findElement(By.xpath(".//*[@id='page']/section[6]/div/div/div[2]"));
		List<WebElement> dlinks = dlink.findElements(By.tagName("a"));
		System.out.println(dlinks.size());
		for (i=0; i<dlinks.size(); i++) {
			String exurl = dlinks.get(i).getAttribute("href");
			dlinks.get(i).click();
			String acurl = driver.getCurrentUrl();
			if (acurl.contains(exurl)) {
				System.out.println("Urls are matched");
			}else{
				System.out.println("Urls are not matched");
			}
			driver.navigate().back();
			dlink =	driver.findElement(By.xpath(".//*[@id='page']/section[6]/div/div/div[2]"));
			dlinks = dlink.findElements(By.tagName("a"));
		}
	}
	@Test (priority = 5, enabled = false)
	public void tgooglelinksverification ()
	{	driver.get("https://google.com");
		List<WebElement> gglinks = driver.findElements(By.tagName("a"));
		System.out.println(gglinks.size());
		int count=0;
		for (i=0; i<gglinks.size(); i++ ) {
			if (!gglinks.get(i).getText().isEmpty()){
				count++;
				String expurl =gglinks.get(i).getAttribute("href");
				gglinks.get(i).click();
				String acturl = driver.getCurrentUrl();
				if (acturl.contains(expurl)){
					System.out.println("Both links are matched \n" +acturl + "\n" +expurl );
				} else {
					System.out.println("Both links are not matched  \n" +acturl + "\n" +expurl);
				}
				driver.navigate().back();
				gglinks = driver.findElements(By.tagName("a"));
			}
		} 	System.out.println("Visable links are  " +count);
			System.out.println("Hidden links are  " + (gglinks.size()-count));
	}
	@Test (priority = 6, enabled = false)
	public void tbinglinksComparison ()
	{	driver.get("https://bing.com");
		WebElement blink = driver.findElement(By.id("sc_hdu"));
		List<WebElement> blinks = blink.findElements(By.tagName("a"));
		System.out.println("Total links are " + blinks.size());
		
		for (int i=0; i<blinks.size(); i++) {
			if (blinks.get(i).getText()== "Videos") {
				System.out.println(blinks.get(i).getText());
				blinks.get(i).click();
				break;
			}
		} 
	}
	@Test (priority = 0, enabled = false)
	public void tbinglinksComparison2()
	{	driver.get("https://bing.com");
		WebElement blink = driver.findElement(By.id("sc_hdu"));
		List<WebElement> blinks = blink.findElements(By.tagName("a"));
		System.out.println("Total links are " + blinks.size());
		
		for (i=0; i<blinks.size(); i++) {
			String svedios = blinks.get(i).getAttribute("innerHTML");
			if (svedios.contains("Maps")) {
			blinks.get(i).click();
		break;
			}
		} 	
	}
	@AfterMethod
	public void browserclose()
	{
		driver.close();
	}
}
