package BasePackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {
	
	public WebDriver driver = null;
	
String URL = "https://paytm.com/";
	
	@BeforeTest
	public void beforetest() throws InterruptedException {
		System.out.println("Launch the browser");
		System.setProperty("webdriver.gecko.driver","C:\\Selenium-Java8-Eclipse\\Eclipse Worspace\\Selenium_3RI\\Drivers\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");
		driver = new FirefoxDriver();
		
		System.out.println("Launch the browser");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(URL);
		System.out.println("The landing page is:"+driver.getTitle());
		Thread.sleep(3000);
	}
		
	@Test
	public void logincreds() throws InterruptedException {


		
		driver.findElement(By.xpath("//span[@class='path5']"));
		Thread.sleep(2000);
		System.out.println("Page refreshed by clicking on Paytm icon on top left");
		Thread.sleep(2000);
		
		
	}
		
	/*@AfterTest
	public void aftertest()
	{
		driver.close();
		System.out.println("Close the browser");

	}*/
	

}
