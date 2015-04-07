package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.UpdateListing;
import com.agorafy.automation.pageobjects.submitlisting.SubmitListingMediaFormPage;
import com.agorafy.automation.pageobjects.subnavigationmenu.MyListings;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.utilities.HandlingWindows;

public class UpdateListingAction extends AutomationTestCaseVerification
{

    Homepage homePage;
    private Header header;
    private HeaderLoginForm headerLoginForm;
    private SubNavigation subNavigation;
    private MyListings myListings;
    private UpdateListing updateListingPage;
    private SubmitListingMediaFormPage mediaPage;
    private HashMap<String, String> dataFromCSV = new HashMap<>();

    public UpdateListingAction()
    {
        super();
    }

    @Override
    public void setup() 
    {
        super.setup();
        AutomationLog.info("Setup to reach My Listings page of the user started...");
        try 
        {
            homePage = Homepage.homePage();
            header = Header.header();
            headerLoginForm = header.openHeaderLoginForm();
            Credentials ValidCredentials = userCredentials();
            homePage = headerLoginForm.doSuccessfulLogin(ValidCredentials.getEmail(), ValidCredentials.getPassword());
            WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
            subNavigation = SubNavigation.subNavigation();
            myListings = subNavigation.clickLinkMyListings();
            AutomationLog.info("Setup to reach My Listings page of the user passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Setup to reach My Listings page of the user failed");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
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

        AutomationLog.info("Verify whether after performing click operation over update link for single listing it navigates to update listing page with expected heading");
        verifyUpdateListingPageHeading();

        AutomationLog.info("Verification of email id on update listing page");
        verifyEmailId();

        AutomationLog.info("Verify whether after selecting No radio btn on availability form respective form opens");
        verifyNoRadioBtn();
    }

    private void verifyNoRadioBtn() 
    {
        
    	
    }

	private void verifyEmailId() throws Exception 
    {
        myListings.hoverOverFirstListing();
        myListings.hoverOverUpdate();
        updateListingPage = myListings.clickUpdateOfFirstListing();
        HandlingWindows.switchToWindow(Page.driver, 2);
        String actualEmailId = updateListingPage.emailId().getText();
        dataFromCSV = testCaseData.get("EmailIdOnlistingUpdatePage");
        String expectedEmailId = dataFromCSV.get("EmailId");
        Assert.assertEquals(actualEmailId, expectedEmailId, "Email Id does not match with expected email id on listing update page");
        AutomationLog.info("Email Id matches with expected email id on listing update page");
        HandlingWindows.closeCurrentWindow(Page.driver);
        HandlingWindows.switchToWindow(Page.driver, 1);
    }

	private void verifyUpdateListingPageHeading() throws Exception 
    {
        String actualUpdateListingPageHeading;
        myListings.hoverOverFirstListing();
        myListings.hoverOverUpdate();
        updateListingPage = myListings.clickUpdateOfFirstListing();
        HandlingWindows.switchToWindow(Page.driver, 2);
        WaitFor.sleepFor(2000);
        actualUpdateListingPageHeading = updateListingPage.pageHeading(); 
        dataFromCSV = testCaseData.get("Headings");
        String expectedUpdateListingPageHeading = dataFromCSV.get("PageHeading");
        Assert.assertEquals(actualUpdateListingPageHeading, expectedUpdateListingPageHeading, "Update listing page title is not found as expected");
        AutomationLog.info("Update listing page title is not found as expected");
        HandlingWindows.closeCurrentWindow(Page.driver);
        HandlingWindows.switchToWindow(Page.driver, 1);
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
        myListings.pageScrollDown(0, 300);
        myListings.hoverOverFirstListing();
        actualUpdateListingLinkStatus = myListings.updateListing().isDisplayed();
        Assert.assertEquals(actualUpdateListingLinkStatus, true, "After performing hover operation over first listing update link is not displayed");
        AutomationLog.info("After performing hover operation over first listing update link is displayed successfully");
    }

    @Override
    protected String successMessage() 
    {
        return "sucessfully tested update listing action";
    }

    @Override
    protected String failureMessage() 
    {
        return "failed to test update listing action";
    }

}
