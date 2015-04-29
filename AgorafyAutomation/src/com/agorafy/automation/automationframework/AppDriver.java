package com.agorafy.automation.automationframework;
import java.util.logging.Level;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppDriver 
{
    public static WebDriver getDriver(String browserType)
    {
    	DesiredCapabilities capabilities = new DesiredCapabilities();
    	capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\phantomjs-2.0.0-windows\\bin\\phantomjs.exe");
    	
    	//driver.setLogLevel(Level.INFO.OFF);
    	
    	String[] phantomArgs = new  String[] {"--webdriver-loglevel=NONE"};
    	capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
    	PhantomJSDriver driver = new PhantomJSDriver(capabilities);
    	
        //Get browser driver based on browser type specified.
        //WebDriver driver = new FirefoxDriver();
        /*System.setProperty("webdriver.chrome.driver", "src\\lib\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();*/
        driver.manage().window().maximize();
        
        driver.get(Configuration.applicationUnderTestURL());
        return driver;
    }

    public static void clearBrowserContext(WebDriver driver)
    {
        if (driver != null)
        {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
}
