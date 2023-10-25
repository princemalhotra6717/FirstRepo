package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//span[text()='Sun Malhotra']")
	WebElement userNamelabel;
	
	@FindBy(xpath = "//span[text() = 'Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath = "//span[text() = 'Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath = "//span[text() = 'Tasks']")
	WebElement tasksLink;
	
	@FindBy(xpath = "//span[text()='Contacts']")
	WebElement hoverFunctions;
	
	
	public HomePage() {
    	PageFactory.initElements(driver, this);
    }
	public String verifyHomePageTitle() {
    	return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNamelabel.isDisplayed();
		
	}
	
    	public ContactsPage clickOnContactsLink() {
    		contactsLink.click();
    		return new ContactsPage();
    	}		
    	public DealsPage clickOnDealsLink() {
    			dealsLink.click();
        		return new DealsPage();
    		}
    	public TasksPage clickOnTasksLink() {
    		tasksLink.click();
        		return new TasksPage();
    		
	
	
	
	
	
	
	
	
		
}
}