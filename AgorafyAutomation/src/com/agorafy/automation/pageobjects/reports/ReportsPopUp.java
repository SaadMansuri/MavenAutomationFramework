package com.agorafy.automation.pageobjects.reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class ReportsPopUp extends Page
{
    private WebElement element = null;

    public ReportsPopUp(WebDriver driver)
    {
       super(driver);
    }

    public WebElement txtbx_Name() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("crName"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Name textbox ");
            throw(e);
        }
        return element;
    }

    public WebElement txtbx_Company() throws Exception 
    {
        try
        {
            element = driver.findElement(By.name("crContact[company]"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Company textbox ");
            throw(e);
        }
        return element;
    }

    public WebElement txtbx_Phone() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("crPhone"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Phone textbox ");
            throw(e);
        }
        return element;
    }

    public WebElement txtbx_Email() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("crEmail"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Email textbox ");
            throw(e);
        }
        return element;
    }

    public WebElement popup_Reports() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("customizeReport"));
            AutomationLog.info("Reports PopUP found");
        }
        catch(Exception e)
        {
           AutomationLog.error("Could not find Reports PopUp ");
        }
        return element;
    }

    public WebElement btn_Close() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("btn-cancel"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find close button on Reports Popup");
            throw(e);
        }
        return element;
    }

    public void clickOnCloseButton() throws Exception 
    {
        try
        {
            btn_Close().click();
            AutomationLog.info("Successfully clicked on close button Report PopUp");
        }
        catch(Exception e)
        {
           AutomationLog.error("Could not click on close button Report Popup");
           throw(e);
        }
    }

    //CustomizedReport select button
    public WebElement btn_selectForCustomizedReports() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("generateReportCustom")).findElement(By.className("generateReportButton"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find select button on Reports PopUp");
            throw(e);
        }
        return element;
    }

    public void clickOnSelectButtonForCustomizedReports() throws Exception
    {
        try
        {
            btn_selectForCustomizedReports().click();
            AutomationLog.info("Successfully clicked on Select button for Customized Reports");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Select Button for Customized Reports");
            throw(e);
        }
    }

    public WebElement msg_NameError() throws Exception 
    {
        try
        {
            element = driver.findElement(By.className("crNameformError")).findElement(By.className("formErrorContent"));
            AutomationLog.info("Error Message for Name field Found ");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Error Message for Name field");
            throw(e);
        }
        return element;
    }

    public boolean isPhoneAndEmailErrorMsgPresent() throws Exception
    {
        boolean isErrorMsgPresent;
        isErrorMsgPresent = driver.findElements(By.className("crPhoneformError")).size() > 0;
        return isErrorMsgPresent;
    }

    public WebElement msg_InvalidEmail() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("crEmailformError")).findElement(By.className("formErrorContent"));
            AutomationLog.info("Error message for Invalid Email found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Error Message for Invalid Email ");
            throw(e);
        }
        return element;
    }

    public WebElement msg_InvalidPhone() throws Exception
    {
       try
       {
            element = driver.findElement(By.className("crPhoneformError")).findElement(By.className("formErrorContent"));
            AutomationLog.info("Error message for Invalid Phone found");
       }
       catch(Exception e)
       {
           AutomationLog.error("Could not find Error Message for Invalid Phone ");
           throw(e);
       }
       return element;
    }
}
