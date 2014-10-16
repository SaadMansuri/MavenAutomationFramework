package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.datamodel.profile.EmailData;
import com.agorafy.automation.pageobjects.ForgotPassword;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.LoginPage;

/**
 * Precondition:Do invalid login
 * Navigate to forgot password page
 * Enter wrong email address without domain name
 * verify the message "please enter valid email address"
 */
public class ForgotPasswordAction extends AutomationTestCaseVerification
{
    private Homepage homePage;
    private LoginPage loginPage;
    private HeaderLoginForm headerlogin;
    ForgotPassword forgotPassword = null;

    public ForgotPasswordAction()
    {
        super();
    }

    public void setup()
    {
        super.setup();
        homePage = Homepage.homePage();
        try
        {
            headerlogin =  homePage.openHeaderLoginForm();
            loginPage = headerlogin.doInvalidLogin("", "");
            forgotPassword = loginPage.clickOnForgotPassword();
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not navigate to Forgot Password Page");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {

        verifyIfTheUserEnteredWrongEmailAddress(forgotPassword);
    }

    public void verifyIfTheUserEnteredWrongEmailAddress(ForgotPassword forgotpassword) throws Exception
    {
        EmailData forgotpassworddata = new EmailData();

        HashMap<String, String> invalidEmailData = testCaseData.get("UserEnteredWrongEmailAddress");
        forgotpassworddata.setEmailAddress(invalidEmailData.get("invalidEmail"));

        forgotpassword.populateForgotPasswordData(forgotpassworddata);
        forgotpassword = forgotpassword.clickOnRequestNewPassword();
        String invalidEmailAddress = forgotpassword.errorMessageEnterValidMail().getText();
        Assert.assertEquals(invalidEmailAddress, invalidEmailData.get("errorMsg"), "The proper error message please enter valid email address is not displayed");
        AutomationLog.info("The Appropriate error message is shown");
    }

    @Override
    protected String successMessage()
    {
        return "The test cases for forgot password passed";
    }

    @Override
    protected String failureMessage()
    {
        return "The test cases for forgot password failed";
    }
}
