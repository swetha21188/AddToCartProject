package com.automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

	public static WebDriver driver;

@BeforeClass
	public void openBrowser() throws InterruptedException {
	
		//adding the path of the chromedriver into a config file
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("./resources/config.properties");
			// load a properties file
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 	String driverPath = prop.getProperty("driverPath");
	 	System.setProperty("webdriver.chrome.driver" , driverPath+"chromedriver");
	 	driver = new ChromeDriver();
	 	driver.get("http://store.23andme.com/en-us/");
	 	driver.manage().window().maximize();
 		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);   
  }

@AfterClass
   public void tearDown() {
	
		System.out.println("closing Browser"); 
		driver.quit();
   }
   
}
