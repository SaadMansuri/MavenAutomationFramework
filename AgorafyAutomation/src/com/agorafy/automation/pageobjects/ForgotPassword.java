package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.datamodel.profile.ForgotPasswordData;

public class ForgotPassword extends Page
{
    private WebElement element = null;
    public ForgotPassword(WebDriver driver) 
    {
        super(driver);
    }

    public WebElement txtbox_EmailAddress() throws Exception
    {
        try
        {
            element=driver.findElement(By.id("forgotPassInput"));
            AutomationLog.info("Email Address found inside the Forgot Password Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Email Address not found inside the Forgot Password Page");
            throw(e);
        }
            return element;
    }

    public WebElement btn_RequestNewPassword() throws Exception
    {
        try
        {
            element=driver.findElement(By.id("forgotPassSubmit"));
            AutomationLog.info("RequestNewPassword found inside the Forgot Password Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("RequestNewPassword not found inside the Forgot Password Page");
            throw(e);
        }
            return element;
    }

    public WebElement errorMessageEnterValidMail() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='forgotPassError']"));
            AutomationLog.info("The error message please enter valid email successfully dispalyed");
        }
        catch(Exception e)
        {
            AutomationLog.error("The error message please enter valid email not dispalyed");
            throw(e);
        }
           return element;
    }

    public ForgotPassword clickOnRequestNewPassword() throws Exception
    {
        ForgotPassword forgotpassword = null;
        try
        {
            btn_RequestNewPassword().click();
            forgotpassword = new ForgotPassword(driver);
            AutomationLog.info("Successfully clicked on RequestNewPassword button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Not clicked on RequestNewPassword button");
            throw(e);
        }
        return forgotpassword;
    }

    public void populateForgotPasswordData(ForgotPasswordData forgotpassworddata) throws Exception
    {
        try
        {
            txtbox_EmailAddress().clear();
            txtbox_EmailAddress().sendKeys(forgotpassworddata.getEmailAddress());
        }
            catch(Exception e)
        {
            AutomationLog.info("Not able to populate email address details");
            throw(e);
        }
    }
}