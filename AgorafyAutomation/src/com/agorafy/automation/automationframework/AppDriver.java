package com.agorafy.automation.automationframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AppDriver 
{
    public static WebDriver getDriver(){
    	WebDriver driver = new FirefoxDriver();
    	driver.manage().window().maximize();
    	driver.get("http://preview.agorafy.com");
        return driver;
    }
}
