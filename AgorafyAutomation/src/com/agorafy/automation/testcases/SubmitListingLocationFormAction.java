package com.agorafy.automation.testcases;
import java.util.HashMap;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.SubmitListingLocationFormPage;
import com.agorafy.automation.pageobjects.Page;
/**
 * Precondition:Do valid login
 * Navigate to submit Listing page
 * Verify empty input combination
 * verify negative input-13 combinations
 * verify positive input-2 combinations
 */
public class SubmitListingLocationFormAction extends AutomationTestCaseVerification 
{
    private Homepage homepage = null;
    private HeaderLoginForm headerLoginForm = null;
    Header header = null;
    SubmitListingLocationFormPage submitListingLocationFormPage = null;
    HashMap<String, String> dummyLocationData = new HashMap<String, String>();
    HashMap<String, String> dummyLocationDataFromCSV= null;
    
    public SubmitListingLocationFormAction() 
    {
         super();
    }

    public void setup()
    {
        super.setup();
        homepage = Homepage.homePage();
        header = Header.header();
        try 
        {
            headerLoginForm = homepage.openHeaderLoginForm();
            Credentials ValidCredentials = userCredentials();
            headerLoginForm.doSuccessfulLogin(ValidCredentials.getEmail(), ValidCredentials.getPassword());
            WaitFor.waitUntilElementIsLoaded(Page.driver, header.getProfileNameLocator());
            submitListingLocationFormPage = (SubmitListingLocationFormPage) header.clickSubmitListing(true);
            WaitFor.waitUntilElementIsLoaded(Page.driver, submitListingLocationFormPage.getAddressLocator());
        }
        catch (Exception e) 
        {
            AutomationLog.error("Submit listing location form page not found");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
        verifyNegativeLocationCombinations();
        verifyPositiveLocationCombinations();
    }

    public void verifyNegativeLocationCombinations() throws Exception
    {
        setkeysOfDummyLocationData();
        int index = 1;
        try
        {
            //for all empty combinations
            submitListingLocationFormPage.clearLocationFields();
            submitListingLocationFormPage.btn_SaveAndContinue();
            WaitFor.waitUntilElementIsLoaded(Page.driver, submitListingLocationFormPage.getAddressLocator());
            AutomationLog.info("Empty combination passed");

            //for all other negative combinations
            for(index=2; index<15; index++)
            {
                String para = "LocationCombination"+index ;
                dummyLocationDataFromCSV = testCaseData.get(para);
                setValuesOfDummyLocationData(dummyLocationDataFromCSV);
                submitListingLocationFormPage.clearLocationFields();
                fillingLocationForm(dummyLocationData);
                submitListingLocationFormPage.btn_SaveAndContinue();
                WaitFor.waitUntilElementIsLoaded(Page.driver, submitListingLocationFormPage.getAddressLocator());
                AutomationLog.info(index +"combination passed");
                dummyLocationData.clear();
            }
        }
        catch(Exception e)
        {
            AutomationLog.error(index +"combination failed");
            throw(e);
        }
    }

    public void verifyPositiveLocationCombinations() throws Exception
    {
        setkeysOfDummyLocationData();
        int index = 0;
        try
        {
            for(index=15; index<17; index++)
            {
                String para = "LocationCombination"+index ;
                dummyLocationDataFromCSV = testCaseData.get(para);
                setValuesOfDummyLocationData(dummyLocationDataFromCSV);
                submitListingLocationFormPage.clearLocationFields();
                fillingLocationForm(dummyLocationData);
                submitListingLocationFormPage.clickSaveAndContinue();;
                WaitFor.waitUntilElementIsLoaded(Page.driver, submitListingLocationFormPage.getBackBtnOnDetailsPageLocator());
                submitListingLocationFormPage.clickBackBtnOnDetails();
                AutomationLog.info(index +"combination passed");
                WaitFor.waitUntilElementIsLoaded(Page.driver, submitListingLocationFormPage.getAddressLocator());
            }
        }
        catch(Exception e)
        {
            AutomationLog.error(index +"combination failed");
            throw(e);
        }
    }

    public void setkeysOfDummyLocationData()
    {
        dummyLocationData.put("address","");
        dummyLocationData.put("city","");
        dummyLocationData.put("state","");
        dummyLocationData.put("zipcode","");
    }

    public void setValuesOfDummyLocationData(HashMap<String, String> dummyLocationDataFromCSV) 
    {
        dummyLocationData.put("address", dummyLocationDataFromCSV.get("address"));
        dummyLocationData.put("city", dummyLocationDataFromCSV.get("city"));
        dummyLocationData.put("state", dummyLocationDataFromCSV.get("state"));
        dummyLocationData.put("zipcode", dummyLocationDataFromCSV.get("zipcode"));
    }

    public void fillingLocationForm(HashMap<String , String> dummyLocationData) throws Exception
    {
        try 
        {
            submitListingLocationFormPage.setAddress(dummyLocationData.get("address"));
            submitListingLocationFormPage.setCity(dummyLocationData.get("city"));
            submitListingLocationFormPage.setState(dummyLocationData.get("state"));
            submitListingLocationFormPage.setZipCode(dummyLocationData.get("zipcode"));
            AutomationLog.info("location form filled successfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to fill location form");
            throw(e);
        }
    }

    @Override
    protected String successMessage() 
    {
        return "Submit Listing Location Form Action Successfully tested";
    }

    @Override
    protected String failureMessage() 
    {
        return "Submit Listing Location Form Action testing failed";
    }
}
