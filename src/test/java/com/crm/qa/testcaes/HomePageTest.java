package com.crm.qa.testcaes;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	DealsPage dealsPage;
	TasksPage taskPage;
	
	
	public HomePageTest()
	{
		super(); 
	}
	
	@BeforeMethod
	public void setUp()
	{
	 	initialization();
	 	loginPage = new LoginPage();
	 	contactPage = new ContactsPage();
	 	dealsPage =  new DealsPage();
	 	taskPage = new TasksPage();
	 	homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password")); //login method is returning home page class object
	}
	
    @Test(priority=1)
    public void verifyHomePageTitleTest()
    {
    	String homePageTitle= homePage.homePageTilte();
    	Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home Page title not matched");
    	
    }
    
    @Test(priority = 2)
    public void verifyUserNameTest()
    {
    	Assert.assertTrue(homePage.verifyCorrectUserName());
    	
    }
    
	
	  @Test(priority = 3) 
	  public void contactsClickTest() throws InterruptedException
	  {
		  contactPage= homePage.contactClick();
		  
	  }
	  
		
	@Test(priority =4)
	public void dealsPageClickTest() 
    {
	  dealsPage = homePage.dealsClick();
    }
	
	@Test(priority= 5)
	public void tasksPageClickTest()
	{
		taskPage = homePage.tasksClick();
	}
		  
		 
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	} 
	
}
