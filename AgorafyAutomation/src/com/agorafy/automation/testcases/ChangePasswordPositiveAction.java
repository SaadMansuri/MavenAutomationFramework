package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.datamodel.profile.ChangePasswordData;
import com.agorafy.automation.pageobjects.AccountSettings;
import com.agorafy.automation.pageobjects.ChangePasswordTab;
import com.agorafy.automation.pageobjects.Dashboard;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;

/**
 * Precondition:Open header login form and Naviagte to Account Setting Page
 * Go to change password tab
 * verify on giving valid inputs password is changing or not
 * verify password changed successfully message should be displayed
 */
public class ChangePasswordPositiveAction extends AutomationTestCaseVerification
{
    private Homepage homePage = null;
    private HeaderLoginForm headerLoginForm = null;
    private Header header = null;
    private Dashboard dashboard = null;
    private AccountSettings accountSettings = null;
    private ChangePasswordTab changePasswordTab = null;

    public ChangePasswordPositiveAction()
    {
        super();
    }

    @Override
    public void setup()
    {
        super.setup();
        homePage = Homepage.homePage();
        try
        {
            headerLoginForm = homePage.openHeaderLoginForm();

            HashMap<String, String> loginData =  testCaseData.get("validCredential");
            String UserName = loginData.get("username");
            String Password = loginData.get("password");

            homePage = headerLoginForm.doSuccessfulLogin(UserName, Password);
            // Verify this is the correct homepage.
            WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
            header= Page.header();
            header.openActiveProfile();
            //Navigation To AccountSetting page.
            dashboard = header.openDashboard();
            accountSettings = dashboard.accountSettings();
            changePasswordTab = accountSettings.clickOnChangePasswordTab();

        }
        catch (Exception e)
        {
            AutomationLog.error("The change password tab not found");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifyIfAllTheValidFieldsAreEntered(changePasswordTab);
    }

    public void verifyIfAllTheValidFieldsAreEntered(ChangePasswordTab changePasswordTab) throws Exception
    {
        ChangePasswordData changepassworddata = new ChangePasswordData();

        HashMap<String, String> validTestData = testCaseData.get("AllTheValidFieldsAreEntered");

        changepassworddata.setOldPassword(validTestData.get("ValidOldPassword"));

        changepassworddata.setNewPassword(validTestData.get("ValidNewPassword"));

        changepassworddata.setRetypeNewPassword(validTestData.get("ValidRetypeNewPassword"));

        changePasswordTab.populateChangePasswordData(changepassworddata);

        changePasswordTab = changePasswordTab.clickOnSubmitButtonChangePassword();
        String verifySuccesfullPasswordMessage = changePasswordTab.passwordChangedSuccessfully().getText();
        Assert.assertEquals(verifySuccesfullPasswordMessage, validTestData.get("validMsg"), "Password not Changed successfully when valid credentials are entered");
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
