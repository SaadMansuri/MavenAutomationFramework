package com.agorafy.automation.testcases.submitlisting;
/**
 * Precondition:Do valid login
 * Navigate to submit Listing page
 * fill location form and select listing type as Property
 * verify all test cases
 */
import java.util.Collection;
import java.util.HashMap;
import org.testng.Assert;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.submitlisting.SubmitListingDetailsFormPropertyPage;
import com.agorafy.automation.pageobjects.submitlisting.SubmitListingMediaFormPage;

public class SubmitListingDetailsFormPropertyAction extends SubmitListingBaseAction 
{
    SubmitListingDetailsFormPropertyPage detailsPropertyPage;
    SubmitListingMediaFormPage nextPage;
    private SubmitListingLocationFormAction locationAction;

    public SubmitListingDetailsFormPropertyAction() 
    {
        super();
    }

    @Override
    public void setup() 
    {
        super.setup();
        try 
        {
            locationAction = new SubmitListingLocationFormAction();
            dataFromCSV = testCaseData.get("LocationCombination16");
            detailsBasePage = locationPage.fillLocationFormAndClickSaveAndContinue(dataFromCSV);
            detailsPropertyPage = (SubmitListingDetailsFormPropertyPage) detailsBasePage.selectListingTypeDropdown("Property");
            AutomationLog.info("Set up to reach details-Property page sucessfull");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Set up to reach details-Property page failed");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
        try
        {
            AutomationLog.info("verify All Drop Down Options started...");
            verifyAllDropDownOptions();

            AutomationLog.info("verify Positive Form Fill Up started ...");
            verifyPositiveFormFillUp();

            AutomationLog.info("verify Negative Form Fill Up started...");
            verifyNegativeFormFillUp();

            AutomationLog.info("verify Test Cases passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("verify Test Cases failed");
            throw (e);
        }
    }

    private void verifyPositiveFormFillUp() throws Exception 
    {
        try 
        {
            AutomationLog.info("verify Positive Form Fill Up With Compulsory Fields Only started...");
            verifyPositiveFormFillUpWithCompulsoryFieldsOnly();

            AutomationLog.info("verify Positive Form Fill Up With All Fields started...");
            verifyPositiveFormFillUpWithAllFields();

        }
        catch (Exception e) 
        {
            AutomationLog.error("verify Positive Form Fill Up failed");
            throw (e);
        }
    }

    private void verifyNegativeFormFillUp() throws Exception 
    {
        try 
        {
            AutomationLog.info("verify Negative Form Fill Up Empty Form started...");
            verifyNegativeFormFillUpEmptyForm();

            AutomationLog.info("verify Negative Form Fill Up Without Compulsory Fields started...");
            verifyNegativeFormFillUpWithoutCompulsoryFields();

            AutomationLog.info("verify Negative Form Fill Up passed");
        }
        catch (Exception e) 
        {
             AutomationLog.error("verify Negative Form Fill Up failed");
             throw (e);
        }
    }

    private void verifyNegativeFormFillUpWithoutCompulsoryFields() throws Exception 
    {
        try 
        {
            clearCurrentForm();
            dataFromCSV = testCaseData.get("NegativePropertyFormDataWithoutCompulsoryFields");
            fillCurrentFormAndClickSaveAndContinue(dataFromCSV);
            Assert.assertEquals(detailsPropertyPage.form_Property().isDisplayed(), true,"details-property form filled without compulsory fields should stay on same page");
            AutomationLog.info("verify Negative Form Fill Up Without Compulsory Fields passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("verify Negative Form Fill Up Without Compulsory Fields failed");
            throw (e);
        }
    }

    private void verifyNegativeFormFillUpEmptyForm() throws Exception 
    {
        try 
        {
            clearCurrentForm();
            detailsPropertyPage.clickSaveAndContinue();
            Assert.assertEquals(detailsPropertyPage.form_Property().isDisplayed(), true, "empty details-property form should stay on same page");
            AutomationLog.info("verify Negative Form Fill Up Empty Form passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("verify Negative Form Fill Up Empty Form failed");
            throw (e);
        }
    }

    private void verifyPositiveFormFillUpWithAllFields() throws Exception 
    {
        try 
        {
            clearCurrentForm();
            dataFromCSV = testCaseData.get("TotalPropertyFormData");
            nextPage = (SubmitListingMediaFormPage) fillCurrentFormAndClickSaveAndContinue(dataFromCSV);
            Assert.assertEquals(nextPage.form_Media().isDisplayed(), true, "details-property form filled with all fields should navigate to next(media) page");
            AutomationLog.info("positive form fill up with all fileds succesfull");
            nextPage.clickOnBackButton();
            AutomationLog.info("verify Positive Form Fill Up With All Fields passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("verify Positive Form Fill Up With All Fields failed");
            throw (e);
        }
    }

    private void verifyAllDropDownOptions() throws Exception 
    {
        try 
        {
            AutomationLog.info("verifyAllDropDownOptionsForOfferTypes started");
            verifyAllDropDownOptionsForOfferTypes();

            AutomationLog.info("verifyAllDropDownOptionsForPropertyTypes started");
            verifyAllDropDownOptionsForPropertyTypes();

            AutomationLog.info("verifyAllDropDownOptions passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("verify All Drop Down Options failed");
            throw (e);
        }

    }

    private void verifyPositiveFormFillUpWithCompulsoryFieldsOnly() throws Exception 
    {
        try 
            {
                clearCurrentForm();
                dataFromCSV = testCaseData.get("CompulsoryPropertyFormData");
                nextPage = (SubmitListingMediaFormPage) fillCurrentFormAndClickSaveAndContinue(dataFromCSV);
                Assert.assertEquals(nextPage.form_Media().isDisplayed(), true, "details-property form filled with compulsory fields should navigate to next(media) page");
                AutomationLog.info("positive form fill up with compulsory fileds succesfull");
                nextPage.clickOnBackButton();
            }
        catch (Exception e) 
            {
                AutomationLog.error("details form fillup with compulsory fields failed");
                throw (e);
            }
    }

    private void verifyAllDropDownOptionsForOfferTypes() throws Exception 
    {
        Collection<String> actualAllDisplayedListingOfferTypes;
        Collection<String> expectedListingOfferTypes;
        try 
        {
            dataFromCSV = testCaseData.get("ListingOffersForProperty");
            expectedListingOfferTypes = dataFromCSV.values();
            actualAllDisplayedListingOfferTypes = detailsPropertyPage.txt_AllDisplayedListingOfferTypes();
            Boolean actual = locationAction.compareTwoCollections(actualAllDisplayedListingOfferTypes, expectedListingOfferTypes);
            Boolean expected = true;
            Assert.assertEquals(actual, expected, "All Listing offer types from dropdown do not match with required types");
            AutomationLog.info("verify All Drop Down Options For Offer Types passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("verify All Drop Down Options For Offer Types failed");
            throw (e);
        }
    }

    private void verifyAllDropDownOptionsForPropertyTypes() throws Exception 
    {
        Collection<String> actualAllDisplayedPropertyTypes;
        Collection<String> expectedPropertyTypes;
        try 
        {
            dataFromCSV = testCaseData.get("PropertyTypes");
            expectedPropertyTypes = dataFromCSV.values();
            actualAllDisplayedPropertyTypes = detailsPropertyPage.txt_AllDisplayedPropertyTypes();
            Boolean actual = locationAction.compareTwoCollections(actualAllDisplayedPropertyTypes, expectedPropertyTypes);
            Boolean expected = true;
            Assert.assertEquals(actual, expected, "All Property Types from dropdown do not match with required types");
            AutomationLog.info("verify All Drop Down Options For Property Types passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("verify All Drop Down Options For Property Types failed");
            throw (e);
        }
    }

    public void clearCurrentForm() throws Exception 
    {
        try 
        {
            detailsPropertyPage.clearAskingPrice();
            detailsPropertyPage.clearBlock();
            detailsPropertyPage.clearLot();
            detailsPropertyPage.clearListingLink();
            detailsPropertyPage.clearDescription();

            AutomationLog.info("details-property form cleared sucessfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to clear details-property form");
            throw (e);
        }
    }

    public Page fillCurrentFormAndClickSaveAndContinue(HashMap<String, String> dummyFormData) throws Exception 
    {
        Page page;
        try 
        {
            if(dummyFormData.get("ListingOffer") != null)
                detailsPropertyPage.selectListingOfferDropdown(dummyFormData.get("ListingOffer"));	

            if(dummyFormData.get("PropertyType") != null)
            {
                detailsPropertyPage.selectPropertyTypeDropdown(dummyFormData.get("PropertyType"));
            }

            if(dummyFormData.get("Price") != null)
                detailsPropertyPage.setAskingPrice(dummyFormData.get("Price"));

            if(dummyFormData.get("PriceUnit") != null)
                detailsPropertyPage.selectAskingPriceUnit(dummyFormData.get("PriceUnit"));

            if(dummyFormData.get("Block") != null)
                detailsPropertyPage.setBlock(dummyFormData.get("Block"));

            if(dummyFormData.get("Lot") != null)
                detailsPropertyPage.setLot(dummyFormData.get("Lot"));

            if(dummyFormData.get("ListingLink") != null)
                detailsPropertyPage.setListingLink(dummyFormData.get("ListingLink"));

            if(dummyFormData.get("Description") != null)
                detailsPropertyPage.setDescription(dummyFormData.get("Description"));

            detailsPropertyPage.clickSaveAndContinue();
            AutomationLog.info("details-property form filled and clicked save and comntinue successfully");
            page = new SubmitListingMediaFormPage(Page.driver);
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to fill and click save and continue details-property form");
            throw (e);
        }
        return page;
    }

    @Override
    protected String successMessage() 
    {
        return "Submit listing details-property form tested successfully";
    }

    @Override
    protected String failureMessage() 
    {
        return "Submit listing details-property form testing failed";
    }
}

