package com.agorafy.automation.pageobjects.subnavigationmenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class AdvancedSearchPage extends Page
{
    WebElement element;
    public AdvancedSearchPage(WebDriver driver)
    {
        super(driver);
    }

    public WebElement pageHeadingElement() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("page-desc"));
            AutomationLog.info("Advanced Search page - heading is found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Advanced Search page - heading is not found");
            throw(e);
        }
        return element;
    }

    @Override
    public String pageHeading() throws Exception
    {
        return pageHeadingElement().getText();
    }

    public String getURL()
    {
        return applicationUrl() + "/search/advancedsearch/";
    }
}
