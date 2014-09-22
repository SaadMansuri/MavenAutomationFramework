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
        //driver.get(Configuration.globalConfiguration().readConfigurationProperty("applicationURL"));
        //driver.get("http://preview.agorafy.com");
        driver.get("http://www.agorafy.com");
        return driver;
    }
}
