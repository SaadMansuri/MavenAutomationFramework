package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;

public class FacebookLogin extends Page
{

    private WebElement element = null;

    public FacebookLogin(WebDriver driver)
    {
        super(driver);
    }

    public WebElement txtbx_Email() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("email"));
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
            element = driver.findElement(By.id("pass"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Password text box");
            throw(e);
        }
        return element;
    }


    public WebElement btn_Login() throws Exception
    {
        try
        {
            element = driver.findElement(By.name("login"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Login button");
            throw(e);
        }
        return element;
    }

    public Homepage doSuccessFullLoginUsingFacebook(String email, String pass) throws Exception
    {
        Homepage homepage = null;
        try
        {
            txtbx_Email().clear();
            txtbx_Email().sendKeys(email);

            txtbx_Password().clear();
            txtbx_Password().sendKeys(pass);

            btn_Login().click();
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
