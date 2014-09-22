package com.agorafy.automation.pageobjects;

import org.openqa.selenium.WebDriver;

public class Page 
{
    public static WebDriver driver;

    public Page(WebDriver driver)
    {
        Page.driver = driver;
    }

}
