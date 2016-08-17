package UnitTests;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DataProvider.RunConfigurationReader;

/*
 * Unit Tests: Test to validate the RunConfigurationReaderClass
 * 
 */
public class RunConfigurationTests {
	
	private RunConfigurationReader runConfigReader = null;
	
	@BeforeClass
	public void setUp(){
		try {
			runConfigReader = new RunConfigurationReader("TestData\\frameworkTestData.properties");
		} catch (IOException e) {
			e.printStackTrace();
			Assert.assertEquals(false, " not able to open the configuration file. Stack trace is " + e.getStackTrace());
		}
	}
	
	@Test
	public void testPageLoadTimeout(){
		long pageLoadTimeout = runConfigReader.getPageLoadTimeou();
		Assert.assertEquals(pageLoadTimeout, 5000);
	}
	
	@Test
	public void testIEBrowserPath(){
		String iePath = runConfigReader.getIEServerPath();
		Assert.assertEquals(iePath, "C:\\developer\\SeleniumDrivers\\IEDriverServer.exe");
		
	}
	
	
	
	

}
