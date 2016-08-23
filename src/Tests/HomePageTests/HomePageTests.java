package Tests.HomePageTests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Factories.BrowserFactory;
import Factories.ReporterFactory;
import PageObjects.HomePageObjects.HomePagePOM;

public class HomePageTests {
	
	public String testCaseName = "HomePageTests";
	
	@Test(groups = "P1")
	public void verifyMyAccountLinkPresent() throws IOException{
		//Increment by one for each test
		String completeTestName = testCaseName + "001";
		ReporterFactory.getReporter().startTest(completeTestName);
		//debug
		//System.out.println(completeTestName + " " + Thread.currentThread().getId());
		WebDriver driver = BrowserFactory.getBrowser();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://store.demoqa.com");
		ReporterFactory.getReporter().log("Successfully navigated to the page " + "http://store.demoqa.com");
		HomePagePOM homePage = PageFactory.initElements(driver, HomePagePOM.class);
		ReporterFactory.getReporter().log("Created home page factory");
		Assert.assertTrue(homePage.isMyAccountLinkClickable() && homePage.isMyAccountLinkDisplayed(), "The MYAcount link is not present or clickable");
		ReporterFactory.getReporter().log("Home page link is visible and clickable");
		ReporterFactory.getReporter().stopTest(completeTestName);
	}
	
	@Test(groups = "P2")
	public void verifyLoginNavigation() throws IOException, InterruptedException{
		String completeTestName = testCaseName + "002";
		ReporterFactory.getReporter().startTest(completeTestName);
		//debug
		//System.out.println(completeTestName + " " + Thread.currentThread().getId());
		WebDriver driver = BrowserFactory.getBrowser();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://store.demoqa.com");
		ReporterFactory.getReporter().log("Successfully navigated to the page " + "http://store.demoqa.com");
		HomePagePOM homePage = PageFactory.initElements(driver, HomePagePOM.class);
		ReporterFactory.getReporter().log("Created home page factory");
		homePage.clickMyAccountLink();
		ReporterFactory.getReporter().log("clicked on My Account link");
		//Here it started to break with a slower internet connection so I needed Wait
		Thread.sleep(5000);
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("http://store.demoqa.com/products-page/your-account/"), "Clicking on my account link takes to a wrong page");
		ReporterFactory.getReporter().log("Reached to the correct page after clicking on My Account link. Actual URL " + driver.getCurrentUrl());
		ReporterFactory.getReporter().stopTest(completeTestName);
	}
	
	
	

}
