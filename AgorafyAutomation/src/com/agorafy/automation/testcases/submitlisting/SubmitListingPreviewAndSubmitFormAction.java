package com.agorafy.automation.testcases.submitlisting;


import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.submitlisting.SubmitListingContactsFormPage;
import com.agorafy.automation.pageobjects.submitlisting.SubmitListingDetailsFormRetailPage;
import com.agorafy.automation.pageobjects.submitlisting.SubmitListingPreviewAndSubmitPage;


public class SubmitListingPreviewAndSubmitFormAction extends SubmitListingBaseAction
{
    private SubmitListingContactsFormAction contactsAction = new SubmitListingContactsFormAction();
    private SubmitListingPreviewAndSubmitPage preview = null; 
    private SubmitListingContactsFormPage contacts = new SubmitListingContactsFormPage(Page.driver);
    private SubmitListingDetailsFormRetailPage detailsRetailPage = new SubmitListingDetailsFormRetailPage(Page.driver); 

    public SubmitListingPreviewAndSubmitFormAction()
    {
        super();
    }

    @Override
    public void setup()
    {
       super.setup();
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
        preview = contactsAction.moveToPreviewAndSubmitForm(testCaseData);
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
        testLocationFormData();
        testDetailsFormData();
        testMediaFormData();
        testContactsFormData();
    }

    public void testLocationFormData() throws Exception
    {
        testLocationFormAddressData();
        testLocationFormStateData();
        testLocationFormCityData();
        testLocationFormZipCodeData();
        AutomationLog.info("same data reflects back in preview and submit form as added in location form");
    }

    private void testLocationFormZipCodeData() throws Exception 
    {
            String actualZipCode;
            actualZipCode = preview.Location_ZipCode();
            String expectedZipCode = testCaseData.get("LocationCombination16").get("zipcode");
            Assert.assertEquals(actualZipCode, expectedZipCode, "ZipCode added in location form did not reflects back in preview and submit form:");
            AutomationLog.info("same Zip Code reflects back in preview and submit form as added in location form");
    }

    private void testLocationFormCityData() throws Exception 
    {
            String actualCity;
            actualCity = preview.Location_City();
            String expectedCity = testCaseData.get("LocationCombination16").get("city");
            Assert.assertEquals(actualCity, expectedCity, "City added in location form did not reflects back in preview and submit form:");
            AutomationLog.info("same City reflects back in preview and submit form as added in location form");
    }

    private void testLocationFormStateData() throws Exception 
    {
            String actualState;
            actualState = preview.Location_State();
            String expectedState = testCaseData.get("LocationCombination16").get("state");
            Assert.assertEquals(actualState, expectedState, "State added in location form did not reflects back in preview and submit form:");
            AutomationLog.info("same State reflects back in preview and submit form as added in location form");
    }

    private void testLocationFormAddressData() throws Exception 
    {
            String actualAddress;
            actualAddress = preview.Location_Address();
            String expectedAddress = testCaseData.get("LocationCombination16").get("address");
            Assert.assertEquals(actualAddress, expectedAddress, "address added in location form did not reflects back in preview and submit form:");
            AutomationLog.info("same Address reflects back in preview and submit form as added in location form");
    }

    public void testDetailsFormData() throws Exception
    {
        AutomationLog.info("testing of no of spaces started...");
        testNoOfSpacesAdded();

        AutomationLog.info("testing of details-retail form text data started...");
        testDetailsTxtFormData();

        AutomationLog.info("same data reflects back in preview and submit form as added in details-retail form");
    }

    private void testDetailsTxtFormData() throws Exception 
    {
        testdetailsFormAskingPrice();
        testdetailsFormFrontage();
        testdetailsFormCeilingHeight();
        testdetailsFormDescription();
        AutomationLog.info("same text data reflects back in preview and submit form as added in details-retail form");
    }

    private void testdetailsFormDescription() throws Exception 
    {
            String actualDescription;
            actualDescription = preview.Details_Description();
            String expectedDescription = testCaseData.get("TotalRetailFormData").get("Description");
            Assert.assertEquals(actualDescription, expectedDescription, "Description added in details-retail form did not reflects back in preview and submit form:");
            AutomationLog.info("same Description reflects back in preview and submit form as added in details-retail form");
    }

    private void testdetailsFormCeilingHeight() throws Exception 
    {
            String actualCeilingHeight;
            actualCeilingHeight = preview.Details_CeilingHeight();
            String expectedCeilingHeight = testCaseData.get("TotalRetailFormData").get("CeilingHeight");
            Assert.assertEquals(actualCeilingHeight, expectedCeilingHeight, "Ceiling Height added in details-retail form did not reflects back in preview and submit form:");
            AutomationLog.info("same Ceiling Height reflects back in preview and submit form as added in details-retail form");
    }

    private void testdetailsFormFrontage() throws Exception 
    {
        String actualFrontage;
        actualFrontage = preview.Details_Frontage();
        String expectedFrontage = testCaseData.get("TotalRetailFormData").get("Frontage");
        Assert.assertEquals(actualFrontage, expectedFrontage, "Frontage added in details-retail form did not reflects back in preview and submit form:");
        AutomationLog.info("same Frontage reflects back in preview and submit form as added in details-retail form");
    }

    private void testdetailsFormAskingPrice() throws Exception 
    {
            String actualAskingPrice;
            actualAskingPrice = preview.Details_AskingPrice();
            String expectedAskingPrice = testCaseData.get("TotalRetailFormData").get("AskingPrice");
            Assert.assertEquals(actualAskingPrice, expectedAskingPrice, "Asking Price added in details-retail form did not reflects back in preview and submit form:");
            AutomationLog.info("same Asking Price reflects back in preview and submit form as added in details-retail form"); 
    }

	private void testNoOfSpacesAdded() 
    { 
        Integer noOfSpacesAddedSeenInSpaceHeader  = detailsRetailPage.noOfSpacesAddedSeenInSpaceHeader();
        Integer noOfSpacesAddedSeenSpaceInList = detailsRetailPage.noOfSpacesAddedSeenSpaceInList();
        Assert.assertEquals(noOfSpacesAddedSeenInSpaceHeader.toString(), "1", "no of spaces added does not matches with no of spaces seen in space header");
        Assert.assertEquals(noOfSpacesAddedSeenSpaceInList.toString(), "1", "no of spaces added does not matches with no of spaces seen in space list");

        AutomationLog.info("same no of added spaces reflects back in preview and submit form as added in details-retail form");
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
        return "test cases for Preview And Submit form passed";
    }

    @Override
    protected String failureMessage() 
    {
        return "test cases for Preview And Submit form failed";
    }

}
