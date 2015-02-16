package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.datamodel.profile.UserProfile;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.PersonalInfo;

/**
 * Test Personal Information Tab for Negative Test Cases
 * Verify if error message is shown when name field is left blank
 */

public class PersonalInfoNegativeAction extends AccountSettingsBaseAction
{
    PersonalInfo personalInfo = null;
    HashMap<String, String> expectedPersonalInfoData  = null;

    public PersonalInfoNegativeAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        personalInfo =  accountSettings.clickOnPersonalInfoTab();
        expectedPersonalInfoData = testCaseData.get("PersonalInfo");
        HashMap<String, String> addressdata =testCaseData.get("AddressData");
        populateFields(personalInfo);
        verifyIfNameFieldLeftBlank();
        verifyIfAddressFieldLeftBlank(addressdata);
        verifyIfAddressFieldTakesSpecialCharacterAsInput();
        verifyIfCityFieldLeftBlank(addressdata);
        verifyIfCityFieldTakesNumbersAsInput();
        verifyIFStateFieldIsNotSelected(addressdata);
        verifyIfZipCodeFieldLeftBlank(addressdata);
        verifyIfZipFieldAcceptsCharctersOtherThanNumbersAsInput();
    }

    private void verifyIfNameFieldLeftBlank() throws Exception
    {
        Assert.assertEquals(personalInfo.nameError(), expectedPersonalInfoData.get("failureMessage"),"Appropriate Error Message is not shown");
    }

    public void verifyIfAddressFieldLeftBlank(HashMap<String, String> addressdata) throws Exception
    {
        HashMap<String, String> errors = testCaseData.get("WrongAddressData");
        HashMap<String, String> data = new HashMap<String, String>();
        data.putAll(addressdata);
        data.remove("address");
        fillAddressFields(data);
        personalInfo.clickOnSaveChangesBtn();
        String errmsg1 = errors.get("errorMsg1");
        String errmsg2 = errors.get("errorMsg2");
        String msg = personalInfo.addressError();
        Assert.assertEquals(msg.contains(errmsg1), true, "Expected error message not shown");
        Assert.assertEquals(msg.contains(errmsg2), true, "Expected error message not shown");
        AutomationLog.info("Empty Address field shows error message");
    }

    public void verifyIfAddressFieldTakesSpecialCharacterAsInput() throws Exception
    {
        HashMap<String, String> data = testCaseData.get("WrongAddressData");
        personalInfo.textBox_Address1().clear();
        personalInfo.textBox_Address1().sendKeys(data.get("invalidAddress"));
        personalInfo.clickOnSaveChangesBtn();
        Assert.assertEquals(personalInfo.addressError(), data.get("errorMsg2"), "Expected error message not shown");
        AutomationLog.info("Address Field shows error when special characters are entered as input");
    }

    public void verifyIfCityFieldLeftBlank(HashMap<String, String> addressdata) throws Exception
    {
        HashMap<String, String> errors = testCaseData.get("WrongCityData");
        HashMap<String, String> data = new HashMap<String, String>();
        data.putAll(addressdata);
        data.remove("city");
        fillAddressFields(data);
        personalInfo.clickOnSaveChangesBtn();
        String errmsg1 = errors.get("errorMsg1");
        String errmsg2 = errors.get("errorMsg2");
        String msg = personalInfo.cityError();
        Assert.assertEquals(msg.contains(errmsg1), true, "Expected error message not shown");
        Assert.assertEquals(msg.contains(errmsg2), true, "Expected error message not shown");
        AutomationLog.info("Empty City field shows error message");
        
    }

    public void verifyIfCityFieldTakesNumbersAsInput() throws Exception
    {
        HashMap<String, String> data = testCaseData.get("WrongCityData");
        personalInfo.textBox_City().clear();
        personalInfo.textBox_City().sendKeys(data.get("invalidCity"));
        personalInfo.clickOnSaveChangesBtn();
        Assert.assertEquals(personalInfo.cityError(), data.get("errorMsg2"), "Expected error message not shown");
        AutomationLog.info("City Field shows error when numbers are entered as input");
    }

    public void verifyIFStateFieldIsNotSelected(HashMap<String, String> addressdata) throws Exception
    {
        HashMap<String, String> errors = testCaseData.get("WrongStateData");
        HashMap<String, String> data = new HashMap<String, String>();
        data.putAll(addressdata);
        data.put("state", "");
        fillAddressFields(data);
        personalInfo.clickOnSaveChangesBtn();
        Assert.assertEquals(personalInfo.stateError(), errors.get("errorMsg"), "Expected error message not shown ");
        AutomationLog.info("State field shows error message if not selected from dropdown");
    }

    public void verifyIfZipCodeFieldLeftBlank(HashMap<String, String> addressdata) throws Exception
    {
        HashMap<String, String> errors = testCaseData.get("WrongZipCodeData");
        HashMap<String, String> data = new HashMap<String, String>();
        data.putAll(addressdata);
        data.remove("zipcode");
        fillAddressFields(data);
        personalInfo.clickOnSaveChangesBtn();
        String errmsg1 = errors.get("errorMsg1");
        String errmsg2 = errors.get("errorMsg2");
        String msg = personalInfo.zipError();
        Assert.assertEquals(msg.contains(errmsg1), true, "Expected error message not shown");
        Assert.assertEquals(msg.contains(errmsg2), true, "Expected error message not shown");
        AutomationLog.info("Empty ZipCode field shows error message");
    }

    public void verifyIfZipFieldAcceptsCharctersOtherThanNumbersAsInput() throws Exception
    {
        HashMap<String, String> data = testCaseData.get("WrongZipCodeData");
        personalInfo.textBox_Zip().clear();
        personalInfo.textBox_Zip().sendKeys(data.get("invalidZip"));
        personalInfo.clickOnSaveChangesBtn();
        Assert.assertEquals(personalInfo.zipError(), data.get("errorMsg2"), "Expected error message is not shown");
        AutomationLog.info("Zipcode Field shows error when characters other than numbers  entered as input");
    }

    public void fillAddressFields(HashMap<String, String> addressdata ) throws Exception
    {
        personalInfo.textBox_Address1().clear();
        personalInfo.textBox_Address1().sendKeys(addressdata.get("address"));
        personalInfo.textBox_City().clear();
        personalInfo.textBox_City().sendKeys(addressdata.get("city"));
        personalInfo.selectState(addressdata.get("state"));
        personalInfo.textBox_Zip().clear();
        personalInfo.textBox_Zip().sendKeys(addressdata.get("zipcode"));
    }

    private void populateFields(PersonalInfo pInfo) throws Exception
    {
        UserProfile profileData = getUserProfileData();
        pInfo.populateData(profileData);
        pInfo = pInfo.clickOnSaveChangesBtn();
        WaitFor.waitForPageToLoad(Page.driver);
    }

    private UserProfile getUserProfileData()
    {
        UserProfile profile = new UserProfile();
        profile.setName("");
        return profile;
    }

    @Override
    protected String successMessage()
    {
        return "Personal Information Negative Scenario tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Personal Info Negative Action Failed";
    }
}
