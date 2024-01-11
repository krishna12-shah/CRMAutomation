package com.crm.qa.testcaes;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	String sheetname= "Contacts";
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
	 	initialization();
	 	loginPage = new LoginPage();
	 	contactPage = new ContactsPage();
	 	//dealsPage =  new DealsPage();
	 	//taskPage = new TasksPage();
	 	homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password")); //login method is returning home page class object
	 	contactPage= homePage.contactClick();
	}
		
	@Test(priority = 1)
	public void verifyContactsPageLabelTest()
	{
		Assert.assertTrue(contactPage.verifyContactsPageLabel(), "Contact lable is missing on the Page");   ;
	}
	
	@Test(priority = 2)
	
	public void selectContactsTest() 
	{
		contactPage.selectContactsByName("Jennifer  Wade");
	}
	
	@Test(priority = 3)
	public void selectMultipleContacts()
	{
		contactPage.selectContactsByName("Tyler Hale");
		contactPage.selectContactsByName("Jennifer  Wade");
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
	  	Object data[][] =TestUtil.getTestData(sheetname);
	  	return data; 
	}
	
	@Test(priority =4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String firstname, String middlename, String lastname, String email,String status, String socialchannel)
	{
		homePage.addNewContact();
		//contactPage.createNewContact("Jully", "Ken", "Wron", "julie8@yopmail.com");
		contactPage.createNewContact(firstname, middlename, lastname, email, status, socialchannel);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
