package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.datamodel.profile.EmailData;
import com.agorafy.automation.pageobjects.upsellpopups.*;

public class SignUp extends Page
{
    private WebElement element = null;
    public SignUp(WebDriver driver) 
    {
        super(driver);
    }

    protected boolean isSecured()
    {
        return true;
    }

    public String registerPageUrl()
    {
        return applicationUrl() + "/register";
    }

    public WebElement txtbox_Email() throws Exception
    {
        try
        {
            element=driver.findElement(By.id("registrationEmailInput"));
            AutomationLog.info("Email text box found in the SignUp page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found email text box");
            throw(e);
        }
        return element;
    }

    public WebElement errorMessageInvalidEmailEntered() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("registrationEmailInputformError")).findElement(By.className("formErrorContent"));
        }
        catch(Exception e)
        {
            throw(e);
        }
        return element;
    }
    
    public WebElement link_Login() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("description")).findElement(By.className("upsell"));
            AutomationLog.info("login link found on Signup page");
        }
        catch(Exception e)
        {
            AutomationLog.error("login link not found on signup page");
            throw(e);
        }
        return element;
    }

    public LoginPopUp clickOnLoginLink() throws Exception
    {
        LoginPopUp loginpopup=null;
        try
        {
            link_Login().click();
            loginpopup=new LoginPopUp(driver);
            AutomationLog.info("Successfully clicked on login link");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not clicked on login link");
            throw(e);
        }
        return loginpopup;
    }
    public String getErrorMessageOfInvalidEmail() throws Exception
    {
        String invalidEmail = "";
        try
        {
            invalidEmail = errorMessageInvalidEmailEntered().getText();
        }
        catch (Exception e)
        {
            AutomationLog.error("error message for invalid email not found");
            throw(e);
        }
        return invalidEmail;
     }

    public WebElement btn_SignUp() throws Exception
    {
        try
        {
            element=driver.findElement(By.id("registrationSubmit"));
            AutomationLog.info("SignUp button found");
        }
            catch(Exception e)
        {
            AutomationLog.error("Signup button not found");
            throw(e);
        }
        return element;
    }

    public SignUp clickOnSignUpAccountButton() throws Exception
    {
        SignUp signup = null;
        try
        {
            btn_SignUp().click();
            signup = new SignUp(driver);
            AutomationLog.info("Successfully clicked on signup button");
        }
            catch(Exception e)
        {
            AutomationLog.error(" could not clicked on Signup button");
            throw(e);
        }
        return signup;
    }

    public void populateSignUpData(EmailData signupdata) throws Exception
    {
        WebElement signupEmail;
        try
        {
            signupEmail = txtbox_Email();
            signupEmail.clear();
            signupEmail.sendKeys(signupdata.getEmailAddress());
            AutomationLog.info("Data populated in the email text field");
        }
            catch(Exception e)
        {
            AutomationLog.error("could not populate email details");
        throw(e);
        }
    }

    public WebElement emailAlreadyRegistered() throws Exception
    {
        try
        {
            element=driver.findElement(emailAlreadyRegisteredLink());
        }
        catch(Exception e)
        {
            throw(e);
        }
        return element;
    }

    public String getMessageForAlreadyRegEmail() throws Exception
    {
        String regEmail = "";
        try
        {
            regEmail = emailAlreadyRegistered().getText();
        }
        catch (Exception e)
        {
            AutomationLog.error("Proper message for registered mail not found");
            throw(e);
        }
        return regEmail;
     }

    public By emailAlreadyRegisteredLink()
    {
        return By.xpath(".//*[@id='registration_result_2']/p[1]");
    }
}
