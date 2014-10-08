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
            AutomationLog.info("Old Password text box found in change Password tab");
        }
        catch (Exception e)
        {
            AutomationLog.error("Old Password text box not found in change Password tab");
            throw(e);
        }
        return element;
    }

    public WebElement txtBox_NewPassword() throws Exception
    {
        try
        { 
            element = driver.findElement(By.id("password1"));
            AutomationLog.info("New Password text box found in change Password tab");
        }
        catch (Exception e)
        {
            AutomationLog.error("New Password text box not found in change Password tab");
            throw(e);
        }
        return element;
    }

    public WebElement txtBox_RetypeNewPassword() throws Exception
    { 
        try
        { 
            element = driver.findElement(By.id("password2"));
            AutomationLog.info("Retype New Password text box found in change Password tab");
        }
        catch (Exception e)
        {
            AutomationLog.error("Retype New Password text box not found in change Password tab");
            throw(e);
        }
        return element;
        }

    public WebElement submitButtonChangePassword() throws Exception
    {
        try
        { 
            element = driver.findElement(By.id("passwordChangeSubmit"));
            AutomationLog.info("ChangePassword button found in change Password tab");
        }
        catch (Exception e)
        {
            AutomationLog.error("ChangePassword button not found in change Password tab");
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
            AutomationLog.info("Clicked on submit button password changed successfully");
        }
        catch(Exception e)
        {
            AutomationLog.info("not clicked on submit change password button");
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
            AutomationLog.info("not able to populate password details");
            throw(e);
        }
    }

    public WebElement errorMessageOldPassword() throws Exception
    {
       try
       {
           element=driver.findElement(By.xpath(".//*[@id='changePasswordForm']/div[2]/div/div/div"));
           AutomationLog.info("Actual error message found in OldPassword text field");
       }
       catch(Exception e)
       {
           AutomationLog.error("error message not fond in OldPassword button");
           throw(e);
       }
       return element;
    }

    public WebElement errorMessageNewPassword() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='changePasswordForm']/div[3]/div/div/div"));
            AutomationLog.info("Actual error message found in NewPassword button");
        }
        catch(Exception e)
        {
            AutomationLog.error("error message not found in NewPassword button");
            throw(e);
        }
        return element;
    }

    public WebElement errorRetypeNewPassword() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='changePasswordForm']/div[4]/div/div/div"));
            AutomationLog.info("Actual error message found in Retype NewPassword button");
        }
        catch(Exception e)
        {
            AutomationLog.error("error message not found in Retype NewPassword button");
            throw(e);
        }
        return element;
    }

    public WebElement passwordChangedSuccessfully() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='changePasswordMessage']"));
            AutomationLog.info("Password Changed Successfully");
        }
        catch(Exception e)
        {
            AutomationLog.error("Password Not Changed Successfully");
            throw(e);
        }
        return element;
    }
}
