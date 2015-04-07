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
    private HashMap<String, String> dataFromCSV = new HashMap<>();

    public UpdateListingAction()
    {
        super();
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
            myListings.pageScrollDown(0, 300);
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
    }

    private void verifyNoRadioBtn() 
    {
        
    	
    }

	private void verifyEmailId() throws Exception 
    {
        /*myListings.hoverOverFirstListing();
        myListings.hoverOverUpdate();
        updateListingPage = myListings.clickUpdateOfFirstListing();
        HandlingWindows.switchToWindow(Page.driver, 2);*/
        String actualEmailId = updateListingPage.emailId().getText();
        dataFromCSV = testCaseData.get("EmailIdOnlistingUpdatePage");
        String expectedEmailId = dataFromCSV.get("EmailId");
        Assert.assertEquals(actualEmailId, expectedEmailId, "Email Id does not match with expected email id on listing update page");
        AutomationLog.info("Email Id matches with expected email id on listing update page");
    }

	private void verifyUpdateListingPageHeading() throws Exception 
    {
        String actualUpdateListingPageHeading;
        /*myListings.hoverOverFirstListing();
        myListings.hoverOverUpdate();
        updateListingPage = myListings.clickUpdateOfFirstListing();
        HandlingWindows.switchToWindow(Page.driver, 2);
        WaitFor.sleepFor(2000);*/
        actualUpdateListingPageHeading = updateListingPage.pageHeading(); 
        dataFromCSV = testCaseData.get("Headings");
        String expectedUpdateListingPageHeading = dataFromCSV.get("PageHeading");
        Assert.assertEquals(actualUpdateListingPageHeading, expectedUpdateListingPageHeading, "Update listing page title is not found as expected");
        AutomationLog.info("Update listing page title is not found as expected");
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
