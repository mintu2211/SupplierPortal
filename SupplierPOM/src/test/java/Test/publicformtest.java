package Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import PageObjectAdmin.Publicform;
import Utilities.Exceldataprovider;
import io.github.bonigarcia.wdm.WebDriverManager;

public class publicformtest {

	@org.testng.annotations.Test(dataProvider = "supplierdata", dataProviderClass = Exceldataprovider.class)
	public void fillpublicform(String FName, String LName, String mail,String ein, String duns, String comname, String companyweb, String yesrEs, String street, String city, String zip, String phone, String ext) {
		WebDriver driver= new EdgeDriver();
		WebDriverManager.edgedriver().setup();
		//UAT
		//driver.get("http://172.16.0.21/SupplierPortal_QA/profile/mysupplierprofile");
		driver.get("http://172.16.0.21/SupplierPortal_QA/profile/mysupplierprofile");
		//QA
		//driver.get("http://172.16.0.21/SupplierPortal_QA/profile/mysupplierprofile/");
		driver.manage().window().maximize();

		Publicform pf = new Publicform(driver);
		pf.enterfname(FName);
		pf.enterlname(LName);
		pf.enteremail(mail);
		pf.selcthearaboutus();
		pf.selectcounty();
		pf.enterEIN(ein);
		pf.enterDUNS(duns);
		pf.entercompanyname(comname);
		pf.entercompanysite(companyweb);
		pf.entertyear(yesrEs);
		pf.selectState();
		pf.entertAdd(street);
		pf.entertcity(city);
		pf.entertpostalcode(zip);
		pf.entertphonenumber(phone);
		pf.enterExt(ext);
		//submit
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
		driver.findElement(By.cssSelector(".recaptcha-checkbox-border")).click();

		driver.switchTo().defaultContent();
		pf.ClickOnSubmit();

	}


}
