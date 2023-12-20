package Test;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObjectAdmin.AdminSideLaborCategory;
import PageObjectAdmin.ClickActionOfAllMenu;
import PageObjectAdmin.Login;
import Utilities.Excellabourcat;
import Utilities.Extent12dec;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(Utilities.Listeners.class)
public class Logintest {

	public static Logger logger;
	
	
	@Test(dataProvider = "labourcategory", dataProviderClass = Excellabourcat.class)
	public void  loginsuppllier(String url,String usern, String pass, String labcatname, String SearchText) {
		logger =LogManager.getLogger("SupplierTestLogs");
		WebDriver driver= new EdgeDriver();
		WebDriverManager.edgedriver().setup();
		logger.info("open browser");
		//UAT
		//driver.get("http://172.16.0.21/SupplierPortal_QA/profile/mysupplierprofile");
		driver.get(url);
		logger.info("enter url");
		
		//QA
		//driver.get("http://172.16.0.21/SupplierPortal_QA/profile/mysupplierprofile/");
		driver.manage().window().maximize();
		
		Login la = new Login(driver);
		la.enterusernaem(usern);
		logger.info("enter username");
		la.enterpwd(pass);
		logger.info("enter password");
		la.clickbutton();
		logger.info("click on submit");
		ClickActionOfAllMenu cm = new ClickActionOfAllMenu(driver);
		cm.clickonMasterManagement();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cm.clickonLabourcategory();
		
		AdminSideLaborCategory asl = new AdminSideLaborCategory(driver);
		//asl.enterlabourcategoryfield(labcatname);
		//asl.ClickonSave();
		asl.enterinsearch(SearchText);
		
		
	}
	
	
	
}
