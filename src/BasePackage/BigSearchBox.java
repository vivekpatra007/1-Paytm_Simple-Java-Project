// Searching an element in the Big search box and clicking on that element
// Using the DataProvider annotation

package BasePackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class BigSearchBox extends BaseTest{		
	
@Test(dataProvider="searchtext")

 public void BigSearchBox_Search(String a, String b) {
	try {
		
		WebElement dd = driver.findElement(By.xpath("//input[@autocomplete='off']"));
		WebDriverWait wait = new WebDriverWait (driver, 10);
		wait.until(ExpectedConditions.visibilityOf(dd));
		
		dd.sendKeys(a);
		Thread.sleep(3000);
		List<WebElement> search_list = driver.findElements(By.xpath("//div[@class='_3f1M']/ul[1]/li/span"));		
		System.out.println(search_list.size());
		
		
		for (int i=0; i<search_list.size();i++)
		{
			System.out.println(search_list.get(i).getText()); //Printing the elements in the list

		    if (search_list.get(i).getText().equalsIgnoreCase(b)) {
		    search_list.get(i).click();                    //Clicking a specific element in the list
		}
	  }		
	}
		
	catch (Exception e) {
		
		e.printStackTrace();
	}
}
@DataProvider
public Object[][] searchtext() {
	return new Object[][] {{"Nokia","Nokia Smartphones" }};
}
}
