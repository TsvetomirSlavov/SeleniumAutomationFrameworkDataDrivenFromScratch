package Factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

/*
 * This class has the following responsibilities
 * - To create required WebDriver
 * - To maintain an instance of a WebDriver
 */
public class BrowserFactory {

	private static WebDriver driver;
	
	public static WebDriver getBrowser(String browserName){
		if(driver == null){
			if(browserName.equals("Firefox")){
				driver = new FirefoxDriver();
			}
			else if(browserName.equals("InternetExplorer")){
				driver = new InternetExplorerDriver();
			}
			else if(browserName.equals("Chrome")){
				driver = new ChromeDriver();
			}
			else if(browserName.equals("Safari")){
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
