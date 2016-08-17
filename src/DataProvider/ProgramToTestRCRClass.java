package DataProvider;

import java.io.IOException;

public class ProgramToTestRCRClass {

	public static void main(String[] args) throws IOException {
		
		String propFile = "C:\\developer\\workspace\\FrameworkWebDriver\\framework.properties";
		RunConfigurationReader configReader = new RunConfigurationReader(propFile);
		System.out.println("The browser list is " + configReader.getBrowsers().toString());
	}

}
