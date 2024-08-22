package QA_Automation_Testing_Task;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class search_functionality {
	WebDriver driver ;
	@BeforeTest
	public void beforetest() {
		// create the  Chromedriver method
		WebDriverManager.chromedriver().setup();
		// Set up Chromedriver object
		driver = new ChromeDriver();
		// Open eBay website
		driver.get("https://www.ebay.com/");
		// Maximize the browser window
		driver.manage().window().maximize();
		
	}
	@Test
	public void search_product() {
		try {
			//apply the implicitywait
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//select the textfield for search
			WebElement textfield   = driver.findElement(By.id("gh-ac"));
			//send the value useing sendkeys
			textfield.sendKeys("camera");
			//apply the threadsleep
			Thread.sleep(1000);
			//clcik on the serachbox button
			WebElement searchbox   = driver.findElement(By.id("gh-btn"));
			//clcik on  the button
			 searchbox.click();
			//apply the threadsleep
			 Thread.sleep(1000);
			 //apply the softasseration
			 String title = driver.getTitle();
			 //create the object for softassert
			 SoftAssert  sc = new SoftAssert();
			
			 sc.assertAll();	
			 
			 //value should there in expected text
			  String expectedText = "Camera for sale | eBay";
			  //check the Expected text found or nt  useing if else condiation
			  if (title.contains(expectedText)) {
	                System.out.println("Test Passed: Expected text found.");
	            } else {
	                System.out.println("Test Failed: Expected text missing.");
	            }
			 
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	@AfterTest
	public void aftertest() {
		//colse the browser
		driver.close();
	}

}
