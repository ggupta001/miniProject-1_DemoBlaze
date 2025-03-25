package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.UtilityClass;

	public class ProjectSpecificMethod  extends UtilityClass{

		public ProjectSpecificMethod() throws IOException {
		super();
	}
		
		@BeforeMethod
		public  WebDriver openBrowser() {
			LaunchBrowser();	
			String URI=configProperties.getProperty("home-page-url");
			driver.get(URI);
			return driver;
		}
		
		@AfterMethod
		public void takeScreenshot(ITestResult result) throws IOException {
			if(ITestResult.FAILURE==result.getStatus()) {
				File screenshotfile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
				String path=System.getProperty("user.dir")+"\\Reports\\FailedTests\\Screenshot_"+timestamp+".png";
				FileUtils.copyFile(screenshotfile, new File(path));
			}
			
		}
		
		@AfterClass
		
		public void tearDown() {
			driver.close();
		}

}
