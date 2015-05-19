package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.datamodel.profile.UserProfile;
import com.agorafy.automation.pageobjects.PersonalInfo;

/**
 * Test Personal Information Tab for Positive Test Cases
 * Verify if Name field is editable
 * Verify if Name field shows the changed name after clicking Save button
 * Verify if Profile Name on header shows Changed Name
 * Verify that Email field shows email id of the user logged In
 * Verify that Email field is not editable
 */

public class PersonalInfoPositiveAction extends AccountSettingsBaseAction
{
    PersonalInfo personalInfo = null;
    HashMap<String, String> expectedpersonalInfoData = null;

    public PersonalInfoPositiveAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        personalInfo =  accountSettings.clickOnPersonalInfoTab();
        expectedpersonalInfoData = testCaseData.get("PersonalInfo");
        verifyIfNameFieldEditable();

        UserProfile profileData = getUserProfileData();
        populateFields(personalInfo, profileData);

        verifyNameAfterSavingForm(profileData);
        verifyHeaderProfileName();

        verifyIfEmailFieldEditable();
        verifyEmailinEmailField();

        verifyIfCompanyFieldMandatory();
    }

    private void verifyEmailinEmailField() throws Exception
    {
        expectedpersonalInfoData = testCaseData.get("validCredential");
        Assert.assertEquals(personalInfo.emailTextValue(), expectedpersonalInfoData.get("username"),"Email in email text field is not as expected");
        AutomationLog.info("Email in email text field is as expected");
    }

    private void verifyIfEmailFieldEditable() throws Exception
    {
        WebElement element = personalInfo.textBox_Email();
        Assert.assertEquals(personalInfo.checkEnablityofTextField(element), true,"Email Text field is Editable; it should not be editable");
        AutomationLog.info("Email Text Field is not editable");
    }

    private void verifyNameAfterSavingForm(UserProfile profileData) throws Exception
    {
        Assert.assertEquals(personalInfo.nameTextValue(), profileData.getName(), "Name in Personal Info form did not get replaced with the new name");
        AutomationLog.info("Name in Personal Information form gets replaced with the new name");
    }

    private void verifyIfNameFieldEditable() throws Exception
    {
        WebElement element = personalInfo.textBox_Name();
        Assert.assertEquals(personalInfo.checkEnablityofTextField(element), true,"Name Text field is not editable");
        AutomationLog.info("Name Text field is editable");
    }

    private void verifyHeaderProfileName() throws Exception
    {
        //String nameOnHeader = header.profileName();
        String nameOnHeader = header.greeting();
        Assert.assertEquals(nameOnHeader, expectedpersonalInfoData.get("headerProfileName"), "Name does not get reflected on header");
        AutomationLog.info("Name in Personal Information form gets reflected on header");
    }

    private void populateFields(PersonalInfo personalInfo, UserProfile profileData) throws Exception
    {
        personalInfo.populateData(profileData);
        personalInfo = personalInfo.clickOnSaveChangesBtn();
        WaitFor.sleepFor(2000);
        Assert.assertEquals(personalInfo.successMessage(),expectedpersonalInfoData.get("successMessage"),"Success Message is not shown after valid changes have been made");
        AutomationLog.info("Success Message is shown after valid changes have been made");
    }

    private UserProfile getUserProfileData()
    {
        UserProfile profile = new UserProfile();
        profile.setName(expectedpersonalInfoData.get("name"));
        return profile;
    }

    public void verifyIfCompanyFieldMandatory() throws Exception
    {
        expectedpersonalInfoData = testCaseData.get("PersonalInfo");
        personalInfo.textBox_Company().clear();
        personalInfo.clickOnSaveChangesBtn();
        WaitFor.sleepFor(2000);
        Assert.assertEquals(personalInfo.successMessage(), expectedpersonalInfoData.get("successMessage"), "Expected Success Message is not shown");
        AutomationLog.info("Company field is not mandatory");
    }

    @Override
    protected String successMessage()
    {
        return "Personal Information Positive Scenario tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Personal Information Positive Action Failed";
    }
}