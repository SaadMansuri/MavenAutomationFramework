package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.datamodel.profile.SignUpData;

public class SignUp extends Page
{
    private WebElement element = null;
    public SignUp(WebDriver driver) 
    {
        super(driver);
    }

    public WebElement txtbox_Email() throws Exception
    {
        try
        {
            element=driver.findElement(By.id("registrationEmailInput"));
            AutomationLog.info("Email text box found inside the SignUp page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Email text box not found inside the SignUp page");
            throw(e);
        }
        return element;
    }

    public WebElement errorMessageInvalidEmailEntered() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='registrationSubmitForm']/div[1]/div/div"));
            AutomationLog.info("Actual Error message found in the email text box");
        }
        catch(Exception e)
        {
            AutomationLog.error("Error message found in the email text box");
            throw(e);
        }
        return element;
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
            AutomationLog.error("Not clicked on Signup button");
            throw(e);
        }
        return signup;
    }

    public void populateSignUpData(SignUpData data) throws Exception
    {
        try
        {
            txtbox_Email().clear();
            txtbox_Email().sendKeys(data.getEmail());
            AutomationLog.info("Data populated in the email text field");
        }
            catch(Exception e)
        {
            AutomationLog.error("Not able to populate email details");
        throw(e);
        }
    }

    public WebElement emailAlreadyRegistered() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='registration_result_2']/p[1]"));
            AutomationLog.info("Email Already Registered");
        }
        catch(Exception e)
        {
            AutomationLog.error("Email not Registered");
            throw(e);
        }
        return element;
    }
}
 