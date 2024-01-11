package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
           //PageFactory -OR(Object Repository:
	
	@FindBy(name="email")
      WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signUpBtn; 
	
	//Initalizating page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);	 //all variables will be initialized with this driver. this means all above defined elements
	                                             //this is pointing to the current class object
	}  
	
	//Actions: 
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
    public HomePage login(String em, String pwd)
    {
    	email.sendKeys(em);
    	password.sendKeys(pwd);
    	loginBtn.click();
    	
    	return new HomePage();  //This method returns Instance of Home Page class
    	                        //It means login operation navigates to a new page(Home page) or updates the  current page URL
    }
	
}
