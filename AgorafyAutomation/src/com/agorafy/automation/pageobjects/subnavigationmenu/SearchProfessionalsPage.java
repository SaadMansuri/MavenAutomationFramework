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

    public WebElement pageHeadingElement() throws Exception
    {
        WebElement element;
        try
        {
        	element = driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/h2"));
            AutomationLog.info("Search Professionals page heading found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Search Professionals page heading Not found");
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
        return applicationUrl() + "/search/agent";
    }
}
