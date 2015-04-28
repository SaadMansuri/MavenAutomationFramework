package com.agorafy.automation.testcases.updateListing;

import java.util.Collection;
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
import com.agorafy.automation.pageobjects.updatelisting.*;
import com.agorafy.automation.pageobjects.subnavigationmenu.MyListings;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.utilities.HandlingWindows;

public class AvailabilityFormAction extends AutomationTestCaseVerification
{

    Homepage homePage;
    private Header header;
    private HeaderLoginForm headerLoginForm;
    private SubNavigation subNavigation;
    private MyListings myListings;
    private AvailabilityAndDetailsForm updateListingPage;
    private HashMap<String, String> dataFromCSV = new HashMap<>();

    public AvailabilityFormAction()
    {
        super("UpdateListing");
    }

    @Override
    public void setup() 
    {
        super.setup();
        AutomationLog.info("Setup to reach update Listing page of the user started...");
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
            myListings.scrollPage(0, 300);
            myListings.hoverOverFirstListing();
            myListings.hoverOverUpdate();
            updateListingPage = myListings.clickUpdateOfFirstListing();
            HandlingWindows.closeCurrentWindow(Page.driver);
            HandlingWindows.switchToWindow(Page.driver, 1);
            WaitFor.sleepFor(2000);
            AutomationLog.info("Setup to reach update Listing page of the user passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Setup to reach update Listing page of the user failed");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {

        AutomationLog.info("Verify whether after performing click operation over update link for single listing it navigates to update listing page with expected heading");
        verifyUpdateListingPageHeading();

        AutomationLog.info("Verification of email id on update listing page");
        verifyEmailId();

        AutomationLog.info("Verify whether after selecting No radio btn on availability form respective form opens");
        verifyNoRadioBtn();

        AutomationLog.info("Verify whether after selecting No radio btn on availability form reason dropdown has required options");
        verifyReasonDropdown();

        AutomationLog.info("Verify whether after selecting Save and continue btn on availability form it navigates to details form");
        verifySaveAndContinue();
    }

    private void verifySaveAndContinue() throws Exception 
    {
        updateListingPage.btn_SaveAndContinue().click();
        boolean detailsFormStatus = false;
        detailsFormStatus = updateListingPage.form_Details().isDisplayed();
        Assert.assertEquals(detailsFormStatus, true, "After performing click operation on Save And Continue btn on Availability form it should navigate to Detais form");
        AutomationLog.info("After performing click operation on Save And Continue btn on Availability form it does navigate to Detais form");
        updateListingPage.btn_Back().click();
    }

    private void verifyReasonDropdown() throws Exception 
    {
        updateListingPage.radioBtnNo().click();
        updateListingPage.dropdownReason().click();
        Collection<String> actualAllReasonDropdownOptions = updateListingPage.dropdownReasonOptions();
        dataFromCSV = testCaseData.get("ReasonDropdownOptions");
        Collection<String> expectedAllReasonDropdownOptions = dataFromCSV.values();
        boolean flag = compareTwoCollections(actualAllReasonDropdownOptions, expectedAllReasonDropdownOptions);
        Assert.assertEquals(flag, true, "Dropdown options for reason dropdown does not match as expected");
        AutomationLog.info("Dropdown options for reason dropdown does matches as expected");
        updateListingPage.radioBtnYes().click();
    }

	private void verifyNoRadioBtn() throws Exception 
    {
        updateListingPage.radioBtnNo().click();
        boolean actualReasonAndNotesBlockStatus = false;
        actualReasonAndNotesBlockStatus = ( updateListingPage.reasonBlock().isDisplayed() && updateListingPage.notesBlock().isDisplayed());
        Assert.assertEquals(actualReasonAndNotesBlockStatus, true, "After performing click operation on No availability radio btn reason and notes blocks does not open sucessfully"); 
        AutomationLog.info("After performing click operation on No availability radio btn reason and notes blocks opens sucessfully");
        updateListingPage.radioBtnYes().click();
    }

    private void verifyEmailId() throws Exception 
    {
        String actualEmailId = updateListingPage.emailId().getText();
        dataFromCSV = testCaseData.get("EmailIdOnlistingUpdatePage");
        String expectedEmailId = dataFromCSV.get("EmailId");
        Assert.assertEquals(actualEmailId, expectedEmailId, "Email Id does not match with expected email id on listing update page");
        AutomationLog.info("Email Id matches with expected email id on listing update page");
    }

    private void verifyUpdateListingPageHeading() throws Exception 
    {
        String actualUpdateListingPageHeading;
        actualUpdateListingPageHeading = updateListingPage.pageHeading(); 
        dataFromCSV = testCaseData.get("Headings");
        String expectedUpdateListingPageHeading = dataFromCSV.get("PageHeading");
        Assert.assertEquals(actualUpdateListingPageHeading, expectedUpdateListingPageHeading, "Update listing page title is not found as expected");
        AutomationLog.info("Update listing page title is not found as expected");
    }

	
    @Override
    protected String successMessage() 
    {
        return "sucessfully tested update listing availability form action";
    }

    @Override
    protected String failureMessage() 
    {
        return "failed to test update listing availability form action";
    }

}
