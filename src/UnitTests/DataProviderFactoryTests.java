package UnitTests;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import DataProvider.RunConfigurationReader;
import DataProvider.TestDataProviderExcel;

import Factories.DataProviderFactory;

public class DataProviderFactoryTests {
	
	@Test
	public void dataProviderInitTests() throws IOException{		
		RunConfigurationReader runReader = DataProviderFactory.getRunConfigDataProvider();
		Assert.assertTrue(runReader != null, "DataProvider factory returned null for a Run config provider");
		
		TestDataProviderExcel testDataProvider = DataProviderFactory.getTestDataProvider();
		Assert.assertTrue(testDataProvider != null, "DataProvider factory returned null for Test data provider");
	}
	
	@Test
	public void dataProviderInstaceTest() throws IOException{		
		RunConfigurationReader runReader1 = DataProviderFactory.getRunConfigDataProvider();
		RunConfigurationReader runReader2 = DataProviderFactory.getRunConfigDataProvider();
		Assert.assertTrue(runReader1.equals(runReader2), "DataProvider factory returned different instances of Run config provider");
		
		TestDataProviderExcel testDataProvider1 = DataProviderFactory.getTestDataProvider();
		TestDataProviderExcel testDataProvider2 = DataProviderFactory.getTestDataProvider();
		Assert.assertTrue(testDataProvider1.equals(testDataProvider2), "DataProvider factory returned different instances for Test data provider");
	}
	
	
	
	
	
}