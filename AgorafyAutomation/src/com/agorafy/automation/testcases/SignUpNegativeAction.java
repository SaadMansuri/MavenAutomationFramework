package com.agorafy.automation.testcases;
import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.datamodel.profile.EmailData;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.SignUp;

/**
 * Navigate to sign up page present in the header
 * verify the error message by entering invalid email details
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
        populateAndVerifyEmailDetails(signUp);
        verifyIfEmailIsLeftEmpty(signUp);
        verifyIfEmailAlreadyExist(signUp);
    }

    public void populateAndVerifyEmailDetails(SignUp signup) throws Exception
    {
        signupdata = new EmailData();

        invalidEmailData = testCaseData.get("VerifyEmailDetails");
        signupdata.setEmailAddress(invalidEmailData.get("invalidEmail"));
        signup.populateSignUpData(signupdata);

        signup = signup.clickOnSignUpAccountButton();

        String wrongEmailAddress = signup.errorMessageInvalidEmailEntered().getText();
        Assert.assertEquals(wrongEmailAddress, invalidEmailData.get("errorMsg"), "The proper error message for invalid email is not displayed");
        AutomationLog.info("The Appropriate error message for invalid email is displayed");
    }

    public void verifyIfEmailIsLeftEmpty(SignUp signup) throws Exception
    {
        signupdata = new EmailData();

        invalidEmailData = testCaseData.get("VerifyEmailDetails");
        signupdata.setEmailAddress("");
        signup.populateSignUpData(signupdata);

        signup = signup.clickOnSignUpAccountButton();

        String emptyEmailAddress = signup.errorMessageInvalidEmailEntered().getText();
        Assert.assertEquals(emptyEmailAddress, invalidEmailData.get("errorMsg1"), "The proper error message for empty email is not displayed");
        AutomationLog.info("The Appropriate error message for empty email is displayed");
    }

    public void verifyIfEmailAlreadyExist(SignUp signup) throws Exception
    {
        signupdata = new EmailData();

        HashMap<String, String> ValidEmailData = testCaseData.get("VerifyEmailDetails");
        signupdata.setEmailAddress(ValidEmailData.get("validEmail"));
        signup.populateSignUpData(signupdata);

        signup = signup.clickOnSignUpAccountButton();
        WaitFor.waitForPageToLoad(Page.driver, ValidEmailData.get("validMsg"), signup.emailAlreadyRegisteredLink());

        String validEmailAddress = signup.emailAlreadyRegistered().getText();
        Assert.assertEquals(validEmailAddress, ValidEmailData.get("validMsg"), "The proper message for valid mail is not displayed");
        AutomationLog.info("The Appropriate message for valid displayed");
    }

    @Override
    protected String successMessage()
    {
        return "The Negative test cases for Sign Up link passed";
    }

    @Override
    protected String failureMessage()
    {
        return "The Negative test cases for Sign Up link failed";
    }
}
