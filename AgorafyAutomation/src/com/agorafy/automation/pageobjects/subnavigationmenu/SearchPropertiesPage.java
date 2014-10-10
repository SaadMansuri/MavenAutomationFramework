package com.agorafy.automation.pageobjects.subnavigationmenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class SearchPropertiesPage extends Page
{
    public SearchPropertiesPage(WebDriver driver)
    {
        super(driver);
    }

    public WebElement text_pageHeading() throws Exception
    {
        WebElement element;
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div/div/div[1]/h2"));
            AutomationLog.info("Search Properties page - heading is found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Search Properties page - heading is not found");
            throw(e);
        }
        return element;
    }

    public String pageHeading() throws Exception
    {
        return getTextfromElement(text_pageHeading());
    }

    public String getURL()
    {
        return applicationUrl() + "/search";
    }
}
