package com.agorafy.automation.automationframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
            //driver.close();
        }
    }
}
