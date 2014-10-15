package com.agorafy.automation.testcases;
import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCase;
import com.agorafy.automation.datamodel.profile.SignUpData;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.SignUp;

public class SignUpNegativeAction extends AutomationTestCase
{
    private Header header = null;

    public SignUpNegativeAction()
    {
        super();
    }

    public void setup()
    {
        super.setup();
        header = Homepage.header();
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
            SignUp signUp = header.clickOnSignUpUpLink();
            populateAndVerifyEmailDetails(signUp);
            verifyIfEmailAlreadyExist(signUp);
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
        AutomationLog.error("InValid Test Cases SignUp Action  Failed: " + message);
        throw (new Exception("InValid Test Cases SignUp Action  Failed" + message));
    }

    public void populateAndVerifyEmailDetails(SignUp signup) throws Exception
    {
        SignUpData signupdata = new SignUpData();

        HashMap<String, String> InvalidEmailData = testCaseData.get("VerifyEmailDetails");
        signupdata.setEmail(InvalidEmailData.get("invalidEmail"));
        signup.populateSignUpData(signupdata);
        signup = signup.clickOnSignUpAccountButton();
        String wrongEmailAddress = signup.errorMessageInvalidEmailEntered().getText();
        Assert.assertEquals(wrongEmailAddress, InvalidEmailData.get("errorMsg"), "The proper error message for invalid email is not displayed");
        AutomationLog.info("The Appropriate error message for invalid emails is displayed");
    }

    public void verifyIfEmailAlreadyExist(SignUp signup) throws Exception
    {
        SignUpData signupdata = new SignUpData();

        HashMap<String, String> ValidEmailData = testCaseData.get("VerifyEmailDetails");
        signupdata.setEmail(ValidEmailData.get("validEmail"));
        signup.populateSignUpData(signupdata);

        signup = signup.clickOnSignUpAccountButton();

        String validEmailAddress = signup.emailAlreadyRegistered().getText();
        Assert.assertEquals(validEmailAddress, ValidEmailData.get("validMsg"), "The proper message for valid mail is not displayed");
        AutomationLog.info("The Appropriate message Email already registered is displayed");
    }
}
