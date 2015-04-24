package com.agorafy.automation.testcases.submitlisting;
import java.util.Collection;
import java.util.HashMap;
import org.testng.Assert;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.submitlisting.SubmitListingDetailsFormBasePage;
import com.agorafy.automation.pageobjects.Page;
/**
 * Precondition:Do valid login
 * Navigate to submit Listing page
 * Verify empty input combination
 * verify negative input-13 combinations
 * verify positive input-2 combinations
 */
public class SubmitListingLocationFormAction extends SubmitListingBaseAction 
{
    Header header = null;
    HashMap<String, String> dataFromCSV = new HashMap<>();
    public SubmitListingDetailsFormBasePage nextPage;
    public Integer combinationNo;
    public String getCombination;
    public Integer noOfSpacesAddedSeenInSpaceHeader;
    public Integer noOfSpacesAddedSeenInSpaceList;

    public SubmitListingLocationFormAction() 
    {
        super();
    }

    public void setup()
    {
        super.setup();
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
        AutomationLog.info("verifyNegativeLocationCombinations started ...");
        verifyNegativeLocationCombinations();

        AutomationLog.info("verifyPositiveLocationCombinations started ...");
        verifyPositiveLocationCombinations();
     }

    public void verifyNegativeLocationCombinations() throws Exception
    {
        try
        {
             /*Since, we can't add empty values in CSV file, 
             we have to set key's in hashmap for all fields*/

            setkeysOfDataFromCSV();

            //for all empty combinations
            clearCurrentForm();
            locationPage.clickSaveAndContinue();
            /*when we are on current form its CSS display property= block 
             * and we check that property to check whether we are on same or different form*/
            Assert.assertEquals(locationPage.form_Location().isDisplayed(), true, "Location form with all empty fields should not navigate to next page");
            AutomationLog.info("Location form with all empty fields stays on same page");

            //for all other negative combinations
            for(Integer combinationNo=2; combinationNo<15; combinationNo++)
            {
                getCombination = "LocationCombination"+combinationNo ;
                /*We use para to locate location combination no in CSV file, 
                 * see CSV file for more info*/ 
                dataFromCSV = testCaseData.get(getCombination);
                setValuesOfDataFromCSV(dataFromCSV);
                clearCurrentForm();
                locationPage.fillLocationFormAndClickSaveAndContinue(dataFromCSV);
                //We are not catching the returned object, because we don't need that
                Assert.assertEquals(locationPage.form_Location().isDisplayed(), true, "Location form with following combination should not navigate to next page"+ dataFromCSV);
                AutomationLog.info("Location form with following combination stays on same page" + dataFromCSV);
            }
        }
        catch(Exception e)
        {
            AutomationLog.error("Negative Location Combination failed");
            throw(e);
        }
    }

    public void verifyPositiveLocationCombinations() throws Exception
    {
        try
        {
             /*Since, we can't add empty values in CSV file, 
              * we have to set key's in hashmap for all fields*/
            setkeysOfDataFromCSV();
            for(Integer combinationNo=15; combinationNo<17; combinationNo++)
            {
                getCombination = "LocationCombination"+combinationNo;
                dataFromCSV = testCaseData.get(getCombination);
                setValuesOfDataFromCSV(dataFromCSV);
                clearCurrentForm();
                nextPage = (SubmitListingDetailsFormBasePage) locationPage.fillLocationFormAndClickSaveAndContinue(dataFromCSV);
                Assert.assertEquals(nextPage.form_Property().isDisplayed(), true, "Location form with following combination should navigate to details page"+ dataFromCSV);
                nextPage.clickBack();
                AutomationLog.info("Location form with following combination navigates to details page" + dataFromCSV);
                WaitFor.waitUntilElementIsLoaded(Page.driver, locationPage.getAddressLocator());
            }
        }
        catch(Exception e)
        {
            AutomationLog.error("Positive Location Combination failed");
            throw(e);
        }
    }

    public void setkeysOfDataFromCSV()
    {
        dataFromCSV.put("address"," ");
        dataFromCSV.put("city"," ");
        dataFromCSV.put("state"," ");
        dataFromCSV.put("zipcode"," ");
    }

    public void setValuesOfDataFromCSV(HashMap<String, String> dummyLocationDataFromCSV) 
    {
        dataFromCSV.put("address", dummyLocationDataFromCSV.get("address"));
        dataFromCSV.put("city", dummyLocationDataFromCSV.get("city"));
        dataFromCSV.put("state", dummyLocationDataFromCSV.get("state"));
        dataFromCSV.put("zipcode", dummyLocationDataFromCSV.get("zipcode"));
    }

    public void clearCurrentForm() throws Exception
    {
        try 
        {
            locationPage.clearAddress();
            locationPage.clearCity();
            locationPage.clearState();
            locationPage.clearZipCode();
            AutomationLog.info("clearing all fields of current form successfully");
         }
        catch (Exception e) 
         {
            AutomationLog.error("clearing all fields of current form failed");
            throw (e);
         }
    }
    
    @Override
    protected String successMessage()
    {
        return "Submit Listing Location Form Successfully tested";
    }

    @Override
    protected String failureMessage()
    {
        return "Submit Listing Location Form testing failed";
    }
}
