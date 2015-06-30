package com.agorafy.automation.pageobjects.contentpages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class AboutUs extends Page
{
    private WebElement element = null;
    public AboutUs(WebDriver driver)
    {
        super(driver);
    }

    public String getApplicationUrl()
    {
        return applicationUrl();
    }

    public WebElement page_HeadingSection() throws Exception
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
            element = page_HeadingSection().findElement(By.tagName("h2"));
            AutomationLog.info("About Us Page Heading found");
        }
        catch(Exception e)
        {
            AutomationLog.error("About Us Page Heading Not found");
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
