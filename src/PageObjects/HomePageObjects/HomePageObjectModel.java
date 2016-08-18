package PageObjects.HomePageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageObjectModel {
	
	@FindBy(how = How.CLASS_NAME, using = "account_icon")
	private WebElement myAccountLink;
	
	public boolean isMyAccountClickable(){
		if(myAccountLink.isEnabled()){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	
}
