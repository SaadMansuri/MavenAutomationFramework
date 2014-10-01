package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.agorafy.automation.automationframework.AutomationLog;

public class AccountSettings extends Page 
    {
        private WebElement element = null;
        public AccountSettings(WebDriver driver)
    {
        super(driver);
    }
public WebElement link_ChangePasswordTab() throws Exception
    {
    try
    { 
        element = driver.findElement(By.id("changePasswordLink"));
        AutomationLog.info("Change Password tab found in AccountSettings Page");
    }
    catch (Exception e)
    {
        AutomationLog.error("Change Password tab not found in AccountSettings Page");
        throw(e);
    }
    return element;
    }
     
public ChangePasswordTab clickOnChangePasswordTab() throws Exception
    {
        ChangePasswordTab changePasswordTab = null;
    try
    {
        link_ChangePasswordTab().click();
        changePasswordTab = new ChangePasswordTab(driver);
        AutomationLog.info("clicked on change password tab");
    }
    catch(Exception e)
    {
       AutomationLog.info("not clicked on change password tab");			
       throw(e);
    }
       return changePasswordTab;
    }
    }

