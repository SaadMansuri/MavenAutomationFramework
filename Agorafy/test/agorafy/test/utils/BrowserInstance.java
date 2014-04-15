/*
 * @author : Chandrani
 * This class creates an instance of web driver which is required for running the browser
 * Parameter passed to the method is the browser name and return type is the web driver instance
 */

package agorafy.test.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class BrowserInstance {
    static WebDriver d;
    static EventFiringWebDriver driver;
    
    public static EventFiringWebDriver BrowserInstance(String browser)
    {
        switch(browser.toLowerCase())
        {
            case "firefox" :
                d = new FirefoxDriver();
                break;
                
            case "chrome":
                d = new ChromeDriver();
                break;
                
            case "ie":
                d = new InternetExplorerDriver();
                break;
                
            case "internet explorer":
                d = new InternetExplorerDriver();
                break;
        }
        
        driver = new EventFiringWebDriver(d);
            
        return driver;
        
    }
    
}
