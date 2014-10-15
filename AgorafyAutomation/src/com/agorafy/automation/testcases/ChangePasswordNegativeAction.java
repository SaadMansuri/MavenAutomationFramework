package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCase;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.datamodel.profile.ChangePasswordData;
import com.agorafy.automation.pageobjects.AccountSettings;
import com.agorafy.automation.pageobjects.ChangePasswordTab;
import com.agorafy.automation.pageobjects.Dashboard;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;

public class ChangePasswordNegativeAction extends AutomationTestCase
{
    private Homepage homePage = null;
    private HeaderLoginForm headerLoginForm = null;

    public ChangePasswordNegativeAction()
    {
        super();
    }

    public void setup()
    {
        super.setup();
        homePage = Homepage.homePage();
    }

    public void cleanup()
    {
        super.cleanup();
    }

    public void Execute() throws Exception
    {
        try
        {
            setup();
            // TODO: get this from CSV data.
            headerLoginForm = homePage.openHeaderLoginForm();

            HashMap<String, String> loginData =  testCaseData.get("validCredential");
            String UserName = loginData.get("username");
            String Password = loginData.get("password");

            homePage = headerLoginForm.doSuccessfulLogin(UserName, Password);
            // Verify this is the correct homepage.
            WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
            Header header = Page.header();
            header.openActiveProfile();
            //Navigation To AccountSetting page.
            Dashboard dashboard = header.openDashboard();
            AccountSettings accountSettings = dashboard.accountSettings();
            ChangePasswordTab changePasswordTab = accountSettings.clickOnChangePasswordTab();
            verifyIfChangePasswordTabActive(accountSettings);

            // Verify the negative Test Cases Of Change Password.
            populateAndVerifyChangePasswordDetails(changePasswordTab);
            verifyOldPassowrdLeftBlank(changePasswordTab);
            verifyNewPassowrdLeftBlank(changePasswordTab);
            verifyRetypeNewPasswordLeftBlank(changePasswordTab);
            verifyIfWrongOldPasswordEntered(changePasswordTab);
            verifyIfNewAndRetypeNewPasswordIsLessThenEightChar(changePasswordTab);
            verifyIfNewpasswordAndRetypeNewpasswordAreNotSame(changePasswordTab);
            testcasePassed("Invalid Test Cases Change Password Action perfomed successfully.");
        }
        catch (Exception e)
        {
            handleTestCaseFailure(e.getMessage());
        }
        catch(Throwable throwable)
        {
            handleTestCaseFailure(throwable.getMessage());
        }
            finally
        {
            cleanup();
        }
    }

    private void handleTestCaseFailure(String message) throws Exception
    {
        AutomationLog.error("InValid Test Cases Change Password Action  Failed: " + message);
        throw (new Exception("InValid Test Cases Change Password Action  Failed" + message));
    }

    public void verifyIfChangePasswordTabActive(AccountSettings accountSettings) throws Exception
    {
        //changePasswordTab = changePasswordTab.clickOnChangePasswordTabLoads();
        String verifyChangePasswordTabLoads = accountSettings.link_ChangePasswordTab().getAttribute("class");
        Assert.assertEquals(verifyChangePasswordTabLoads, "active", "active class is not found when the page gets loaded");
        AutomationLog.info("ChangePassword Tab is active and gets loaded");
   }

    public void populateAndVerifyChangePasswordDetails(ChangePasswordTab changePasswordTab) throws Exception
    {
        changePasswordTab = changePasswordTab.clickOnSubmitButtonChangePassword();

        HashMap<String, String> InvalidTestData = testCaseData.get("populateAndVerifyChangePasswordDetails");

        String oldErrorPasswordMessage = changePasswordTab.errorMessageOldPassword().getText();
        Assert.assertEquals(oldErrorPasswordMessage, InvalidTestData.get("errorMsg1"), "The proper error messgae for old password is not displayed ");
        AutomationLog.info("The appropriate error message for old password is dispalyed when no input is provided");

        String newErrorPasswordMessage = changePasswordTab.errorMessageNewPassword().getText();
        Assert.assertEquals(newErrorPasswordMessage, InvalidTestData.get("errorMsg2") , "The proper error messgae for new password is not displayed ");
        AutomationLog.info("The appropriate error message for new password is dispalyed when no input is provided");

        String retypeNewErrorPasswordMessage=changePasswordTab.errorRetypeNewPassword().getText();
        Assert.assertEquals(retypeNewErrorPasswordMessage, InvalidTestData.get("errorMsg3") , "The proper error messgae for retype new password is not displayed");
        AutomationLog.info("The appropriate error message for retype new password is displayed when no input is provided");
    }

    public void verifyOldPassowrdLeftBlank(ChangePasswordTab changePasswordTab) throws Exception
    {
        ChangePasswordData changepassworddata = new ChangePasswordData();
        changepassworddata.setOldPassword("");

        HashMap<String, String> InvalidTestData = testCaseData.get("oldPasswordLeftBlank");
        changepassworddata.setNewPassword(InvalidTestData.get("invalidNewPassword"));

        changepassworddata.setRetypeNewPassword(InvalidTestData.get("invalidRetypeNewPassword"));

        changePasswordTab.populateChangePasswordData(changepassworddata);

        changePasswordTab = changePasswordTab.clickOnSubmitButtonChangePassword();

        String newErrorOldMesagePassword = changePasswordTab.errorMessageOldPassword().getText();
        String expectedOldPasswordErrorMessage = InvalidTestData.get("errorMsg");
        Assert.assertEquals(newErrorOldMesagePassword, expectedOldPasswordErrorMessage, "The proper error messgae for new password is not displayed when OldPassword is left empty");
        AutomationLog.info("The appropriate error message for old password is dispalyed when other text fields are entered");
    }

    public void verifyNewPassowrdLeftBlank(ChangePasswordTab changePasswordTab) throws Exception
    {
        ChangePasswordData changepassworddata = new ChangePasswordData();

        HashMap<String, String> InvalidTestData = testCaseData.get("newPasswordLeftBlank");
        changepassworddata.setOldPassword(InvalidTestData.get("invalidOldPassword"));

        changepassworddata.setNewPassword("");

        changepassworddata.setRetypeNewPassword(InvalidTestData.get("invalidRetypeNewPassword"));

        changePasswordTab.populateChangePasswordData(changepassworddata);

        changePasswordTab = changePasswordTab.clickOnSubmitButtonChangePassword();

        String verifynewPasswordErrorMessage = changePasswordTab.errorMessageNewPassword().getText();
        Assert.assertEquals(verifynewPasswordErrorMessage, InvalidTestData.get("errorMsg1"), "The proper error messgae for new password is not displayed when NewPassword is left empty" );
        AutomationLog.info("The appropriate error message for New password is dispalyed when other text fields are entered");

        String verifyretypeNewPasswordErrorMessage = changePasswordTab.errorRetypeNewPassword().getText();
        Assert.assertEquals(verifyretypeNewPasswordErrorMessage,  InvalidTestData.get("errorMsg2"),  "The proper error messgae for new password is not displayed when NewPassword is left empty" );
        AutomationLog.info("The appropriate error message for Retype New password is dispalyed when other text fields are entered");
    }

    public void verifyRetypeNewPasswordLeftBlank(ChangePasswordTab changePasswordTab) throws Exception
    {
        ChangePasswordData changepassworddata = new ChangePasswordData();

        HashMap<String, String> InvalidTestData = testCaseData.get("retypeNewPasswordLeftBlank");
        changepassworddata.setOldPassword(InvalidTestData.get("invalidOldPassword"));

        changepassworddata.setNewPassword(InvalidTestData.get("invalidNewPassword"));

        changepassworddata.setRetypeNewPassword("");

        changePasswordTab.populateChangePasswordData(changepassworddata);

        changePasswordTab = changePasswordTab.clickOnSubmitButtonChangePassword();

        String verifyNewPassworderrorMessage = changePasswordTab.errorRetypeNewPassword().getText();
        Assert.assertEquals(verifyNewPassworderrorMessage, InvalidTestData.get("errorMsg"), "The proper error messgae for Retype new password is not displayed when NewPassword is left empty" );
        AutomationLog.info("The appropriate error message for Retype New password is dispalyed when other text fields are entered");
    }

    public void verifyIfWrongOldPasswordEntered(ChangePasswordTab changePasswordTab) throws Exception
    {
        ChangePasswordData changepassworddata = new ChangePasswordData();

        HashMap<String, String> InvalidTestData = testCaseData.get("WrongOldPasswordEntered");
        changepassworddata.setOldPassword(InvalidTestData.get("invalidOldPassword"));

        changepassworddata.setNewPassword("");

        changepassworddata.setRetypeNewPassword("");

        changePasswordTab.populateChangePasswordData(changepassworddata);

        changePasswordTab = changePasswordTab.clickOnSubmitButtonChangePassword();

        String verifyNewPasswordMessage = changePasswordTab.errorMessageNewPassword().getText();
        Assert.assertEquals(verifyNewPasswordMessage, InvalidTestData.get("errorMsg1"), "The proper error messgae for  new password is not displayed when OldPassword is entered wrong");
        AutomationLog.info("The appropriate error message for New password is dispalyed when Old password is Entered wrong");

        String verifyRetypeNewPassword = changePasswordTab.errorRetypeNewPassword().getText();
        Assert.assertEquals(verifyRetypeNewPassword, InvalidTestData.get("errorMsg2"), "The proper error messgae for Retype new password is not displayed when OldPassword is entered wrong" );
        AutomationLog.info("The appropriate error message for Retype New password is dispalyed when Old password is Entered wrong");
    }

    public void verifyIfNewAndRetypeNewPasswordIsLessThenEightChar(ChangePasswordTab changePasswordTab) throws Exception
    {
        ChangePasswordData changepassworddata = new ChangePasswordData();
        changepassworddata.setOldPassword("");

        HashMap<String, String> InvalidTestData = testCaseData.get("NewAndRetypeNewPasswordIsLessThenEightChar");
        changepassworddata.setNewPassword(InvalidTestData.get("invalidNewPassword"));

        changepassworddata.setRetypeNewPassword(InvalidTestData.get("invalidRetypeNewPassword"));

        changePasswordTab.populateChangePasswordData(changepassworddata);

        changePasswordTab = changePasswordTab.clickOnSubmitButtonChangePassword();

        String verifyOldPasswordMessage = changePasswordTab.errorMessageOldPassword().getText();
        Assert.assertEquals(verifyOldPasswordMessage, InvalidTestData.get("errorMsg1"), "The proper error messgae for Old password is not displayed when new password and Retype New Password is less than eight Character");
        AutomationLog.info("The appropriate error message for Old password is dispalyed when New Password And retype New Password is less then Eight Character");

        String verifyNewPasswordMessage = changePasswordTab.errorMessageNewPassword().getText();
        Assert.assertEquals(verifyNewPasswordMessage, InvalidTestData.get("errorMsg2"), "The proper error messgae for New password is not displayed when new password and Retype New Password is less than eight Character");
        AutomationLog.info("The appropriate error message for New password is dispalyed when New Password And retype New Password is less then Eight Character");
    }

    public void verifyIfNewpasswordAndRetypeNewpasswordAreNotSame(ChangePasswordTab changePasswordTab) throws Exception
    {
        ChangePasswordData changepassworddata = new ChangePasswordData();
        changepassworddata.setOldPassword("");

        HashMap<String, String> InvalidTestData = testCaseData.get("NewpasswordAndRetypeNewpasswordAreNotSame");
        changepassworddata.setNewPassword(InvalidTestData.get("invalidNewPassword"));

        changepassworddata.setRetypeNewPassword(InvalidTestData.get("invalidRetypeNewPassword"));

        changePasswordTab.populateChangePasswordData(changepassworddata);

        changePasswordTab = changePasswordTab.clickOnSubmitButtonChangePassword();

        String verifyOldPasswordMessage = changePasswordTab.errorMessageOldPassword().getText();
        Assert.assertEquals(verifyOldPasswordMessage, InvalidTestData.get("errorMsg1"), "The proper error messgae for Old password is not displayed when new password and Retype New Password is not same");
        AutomationLog.info("The appropriate error message for Old password is dispalyed when New Password And retype New Password is not same");

        String verifyNewPasswordMessage = changePasswordTab.errorMessageNewPassword().getText();
        Assert.assertEquals(verifyNewPasswordMessage, InvalidTestData.get("errorMsg2"), "The proper error messgae for New password is not displayed when new password and Retype New Password is not same");
        AutomationLog.info("The appropriate error message for New password is dispalyed when New Password And retype New Password is not same");

        String verifyRetypeNewPasswordMessage = changePasswordTab.errorRetypeNewPassword().getText();
        Assert.assertEquals(verifyRetypeNewPasswordMessage, InvalidTestData.get("errorMsg3"), "The proper error messgae for Retype New password is not displayed when new password and Retype New Password is not same");
        AutomationLog.info("The appropriate error message for Retype New password is dispalyed when New Password And retype New Password is not same");
    }
}
