package com.agorafy.automation.testcases.contentpages.subnavigation;

 import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.updatelisting.*;
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
        String url = myListings.getApplicationUrl() + expectedmyListingsData.get("myListingsPageUrl");
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

    }

    private void verifyAddMediaLink() throws Exception 
    {
        myListings.hoverOverFirstListing();
        mediaPage = myListings.clickAddMediaOfFirstListing();
        HandlingWindows.switchToWindow(Page.driver, 2);
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
