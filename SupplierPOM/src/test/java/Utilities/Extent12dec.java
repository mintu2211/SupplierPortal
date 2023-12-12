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

public class Extent12dec implements ITestListener {

	
	private ExtentReports extentReports;
    private ExtentTest extentTest;
    private WebDriver driver;

    public void onStart(ITestContext context) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
        String reportName = "TestReport-" + timestamp + ".html";
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("Reports/" + reportName);
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        
      //add system info 
      		extentReports.setSystemInfo("Machine", "DevendraPC1");
      		extentReports.setSystemInfo("os", "window 11");
      		extentReports.setSystemInfo("Browser", "Edge");
      		extentReports.setSystemInfo("username", "Devendra");

      		//configuration 
      		htmlReporter.config().setDocumentTitle("Supplier Portal Report");
      		htmlReporter.config().setReportName("Supplier Portal Testing Report");
      		htmlReporter.config().setTheme(Theme.STANDARD);
      		//isme time samp nahi liya hai
        
    }

    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, "Test Case Passed: " + result.getName());
        
     // Capture screenshot and add to 
        if (driver instanceof TakesScreenshot) {
            String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            extentTest.log(Status.PASS, MarkupHelper.createLabel("Screenshot:", ExtentColor.GREEN));
            extentTest.addScreenCaptureFromBase64String(base64Screenshot);
        }
    
    }

    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL, "Test Case Failed: " + result.getName());

        // Capture screenshot and add to report
        if (driver instanceof TakesScreenshot) {
            String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            extentTest.log(Status.FAIL, MarkupHelper.createLabel("Screenshot:", ExtentColor.RED));
            extentTest.addScreenCaptureFromBase64String(base64Screenshot);
        }
    }

    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP, "Test Case Skipped: " + result.getName());
    }

    public void onFinish(ITestContext context) {
        extentReports.flush();
    }

    // Add methods for other ITestListener events if needed

    // Set the WebDriver instance
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
