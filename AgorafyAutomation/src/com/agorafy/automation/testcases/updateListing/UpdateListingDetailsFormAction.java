package com.agorafy.automation.testcases.updateListing;

import java.util.ArrayList;
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
import com.agorafy.automation.pageobjects.UpdateListing;
import com.agorafy.automation.pageobjects.subnavigationmenu.MyListings;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.utilities.HandlingWindows;

public class UpdateListingDetailsFormAction extends AutomationTestCaseVerification
{

    private Homepage homePage;
    private Header header;
    private HeaderLoginForm headerLoginForm;
    private SubNavigation subNavigation;
    private MyListings myListings;
    private UpdateListing updateListingPage;
    private HashMap<String, String> dataFromCSV;

    public UpdateListingDetailsFormAction() 
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
        AutomationLog.info("Verify whether after selecting single family for sale listing it opens respective details form");
        verifySingleFamilyListingForm();

        AutomationLog.info("Verify whether after selecting Hotel for Sale listing it opens respective details form");
        verifyHotelForSaleListingForm();

        AutomationLog.info("Verify whether after selecting Office for Sublease listing it opens respective details form");
        verifyOfficeForSubleaseListingForm();

    }

    private void verifyOfficeForSubleaseListingForm() throws Exception 
    {
        dataFromCSV = testCaseData.get("ListingTypes");
        String listingType = dataFromCSV.get("ListingType3");
        String listingName;
        myListings = subNavigation.clickLinkMyListings();
        WaitFor.sleepFor(2000);
        HashMap<String, String> allListingTypes = new HashMap<>();
        allListingTypes = myListings.allListingTypes();
        listingName = allListingTypes.get(listingType);
        try 
        {
            updateListingPage = myListings.selectRequiredListingsUpdate(listingName);
            AutomationLog.info("Successfully selected required listing");
        }
        catch (Exception e) 
        {
            AutomationLog.error("It may happen that, given listing type is not present on My Listings page, So make sure that given listing type is present on My listings page. Listing type:"+listingType);
        }
        HandlingWindows.closeCurrentWindow(Page.driver);
        HandlingWindows.switchToWindow(Page.driver, 1);
        WaitFor.sleepFor(1000);
        updateListingPage.btn_SaveAndContinue().click();
        int count_NoOfTextBoxes = updateListingPage.count_NoOfTextBoxesInDetailsForm();
        Assert.assertEquals(count_NoOfTextBoxes, 36, "No of text boxes in details form of this type of listing do not matches as expected");
        AutomationLog.info("No of text boxes in details form of this type of listing matches as expected");
        updateListingPage.btn_Back().click();
    }

	private void verifyHotelForSaleListingForm() throws Exception 
    {
        dataFromCSV = testCaseData.get("ListingTypes");
        String listingType = dataFromCSV.get("ListingType2");
        String listingName;
        myListings = subNavigation.clickLinkMyListings();
        WaitFor.sleepFor(2000);
        HashMap<String, String> allListingTypes = new HashMap<>();
        allListingTypes = myListings.allListingTypes();
        listingName = allListingTypes.get(listingType);
        try 
        {
            updateListingPage = myListings.selectRequiredListingsUpdate(listingName);
            AutomationLog.info("Successfully selected required listing");
        }
        catch (Exception e) 
        {
            AutomationLog.error("It may happen that, given listing type is not present on My Listings page, So make sure that given listing type is present on My listings page. Listing type:"+listingType);
        }
        HandlingWindows.closeCurrentWindow(Page.driver);
        HandlingWindows.switchToWindow(Page.driver, 1);
        WaitFor.sleepFor(1000);
        updateListingPage.btn_SaveAndContinue().click();
        int count_NoOfTextBoxes = updateListingPage.count_NoOfTextBoxesInDetailsForm();
        Assert.assertEquals(count_NoOfTextBoxes, 13, "No of text boxes in details form of this type of listing do not matches as expected");
        AutomationLog.info("No of text boxes in details form of this type of listing matches as expected");
    }

    private void verifySingleFamilyListingForm() throws Exception 
    {
        dataFromCSV = testCaseData.get("ListingTypes");
        String listingType = dataFromCSV.get("ListingType1");
        String listingName;
        myListings = subNavigation.clickLinkMyListings();
        WaitFor.sleepFor(2000);
        HashMap<String, String> allListingTypes = new HashMap<>();
        allListingTypes = myListings.allListingTypes();
        listingName = allListingTypes.get(listingType);
        try 
        {
            updateListingPage = myListings.selectRequiredListingsUpdate(listingName);
            AutomationLog.info("Successfully selected required listing");
        }
        catch (Exception e) 
        {
            AutomationLog.error("It may happen that, given listing type is not present on My Listings page, So make sure that given listing type is present on My listings page. Listing type:"+listingType);
        }
        HandlingWindows.closeCurrentWindow(Page.driver);
        HandlingWindows.switchToWindow(Page.driver, 1);
        WaitFor.sleepFor(1000);
        updateListingPage.btn_SaveAndContinue().click();
        int count_NoOfTextBoxes = updateListingPage.count_NoOfTextBoxesInDetailsForm();
        Assert.assertEquals(count_NoOfTextBoxes, 11, "No of text boxes in details form of this type of listing do not matches as expected");
        AutomationLog.info("No of text boxes in details form of this type of listing matches as expected");

        AutomationLog.info("Verification of  Asking price units");
        verifySingleFamilyListingAskingPriceUnits();

        AutomationLog.info("Verification of  details form compulsory fields");
        verifySingleFamilyListingCompulsoryFields();
    }

    private void verifySingleFamilyListingCompulsoryFields() throws Exception 
    {
        updateListingPage.setAskingPrice("");
        dataFromCSV = testCaseData.get("ListingLinkUrls");
        String listinglinkUrl = dataFromCSV.get("ListingLinkUrl1");
        updateListingPage.setListingLinkUrl(listinglinkUrl);
        updateListingPage.setDescription("");
        updateListingPage.btn_SaveAndContinue().click();
        boolean actualDetailsPageStatus = false;
        actualDetailsPageStatus = updateListingPage.form_Details().isDisplayed();
        Assert.assertEquals(actualDetailsPageStatus, true,"After filling details form without any compulsory fields form should not navigate to media form");
        AutomationLog.info("After filling details form without any compulsory fields form does not navigate to media form");
        updateListingPage.btn_Back().click();
    }

	private void verifySingleFamilyListingAskingPriceUnits() throws Exception 
    {
        updateListingPage.dropdown_AskingPriceUnits().click();
        Collection<String> actualAskingPriceUnits = new ArrayList<>();
        actualAskingPriceUnits = updateListingPage.askingPriceUnits();
        dataFromCSV = testCaseData.get("AskingPriceUnits");
        Collection<String> expectedAskingPriceUnits = dataFromCSV.values();
        boolean askingPriceUnitsStatus = false;
        askingPriceUnitsStatus = compareTwoCollections(actualAskingPriceUnits, expectedAskingPriceUnits);
        Assert.assertEquals(askingPriceUnitsStatus, true, "Asking price units are found as expected");
    }

	@Override
    protected String successMessage() 
    {
        return "Successfully tested Update Listing Details Form Action";
    }

    @Override
    protected String failureMessage() 
    {
        return "Failed to test Update Listing Details Form Action";
    }
}
