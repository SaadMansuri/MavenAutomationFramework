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

    private void editContactForm() 
    {
        try 
        {
            contacts.clickEditIconOnAddedContact();
            dataFromCSV = testCaseData.get("ContactOwner");
            contacts.txt_AddedContactName().sendKeys(dataFromCSV.get("Name1"));
            dataFromCSV = testCaseData.get("RepresentingAsOptions");
            contacts.selectValueFromRepresentingAsDropDown(dataFromCSV.get("RepresentingAsOption3"));
            dataFromCSV = testCaseData.get("CompanyNames");
            contacts.txtbx_Company().clear();
            contacts.txtbx_Company().sendKeys(dataFromCSV.get("CompanyName1"));
            dataFromCSV = testCaseData.get("EmailIds");
            contacts.txtbx_Email().clear();
            contacts.txtbx_Email().sendKeys(dataFromCSV.get("Email1"));
            dataFromCSV = testCaseData.get("Phones");
            contacts.txtbx_Phone().clear();
            contacts.txtbx_Phone().sendKeys(dataFromCSV.get("Phone1"));
            dataFromCSV = testCaseData.get("Addresses");
            contacts.txtbx_Address().clear();
            contacts.txtbx_Address().sendKeys(dataFromCSV.get("Address1"));
            contacts.btn_SaveContact().click();
            preview = contacts.clickOnSaveAndContinueButton();
            AutomationLog.info("Succesfully edited selected contact");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to edit contacts form");
        }
    }

    private void editMediaForm() throws Exception 
    {
        try 
        {
            contacts = mediaForm.clickOnSaveAndContinueButton();
            AutomationLog.info("Successfully edited media form");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to edit media form");
        }
    }

    private void editDetailsForm() throws Exception 
    {
        try 
        {
            dataFromCSV = testCaseData.get("AskingPrices");
            availabilityForm.txt_AskingPrice().clear();
            availabilityForm.txt_AskingPrice().sendKeys(dataFromCSV.get("AskingPrice2"));
            dataFromCSV = testCaseData.get("ListingLinkUrls");
            availabilityForm.txt_ListingLink().click();
            availabilityForm.txt_ListingLink().sendKeys(dataFromCSV.get("ListingLinkUrl2"));
            dataFromCSV = testCaseData.get("DetailsDescription");
            availabilityForm.txt_Description().clear();
            availabilityForm.txt_Description().sendKeys(dataFromCSV.get("Description1"));
            mediaForm = availabilityForm.clickSaveAndContinueOnDetailsForm();
            AutomationLog.info("Successfully filled details form");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to edit details form");
        }
    }

    private void editAvailabilityForm()
    {
        try 
        {
            availabilityForm.radioBtnYes().click();
            availabilityForm.btn_SaveAndContinue().click();
            AutomationLog.info("Successfully edited availability form");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to edit availability form");
        }
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
        testAvailabilityFormData();
        testDetailsFormData();
        testContactsFormData();
    }

    private void testDetailsFormData() 
    {
        try 
        {
            String actualAskingPrice = availabilityForm.txt_AskingPrice().getAttribute("value");
            dataFromCSV = testCaseData.get("AskingPrices");
            String expectedAskingPrice = dataFromCSV.get("AskingPrice2");
            Assert.assertEquals(actualAskingPrice, expectedAskingPrice, "Asking price data on preview page does not matches data on details page");

            dataFromCSV = testCaseData.get("ListingLinkUrls");
            String actualListinglink = availabilityForm.txt_ListingLink().getAttribute("value");
            String expectedListingLink = dataFromCSV.get("ListingLinkUrl2");
            Assert.assertEquals(actualListinglink, expectedListingLink, "Listing Link data on preview page does not matches data on details page");

            dataFromCSV = testCaseData.get("DetailsDescription");
            String expectedDescription = dataFromCSV.get("Description1");
            String actualDescription = availabilityForm.txt_Description().getAttribute("value");
            Assert.assertEquals(actualDescription, expectedDescription, "Description data on preview page does not matches data on details page");
            AutomationLog.info("Successfully tested details form data");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to test details form data");
        }
    }

    private void testAvailabilityFormData() 
    {
        try 
        {
            String actualAvailabilityStatus = availabilityForm.radioBtnYes().getAttribute("value");
            String expectedAvailabilityStatus = "Yes";
            Assert.assertEquals(actualAvailabilityStatus, expectedAvailabilityStatus, "Availibility status is not found as expected");
            AutomationLog.info("Successfully tested availability form data");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to test availability form data");
        }
    }

    public void testContactsFormData() throws Exception
    {
        contacts.clickEditIconOnAddedContact();
        testContacts_RepresentingAs();
        testContacts_Company();
        testContacts_Email();
        testContacts_Phone();
        testContacts_Address();
        AutomationLog.info("Successfully tested Contacts Form data On Preview And Submit page");
    }

    public void testContacts_RepresentingAs() throws Exception
    {
        String actualContactRepresentingAs = preview.Contact_RepresentingAs();
        String expectedContactRepresentingAs = testCaseData.get("RepresentingAsOptions").get("RepresentingAsOption3");
        Assert.assertEquals(actualContactRepresentingAs, expectedContactRepresentingAs, "Expected Contact RepresentingAs is not found");
        AutomationLog.info("Successfully found Added Contact RepresentingAs ");
    }

    public void testContacts_Company() throws Exception
    {
        String actualContactCompany = preview.Contact_Company();
        String expectedContactCompany = testCaseData.get("CompanyNames").get("CompanyName1");
        Assert.assertEquals(actualContactCompany, expectedContactCompany, "Expected Contact Company is not found");
        AutomationLog.info("Successfully found Added Contact Company ");
    }

    public void testContacts_Email() throws Exception
    {
        String actualContactEmail = preview.Contact_Email();
        String expectedContactEmail = testCaseData.get("EmailIds").get("Email1");
        Assert.assertEquals(actualContactEmail, expectedContactEmail, "Expected Contact Email is not found");
        AutomationLog.info("Successfully found Added Contact Email ");
    }

    public void testContacts_Phone() throws Exception
    {
        String actualContactPhone = preview.Contact_Phone();
        String expectedContactPhone = testCaseData.get("Phones").get("Phone1");
        Assert.assertEquals(actualContactPhone, expectedContactPhone, "Expected Contact Phone is not found");
        AutomationLog.info("Successfully found Added Contact Phone ");
    }

    public void testContacts_Address() throws Exception
    {
        String actualContactAddress = preview.Contact_Address();
        String expectedContactAddress = testCaseData.get("Addresses").get("Address1");
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
