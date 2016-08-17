package UnitTests;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DataProvider.TestDataProviderExcel;

public class TestDataProviderTests {

	private TestDataProviderExcel testDataReader = null;
	
	@BeforeClass
	public void setUp(){
		try {
			testDataReader = new TestDataProviderExcel("C:\\developer\\workspace\\FrameworkWebDriver\\src\\UnitTests\\TestData.xlsx");
		} catch (IOException e) {
			Assert.assertEquals(false, " not able to open the TestData file. Stack trace is " + e.getStackTrace());
		}
	}
	
	@Test
	public void testUserName(){
		String userName = testDataReader.getUsername("Test001");
		Assert.assertEquals(userName, "username1");
	}
	
	@Test
	public void testProductID(){
		String productID = testDataReader.getProductID("Test001");
		//I made every numeric cell to be formatted to a String with DataFormatter
		Assert.assertEquals(productID, "1234");
	}
	
	
}
