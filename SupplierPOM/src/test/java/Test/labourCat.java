package Test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Listeners;

import PageObjectAdmin.Login;
import Utilities.Excellogindata;
import Utilities.ExtentListeners;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(ExtentListeners.class)
public class labourCat {

	
	@org.testng.annotations.Test(dataProvider = "logindata", dataProviderClass = Excellogindata.class)
	public void  addlabourcat(String url,String usern, String pass) {
		
		WebDriver driver= new EdgeDriver();
		WebDriverManager.edgedriver().setup();
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		Login la = new Login(driver);
		la.enterusernaem(usern);
		la.enterpwd(pass);
		la.clickbutton();
		
		
		
	}
	
	
	
}
