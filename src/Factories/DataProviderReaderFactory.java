package Factories;

import java.io.IOException;

import DataProvider.RunConfigurationReader;
import DataProvider.TestDataProviderExcel;

/*
 * The purpose of this class is to
 * - Create run configuration reader
 * - Maintain an instance of the reader so that single reader can be used across tets/framework
 */
public class DataProviderReaderFactory {

	private static RunConfigurationReader runDataProvider = null;
	private static TestDataProviderExcel testDataProvider = null;
	private static String runConfigFilePath = "framework.properties";
	private static String testDataFilePath = "TestData.xlsx";
	
	public static RunConfigurationReader getRunConfigDataProvider(){
		if(runDataProvider == null){
			try {
				runDataProvider = new RunConfigurationReader(runConfigFilePath);
			} catch (IOException e) {
				System.out.println("Not able to create config reader " + e.getMessage());
			}
		}
		
		return runDataProvider;
	}
	
	
	public static TestDataProviderExcel getTestDataProvider(){
		if(testDataProvider == null){
			try {
				testDataProvider = new TestDataProviderExcel(testDataFilePath);
			} catch (IOException e) {
				System.out.println("Not able to create Test data provider " + e.getMessage());
			}
		}
		
		return testDataProvider;
	}
	
	
}
