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

    public ChangePasswordPositiveAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        changePasswordTab = accountSettings.clickOnChangePasswordTab();
        HashMap<String, String> validTestData = testCaseData.get("ChangePassword");;
        changePasswordWithValidCredentials(validTestData);
        verifyIfPasswordChanged();
        validTestData = testCaseData.get("ChangePasswordAgain");
        changePasswordWithValidCredentials(validTestData);
        verifyIfPasswordChanged();
    }

    private void verifyIfPasswordChanged() throws Exception
    {
        HashMap<String, String> messagedata = testCaseData.get("SuccessMessage");
        String verifySuccesfullPasswordMessage = changePasswordTab.getSuccessMessageOfChangePasswordTab();
        Assert.assertEquals(verifySuccesfullPasswordMessage, messagedata.get("validMsg"), "Expected success message for ChangePasswordTab not found");
        AutomationLog.info("Expected success message for ChangePasswordTab found");
    }

    private void changePasswordWithValidCredentials(HashMap<String, String> validTestData) throws Exception
    {
        ChangePasswordData changepassworddata = new ChangePasswordData();
        changepassworddata.setOldPassword(validTestData.get("ValidOldPassword"));
        changepassworddata.setNewPassword(validTestData.get("ValidNewPassword"));
        changepassworddata.setRetypeNewPassword(validTestData.get("ValidRetypeNewPassword"));
        changePasswordTab.populateChangePasswordData(changepassworddata);
        changePasswordTab = changePasswordTab.clickOnSubmitButtonChangePassword();
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
