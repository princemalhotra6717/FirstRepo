package com.crm.qa.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.util.TestUtil;

public class ReadProp {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("D:\\Workspace\\HybridAutomation\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(ip);
		
		System.out.println(prop.getProperty("browser"));
		
		String browserName = prop.getProperty("browser");
	    if (browserName.equals("chrome")) {
	    	System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\HybridAutomation\\src\\test\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
	    else if (browserName.equals("FireFox")) {
	    	driver = new FirefoxDriver();
			}
	    else {
	    	System.out.println("No Browser is opening");
	    }
		
	    driver.get(prop.getProperty("url"));
	    driver.manage().window().maximize();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[@href='https://ui.freecrm.com' and contains(@class, 'btn') and contains(@class, 'btn-primary') and contains(@class, 'btn-xs-2') and contains(@class, 'btn-shadow') and contains(@class, 'btn-rect') and contains(@class, 'btn-icon') and contains(@class, 'btn-icon-left')]")).click();
	    driver.findElement(By.name("email")).sendKeys(prop.getProperty("username"));
	    driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
	    
	    driver.findElement(By.xpath("//div[@class = 'ui fluid large blue submit button']")).click();
	    
	    WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
	    
	    WebElement contactsMenuItem = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Contacts']")));
	    
	    Actions builder = new Actions(driver);
	    builder.moveToElement(contactsMenuItem).clickAndHold().build().perform();
	    //driver.quit();
	    
	  //	    driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT ,TimeUnit.SECONDS);

	
	
	
	}
	}
