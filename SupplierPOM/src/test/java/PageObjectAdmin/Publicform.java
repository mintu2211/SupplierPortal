package PageObjectAdmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Publicform {


	WebDriver ldriver;
	public Publicform(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);

	}

	//public form locaters
	@FindBy(id = "Primary_Contact_First_Name")
	WebElement firstname;

	@FindBy(id = "Primary_Contact_Last_Name")
	WebElement lastname;

	@FindBy(id = "Primary_Contact_Email")
	WebElement email;

	@FindBy(id = "Hear_about_us")
	WebElement hearAboutus;


	@FindBy(id = "Country_HQ")
	WebElement country;

	@FindBy(id = "Primary_TaxID")
	WebElement SEIN;


	@FindBy(id = "DUNS_Number")
	WebElement SDUNS;

	@FindBy(id = "Company_Name")
	WebElement companyname;

	@FindBy(id = "Company_Website")
	WebElement website;


	@FindBy(id = "Year_Established")
	WebElement yearofestablishment;

	@FindBy(id = "StateDropDown")
	WebElement SupplieState;

	@FindBy(id = "Address1")
	WebElement Address;

	@FindBy(id = "City_HQ")
	WebElement city;

	@FindBy(id = "Postal_Code_HQ")
	WebElement postalcode;


	@FindBy(id = "phonePhoneNumber")
	WebElement phonenumber;

	@FindBy(id = "phoneExt")
	WebElement EXT;

	@FindBy(id = "btnSubmit")
	WebElement submitbutton;



	public void enterfname(String fname) {

		firstname.sendKeys(fname);

	}

	public void enterlname(String lname) {

		lastname.sendKeys(lname);

	}


	public void enteremail(String mail) {

		email.sendKeys(mail);

	}



	public void selcthearaboutus () {

		Select hau = new Select(hearAboutus);
		hau.selectByIndex(2);


	}
	
	public void selectcounty () {

		Select hau = new Select(country);
		hau.selectByIndex(1);


	}

	public void enterEIN(String EIN) {

		SEIN.sendKeys(EIN);

	}
	public void enterDUNS(String DUNS) {

		SDUNS.sendKeys(DUNS);

	}

	public void entercompanyname(String cname) {

		companyname.sendKeys(cname);

	}
	public void entercompanysite(String site) {

		website.sendKeys(site);

	}

	
	
	public void entertyear(String year) {

		yearofestablishment.sendKeys(year);

	}

	public void selectState () {

		Select hau = new Select(SupplieState);
		hau.selectByIndex(4);


	}
	

	
	public void entertAdd(String add) {

		Address.sendKeys(add);

	}
	
	
	public void entertcity(String City) {

		city.sendKeys(City);

	}

	

	public void entertpostalcode(String code) {

		postalcode.sendKeys(code);

	}
	

	
	
	
	public void entertphonenumber(String pnumber) {

		phonenumber.sendKeys(pnumber);

	}

	

	public void enterExt(String phoneext) {

		EXT.sendKeys(phoneext);

	}
	


	public void ClickOnSubmit() {

		submitbutton.click();

	}
	




}
