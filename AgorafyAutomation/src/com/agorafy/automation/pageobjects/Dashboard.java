package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.editprofile.OverviewTab;
import com.agorafy.automation.pageobjects.submitlisting.SubmitListingLocationFormPage;
import com.agorafy.automation.pageobjects.subnavigationmenu.MyListings;
import com.agorafy.automation.pageobjects.subnavigationmenu.MySubscriptions;

public class Dashboard extends Page
{
    private WebElement element = null;
    public Dashboard(WebDriver driver)
    {
        super(driver);
    }

    public String getApplicationurl()
    {
    	return applicationUrl();
    }

    public String getCurrentUrl() throws Exception
    {
        return driver.getCurrentUrl();
    }


    public WebElement link_EditProfile() throws Exception
    {
        try
        {
            element = leftMenuLinks().findElement(By.linkText("Edit / View My Profile"));
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
            element = leftMenuLinks().findElement(By.linkText("Account Settings"));
            AutomationLog.info("AccountSettings link found on the Dashboard");
        }
        catch (Exception e)
        {
            AutomationLog.error("AccountSettings link not found on the Dashboard");
            throw (e);
        }
        return element;
    }

    public WebElement btn_SubmitListing() throws Exception
    {
        try
        {
            element = leftMenuLinks().findElement(By.linkText("Submit Listing"));
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
            element = driver.findElement(By.className("fixed-column")).findElements(By.className("menu-list-left")).get(0);
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not find Left Menu links on Dashboard");
            throw(e);
        }
        return element;
    }

    public String getCurrentlyActiveLinkInLeftMenuLinks()
    {
        String activeLinkText = "";
        try
        {
            element = leftMenuLinks().findElement(By.className("active"));
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

    public WebElement page_HeadingSection() throws Exception 
    {
        try
        {
            element = driver.findElement(By.className("page-column")).findElements(By.className("content-block")).get(0);
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find MyDashboard page Heading Section");
            throw(e);
        }
        return element;
    }

    public WebElement text_PageHeading() throws Exception
    {
        try
        {
            element = page_HeadingSection().findElement(By.tagName("h2"));
            AutomationLog.info("Page Heading text found on My Dashboard");
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not find Page Heading text on My Dashboard");
            throw(e);
        }
        return element;
    }

    public String getApplicationURL()
    {
        return applicationUrl();
    }

    public String pageHeading() throws Exception
    {
        return text_PageHeading().getText();
    }

    public WebElement link_MySubscriptions() throws Exception
    {
        try
        {
            element = leftMenuLinks().findElement(By.linkText("My Subscriptions"));
            AutomationLog.info("My Subscriptions link found");
        }
        catch (Exception e)
        {
            AutomationLog.error("My Subscriptions link Not found the Home Page");
            throw (e);
        }
        return element;
    }

    public MySubscriptions clickOnMySubscriptionsLink() throws Exception 
    {
        MySubscriptions mySubscriptions;
        try
        {
            link_MySubscriptions().click();
            mySubscriptions = new MySubscriptions(driver);
            AutomationLog.info("Successfully clicked on My Subscriptions Link");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not clicked on My Subscriptions Link");
            throw(e);
        }
        return mySubscriptions;
    }

    public WebElement link_MyListings() throws Exception
    {
        try
        {
            element = leftMenuLinks().findElement(By.linkText("My Listings"));
            AutomationLog.info("My Listings link found");
        }
        catch (Exception e)
        {
            AutomationLog.error("My Listings link Not found the Home Page");
            throw (e);
        }
        return element;
    }

    public MyListings clickOnMyListingsLink() throws Exception 
    {
        MyListings myListings = null;
                try
        {
            link_MyListings().click();
            myListings = new MyListings(driver);
            AutomationLog.info("Successfully clicked on My Listings Link");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not clicked on My Listings Link");
            throw(e);
        }
        return myListings;
    }
}
