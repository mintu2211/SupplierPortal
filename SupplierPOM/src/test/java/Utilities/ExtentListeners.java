package Utilities;



import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListeners implements ITestListener{

	WebDriver driver;
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	public void configurationReport()
	{

		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "SupplierTestReports" + timestamp + ".html";
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);

		//add system info 
		reports.setSystemInfo("Machine", "DevendraPC1");
		reports.setSystemInfo("os", "window 11");
		reports.setSystemInfo("Browser", "Edge");
		reports.setSystemInfo("username", "Devendra");

		//configuration 
		htmlReporter.config().setDocumentTitle("Supplier Portal Report");
		htmlReporter.config().setReportName("Supplier Portal Testing Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		//isme time samp nahi liya hai

	}

	

	// Set the driver before using it
	public void setDriver(WebDriver driver) {
	    this.driver = driver;
	}
	
	

	//(1) onstart method is called when any test starts.
	public void onStart(ITestContext Result)
	{
		configurationReport();
		System.out.println("on start method is invoked");
	}

	//(2) onfinish method is called after all test are executed
	public void onFinish(ITestContext Result)
	{
		System.out.println("on finish method invoked");
		reports.flush();
		//it is mendatory to call flush method to ensure information is written to the started reporter

	}

	//(3) when test case get failed,this method is called 
	public void onTestFailure(ITestResult Result)
	{
		System.out.println("Name of test method failed " +Result.getName());
		test=reports.createTest(Result.getName());
	
		//test.log(Status.FAIL, MarkupHelper.createLabel("Name of TestCases is" +Result.getName(), ExtentColor.RED));
		
		  test.log(Status.FAIL, "Test failed");
	        test.log(Status.FAIL, Result.getThrowable());

	        // Capture screenshot and add to report
	       // String base64Screenshot = ScreenshotUtil.captureScreenshotAsBase64(DriverFactory.getDriver());
	        String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	        if (base64Screenshot != null) {
	            test.log(Status.FAIL, MarkupHelper.createLabel("Screenshot:", ExtentColor.RED));
	            test.addScreenCaptureFromBase64String(base64Screenshot);
	        }
		
		 
		
		//String screenshotpath=System.getProperty("user.dir") + "\\Screenshots\\" + Result.getName() + ".png";
		//File screenshotfile=new File(screenshotpath);

		//if(screenshotfile.exists())
		//{
		//	test.fail("captured screenshot is below" +test.addScreenCaptureFromPath(screenshotpath));
		//}

		//test.addScreenCaptureFromPath(null)


	}

	//(4) when test case get skipped,this method is called 
	public void onTestSkipped(ITestResult Result)
	{
		System.out.println("Name of test method skipped " +Result.getName());
		test=reports.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of TestCases is" +Result.getName(), ExtentColor.YELLOW));
	}


	//(5) when on test case get started, this method is called
	public void onTestStart(ITestResult Result)
	{
		System.out.println("Name of the method started:" +Result.getName() );

	}

	//(6) when test case get passed,this method is called 
	public void onTestSuccess(ITestResult Result)
	{
		System.out.println("Name of test method Success " +Result.getName());
		test=reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of TestCases is" +Result.getName(), ExtentColor.GREEN));
		String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		test.log(Status.PASS, "Screenshot below: " + test.addScreenCaptureFromBase64String(base64Screenshot));
	}

	//(7) when test case onTestfailureButWithinSuccessPercentage,this method is called 
	public void onTestfailureButWithinSuccessPercentage(ITestResult Result)
	{

	}


	
	
	
}
