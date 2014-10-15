package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCase;
import com.agorafy.automation.datamodel.profile.ForgotPasswordData;
import com.agorafy.automation.pageobjects.ForgotPassword;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.LoginPage;

public class ForgotPasswordAction extends AutomationTestCase
{
    private Homepage homePage;
    private LoginPage loginPage;
    private HeaderLoginForm headerlogin;

    public ForgotPasswordAction()
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
             headerlogin =  homePage.openHeaderLoginForm();
             loginPage = headerlogin.doInvalidLogin("", "");
             ForgotPassword forgotPassword = loginPage.clickOnForgotPassword();
             verifyIfTheUserEnteredWrongEmailAddress(forgotPassword);
        }
        catch (Exception e)
        {
             testcaseFailed("For forpassword when user enter wrong email address");
             throw(e);
        }
        catch(Throwable throwable)
        {
            testcaseFailed("For forpassword when user enter wrong email address");
            throw(new Exception(throwable.getMessage()));
        }
        finally
        {
            cleanup();
        }
    }

    public void verifyIfTheUserEnteredWrongEmailAddress(ForgotPassword forgotpassword) throws Exception
    {
        ForgotPasswordData forgotpassworddata = new ForgotPasswordData();

        HashMap<String, String> invalidEmailData = testCaseData.get("UserEnteredWrongEmailAddress");
        forgotpassworddata.setEmailAddress(invalidEmailData.get("invalidEmail"));

        forgotpassword.populateForgotPasswordData(forgotpassworddata);
        forgotpassword = forgotpassword.clickOnRequestNewPassword();
        String invalidEmailAddress = forgotpassword.errorMessageEnterValidMail().getText();
        Assert.assertEquals(invalidEmailAddress, invalidEmailData.get("errorMsg"), "The proper error message please enter valid email address is not displayed");
        AutomationLog.info("The Appropriate error message please enter valid email is displayed");
    }
}
