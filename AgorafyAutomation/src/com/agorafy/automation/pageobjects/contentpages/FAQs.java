package com.agorafy.automation.pageobjects.contentpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class FAQs extends Page
{
    private WebElement element = null;
    public FAQs(WebDriver driver)
    {
        super(driver);
    }

    public String faqsPageUrl()
    {
        return "http://blog.agorafy.com/faq/";
    }

    public WebElement pageHeading() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='item16888584']/div[3]/h2/a"));
            AutomationLog.info("FAQs Page Heading found on page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Not able to find FAQs Page Heading");
            throw(e);
        }
        return element;
    }

    public String headingText() throws Exception
    {
        return getTextfromElement(pageHeading());
    }
}