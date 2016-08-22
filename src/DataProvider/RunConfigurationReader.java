package DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.util.Strings;

/*
 * Purpose: This class helps us read the framework.properties file
 * And it will help us get the data from the mentioned file
 */
public class RunConfigurationReader {
	
	Properties propertyFile;
	String fileName;
	
	public RunConfigurationReader(String propertyFilePath) throws IOException
	{
		this.fileName = propertyFilePath;
		BufferedReader reader = new BufferedReader(new FileReader(fileName)); 
		propertyFile = new Properties();
		propertyFile.load(reader);
		reader.close();
	}
	
	public List<String> getBrowsers()
	{
		String browserNames = propertyFile.getProperty("browserType");
		String[] browserArray = browserNames.split(",");
		List<String> browserList = new ArrayList<String>();		
		for(int i = 0; i < browserArray.length; i++)
		{
			browserList.add(browserArray[i]);
		}
		return browserList;
	}

	public long getPageLoadTimeou()
	{
		String pageLoadTime = propertyFile.getProperty("pageLoadTimeout");
		return Long.parseLong(pageLoadTime);
	}
	
	public long getImplicitWait()
	{
		String ImplicitWait = propertyFile.getProperty("implicitWait");
		return Long.parseLong(ImplicitWait);
	}
	
	public boolean getScreenShotOnFailure()
	{
		return Boolean.parseBoolean(propertyFile.getProperty("screenShotOnFailure"));
	}
	
	public boolean getHighlightElements()
	{
		return Boolean.parseBoolean(propertyFile.getProperty("screenShotOnFailure"));
	}
	
	public String getIEServerPath()
	{
		return propertyFile.getProperty("IEServerPath");
	}
	
	public String getChromeServerPath()
	{
		return propertyFile.getProperty("ChromeServerPath");
	}
	
	public List<String> getRunXmls(){
		String runXMLs = propertyFile.getProperty("runXMLs");
		List<String> listOfRunXmls = new ArrayList<String>();
		for(String runXML : runXMLs.split(",")){
			//One way to solve it to find properly the xml files path or directly in the properties file
			listOfRunXmls.add("TestRunXmls\\" + runXML);
		}
		return listOfRunXmls;
	}
	
	
	
}
