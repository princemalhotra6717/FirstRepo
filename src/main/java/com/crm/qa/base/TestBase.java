package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	
	//public static void main(String[]args) throws IOException, InterruptedException {
		//WebDriver driver = null;

	public TestBase() {
		try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("D:\\Workspace\\HybridAutomation\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
	    prop.load(ip);
	    
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
			}
	    
	    System.out.println(prop.getProperty("browser"));
	}

	    public static void Initialization() {
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
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT ,TimeUnit.SECONDS);
	    // Launch a URL
	    driver.get(prop.getProperty("url"));
	    
	    }
	    public static WebDriver getDriver() {
			return driver;
	    	
	
	
	
	
	
	
}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
