package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.datamodel.profile.ChangePasswordData;
import com.agorafy.automation.pageobjects.ChangePasswordTab;

/**
 * Precondition:Open header login form and Navigate to Account Setting Page
 * Go to change password tab
 * verify if all the field of change password are empty
 * verifyOldPassowrdLeftBlank
 * verifyNewPassowrdLeftBlank
 * verifyRetypeNewPasswordLeftBlank
 * verifyIfWrongOldPasswordEntered
 * verifyIfNewAndRetypeNewPasswordIsLessThenEightChar
 * verifyIfNewpasswordAndRetypeNewpasswordAreNotSame
 */

public class ChangePasswordNegativeAction extends AccountSettingsBaseAction
{
    private ChangePasswordTab changePasswordTab = null;
    private HashMap<String, String> invalidTestData = null;

    public ChangePasswordNegativeAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        changePasswordTab = accountSettings.clickOnChangePasswordTab();
        populateAndVerifyIfAllFieldsAreEmpty(changePasswordTab);
        verifyOldPassowrdLeftBlank(changePasswordTab);
        verifyNewPassowrdLeftBlank(changePasswordTab);
        verifyRetypeNewPasswordLeftBlank(changePasswordTab);
        verifyIfWrongOldPasswordEntered(changePasswordTab);
        verifyIfNewAndRetypeNewPasswordIsLessThenEightChar(changePasswordTab);
        verifyIfNewpasswordAndRetypeNewpasswordAreNotSame(changePasswordTab);
        testcasePassed("Invalid Test Cases Change Password Action performed successfully.");
    }

    public void populateAndVerifyIfAllFieldsAreEmpty(ChangePasswordTab changePasswordTab) throws Exception
    {
        changePasswordTab = changePasswordTab.clickOnSubmitButtonChangePassword();
        invalidTestData = testCaseData.get("populateAndVerifyIfAllFieldsAreEmpty");

        String oldErrorPasswordMessage = changePasswordTab.errorMessageOldPassword().getText();
        Assert.assertEquals(oldErrorPasswordMessage, invalidTestData.get("errorMsg1"), "The proper error messgae for old password is not displayed ");
        AutomationLog.info("The appropriate error message for old password is displayed when no input is provided");

        String newErrorPasswordMessage = changePasswordTab.errorMessageNewPassword().getText();
        Assert.assertEquals(newErrorPasswordMessage, invalidTestData.get("errorMsg2") , "The proper error messgae for new password is not displayed ");
        AutomationLog.info("The appropriate error message for new password is displayed when no input is provided");

        String retypeNewErrorPasswordMessage=changePasswordTab.errorRetypeNewPassword().getText();
        Assert.assertEquals(retypeNewErrorPasswordMessage, invalidTestData.get("errorMsg3") , "The proper error messgae for retype new password is not displayed");
        AutomationLog.info("The appropriate error message for retype new password is displayed when no input is provided");
    }

    public void verifyOldPassowrdLeftBlank(ChangePasswordTab changePasswordTab) throws Exception
    {
        ChangePasswordData changepassworddata = new ChangePasswordData();

        changepassworddata.setOldPassword("");

        invalidTestData = testCaseData.get("oldPasswordLeftBlank");

        changepassworddata.setNewPassword(invalidTestData.get("invalidNewPassword"));

        changepassworddata.setRetypeNewPassword(invalidTestData.get("invalidRetypeNewPassword"));

        changePasswordTab.populateChangePasswordData(changepassworddata);

        changePasswordTab = changePasswordTab.clickOnSubmitButtonChangePassword();

        String newErrorOldMesagePassword = changePasswordTab.errorMessageOldPassword().getText();
        String expectedOldPasswordErrorMessage = invalidTestData.get("errorMsg");
        Assert.assertEquals(newErrorOldMesagePassword, expectedOldPasswordErrorMessage, "The proper error message for new password is not displayed when OldPassword is left empty");
        AutomationLog.info("The appropriate error message for old password is displayed when old password is empty and other text fields are entered");
    }

    public void verifyNewPassowrdLeftBlank(ChangePasswordTab changePasswordTab) throws Exception
    {
        ChangePasswordData changepassworddata = new ChangePasswordData();

        invalidTestData = testCaseData.get("newPasswordLeftBlank");

        changepassworddata.setOldPassword(invalidTestData.get("invalidOldPassword"));

        changepassworddata.setNewPassword("");

        changepassworddata.setRetypeNewPassword(invalidTestData.get("invalidRetypeNewPassword"));

        changePasswordTab.populateChangePasswordData(changepassworddata);

        changePasswordTab = changePasswordTab.clickOnSubmitButtonChangePassword();

        String verifynewPasswordErrorMessage = changePasswordTab.errorMessageNewPassword().getText();
        Assert.assertEquals(verifynewPasswordErrorMessage, invalidTestData.get("errorMsg1"), "The proper error message for new password is not displayed when NewPassword is left empty" );
        AutomationLog.info("The appropriate error message for New password is displayed when new password is empty and other text fields are entered");

        String verifyretypeNewPasswordErrorMessage = changePasswordTab.errorRetypeNewPassword().getText();
        Assert.assertEquals(verifyretypeNewPasswordErrorMessage,  invalidTestData.get("errorMsg2"),  "The proper error messgae for new password is not displayed when NewPassword is left empty" );
        AutomationLog.info("The appropriate error message for Retype New password is displayed when new password is empty other text fields are entered");
    }

    public void verifyRetypeNewPasswordLeftBlank(ChangePasswordTab changePasswordTab) throws Exception
    {
        ChangePasswordData changepassworddata = new ChangePasswordData();

        invalidTestData = testCaseData.get("retypeNewPasswordLeftBlank");

        changepassworddata.setOldPassword(invalidTestData.get("invalidOldPassword"));

        changepassworddata.setNewPassword(invalidTestData.get("invalidNewPassword"));

        changepassworddata.setRetypeNewPassword("");

        changePasswordTab.populateChangePasswordData(changepassworddata);

        changePasswordTab = changePasswordTab.clickOnSubmitButtonChangePassword();

        String verifyNewPassworderrorMessage = changePasswordTab.errorRetypeNewPassword().getText();
        Assert.assertEquals(verifyNewPassworderrorMessage, invalidTestData.get("errorMsg"), "The proper error messgae for Retype new password is not displayed when NewPassword is left empty" );
        AutomationLog.info("The appropriate error message for Retype New password is displayed when retype new password is empty and other text fields are entered");
    }

    public void verifyIfWrongOldPasswordEntered(ChangePasswordTab changePasswordTab) throws Exception
    {
        ChangePasswordData changepassworddata = new ChangePasswordData();

        invalidTestData = testCaseData.get("WrongOldPasswordEntered");

        changepassworddata.setOldPassword(invalidTestData.get("invalidOldPassword"));

        changepassworddata.setNewPassword("");

        changepassworddata.setRetypeNewPassword("");

        changePasswordTab.populateChangePasswordData(changepassworddata);

        changePasswordTab = changePasswordTab.clickOnSubmitButtonChangePassword();

        String verifyNewPasswordMessage = changePasswordTab.errorMessageNewPassword().getText();
        Assert.assertEquals(verifyNewPasswordMessage, invalidTestData.get("errorMsg1"), "The proper error message for new password is not displayed when OldPassword is entered wrong");
        AutomationLog.info("The appropriate error message for New password is displayed when Old password is Entered wrong");

        String verifyRetypeNewPassword = changePasswordTab.errorRetypeNewPassword().getText();
        Assert.assertEquals(verifyRetypeNewPassword, invalidTestData.get("errorMsg2"), "The proper error messgae for Retype new password is not displayed when OldPassword is entered wrong" );
        AutomationLog.info("The appropriate error message for Retype New password is displayed when Old password is Entered wrong");
    }

    public void verifyIfNewAndRetypeNewPasswordIsLessThenEightChar(ChangePasswordTab changePasswordTab) throws Exception
    {
        ChangePasswordData changepassworddata = new ChangePasswordData();

        invalidTestData = testCaseData.get("NewAndRetypeNewPasswordIsLessThenEightChar");

        changepassworddata.setOldPassword(invalidTestData.get("validOldPassword"));

        changepassworddata.setNewPassword(invalidTestData.get("invalidNewPassword"));

        changepassworddata.setRetypeNewPassword(invalidTestData.get("invalidRetypeNewPassword"));

        changePasswordTab.populateChangePasswordData(changepassworddata);

        changePasswordTab = changePasswordTab.clickOnSubmitButtonChangePassword();

        String verifyOldPasswordMessage = changePasswordTab.errorMessageNewPassword().getText();
        Assert.assertEquals(verifyOldPasswordMessage, invalidTestData.get("errorMsg2"), "The proper error message for Old password is not displayed when new password and Retype New Password is less than eight Character");
        AutomationLog.info("The appropriate error message for New password is displayed when New Password And retype New Password is less then Eight Character");

    }

    public void verifyIfNewpasswordAndRetypeNewpasswordAreNotSame(ChangePasswordTab changePasswordTab) throws Exception
    {
        ChangePasswordData changepassworddata = new ChangePasswordData();

        invalidTestData = testCaseData.get("NewpasswordAndRetypeNewpasswordAreNotSame");

        changepassworddata.setOldPassword(invalidTestData.get("validOldPassword"));

        changepassworddata.setNewPassword(invalidTestData.get("invalidNewPassword"));

        changepassworddata.setRetypeNewPassword(invalidTestData.get("invalidRetypeNewPassword"));

        changePasswordTab.populateChangePasswordData(changepassworddata);

        changePasswordTab = changePasswordTab.clickOnSubmitButtonChangePassword();

        String verifyOldPasswordMessage = changePasswordTab.errorMessageNewPassword().getText();
        Assert.assertEquals(verifyOldPasswordMessage, invalidTestData.get("errorMsg1"), "The proper error message for Old password is not displayed when new password and Retype New Password is not same");
        AutomationLog.info("The appropriate error message for New password is displayed when New Password And retype New Password is not same");

        String verifyNewPasswordMessage = changePasswordTab.errorRetypeNewPassword().getText();
        Assert.assertEquals(verifyNewPasswordMessage, invalidTestData.get("errorMsg2"), "The proper error message for New password is not displayed when new password and Retype New Password is not same");
        AutomationLog.info("The appropriate error message for Retype New password is displayed when New Password And retype New Password is not same");

    }

    @Override
    protected String successMessage()
    {
        return "The Negative test cases for change password tab passed";
    }

    @Override
    protected String failureMessage()
    {
        return "The Negative test cases for change password tab failed";
    }
}
