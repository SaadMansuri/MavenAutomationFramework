package com.agorafy.automation.pageobjects.subnavigationmenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class SearchProfessionalsPage extends Page
{
    public SearchProfessionalsPage(WebDriver driver)
    {
        super(driver);
    }

    public WebElement text_pageHeading() throws Exception
    {
        WebElement element;
        try
        {
        	element = driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/h2"));
            AutomationLog.info("Search Professionals page heading found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Search Professionals page heading does not match with expected heading");
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
        return applicationUrl() + "/search/agent";
    }
}
