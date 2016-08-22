package TestRunner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

import Factories.DataProviderFactory;

public class RunManager {

	public static void main(String[] args) {
		
		//TestNG provides a test runner class with name TestNG
		TestNG testRunner = new TestNG();		
		//List<String> suites	= new ArrayList<String>();
		
		//Add textXML suites
		List<String> suites = DataProviderFactory.getRunConfigDataProvider().getRunXmls();		
		//hard coded suites that we need to pick up programatically - loosely coupled
		//Solution: specify/identify them in the framefork.properties file 
		//suites.add("TestRunXmls\\P1TestRun.xml");
		//suites.add("TestRunXmls\\P2TestRun.xml");			
		testRunner.setTestSuites(suites);
		testRunner.run();
		
		
		
		
	}

}
