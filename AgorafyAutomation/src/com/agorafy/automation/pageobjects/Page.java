package com.agorafy.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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

    public static Header header()
    {
        return PageFactory.initElements(driver, Header.class);
    }
}
