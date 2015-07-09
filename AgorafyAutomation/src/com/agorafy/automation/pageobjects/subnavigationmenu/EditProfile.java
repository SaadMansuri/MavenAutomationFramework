package com.agorafy.automation.pageobjects.subnavigationmenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class EditProfile extends Page  
{
    WebElement element;

    public EditProfile(WebDriver driver) 
    {
        super(driver);
    }

    public WebElement EditProfileHeadingSection() throws Exception
    {
        try 
        {
            element = driver.findElement(By.className("page-column")).findElement(By.className("content-block"));
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find edit profile Heading section");
            throw (e);
        }
        return element;
    }

    public WebElement element_PageHeading() throws Exception
    {
        try 
        {
            element = EditProfileHeadingSection().findElement(By.tagName("h2"));
            AutomationLog.info("edit profile page heading found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find edit profile heading");
            throw (e);
        }
        return element;
    }

    public String getApplicationUrl()
    {
        return applicationUrl();
    }

    public String pageHeading() throws Exception
    {
        return element_PageHeading().getText();
    }
}
