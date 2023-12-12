package PageObjectAdmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminSideLaborCategory {

	WebDriver ldriver;
	public AdminSideLaborCategory(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);

	}

	//identify web elements 
	@FindBy(id = "LabourCategory") WebElement labourcategoryfield;
	@FindBy(id = "btnSave") WebElement Savebutton;
	@FindBy(id = "btnClear") WebElement Clearbutton;
	@FindBy(xpath = "//body/div[1]/div[1]/section[2]/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/label[1]/select[1]") 
	WebElement showentries;
	@FindBy(xpath = "//body/div[1]/div[1]/section[2]/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/label[1]/input[1]")
	WebElement search;

	public void enterlabourcategoryfield (String labcat ) {

		labourcategoryfield.sendKeys(labcat);

	}


	public void ClickonSave() {

		Savebutton.click();
	}

	public void Clickonclear() {

		Clearbutton.click();
	}




	public void enterinsearch(String searchtext) {

		search.sendKeys(searchtext);
	}

	public void selectshowentries () {

		Select selshowent = new Select(showentries);
		selshowent.selectByIndex(2);


	}


}
