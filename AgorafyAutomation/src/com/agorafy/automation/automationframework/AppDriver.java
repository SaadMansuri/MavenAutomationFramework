package com.agorafy.automation.automationframework;


import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.agorafy.automation.utilities.HandlingWindows;

public class AppDriver 
{
    public static WebDriver getDriver(String browserType)
    {
        // TODO: Get browser driver based on browser type specified.
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(Configuration.applicationUnderTestURL());
        return driver;
    }

    public static void clearBrowserContext(WebDriver driver)
    {
        if (driver != null)
        {
            driver.manage().deleteAllCookies();
            HashMap<Integer, String> allWindowHandles = HandlingWindows.allWindowhandles(driver);
            /* This condition checks whether multiple windows are present, if present then all windows will be closed using for each loop*/
            if(allWindowHandles.size() > 1)
            {
                Iterable<String> allWindowHandlesList = allWindowHandles.values();
                for(String singleWindow : allWindowHandlesList)
                {
                    driver.switchTo().window(singleWindow);
                    driver.close();
                }
            }
            /*If only window is opened then following code will be executed*/
            else
            {
                driver.close();
            }
        }
    }
}
