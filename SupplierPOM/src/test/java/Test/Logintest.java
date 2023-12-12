package Test;

import java.util.concurrent.TimeUnit;

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

@Listeners(Extent12dec.class)
public class Logintest {

	
	
	@Test(dataProvider = "labourcategory", dataProviderClass = Excellabourcat.class)
	public void  loginsuppllier(String url,String usern, String pass, String labcatname, String SearchText) {
		WebDriver driver= new EdgeDriver();
		WebDriverManager.edgedriver().setup();
		//UAT
		//driver.get("http://172.16.0.21/SupplierPortal_QA/profile/mysupplierprofile");
		driver.get(url);
		//QA
		//driver.get("http://172.16.0.21/SupplierPortal_QA/profile/mysupplierprofile/");
		driver.manage().window().maximize();
		
		Login la = new Login(driver);
		la.enterusernaem(usern);
		la.enterpwd(pass);
		la.clickbutton();
		
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
