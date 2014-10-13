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

    public String accountSettingsPageUrl()
    {
        return applicationUrl() + "/account/";
    }

    public WebElement pageHeading() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[1]/h2"));
            AutomationLog.info("Account Settings page Heading found on page");
        }
        catch (Exception e)
        {
            AutomationLog.error("Not able to find Account Settings Page Heading");
            throw (e);
        }
        return element;
    }

    public String headingText() throws Exception
    {
        return getTextfromElement(pageHeading());
    }

    public WebElement link_personalInfo() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("personalInfoLink"));
            AutomationLog.info("Personal Info tab found on Account Settings");
        }
        catch (Exception e)
        {
            AutomationLog.error("Not able to find Personal Info Tab on Account Settings Page");
            throw (e);
        }
        return element;
    }

    public PersonalInfo clickOnPersonalInfoTab() throws Exception
    {
        PersonalInfo personalInfo = null;
        try
        {
            link_personalInfo().click();
            personalInfo = new PersonalInfo(driver);
            AutomationLog.info("Clicked on PersonalInfo Tab");
        }
        catch (Exception e)
        {
            AutomationLog.error("Not clicked on PersonalInfo Tab");
            throw (e);
        }
        return personalInfo;
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
            throw (e);
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
        catch (Exception e)
        {
            AutomationLog.info("not clicked on change password tab");
            throw (e);
        }
        return changePasswordTab;
    }

    public String isPersonalInfoTabActive() throws Exception
    {
        return link_personalInfo().getAttribute("class");
    }

    public String isChangePasswordTabActive() throws Exception
    {
        return link_ChangePasswordTab().getAttribute("class");
    }
}