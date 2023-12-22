package PageObjectSupplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SupplierLogin {

	WebDriver ldriver;
	public SupplierLogin(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);

	}
	
}
