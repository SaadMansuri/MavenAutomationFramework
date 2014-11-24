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
    private ForgotPassword forgotPassword = null;

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
        HashMap<String, String> expectedEmailData = testCaseData.get("EmptyEmail");
        verifyIfTheUserEnteredEmptyEmailAddress(forgotPassword,expectedEmailData);

        expectedEmailData = testCaseData.get("InvalidEmail");
        verifyIfTheUserEnteredInvalidEmailAddress(forgotPassword,expectedEmailData);

        expectedEmailData = testCaseData.get("UnRegisteredValidEmail");
        verifyIfTheUserEnteredValidEmailAddress(forgotPassword, expectedEmailData);

        verifyBackToLoginLinkInForgotPasswordPage();

    }

    private ForgotPassword populateEmailFieldAndRequestNewPassword(HashMap<String, String> expectedEmailData) throws Exception
    {
        EmailData forgotpassworddata = new EmailData();
        forgotpassworddata.setEmailAddress(expectedEmailData.get("email"));
        forgotPassword.populateForgotPasswordData(forgotpassworddata);
        forgotPassword = forgotPassword.clickOnRequestNewPassword();
        return forgotPassword;
    }

    public void verifyIfTheUserEnteredEmptyEmailAddress(ForgotPassword forgotPassword, HashMap<String, String> expectedEmailData) throws Exception
    {
        forgotPassword = populateEmailFieldAndRequestNewPassword(expectedEmailData);
        String emptyEmailAddress = forgotPassword.getErrorMessageOfInvalidEmail();
        Assert.assertEquals(emptyEmailAddress, expectedEmailData.get("emptyEmailErrorMsg"), "Expected error message for empty email is not displayed in Forgot Password page");
        AutomationLog.info("Expected error message for empty email is displayed in Forgot Password page");
    }

    public void verifyIfTheUserEnteredInvalidEmailAddress(ForgotPassword forgotpassword, HashMap<String, String> expectedEmailData) throws Exception
    {
        forgotpassword = populateEmailFieldAndRequestNewPassword(expectedEmailData);
        String invalidEmailAddress = forgotpassword.getErrorMessageOfInvalidEmail();
        Assert.assertEquals(invalidEmailAddress, expectedEmailData.get("invalidEmailErrorMsg"), "Expected error message for invalid email is not displayed in Forgot Password page");
        AutomationLog.info("Expected error message for invalid email is not displayed in Forgot Password page");   
    }

    public void verifyIfTheUserEnteredValidEmailAddress(ForgotPassword forgotpassword, HashMap<String, String> expectedEmailData) throws Exception
    {
        forgotpassword = populateEmailFieldAndRequestNewPassword(expectedEmailData);
        WaitFor.waitForPageToLoad(Page.driver, expectedEmailData.get("validMailNotReg"), forgotpassword.validEmailNotRegistered());

        String validEmailAddress = forgotpassword.getMessageOfValidEmailNotReg();
        Assert.assertEquals(validEmailAddress, expectedEmailData.get("validMailNotReg"),"Expected error message for valid email is not displayed in Forgot Password page");
        AutomationLog.info("Expected error message for valid email is displayed in Forgot Password page");
    }
    
    public void verifyBackToLoginLinkInForgotPasswordPage() throws Exception
    {
    	LoginPage BackToLogin = forgotPassword.clickOnBackToLoginLink();
        Assert.assertEquals(BackToLogin.currentURL(),"https://www.agorafy.com/login","The CurrentURL is not been not found");
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
