package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	//Home Page Factory
	//We have created Page Library
	
	@FindBy(xpath="//span[text() = 'Johnny Deep']")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath="//div[@id='main-nav']")
	WebElement mainNav;
	
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//th[text()='Email']")
	WebElement contactPagecusrsormove;
	
	@FindBy(xpath="//a[@href='/contacts']/following-sibling::button//i[@class='plus inverted icon']")
	WebElement newContactLink;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement addContactCursormove;
	
	@FindBy(xpath="//span[text()='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath= "//span[text()='Tasks']")
	WebElement tasksLink;
	
	
	
		
	public Actions a = new Actions(driver); 
	
	public HomePage() {
		PageFactory.initElements(driver, this);	
	}
	
	public String homePageTilte()
	{
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName()
	{
		return userNameLabel.isDisplayed();
	}
	
	public void moveToMainNav()
	{
		
		a.moveToElement(mainNav).build().perform();
		
	}
	public ContactsPage contactClick() throws InterruptedException
	{
		moveToMainNav();
		contactsLink.click();
		Thread.sleep(3000);
		a.moveToElement(contactPagecusrsormove).build().perform();
		return new ContactsPage();
	}
	
	public void addNewContact()
	{
		moveToMainNav();
		newContactLink.click();
		a.moveToElement(addContactCursormove).build().perform();
	}
	
	public DealsPage dealsClick()
	{
		moveToMainNav();
		dealsLink.click();
		
		return new DealsPage();
	}
	
	public TasksPage tasksClick()
	{
		moveToMainNav();
		tasksLink.click();
		
		return new TasksPage(); //Bcoz now the browser is hoping to the next landing page(TasksPage)
	}
	
}
