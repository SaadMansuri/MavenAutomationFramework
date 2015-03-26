package com.agorafy.automation.testcases.submitlisting;


import java.util.HashMap;
import org.testng.Assert;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.PageBanner;
import com.agorafy.automation.pageobjects.submitlisting.SubmitListingContactsFormPage;
import com.agorafy.automation.pageobjects.submitlisting.SubmitListingMediaFormPage;
import com.agorafy.automation.pageobjects.submitlisting.SubmitListingPreviewAndSubmitPage;


public class SubmitListingContactsFormAction extends SubmitListingBaseAction
{
    private SubmitListingContactsFormPage contacts = new SubmitListingContactsFormPage(Page.driver);
    private SubmitListingMediaFormAction media = new SubmitListingMediaFormAction();
    private SubmitListingPreviewAndSubmitPage preview = null;
    private PageBanner pagebanner = new PageBanner(Page.driver);
    HashMap<String, String> mediadata;
    HashMap<String, String > contactinfo;
    public SubmitListingContactsFormAction() 
    {
        super();
    }

    @Override
    public void setup() 
    {
        super.setup();

        try
        {
            contacts = media.moveToContactsForm(testCaseData);
            contactinfo = testCaseData.get("ContactOwner");
            AutomationLog.info("Successfully reached to Contacts Form");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to reach Contacts form");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {

        verifyIfErrorMessageShownOnClickingSaveAndContinueButtonWithEmptyForm(); 
        verifyIfNameFieldIsRequired();
        verifyIfClickingAddContactWithFormDataAddsContact(contactinfo);
        verifyIfClickingEditOptionOnAddedContactsEditFormData(contactinfo); 
        verifyIfCancelButtonIsClickedAfterEdit();
        verifyIfSaveButtonIsClickedAfterEdit();
        verifyIfClickingDeleteOptionOnAddedContactRemovesContact();
        verifyIfAddedContactsShowsTotalNoOfContactsAdded();
        verifyIfClickingBackButtonRedirectsToMediaForm();
        verifyIfMultipleContactsCanBeRemoved();
        verifyIfClickingUseMyContactInformationButtonContactsFormIsFilledWithPageBannerData();
        verifyIfClickingAddToContactAfterClickingUseMyContactInformationButton();
        verifyIfClickingSaveAndContinueRedirectsToPreviewAndSubmitForm();
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
        SubmitListingMediaFormPage media = contacts.clickOnBackButton();
        Assert.assertEquals(media.form_Media().isDisplayed(), true, "Expected media form is not shown");
        AutomationLog.info("Clicking on back button shows media form");
        media.clickOnSaveAndContinueButton();
    }

    public void verifyIfClickingAddContactWithFormDataAddsContact(HashMap<String, String> contactinfo) throws Exception
    {
        addContactFormFill(contacts,contactinfo);
        contacts.clickOnAddContactsButton();
        Assert.assertEquals(contacts.added_Contacts().isDisplayed(), true, "Expected added contacts is not shown");
        Assert.assertEquals(contacts.txt_AddedContactName().getText(), contactinfo.get("Name"), "Expected contact name not found ");
        AutomationLog.info("Clicking Add Contact with form data shows added contacts successfullys");
    }

    public void verifyIfClickingEditOptionOnAddedContactsEditFormData(HashMap<String, String> contactinfo) throws Exception
    {
        contacts.clickEditIconOnAddedContact();
        Assert.assertEquals(contacts.txtbx_Name().getAttribute("value"), contactinfo.get("Name"), "Expected Contact is not Edited");
        AutomationLog.info("Contact Edited Successfully");
    }

    public void verifyIfCancelButtonIsClickedAfterEdit() throws Exception 
    {
        contacts.clickOnCancelContactButton();
        Assert.assertEquals(contacts.txtbx_Name().getAttribute("value"), "", "Expected Form Data is not Cleared from edit");
        AutomationLog.info("Clickin Cancel button clears form data from edit successfully ");
    }

    public void verifyIfSaveButtonIsClickedAfterEdit() throws Exception 
    {
        contactinfo = testCaseData.get("ContactName");
        String name = contactinfo.get("name");
        contacts.clickEditIconOnAddedContact();
        contacts.txtbx_Name().clear();
        contacts.txtbx_Name().sendKeys(name);
        contacts.clickOnSaveContactButton();
        Assert.assertEquals(contacts.txt_AddedContactName().getText(), name, "Expected Form Data is not Saved from edit");
        AutomationLog.info("Clickin Cancel button clears form data from edit successfully ");
    }

    public void verifyIfClickingDeleteOptionOnAddedContactRemovesContact() throws Exception
    {
        contacts.clickDeleteIconOnAddedContact();
        Assert.assertEquals(contacts.added_Contacts().isDisplayed(), false, "Expected Contact is not removed");
        AutomationLog.info("Clicking Delete option on added contacts removes contact successfully");
    }

    public void verifyIfClickingSaveAndContinueRedirectsToPreviewAndSubmitForm() throws Exception
    {
        preview = moveToPreviewAndSubmitForm(testCaseData);
        Assert.assertEquals(preview.form_PreviewAndSubmit().isDisplayed(), true, "Expected Preview and Submit form is not shown");
        AutomationLog.info("Preview And Submit form is Shown after Successfully filling Contacts form data");
    }

    public void verifyIfMultipleContactsCanBeRemoved() throws Exception
    {
        contacts.deleteAllAddedContacts();
        Assert.assertEquals(contacts.added_Contacts().isDisplayed(), false, "Expected Contacts are not removed");
        AutomationLog.info("Delete option on added contacts multiple contacts Removed successfully");
    }

    public SubmitListingPreviewAndSubmitPage moveToPreviewAndSubmitForm(HashMap<String, HashMap<String, String>> data) throws Exception
    {
        SubmitListingPreviewAndSubmitPage previewnsubmit = null;
        try
        {
            if(!(contacts.form_Contacts().isDisplayed()))
            {
                 media.moveToContactsForm(data);
            }
            addContactFormFill(contacts,data.get("ContactOwner"));
            contacts.clickOnAddContactsButton();
            contacts.clickOnSaveAndContinueButton();
            previewnsubmit = new SubmitListingPreviewAndSubmitPage(Page.driver);
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not move to Preview And Submit form");
            throw(e);
        }
        return previewnsubmit;
    }

    public void verifyIfAddedContactsShowsTotalNoOfContactsAdded() throws Exception
    {
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

    public void addContactFormFill(SubmitListingContactsFormPage contact,HashMap<String, String> contactinfo) throws Exception
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

    public void verifyIfClickingUseMyContactInformationButtonContactsFormIsFilledWithPageBannerData() throws Exception
    {
        contacts.clickOnUseMyContactInformationbutton();
        verifyContactForm();
    }

    public void verifyContactForm() throws Exception
    {
        verifyNameField();
        verifyCompanyField();
        verifyEmailField();
        verifyPhoneField();
        verifyAddressField();
    }

    public void verifyIfClickingAddToContactAfterClickingUseMyContactInformationButton() throws Exception
    {
        contacts.clickOnAddContactsButton();
        Assert.assertEquals(contacts.added_Contacts().isDisplayed(), true, "Expected added contacts is not shown");
    }

    public void verifyNameField() throws Exception 
    {
        String actualName = contacts.txtbx_Name().getAttribute("value").replaceAll("\\s", "");
        String expectedName =  pagebanner.getBannerText();
        Assert.assertEquals(actualName, expectedName, "Expected name is not shown");
    }

    public void verifyCompanyField() throws Exception
    {
        String actualCompany = contacts.txtbx_Company().getAttribute("value");
        String expectedCompany = pagebanner.getBannerCompanyText();
        Assert.assertEquals(actualCompany, expectedCompany, "Expected Company is not shown");
    }

    public void verifyEmailField() throws Exception
    {
        String actualEmail = contacts.txtbx_Email().getAttribute("value");
        String expectedEmail = pagebanner.getBannerEmailText();
        Assert.assertEquals(actualEmail, expectedEmail, "Expected email is not shown");
    }

    public void verifyPhoneField() throws  Exception
    {
         String actualPhone = contacts.txtbx_Phone().getAttribute("value").replaceAll("\\D", "");
         String expectedPhone = (pagebanner.getBannerWorkPhoneText() + pagebanner.getBannerMobilePhoneText()).replaceAll("\\D", "");
         Assert.assertEquals(actualPhone, expectedPhone, "Expected phone in not shown");
    }

    public void verifyAddressField() throws Exception
    {
        String actualAddress = contacts.txtbx_Address().getAttribute("value").replaceAll("\\W", "");
        String expectedAddress = pagebanner.getBannerAddressText().replaceAll("\\W", "");
        Assert.assertEquals(actualAddress, expectedAddress, "Expected Address is not shown");
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