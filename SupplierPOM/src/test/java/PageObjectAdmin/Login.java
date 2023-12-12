package PageObjectAdmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class Login {

	
	WebDriver ldriver;
	public Login(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);

	}
	
	//identify web elements 
	@FindBy(id = "Username") WebElement username;
	@FindBy(id = "Password") WebElement password;
	@FindBy(id = "btnLogin") WebElement loginbtn;
	@FindBy(linkText = "chkText")  WebElement rememberme;
	@FindBy(linkText = "Forgot Password?") WebElement forgetpwd;

	//@Test(dataProvider = "logindata", dataProviderClass = Excellogindata.class)
	public void enterusernaem (String usern ) {
		
		username.sendKeys(usern);
		
	}

	public void enterpwd(String pwd) {
		
		password.sendKeys(pwd);
	}


	public void clickbutton() {
		
		loginbtn.click();
	}

	public void rememberme()
	{

		rememberme.click();
	}


	public void forgetpasswrd()
	{
	forgetpwd.click();	
	}

	
}
