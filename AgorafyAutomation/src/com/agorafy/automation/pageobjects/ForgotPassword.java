package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.datamodel.profile.EmailData;

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
            AutomationLog.info("Email Address found in the Forgot Password Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found the email address");
            throw(e);
        }
            return element;
    }

    public WebElement btn_RequestNewPassword() throws Exception
    {
        try
        {
            element=driver.findElement(By.id("forgotPassSubmit"));
            AutomationLog.info("RequestNewPassword button found in the Forgot Password Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found the RequestNewPassword button");
            throw(e);
        }
            return element;
    }

    public WebElement errorMessageEnterInvalidEMail() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='forgotPassError']"));
        }
        catch(Exception e)
        {
            throw(e);
        }
           return element;
    }

    public String getErrorMessageOfInvalidEmail() throws Exception
    {
        String invalidEmail = "";
        try
        {
            invalidEmail = errorMessageEnterInvalidEMail().getText();
        }
        catch (Exception e)
        {
            AutomationLog.error("error message for invalid email is not shown");
            throw(e);
        }
        return invalidEmail;
     }

    public WebElement messageEnterValidEmailNotReg() throws Exception
    {
        try
        {
            element=driver.findElement(validEmailNotRegistered());
        }
        catch(Exception e)
        {
            throw(e);
        }
           return element;
    }

    public String getMessageOfValidEmailNotReg() throws Exception
    {
        String validEmailNotReg = "";
        try
        {
            validEmailNotReg = messageEnterValidEmailNotReg().getText();
        }
        catch (Exception e)
        {
            AutomationLog.error("error message for valid registered email is not shown");
            throw(e);
        }
        return validEmailNotReg;
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
            AutomationLog.error("Could not click on RequestNewPassword button ");
            throw(e);
        }
        return forgotpassword;
    }

    public WebElement populateForgotPasswordData(EmailData forgotpassworddata) throws Exception
    {
        WebElement emailField;
        try
        {
            emailField = txtbox_EmailAddress();
            emailField.clear();
            emailField.sendKeys(forgotpassworddata.getEmailAddress());
        }
            catch(Exception e)
        {
            AutomationLog.info("Successfully populated email address details");
            throw(e);
        }
        return element;
    } 
      public WebElement BackToLoginLink() throws Exception
        {
            try
            {
                element=driver.findElement(By.id("showLogin"));
                AutomationLog.info("Found the BackToLoginLink on the ForgotPasswordPage");
            }
            catch(Exception e)
            {
                AutomationLog.error("Could not found the BackToLoginLink");
                throw(e);
            }
                return element;
        }
    
      public LoginPage clickOnBackToLoginLink() throws Exception
      {
          LoginPage forgotpassword = null;
          try
          {
              BackToLoginLink().click();
              forgotpassword = new LoginPage(driver);
              AutomationLog.info("Successfully clicked and Redirected To Landing Page");
          }
          catch(Exception e)
          {
              AutomationLog.error("Could not click on BackToLoginLink");
              throw(e);
          }
          return forgotpassword;
      }
     

    public By validEmailNotRegistered()
    {
        return By.xpath(".//*[@id='forgot_confirm_error']/h5");
    }
}