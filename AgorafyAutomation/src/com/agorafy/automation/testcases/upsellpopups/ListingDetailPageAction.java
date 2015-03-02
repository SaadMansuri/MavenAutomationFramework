package com.agorafy.automation.testcases.upsellpopups;

import java.util.HashMap;
import java.util.Set;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.PropertySearch;
import com.agorafy.automation.pageobjects.upsellpopups.ListingDetailPage;
import com.agorafy.automation.pageobjects.upsellpopups.LoginPopUp;

/**
 * Verify whether login pop up is seen when 'Subscribe to Listing' link is clicked in Logged out state
 * Verify whether login pop up is seen when 'Send Email' link provided below Agent name is clicked in Logged out state
 * Verify whether login pop up is seen when 'Add to Report' link is clicked in Logged out state
 */

public class ListingDetailPageAction extends AutomationTestCaseVerification 
{
    private ListingDetailPage listingDetailPage = null;
    private PropertySearch searchResultsPage = null;

    public ListingDetailPageAction()
    {
        super();
    }

    public void setup()
    {
        listingDetailPage = ListingDetailPage.listingDetailPage();
        try
        {
            super.setup();

            Homepage homepage = Homepage.homePage();
            HashMap<String, String> data = testCaseData.get("SearchData");
            searchResultsPage = homepage.populateSearchTermTextBox(data.get("borough"),data.get("listingcategory"),data.get("searchterm"));
            String handle = Page.driver.getWindowHandle();
            listingDetailPage = searchResultsPage.clickSearchResult();

            Set<String> numbers = Page.driver.getWindowHandles();
            numbers.remove(handle);
            String newHandle = numbers.iterator().next();
            Page.driver.switchTo().window(newHandle);
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not Navigate to Listing Detail Page");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        Credentials validCredentials = userCredentials();
        verifySubscribeToListingLinkUpsell(listingDetailPage,validCredentials);

        preconditionForNextTest();

        verifySendEmailLinkUpsell(listingDetailPage,validCredentials);

        preconditionForNextTest();
        verifyAddToReportLinkUpsell(listingDetailPage,validCredentials);
    }

    public void verifySubscribeToListingLinkUpsell(ListingDetailPage subscribeListingPopup, Credentials getValidCredentials) throws Exception
    {
        ListingDetailPage listingDetailPage;
        try
        {
            boolean loginStatus = false;
            LoginPopUp loginpopup = (LoginPopUp) subscribeListingPopup.clickOnSubscribeToListingLink(loginStatus);
            Assert.assertEquals(loginpopup.checkingLogInPopUp(), true, "Login pop up is not seen after clicking on Subscribe to Listing");
            loginpopup.populateLoginPopUpData(getValidCredentials.getEmail(),getValidCredentials.getPassword());
            listingDetailPage = (ListingDetailPage) loginpopup.clickLoginButtonOnUpsell();
            Assert.assertEquals(listingDetailPage.isUpdateListingLinkPresent(), true, "Login action was unsuccessful");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not send credentials to login pop up of ListingDetailPage");
        }
    }

    public void verifySendEmailLinkUpsell(ListingDetailPage subscribeListingPopup, Credentials getValidCredentials)throws Exception
    {
        LoginPopUp loginpopup = subscribeListingPopup.clickSendEmailLink();
        Assert.assertEquals(loginpopup.checkingLogInPopUp(), true, "Login pop up is not seen after clicking on send email");
        loginpopup.populateLoginPopUpData(getValidCredentials.getEmail(),getValidCredentials.getPassword());
        listingDetailPage = (ListingDetailPage) loginpopup.clickLoginButtonOnUpsell();
        Assert.assertEquals(listingDetailPage.isUpdateListingLinkPresent(), true, "Login action was unsuccessful");
        AutomationLog.info("Test for Send email link Upsell is successful");
    }

    public void verifyAddToReportLinkUpsell(ListingDetailPage subscribeListingPopup, Credentials getValidCredentials)throws Exception
    {
        boolean isLoggedIn = false;
        LoginPopUp loginpopup = (LoginPopUp) subscribeListingPopup.clickOnAddToReportLink(isLoggedIn);
        Assert.assertEquals(loginpopup.checkingLogInPopUp(), true, "Login pop up is not seen after clicking on Add To Report");
        loginpopup.populateLoginPopUpData(getValidCredentials.getEmail(),getValidCredentials.getPassword());
        listingDetailPage = (ListingDetailPage) loginpopup.clickLoginButtonOnUpsell();
        Assert.assertEquals(listingDetailPage.isUpdateListingLinkPresent(), true, "Login action was unsuccessful");
        AutomationLog.info("Test for Add To Report link Upsell is successful");

    }
    public void preconditionForNextTest() throws Exception
    {
        String currentUrl = listingDetailPage.currentURL();
        Page.header().logout();
        Page.driver.get(currentUrl);
    }
@Override
    protected String successMessage()
     {
        return "Test for verifying login pop-ups on listing detail page has Passed";
     }

@Override
    protected String failureMessage()
    {
        return "Test for verifying login pop-ups on listing detail page has Failed";
    }
}
