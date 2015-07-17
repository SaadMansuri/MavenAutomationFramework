package com.agorafy.automation.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;

public class GooglePlusLogin extends Page
{
    private WebElement element = null;

    public GooglePlusLogin(WebDriver driver)
    {
        super(driver);
    }

    public WebElement txtbx_Email() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("Email"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Email text box");
            throw(e);
        }
        return element;
    }

    public WebElement txtbx_Password() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("Passwd"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Password text box");
            throw(e);
        }
        return element;
    }


    public WebElement btn_SignIn() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("signIn"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find SignIn button");
            throw(e);
        }
        return element;
    }

    public WebElement btn_Next() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("next"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find next button");
            throw(e);
        }
        return element;
    }


    public Homepage doSuccessFullLoginUsingGooglePlus(String email, String pass) throws Exception
    {
        Homepage homepage = null;
        try
        {
            txtbx_Email().clear();
            txtbx_Email().sendKeys(email);

            btn_Next().click();

            Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WaitFor.sleepFor(2000);
            txtbx_Password().clear();
            txtbx_Password().sendKeys(pass);

            btn_SignIn().click();
            homepage = new Homepage(driver);
            AutomationLog.info("Login done");
        }
        catch(Exception e)
        {
            AutomationLog.error("Login failed");
            throw(e);
        }
        return homepage;
    }

}
