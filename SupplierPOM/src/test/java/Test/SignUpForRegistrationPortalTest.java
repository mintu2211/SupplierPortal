package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import PageObjectAdmin.ClickActionOfAllMenu;
import PageObjectAdmin.Login;
import PageObjectAdmin.SignUpforSupplierRegistrationPortal;
import Utilities.ExcelSignUp;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SignUpForRegistrationPortalTest {

     
	@Test(dataProvider = "loginsupplierdata", dataProviderClass = ExcelSignUp.class)
	public void  loginsuppllier(String url, String usern, String pass, String FName, String LName, String mail,String ein, String duns, String comname, String companyweb, String yesrEs, String street, String city, String zip, String phone, String ext) {
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

		//click on all resgistration 
		
		ClickActionOfAllMenu clickmenu = new ClickActionOfAllMenu(driver);
		clickmenu.clickonRegistration();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		clickmenu.clickonNewregistration();


		SignUpforSupplierRegistrationPortal su = new SignUpforSupplierRegistrationPortal(driver);
		su.enterfname(FName);
		su.enterlname(LName);
		su.enteremail(mail);
		su.selcthearaboutus();
		su.selectcounty();
		su.enterEIN(ein);
		su.enterDUNS(duns);
		su.entercompanyname(comname);
		su.entercompanysite(companyweb);
		su.entertyear(yesrEs);
		su.selectState();
		su.entertAdd(street);
		su.entertcity(city);
		su.entertpostalcode(zip);
		su.entertphonenumber(phone);
		su.enterExt(ext);
		//submit
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
		driver.findElement(By.cssSelector(".recaptcha-checkbox-border")).click();

		driver.switchTo().defaultContent();
		su.ClickOnSubmit();

	}


}
