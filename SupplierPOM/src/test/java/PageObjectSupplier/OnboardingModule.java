package PageObjectSupplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OnboardingModule {

	
	WebDriver ldriver;
	public OnboardingModule(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);

	}
	
}
