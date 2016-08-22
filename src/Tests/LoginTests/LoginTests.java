package Tests.LoginTests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Factories.BrowserFactory;
import Factories.DataProviderFactory;
import PageObjects.HomePageObjects.HomePagePOM;
import PageObjects.LoginPageObjects.LoginPagePOM;

public class LoginTests {
	
	//In order to connect to excel data sheet
	public String testCaseName = "LoginTest";
	
	//In some projects you might want to run only the Sanity scenarios P1, 
	//and you do not care about P2 Priority scenarios, 
	//you achieve that with a testng.xml file 
	//OR sometimes you want to run the complete test suite which has P1, P2, P3 scenarios
	//@Test(groups ={"Sanity", "Production"}) just a way to name groups
	@Test(groups = "P1")//P1 Priority - this scenarion falls under P1 Priority
	public void invalidLogin() throws IOException{
		//Increment by one for each test
		//completeTestName loval variable matches the required parameter for the methods get of DataProviderReaderFactory class which we create a String object
		String completeTestName = testCaseName + "001";
		WebDriver driver = BrowserFactory.getBrowser("Firefox");
		//declaring implicit wait     		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://store.demoqa.com");
		HomePagePOM homePage = PageFactory.initElements(driver, HomePagePOM.class);
		homePage.clickMyAccountLink();
		LoginPagePOM loginPage = PageFactory.initElements(driver, LoginPagePOM.class);		
		//Fetch Data
		String userName = DataProviderFactory.getTestDataProvider().getUsername(completeTestName);		
		loginPage.setUserName(userName);
		//Fetch Data
		String password = DataProviderFactory.getTestDataProvider().getPassword(completeTestName);
		loginPage.setPassword(password);
		loginPage.clickLogin();
		Assert.assertTrue(loginPage.isUsernameBoxVisible() && loginPage.isUsenameBoxEnabled(), "Login button is not present that means that we logged in using invalid login credentials");
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
