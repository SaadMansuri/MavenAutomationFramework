package com.agorafy.automation.testcases.submitlisting;
/**
 * Precondition:Do valid login
 * Navigate to submit Listing page
 * fill location form and select listing type as retail
 * verify all test cases
 */
import java.util.Collection;
import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.submitlisting.SubmitListingDetailsFormRetailPage;
import com.agorafy.automation.pageobjects.submitlisting.SubmitListingLocationFormPage;
import com.agorafy.automation.pageobjects.submitlisting.SubmitListingMediaFormPage;

public class SubmitListingDetailsFormRetailAction extends SubmitListingBaseAction
{
    private Integer index;
    private SubmitListingMediaFormPage nextPage;
    SubmitListingDetailsFormRetailPage detailsRetailPage;
    private Integer noOfSpacesAddedSeenInSpaceHeader;
    private Object noOfSpacesAddedSeenInSpaceList;
    SubmitListingLocationFormAction locationAction;

    public SubmitListingDetailsFormRetailAction() 
    {
        super();
    }

    @Override
    public void setup()
    {
        super.setup();
        try 
        {
            /*set up which fills location form and navigates to details page and then clicks retail option*/
            locationAction = new SubmitListingLocationFormAction();
            dataFromCSV = testCaseData.get("LocationCombination16");
            detailsBasePage = locationPage.fillLocationFormAndClickSaveAndContinue(dataFromCSV);
            detailsRetailPage = (SubmitListingDetailsFormRetailPage) detailsBasePage.selectListingTypeDropdown("Retail");
            AutomationLog.info("Setup to reach Details-Retails page passed");
        } 
        catch (Exception e) 
        {
            AutomationLog.error("Setup to reach Details-Retails page failed");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
        AutomationLog.info("verifying All Drop Down Options started...");
        verifyAllDropDownOptions();

        AutomationLog.info("verifying Positive Form FillUp started...");
        verifyPositiveFormFillUp();

        /*only add space related test script*/
        AutomationLog.info("verifying Add Space started...");
        verifyAddSpace();

        AutomationLog.info("verifying Negative Form FillUp started...");
        verifyNegativeFormFillUp();

    }

    private void verifyAllDropDownOptions() throws Exception 
    {
        try 
        {
            AutomationLog.info("verifying All DropDown Options For Listing Types started...");
            verifyAllDropDownOptionsForListingTypes();

            AutomationLog.info("verifying All DropDown Options For Offer Types started...");
            verifyAllDropDownOptionsForOfferTypes();

            AutomationLog.info("verifying All DropDown Options For Asking Price Units started...");
            verifyAllDropDownOptionsForAskingPriceUnits();

            AutomationLog.info("verifying All DropDown Options passed");
        } 
        catch (Exception e) 
        {
            AutomationLog.error("verifying All DropDown Options failed");
            throw (e);
        }

    }

    private void verifyAllDropDownOptionsForAskingPriceUnits() throws Exception 
    {
        Collection<String> actualAllDisplayedAskingPriceUnits;
        Collection<String> expectedAskingPriceUnits;
        try 
        {
            dataFromCSV = testCaseData.get("AskingPriceUnit");
            expectedAskingPriceUnits = dataFromCSV.values();
            actualAllDisplayedAskingPriceUnits = detailsRetailPage.txt_AllDisplayedAskingPriceUnits();
            Boolean actual = locationAction.compareTwoCollections(actualAllDisplayedAskingPriceUnits, expectedAskingPriceUnits);
            Boolean expected = true;
            Assert.assertEquals(actual, expected, "All Asking Price Units from dropdown do not match with required types");
            AutomationLog.info("All drop down options for Asking price units are same as expected");
        }
        catch (Exception e) 
        {
            AutomationLog.error("verification of All DropDown Options For Asking Price Units failed");
            throw (e);
        }
    }

    private void verifyAllDropDownOptionsForOfferTypes() throws Exception 
    {
        Collection<String> actualAllDisplayedListingOfferTypes;
        Collection<String> expectedListingOfferTypes;
        try 
        {
            dataFromCSV = testCaseData.get("ListingOffersForRetail");
            expectedListingOfferTypes = dataFromCSV.values();
            actualAllDisplayedListingOfferTypes = detailsRetailPage.txt_AllDisplayedListingOfferTypes();
            Boolean actual = locationAction.compareTwoCollections(actualAllDisplayedListingOfferTypes, expectedListingOfferTypes);
            Boolean expected = true;
            Assert.assertEquals(actual, expected, "All Listing offer types from dropdown do not match with required types");
            AutomationLog.info("All drop down options from listing offer types are same as expected");
        }
        catch (Exception e) 
        {
            AutomationLog.error("verification of All Drop Down Options For Offer Types failed");
            throw (e);
        }
    }

    private void verifyAllDropDownOptionsForListingTypes() throws Exception 
    {
        Collection<String> actualAllDisplayedListingTypes;
        Collection<String> expectedListingTypes;
        try 
        {
            dataFromCSV = testCaseData.get("ListingTypes");
            expectedListingTypes = dataFromCSV.values();
            actualAllDisplayedListingTypes = detailsRetailPage.txt_AllDisplayedListingTypes();
            Boolean actual = locationAction.compareTwoCollections(actualAllDisplayedListingTypes, expectedListingTypes); 
            Boolean expected = true;
            Assert.assertEquals(actual, expected, "All Listing types from dropdown do not match with required types");
            AutomationLog.info("All drop down options from listing types are same as expected");
        }
        catch (Exception e)
        {
            AutomationLog.error("verification of All Drop Down Options For Listing Types failed");
            throw (e);
        }
    }

    private void verifyNegativeFormFillUp() throws Exception 
    {
        try 
        {
            AutomationLog.info("verify Negative Form Fill Up Empty Form started...");
            verifyNegativeFormFillUpEmptyForm();

            AutomationLog.info("verify Negative Form Fill Up Added Space Only started...");
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
            dataFromCSV = testCaseData.get("NegativeRetailFormDataWithoutCompulsoryfields");
            detailsRetailPage.fillCurrentFormAndClickSaveAndContinue(dataFromCSV);
            Assert.assertEquals(detailsRetailPage.form_Property().isDisplayed(), true, "Details form without compulsory fields should not navigate to next page");
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
            dataFromCSV = testCaseData.get("NegativeRetailFormDataWithAskingPriceOnly");
            detailsRetailPage.fillCurrentFormAndClickSaveAndContinue(dataFromCSV);
            Assert.assertEquals(detailsRetailPage.form_Property().isDisplayed(), true, "Details form with asking price only should not navigate to next page");
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
            dataFromCSV = testCaseData.get("NegativeRetailFormDataWithAddSpaceOnly");
            detailsRetailPage.fillCurrentFormAndClickSaveAndContinue(dataFromCSV);
            Assert.assertEquals(detailsRetailPage.form_Property().isDisplayed(), true, "Details form with added space only should not navigate to next page");
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
            detailsRetailPage.clickSaveAndContinue();
            Assert.assertEquals(detailsRetailPage.form_Property().isDisplayed(), true, "Details form with empty form should not navigate to next page");
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
            
            AutomationLog.info("verify Positive Form Fill Up With All Fields started ...");
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
            dataFromCSV = testCaseData.get("TotalRetailFormData");
            nextPage = detailsRetailPage.fillCurrentFormAndClickSaveAndContinue(dataFromCSV);
            Assert.assertEquals(nextPage.form_Media().isDisplayed(), true, "details form with all fields fill-up should navigate to next page");
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

    private void verifyAddSpace() throws Exception
    {
        AutomationLog.info("verify Add Space Positive Combinations started...");
        verifyAddSpacePositiveCombinations();
        
        AutomationLog.info("verify Edit Space started...");
        verifyEditSpace();
        
        AutomationLog.info("verify Add Space Negative Combinations started...");
        verifyAddSpaceNegativeCombinations();
        
        AutomationLog.info("verify Remove All Added Spaces started...");
        verifyRemoveAllAddedSpaces(index);
    }

    private void verifyAddSpacePositiveCombinations() throws Exception 
    {	
        index = 0;
        try
        {
            AutomationLog.info("verify Add Space With Combinable Yes started...");
            verifyAddSpaceWithCombinableYes();

            AutomationLog.info("verify Add Space With Combinable No started ...");
            verifyAddSpaceWithCombinableNo();
        }
        catch(Exception e)
        {
            AutomationLog.error("positive add space failed");
            throw e;
        }
    }

    private void verifyAddSpaceWithCombinableNo() throws Exception
    {
        try 
        {
        	dataFromCSV = testCaseData.get("SpaceSize");
        	detailsRetailPage.addSpaceWithCombinableOption(false,dataFromCSV);
            index++;
            noOfSpacesAddedSeenInSpaceHeader = detailsRetailPage.noOfSpacesAddedSeenInSpaceHeader();
            noOfSpacesAddedSeenInSpaceList = detailsRetailPage.noOfSpacesAddedSeenSpaceInList();
            Assert.assertEquals(noOfSpacesAddedSeenInSpaceHeader, index, "no of spaces added and count in space header do not matches");
            Assert.assertEquals(noOfSpacesAddedSeenInSpaceList, index, "no of spaces added and total no of spaces in space list do not matches");
        }
        catch (Exception e) 
        {
            AutomationLog.error("add space with combinable No failed");
            throw (e);
        }
    }

    private void verifyAddSpaceWithCombinableYes() throws Exception 
    {
        try 
        {
            dataFromCSV = testCaseData.get("SpaceSize");
            detailsRetailPage.addSpaceWithCombinableOption(true, dataFromCSV);
            index++;
            noOfSpacesAddedSeenInSpaceHeader = detailsRetailPage.noOfSpacesAddedSeenInSpaceHeader();
            noOfSpacesAddedSeenInSpaceList = detailsRetailPage.noOfSpacesAddedSeenSpaceInList();
            Assert.assertEquals(noOfSpacesAddedSeenInSpaceHeader, index, "no of spaces added and count in space header do not matches");
            Assert.assertEquals(noOfSpacesAddedSeenInSpaceList, index, "no of spaces added and total no of spaces in space list do not matches");
        }
        catch (Exception e) 
        {
             AutomationLog.error("add space with combinable yes failed");
             throw (e);
        }
    }

    private void verifyEditSpace() throws Exception
    {
        AutomationLog.info("verify Edit Space Data Matching started...");
        verifyEditSpaceDataMatching();

        AutomationLog.info("verify Edit Space Save started...");
        verifyEditSpaceSave();	

        AutomationLog.info("verify Edit Space Cancel started...");
        verifyEditSpaceCancel();
    }

    private void verifyEditSpaceDataMatching() throws Exception
    {
        //verify whether data in text boxes matches with data of space in list after edit space icon clicked
        try 
        {
            String spaceInfoFromList = detailsRetailPage.getSpaceInfo();
            detailsRetailPage.clickEditSpace();
            String spaceName = detailsRetailPage.getSpaceName();
            String spaceSize = detailsRetailPage.getSpaceSize();
            String combinable = detailsRetailPage.whichCombinableIsChecked();		
            String spaceInfoInRespectiveBoxes = spaceName;
            spaceInfoInRespectiveBoxes = spaceInfoInRespectiveBoxes.concat(", ").concat(spaceSize).concat(", ").concat(combinable);
            Assert.assertEquals(spaceInfoInRespectiveBoxes,	spaceInfoFromList, "space info in space list and in respective boxes does not matches");
            AutomationLog.info("space info in space list and in respective boxes matches");
        }
        catch(Exception e)
        {
            AutomationLog.error("verify Edit Space Data Matching failed");
            throw (e);
        }
    }

    private void verifyEditSpaceSave() throws Exception
    {
        //verify data change in text boxes reflects back into space list
        String newSpaceSize = null;
        try 
        {
        	detailsRetailPage.clickEditSpace();
            newSpaceSize = "5555";
            detailsRetailPage.clearSpaceSize();
            detailsRetailPage.setSpaceSize(newSpaceSize);
            detailsRetailPage.clickSave();
            String spaceInfoFromList = detailsRetailPage.getSpaceInfo();
            boolean isChangeReflected;
            isChangeReflected = spaceInfoFromList.contains(newSpaceSize);
            Assert.assertEquals(isChangeReflected, true, "data change in text box is not reflected in space list");
            AutomationLog.info("data change in text box is reflected in space list:");
        }
        catch (Exception e) 
        {
            AutomationLog.error("verify Edit Space Save failed");
            throw (e);
        }
    }

    private void verifyEditSpaceCancel() throws Exception
    {
        try 
        {
            String spaceInfoFromListOld = detailsRetailPage.getSpaceInfo();
            detailsRetailPage.clickEditSpace();
            detailsRetailPage.clickCancel();
            String spaceInfoFromListNew = detailsRetailPage.getSpaceInfo();
            Assert.assertEquals(spaceInfoFromListOld, spaceInfoFromListNew, "space info shown in list changes after clicking cancel button");
            AutomationLog.info("verify Edit Space Cancel passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("edit space cancel failed");
            throw (e);
        }
    }

    private void verifyRemoveAllAddedSpaces(int maxSpaces) 
    {
        try
        {	
            for (int index = 0; index < maxSpaces; index++) 
            {
            	detailsRetailPage.removeSpaceElement(0);
            }
            AutomationLog.info("deletion of all spaces passed");
        }
        catch(Exception e)
        {
            AutomationLog.error("deletion of all spaces failed");
        }
    }

    private void verifyAddSpaceNegativeCombinations() throws Exception 
    {
        try 
        {
            AutomationLog.info("verify Add Space Negative Combination With All Inputs Empty started...");
            verifyAddSpaceNegativeCombinationWithAllInputsEmpty();
            
            AutomationLog.info("verify Add Space Negative Combination With Space Name Absent started ...");
            verifyAddSpaceNegativeCombinationWithSpaceNameAbsent();
             
            AutomationLog.info("verify Add Space Negative Combination With Space Size Absent started ...");
            verifyAddSpaceNegativeCombinationWithSpaceSizeAbsent();
        } 
        catch (Exception e) 
        {
            AutomationLog.error("add space negative combination failed");
            throw (e);
        }
    }

    private void verifyAddSpaceNegativeCombinationWithAllInputsEmpty() throws Exception 
    {
        try 
        {
        	detailsRetailPage.clickAddSpace();
            noOfSpacesAddedSeenInSpaceHeader = detailsRetailPage.noOfSpacesAddedSeenInSpaceHeader();
            noOfSpacesAddedSeenInSpaceList = detailsRetailPage.noOfSpacesAddedSeenSpaceInList();
            Assert.assertEquals(noOfSpacesAddedSeenInSpaceHeader, index, "no of spaces added and count in space header do not matches");
            Assert.assertEquals(noOfSpacesAddedSeenInSpaceList, index, "no of spaces added and total no of spaces in space list do not matches");
        }
        catch (Exception e) 
        {
            AutomationLog.info("Add space with empty inputs failed");
            throw (e);
        }	
    }

    private void verifyAddSpaceNegativeCombinationWithSpaceNameAbsent() throws Exception 
    {
        try 
        {
            dataFromCSV = testCaseData.get("SpaceSize");
            detailsRetailPage.setSpaceSize(dataFromCSV.get("SpaceSize1"));
            detailsRetailPage.clickAddSpace();
            noOfSpacesAddedSeenInSpaceHeader = detailsRetailPage.noOfSpacesAddedSeenInSpaceHeader();
            noOfSpacesAddedSeenInSpaceList = detailsRetailPage.noOfSpacesAddedSeenSpaceInList();
            Assert.assertEquals(noOfSpacesAddedSeenInSpaceHeader, index, "no of spaces added and count in space header do not matches");
            Assert.assertEquals(noOfSpacesAddedSeenInSpaceList, index, "no of spaces added and total no of spaces in space list do not matches");
        }
        catch (Exception e) 
        {
            AutomationLog.error("add space negative combination with space name absent failed");
            throw (e);
        }
    }

    private void verifyAddSpaceNegativeCombinationWithSpaceSizeAbsent() throws Exception 
    {
        try 
        {
        	detailsRetailPage.clearSpaceSize();
        	detailsRetailPage.selectSpaceName();
        	detailsRetailPage.clickAddSpace();
            noOfSpacesAddedSeenInSpaceHeader = detailsRetailPage.noOfSpacesAddedSeenInSpaceHeader();
            noOfSpacesAddedSeenInSpaceList = detailsRetailPage.noOfSpacesAddedSeenSpaceInList();
            Assert.assertEquals(noOfSpacesAddedSeenInSpaceHeader, index, "no of spaces added and count in space header do not matches");
            Assert.assertEquals(noOfSpacesAddedSeenInSpaceList, index, "no of spaces added and total no of spaces in space list do not matches");
        }
        catch (Exception e) 
        {
            AutomationLog.error("add space negative combination with space size absent failed");
            throw (e);
        }
    }

    private void verifyPositiveFormFillUpWithCompulsoryFieldsOnly() throws Exception
    {
        try 
        {
            clearCurrentForm();
            dataFromCSV = testCaseData.get("CompulsoryRetailFormData");
            nextPage = detailsRetailPage.fillCurrentFormAndClickSaveAndContinue(dataFromCSV);
            Assert.assertEquals(nextPage.form_Media().isDisplayed(), true, "After filling all compulsory data of retail form page should navigate to media form");
            AutomationLog.info("positive form fill up with compulsory fileds succesfull");
            nextPage.clickOnBackButton();
        }
        catch (Exception e) 
        {
            AutomationLog.error("details form fillup with compulsory fields failed");
            throw (e);
        }
    }

    public void clearCurrentForm() throws Exception
    {
        try
        {
            noOfSpacesAddedSeenInSpaceHeader = detailsRetailPage.noOfSpacesAddedSeenInSpaceHeader();
            verifyRemoveAllAddedSpaces(noOfSpacesAddedSeenInSpaceHeader);
            detailsRetailPage.clearAskingPrice();
            detailsRetailPage.clearFrontage();
            detailsRetailPage.clearCeilingHeight();
            detailsRetailPage.clearDescription();
            AutomationLog.info("clear This Form sucessfull");
        } 
        catch (Exception e) 
        {
            AutomationLog.error("clear This Form failed");
            throw (e);
        }
    }

    public SubmitListingMediaFormPage fillDetailsFormAndMoveToMediaForm(HashMap<String, HashMap<String, String>> data) throws Exception
    {
        detailsRetailPage = new SubmitListingDetailsFormRetailPage(Page.driver);
        try
        {
            if( !(detailsRetailPage.form_Property().isDisplayed()) )
            {
               locationPage = new SubmitListingLocationFormPage(Page.driver);
               detailsRetailPage = (SubmitListingDetailsFormRetailPage) locationPage.moveToDetailsForm(data);
            }
            nextPage = detailsRetailPage.fillDetailsRetailFormForPreviewSetup(data);
            AutomationLog.info("details form filled sucessfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to fill details form");
            throw (e);
        }
        return nextPage;
    }

    @Override
    protected String successMessage() 
    {
        return "tested successfully";
    }

    @Override
    protected String failureMessage() 
    {
        return "testing failed";
    }
}
