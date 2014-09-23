package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;

public class LoginPage extends Page 
{
    private WebElement element = null;

    public LoginPage(WebDriver driver) 
    {
        super(driver);
    }

    public WebElement txtbx_UserName() throws Exception
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
    
    public WebElement txtbx_Password() throws Exception
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

    public WebElement btn_LogIn() throws Exception
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
    
    public Homepage doSuccessfulLogin(String username, String password) throws Exception
    {
        Homepage element = null;
        try
        {
            doLoginWithCredentials(username, password);
            element = Homepage.homePage();
        }
        catch (Exception e)
        {
            AutomationLog.error("Loin failed.");
            throw(e);
        }
        return element;
    }

    public LoginPage doInvalidLogin(String username, String password) throws Exception
    {
        LoginPage element = null;
        try
        {
            doLoginWithCredentials(username, password);
            element = new LoginPage(driver);
        }
        catch (Exception e)
        {
            AutomationLog.error("Not able to do Invalid Login");
            throw(e);
        }
        return element;
    }

    private void doLoginWithCredentials(String username, String password) throws Exception
    {
        try
        {
            WebElement userNameTextBox = txtbx_UserName();
            userNameTextBox.clear();
            userNameTextBox.sendKeys(username);
            WebElement passwordTextBox = txtbx_Password();
            passwordTextBox.clear();
            passwordTextBox.sendKeys(password);
            btn_LogIn().click();
            AutomationLog.info("Login Done");
        }
        catch (Exception e)
        {
            AutomationLog.error("Not able to Login");
            throw(e);
        }
    }
}
