package com.agorafy.automation.testcases.updateListing;

import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.automationframework.WaitFor;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.agorafy.automation.automationframework.AutomationLog;
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


public class ContactsFormAction extends AutomationTestCaseVerification
{

    private HashMap<String, String > contactinfo;
    private Homepage homePage;
    private Header header;
    private HeaderLoginForm headerLoginForm;
    private SubNavigation subNavigation;
    private MyListings myListings;
    private AvailabilityAndDetailsForm updateListingPage;
    private MediaForm media;
    private PreviewAndSubmitForm previewAndSubmitForm;
    private ContactsForm contacts;
	private Integer oldNoOfContacts;
	private Integer newNoOfContacts;

    public ContactsFormAction() 
    {
        super("UpdateListing");
    }

    @Override
    public void setup() 
    {
        super.setup();
        try
        {
            AutomationLog.info("Setup to reach contacts form started...");
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
            updateListingPage.btn_SaveAndContinue().click();
            media = updateListingPage.clickSaveAndContinueOnDetailsForm();
            contacts = media.clickOnSaveAndContinueButton();
            AutomationLog.info("Setup to reach contacts form of the user passed");
            
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to reach Contacts form");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
 
        verifyIfNameFieldIsRequired();

        AutomationLog.info("Verification of Add contact started...");
        contactinfo = testCaseData.get("ContactOwner");
        verifyIfClickingAddContactWithFormDataAddsContact();

        AutomationLog.info("Verification of Edit option on contacts form started...");
        verifyAfterClickingEditIconSameNameGetsReflected();

        AutomationLog.info("Verify that after performing click operation on cancel btn it clears form");
        verifyIfCancelButtonIsClickedAfterEdit();

        AutomationLog.info("Verify that saving contact name after edit, reflects profile name in contacts added");
        verifySavedContactNameAfterEdit();

        AutomationLog.info("Verify deletion of all contacts started...");
        verifyDeletionOfAllContacts();

        AutomationLog.info("Verify that no of added contacts matches with count of added contacts");
        verifyIfAddedContactsShowsTotalNoOfContactsAdded();

        AutomationLog.info("Verify after performing click operation on back btn it navigates to media form");
        verifyIfClickingBackButtonRedirectsToMediaForm();

        AutomationLog.info("Verify representing as options started...");
        verifyRepresentingAsOptions();

        AutomationLog.info("Verify Contacts form fill up with compulsory fields only started...");
        verifyContactsFormWithCompulsoryFieldsOnly();

        AutomationLog.info("Verify Contacts form fill up with all fields only started...");
        verifyContactsFormWithAllFields();

        AutomationLog.info("Verify add contact form fill up with optional fields only");
        verifyContactsFormWithOptionalFieldsOnly();

        AutomationLog.info("Verify Empty Contacts form fill up started...");
        verifyEmptyFormFillUp();

        AutomationLog.info("Verify that after performing click operation on save and continue btn on contacts form it navigates to preview and submit form");
        verifyIfClickingSaveAndContinueRedirectsToPreviewAndSubmitForm();

    }

    private void verifyContactsFormWithOptionalFieldsOnly() throws Exception 
    {
        oldNoOfContacts = 0;
        oldNoOfContacts = contacts.noOfContactsAdded();
        contactinfo = testCaseData.get("OptionalFieldsOnly");
        addContactFormFill(contacts, contactinfo);
        contacts.btn_AddContact().click();
        newNoOfContacts = 0;
        newNoOfContacts = contacts.noOfContactsAdded();
        Assert.assertEquals(newNoOfContacts, oldNoOfContacts,"Contacts form with optional fields should not add new contact");
        AutomationLog.error("Contacts form with optional fields not added new contact");
    }

    private void verifyEmptyFormFillUp() throws Exception 
    {
        oldNoOfContacts = 0;
        oldNoOfContacts = contacts.noOfContactsAdded();
        contacts.btn_AddContact().click();
        newNoOfContacts = 0;
        newNoOfContacts = contacts.noOfContactsAdded();
        Assert.assertEquals(newNoOfContacts, oldNoOfContacts,"Contacts form with empty fields should not add new contact");
        AutomationLog.error("Contacts form with empty fields not added new contact");
    }

	private void verifyContactsFormWithAllFields() throws Exception 
    {
        oldNoOfContacts = 0;
        oldNoOfContacts = contacts.noOfContactsAdded();
        contactinfo = testCaseData.get("ContactPropertyManager");
        addContactFormFill(contacts, contactinfo);
        contacts.btn_AddContact().click();
        newNoOfContacts = 0;
        newNoOfContacts = contacts.noOfContactsAdded();
        newNoOfContacts--;
        Assert.assertEquals(newNoOfContacts, oldNoOfContacts,"Failed to add contact with all fields");
        AutomationLog.error("Successfully added contact with all fields");
    }

	private void verifyContactsFormWithCompulsoryFieldsOnly() throws Exception 
    {
        oldNoOfContacts = 0;
        oldNoOfContacts = contacts.noOfContactsAdded();
        contactinfo = testCaseData.get("ContactName");
        contacts.txtbx_Name().sendKeys(contactinfo.get("name"));
        contacts.btn_AddContact().click();
        newNoOfContacts = 0;
        newNoOfContacts = contacts.noOfContactsAdded();
        newNoOfContacts--;
        Assert.assertEquals(newNoOfContacts, oldNoOfContacts,"Failed to add contact with compulsory field name only");
        AutomationLog.error("Successfully added contact with compulsory field name only");
    }

	private void verifyRepresentingAsOptions() 
    {
        contactinfo = testCaseData.get("RepresentingAsOptions");
        Collection<String> actualAllRepresentingAsOptions = contacts.allRepresentingAsOptions();
        Collection<String> expectedAllRepresentingAsOptions = contactinfo.values();
        boolean representingAsOptionsStatus = false;
        representingAsOptionsStatus = compareTwoCollections(actualAllRepresentingAsOptions, expectedAllRepresentingAsOptions);
        Assert.assertEquals(representingAsOptionsStatus, true, "Representing As Options are not found as expected");
        AutomationLog.info("Representing As Options are found as expected");
    }

	public void verifyIfErrorMessageShownOnClickingSaveAndContinueButtonWithEmptyForm() throws Exception
    {
        contacts.clickOnSaveAndContinueButton();
        Assert.assertEquals(contacts.msg_ContactsError().getText(), "Minimum one contact should be added", "Expected error message is not shown");
        AutomationLog.info("Error message shown on clicking Save And Continue button with empty input ");
    }

    public void verifyIfNameFieldIsRequired() throws Exception
    {
        contacts.clickOnAddContactsButton();
        Assert.assertEquals(contacts.txtbx_Name().getAttribute("required"), "true", "Expected Name is not required ");
        AutomationLog.info("Name field is required");
    }

    public void verifyIfClickingBackButtonRedirectsToMediaForm() throws Exception
    {
        MediaForm media = contacts.clickOnBackButton();
        Assert.assertEquals(media.form_Media().isDisplayed(), true, "Expected media form is not shown");
        AutomationLog.info("Clicking on back button shows media form");
        media.clickOnSaveAndContinueButton();
    }

    public void verifyIfClickingAddContactWithFormDataAddsContact() throws Exception
    {
        addContactFormFill(contacts,contactinfo);
        contacts.clickOnAddContactsButton();
        Assert.assertEquals(contacts.added_Contacts().isDisplayed(), true, "Expected added contacts is not shown");
        List<String> allAddedContacts = contacts.allAddedContacts();
        boolean addedContactStatus = false;
        String expectedContactName = contactinfo.get("Name");
        addedContactStatus = allAddedContacts.contains(expectedContactName);
        Assert.assertEquals(addedContactStatus, true, "Expected contact name not found ");
        AutomationLog.info("Clicking Add Contact with form data shows added contacts successfullys");
    }

    public void verifyAfterClickingEditIconSameNameGetsReflected() throws Exception
    {
        List<WebElement> allAddedContacts = contacts.element_AllAddedContacts();
        String expectedContactName = contacts.getContactName(allAddedContacts.get(0));
        contacts.clickEditIconForSingleContact(allAddedContacts.get(0));
        String actualContactName = contacts.txtbx_Name().getAttribute("value");
        Assert.assertEquals(expectedContactName, actualContactName, "Expected Contact is not matched with contact whose edit icon was clicked");
        AutomationLog.info("Same contact name gets reflected after clicking edit icon for respective contact");
    }

    public void verifyIfCancelButtonIsClickedAfterEdit() throws Exception 
    {
        contacts.clickOnCancelContactButton();
        boolean emptyFormStatus = false;
        boolean emptyNameStatus = contacts.txtbx_Name().getAttribute("value").isEmpty();
        WaitFor.sleepFor(1000);
        boolean emptyCompanyStatus = contacts.txtbx_Company().getAttribute("value").isEmpty();
        WaitFor.sleepFor(1000);
        boolean emptyEmailStatus = contacts.txtbx_Email().getAttribute("value").isEmpty();
        WaitFor.sleepFor(1000);
        boolean emptyPhoneStatus = contacts.txtbx_Phone().getAttribute("value").isEmpty();
        WaitFor.sleepFor(1000);
        boolean emptyAddressStatus = contacts.txtbx_Address().getAttribute("value").isEmpty();
        WaitFor.sleepFor(1000);
        emptyFormStatus = (emptyNameStatus && emptyCompanyStatus && emptyEmailStatus && emptyPhoneStatus && emptyAddressStatus);
        Assert.assertEquals(emptyFormStatus, true, "After performing click operation on cancel btn on form it should clear all form fields");
        AutomationLog.info("After performing click operation on cancel btn on form it clears all form fields");
    }

    public void verifySavedContactNameAfterEdit() throws Exception 
    {
        contactinfo = testCaseData.get("ContactName");
        String expectedContactName = contactinfo.get("name");
        List<WebElement> elements_AllAddedContacts = contacts.element_AllAddedContacts();
        contacts.clickEditIconForSingleContact(elements_AllAddedContacts.get(0));
        contacts.txtbx_Name().clear();
        contacts.txtbx_Name().sendKeys(expectedContactName);
        contacts.clickOnSaveContactButton();
        List<String> allAddedContacts = contacts.allAddedContacts();
        boolean contactNameStatus = allAddedContacts.contains(expectedContactName);
        Assert.assertEquals(contactNameStatus, true, "Contact name is not reflected in added contacts box after save btn click");
        AutomationLog.info("Contact name is successfully reflected in added contacts box after save btn click");
    }

    public void verifyDeletionOfAllContacts() throws Exception
    {
        contacts.deleteAllAddedContacts();
        Assert.assertEquals(contacts.added_Contacts().isDisplayed(), false, "Expected Contact is not removed");
        AutomationLog.info("Clicking Delete option on added contacts removes contact successfully");
    }

    public void verifyIfClickingSaveAndContinueRedirectsToPreviewAndSubmitForm() throws Exception
    {
        previewAndSubmitForm = contacts.clickOnSaveAndContinueButton();
        Assert.assertEquals(previewAndSubmitForm.form_PreviewAndSubmit().isDisplayed(), true, "Expected Preview and Submit form is not shown");
        AutomationLog.info("Preview And Submit form is Shown after Successfully filling Contacts form data");
    }

    public void verifyIfMultipleContactsCanBeRemoved() throws Exception
    {
        contacts.deleteAllAddedContacts();
        Assert.assertEquals(contacts.added_Contacts().isDisplayed(), false, "Expected Contacts are not removed");
        AutomationLog.info("Delete option on added contacts multiple contacts Removed successfully");
    }

    public void verifyIfAddedContactsShowsTotalNoOfContactsAdded() throws Exception
    {
        contacts.deleteAllAddedContacts();
        HashMap<String, String > addcontact = testCaseData.get("ContactOwner");
        addContactFormFill(contacts,addcontact);
        contacts.clickOnAddContactsButton();
        addcontact = testCaseData.get("ContactBroker");
        addContactFormFill(contacts,addcontact);
        contacts.clickOnAddContactsButton();
        addcontact = testCaseData.get("ContactPropertyManager");
        addContactFormFill(contacts,addcontact);
        contacts.clickOnAddContactsButton();
        String numcontacts = contacts.txt_NoOfContactsAdded().getText();
        int num = contacts.getNoOfContactsAdded();
        String addedcontacts = num + " contact(s) added";
        Assert.assertEquals(numcontacts, addedcontacts, "Expected contacts are not added");
        AutomationLog.info("Added contats shows total no of added contacts successfully");
    }

    public void addContactFormFill(ContactsForm contact,HashMap<String, String> contactinfo) throws Exception
    {
        contact.txtbx_Name().clear();
        contact.txtbx_Name().sendKeys(contactinfo.get("Name"));
        contact.selectValueFromRepresentingAsDropDown(contactinfo.get("RepresentingAs"));
        contact.txtbx_Company().clear();
        contact.txtbx_Company().sendKeys(contactinfo.get("Company"));
        contact.txtbx_Email().clear();
        contact.txtbx_Email().sendKeys(contactinfo.get("Email"));
        contact.txtbx_Phone().clear();
        contact.txtbx_Phone().sendKeys(contactinfo.get("Phone"));
        contact.txtbx_Address().clear();
        contact.txtbx_Address().sendKeys(contactinfo.get("Address"));
        AutomationLog.info("Form data added successfully");
    }

    @Override
    protected String successMessage() 
    {
        return "Test cases passed for SubmitListing Contacts form";
    }

    @Override
    protected String failureMessage() 
    {
        return "Test cases failed for SubmitListing Contacts form";
    }
}