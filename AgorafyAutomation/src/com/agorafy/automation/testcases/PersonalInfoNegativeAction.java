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
        populateFields(personalInfo);
        verifyIfNameFieldLeftBlank();
    }

    private void verifyIfNameFieldLeftBlank() throws Exception
    {
        Assert.assertEquals(personalInfo.nameError(), expectedPersonalInfoData.get("failureMessage"),"No Error Message is shown");
        AutomationLog.info("Appropriate Error Message is shown");
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
