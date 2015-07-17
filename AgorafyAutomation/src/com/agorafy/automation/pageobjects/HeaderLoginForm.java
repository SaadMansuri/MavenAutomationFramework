package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;

public class HeaderLoginForm extends Page
{
    WebElement element;

    public HeaderLoginForm(WebDriver driver)
    {
        super(driver);
    }

    public WebElement form_HeaderLogin() throws Exception 
    {
        try
        {
            element = driver.findElement(getHeaderLoginFormLocator());
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Header Login form ");
            throw(e);
        }
        return element;
    }

    public WebElement txtbx_UserNameInHeaderDropdown() throws Exception
    {
        try
        {
            element = form_HeaderLogin().findElement(By.name("_username"));
            AutomationLog.info("Username text box found on Header Login Form");
        }
        catch (Exception e)
        {
            AutomationLog.error("UserName text box was Not found on Header Login Form");
            throw(e);
        }
        return element;
    }

    public WebElement txtbx_PasswordInHeaderDropdown() throws Exception
    {
        try
        {
            element = form_HeaderLogin().findElement(By.name("_password"));
            AutomationLog.info("Password text box found on Header Login Form");
        }
        catch (Exception e)
        {
            AutomationLog.error("Password text box was Not found on Header Login Form");
            throw(e);
         }
        return element;
    }

    public WebElement btn_LogInHeaderDropdown() throws Exception
    {
        try
        {
            element = form_HeaderLogin().findElement(By.className("btn-primary"));
            AutomationLog.info("Login button found on Header Login Form");
        }
        catch (Exception e)
        {
            AutomationLog.error("Login button was Not found on Header Login Form");
            throw(e);
        }
        return element;
    }

    public WebElement checkbox_stayLoggedIn() throws Exception
    {
        try
        {
            element = form_HeaderLogin().findElement(By.id("remember_me"));
            AutomationLog.info("Checkbox for 'Stay logged in' found");
        }
        catch (Exception e)
        {
            AutomationLog.error("checkbox for 'Stay logged in' Not found");
            throw(e);
        }
        return element;
    }

    public WebElement label_stayLoggedIn() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='headerLoginForm']/div[3]/label"));
            AutomationLog.info("Label 'Stay logged in' found");
        }
        catch (Exception e)
        {
            AutomationLog.error("Label 'Stay logged in' Not found");
        }
        return element;
    }

    public LoginPage doInvalidLogin(String email, String password) throws Exception
    {
        LoginPage element = null;
        try
        {
            WaitFor.ElementToBeDisplayed(driver, getHeaderLoginFormLocator());
            doLoginWithCredentials(email, password);
            element = new LoginPage(driver);
        }
        catch (Exception e)
        {
            AutomationLog.error("There was an error in entering credentials in the header login form");
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
            AutomationLog.info("Login Done");
            element = Homepage.homePage();
        }
        catch (Exception e)
        {
            AutomationLog.error("Login failed.");
            throw(e);
        }
        return element;
    }

    public By getHeaderLoginFormLocator() throws Exception
    {
        return By.id("headerLoginForm");
    }

    private void doLoginWithCredentials(String username, String password) throws Exception
    {
        try
        {
            WebElement userNameTextBox = txtbx_UserNameInHeaderDropdown();
            userNameTextBox.clear();
            userNameTextBox.sendKeys(username);
            AutomationLog.info("Username entered Successfully");
            WaitFor.sleepFor(1000);
            WebElement passwordTextBox = txtbx_PasswordInHeaderDropdown();
            passwordTextBox.clear();
            passwordTextBox.sendKeys(password);
            AutomationLog.info("Password entered Successfully");
            WaitFor.sleepFor(1000);
            btn_LogInHeaderDropdown().click();
        }
        catch (Exception e)
        {
            AutomationLog.error("Not able to Login");
            throw(e);
        }
    }

    public WebElement link_Facebook() throws Exception
    {
        try
        {
            element = form_HeaderLogin().findElement(By.linkText("Facebook"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Facebook link");
            throw(e);
        }
        return element;
    }

    public WebElement link_GooglePlus() throws Exception
    {
        try
        {
            element = form_HeaderLogin().findElement(By.linkText("Google+"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Google+ link");
            throw(e);
        }
        return element;
    }

    public FacebookLogin clickOnFacebookLinkInHeaderLoginForm() throws Exception
    {
        FacebookLogin facebooklogin = null;
        try
        {
            link_Facebook().click();
            facebooklogin = new FacebookLogin(driver);
            AutomationLog.info("Successfully clicked facebook link in headerloginform");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could click on facebook link in headerLoginform");
            throw(e);
        }
        return facebooklogin;
    }

    public GooglePlusLogin clickOnGooglePlusLinkInHeaderLoginForm() throws Exception
    {
    	GooglePlusLogin googlelogin = null;
        try
        {
            link_GooglePlus().click();
            googlelogin = new GooglePlusLogin(driver);
            AutomationLog.info("Successfully clicked GooglePlus link in headerloginform");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could click on GooglePlus link in headerLoginform");
            throw(e);
        }
        return googlelogin;
    }

}
