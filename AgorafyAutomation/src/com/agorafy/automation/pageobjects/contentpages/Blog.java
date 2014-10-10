package com.agorafy.automation.pageobjects.contentpages;

import org.openqa.selenium.WebDriver;
import com.agorafy.automation.pageobjects.Page;

public class Blog extends Page
{
    public Blog(WebDriver driver)
    {
        super(driver);
    }

    public String blogPageUrl()
    {
        return "http://blog.agorafy.com/";
    }
}