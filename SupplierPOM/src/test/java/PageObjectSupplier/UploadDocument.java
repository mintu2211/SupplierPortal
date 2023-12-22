package PageObjectSupplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UploadDocument {

	
	WebDriver ldriver;
	public UploadDocument(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);

	}
	
	
}
