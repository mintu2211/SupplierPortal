package PageObjectSupplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddEditSupplierUser {

	WebDriver ldriver;
	public AddEditSupplierUser(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);

	}
	
	
}
