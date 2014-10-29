package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.datamodel.profile.ChangePasswordData;
import com.agorafy.automation.pageobjects.ChangePasswordTab;

/**
 * Precondition:Open header login form and Naviagte to Account Setting Page
 * Go to change password tab
 * verify on giving valid inputs password is changing or not
 * verify password changed successfully message should be displayed
 */

public class ChangePasswordPositiveAction extends AccountSettingsBaseAction
{
    private ChangePasswordTab changePasswordTab = null;
    HashMap<String, String> validTestData = null;

    public ChangePasswordPositiveAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
    	changePasswordTab = accountSettings.clickOnChangePasswordTab();
        verifyIfAllTheValidFieldsAreEntered(changePasswordTab);
    }

    public void verifyIfAllTheValidFieldsAreEntered(ChangePasswordTab changePasswordTab) throws Exception
    {
        ChangePasswordData changepassworddata = new ChangePasswordData();

        validTestData = testCaseData.get("AllTheValidFieldsAreEntered");

        changepassworddata.setOldPassword(validTestData.get("ValidOldPassword"));

        changepassworddata.setNewPassword(validTestData.get("ValidNewPassword"));

        changepassworddata.setRetypeNewPassword(validTestData.get("ValidRetypeNewPassword"));

        changePasswordTab.populateChangePasswordData(changepassworddata);

        changePasswordTab = changePasswordTab.clickOnSubmitButtonChangePassword();
        String verifySuccesfullPasswordMessage = changePasswordTab.passwordChangedSuccessfully().getText();
        Assert.assertEquals(verifySuccesfullPasswordMessage, validTestData.get("validMsg"), "Appropriate message for change password is Not displayed");
        AutomationLog.info("Appropriate message for change password is displayed");
    }

    @Override
    protected String successMessage()
    {
        return "The Positive test cases for change password tab passed";
    }

    @Override
    protected String failureMessage()
    {
        return "The positive test cases for change password tab failed";
    }
}
