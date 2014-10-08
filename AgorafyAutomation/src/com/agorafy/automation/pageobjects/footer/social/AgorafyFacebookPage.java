package com.agorafy.automation.pageobjects.footer.social;

import org.openqa.selenium.WebDriver;

import com.agorafy.automation.pageobjects.Page;

public class AgorafyFacebookPage extends Page
{
    public AgorafyFacebookPage(WebDriver driver)
    {
        super(driver);
    }

    public String agorafyFacebookPageUrl()
    {
        return "https://www.facebook.com/agorafy";
    }
}