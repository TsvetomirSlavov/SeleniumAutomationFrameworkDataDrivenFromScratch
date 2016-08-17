package DataProvider;

import java.io.IOException;
import org.apache.poi.util.SystemOutLogger;

public class ProgramToTestTDPClass {

	public static void main(String[] args)
	{
		String filePath = "C:\\developer\\workspace\\FrameworkWebDriver\\TestData.xlsx";
		TestDataProviderExcel testData = null;
		try {
			testData = new TestDataProviderExcel(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("The username for the testcase001 is " + testData.getUsername("Test001"));
		System.out.println("The username for the testcase002 is " + testData.getUsername("Test002"));
		System.out.println("The username for the testcase003 is " + testData.getUsername("Test003"));
		
		System.out.println("The username for testcase003 is " + testData.getFirstName("Test003"));
		testData.closeTestDataSheet();
		
	}
	
	
	
	
	
}
