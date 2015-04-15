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
	private Integer noOfSpaceAdded;

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

        AutomationLog.info("Verify whether after selecting Condo for sale listing it opens respective details form");
        verifyCondoForSaleListingForm();
    }

    private void verifyCondoForSaleListingForm() throws Exception 
    {
        dataFromCSV = testCaseData.get("ListingTypes");
        String listingType = dataFromCSV.get("ListingType4");
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
        Assert.assertEquals(count_NoOfTextBoxes, 19, "No of text boxes in details form of this type of listing do not matches as expected");
        AutomationLog.info("No of text boxes in details form of this type of listing matches as expected");

        AutomationLog.info("Verify that Aasking price should have $ sign before amount");
        verifyDollarSignInAskingPriceInCondoForSale();

        AutomationLog.info("Verification of  details form without compulsory fields");
        verifyCondoForSaleWithoutCompulsoryFields();

        AutomationLog.info("Verification of  details form with compulsory fields only");
        verifyCondoForSaleWithCompulsoryFields();

        AutomationLog.info("Verification of  details form with empty fields");
        verifyCondoForSaleEmptyFields();
    }

    private void verifyCondoForSaleEmptyFields() throws Exception 
    {
        clearCondoForSaleListing();
        updateListingPage.btn_SaveAndContinueOnDetailsForm().click();
        boolean actualDetailsPageStatus = false;
        actualDetailsPageStatus = updateListingPage.form_Details().isDisplayed();
        Assert.assertEquals(actualDetailsPageStatus, true,"After filling details form with empty form should not navigate to media form");
        AutomationLog.info("After filling details form with empty form does not navigate to media form");
    }

	private void verifyCondoForSaleWithCompulsoryFields() throws Exception 
    {
        updateListingPage.txt_PropertyName().clear();
        dataFromCSV = testCaseData.get("SpaceSizes");
        updateListingPage.txt_SpaceSizeMin().clear();
        updateListingPage.setSpaceSizeMin(dataFromCSV.get("SpaceSizeMin"));
        updateListingPage.txt_SpaceSizeMax().clear();
        updateListingPage.setSpaceSizeMax(dataFromCSV.get("SpaceSizeMax"));
        dataFromCSV = testCaseData.get("AskingPrices");
        updateListingPage.txt_AskingPriceMin().clear();
        updateListingPage.setAskingPriceMin(dataFromCSV.get("AskingPriceMin"));
        updateListingPage.txt_AskingPriceMax().clear();
        updateListingPage.setAskingPriceMax(dataFromCSV.get("AskingPriceMax"));
        dataFromCSV = testCaseData.get("Bedrooms");
        updateListingPage.txt_Bedrooms().clear();
        updateListingPage.txt_Bedrooms().sendKeys(dataFromCSV.get("Bedroom1"));
        dataFromCSV = testCaseData.get("Bathrooms");
        updateListingPage.txt_Bathrooms().clear();
        updateListingPage.txt_Bathrooms().sendKeys(dataFromCSV.get("Bathroom1"));
        updateListingPage.txt_Description().clear();
        updateListingPage.btn_SaveAndContinueOnDetailsForm().click();
        boolean actualMediaFormStatus = false;
        actualMediaFormStatus = updateListingPage.form_Media().isDisplayed();
        Assert.assertEquals(actualMediaFormStatus, true, "After filling details form with compulsory fields only it should navigate to media form");
        AutomationLog.info("After filling details form with compulsory fields only it navigate to media form");
        updateListingPage.btn_BackOnMediaForm().click();
    }

    private void verifyCondoForSaleWithoutCompulsoryFields() throws Exception 
    {
        updateListingPage.txt_PropertyName().clear();
        dataFromCSV = testCaseData.get("PropertyNames");
        updateListingPage.txt_PropertyName().sendKeys(dataFromCSV.get("PropertyName1"));
        updateListingPage.txt_SpaceSizeMin().clear();
        updateListingPage.txt_SpaceSizeMax().clear();
        updateListingPage.txt_AskingPriceMin().clear();
        updateListingPage.txt_AskingPriceMax().clear();
        updateListingPage.txt_Bedrooms().clear();
        updateListingPage.txt_Bathrooms().clear();
        dataFromCSV = testCaseData.get("DetailsDescription");
        updateListingPage.txt_Description().clear();
        updateListingPage.setDescription(dataFromCSV.get("Description"));
        updateListingPage.btn_SaveAndContinueOnDetailsForm().click();
        boolean actualDetailsPageStatus = false;
        actualDetailsPageStatus = updateListingPage.form_Details().isDisplayed();
        Assert.assertEquals(actualDetailsPageStatus, true,"After filling details form without any compulsory fields form should not navigate to media form");
        AutomationLog.info("After filling details form without any compulsory fields form does not navigate to media form");
    }

	private void verifyDollarSignInAskingPriceInCondoForSale() throws Exception 
    {
        String actualAskingPriceMin = updateListingPage.txt_AskingPriceMin().getAttribute("value");
        String actualAskingPriceMax = updateListingPage.txt_AskingPriceMax().getAttribute("value");
        boolean actualDollarSignStatusInAskingPriceMin = false;
        boolean actualDollarSignStatusInAskingPriceMax = false;
        actualDollarSignStatusInAskingPriceMin = actualAskingPriceMin.contains("$");
        actualDollarSignStatusInAskingPriceMax = actualAskingPriceMax.contains("$");
        boolean actualAskingPriceStatus = false;
        actualAskingPriceStatus = ( actualDollarSignStatusInAskingPriceMin && actualDollarSignStatusInAskingPriceMax); 
        Assert.assertEquals(actualAskingPriceStatus, true, "Asking price Min/Max should contain dollar sign before price");
        AutomationLog.info("Asking price Min/Max contains dollar sign before price");
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

        AutomationLog.info("Verification of  Asking price units");
        verifyAskingPriceUnitsForOfficeForSublease();

        AutomationLog.info("Verification of  details form without compulsory fields");
        verifyOfficeForSubleaseWithoutCompulsoryFields();

        AutomationLog.info("Verification of  details form with compulsory fields only");
        verifyOfficeForSubleaseWithCompulsoryFields();

        AutomationLog.info("Verification of  details form with empty fields");
        verifyOfficeForSubleaseEmptyFields();
    }

    private void verifyOfficeForSubleaseEmptyFields() throws Exception 
    {
        clearOfficeForSubleaseDetailsForm();
        updateListingPage.btn_SaveAndContinueOnDetailsForm().click();
        boolean actualDetailsPageStatus = false;
        actualDetailsPageStatus = updateListingPage.form_Details().isDisplayed();
        Assert.assertEquals(actualDetailsPageStatus, true,"After filling details form with empty form should not navigate to media form");
        AutomationLog.info("After filling details form with empty form does not navigate to media form");
    }

	private void verifyOfficeForSubleaseWithCompulsoryFields() throws Exception 
    {
        addSpace();
        dataFromCSV = testCaseData.get("AskingPrices");
        updateListingPage.txt_AskingPrice().clear();
        updateListingPage.setAskingPrice(dataFromCSV.get("AskingPrice1"));
        updateListingPage.txt_CeilingHeight().clear();
        dataFromCSV = testCaseData.get("CeilingHeights");
        updateListingPage.txt_CeilingHeight().clear();
        updateListingPage.setCeilingHeight(dataFromCSV.get("CeilingHeight1"));
        updateListingPage.txt_Combinable().clear();
        updateListingPage.txt_Electricity().clear();
        updateListingPage.txt_Description().clear();
        updateListingPage.btn_SaveAndContinueOnDetailsForm().click();
        boolean actualMediaFormStatus = false;
        actualMediaFormStatus = updateListingPage.form_Media().isDisplayed();
        Assert.assertEquals(actualMediaFormStatus, true, "After filling details form with compulsory fields only it should navigate to media form");
        AutomationLog.info("After filling details form with compulsory fields only it navigate to media form");
        updateListingPage.btn_BackOnMediaForm().click();
    }

    private void addSpace() throws Exception 
    {
        dataFromCSV = testCaseData.get("SpaceTypes");
        updateListingPage.selectSpaceType(dataFromCSV.get("SpaceType1"));
        updateListingPage.selectSpaceName();
        dataFromCSV = testCaseData.get("SpaceSizes");
        updateListingPage.txt_SpaceSize().clear();
        updateListingPage.setSpaceSize(dataFromCSV.get("SpaceSize1"));
        updateListingPage.btn_AddSpace().click();
    }

    private void verifyOfficeForSubleaseWithoutCompulsoryFields() throws Exception 
    {
        noOfSpaceAdded = updateListingPage.noOfSpacesAdded();
        if(noOfSpaceAdded != 0)
        updateListingPage.deleteAllSpaces();
        updateListingPage.txt_AskingPrice().clear();
        updateListingPage.txt_CeilingHeight().clear();
        dataFromCSV = testCaseData.get("CombinableOption");
        updateListingPage.txt_Combinable().clear();
        updateListingPage.setCombinable(dataFromCSV.get("Combinable"));
        dataFromCSV = testCaseData.get("Electricity");
        updateListingPage.txt_Electricity().clear();
        updateListingPage.setElectricity(dataFromCSV.get("ElectricityOption"));
        dataFromCSV = testCaseData.get("DetailsDescription");
        updateListingPage.txt_Description().clear();
        updateListingPage.setDescription(dataFromCSV.get("Description"));
        updateListingPage.btn_SaveAndContinueOnDetailsForm().click();
        boolean actualDetailsPageStatus = false;
        actualDetailsPageStatus = updateListingPage.form_Details().isDisplayed();
        Assert.assertEquals(actualDetailsPageStatus, true,"After filling details form without any compulsory fields form should not navigate to media form");
        AutomationLog.info("After filling details form without any compulsory fields form stays on same details form");
    }

	private void verifyAskingPriceUnitsForOfficeForSublease() throws Exception 
    {
        updateListingPage.dropdown_AskingPriceUnits().click();
        Collection<String> actualAskingPriceUnits = new ArrayList<>();
        actualAskingPriceUnits = updateListingPage.askingPriceUnits();
        dataFromCSV = testCaseData.get("AskingPriceUnitsForofficeForSublease");
        Collection<String> expectedAskingPriceUnits = dataFromCSV.values();
        boolean askingPriceUnitsStatus = false;
        askingPriceUnitsStatus = compareTwoCollections(actualAskingPriceUnits, expectedAskingPriceUnits);
        Assert.assertEquals(askingPriceUnitsStatus, true, "Asking price units are found as expected");
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

        AutomationLog.info("Verify that Aasking price should have $ sign before amount");
        verifyDollarSignInAskingPrice();

        AutomationLog.info("Verification of  Asking price units");
        verifyAskingPriceUnits();

        AutomationLog.info("Verification of  details form without compulsory fields");
        verifyHotelForSaleWithoutCompulsoryFields();

        AutomationLog.info("Verification of  details form with compulsory fields only");
        verifyHotelForSaleWithCompulsoryFields();

        AutomationLog.info("Verification of  details form empty fields only");
        verifyHotelForSaleEmptyDetailsForm();

    }

    private void verifyHotelForSaleEmptyDetailsForm() throws Exception 
    {
        clearHotelForSaleDetailsForm();
        updateListingPage.btn_SaveAndContinueOnDetailsForm().click();
        boolean actualDetailsPageStatus = false;
        actualDetailsPageStatus = updateListingPage.form_Details().isDisplayed();
        Assert.assertEquals(actualDetailsPageStatus, true,"After filling details form with empty form should not navigate to media form");
        AutomationLog.info("After filling details form with empty form does not navigate to media form");
    }

	private void verifyHotelForSaleWithCompulsoryFields() throws Exception 
    {
        dataFromCSV = testCaseData.get("AskingPrices");
        updateListingPage.setAskingPrice(dataFromCSV.get("AskingPrice1"));
        updateListingPage.txt_ListingLink().clear();
        updateListingPage.txt_BidDeadline().clear();
        dataFromCSV = testCaseData.get("DetailsDescription");
        updateListingPage.setDescription(dataFromCSV.get("Description"));
        updateListingPage.btn_SaveAndContinueOnDetailsForm().click();
        boolean actualMediaFormStatus = false;
        actualMediaFormStatus = updateListingPage.form_Media().isDisplayed();
        Assert.assertEquals(actualMediaFormStatus, true, "After filling details form with compulsory fields only it should navigate to media form");
        AutomationLog.info("After filling details form with compulsory fields only it navigate to media form");
        updateListingPage.btn_BackOnMediaForm().click();
    }

    private void verifyHotelForSaleWithoutCompulsoryFields() throws Exception 
    {
        updateListingPage.txt_AskingPrice().clear();;
        dataFromCSV = testCaseData.get("ListingLinkUrls");
        String listinglinkUrl = dataFromCSV.get("ListingLinkUrl1");
        updateListingPage.setListingLinkUrl(listinglinkUrl);
        dataFromCSV = testCaseData.get("BidDeadlines");
        updateListingPage.setBidDeadline(dataFromCSV.get("BidDeadline"));
        updateListingPage.txt_Description().clear();
        updateListingPage.btn_SaveAndContinueOnDetailsForm().click();
        boolean actualDetailsPageStatus = false;
        actualDetailsPageStatus = updateListingPage.form_Details().isDisplayed();
        Assert.assertEquals(actualDetailsPageStatus, true,"After filling details form without any compulsory fields form should not navigate to media form");
        AutomationLog.info("After filling details form without any compulsory fields form does not navigate to media form");
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

        AutomationLog.info("Verify that Aasking price should have $ sign before amount");
        verifyDollarSignInAskingPrice();

        AutomationLog.info("Verification of  Asking price units");
        verifyAskingPriceUnits();

        AutomationLog.info("Verification of  details form without compulsory fields");
        verifySingleFamilyListingWithoutCompulsoryFields();

        AutomationLog.info("Verification of  details form with compulsory fields only");
        verifySingleFamilyListingWithCompulsoryFields();

        AutomationLog.info("Verification of  details form with all fields ");
        verifySingleFamilyListingWithAllFields();

        AutomationLog.info("Verification of  details form with empty fields ");
        verifySingleFamilyListingWithEmptyFields();
        }

    private void verifySingleFamilyListingWithEmptyFields() throws Exception 
    {
        clearSingleFamilyListingDetailsForm();
        updateListingPage.btn_SaveAndContinueOnDetailsForm().click();
        boolean actualDetailsPageStatus = false;
        actualDetailsPageStatus = updateListingPage.form_Details().isDisplayed();
        Assert.assertEquals(actualDetailsPageStatus, true,"After filling details form with empty form should not navigate to media form");
        AutomationLog.info("After filling details form with empty form does not navigate to media form");
    }

    private void clearSingleFamilyListingDetailsForm() throws Exception 
    {
        updateListingPage.txt_AskingPrice().clear();
        updateListingPage.txt_ListingLink().clear();
        updateListingPage.txt_Description().clear();
    }

    private void clearHotelForSaleDetailsForm() throws Exception 
    {
        updateListingPage.txt_AskingPrice().clear();
        updateListingPage.txt_ListingLink().clear();
        updateListingPage.txt_BidDeadline().clear();
        updateListingPage.txt_Description().clear();
    }

    private void clearOfficeForSubleaseDetailsForm() throws Exception 
    {
        noOfSpaceAdded = updateListingPage.noOfSpacesAdded();
        if(noOfSpaceAdded != 0)
        updateListingPage.deleteAllSpaces();
        updateListingPage.txt_AskingPrice().clear();
        updateListingPage.txt_CeilingHeight().clear();
        updateListingPage.txt_Combinable().clear();
        updateListingPage.txt_Electricity().clear();
        updateListingPage.txt_Description().clear();
    }

    private void clearCondoForSaleListing() throws Exception 
    {
        updateListingPage.txt_PropertyName().clear();
        updateListingPage.txt_SpaceSizeMin().clear();
        updateListingPage.txt_SpaceSizeMax().clear();
        updateListingPage.txt_AskingPriceMin().clear();
        updateListingPage.txt_AskingPriceMax().clear();
        updateListingPage.txt_Bedrooms().clear();
        updateListingPage.txt_Bathrooms().clear();
        updateListingPage.txt_Description().clear();
    }

    private void verifySingleFamilyListingWithAllFields() throws Exception 
    {
        dataFromCSV = testCaseData.get("AskingPrices");
        updateListingPage.txt_AskingPrice().clear();
        updateListingPage.txt_AskingPrice().sendKeys((dataFromCSV.get("AskingPrice1")));
        updateListingPage.txt_ListingLink().clear();
        dataFromCSV = testCaseData.get("ListingLinkUrls");
        updateListingPage.txt_ListingLink().sendKeys(dataFromCSV.get("ListingLinkUrl1"));
        updateListingPage.txt_Description().clear();
        dataFromCSV = testCaseData.get("DetailsDescription");
        updateListingPage.txt_Description().sendKeys(dataFromCSV.get("Description"));
        updateListingPage.btn_SaveAndContinueOnDetailsForm().click();
        boolean actualMediaFormStatus = false;
        actualMediaFormStatus = updateListingPage.form_Media().isDisplayed();
        Assert.assertEquals(actualMediaFormStatus, true, "After filling details form with compulsory fields only it should navigate to media form");
        AutomationLog.info("After filling details form with compulsory fields only it navigate to media form");
        updateListingPage.btn_BackOnMediaForm().click();
    }

	private void verifyDollarSignInAskingPrice() throws Exception 
    {
         String askingPrice = updateListingPage.txt_AskingPrice().getAttribute("value");
         boolean actualDollarSignStatus = false;
         actualDollarSignStatus = askingPrice.contains("$");
         Assert.assertEquals(actualDollarSignStatus, true, "Asking price should contain dollar sign before price");
         AutomationLog.info("Asking price contains dollar sign before price");
    }

	private void verifySingleFamilyListingWithCompulsoryFields() throws Exception 
    {
        dataFromCSV = testCaseData.get("AskingPrices");
        updateListingPage.setAskingPrice(dataFromCSV.get("AskingPrice1"));
        updateListingPage.txt_ListingLink().clear();
        dataFromCSV = testCaseData.get("DetailsDescription");
        updateListingPage.setDescription(dataFromCSV.get("Description"));
        updateListingPage.btn_SaveAndContinueOnDetailsForm().click();
        boolean actualMediaFormStatus = false;
        actualMediaFormStatus = updateListingPage.form_Media().isDisplayed();
        Assert.assertEquals(actualMediaFormStatus, true, "After filling details form with compulsory fields only it should navigate to media form");
        AutomationLog.info("After filling details form with compulsory fields only it navigate to media form");
        updateListingPage.btn_BackOnMediaForm().click();
    }

    private void verifySingleFamilyListingWithoutCompulsoryFields() throws Exception 
    {
        updateListingPage.txt_AskingPrice().clear();;
        dataFromCSV = testCaseData.get("ListingLinkUrls");
        String listinglinkUrl = dataFromCSV.get("ListingLinkUrl1");
        updateListingPage.setListingLinkUrl(listinglinkUrl);
        updateListingPage.txt_Description().clear();
        updateListingPage.btn_SaveAndContinueOnDetailsForm().click();
        boolean actualDetailsPageStatus = false;
        actualDetailsPageStatus = updateListingPage.form_Details().isDisplayed();
        Assert.assertEquals(actualDetailsPageStatus, true,"After filling details form without any compulsory fields form should not navigate to media form");
        AutomationLog.info("After filling details form without any compulsory fields form does not navigate to media form");
    }

	private void verifyAskingPriceUnits() throws Exception 
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
