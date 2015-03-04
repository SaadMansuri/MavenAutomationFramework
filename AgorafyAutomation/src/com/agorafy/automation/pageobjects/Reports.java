package com.agorafy.automation.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;
import com.thoughtworks.selenium.Wait;

public class Reports extends Page 
{
    private WebElement element = null;
    private PropertySearch propertysearch = null;
    private Header header = new Header(driver);

    public Reports(WebDriver driver) 
    {
        super(driver);
    }

    public static Reports reports() throws Exception
    {
        return PageFactory.initElements(driver, Reports.class);
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

    public By getReportBoxLocator() throws Exception
    {
        return By.id("reportBox");
    }

    public WebElement reportBox() throws Exception
    {
        try
        {
            element = driver.findElement(getReportBoxLocator());
            AutomationLog.info("ReportBox found");
        }
        catch (Exception e)
        {
            AutomationLog.error("could not found ReportBox");
            throw(e);
        }
        return element;
    }

    public By getUserDropdownLocator() throws Exception
    {
        return By.className("userDropdown");
    }

    public String getReportCount() throws Exception
    {
        String count;
        header.clickOnProfileNameDropdownArrow();
        WaitFor.presenceOfTheElement(driver, getUserDropdownLocator());
        count = header.reportCount().getText();
        header.clickOnProfileNameDropdownArrow();
        //WaitFor.presenceOfTheElement(driver, getUserDropdownLocator());
        return count;
        
    }

    public WebElement icon_Close() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("reportWindowClose"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found close icon");
            throw(e);
        }
        return element;
    }

    public void clickOnCloseIcon() throws Exception
    {
        try
        {
            icon_Close().click();
            AutomationLog.info("Successfully clicked on Close icon");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Close icon");
            throw(e);
        }
    }

    public WebElement link_Clear() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("clearReport"));
            AutomationLog.info("Clear link found on Reports box");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found clear link Reports box");
            throw(e);
        }
        return element;
    }

    public void clickOnClearLink() throws Exception 
    {
        try
        {
            link_Clear().click();
            AutomationLog.info("Successfully Clicked on Clear link");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Clear link");
            throw(e);
        }
    }

    public WebElement Report_List() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("reportList"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found Report list");
            throw(e);
        }
        return element;
    }

    public List<WebElement> resultsetReportList() throws Exception
    {
        return Report_List().findElements(By.tagName("li"));
    }

    public WebElement link_Print() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("printReport"));
            AutomationLog.info("Print link found on Reports box");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found Print link on Reports box");
            throw(e);
        }
        return element;
    }

    public void clickOnPrintLink() throws Exception 
    {
        try
        {
            link_Print().click();
            AutomationLog.info("Successfully Clicked on Print link");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Print link");
            throw(e);
        }
    }

}
