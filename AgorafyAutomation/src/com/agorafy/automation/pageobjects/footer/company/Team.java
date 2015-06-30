package com.agorafy.automation.pageobjects.footer.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class Team extends Page
{
    private WebElement element = null;
    public Team(WebDriver driver)
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
            element = driver.findElement(By.className("page-column")).findElement(By.className("page-desc"));
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
            AutomationLog.info("Team page Heading found on the page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Team page Heading Not found");
            throw(e);
        }
        return element;
    }

    @Override
    public String pageHeading() throws Exception
    {
        return pageHeadingElement().getText();
    }
}