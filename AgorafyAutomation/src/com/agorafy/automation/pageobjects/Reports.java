package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;

public class Reports extends Page 
{
    private WebElement element = null;
    private PropertySearch propertysearch = null;
    private Header header = new Header(Page.driver);

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

    public WebElement reportBox() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("reportBox"));
            AutomationLog.info("ReportBox found");
        }
        catch (Exception e)
        {
            AutomationLog.error("could not found ReportBox");
            throw(e);
        }
        return element;
    }

    public String getReportCount() throws Exception
    {
        String count;
        header.clickOnProfileNameDropdownArrow();
        count = header.reportCount().getText();
        return count;
        
    }
}
