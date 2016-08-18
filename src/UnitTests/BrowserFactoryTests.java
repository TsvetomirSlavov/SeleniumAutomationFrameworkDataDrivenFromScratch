package UnitTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Factories.BrowserFactory;

public class BrowserFactoryTests {
	
	@Test
	public void browserFactoryInitTest(){
		WebDriver driver = BrowserFactory.getBrowser("Firefox");
		
		Assert.assertTrue(driver != null, "Browserfactory returned a null webdriver");
	}
	
	@Test
	public void browserFactoryWebDriverInstanceTest(){
		WebDriver driver1 = BrowserFactory.getBrowser("InternetExplorer");
		WebDriver driver2 = BrowserFactory.getBrowser("InternetExplorer");
		Assert.assertTrue(driver1.equals(driver2), "Two webdrivers returned are not the same");
	}

}
