package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;

public class Reports extends Page 
{
    private WebElement element = null;
    private PropertySearch propertysearch = null;

    public Reports(WebDriver driver) 
    {
        super(driver);
    }

    public WebElement link_AddToReport() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("addToReport"));
            AutomationLog.info("AddToReport link found");
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not found Add To report link");
            throw(e);
        }
        return element;
    }

}
