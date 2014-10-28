package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.datamodel.profile.EmailData;
import com.agorafy.automation.pageobjects.ForgotPassword;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.LoginPage;
import com.agorafy.automation.pageobjects.Page;

/**
 * Precondition:Do invalid login
 * Navigate to forgot password page
 * Verify if empty mail has entered
 * verify if invalid email entered
 * verify if valid email entered which is not registered
 */
public class ForgotPasswordAction extends AutomationTestCaseVerification
{
    private Homepage homePage;
    private LoginPage loginPage;
    private HeaderLoginForm headerlogin;
    ForgotPassword forgotPassword = null;
    private HashMap<String, String> invalidEmailData = null;
    private HashMap<String, String> validEmailData = null;

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
        verifyIfTheUserEnteredEmptyEmailAddress(forgotPassword);
        verifyIfTheUserEnteredInvalidEmailAddress(forgotPassword);
        verifyIfTheUserEnteredValidEmailAddress(forgotPassword);
    }

    public void verifyIfTheUserEnteredEmptyEmailAddress(ForgotPassword forgotpassword) throws Exception
    {
        EmailData forgotpassworddata = new EmailData();
        invalidEmailData = testCaseData.get("UserEnteredWrongEmailAddress");
        forgotpassworddata.setEmailAddress("");
        forgotpassword = forgotpassword.clickOnRequestNewPassword();

        String emptyEmailAddress = forgotpassword.errorMessageEnterValidMail().getText();
        Assert.assertEquals(emptyEmailAddress, invalidEmailData.get("emptyEmailErrorMsg"), "The proper error message please enter your email address is not displayed");
        AutomationLog.info("The Appropriate error message for empty email is shown");
    }

    public void verifyIfTheUserEnteredInvalidEmailAddress(ForgotPassword forgotpassword) throws Exception
    {
        EmailData forgotpassworddata = new EmailData();
        forgotpassworddata.setEmailAddress(invalidEmailData.get("invalidEmail"));
        forgotpassword.populateForgotPasswordData(forgotpassworddata);
        forgotpassword = forgotpassword.clickOnRequestNewPassword();

        String invalidEmailAddress = forgotpassword.errorMessageEnterValidMail().getText();
        Assert.assertEquals(invalidEmailAddress, invalidEmailData.get("invalidEmailErrorMsg"), "The proper error message please enter valid email address is not displayed");
        AutomationLog.info("The Appropriate error message for invalid email is shown");
    }

    public void verifyIfTheUserEnteredValidEmailAddress(ForgotPassword forgotpassword) throws Exception
    {
        EmailData forgotpassworddata = new EmailData();
        validEmailData = testCaseData.get("UserEnteredValidEmailAddress");
        forgotpassworddata.setEmailAddress(validEmailData.get("validEmail"));
        forgotpassword.populateForgotPasswordData(forgotpassworddata);
        forgotpassword = forgotpassword.clickOnRequestNewPassword();
        WaitFor.waitForPageToLoad(Page.driver);

        String validEmailAddress = forgotpassword.messageEnterValidMail().getText();
        Assert.assertEquals(validEmailAddress, validEmailData.get("validMailNotReg"),"The proper message is not dispalyed when valid email is given");
        AutomationLog.info("The Appropriate message for valid email is shown");
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
