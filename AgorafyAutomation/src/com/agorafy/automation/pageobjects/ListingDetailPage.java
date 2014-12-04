package com.agorafy.automation.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.agorafy.automation.automationframework.AutomationLog;

public class ListingDetailPage extends Page {

	WebElement element = null;

    public ListingDetailPage(WebDriver driver) 
    {
        super(driver);
    }
    public static ListingDetailPage listingDetailPage()
    {
        return PageFactory.initElements(driver, ListingDetailPage.class);
    }
    public WebElement SubscribeToListingLinkInListingDetailPage() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//*[@id='subscriptionSectionLink']/div/a"));
            AutomationLog.info("Subscribe to listing link found on Listing Detail Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Subscribe to listing link not found on Listing Detail Page");
            throw(e);
        }
         return element;
    }
    public String clickSubscribeToListingLinkInListingDetailPage() throws Exception
    {
        String subscribeToListingPopUp="";
        try
        {
        	SubscribeToListingLinkInListingDetailPage().click();
            AutomationLog.info("Click action performed on SubscribeToListingLink on Listing Detail Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Click action not performed on SubscribeToListingLink on Listing Detail Page");
            throw(e);
         }
         return subscribeToListingPopUp;
    }
    public WebElement UnSubscribeToListingLinkInListingDetailPage() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//*[@id='subscriptionSectionLink']/div[1]/a"));
            AutomationLog.info("UnSubscribe to listing link found on Listing Detail Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("UnSubscribe to listing link not found on Listing Detail Page");
            throw(e);
        }
         return element;
    }
    public String getUnSubscribeToListingLinkTextInListingDetailPage() throws Exception
    {
        String unSubscribeToListing="";
        try
        {
        	unSubscribeToListing = driver.findElement(By.xpath("//*[@id='subscriptionSectionLink']/div[1]/a")).getText();
            AutomationLog.info("UnSubscribeToListingLink Text found after click on SubscribeToListingLink on ListingPage");
        }
        catch(Exception e)
        {
            AutomationLog.error("UnSubscribeToListingLink Text Not found after click on SubscribeToListingLink on ListingPage");
            throw(e);
         }
         return unSubscribeToListing;
    }
    public WebElement userNameInPopupSubscribeToListingLinkInListingDetailPage() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//*[@id='upsellPopup']/form/div[1]/input"));
            AutomationLog.info("Found Username Field on Login popup after click on SubscribeToListingLinkInListingDetailPage");
        }
        catch(Exception e)
        {
            AutomationLog.error("Dind't Found Username Field on Login popup after click on SubscribeToListingLinkInListingDetailPage");
            throw(e);
         }
         return element;
    }

    public WebElement passwordInPopupSubscribeToListingLinkInListingDetailPage() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//*[@id='upsellPopup']/form/div[2]/input"));
            AutomationLog.info("Found Password Field on Login popup after click on SubscribeToListingLinkInListingDetailPage");
        }
        catch(Exception e)
        {
            AutomationLog.error("Dind't Found Username Field on Login popup after click on SubscribeToListingLinkInListingDetailPage");
            throw(e);
         }
         return element;
    }

    public WebElement btnLoginToMyAccountInPopupInSubscribeToListing() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//*[@id='upsellPopup']/form/div[3]/input"));
            AutomationLog.info("LoginToMyAccount button found on Login popup in SubscribeToListingLinkInListingDetailPage");
        }
        catch(Exception e)
        {
            AutomationLog.error("LoginToMyAccount button did not found on Login popup in SubscribeToListingLinkInListingDetailPage");
            throw(e);
         }
         return element;
    }

    public ListingDetailPage populateLoginPopUpDataForListingDetailPage(String Email, String Password ) throws Exception
    {
    	ListingDetailPage listingDetailPage = new ListingDetailPage(driver);
        try
        {
            Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            userNameInPopupSubscribeToListingLinkInListingDetailPage().clear();
            userNameInPopupSubscribeToListingLinkInListingDetailPage().sendKeys(Email);
            passwordInPopupSubscribeToListingLinkInListingDetailPage().clear();
            passwordInPopupSubscribeToListingLinkInListingDetailPage().sendKeys(Password);
            btnLoginToMyAccountInPopupInSubscribeToListing().click();
            AutomationLog.info("Successfully populated data in login pop up of SubscribeToListingLinkInListingDetailPage");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not populate data into login pop up of SubscribeToListingLinkInListingDetailPage");
            throw(e);
        }
        return listingDetailPage;
    }
}
