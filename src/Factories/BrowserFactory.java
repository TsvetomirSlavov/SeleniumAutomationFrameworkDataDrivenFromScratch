package Factories;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import DataProvider.RunConfigurationReader;

/*
 * This class has the following responsibilities
 * - To create required WebDriver
 * - To maintain an instance of a WebDriver
 * - SET THE DESIRED CAPABILITIES FOR EACH DRIVER, WAITS AND MORE READING FROM THE PROPERTIES FILE WITH RUNCONFIGURATIONREADER
 */
public class BrowserFactory {

	private static WebDriver driver;
	//private static String emptyString = "";
	private static long implicitTime;
	
	
	public static WebDriver getBrowser(String browserName) throws IOException{
		if(driver == null){
			if(browserName.equals("Firefox")){
				//Must have solution like for Chrome with variable for path reference
				System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
				driver = new FirefoxDriver();
				RunConfigurationReader runConfigReader = new RunConfigurationReader("framework.properties");
				implicitTime = runConfigReader.getImplicitWait();
				driver.manage().timeouts().implicitlyWait(implicitTime ,TimeUnit.SECONDS);				
			}
			else if(browserName.equals("InternetExplorer")){
				RunConfigurationReader runConfigReader = new RunConfigurationReader("framework.properties");
				String internetExplorerPath = runConfigReader.getIEServerPath();
				System.setProperty("webdriver.ie.driver", internetExplorerPath);
				driver = new InternetExplorerDriver();
				RunConfigurationReader runConfigReader1 = new RunConfigurationReader("framework.properties");
				implicitTime = runConfigReader1.getImplicitWait();
				driver.manage().timeouts().implicitlyWait(implicitTime ,TimeUnit.SECONDS);	
			}
			//This was missed to reference to a RunConfigurationReader object calling the method to find the Chrome Server path in the property file
			else if(browserName.equals("Chrome")){
				RunConfigurationReader runConfigReader = new RunConfigurationReader("framework.properties");
				String driverLocation1 = runConfigReader.getChromeServerPath();
				System.out.println("LOOK HERE FOR THE ERROR: " + driverLocation1);
				//"C:\\developer\\SeleniumDrivers\\chromedriver.exe"
				//driverLocation1
				//Issue 1: setProperty does not accept a String object, but only a String otherwise it prepends the canonical path of the project
				//It actually does that: System.setProperties("wedriver.chrome.driver",System.getProperty("user.dir")+//chomedrive//chromedriver.exe)
				//Solution: Just copy the exe files in a directory in the projet folder and reference to it     System.setProperty("webdriver.chrome.driver", emptyString + "chromedriver.exe");
				//"C:\\developer\\SeleniumDrivers\\chromedriver.exe"
				//System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); the exe file is in the root project directory 
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver = new ChromeDriver();
				RunConfigurationReader runConfigReader2 = new RunConfigurationReader("framework.properties");
				implicitTime = runConfigReader2.getImplicitWait();
				driver.manage().timeouts().implicitlyWait(implicitTime ,TimeUnit.SECONDS);	
			}
			else if(browserName.equals("Safari")){
				driver = new SafariDriver();
			}
			else if(browserName.equals("Edge")){
				driver = new SafariDriver();
			}
			else if(browserName.equals("Opera")){
				driver = new SafariDriver();
			}
			else if(browserName.equals("Phantom")){
				driver = new SafariDriver();
			}
		}
		return driver;
	}
	
	public static void closeWebDriver(){
		driver.close();
		driver.quit();
	}
	
	
	
}
