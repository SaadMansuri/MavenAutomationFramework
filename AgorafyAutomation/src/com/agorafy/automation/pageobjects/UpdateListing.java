package com.agorafy.automation.pageobjects;

import org.apache.xalan.templates.ElemApplyImport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;

public class UpdateListing extends Page 
{

    WebElement element;
    public UpdateListing(WebDriver driver) 
    {
        super(driver);
    }

    public String txt_ListingName()
    {
        String listingName = null;
        try 
        {
            element = driver.findElement(By.className("listing-id-name")).findElement(By.tagName("h4"));
            listingName = element.getText();
            AutomationLog.info("Sucessfully found listing name located at upper corner at RHS");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to find listing name located at upper corner at RHS");
        }
        return listingName;
    }

    public WebElement element_PageHeading() throws Exception
    {
        WebElement parent;
        try 
        {
            parent = driver.findElements(By.className("content-block")).get(0);
            element = parent.findElement(By.tagName("h2"));
            AutomationLog.info("My listing heading found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find My listings heading");
            throw (e);
        }
        return element;
    }

    public WebElement emailId() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("from"));
            AutomationLog.info("Email id is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Email id");
            throw (e);
        }
        return element;
    }

    public String pageHeading() throws Exception
    {
        return element_PageHeading().getText();
    }
}
