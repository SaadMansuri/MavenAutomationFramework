package com.agorafy.automation.testcases.submitlisting;
/**
 * Precondition:Do valid login
 * Navigate to submit Listing page
 * fill location form and select listing type as office
 * verify all test cases
 */
import java.util.Collection;
import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.submitlisting.SubmitListingDetailsFormOfficePage;
import com.agorafy.automation.pageobjects.submitlisting.SubmitListingMediaFormPage;

public class SubmitListingDetailsFormOfficeAction extends SubmitListingBaseAction 
{
    SubmitListingDetailsFormOfficePage detailsOfficePage;
    SubmitListingMediaFormPage nextPage;
    SubmitListingDetailsFormOfficeAction detailsOfficeAction;
    private Integer noOfSpacesAddedSeenInSpaceHeader;
    private Integer noOfSpacesAddedSeenInSpaceList;
    private Integer combinationNo;
    private String getCombination;
    private SubmitListingLocationFormAction locationAction;

    public SubmitListingDetailsFormOfficeAction() 
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
            detailsOfficeAction = new SubmitListingDetailsFormOfficeAction();
            locationAction = new SubmitListingLocationFormAction();
            dataFromCSV = testCaseData.get("LocationCombination16");
            detailsBasePage = locationPage.fillLocationFormAndClickSaveAndContinue(dataFromCSV);
            detailsOfficePage = (SubmitListingDetailsFormOfficePage) detailsBasePage.selectListingTypeDropdown("Office");

            AutomationLog.info("verify All Drop Down Options started...");
            verifyAllDropDownOptions();

            AutomationLog.info("verify Positive Form Fill Up started...");
            verifyPositiveFormFillUp();

            AutomationLog.info("verify Add Space started ...");
            verifyAddSpace();

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

            AutomationLog.info("verify Negative Form Fill Up Added Space Only started ...");
            verifyNegativeFormFillUpAddedSpaceOnly();

            AutomationLog.info("verify Negative Form Fill Up With Asking Price Only started...");
            verifyNegativeFormFillUpWithAskingPriceOnly();

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
            dataFromCSV = testCaseData.get("NegativeOfficeFormDataWithoutCompulsoryFields");
            fillCurrentFormAndClickSaveAndContinue(dataFromCSV);
            Assert.assertEquals(detailsOfficePage.form_Property().isDisplayed(), true,"details form filled without compulsory fields should not navigate to media page");
            AutomationLog.info("verify Negative Form Fill Up Without Compulsory Fields passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("verify Negative Form Fill Up Without Compulsory Fields failed");
            throw (e);
        }
	}

	private void verifyNegativeFormFillUpWithAskingPriceOnly() throws Exception 
	{
		try 
        {
            clearCurrentForm();
            dataFromCSV = testCaseData.get("NegativeOfficeFormDataWithAskingPriceOnly");
            fillCurrentFormAndClickSaveAndContinue(dataFromCSV);
            Assert.assertEquals(detailsOfficePage.form_Property().isDisplayed(), true, "Details form filled with asking price, should not navigate to media page");
            AutomationLog.info("verify Negative Form Fill Up With Asking Price Only passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("verify Negative Form Fill Up With Asking Price Only failed");
            throw (e);
        }
	}

	private void verifyNegativeFormFillUpAddedSpaceOnly() throws Exception 
	{
		try 
        {
            clearCurrentForm();
            dataFromCSV = testCaseData.get("NegativeOfficeFormDataWithAddSpaceOnly");
            fillCurrentFormAndClickSaveAndContinue(dataFromCSV);
            Assert.assertEquals(detailsOfficePage.form_Property().isDisplayed(), true, "Details form filled with added space only, should not navigate to media page");
            AutomationLog.info("verify Negative Form Fill Up Added Space Only passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("verify Negative Form Fill Up Added Space Only failed");
            throw (e);
        }	
    }

    private void verifyNegativeFormFillUpEmptyForm() throws Exception 
    {
        try 
        {
            clearCurrentForm();
            detailsOfficePage.clickSaveAndContinue();
            Assert.assertEquals(detailsOfficePage.form_Property().isDisplayed(), true, "Details form with empty fields should not navigate to media page");
            AutomationLog.info("verify Negative Form Fill Up Empty Form passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("verify Negative Form Fill Up Empty Form failed");
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

    private void verifyPositiveFormFillUpWithAllFields() throws Exception 
    {
        try
        {
            clearCurrentForm();
            dataFromCSV = testCaseData.get("TotalOfficeFormData");
            nextPage = (SubmitListingMediaFormPage) fillCurrentFormAndClickSaveAndContinue(dataFromCSV);
            Assert.assertEquals(nextPage.form_Media().isDisplayed(), true, "Details form filled with all fields should navigate to media page");
            AutomationLog.info("verify Positive Form Fill Up With All Fields passed");
            nextPage.clickOnBackButton();
            clearCurrentForm();
         } 
        catch (Exception e) 
        {
            AutomationLog.error("verify Positive Form Fill Up With All Fields failed");
            throw (e);
        }
    }

    private void verifyPositiveFormFillUpWithCompulsoryFieldsOnly() throws Exception 
    {
        try 
        {
            clearCurrentForm();
            dataFromCSV = testCaseData.get("CompulsoryOfficeFormData");
            nextPage = (SubmitListingMediaFormPage) fillCurrentFormAndClickSaveAndContinue(dataFromCSV);
            Assert.assertEquals(nextPage.form_Media().isDisplayed(), true, "Details form filled with compulsory fields should navigate to media page");
            AutomationLog.info("positive form fill up with compulsory fileds succesfull");
            nextPage.clickOnBackButton();
        }
        catch (Exception e) 
        {
            AutomationLog.error("details form fillup with compulsory fields failed");
            throw (e);
        }
    }

    private void verifyAllDropDownOptions() throws Exception
    {
        try 
        {
            AutomationLog.info("verify All Drop Down Options For Offer Types started");
            verifyAllDropDownOptionsForOfferTypes();

            AutomationLog.info("verify All Drop Down Options passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("verify All Drop Down Options failed");
            throw (e);
        }

    }

    private void verifyAllDropDownOptionsForOfferTypes() throws Exception 
    {
        Collection<String> actualAllDisplayedListingOfferTypes;
        Collection<String> expectedListingOfferTypes;
        try 
        {
            dataFromCSV = testCaseData.get("ListingOffersForOffice");
            expectedListingOfferTypes = dataFromCSV.values();
            actualAllDisplayedListingOfferTypes = detailsOfficePage.txt_AllDisplayedListingOfferTypes();
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

    private void verifyAddSpace() throws Exception 
    {
        try 
        {
            AutomationLog.info("verify Add Space Positive Combinations started ...");
            verifyAddSpacePositiveCombinations();

            AutomationLog.info("verify Edit Space started...");
            verifyEditSpace();

            AutomationLog.info("verify Remove All Added Spaces started...");
            verifyRemoveAllAddedSpaces();

            AutomationLog.info("verify Add Space Negative Combinations started...");
            verifyAddSpaceNegativeCombinations();

            AutomationLog.info("verify Add Space passed...");
        }
        catch (Exception e) 
        {
            throw (e);
        }

    }

    private void verifyEditSpace() throws Exception 
    {
        try 
        {
            AutomationLog.info("verify Edit Space Data Matching started...");
            verifyEditSpaceDataMatching();

            AutomationLog.info("verify Edit Space Save started...");
            verifyEditSpaceSave();	

            AutomationLog.info("verify Edit Space Cancel started...");
            verifyEditSpaceCancel();

            AutomationLog.info("verify Edit Space passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("verify Edit Space failed");
            throw (e);
        }
    }

    private void verifyEditSpaceCancel() throws Exception 
    {
        try 
        {
            String spaceInfoFromListOld = detailsOfficePage.getSpaceInfo();
            detailsOfficePage.clickEditSpace();
            detailsOfficePage.clickCancel();
            String spaceInfoFromListNew = detailsOfficePage.getSpaceInfo();
            Assert.assertEquals(spaceInfoFromListOld, spaceInfoFromListNew, "space info shown in list changes after clicking cancel button");
            AutomationLog.info("verify Edit Space Cancel passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("edit space cancel failed");
            throw (e);
        }
    }

    private void verifyEditSpaceSave() throws Exception 
    {
        //verify data change in text boxes reflects back into space list
        String newSpaceSize = null;
        try 
        {
        	detailsOfficePage.clickEditSpace();
            newSpaceSize = "5555";
            detailsOfficePage.clearSpaceSize();
            detailsOfficePage.setSpaceSize(newSpaceSize);
            detailsOfficePage.clickSave();
            String spaceInfoFromList = detailsOfficePage.getSpaceInfo();
            boolean isChangeReflected;
            isChangeReflected = spaceInfoFromList.contains(newSpaceSize);
            Assert.assertEquals(isChangeReflected, true, "data change in text box is not reflected in space list:");
            AutomationLog.info("data change in text box is reflected in space list:");
        }
        catch (Exception e) 
        {
            AutomationLog.error("verify Edit Space Save failed");
            throw (e);
        }
    }

    private void verifyEditSpaceDataMatching() throws Exception
    {
        //verify whether data in text boxes matches with data of space in list after edit space icon clicked
        try 
        {
            String spaceInfoFromList = detailsOfficePage.getSpaceInfo();
            detailsOfficePage.clickEditSpace();
            String spaceName = detailsOfficePage.getSpaceName();
            String spaceSize = detailsOfficePage.getSpaceSize();
            String spaceType = detailsOfficePage.getSelectedSpaceType();
            String spaceInfoInRespectiveBox = spaceType;
            spaceInfoInRespectiveBox = spaceInfoInRespectiveBox.concat(", ").concat(spaceName).concat(", ").concat(spaceSize);
            Assert.assertEquals(spaceInfoInRespectiveBox,	spaceInfoFromList, "space info in space list and in respective boxes does not match:");
            AutomationLog.info("space info in space list and in respective boxes matches");
        }
        catch (Exception e) 
        {
            AutomationLog.error("verify Edit Space Data Matching failed");
            throw (e);
        }
    }

    private void verifyRemoveAllAddedSpaces() throws Exception 
    {
        try 
        {
            noOfSpacesAddedSeenInSpaceHeader = detailsOfficePage.noOfSpacesAddedSeenInSpaceHeader();
            for(Integer index=1; index <= noOfSpacesAddedSeenInSpaceHeader; index++)
            {
                detailsOfficePage.removeSpaceElement(0);
            }
            noOfSpacesAddedSeenInSpaceHeader = detailsOfficePage.noOfSpacesAddedSeenInSpaceHeader();
            noOfSpacesAddedSeenInSpaceList = detailsOfficePage.noOfSpacesAddedSeenSpaceInList();
            Integer addedSpaces = 0;
            Assert.assertEquals(noOfSpacesAddedSeenInSpaceHeader, addedSpaces, "no of spaces added and count in space header do not matches");
            Assert.assertEquals(noOfSpacesAddedSeenInSpaceList, addedSpaces, "no of spaces added and total no of spaces in space list do not matches");
            AutomationLog.info("verifyRemoveAllAddedSpaces passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("verify Remove All Added Spaces failed");
            throw (e);
        }
    }

    private void verifyAddSpaceNegativeCombinations() throws Exception 
    {
        try 
        {
            //verifyAddSpaceNegativeCombinations empty combination with all fields empty
           	clearCurrentForm();
           	detailsOfficePage.clickSaveAndContinue();
           	noOfSpacesAddedSeenInSpaceHeader = detailsOfficePage.noOfSpacesAddedSeenInSpaceHeader();
           	noOfSpacesAddedSeenInSpaceList = detailsOfficePage.noOfSpacesAddedSeenSpaceInList();
           	Integer addedSpaces = 0;
           	Assert.assertEquals(noOfSpacesAddedSeenInSpaceHeader, addedSpaces, "no of spaces added and count in space header do not matches");
            Assert.assertEquals(noOfSpacesAddedSeenInSpaceList, addedSpaces, "no of spaces added and total no of spaces in space list do not matches");
            AutomationLog.info("Add space with all empty fields do not adds new space");

            for(combinationNo = 2; combinationNo< 4; combinationNo++)
            {
            getCombination = "AddSpaceNegativeCombination"+combinationNo;
            dataFromCSV = testCaseData.get(getCombination);
            addSpace(dataFromCSV);
            detailsOfficePage.clearSpaceSize();
            noOfSpacesAddedSeenInSpaceHeader = detailsOfficePage.noOfSpacesAddedSeenInSpaceHeader();
            noOfSpacesAddedSeenInSpaceList = detailsOfficePage.noOfSpacesAddedSeenSpaceInList();
            Assert.assertEquals(noOfSpacesAddedSeenInSpaceHeader, addedSpaces, "no of spaces added and count in space header do not matches");
            Assert.assertEquals(noOfSpacesAddedSeenInSpaceList, addedSpaces, "no of spaces added and total no of spaces in space list do not matches");
            AutomationLog.info("add space with following combination not adds new space:"+dataFromCSV);
            }

        }
        catch (Exception e) 
        {
            AutomationLog.error("add space with following combination adds new space:" +dataFromCSV);
            throw (e);
        }
    }

    private void verifyAddSpacePositiveCombinations() throws Exception 
    {
        try 
        {
            for(combinationNo = 1; combinationNo< 4; combinationNo++)
            {
                getCombination = "AddSpacePositiveCombination"+combinationNo;
                dataFromCSV = testCaseData.get(getCombination);
                addSpace(dataFromCSV);
                noOfSpacesAddedSeenInSpaceHeader = detailsOfficePage.noOfSpacesAddedSeenInSpaceHeader();
                noOfSpacesAddedSeenInSpaceList = detailsOfficePage.noOfSpacesAddedSeenSpaceInList();
                Assert.assertEquals(noOfSpacesAddedSeenInSpaceHeader, combinationNo, "no of spaces added and count in space header do not matches");
                Assert.assertEquals(noOfSpacesAddedSeenInSpaceList, combinationNo, "no of spaces added and total no of spaces in space list do not matches");
                AutomationLog.info("add space with following combination adds new space:"+dataFromCSV);
            }

        }
        catch (Exception e) 
        {
            AutomationLog.error("add space with following combination should add new space:"+dataFromCSV);
            throw (e);
        }
    }

    public void clearCurrentForm() throws Exception 
    {
        try 
        {
            removeAllAddedSpaces();
            detailsOfficePage.clearAskingPrice();
            detailsOfficePage.clearCeilingHeight();
            detailsOfficePage.clearCombinable();
            detailsOfficePage.clearElectricity();
            detailsOfficePage.clearDescription();

            AutomationLog.info("cleared Current Form successfully ");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to clear Current Form");
            throw (e);
        }
    }

    private void removeAllAddedSpaces() 
    {
    	try 
        {
            noOfSpacesAddedSeenInSpaceHeader = detailsOfficePage.noOfSpacesAddedSeenInSpaceHeader();
            for(Integer index=1; index <= noOfSpacesAddedSeenInSpaceHeader; index++)
            {
                detailsOfficePage.removeSpaceElement(0);
            }
            AutomationLog.info("All added spaces removed sucessfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to remove all added spaces");
            throw (e);
        }
    }

    public void addSpace(HashMap<String, String> dataFromCSV) throws Exception
    {
        try 
        {
            if(dataFromCSV.get("SpaceType") != null)
            detailsOfficePage.selectSpaceType(dataFromCSV.get("SpaceType"));

            if(dataFromCSV.get("SpaceName") != null)
            detailsOfficePage.selectSpaceName();

            if(dataFromCSV.get("SpaceSize") != null)
            detailsOfficePage.setSpaceSize(dataFromCSV.get("SpaceSize"));

            detailsOfficePage.clickAddSpace();

            AutomationLog.info("added Space sucessfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to add Space");
            throw (e);
        }
    }

    public Page fillCurrentFormAndClickSaveAndContinue(HashMap<String, String> dummyFormData) throws Exception 
    {
        Page page = null;
        try 
        {
            if(dummyFormData.get("ListingOffer") != null)
            detailsOfficePage.selectListingOfferDropdown(dummyFormData.get("ListingOffer"));	

            if(dummyFormData.get("AddSpace") != null)
            {
                dataFromCSV = testCaseData.get("AddSpacePositiveCombination1");
                addSpace(dataFromCSV);
            }

            if(dummyFormData.get("AskingPrice") != null)
            {
                detailsOfficePage.setAskingPrice(dummyFormData.get("AskingPrice"));
                detailsOfficePage.selectAskingPriceUnit(dummyFormData.get("AskingPriceUnit"));
            }

            if(dummyFormData.get("CeilingHeight") != null)
            detailsOfficePage.setCeilingHeight(dummyFormData.get("CeilingHeight"));

            if(dummyFormData.get("Combinable") != null)
            detailsOfficePage.setCombinable(dummyFormData.get("Combinable"));

            if(dummyFormData.get("Electricity") != null)
            detailsOfficePage.setElectricity(dummyFormData.get("Electricity"));

            if(dummyFormData.get("Description") != null)
            detailsOfficePage.setDescription(dummyFormData.get("Description"));

            detailsOfficePage.clickSaveAndContinue();

            AutomationLog.info("filled details-Office form and click save and continue sucessfully");

            page = new SubmitListingMediaFormPage(Page.driver);
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to fill details-office form and click save and continue");
            throw (e);
        }

        return page;
    }

    @Override
    protected String successMessage() 
    {
        return "testing details-office page passed";
    }

    @Override
    protected String failureMessage() 
    {
       return "testing details-office page failed";
    }

}
