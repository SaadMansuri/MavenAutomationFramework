package com.agorafy.automation.pageobjects.contentpages;

import org.openqa.selenium.WebDriver;
import com.agorafy.automation.pageobjects.Page;

public class FAQs extends Page
{
    public FAQs(WebDriver driver)
    {
        super(driver);
    }

    public String faqsPageUrl()
    {
        return "http://blog.agorafy.com/faq/";
    }
}