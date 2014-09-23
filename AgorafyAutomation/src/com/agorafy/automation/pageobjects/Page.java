package com.agorafy.automation.pageobjects;

import org.openqa.selenium.WebDriver;

import com.agorafy.automation.automationframework.Configuration;

public class Page 
{
    public static WebDriver driver;

    public Page(WebDriver driver)
    {
        Page.driver = driver;
    }

    protected String applicationUrl()
    {
        return Configuration.getConfigurationValueForProperty("applicationURL");
    }
}
