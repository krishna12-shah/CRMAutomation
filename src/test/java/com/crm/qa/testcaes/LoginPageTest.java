package com.crm.qa.testcaes;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	Logger log = Logger.getLogger(LoginPageTest.class);
	LoginPage loginPage; //Declared variable
	HomePage homePage;
	public LoginPageTest()
	{
		super(); //It will first call parent class(Test Base) constructor
		         //Compulsory to call Testbase class constructor
	}
	
	@BeforeMethod
	public void setUp()
	{
	 	initialization();
	 	loginPage = new LoginPage();
	 	log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
	}
	 
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** freeCrmTitleTest *****************************************");
		String title =loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
		//System.out.println(title);
		
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** freeCrmTitleTest *****************************************");
		
	}
	
	@Test(priority=2)
	public void loginTest()
	{
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password")); //Bcoz this method is returning HomePage class object
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		log.info("****************************** Browser is closed *****************************************");
	}
	
}
