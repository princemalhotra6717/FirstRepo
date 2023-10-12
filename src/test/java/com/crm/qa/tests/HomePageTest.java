package com.crm.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;



public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super(); // we use super base class constructor will be called and my property will be initialized
	}
	//test cases should be separated - independent of each other.
	//@before each test cases -- launch the browser and login.
	//@test method execute test cases 
	//@after each test cases -- close the browser.
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		Initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = new ContactsPage();
    }
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		
		String homePageTitle = homePage.verifyHomePageTitle();
		System.out.println("title of the page is.."+homePageTitle);
		Assert.assertEquals(homePageTitle, "Cogmento CRM" , "Home Page Title is not displayed");
		}
	@Test(priority=2)
	public void verifyUserNameTest() {
		
		Assert.assertTrue(homePage.verifyCorrectUserName());
		
		boolean result = homePage.verifyCorrectUserName();
		System.out.println("Assertion result: " + result);

		}
	
	@Test(priority=3)
	public void hoverFunction() {
		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
	    
	    WebElement contactsMenuItem = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Contacts']")));
	    
	    Actions builder = new Actions(driver);
	    builder.moveToElement(contactsMenuItem).clickAndHold().build().perform();
	}
	
	@Test(priority=4)
	public void verifyContactsLinkTest() {
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	
}
}