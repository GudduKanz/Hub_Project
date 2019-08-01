package TestNG_Files;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Page_Code.Hubcodes;
import TestDataEngine_Files.TestExcelsheet;
import Utilities_Files.Mybrowsercodings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class TestScript {
	public static WebDriver driver;
	ExtentReports report;//global variables
	ExtentTest logger;
  @Test(priority=0,dataProvider="Test")
  public void Signin(String user,String pass) throws IOException, InterruptedException {
	  report=new ExtentReports("D:\\ResultReport.html",true);
	  logger=report.startTest("BusinessVerifyLogin");
	  Hubcodes obj = PageFactory.initElements(driver, Hubcodes.class);
	  obj.login(user, pass);
	  logger.log(LogStatus.INFO, "Logins the application successfully");
	  
  }
  
  @Test(priority=1)
  public void Share() {
	  Hubcodes obj1 = PageFactory.initElements(driver, Hubcodes.class);
	  obj1.Shareanupdate("Happy to be hear");

  }
  @BeforeClass
  public void beforeMethod() throws InterruptedException {
	  driver = Mybrowsercodings.Browserfact("chrome", "https://check.youthhub.co.nz/");
  }

  @AfterMethod
  public void afterMethod(ITestResult result) {
	  if (result.getStatus() == ITestResult.FAILURE) {
	  logger.log(LogStatus.FAIL, "Test failed " + result.getThrowable());
	  } else if (result.getStatus() == ITestResult.SKIP) {
	  logger.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
	  } else {
	 logger.log(LogStatus.PASS, "Test passed");
	 report.endTest(logger);
	  }
  }
  @AfterTest
  public void endReport()
  {
  report.flush();
  report.close();
  }
  @DataProvider
  public Object[][] Test() {
	 TestExcelsheet RR = new TestExcelsheet("C:\\Users\\Guddu\\eclipse-workspace\\Hub_Project\\src\\TestData\\Login Data.xlsx");
  int rows = RR.getrowgount(0);
  	   Object [][] data = new Object [rows][2];
  	   for(int i=0;i<rows;i++)
  	   {
  		   data[i][0] = RR.getData(0, i, 0);
  		   data[i][1]= RR.getData(0, i,1);
  		
  		   
  		   }
  	   return data;
  	  }
}
