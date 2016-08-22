package PageObjects.HomePageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePagePOM {
	
	@FindBy(how = How.CLASS_NAME, using = "account_icon")
	private WebElement myAccountLink;
	
	
	public boolean isMyAccountLinkClickable(){
		//Verify that my account is clickable
		if(myAccountLink.isEnabled()){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isMyAccountLinkDisplayed(){
		//Verify that my account is present on the homepage
		if(myAccountLink.isDisplayed()){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void clickMyAccountLink(){
		myAccountLink.click();
	}
	
	
	
	
}
