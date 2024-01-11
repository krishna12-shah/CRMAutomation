package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	//div[@class='ui header item mb5 light-black']/span[@class='selectable ']
	WebElement contactsLabel;
	
	@FindBy(xpath="//div[@name='channel_type']")
	WebElement socialChannels;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='middle_name']")
	WebElement middleName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@placeholder='Email address']")
	WebElement emailAddress;
	
	@FindBy(xpath="//label[text()='Status']/following-sibling::div[@name='status']")
	WebElement selectStatus;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveBtn;

	HomePage hp= new HomePage();
	
	//Initializing Page Objects
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsPageLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	
	public void selectContactsByName(String name) 
	{
				
		 driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td")).click();		
	}
	
    public void createNewContact(String fN, String mN, String lN, String eA, String status, String channelName)
    {
                
    	firstName.sendKeys(fN);
    	middleName.sendKeys(mN);
    	lastName.sendKeys(lN);
    	emailAddress.sendKeys(eA);
    	socialChannels.click();   
    	hp.a.moveToElement(selectStatus).click().sendKeys(status).sendKeys(Keys.ENTER).build().perform();
    	hp.a.moveToElement(socialChannels).click().sendKeys(channelName).sendKeys(Keys.RETURN).build().perform();
    	saveBtn.click();
    	
    	     	
    }
    
  
    
}
