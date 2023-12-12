package PageObjectAdmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickActionOfAllMenu {


	WebDriver ldriver;
	public ClickActionOfAllMenu(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);

	}
	
	//identify web elements 
	//Dashboard
	@FindBy(xpath =  "Username") WebElement Dashboard;
	//MasterManagement
	@FindBy(xpath  = "//span[contains(text(),'Master Management')]") WebElement MasterManagement;
	//Labourcategory
	@FindBy(xpath  = "//span[contains(text(),'Labor Category')]") WebElement Labourcategory;
	//RegistrationVerification
	@FindBy(xpath  = "Password") WebElement RegistrationVerification;
	//UnverifiedRegistrationlist
	@FindBy(xpath  = "Password") WebElement UnverifiedRegistrationlist;
	//Registration
	@FindBy(xpath  = "//body[1]/div[1]/aside[1]/section[1]/ul[1]/li[5]/a[1]/span[1]") WebElement Registration;
	//Allresgiatration
	@FindBy(xpath  = "Password") WebElement Allresgiatration;
	//Newregistration
	@FindBy(xpath  = "//span[contains(text(),'New Registration')]") WebElement Newregistration;
	//Migration
	@FindBy(xpath  = "Password") WebElement Migration;
	//Usermanagement
	@FindBy(xpath  = "Password") WebElement Usermanagement;
	//AddUser
	@FindBy(xpath  = "Password") WebElement AddUser;
	//SystemConfiguration
	@FindBy(xpath  = "Password") WebElement SystemConfiguration;
	//Emailconfiguration
	@FindBy(xpath  = "Password") WebElement Emailconfiguration;
	//Documenttypeconfiguration
	@FindBy(xpath  = "Password") WebElement Documenttypeconfiguration;
	//Acroprogramconfiguration
	@FindBy(xpath  = "Password") WebElement Acroprogramconfiguration;
	//Masteronboardingchecklist
	@FindBy(xpath  = "Password") WebElement Masteronboardingchecklist;
	//Supplierlogin
	@FindBy(xpath  = "Password") WebElement Supplierlogin;
	//Supplierlogin1
	@FindBy(xpath  = "Password") WebElement Supplierlogin1;
	//Searchsuppliermassemail
	@FindBy(xpath  = "Password") WebElement Searchsuppliermassemail;
	//Reports
	@FindBy(xpath  = "Password") WebElement Reports;
	//Supplierreport
	@FindBy(xpath  = "Password") WebElement Supplierreport;
	//SupplierBycategory
	@FindBy(xpath  = "Password") WebElement SupplierBycategory;
	//suppliersupportlocation
	@FindBy(xpath  = "Password") WebElement suppliersupportlocation;
	//supplierlocationreport
	@FindBy(xpath  = "Password") WebElement supplierlocationreport;
	//supplierProgramreport
	@FindBy(xpath  = "Password") WebElement supplierProgramreport;
	//Logout
	@FindBy(xpath  = "Password") WebElement Logout;
	
	public void clickonDashboard()
	{
	Dashboard.click();	
	}
	
	public void clickonMasterManagement()
	{
	MasterManagement.click();	
	}
	
	public void clickonLabourcategory()
	{
		Labourcategory.click();	
	}
	
	public void clickonRegistrationVerification()
	{
		RegistrationVerification.click();	
	}
	
	public void clickonRegistration()
	{
		Registration.click();	
	}
	
	public void clickonAllresgiatration()
	{
		Allresgiatration.click();	
	}
	
	
	public void clickonNewregistration()
	{
		Newregistration.click();	
	}
	
	public void clickonMigration()
	{
		Migration.click();	
	}
	
	public void clickonUsermanagement()
	{
		Usermanagement.click();	
	}
	
	public void clickonAddUser()
	{
		AddUser.click();	
	}
	
	public void clickonSystemConfiguration()
	{
		SystemConfiguration.click();	
	}
	
	public void clickonSystemEmailconfiguration()
	{
		Emailconfiguration.click();	
	}
	
	public void clickonSystemDocumenttypeconfiguration()
	{
		Documenttypeconfiguration.click();	
	}
	
	public void clickonAcroprogramconfiguration()
	{
		Acroprogramconfiguration.click();	
	}
	
	public void clickonMasteronboardingchecklist()
	{
		Masteronboardingchecklist.click();	
	}
	
	public void clickonSupplierlogin()
	{
		Supplierlogin.click();	
	}
	
	public void clickonSupplierlogin1()
	{
		Supplierlogin1.click();	
	}
	
	public void clickonSearchsuppliermassemail()
	{
		Searchsuppliermassemail.click();	
	}
	
	public void clickonReports()
	{
		Reports.click();	
	}
	
	public void clickonSupplierreport()
	{
		Supplierreport.click();	
	}
	
	public void clickonSupplierBycategory()
	{
		SupplierBycategory.click();	
	}
	
	public void clickonsuppliersupportlocation()
	{
		suppliersupportlocation.click();	
	}
	
	public void clickonsupplierlocationreport()
	{
		supplierlocationreport.click();	
	}
	
	public void clickonsupplierProgramreport()
	{
		supplierProgramreport.click();	
	}
	
	public void clickonLogout()
	{
		Logout.click();	
	}
}
