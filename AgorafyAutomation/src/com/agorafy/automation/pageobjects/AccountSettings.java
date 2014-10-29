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

    protected boolean isSecured()
    {
        return true;
    }

    public String accountSettingsPageUrl()
    {
        return applicationUrl() + "/account/";
    }

    public WebElement pageHeadingElement() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[1]/h2"));
            AutomationLog.info("Account Settings page Heading found");
        }
        catch (Exception e)
        {
            AutomationLog.error("Account Settings page Heading Not found on page");
            throw (e);
        }
        return element;
    }

    @Override
    public String pageHeading() throws Exception
    {
        return pageHeadingElement().getText();
    }

    public WebElement link_personalInfo() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("personalInfoLink"));
            AutomationLog.info("Personal Information tab found on Account Settings");
        }
        catch (Exception e)
        {
            AutomationLog.error("Personal Information tab Not found on Account Settings");
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
            AutomationLog.info("Clicked Personal Information Tab");
        }
        catch (Exception e)
        {
            AutomationLog.error("Unable to click Personal Information Tab");
            throw (e);
        }
        return personalInfo;
    }

    public WebElement link_ChangePasswordTab() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("changePasswordLink"));
            AutomationLog.info("Change Password tab found in Account Settings Page");
        }
        catch (Exception e)
        {
            AutomationLog.error("Change Password tab Not found in Account Settings Page");
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
            AutomationLog.info("Clicked Change Password tab");
        }
        catch (Exception e)
        {
            AutomationLog.info("Unable to click Change Password tab");
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