package TestRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

import Factories.BrowserFactory;
import Factories.DataProviderFactory;
import Factories.ReporterFactory;
import TestNGListeners.SuiteListener;
import TestNGListeners.TestListener;

public class RunManager {

	public static void main(String[] args) throws IOException {
		
		List<String> browserList = DataProviderFactory.getRunConfigDataProvider().getBrowsers();
		List<String> suites = DataProviderFactory.getRunConfigDataProvider().getRunXmls();
		TestNG testRunner = new TestNG();
		SuiteListener suiteListener = new SuiteListener();
		TestListener testListener = new TestListener();
		testRunner.addListener(suiteListener);
		testRunner.addListener(testListener);
		//TestNG provides a test runner class with name TestNG		
		for(String browser : browserList){
			ReporterFactory.getReporter().log("Starting tests with browser " + browser);
			BrowserFactory.getBrowser(browser);
						
			testRunner.setTestSuites(suites);
			testRunner.run();
			BrowserFactory.closeWebDriver();
			ReporterFactory.getReporter().log("Stopping tests with browser " + browser);
		}
		ReporterFactory.getReporter().stopLogging();
 		//List<String> suites	= new ArrayList<String>();		
		//Add textXML suites				
		//hard coded suites that we need to pick up programatically - loosely coupled
		//Solution: specify/identify them in the framefork.properties file 
		//suites.add("TestRunXmls\\P1TestRun.xml");
		//suites.add("TestRunXmls\\P2TestRun.xml");			
		
		
		
		
		
	}

}
