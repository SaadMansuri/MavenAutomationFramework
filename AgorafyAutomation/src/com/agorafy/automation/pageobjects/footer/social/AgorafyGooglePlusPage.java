package com.agorafy.automation.pageobjects.footer.social;

import org.openqa.selenium.WebDriver;

import com.agorafy.automation.pageobjects.Page;

public class AgorafyGooglePlusPage extends Page
{
    public AgorafyGooglePlusPage(WebDriver driver)
    {
        super(driver);
    }

    public String agorafyGooglePlusPageUrl()
    {
        return "https://plus.google.com/101471233098763801684/posts";
    }
}