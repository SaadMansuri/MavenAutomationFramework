package com.agorafy.automation.pageobjects.contentpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class HowItWorks extends Page
{
    private WebElement element = null;
    public HowItWorks(WebDriver driver)
    {
        super(driver);
    }

    public String getApplicationUrl()
    {
        return applicationUrl();
    }

    public WebElement pageHeadingSection() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("page-column")).findElements(By.className("content-block")).get(0);
            AutomationLog.info("Page Heading Section found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Page Heading Section");
            throw(e);
        }
        return element;
    }

    public WebElement pageHeadingElement() throws Exception
    {
        try
        {
            element = pageHeadingSection().findElement(By.tagName("h2"));
            AutomationLog.info("How It Works Page Heading found on page");
        }
        catch(Exception e)
        {
            AutomationLog.error("How It Works Page Heading Not found");
            throw(e);
        }
        return element;
    }

    public String pageHeading() throws Exception
    {
        return pageHeadingElement().getText();
    }
}