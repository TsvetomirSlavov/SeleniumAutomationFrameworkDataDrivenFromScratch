package PageObjects.HomePageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Factories.ReporterFactory;

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
	
	public boolean isMyAccountLinkDisplayed() throws IOException{
		//Verify that my account is present on the homepage
		if(myAccountLink.isDisplayed()){
			ReporterFactory.getReporter().log("My Account link is displayed");
			return true;
		}
		else{
			ReporterFactory.getReporter().log("My Account link is not");
			return false;
		}
	}
	
	public void clickMyAccountLink() throws IOException{
		myAccountLink.click();
		ReporterFactory.getReporter().log("Successfully clicked My Account link");
	}
	
	
	
	
}
