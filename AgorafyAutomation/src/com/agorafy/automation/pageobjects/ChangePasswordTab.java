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
            AutomationLog.error("Could not found old password text box");
            throw(e);
        }
        return element;
    }

    public WebElement txtBox_NewPassword() throws Exception
    {
        try
        { 
            element = driver.findElement(By.id("password1"));
            AutomationLog.info("New Password text box found ");
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not found New password text box");
            throw(e);
        }
        return element;
    }

    public WebElement txtBox_RetypeNewPassword() throws Exception
    { 
        try
        { 
            element = driver.findElement(By.id("password2"));
            AutomationLog.info("Retype New Password text box found ");
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not found retype new password text box");
            throw(e);
        }
        return element;
        }

    public WebElement submitButtonChangePassword() throws Exception
    {
        try
        { 
            element = driver.findElement(By.id("passwordChangeSubmit"));
            AutomationLog.info("ChangePassword button found.");
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not found ChangePassword button");
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
            AutomationLog.error("Could not Clicked on change password button");
            throw(e);
        }
        return changePasswordTab;
    }

    public void populateChangePasswordData(ChangePasswordData data) throws Exception
    {
        try
        {
            txtBox_OldPassword().clear();
            txtBox_OldPassword().sendKeys(data.getOldPassword());
            txtBox_NewPassword().clear();
            txtBox_NewPassword().sendKeys(data.getNewPassword());
            txtBox_RetypeNewPassword().clear();
            txtBox_RetypeNewPassword().sendKeys(data.getRetypeNewPassword());
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
           AutomationLog.info("Appropriate error message for old password shown");
       }
       catch(Exception e)
       {
           AutomationLog.error("error message for old password not shown");
           throw(e);
       }
       return element;
    }

    public WebElement errorMessageNewPassword() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='changePasswordForm']/div[3]/div/div/div"));
            AutomationLog.info("Appropriate error message for New password shown");
        }
        catch(Exception e)
        {
            AutomationLog.error("error message for New password not shown");
            throw(e);
        }
        return element;
    }

    public WebElement errorRetypeNewPassword() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='changePasswordForm']/div[4]/div/div/div"));
            AutomationLog.info("Appropriate error message for Retype New password shown");
        }
        catch(Exception e)
        {
            AutomationLog.error("error message for Retype New password not shown");
            throw(e);
        }
        return element;
    }

    public WebElement passwordChangedSuccessfully() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='changePasswordMessage']"));
            AutomationLog.info("Success message for change password shown");
        }
        catch(Exception e)
        {
            AutomationLog.error("Success message for change password not shown");
            throw(e);
        }
        return element;
    }
}
