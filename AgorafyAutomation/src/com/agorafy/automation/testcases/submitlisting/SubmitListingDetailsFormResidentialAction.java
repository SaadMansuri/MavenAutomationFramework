package com.agorafy.automation.testcases.submitlisting;
/**
 * Precondition:Do valid login
 * Navigate to submit Listing page
 * fill location form and select listing type as residential
 * verify all test cases
 */
import java.util.Collection;
import java.util.HashMap;
import org.testng.Assert;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.submitlisting.SubmitListingDetailsFormResidentialPage;
import com.agorafy.automation.pageobjects.submitlisting.SubmitListingMediaFormPage;

public class SubmitListingDetailsFormResidentialAction extends SubmitListingBaseAction
{
    SubmitListingDetailsFormResidentialPage detailsResidentialPage;
    SubmitListingMediaFormPage nextPage;
    SubmitListingDetailsFormResidentialAction detailsResidentialAction;
    private SubmitListingLocationFormAction locationAction;

    public SubmitListingDetailsFormResidentialAction() 
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
        try 
        {
            detailsResidentialAction = new SubmitListingDetailsFormResidentialAction();
            locationAction = new SubmitListingLocationFormAction();
            dataFromCSV = testCaseData.get("LocationCombination16");
            detailsBasePage = locationPage.fillLocationFormAndClickSaveAndContinue(dataFromCSV);
            detailsResidentialPage = (SubmitListingDetailsFormResidentialPage) detailsBasePage.selectListingTypeDropdown("Residential");

            AutomationLog.info("verify All Drop Down Options started...");
            verifyAllDropDownOptions();

            AutomationLog.info("verify Positive Form Fill Up started...");
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
            dataFromCSV = testCaseData.get("NegativeResidentialFormDataWithoutCompulsoryFields");
            fillCurrentFormAndClickSaveAndContinue(dataFromCSV);
            Assert.assertEquals(detailsResidentialPage.form_Property().isDisplayed(), true,"Details-Residential form filled without compulsory fields should not navaigate to media page");
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
            detailsResidentialPage.clickSaveAndContinue();
            Assert.assertEquals(detailsResidentialPage.form_Property().isDisplayed(), true, "Empty details form should not navigate to media form");
            AutomationLog.info("verify Negative Form Fill Up with Empty Form passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("verify Negative Form Fill Up with Empty Form failed");
            throw (e);
        }

    }

    private void verifyPositiveFormFillUp() throws Exception 
    {
        try 
        {
            AutomationLog.info("verify Positive Form Fill Up Wih Compulsory Fields Only started...");
            verifyPositiveFormFillUpWithCompulsoryFieldsOnly();
            
            AutomationLog.info("verify Positive Form Fill Up With All Fields Having Single Unit started...");
            verifyPositiveFormFillUpWithAllFieldsHavingSingleUnit();
            
            AutomationLog.info("verify Positive Form Fill Up With All Fields Having Multiple Units started...");
            verifyPositiveFormFillUpWithAllFieldsHavingMultipleUnits();
            
        }
        catch (Exception e) 
        {
            AutomationLog.error("verify Positive Form Fill Up failed");
            throw (e);
        }
    }

    private void verifyPositiveFormFillUpWithCompulsoryFieldsOnly() throws Exception 
    {
        try 
            {
                clearCurrentForm();
                dataFromCSV = testCaseData.get("CompulsoryResidentialFormData");
                nextPage = (SubmitListingMediaFormPage) fillCurrentFormAndClickSaveAndContinue(dataFromCSV);
                Assert.assertEquals(nextPage.form_Media().isDisplayed(), true, "details-residential form filled with compulsory fields should navigate to next page");
                AutomationLog.info("positive form fill up with compulsory fileds succesfull");
                nextPage.clickOnBackButton();
            }
            catch (Exception e) 
            {
                AutomationLog.error("details form fillup with compulsory fields failed");
                throw (e);
            }
    }

    private void verifyPositiveFormFillUpWithAllFieldsHavingMultipleUnits() throws Exception 
    {
        try
        {
            clearCurrentForm();
            dataFromCSV = testCaseData.get("TotalResidentialFormDataHavingMultipleUnits");
            nextPage = (SubmitListingMediaFormPage) fillCurrentFormAndClickSaveAndContinue(dataFromCSV);
            Assert.assertEquals(nextPage.form_Media().isDisplayed(), true, "details-residential form with multiple units should navigate to next page");
            AutomationLog.info("verify Positive Form Fill Up With All Fields Having Multiple Units passed");
            nextPage.clickOnBackButton();
         } 
        catch (Exception e) 
        {
            AutomationLog.error("verify Positive Form Fill Up With All Fields Having Multiple Units failed");
            throw (e);
        }
    }

    private void verifyPositiveFormFillUpWithAllFieldsHavingSingleUnit() throws Exception 
    {
        try
        {
            clearCurrentForm();
            dataFromCSV = testCaseData.get("TotalResidentialFormDataHavingSingleUnit");
            nextPage = (SubmitListingMediaFormPage) fillCurrentFormAndClickSaveAndContinue(dataFromCSV);
            Assert.assertEquals(nextPage.form_Media().isDisplayed(), true, "details-residential form with single unit should navigate to next page");
            AutomationLog.info("verify Positive Form Fill Up With All Fields Having Single Unit passed");
            nextPage.clickOnBackButton();
         } 
        catch (Exception e) 
        {
            AutomationLog.error("verify Positive Form Fill Up With All Fields Having Single Unit failed");
            throw (e);
        }
    }

    private void verifyAllDropDownOptions() throws Exception 
    {
        try 
        {
            AutomationLog.info("verifyAllDropDownOptionsForOfferTypes started");
            verifyAllDropDownOptionsForOfferTypes();

            AutomationLog.info("verifyAllDropDownOptionsForResidentialTypes started");
            verifyAllDropDownOptionsForResidentialTypes();

            AutomationLog.info("verifyAllDropDownOptionsForNoOfUnits started");
            verifyAllDropDownOptionsForNoOfUnits();

            AutomationLog.info("verifyAllDropDownOptions passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("verify All Drop Down Options failed");
            throw (e);
        }

    }

    private void verifyAllDropDownOptionsForNoOfUnits() throws Exception 
    {
        Collection<String> actualAllDisplayedNoOfUnits;
        Collection<String> expectedNoOfUnits;
        try 
        {
            dataFromCSV = testCaseData.get("NoOfUnits");
            expectedNoOfUnits = dataFromCSV.values();
            actualAllDisplayedNoOfUnits = detailsResidentialPage.txt_AllDisplayedNoOfUnits();
            Boolean actual = locationAction.compareTwoCollections(actualAllDisplayedNoOfUnits, expectedNoOfUnits);
            Boolean expected = true;
            Assert.assertEquals(actual, expected, "All No Of Units from dropdown do not match with required types");
            AutomationLog.info("verify All Drop Down Options For No Of Units passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("verify All Drop Down Options For No Of Units failed");
            throw (e);
        }
    }

    private void verifyAllDropDownOptionsForResidentialTypes() throws Exception 
    {
        Collection<String> actualAllDisplayedResidentialTypes;
        Collection<String> expectedResidentialTypes;
        try 
        {
            dataFromCSV = testCaseData.get("ResidentialTypes");
            expectedResidentialTypes = dataFromCSV.values();
            actualAllDisplayedResidentialTypes = detailsResidentialPage.txt_AllDisplayedResidentialTypes();
            Boolean actual = locationAction.compareTwoCollections(actualAllDisplayedResidentialTypes, expectedResidentialTypes);
            Boolean expected = true;
            Assert.assertEquals(actual, expected, "All Residential Types from dropdown do not match with required types");
            AutomationLog.info("verify All DropDown Options For Residential Types passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("verify All Drop Down Options For Residential Types failed");
            throw (e);
        }
    }

    private void verifyAllDropDownOptionsForOfferTypes() throws Exception 
    {
        Collection<String> actualAllDisplayedListingOfferTypes;
        Collection<String> expectedListingOfferTypes;
        try 
        {
            dataFromCSV = testCaseData.get("ListingOffersForResidential");
            expectedListingOfferTypes = dataFromCSV.values();
            actualAllDisplayedListingOfferTypes = detailsResidentialPage.txt_AllDisplayedListingOfferTypes();
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

    public void clearCurrentForm() throws Exception 
    {
        try
        {
            detailsResidentialPage.clearPropertyName();
            detailsResidentialPage.clearSpaceSizeMin();
            if(detailsResidentialPage.get_SelectedNoOfUnits().equals("Multiple units"))
            {
            	detailsResidentialPage.clearSpaceSizeMax();
            }
            detailsResidentialPage.clearBedrooms();
            detailsResidentialPage.clearBathrooms();
            detailsResidentialPage.clearAskingPriceMin();
            if(detailsResidentialPage.get_SelectedNoOfUnits().equals("Multiple units"))
            {
            	detailsResidentialPage.clearAskingPriceMax();
            }
            detailsResidentialPage.clearDescription();
            
            AutomationLog.info("cleared details-residential Form sucessfully");
        } 
        catch (Exception e) 
        {
            AutomationLog.error("failed to clear details-residential form");
            throw (e);
        }
    }

    public Page fillCurrentFormAndClickSaveAndContinue(HashMap<String, String> dummyFormData) throws Exception 
    {
        Page page = null;
        try
        {
            if(dummyFormData.get("ListingOffer") != null)
            	detailsResidentialPage.selectListingOfferDropdown(dummyFormData.get("ListingOffer"));	

            if(dummyFormData.get("ResidentialType") != null)
            {
            	detailsResidentialPage.selectResidentialTypeDropdown(dummyFormData.get("ResidentialType"));
            }

            if(dummyFormData.get("NoOfUnits") != null)
            {
            	detailsResidentialPage.selectNoOfUnitsDropdown(dummyFormData.get("NoOfUnits"));
            }

            if(dummyFormData.get("PropertyName") != null)
            	detailsResidentialPage.setPropertyName(dummyFormData.get("PropertyName"));

            if(dummyFormData.get("SpaceSizeMin") != null)
            	detailsResidentialPage.setSpaceSizeMin(dummyFormData.get("SpaceSizeMin"));

            if(dummyFormData.get("SpaceSizeMax") != null)
            	detailsResidentialPage.setSpaceSizeMax(dummyFormData.get("SpaceSizeMax"));

            if(dummyFormData.get("Bedrooms") != null)
            	detailsResidentialPage.setBedrooms(dummyFormData.get("Bedrooms"));

            if(dummyFormData.get("Bathrooms") != null)
            	detailsResidentialPage.setBathrooms(dummyFormData.get("Bathrooms"));

            if(dummyFormData.get("PriceMin") != null)
            	detailsResidentialPage.setAskingPriceMin(dummyFormData.get("PriceMin"));

            if(dummyFormData.get("PriceMax") != null)
            	detailsResidentialPage.setAskingPriceMax(dummyFormData.get("PriceMax"));

            if(dummyFormData.get("PriceUnit") != null)
            	detailsResidentialPage.selectAskingPriceUnit(dummyFormData.get("PriceUnit"));

            if(dummyFormData.get("Description") != null)
            	detailsResidentialPage.setDescription(dummyFormData.get("Description"));

            detailsResidentialPage.clickSaveAndContinue();

            AutomationLog.info("filled details-residential form and clicked save and continue successfully");
            page = new SubmitListingMediaFormPage(Page.driver);
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to fill details-residential form and clicking save and continue");
            throw (e);
        }
        return page;
    }

    @Override
    protected String successMessage() 
    {
         return "tested details-residential page sucessfully";
    }

    @Override
    protected String failureMessage() 
    {
         return "testing of details-residential page failed";
    }

}
