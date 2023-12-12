package Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestListener;
import org.testng.annotations.Test;
import org.testng.internal.annotations.IListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentGit  {

	static WebDriver driver;

	@Test
	public void configurationReport() throws Exception
	{
		ExtentSparkReporter htmlReporter;
		ExtentReports extentReport = new ExtentReports();
		File file=new File("report.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReport.attachReporter(sparkReporter);



		

		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.get("https://www.amazon.com");
		String base64code = capturScreenshot();
		String path = capturScreenshot("Google.jpg");
		driver.manage().window().maximize();



		extentReport.createTest("ScreenShot Test1", "This is for attaching the screenshot")
		.info("this is a info msg")
		.addScreenCaptureFromBase64String(base64code);

		extentReport.createTest("ScreenShot Test2", "This is for attaching the screenshot")
		.info("this is a info msg")
		.addScreenCaptureFromBase64String(base64code, "Google HomePage");

		extentReport.createTest("ScreenShot Test3", "This is for attaching the screenshot")
		.info("this is a info msg")
		.addScreenCaptureFromBase64String(base64code, "Google HomePage1")
		.addScreenCaptureFromBase64String(base64code, "Google HomePage2")
		.addScreenCaptureFromBase64String(base64code, "Google HomePage3")
		.addScreenCaptureFromBase64String(base64code, "Google HomePage4");


		extentReport.createTest("ScreenShot Test4", "This is for attaching the screenshot")
		.info("this is a info msg")
		.addScreenCaptureFromPath(path);

		extentReport.createTest("ScreenShot Test5", "This is for attaching the screenshot")
		.info("this is a info msg")
		.addScreenCaptureFromPath(path, "Google HomePage");

		extentReport.createTest("ScreenShot Test6", "This is for attaching the screenshot")
		.info("this is a info msg")
		.addScreenCaptureFromPath(path, "Google HomePage1")
		.addScreenCaptureFromPath(path, "Google HomePage2")
		.addScreenCaptureFromPath(path, "Google HomePage3")
		.addScreenCaptureFromPath(path, "Google HomePage4");

		extentReport.createTest("ScreenShot Test7", "This is for attaching the screenshot")
		.info("this is a info msg")
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64code).build())
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64code, "Google HomePage").build());

		extentReport.createTest("ScreenShot Test8", "This is for attaching the screenshot")
		.info("this is a info msg")
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build())
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path, "Google HomePage").build());

		extentReport.createTest("ScreenShot Test9", "This is for attaching the screenshot")
		.info("this is a info msg")
		.fail("this is a info msg",MediaEntityBuilder.createScreenCaptureFromBase64String(base64code).build())
		.fail("this is a info msg",MediaEntityBuilder.createScreenCaptureFromBase64String(base64code, "Google HomePage").build());

		extentReport.createTest("ScreenShot Test10", "This is for attaching the screenshot")
		.info("this is a info msg")
		.fail("this is a info msg",MediaEntityBuilder.createScreenCaptureFromPath(path).build())
		.fail("this is a info msg",MediaEntityBuilder.createScreenCaptureFromPath(path, "Google HomePage").build());

		Throwable t=new Throwable("This Is throwable exception");
		extentReport.createTest("ScreenShot Test11", "This is for attaching the screenshot")
		.info("this is a info msg")
		.fail(t,MediaEntityBuilder.createScreenCaptureFromBase64String(base64code).build())
		.fail(t,MediaEntityBuilder.createScreenCaptureFromBase64String(base64code, "Google HomePage").build());

		extentReport.createTest("ScreenShot Test12", "This is for attaching the screenshot")
		.info("this is a info msg")
		.fail(t,MediaEntityBuilder.createScreenCaptureFromPath(path).build())
		.fail(t,MediaEntityBuilder.createScreenCaptureFromPath(path, "Google HomePage").build());


		extentReport.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());
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
