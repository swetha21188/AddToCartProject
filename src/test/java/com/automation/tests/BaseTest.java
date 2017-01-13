package com.automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

public class BaseTest {

	public static WebDriver driver;

@BeforeClass
	public void openBrowser() throws InterruptedException {
	
 		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);   
	 	String driverPath = "/Users/spatoor/Downloads/";
	 	System.setProperty("webdriver.chrome.driver" , driverPath+"chromedriver");
	 	driver = new ChromeDriver();
	 	driver.get("http://store.23andme.com/en-us/");
	 	driver.manage().window().maximize();
  }

@AfterClass
   public void tearDown() {
	
		System.out.println("closing Browser"); 
		driver.quit();
   }
   
}
