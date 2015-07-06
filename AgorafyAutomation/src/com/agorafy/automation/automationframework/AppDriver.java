package com.agorafy.automation.automationframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppDriver 
{
    public static WebDriver getDriver(String browserType)
    {
        WebDriver driver=null;
        if(browserType.equalsIgnoreCase("MFF"))
        {
            FirefoxProfile pro=new FirefoxProfile();
            pro.setPreference("browser.downLoad.folderList", 0);
            pro.setPreference("browser.helperApps.neverAsk.saveToDisk", "Applications/zip");
            driver=new FirefoxDriver(pro);
        }
        else if(browserType.equalsIgnoreCase("GC"))
        {
            System.setProperty("webdriver.chrome.driver","./src\\lib\\chromedriver.exe");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("test-type");
            capabilities.setCapability("chrome.binary",".//src\\lib\\chromedriver.exe");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver(capabilities);
        }
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
