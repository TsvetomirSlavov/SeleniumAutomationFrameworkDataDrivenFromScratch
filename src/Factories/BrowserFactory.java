package Factories;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import DataProvider.RunConfigurationReader;
import org.openqa.selenium.phantomjs.*;


/*
 * This class has the following responsibilities
 * - To create required WebDriver
 * - To maintain an instance of a WebDriver
 * - SET THE DESIRED CAPABILITIES FOR EACH DRIVER, WAITS AND MORE READING FROM THE PROPERTIES FILE WITH RUNCONFIGURATIONREADER
 */
public class BrowserFactory {

	private static WebDriver driver;
	
	
	//RunManager is expected to call this method, and we overload so a test can call it without giving a parameter, just needing the instance
	public static WebDriver getBrowser(String browserName) throws IOException{
		if(driver == null){
			if(browserName.equals("Firefox")){
				//Must have solution like for Chrome with variable for path reference
				//System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
				//THE PROPER WAY
				System.setProperty("webdriver.chrome.driver", System.getProperty("webdriver.firefox.driver", DataProviderFactory.getRunConfigDataProvider().getFirefoxServerPath()));
				driver = new FirefoxDriver();
				//RunConfigurationReader runConfigReader = new RunConfigurationReader("framework.properties");
				// runConfigReader.getImplicitWait();
				//NO NEED TO create an instance because DataProviderFactory can statically access the methods this is the point of the Factory class				
			}
			//Not working properly
			else if(browserName.equals("InternetExplorer")){
				//DataProviderFactory.getRunConfigDataProvider().getIEServerPath()
				System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
				driver = new InternetExplorerDriver();				
			}
			//THE NEW CHROMEDRIVER.EXE IS NOT WORKING GOOD, USE THE OLD ONE!!!!
			//This was missed to reference to a RunConfigurationReader object calling the method to find the Chrome Server path in the property file
			else if(browserName.equals("Chrome")){
				RunConfigurationReader runConfigReader = new RunConfigurationReader("framework.properties");
				String driverLocation1 = runConfigReader.getChromeServerPath();
				System.out.println("LOOK HERE FOR THE ERROR: " + driverLocation1);
				//DataProviderFactory.getRunConfigDataProvider().getChomeServerPath()
				//"C:\\developer\\SeleniumDrivers\\chromedriver.exe"
				//driverLocation1
				//Issue 1: setProperty does not accept a String object, but only a String otherwise it prepends the canonical path of the project
				//It actually does that: System.setProperties("wedriver.chrome.driver",System.getProperty("user.dir")+//chomedrive//chromedriver.exe)
				//Solution: Just copy the exe files in a directory in the projet folder and reference to it     System.setProperty("webdriver.chrome.driver", emptyString + "chromedriver.exe");
				//"C:\\developer\\SeleniumDrivers\\chromedriver.exe"
				//System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); the exe file is in the root project directory 
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				//THE PROPER WAY does not work for Chrome again the concatenated String, but if wors for Firefox geckodriver.exe path
				//System.setProperty("webdriver.chrome.driver", System.getProperty("webdriver.chrome.driver", DataProviderFactory.getRunConfigDataProvider().getChromeServerPath()));
				driver = new ChromeDriver();				
			}
			//Not working properly
			else if(browserName.equals("Opera")){
				//DataProviderFactory.getRunConfigDataProvider().getIEServerPath()
				System.setProperty("webdriver.opera.driver", "operadriver.exe");
				//THE PROPER WAY
				//System.setProperty("webdriver.chrome.driver", System.getProperty("webdriver.chrome.driver", DataProviderFactory.getRunConfigDataProvider().getOperaServerPath()));
				driver = new OperaDriver();				
			}			
			//NOT working properly even with selenium server runnung as standalone
			else if(browserName.equals("Edge")){
				File file = new File("C:\\Program Files (x86)\\Microsoft Web Driver\\MicrosoftWebDriver.exe");
				System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
				driver = new EdgeDriver();
			}			
			else if(browserName.equals("PhantomJS")){
        	        File file = new File("C:\\developer\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");				
                    System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
				driver = new PhantomJSDriver();
			}
			
			
			
			
			else if(browserName.equals("Safari")){
				driver = new SafariDriver();
			}
			else if(browserName.equals("HTMLUnit")){
				//driver = new HtmlUnitDriver();
			}
			else if(browserName.equals("jBrowserDriver")){
				driver = new SafariDriver();
			}						
			
			long pageLoadTimeOut = DataProviderFactory.getRunConfigDataProvider().getPageLoadTimeou();
			long implicitWait = DataProviderFactory.getRunConfigDataProvider().getImplicitWait();
			driver.manage().timeouts().implicitlyWait(implicitWait ,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOut, TimeUnit.SECONDS);			
			driver.manage().deleteAllCookies();
		}
		return driver;
	}
	
	//Tests are supposed to call this method
	public static WebDriver getBrowser(){
		return driver;
	}
	
	public static void closeWebDriver(){
		driver.close();
		driver.quit();
		//there is still an object and the condition when creating a new driver is not met to be null so a fix is
		driver = null;
	}
	
	
	
	
	
}

/*
*Fix for IE maybe will work switching to another window and then back
*  
*   public WebDriver driver, driver1;
    System.setProperty("webdriver.ie.driver", System.getProperty(
                    "webdriver.ie.driver", "./BrowserDrivers/IEDriverServer.exe"));
            driver = new InternetExplorerDriver(cap);
            this.driver.manage().deleteAllCookies();
            this.driver.manage().timeouts().implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG, TimeUnit.SECONDS);

            this.driver.get("yourApplication.com");
            this.driver.manage().window().maximize();

public WebDriver driver, driver1;
System.setProperty("webdriver.ie.driver", System.getProperty(
                "webdriver.ie.driver", "./BrowserDrivers/IEDriverServer.exe"));
        driver1 = new InternetExplorerDriver(cap);
        this.driver1.manage().deleteAllCookies();

        this.driver1.get("http://www.google.com");
        this.driver1.manage().window().maximize();
*
*/