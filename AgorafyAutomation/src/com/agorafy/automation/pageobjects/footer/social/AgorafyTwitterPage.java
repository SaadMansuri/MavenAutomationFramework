package com.agorafy.automation.pageobjects.footer.social;

import org.openqa.selenium.WebDriver;

import com.agorafy.automation.pageobjects.Page;

public class AgorafyTwitterPage extends Page
{
    public AgorafyTwitterPage(WebDriver driver)
    {
        super(driver);
    }

    public String agorafyTwitterPageUrl()
    {
        return "https://twitter.com/agorafy";
    }
}