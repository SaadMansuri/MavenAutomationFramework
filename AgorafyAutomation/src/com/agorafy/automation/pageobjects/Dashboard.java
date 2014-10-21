package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.agorafy.automation.automationframework.AutomationLog;

public class Dashboard extends Page
{
    private WebElement element = null;
    public Dashboard(WebDriver driver)
    {
        super(driver);
    }

    public WebElement link_EditProfile() throws Exception
    {
        try
        {
            element = driver.findElement(By.linkText("Edit / View My Profile"));
            AutomationLog.info("My Edit profile link found on the Home Page");
        }
        catch (Exception e)
        {
            AutomationLog.error("My Edit profile link was not found on the Home Page");
            throw (e);
        }
        return element;
    }

    public WebElement link_AccountSettings() throws Exception
    {
        try
        {
            element = driver.findElement(By.linkText("Account Settings"));
            AutomationLog.info("AccountSetting link found on the Dashboard");
        }
        catch (Exception e)
        {
            AutomationLog.error("AccountSetting link not found on the Dashboard");
            throw (e);
        }
        return element;
    }

    public OverviewTab editProfile() throws Exception
    {
        OverviewTab element = null;
        try
        {
            link_EditProfile().click();
            element = new OverviewTab(driver);
            AutomationLog.info("OverviewTab was opened successfully.");
        }
        catch (Exception e)
        {
            AutomationLog.error("Not able to navigate to overview tab");
            throw (e);
        }
        return element;
    }

    public AccountSettings accountSettings() throws Exception
    {
        AccountSettings element = null;
        try
        {
            link_AccountSettings().click();
            element = new AccountSettings(driver);
            AutomationLog.info("Succesfully Navigated to account Settings page");
        }
        catch (Exception e)
        {
            AutomationLog.error("Not able to Navigate to account Settings page");
            throw (e);
        }
        return element;
    }

    public String link_AccountSettingText() throws Exception
    {
        String accountSettingText = "";
        try
        {
            accountSettingText = link_AccountSettings().getText();
            AutomationLog.info("AccountSetting link Text found on the Dashboard");
        }
        catch (Exception e)
        {
            AutomationLog.error("AccountSetting link Text not found on the Dashboard");
            throw (e);
        }
        return accountSettingText;
    }

    public WebElement leftMenuLinks() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[1]/div/ul"));
            AutomationLog.info("Left Menu found on Dashboard");
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not find Left Menu on Dashboard");
            throw(e);
        }
        return element;
    }

    @SuppressWarnings("static-access")
    public String getCurrentlyActiveLink()
    {
        String activeLinkText = "";
        try
        {
            element = leftMenuLinks().findElement(By.tagName("li").className("active"));
            activeLinkText = element.getText();
        }
        catch (Exception e)
        {
            AutomationLog.error("Left Menu does not show any link active");
        }
        return activeLinkText;
    }

    public PageBanner pageBanner()
    {
        return PageFactory.initElements(driver, PageBanner.class);
    }
}