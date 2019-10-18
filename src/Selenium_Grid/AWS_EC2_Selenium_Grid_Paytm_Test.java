package Selenium_Grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AWS_EC2_Selenium_Grid_Paytm_Test {
	
	public WebDriver driver = null;
	
String URL2 = "https://paytm.com/";
	
	@BeforeTest
	public void beforetest() throws InterruptedException, MalformedURLException {
		//System.out.println("Launch the browser");
		//System.setProperty("webdriver.gecko.driver","C:\\Selenium-Java8-Eclipse\\Eclipse Worspace\\Selenium_3RI\\Drivers\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		//System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");
		//driver = new FirefoxDriver();
		
		    String platform_name = "linux";
		    String browser_name = "firefox";
		    String browser_version = "59.0.1";
		    DesiredCapabilities capabilities = new DesiredCapabilities();
		    capabilities.setPlatform(Platform.LINUX);
		    capabilities.setBrowserName(browser_name);
		    capabilities.setVersion(browser_version);
		    RemoteWebDriver driver = new RemoteWebDriver(new URL("http://ec2-18-221-237-122.us-east-2.compute.amazonaws.com:4444/wd/hub"),capabilities);
		
		System.out.println("Launch the browser");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to(URL2);
		System.out.println("The landing page is:"+driver.getTitle());
		Thread.sleep(3000);
	}
		
	//@Test(dataProvider="searchtext")
	public void logincreds() throws InterruptedException {


		
		driver.findElement(By.xpath("//span[@class='path5']"));
		Thread.sleep(2000);
		System.out.println("Page refreshed by clicking on Paytm icon on top left");
		Thread.sleep(2000);
		
		RemoteWebElement dd = (RemoteWebElement)driver.findElement(By.xpath("//input[@autocomplete='off']"));		
		WebDriverWait wait = new WebDriverWait (driver, 10);
		wait.until(ExpectedConditions.visibilityOf(dd));
		
		dd.sendKeys("Nokia");
		Thread.sleep(3000);
		List<WebElement> search_list = driver.findElements(By.xpath("//div[@class='_3f1M']/ul[1]/li/span"));		
		System.out.println(search_list.size());
		
		
		for (int i=0; i<search_list.size();i++)
		{
			System.out.println(search_list.get(i).getText()); //Printing the elements in the list

		    if (search_list.get(i).getText().equalsIgnoreCase("Nokia Smartphones")) {
		    search_list.get(i).click();                    //Clicking a specific element in the list
		}
		}
		
	}
		
	/*@AfterTest
	public void aftertest()
	{
		driver.close();
		System.out.println("Close the browser");

	}*/
	
		/*@DataProvider
		public Object[][] searchtext() {
			return new Object[][] {{"Nokia","Nokia Smartphones" }};*/
		}


