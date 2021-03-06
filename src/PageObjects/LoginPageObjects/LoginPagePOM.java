package PageObjects.LoginPageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Factories.ReporterFactory;

public class LoginPagePOM {
	
	@FindBy(id = "log")
	private WebElement userNameEditBox;
	
	@FindBy(id = "pwd")
	private WebElement passwordEditBox;
	
	@FindBy(id = "login")
	private WebElement loginButton;
	
	
	//Behaviours
	
	public boolean isUsernameBoxVisible(){
		if(userNameEditBox.isDisplayed()){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isUsenameBoxEnabled(){
		if (userNameEditBox.isEnabled()){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	
	public void setUserName(String userName) throws IOException{
		//First check that the username edit box is visible and enabled
		//Perform a sendkeys to set the username
		if(isUsernameBoxVisible() && isUsenameBoxEnabled()){
			userNameEditBox.sendKeys(userName);
			ReporterFactory.getReporter().log("Successfully set user name " + userName);
		}
		else{
			//basically log an error
		}
	}
	
	public boolean isPasswordBoxEnabled(){
		if(passwordEditBox.isEnabled()){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isPasswordBoxVisible(){
		if(passwordEditBox.isDisplayed()){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void setPassword(String password) throws IOException{
		//First check that the password edit box is visible and enabled
		//Perform a sendkeys to set the password
		if(isPasswordBoxEnabled() && isPasswordBoxVisible()){
			passwordEditBox.sendKeys(password);
			ReporterFactory.getReporter().log("Successfully set user name " + password);
		}
		else{
			//basically log an error
		}
	}
	
	public void clickLogin(){
		if(loginButton.isDisplayed() && loginButton.isEnabled()){
		loginButton.click();
		}
	}
	
	

}
