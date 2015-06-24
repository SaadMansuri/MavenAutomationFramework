package com.agorafy.automation.pageobjects.subnavigationmenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class SearchPropertiesPage extends Page
{
    private WebElement element = null;

    public SearchPropertiesPage(WebDriver driver)
    {
        super(driver);
    }

    public WebElement pageHeadingSection() throws Exception
    {
        try
        {
            element = driver.findElements(By.className("content-block")).get(0);
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Page heading section");
            throw(e);
        }
        return element;
    }

    public WebElement pageHeadingElement() throws Exception
    {
        try
        {
            element = pageHeadingSection().findElement(By.tagName("h2"));
            AutomationLog.info("Search Properties page Heading is found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Search Properties page Heading is not found");
            throw(e);
        }
        return element;
    }

    @Override
    public String pageHeading() throws Exception
    {
        return pageHeadingElement().getText();
    }

    public String getApplicationUrl()
    {
        return applicationUrl();
    }
}
