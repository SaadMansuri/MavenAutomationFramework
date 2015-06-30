package com.agorafy.automation.testcases.contentpages.subnavigation;

 import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.updatelisting.*;
import com.agorafy.automation.pageobjects.upsellpopups.LoginPopUp;
import com.agorafy.automation.pageobjects.submitlisting.SubmitListingMediaFormPage;
import com.agorafy.automation.pageobjects.subnavigationmenu.MyListings;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;
import com.agorafy.automation.utilities.HandlingWindows;
import com.agorafy.automation.utilities.Login;
/**
 * Test whether 'My Listings' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 *
 */
public class MyListingsAction extends ContentPagesVerification 
{

    private Homepage homePage;
    private HashMap<String, String> expectedmyListingsData;
    private SubNavigation subnavigation;
    private ContentPagesLeftMenu leftMenu;
    private String actualActiveLeftMenu;
    private String expectedActiveLeftMenu;
    private MyListings myListings;
    private AvailabilityAndDetailsForm updateListingPage;
    private SubmitListingMediaFormPage mediaPage;
    private LoginPopUp loginpopup = new LoginPopUp(Page.driver);

    public MyListingsAction() 
    {
        super();
    }

    @Override
    public void setup() 
    {
        super.setup();
        try 
        {
        subnavigation = Page.subNavigation();
        homePage = Login.doSuccessfullLoginFromHeaderLoginForm();
        WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
        myListings = subnavigation.clickLinkMyListings(); 
        expectedmyListingsData = testCaseData.get("MyListings");
        Page.urlStatus = false;
        String url = myListings.getApplicationurl() + expectedmyListingsData.get("myListingsPageUrl");
        expectedmyListingsData.put("url", url);
        AutomationLog.info("Redirection to MyListing is sucessfull");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Redirection to MyListing is failed");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {

        verifyLink(myListings, expectedmyListingsData);

        AutomationLog.info("Testing whether My Listings link is active in left side started...");
        verifyLeftMenu();

        AutomationLog.info("verify whether update link shows after mouse hovering over single listing");
        verifyUpdateLinkAfterMouseHover();

        AutomationLog.info("verify whether Report Leased link shows after mouse hovering over single listing");
        verifyReportLeasedLinkAfterMouseHover();

        AutomationLog.info("verify whether Renew link shows after mouse hovering over single listing");
        verifyRenewLinkAfterMouseHover();

        AutomationLog.info("verify whether Add Media link shows after mouse hovering over single listing");
        verifyAddMediaLinkAfterMouseHover();

        AutomationLog.info("Verify whether after performing click operation over update link for single listing it navigates to update listing page with same listing");
        verifyUpdateListingLink();

        AutomationLog.info("Verify whether after performing click operation over Add Media link for single listing it navigates to add media page should open");
        verifyAddMediaLink();

        verifySessionExpireTestCases();

    }

    public void verifySessionExpireTestCases() throws Exception
    {
        verifySessionExpireOnUpdateLink();
        verifySessionExpireOnAddMediaLink();
        verifySessionExpireOnReportLeasedLink();
        verifySessionExpireOnRenewLink();
        verifySessionExpireOnScheduleNowLink();
        verifySessionExpireOnOffMarketScheduledLink();
        verifySessionExpireOnOffMarketUpdateLink();
        verifySessionExpireOnOffMarketMediaLink();
    }

    private void verifyAddMediaLink() throws Exception 
    {
        myListings.hoverOverFirstListing();
        mediaPage = myListings.clickAddMediaOfFirstListing();
        HandlingWindows.switchToWindow(Page.driver, 2);
        WaitFor.sleepFor(5000);
        boolean mediaPageStatus = false;
        mediaPageStatus = mediaPage.form_Media().isDisplayed();
        Assert.assertEquals(mediaPageStatus, true, "After performing click operation over Add Media link it does not navigate to media form of update listing");
        AutomationLog.info("After performing click operation over Add Media link it navigates to media form of update listing");
        HandlingWindows.closeCurrentWindow(Page.driver);
        HandlingWindows.switchToWindow(Page.driver, 1);
    }

	private void verifyUpdateListingLink() throws Exception
    {
        String txtFirstListingOnMyListingsPage;
        txtFirstListingOnMyListingsPage = myListings.txt_FirstListing();
        myListings.hoverOverFirstListing();
        myListings.hoverOverUpdate();
        updateListingPage = myListings.clickUpdateOfFirstListing();
        HandlingWindows.switchToWindow(Page.driver, 2);
        WaitFor.sleepFor(5000);
        String txtFirstListingOnUpdateListingPage =  updateListingPage.txt_ListingName();
        Assert.assertEquals(txtFirstListingOnMyListingsPage, txtFirstListingOnUpdateListingPage, "Listing name is not same on My Listing page and Upadte Listing page");
        AutomationLog.info("Listing name is same on My Listing page and Upadte Listing page");
        HandlingWindows.closeCurrentWindow(Page.driver);
        HandlingWindows.switchToWindow(Page.driver, 1);
    }

	private void verifyAddMediaLinkAfterMouseHover() throws Exception 
    {
        boolean actualAddMediaLinkStatus = false;
        myListings.hoverOverFirstListing();
        actualAddMediaLinkStatus = myListings.addMedia().isDisplayed();
        Assert.assertEquals(actualAddMediaLinkStatus, true, "After performing hover operation over first listing Add Media link is not displayed");
        AutomationLog.info("After performing hover operation over first listing Add Media link is displayed successfully");
    }

	private void verifyRenewLinkAfterMouseHover() throws Exception 
    {
        myListings.hoverOverFirstListing();
        boolean actualRenewLinkStatus = false;
        actualRenewLinkStatus = myListings.renew().isDisplayed();
        Assert.assertEquals(actualRenewLinkStatus, true, "After performing hover operation over first listing Renew link is not displayed");
        AutomationLog.info("After performing hover operation over first listing Renew link is displayed successfully");
    }

    private void verifyReportLeasedLinkAfterMouseHover() throws Exception 
    {
        boolean actualReportLeasedLinkStatus = false;
        myListings.hoverOverFirstListing();
        actualReportLeasedLinkStatus = myListings.reportLeased().isDisplayed();
        Assert.assertEquals(actualReportLeasedLinkStatus, true, "After performing hover operation over first listing Report Leased link is not displayed");
        AutomationLog.info("After performing hover operation over first listing Report Leased link is displayed successfully");    	
    }

    private void verifyUpdateLinkAfterMouseHover() throws Exception 
    {
        boolean actualUpdateListingLinkStatus = false;
        myListings.scrollPage(0, 300);
        myListings.hoverOverFirstListing();
        actualUpdateListingLinkStatus = myListings.updateListing().isDisplayed();
        Assert.assertEquals(actualUpdateListingLinkStatus, true, "After performing hover operation over first listing update link is not displayed");
        AutomationLog.info("After performing hover operation over first listing update link is displayed successfully");
    }

    private void verifyLeftMenu() throws Exception 
    {
        leftMenu = Page.contentPagesLeftMenu();
        actualActiveLeftMenu = leftMenu.getCurrentlyActiveLink();
        expectedActiveLeftMenu = leftMenu.MyListingsLinkText();  
        Assert.assertEquals(actualActiveLeftMenu, expectedActiveLeftMenu,"Left menu does not show My Listings link as Active Link");
        AutomationLog.info("Left menu shows My Listings link as Active Link");
    }

    public void verifySessionExpireOnUpdateLink() throws Exception 
    {
        String pageurl = Page.driver.getCurrentUrl();
        String curHandle = Page.driver.getWindowHandle();
        Page.driver.manage().deleteAllCookies();
        myListings.hoverOverFirstListing();
        myListings.clickUpdateOfFirstListing();
        Page.driver.close();
        for(String handle : Page.driver.getWindowHandles())
        {
            if(!handle.equals(curHandle))
            {
                Page.driver.switchTo().window(handle);
                break;
            }
        }
        WaitFor.sleepFor(2000);
        Page.urlStatus = true;
        String expectedUrl = myListings.getApplicationurl() + expectedmyListingsData.get("loginUrl");
        Assert.assertEquals(myListings.getCurrentUrl(), expectedUrl, "Expected page is not shown");
        AutomationLog.info("Clicking Update link on MyListing page after Expiring Session redirects to Login page");
        Login.doSuccessfullLoginFromHeaderLoginForm();
        Page.driver.get(pageurl);
    }

    public void verifySessionExpireOnAddMediaLink() throws Exception
    {
        myListings.scrollPage(0, 300);
        String pageurl = Page.driver.getCurrentUrl();
        String curHandle = Page.driver.getWindowHandle();
        Page.driver.manage().deleteAllCookies();
        myListings.hoverOverFirstListing();
        myListings.hoverOverAddMedia();
        myListings.addMedia().click();
        Page.driver.close();
        for(String handle : Page.driver.getWindowHandles())
        {
            if(!handle.equals(curHandle))
            {
                Page.driver.switchTo().window(handle);
                break;
            }
        }
        WaitFor.sleepFor(2000);
        Page.urlStatus = true;
        String expectedUrl = myListings.getApplicationurl() + expectedmyListingsData.get("loginUrl");
        Assert.assertEquals(myListings.getCurrentUrl(), expectedUrl, "Expected page is not shown");
        AutomationLog.info("Clicking AddMedia link on MyListing page after Expiring Session redirects to Login page");
        Login.doSuccessfullLoginFromHeaderLoginForm();
        Page.driver.get(pageurl);
    }

    public void verifySessionExpireOnReportLeasedLink() throws Exception 
    {
        myListings.scrollPage(0, 300);
        Page.driver.manage().deleteAllCookies();
        myListings.hoverOverFirstListing();
        myListings.hoverOverReportLeased();
        myListings.reportLeased().click();
        WaitFor.sleepFor(5000);
        Assert.assertTrue(myListings.loginPopUpIsDisplayed(loginpopup), "Expected Login PopUp is not Displayed");
        AutomationLog.info("Login PopUp is shown on Clicking Reports Leased Link After session expire");
        myListings.closeLoginPoPup(loginpopup);
    }

    public void verifySessionExpireOnRenewLink() throws Exception 
    {
        myListings.hoverOverFirstListing();
        myListings.hoverOverRenew();
        myListings.renew().click();
        WaitFor.sleepFor(5000);
        Assert.assertTrue(myListings.loginPopUpIsDisplayed(loginpopup), "Expected Login PopUp is not Displayed");
        AutomationLog.info("Login PopUp is shown on Clicking Renew Link After session expire");
        myListings.closeLoginPoPup(loginpopup);
    }

    public void verifySessionExpireOnScheduleNowLink() throws Exception 
    {
        String pageurl = Page.driver.getCurrentUrl();
        Page.driver.manage().deleteAllCookies();
        String listingname = myListings.txt_FirstListing();
        myListings.clickOnScheduleNowLink(listingname);
        WaitFor.sleepFor(2000);
        Page.urlStatus = true;
        String expectedUrl = myListings.getApplicationurl() + expectedmyListingsData.get("loginUrl");
        Assert.assertEquals(myListings.getCurrentUrl(), expectedUrl, "Expected page is not shown");
        AutomationLog.info("Clicking ScheduleNow link after session expire redirects to login page");
        Login.doSuccessfullLoginFromHeaderLoginForm();
        Page.driver.get(pageurl);
    }

    public void verifySessionExpireOnOffMarketScheduledLink() throws Exception
    {
         myListings.scrollPage(0, 300);
         String pageurl = Page.driver.getCurrentUrl();
         Page.driver.manage().deleteAllCookies();
         myListings.link_OffMarket().click();
         myListings.ClickOnScheduledLink();
         WaitFor.sleepFor(2000);
         Page.urlStatus = true;
         String expectedUrl = myListings.getApplicationurl() + expectedmyListingsData.get("loginUrl");
         Assert.assertEquals(myListings.getCurrentUrl(), expectedUrl, "Expected page is not shown");
         AutomationLog.info("Clicking Scheduled link after session expire redirects to login page");
         WaitFor.sleepFor(2000);
         Login.doSuccessfullLoginFromHeaderLoginForm();
         Page.driver.get(pageurl);
    }

    public void verifySessionExpireOnOffMarketUpdateLink() throws Exception 
    {
        myListings.link_OffMarket().click();
        myListings.scrollPage(0, 300);
        String pageurl = Page.driver.getCurrentUrl();
        String curHandle = Page.driver.getWindowHandle();
        Page.driver.manage().deleteAllCookies();
        myListings.hoverOverFirstOffMarketListing();
        myListings.clickUpdateOfFirstListingOffMarket();
        Page.driver.close();
        for(String handle : Page.driver.getWindowHandles())
        {
            if(!handle.equals(curHandle))
            {
                Page.driver.switchTo().window(handle);
                break;
            }
        }
        WaitFor.sleepFor(2000);
        Page.urlStatus = true;
        String expectedUrl = myListings.getApplicationurl() + expectedmyListingsData.get("loginUrl");
        Assert.assertEquals(myListings.getCurrentUrl(), expectedUrl, "Expected page is not shown");
        AutomationLog.info("Clicking First off market Update link after Expiring Session redirects to Login page");
        Login.doSuccessfullLoginFromHeaderLoginForm();
        Page.driver.get(pageurl);
    }

    public void verifySessionExpireOnOffMarketMediaLink() throws Exception 
    {
        myListings.link_OffMarket().click();
        myListings.scrollPage(0, 300);
        String pageurl = Page.driver.getCurrentUrl();
        String curHandle = Page.driver.getWindowHandle();
        Page.driver.manage().deleteAllCookies();
        myListings.hoverOverFirstOffMarketListing();
        myListings.clickAddMediaOfFirstListingOffMarket();
        Page.driver.close();
        for(String handle : Page.driver.getWindowHandles())
        {
            if(!handle.equals(curHandle))
            {
                Page.driver.switchTo().window(handle);
                break;
            }
        }
        WaitFor.sleepFor(2000);
        Page.urlStatus = true;
        String expectedUrl = myListings.getApplicationurl() + expectedmyListingsData.get("loginUrl");
        Assert.assertEquals(myListings.getCurrentUrl(), expectedUrl, "Expected page is not shown");
        AutomationLog.info("Clicking AddMedia link on MyListing page after Expiring Session redirects to Login page");
        Login.doSuccessfullLoginFromHeaderLoginForm();
        Page.driver.get(pageurl);
    }

    @Override
    protected String successMessage() 
    {
        return "Sucessfully tested My Listing page";
    }

    @Override
    protected String failureMessage() 
    {
        return "Failed to test My listing page";
    }

}
