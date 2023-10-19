package allureReports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.crm.qa.base.TestBase;

import io.qameta.allure.Attachment;

public class AllureListener implements ITestListener {
	
	@Override
	public void onTestFailure(ITestResult result) {
		saveScreenshotOnFailure(TestBase.getDriver());
		saveLogs(result.getMethod().getConstructorOrMethod().getName());
		}
     //Text attachment for Allure
	@Attachment(value = "Page screenshot" , type = "image/png")
	public byte[] saveScreenshotOnFailure(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		
	}
	//Text attachment for Allure
	@Attachment(value = "Logs" , type = "text/plain")
	public static String saveLogs(String message) {
		return message;
	}

}