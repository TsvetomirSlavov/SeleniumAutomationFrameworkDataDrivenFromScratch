package UnitTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import DataProvider.RunConfigurationReader;
import Factories.BrowserFactory;
import Factories.DataProviderReaderFactory;

public class DataProviderFactoryTests {
	
	@Test
	public void dataProviderInitTests{
		RunConfigurationReader runReader = DataProviderReaderFactory.getRunConfigDataProvider();
		Assert.assertTrue(driver != null, "DataProvider factory returned null for a Run config provider");
		
	}
	
	

}
