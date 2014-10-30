package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.datamodel.profile.ChangePasswordData;

public class ChangePasswordTab extends Page 
{
    private WebElement element = null;
    public ChangePasswordTab(WebDriver driver) 
    {
        super(driver);
    }

    public WebElement txtBox_OldPassword() throws Exception
    {
        try
        { 
            element = driver.findElement(By.id("oldPassword"));
            AutomationLog.info("Old Password text box found");
        }
        catch (Exception e)
        {
            AutomationLog.error("Old password text box Not found");
            throw(e);
        }
        return element;
    }

    public WebElement txtBox_NewPassword() throws Exception
    {
        try
        { 
            element = driver.findElement(By.id("password1"));
            AutomationLog.info("New Password text box found");
        }
        catch (Exception e)
        {
            AutomationLog.error("New Password text box Not found");
            throw(e);
        }
        return element;
    }

    public WebElement txtBox_RetypeNewPassword() throws Exception
    { 
        try
        { 
            element = driver.findElement(By.id("password2"));
            AutomationLog.info("Retype New Password text box found");
        }
        catch (Exception e)
        {
            AutomationLog.error("Retype New Password text box Not found");
            throw(e);
        }
        return element;
        }

    public WebElement submitButtonChangePassword() throws Exception
    {
        try
        { 
            element = driver.findElement(By.id("passwordChangeSubmit"));
            AutomationLog.info("ChangePassword button found");
        }
        catch (Exception e)
        {
            AutomationLog.error("ChangePassword button Not found");
            throw(e);
        }
        return element;
    } 

    public ChangePasswordTab clickOnSubmitButtonChangePassword() throws Exception
    {
        ChangePasswordTab changePasswordTab = null;
        try
        {
            submitButtonChangePassword().click();
            changePasswordTab = new ChangePasswordTab(driver);
            AutomationLog.info("Successfully Clicked on change password button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not Click on change password button");
            throw(e);
        }
        return changePasswordTab;
    }

    public void populateChangePasswordData(ChangePasswordData data) throws Exception
    {
        WebElement oldPassword, newPassword, retypeNewPassword; 
        try
        {
            oldPassword = txtBox_OldPassword();
            oldPassword.clear();
            oldPassword.sendKeys(data.getOldPassword());
            newPassword = txtBox_NewPassword();
            newPassword.clear();
            newPassword.sendKeys(data.getNewPassword());
            retypeNewPassword = txtBox_RetypeNewPassword();
            retypeNewPassword.clear();
            retypeNewPassword.sendKeys(data.getRetypeNewPassword());
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not populate change password details");
            throw(e);
        }
    }

    public WebElement errorMessageOldPassword() throws Exception
    {
       try
       {
           element=driver.findElement(By.xpath(".//*[@id='changePasswordForm']/div[2]/div/div/div"));
       }
       catch(Exception e)
       {
           AutomationLog.error("Error message for old password not shown");
           throw(e);
       }
       return element;
    }

    public WebElement errorMessageNewPassword() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='changePasswordForm']/div[3]/div/div/div"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Error message for New password not shown");
            throw(e);
        }
        return element;
    }

    public WebElement errorRetypeNewPassword() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='changePasswordForm']/div[4]/div/div/div"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Error message for Retype New password not shown");
            throw(e);
        }
        return element;
    }

    public WebElement passwordChangedSuccessfully() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='changePasswordMessage']"));
        }
        catch(Exception e)
        {
            throw(e);
        }
        return element;
    }

    public String getSuccessMessageOfChangePasswordTab() throws Exception
    {
        String successMessage = "";
        try
        {
            successMessage = passwordChangedSuccessfully().getText();
        }
        catch (Exception e)
        {
            AutomationLog.error("error message for name is not shown");
            throw(e);
        }
        return successMessage;
     }
}
