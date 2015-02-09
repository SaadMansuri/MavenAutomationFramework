/*package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.submitlisting.SubmitListingLocationFormPage;

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
            AutomationLog.info("Edit/View profile link found");
        }
        catch (Exception e)
        {
            AutomationLog.error("Edit/View profile link Not found the Home Page");
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

    public WebElement btn_SubmitListing() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[1]/div/a"));
            AutomationLog.info("Submit Listing button found");
        }
        catch (Exception e)
        {
            AutomationLog.error("Submit Listing Button Not found ");
            throw (e);
        }
        return element;
    }

    public SubmitListingLocationFormPage clickOnSubmitListingButton() throws Exception 
    {
        SubmitListingLocationFormPage location = null;
        try
        {
            btn_SubmitListing().click();
            location = new SubmitListingLocationFormPage(driver);
            AutomationLog.info("Successfully clicked on Submit listing button");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not clicked on submit listing button");
            throw(e);
        }
        return location;
    }

    public OverviewTab editProfile() throws Exception
    {
        OverviewTab element = null;
        try
        {
            link_EditProfile().click();
            element = new OverviewTab(driver);
            AutomationLog.info("Edit profile OverviewTab form loaded");
        }
        catch (Exception e)
        {
            AutomationLog.error("Edit profile OverviewTab form Not loaded");
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
}*/


package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.submitlisting.SubmitListingLocationFormPage;

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
            AutomationLog.info("Edit/View profile link found");
        }
        catch (Exception e)
        {
            AutomationLog.error("Edit/View profile link Not found the Home Page");
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

    public WebElement btn_SubmitListing() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[1]/div/a"));
            AutomationLog.info("Submit Listing button found");
        }
        catch (Exception e)
        {
            AutomationLog.error("Submit Listing Button Not found ");
            throw (e);
        }
        return element;
    }

    public SubmitListingLocationFormPage clickOnSubmitListingButton() throws Exception 
    {
        SubmitListingLocationFormPage location = null;
        try
        {
            btn_SubmitListing().click();
            location = new SubmitListingLocationFormPage(driver);
            AutomationLog.info("Successfully clicked on Submit listing button");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not clicked on submit listing button");
            throw(e);
        }
        return location;
    }

    public OverviewTab editProfile() throws Exception
    {
        OverviewTab element = null;
        try
        {
            link_EditProfile().click();
            element = new OverviewTab(driver);
            AutomationLog.info("Edit profile OverviewTab form loaded");
        }
        catch (Exception e)
        {
            AutomationLog.error("Edit profile OverviewTab form Not loaded");
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

    public WebElement element_PageHeading() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[1]/h2"));
            AutomationLog.info("Page heading found on My Dashboard");
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not find Page heading on My Dashboard");
            throw(e);
        }
        return element;
    }

    public String getURL()
    {
        return applicationUrl() + "/manage/dashboard";
    }

    public String pageHeading() throws Exception
    {
        return element_PageHeading().getText();
    }
}
