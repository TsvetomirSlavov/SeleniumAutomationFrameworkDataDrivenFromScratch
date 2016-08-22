package Tests.HomePageTests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Factories.BrowserFactory;
import PageObjects.HomePageObjects.HomePagePOM;

public class HomePageTests {
	
	public String testCaseName = "HomePageTests";
	
	@Test(groups = "P1")
	public void verifyMyAccountLinkPresent() throws IOException{
		//Increment by one for each test
		String completeTestName = testCaseName + "001";
		WebDriver driver = BrowserFactory.getBrowser("Firefox");
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://store.demoqa.com");
		HomePagePOM homePage = PageFactory.initElements(driver, HomePagePOM.class);
		Assert.assertTrue(homePage.isMyAccountLinkClickable() && homePage.isMyAccountLinkDisplayed(), "The MYAcount link is not present or clickable");
		
	}
	
	@Test(groups = "P2")
	public void verifyLoginNavigation() throws IOException, InterruptedException{
		String completeTestName = testCaseName + "002";
		WebDriver driver = BrowserFactory.getBrowser("Firefox");
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://store.demoqa.com");
		HomePagePOM homePage = PageFactory.initElements(driver, HomePagePOM.class);
		homePage.clickMyAccountLink();
		//Here it started to break with a slower internet connection so I needed Wait
		Thread.sleep(5000);
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("http://store.demoqa.com/products-page/your-account/"), "Clicking on my account link takes to a wrong page");
		
	}
	
	
	

}
