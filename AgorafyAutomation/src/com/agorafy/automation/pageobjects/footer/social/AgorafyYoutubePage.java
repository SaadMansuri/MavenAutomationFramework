package com.agorafy.automation.pageobjects.footer.social;

import org.openqa.selenium.WebDriver;

import com.agorafy.automation.pageobjects.Page;

public class AgorafyYoutubePage extends Page
{
    public AgorafyYoutubePage(WebDriver driver)
    {
        super(driver);
    }

    public String agorafyYoutubePageUrl()
    {
        return "https://www.youtube.com/user/agorafy";
    }
}