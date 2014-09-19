package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;

public class LoginPage extends PageElement 
{
    private static WebElement element = null;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static WebElement txtbx_UserName() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='headerLoginForm']/div[1]/input"));
            AutomationLog.info("Username text box found on the Login Page");
        }
        catch (Exception e)
        {
            AutomationLog.error("UserName text box was not found on the Login Page");
            throw(e);
        }
        return element;
    }
    
    public static WebElement txtbx_Password() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='headerLoginForm']/div[2]/input"));
            AutomationLog.info("Password text box found on the Login page");
        }
        catch (Exception e)
        {
            AutomationLog.error("Password text box was not found on the Login Page");
            throw(e);
         }
        return element;
    }

    public static WebElement btn_LogIn() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='headerLoginForm']/div[4]/input"));
            AutomationLog.info("Submit button found on the Login page");
        }
        catch (Exception e)
        {
            AutomationLog.error("Submit button was not found on the Login Page");
            throw(e);
        }
        return element;
    }

}
