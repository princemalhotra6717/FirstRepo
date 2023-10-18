package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}	
	@BeforeMethod
	public void setUp() {
		Initialization();
		loginPage = new LoginPage();
}
	@Test
	public void validateLoginPageTitle() {
		String title = loginPage.validateLoginPageTitle();
		System.out.println("title of the page.."+title);
		Assert.assertEquals(title, "#1 Free CRM Power Up your Entire Business Free Forever");
		}
	@Test
	public void loginTest() throws InterruptedException  {
	 loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	} 
	 @Test
	 public void Test3() {
	 
	 Assert.assertEquals(false , true);
	 } 
	 
	 @AfterMethod
	public void teardown() {
	driver.quit();
}
}