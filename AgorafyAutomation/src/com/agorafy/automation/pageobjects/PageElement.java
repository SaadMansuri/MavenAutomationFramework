package com.agorafy.automation.pageobjects;

import org.openqa.selenium.WebDriver;

import com.agorafy.automation.automationframework.AppDriver;

public class PageElement 
{
    public static WebDriver driver;
    public static boolean bResult;
    public PageElement(WebDriver driver)
    {
        PageElement.driver = driver;
    }

}
