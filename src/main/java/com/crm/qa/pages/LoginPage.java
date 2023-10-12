package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	// OBJECT REPOSITORY OR PAGE FACTORY
	@FindBy(xpath =  "//span[text()='Log In']")
	By loginIcon = By.xpath("//span[text()='Log In']");
	
	public void clickLogin() {
		driver.manage().timeouts().implicitlyWait(20 ,TimeUnit.SECONDS);
		driver.findElement(loginIcon).click();
		}
	@FindBy(name = "email")
    By email = By.name("email");
	
	public void emailEnter() {
		driver.manage().timeouts().implicitlyWait(40 ,TimeUnit.SECONDS);
		driver.findElement(email).sendKeys(prop.getProperty("username"));
	}
	
	@FindBy(name = "password")
    By password = By.name("password");
	
	public void passwordEnter() {
		driver.manage().timeouts().implicitlyWait(40 ,TimeUnit.SECONDS);
		driver.findElement(password).sendKeys(prop.getProperty("password"));
	}
    
    @FindBy(className = "//div[@class = 'ui fluid large blue submit button']")
    By loginbtn = By.xpath("//div[text()='Login']"); 
    
    public void SubmitBtn() {
    	driver.manage().timeouts().implicitlyWait(50 ,TimeUnit.SECONDS);
    	driver.findElement(loginbtn).click();
    }
    
    @FindBy(xpath = "//a[contains(@class, 'btn') and contains(@href, 'register') and normalize-space()='sign up']")
    WebElement signUPBtn;
    //Initializing the Page Objects:
    public LoginPage() {
    	PageFactory.initElements(driver, this);
    }
    //Actions:
    public String validateLoginPageTitle() {
    	return driver.getTitle();
    }
    public HomePage login(String un , String pwd) throws InterruptedException {
    	Thread.sleep(2000);
    	clickLogin();
    	emailEnter();
    	passwordEnter();
    	SubmitBtn();
    	//email.sendKeys(un);
    	//password.sendKeys(pwd);
    	//loginBtn.click();
    	
    	return new HomePage();
    	
    }
    
    
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	


    
}