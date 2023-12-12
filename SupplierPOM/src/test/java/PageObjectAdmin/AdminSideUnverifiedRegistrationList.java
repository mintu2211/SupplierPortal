package PageObjectAdmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminSideUnverifiedRegistrationList {
	
	WebDriver ldriver;
	public AdminSideUnverifiedRegistrationList(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);

	}
	
	
	//identify web elements 
		@FindBy(xpath = "//table[@id='example1']//tr[2]//td[1]") WebElement table;
		@FindBy(xpath = "//body[1]/div[1]/div[1]/section[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/button[1]") WebElement viewbutton;
		@FindBy(xpath = "//tbody/tr[1]/td[1]/button[2]") WebElement verification;
		
	

}
