package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;

public class SendEmailPopUp extends Page
{
    private WebElement element;

    public SendEmailPopUp(WebDriver driver)
    {
        super(driver);
    }

    public By getSendEmailPopUpLocator() throws Exception
    {
        return By.id("sendEmail");
    }

    public WebElement popup_SendEmail() throws Exception
    {
        try
        {
            element = driver.findElement(getSendEmailPopUpLocator());
            AutomationLog.info("Send Email popup found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Send Email popup");
            throw(e);
        }
        return element;
    }

    public WebElement txtbx_From() throws Exception
    {
        try
        {
            element = popup_SendEmail().findElement(By.id("from"));
            AutomationLog.info("From text box found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find From text box");
            throw(e);
        }
        return element;
    }

    public WebElement txtbx_Subject() throws Exception 
    {
        try
        {
            element = popup_SendEmail().findElement(By.id("subject"));
            AutomationLog.info("Subject text box found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Subject text box");
            throw(e);
        }
        return element;
    }

    public WebElement txtarea_Message() throws Exception
    {
        try
        {
            element = popup_SendEmail().findElement(By.id("message"));
            AutomationLog.info("Message textarea found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find message textarea");
            throw(e);
        }
        return element;
    }

    public WebElement btn_Send() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("btnSaveDialog"));
            AutomationLog.info("Send button found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Send button");
            throw(e);
        }
        return element;
    }

    public WebElement btn_Cancel() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("btnCancelDialog"));
            AutomationLog.info("Cancel button found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Cancel button");
            throw(e);
        }
        return element;
    }

    public void clickOnSendButton() throws Exception
    {
        try
        {
            btn_Send().click();
            AutomationLog.info("Successfully clicked on Send button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Send button");
        }
    }

    public void clickOnCancelButton() throws Exception
    {
        try
        {
            btn_Cancel().click();
            AutomationLog.info("Successfully clicked on Cancel button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Cancel button");
        }
    }

    public boolean isSendEmailPopupDisplayed() throws Exception
    {
        boolean value = false;
        try
        {
            value = popup_SendEmail().isDisplayed();
        }
        catch(Exception e)
        {
            AutomationLog.error("Send email pop up is not displayed");
            throw(e);
        }
        return value;
    }

}
