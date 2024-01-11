package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	
	public static WebDriver driver; 
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase()  //Constructor
	{
		try {
			 String basePath = "E:\\UdemyAutomationCode\\AutomationFramework\\src\\main\\java\\com\\crm\\qa\\config\\";
			 String filePath = basePath + "config.properties" ;
			
			prop = new Properties();
			//FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "E:/UdemyAutomationCode/AutomationFramework/src/main/java/com/crm/qa/config/config.properties");
			FileInputStream ip = new FileInputStream(filePath);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	public static void initialization()
	{
		String browserName = prop.getProperty("browser"); //Read property
		
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\UdemyAutomationCode\\chromedriver-win64\\chromedriver.exe");		
			 driver = new ChromeDriver();
			
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
         
         driver.get(prop.getProperty("url"));
		 
		 
		}
	
	
	}
	

