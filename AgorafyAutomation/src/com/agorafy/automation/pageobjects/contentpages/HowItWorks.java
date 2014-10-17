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

    public String howItWorksPageUrl()
    {
        return applicationUrl() + "/tips/";
    }

    public WebElement pageHeadingElement() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[1]/h2"));
            AutomationLog.info("How It Works Page Heading found on page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Not able to find How It Works Page Heading");
            throw(e);
        }
        return element;
    }

    public String pageHeading() throws Exception
    {
        return pageHeadingElement().getText();
    }
}