package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListener2 implements ITestListener {

	static WebDriver driver;
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	private String base64code;

	public void configurationReport() throws Exception
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
		try {
			configurationReport();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
		
		//String path = capturScreenshot("Google.jpg");
		System.out.println("Name of test method failed " +Result.getName());
		test=reports.createTest(Result.getName());
	
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of TestCases is" +Result.getName(), ExtentColor.RED));
		Object fail = reports.createTest("ScreenShot Test7", "This is for attaching the screenshot")
		.info("this is a info msg")
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64code).build())
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64code, "Google HomePage").build());
		
		
		
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
		
		String base64code = "screenshots";
		try {
			base64code = capturScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String path = capturScreenshot("Google.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Name of test method Success " +Result.getName());
		test=reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of TestCases is" +Result.getName(), ExtentColor.GREEN));
		
		Object fail = reports.createTest("ScreenShot Test7", "This is for attaching the screenshot")
				.info("this is a info msg")
				.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(base64code).build())
				.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(base64code, "Google HomePage").build());
				
		
		
		
		
	}

	//(7) when test case onTestfailureButWithinSuccessPercentage,this method is called 
	public void onTestfailureButWithinSuccessPercentage(ITestResult Result)
	{

	}
	
	
	public static String capturScreenshot() throws IOException
	{
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;
		String base64code  = takescreenshot.getScreenshotAs(OutputType.BASE64);
		
		System.out.println("Screenshot saved sucessfully");
		return base64code;
	}
	
	
	public static String capturScreenshot(String filename) throws IOException
	{
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;
		File sourcefile = takescreenshot.getScreenshotAs(OutputType.FILE);
		  File destfile = new File("./Screenshot/"+ filename);
		//File destfile = new File(System.getProperty("user.dir") + ".\\Screenshot\\" + filename + ".png");
		FileUtils.copyFile(sourcefile, destfile);
		//System.out.println("Screenshot saved sucessfully");
		return destfile.getAbsolutePath();
	}


	
}
