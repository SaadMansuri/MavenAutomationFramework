package com.agorafy.automation.testcases.updateListing;


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
import com.agorafy.automation.pageobjects.subnavigationmenu.MyListings;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.pageobjects.updatelisting.AvailabilityAndDetailsForm;
import com.agorafy.automation.pageobjects.updatelisting.ContactsForm;
import com.agorafy.automation.pageobjects.updatelisting.MediaForm;
import com.agorafy.automation.pageobjects.updatelisting.PreviewAndSubmitForm;
import com.agorafy.automation.utilities.HandlingWindows;

public class PreviewAndSubmitAction extends AutomationTestCaseVerification
{

    private SubNavigation subNavigation;
    private MyListings myListings;
    private AvailabilityAndDetailsForm availabilityForm;
    private ContactsForm contacts;
    private PreviewAndSubmitForm preview;
    private HashMap<String, String> dataFromCSV = new HashMap<>();
    private Homepage homePage;
    private Header header;
    private HeaderLoginForm headerLoginForm;
    private MediaForm mediaForm;

    public PreviewAndSubmitAction() 
    {
        super("UpdateListing");
    }

    @Override
    public void setup() 
    {
         super.setup();
         try
         {
             AutomationLog.info("Setup to reach preview and submit form started...");
             homePage = Homepage.homePage();
             header = Header.header();
             headerLoginForm = header.openHeaderLoginForm();
             Credentials ValidCredentials = userCredentials();
             homePage = headerLoginForm.doSuccessfulLogin(ValidCredentials.getEmail(), ValidCredentials.getPassword());
             WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
             subNavigation = SubNavigation.subNavigation();
             myListings = subNavigation.clickLinkMyListings();
             selectListingType();
             editAllForms();
             AutomationLog.info("Setup to reach preview and submit form successful");
         }
         catch(Exception e)
         {
             AutomationLog.error("Failed to reach preview and submit form");
         }
    }

    private void editAllForms() throws Exception 
    {
        editAvailabilityForm();
        editDetailsForm();
        editMediaForm();
        editContactForm();
    }

    private void editContactForm() throws Exception 
    {
        contacts.clickEditIconOnAddedContact();
        dataFromCSV = testCaseData.get("ContactOwner");
        contacts.txt_AddedContactName().sendKeys(dataFromCSV.get("Name1"));
        dataFromCSV = testCaseData.get("RepresentingAsOptions");
        contacts.selectValueFromRepresentingAsDropDown(dataFromCSV.get("RepresentingAsOption3"));
        dataFromCSV = testCaseData.get("CompanyNames");
        contacts.txtbx_Company().sendKeys(dataFromCSV.get("CompanyName1"));
        dataFromCSV = testCaseData.get("EmailIds");
        contacts.txtbx_Email().sendKeys(dataFromCSV.get("Email1"));
        dataFromCSV = testCaseData.get("Phones");
        contacts.txtbx_Phone().sendKeys(dataFromCSV.get("Phone1"));
        dataFromCSV = testCaseData.get("Addresses");
        contacts.txtbx_Address().sendKeys(dataFromCSV.get("Address1"));
        contacts.btn_SaveContact();
        contacts.btn_SaveAndContinue();
        AutomationLog.info("Succesfully edited selected contact");
    }

	private void editMediaForm() throws Exception 
    {
        contacts = mediaForm.clickOnSaveAndContinueButton();
	}

	private void editDetailsForm() throws Exception 
    {
        dataFromCSV = testCaseData.get("AskingPrices");
        availabilityForm.txt_AskingPrice().sendKeys(dataFromCSV.get("AskingPrice2"));
        dataFromCSV = testCaseData.get("ListingLinkUrls");
        availabilityForm.txt_ListingLink().sendKeys(dataFromCSV.get("ListingLinkUrl2"));
        dataFromCSV = testCaseData.get("DetailsDescription");
        availabilityForm.txt_Description().sendKeys(dataFromCSV.get("Description1"));
        mediaForm = availabilityForm.clickSaveAndContinueOnDetailsForm();
        AutomationLog.info("Successfully filled details form");
    }

    private void editAvailabilityForm() throws Exception 
    {
        availabilityForm.radioBtnYes().click();
        availabilityForm.btn_SaveAndContinue().click();
        AutomationLog.info("Availability form filled successfully");
    }

	private void selectListingType() throws Exception 
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
        	availabilityForm = myListings.selectRequiredListingsUpdate(listingName);
            AutomationLog.info("Successfully selected required listing");
        }
        catch (Exception e) 
        {
            AutomationLog.error("It may happen that, given listing type is not present on My Listings page, So make sure that given listing type is present on My listings page. Listing type:"+listingType);
        }
        HandlingWindows.closeCurrentWindow(Page.driver);
        HandlingWindows.switchToWindow(Page.driver, 1);
        WaitFor.sleepFor(1000);
        AutomationLog.info("setup to select specific listing passed");
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
        verifyIfPreviewAndSubmitContainsAllListingForms();
        verifyDifferentFormsDataOnPreviewAndSubmitForm();
    }

    public void verifyIfPreviewAndSubmitContainsAllListingForms() throws Exception
    {
        Assert.assertEquals(preview.location_Displayed(), true, "Expected Loaction form is not shown");
        Assert.assertEquals(preview.Details_Displayed(), true, "Expected Property Details form is not shown");
        Assert.assertEquals(preview.Media_Displayed(), true, "Expected Media form is not shown");
        Assert.assertEquals(preview.Contacts_Displayed(), true, "Expected contacts form is not shown");
        AutomationLog.info("Preview and Submit contains all four Listings form");
    }

    public void verifyDifferentFormsDataOnPreviewAndSubmitForm() throws Exception
    {
        setupToReachPreviewAndSubmitPageWithSpecificData();
        testAvailabilityFormData();
        testDetailsFormData();
        testMediaFormData();
        testContactsFormData();
    }

    private void setupToReachPreviewAndSubmitPageWithSpecificData() throws Exception 
    {
        subNavigation.clickLinkMyListings();
        setupToReachAvailabilityForm();
        setAvailabilityFromData();
        
        
    }

    private void setAvailabilityFromData() throws Exception 
    {
        availabilityForm.radioBtnYes().click();;
        
    }

	private void setupToReachAvailabilityForm() throws Exception 
    {
        dataFromCSV  = testCaseData.get("ListingTypes");
        String listingType = dataFromCSV.get("ListingType1");
        String listingName;
        myListings = subNavigation.clickLinkMyListings();
        WaitFor.sleepFor(2000);
        HashMap<String, String> allListingTypes = new HashMap<>();
        allListingTypes = myListings.allListingTypes();
        listingName = allListingTypes.get(listingType);
        try 
        {
            availabilityForm = myListings.selectRequiredListingsUpdate(listingName);
            AutomationLog.info("Successfully selected required listing");
        }
        catch (Exception e) 
        {
            AutomationLog.error("It may happen that, given listing type is not present on My Listings page, So make sure that given listing type is present on My listings page. Listing type:"+listingType);
        }
        HandlingWindows.closeCurrentWindow(Page.driver);
        HandlingWindows.switchToWindow(Page.driver, 1);
        WaitFor.sleepFor(1000);
        AutomationLog.info("setup to reach Availability Form passed");
    }

	private void testDetailsFormData() 
    {
        
    	
    }

	private void testAvailabilityFormData() 
    {
        
    	
    }

    public void testMediaFormData() throws Exception
    {
        testMedia_ImageText();
        AutomationLog.info("Successfully tested media form content on Preview And Submit page");
    }

    public void testMedia_ImageText() throws Exception
    {
        String actualMediaImageText = preview.Media_ImageText();
        String expectedMediaImageText = testCaseData.get("MediaFormData").get("imageName");
        Assert.assertEquals(actualMediaImageText, expectedMediaImageText, "Expected image text is not found");
        AutomationLog.info("Successfully found uploaded image text");
    }

    public void testContactsFormData() throws Exception
    {
        testAddedContacts_Name();
        contacts.clickEditIconOnAddedContact();
        testContacts_Name();
        testContacts_RepresentingAs();
        testContacts_Company();
        testContacts_Email();
        testContacts_Phone();
        testContacts_Address();
        AutomationLog.info("Successfully tested Contacts Form data On Preview And Submit page");
    }

    public void testAddedContacts_Name() throws Exception
    {
        String actualAddedContactName = preview.AddedContact_Name();
        String expectedAddedContactName = testCaseData.get("ContactOwner").get("Name");
        Assert.assertEquals(actualAddedContactName, expectedAddedContactName, "Expected Added Contact name is not found");
        AutomationLog.info("Successfully found Added Contact Name ");
    }

    public void testContacts_Name() throws Exception
    {
        String actualContactName = preview.Contact_Name();
        String expectedContactName = testCaseData.get("ContactOwner").get("Name");
        Assert.assertEquals(actualContactName, expectedContactName, "Expected Contact name is not found");
        AutomationLog.info("Successfully found Contact Name ");
    }

    public void testContacts_RepresentingAs() throws Exception
    {
        String actualContactRepresentingAs = preview.Contact_RepresentingAs();
        String expectedContactRepresentingAs = testCaseData.get("ContactOwner").get("RepresentingAs");
        Assert.assertEquals(actualContactRepresentingAs, expectedContactRepresentingAs, "Expected Contact RepresentingAs is not found");
        AutomationLog.info("Successfully found Added Contact RepresentingAs ");
    }

    public void testContacts_Company() throws Exception
    {
        String actualContactCompany = preview.Contact_Company();
        String expectedContactCompany = testCaseData.get("ContactOwner").get("Company");
        Assert.assertEquals(actualContactCompany, expectedContactCompany, "Expected Contact Company is not found");
        AutomationLog.info("Successfully found Added Contact Company ");
    }

    public void testContacts_Email() throws Exception
    {
        String actualContactEmail = preview.Contact_Email();
        String expectedContactEmail = testCaseData.get("ContactOwner").get("Email");
        Assert.assertEquals(actualContactEmail, expectedContactEmail, "Expected Contact Email is not found");
        AutomationLog.info("Successfully found Added Contact Email ");
    }

    public void testContacts_Phone() throws Exception
    {
        String actualContactPhone = preview.Contact_Phone();
        String expectedContactPhone = testCaseData.get("ContactOwner").get("Phone");
        Assert.assertEquals(actualContactPhone, expectedContactPhone, "Expected Contact Phone is not found");
        AutomationLog.info("Successfully found Added Contact Phone ");
    }

    public void testContacts_Address() throws Exception
    {
        String actualContactAddress = preview.Contact_Address();
        String expectedContactAddress = testCaseData.get("ContactOwner").get("Address");
        Assert.assertEquals(actualContactAddress, expectedContactAddress, "Expected Contact Address is not found");
        AutomationLog.info("Successfully found Added Contact Address ");
    }

    @Override
    protected String successMessage() 
    {
        return "Successfully tested preview and submit form";
    }

    @Override
    protected String failureMessage() 
    {
        return "Failed to test preview and submit form";
    }

}
