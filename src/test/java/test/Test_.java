package test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import library_flipkart.base_class_flipkart;
import library_flipkart.utility_class_flipkart;
import module_1.Page2;
import module_1.Page3_flipkart_start;
import module_1.page1_google;
import module_1.page4;

public class Test_ extends base_class_flipkart
{ ExtentSparkReporter htmlReport;
ExtentReports reports;
ExtentTest test;

page1_google page1;
Page2 page2_flipkart;
Page3_flipkart_start page3;
page4 page4_flipkart;
int TCID;

@BeforeClass
public void BrowserOpen()
{
	Browser();
	page1 =new page1_google(driver);
	page2_flipkart=new Page2(driver);
	page3 =new Page3_flipkart_start(driver);
	page4_flipkart =new page4(driver);
}
@BeforeMethod
public void search() throws EncryptedDocumentException, IOException
{
	page1.search_box(utility_class_flipkart.Excel_data(0, 0));
	page1.click_search_button();
	page2_flipkart.click_flip();
	page3.click_close_X();
	page4_flipkart.more_click();
}
@BeforeTest
public void startReport()
{
	htmlReport =new ExtentSparkReporter("ExtentReportFlipkar.html");
	reports =new ExtentReports();
	reports.attachReporter(htmlReport); // tpo attach report ie htmlReport

	//add environment details
	reports.setSystemInfo("Machine", "test1");
	reports.setSystemInfo("Os", "windows 11");
	reports.setSystemInfo("userName", "Akshay");
	reports.setSystemInfo("browserName", "Chrome");

	//configuration to change the look and feel
	htmlReport.config().setDocumentTitle("Extent Report demo");
	htmlReport.config().setReportName("Test report");
	htmlReport.config().setTheme(Theme.STANDARD);
	htmlReport.config().setTimeStampFormat("EEEE , MMMM dd, yyyy, hh:mm a '('zzz')'");


}
@Test
public void verify_list() throws EncryptedDocumentException, IOException
{TCID=10;

for(int i=0; i<page4_flipkart.more_options_get().size();i++)
{
	String actualll = page4_flipkart.more_options_get().get(i).getText();
	String expecteddd = utility_class_flipkart.Excel_data(i, 2);


	Assert.assertEquals(actualll,expecteddd ," failed test" );

	Reporter.log("Actual : "+ actualll + "  & Expected : "+ expecteddd);

}




}
@AfterMethod
public void LogOut(ITestResult result) throws IOException
{
	if (result.getStatus()==ITestResult.FAILURE)
	{
		 utility_class_flipkart.Screenshoot_flipkart(driver, TCID);
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"Fail",ExtentColor.RED ));
		// fail testcase name get in red colour
		test.fail(result.getThrowable());//  all detail of fail will be show in report
		
	}
	else if(result.getStatus()==ITestResult.SUCCESS)
	{
		test.log(Status.PASS , MarkupHelper.createLabel(result.getName()+"Pass",ExtentColor.GREEN ));
	}
	else if(result.getStatus()==ITestResult.SKIP)
	{
		test.log(Status.SKIP , MarkupHelper.createLabel(result.getName()+"Skipped",ExtentColor.YELLOW ));
	}

}
@AfterTest
public void  tearDown()
{
	reports.flush(); //  to write the report
}
@AfterClass
public void BrowserClose()
{
	driver.close();
}

}
