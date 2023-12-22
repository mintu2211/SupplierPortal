package PageObjectSupplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UpdateProfile {

	
	WebDriver ldriver;
	public UpdateProfile(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);

	}
	
}
