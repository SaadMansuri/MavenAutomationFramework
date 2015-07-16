package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.datamodel.profile.EmailData;
import com.agorafy.automation.pageobjects.ForgotPassword;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.LoginPage;
import com.agorafy.automation.pageobjects.Page;

/**
 * Precondition:Do invalid login
 * Navigate to forgot password page
 * Verify if empty mail has entered
 * verify if invalid email entered
 * verify if valid email entered which is not registered
 * verify if clicking Back to Log in link redirects to login page
 */
public class ForgotPasswordAction extends AutomationTestCaseVerification
{
    private LoginPage loginPage;
    private HeaderLoginForm headerlogin;
    private ForgotPassword forgotPassword = null;
	private Header header;

    public ForgotPasswordAction()
    {
        super();
    }

    public void setup()
    {
        super.setup();
        try
        {
            header = Header.header();
            headerlogin = header.openHeaderLoginForm();
            loginPage = headerlogin.doInvalidLogin("", "");
            Assert.assertTrue(loginPage.link_ForgotPassword().isDisplayed(), "Expected forgot password link is not shown");
            forgotPassword = loginPage.clickOnForgotPassword();
            AutomationLog.info("Successfully navigated to forgot password page");
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not navigate to Forgot Password Page");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        HashMap<String, String> expectedEmailData = testCaseData.get("EmptyEmail");
        verifyIfTheUserEnteredEmptyEmailAddress(expectedEmailData);

        expectedEmailData = testCaseData.get("InvalidEmail");
        verifyIfTheUserEnteredInvalidEmailAddress(expectedEmailData);

        expectedEmailData = testCaseData.get("UnRegisteredValidEmail");
        verifyIfTheUserEnteredValidEmailAddress(expectedEmailData);

        expectedEmailData = testCaseData.get("BackToLoginUrl");
        verifyBackToLoginLinkInForgotPasswordPage(expectedEmailData);

    }

    private ForgotPassword populateEmailFieldAndRequestNewPassword(HashMap<String, String> expectedEmailData) throws Exception
    {
        EmailData forgotpassworddata = new EmailData();
        forgotpassworddata.setEmailAddress(expectedEmailData.get("email"));
        forgotPassword.populateForgotPasswordData(forgotpassworddata);
        forgotPassword = forgotPassword.clickOnRequestNewPassword();
        return forgotPassword;
    }

    public void verifyIfTheUserEnteredEmptyEmailAddress(HashMap<String, String> expectedEmailData) throws Exception
    {
        forgotPassword = populateEmailFieldAndRequestNewPassword(expectedEmailData);
        String emptyEmailAddress = forgotPassword.getErrorMessageOfInvalidEmail();
        Assert.assertEquals(emptyEmailAddress, expectedEmailData.get("emptyEmailErrorMsg"), "Expected error message for empty email is not displayed in Forgot Password page");
        AutomationLog.info("Expected error message for empty email is displayed in Forgot Password page");
    }

    public void verifyIfTheUserEnteredInvalidEmailAddress(HashMap<String, String> expectedEmailData) throws Exception
    {
        forgotPassword = populateEmailFieldAndRequestNewPassword(expectedEmailData);
        String invalidEmailAddress = forgotPassword.getErrorMessageOfInvalidEmail();
        Assert.assertEquals(invalidEmailAddress, expectedEmailData.get("invalidEmailErrorMsg"), "Expected error message for invalid email is not displayed in Forgot Password page");
        AutomationLog.info("Expected error message for invalid email is not displayed in Forgot Password page");   
    }

    public void verifyIfTheUserEnteredValidEmailAddress( HashMap<String, String> expectedEmailData) throws Exception
    {
        forgotPassword = populateEmailFieldAndRequestNewPassword(expectedEmailData);
        WaitFor.waitForPageToLoad(Page.driver, expectedEmailData.get("validMailNotReg"), forgotPassword.validEmailNotRegistered());

        String validEmailAddress = forgotPassword.getMessageOfValidEmailNotReg();
        Assert.assertEquals(validEmailAddress, expectedEmailData.get("validMailNotReg"),"Expected error message for valid email is not displayed in Forgot Password page");
        AutomationLog.info("Expected error message for valid email is displayed in Forgot Password page");
    }
    
    public void verifyBackToLoginLinkInForgotPasswordPage(HashMap<String, String> expectedEmailData) throws Exception
    {
        LoginPage BackToLogin = forgotPassword.clickOnBackToLoginLink();
        WaitFor.sleepFor(2000);
        String ExpectedUrl = forgotPassword.getApplicationUrl() + expectedEmailData.get("url");

        Assert.assertEquals(BackToLogin.currentURL(),ExpectedUrl,"The CurrentURL is not been not found");
        AutomationLog.info("The CurrentURL is been found");

        Assert.assertEquals(loginPage.LoginPageFormId_BackToLoginLink().isDisplayed(),true, "After cliking BackToLoginLink, Agorafy forgotpassword page not found the form id");
        AutomationLog.info("After cliking BackToLoginLink, Agorafy forgotpassword page found the form id");

        Assert.assertEquals(loginPage.LoginPageHeading_BackToLoginLink(),"Log in", "After clicking BackToLoginLink ,Agorafy Password Page does not show correct page title");
        AutomationLog.info("After clicking BackToLoginLink ,Agorafy Password Page shows correct page Title");
    }

    @Override
    protected String successMessage()
    {
        return "Test cases for forgot password passed";
    }

    @Override
    protected String failureMessage()
    {
        return "Test cases for forgot password failed";
    }
}
