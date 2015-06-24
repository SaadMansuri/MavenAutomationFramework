package com.agorafy.automation.testcases;
import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.datamodel.profile.EmailData;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.SignUp;

/**
 * Navigate to sign up page present in the header
 * verify the error message by entering invalid email details
 * verify the error message by entering empty email.
 * verify the email by entering valid email(existing email) and check whether the user is registered or not
 */
public class SignUpNegativeAction extends AutomationTestCaseVerification
{
    private Header header = null;
    SignUp signUp = null;
    EmailData signupdata = null;
    private HashMap<String, String> invalidEmailData = null;

    public SignUpNegativeAction()
    {
        super();
    }

    @Override
    public void setup()
    {
        super.setup();
        try
        {
            header = Homepage.header();
            signUp = header.clickOnSignUpUpLink();
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not navigate to Sign Up Page");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifyURLandTitle();
        populateAndVerifyEmailDetails(signUp);
        verifyIfEmailIsLeftEmpty(signUp);
        verifyIfEmailAlreadyExist(signUp);
    }

    private void verifyURLandTitle() throws Exception
    {
        Assert.assertEquals(signUp.currentURL(), signUp.registerPageUrl(),"Sign Up link did not navigate to correct page URL");
        AutomationLog.info("Sign Up link navigates to Sign Up page URL");

        HashMap<String, String> signUpData = testCaseData.get("SignUp");
        Assert.assertEquals(signUp.currentPageTitle(), signUpData.get("title"), "Sign Up Page does not show correct Page Title");
        AutomationLog.info("Sign Up Page shows correct Page Title");
    }

    public void populateAndVerifyEmailDetails(SignUp signup) throws Exception
    {
        signupdata = new EmailData();

        invalidEmailData = testCaseData.get("VerifyEmailDetails");
        signupdata.setEmailAddress(invalidEmailData.get("invalidEmail"));
        signup.populateSignUpData(signupdata);

        signup = signup.clickOnSignUpAccountButton();

        String wrongEmailAddress = signup.getErrorMessageOfInvalidEmail();
        Assert.assertEquals(wrongEmailAddress, invalidEmailData.get("invalidEmailErrorMsg"), "Expected error message for invalid email is not displayed in SignUp page");
        AutomationLog.info("Expected error message for invalid email is displayed in SignUp page");
    }

    public void verifyIfEmailIsLeftEmpty(SignUp signup) throws Exception
    {
        signupdata = new EmailData();

        invalidEmailData = testCaseData.get("VerifyEmailDetails");
        signupdata.setEmailAddress("");
        signup.populateSignUpData(signupdata);

        signup = signup.clickOnSignUpAccountButton();

        String emptyEmailAddress = signup.getErrorMessageOfInvalidEmail();
        Assert.assertEquals(emptyEmailAddress, invalidEmailData.get("emptyEmailErrorMsg"), "Expected error message for empty email is not displayed in SignUp page");
        AutomationLog.info("Expected error message for empty email is displayed in SignUp page");
    }

    public void verifyIfEmailAlreadyExist(SignUp signup) throws Exception
    {
        signupdata = new EmailData();

        HashMap<String, String> ValidEmailData = testCaseData.get("VerifyEmailDetails");
        signupdata.setEmailAddress(ValidEmailData.get("validEmail"));
        signup.populateSignUpData(signupdata);

        signup = signup.clickOnSignUpAccountButton();
        WaitFor.sleepFor(2000);

        String validEmailAddress = signup.getMessageForAlreadyRegEmail();
        Assert.assertEquals(validEmailAddress, ValidEmailData.get("validMsg"), "Expected error message for valid registered email is not displayed in SignUp page");
        AutomationLog.info("Expected error message for valid registered email is displayed in SignUp page");
    }

    @Override
    protected String successMessage()
    {
        return "Negative test cases for Sign Up link passed";
    }

    @Override
    protected String failureMessage()
    {
        return "Negative test cases for Sign Up link failed";
    }
}
