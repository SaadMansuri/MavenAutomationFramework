package com.agorafy.automation.testcases.upsellpopups;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.SignUp;
import com.agorafy.automation.pageobjects.upsellpopups.LoginPopUp;

/**
 * To Test Login Pop up
 * Precondition : SignUp page is loaded
 * Login link is present on SignUp page
 * verify Clicking on Login Link shows login Pop Up
 * verify if valid credentials are entered in login pop up then page redirected to Homepage
 */
public class SignupPageLoginAction extends AutomationTestCaseVerification
{
    private SignUp signup = null;
    private Header header = null;
    private Homepage homepage = null;
    private LoginPopUp loginpopup = null;

    public SignupPageLoginAction()  
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
            signup = header.clickOnSignUpUpLink();
        }
        catch(Exception e)
        {
            AutomationLog.error("could not navigate to login pop up");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
        Credentials validCredentials = userCredentials();
        verifyLoginUpsellOnSignup(loginpopup,validCredentials);
    }

    public void verifyLoginUpsellOnSignup(LoginPopUp loginpopup, Credentials credentials) throws Exception
    {
        try
        {
            
            loginpopup = signup.clickOnLoginLink();
            Thread.sleep(7000);
            Assert.assertEquals(loginpopup.checkingLogInPopUp(), true, "Login pop up is not seen after clicking on Subscribe to Listing");
            loginpopup.populateLoginPopUpData(credentials.getEmail(),credentials.getPassword());
            homepage = (Homepage) loginpopup.clickLoginButtonOnUpsell();
            String expectedUrl = homepage.homepageUrl();
            Assert.assertEquals(homepage.currentURL(), expectedUrl, "Expected home page is not shown");
            AutomationLog.info("expected page is loaded after login");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not navigate to login pop up");
        }
    }

    @Override
    protected String successMessage()
    {
        return "loginpopup test case passed";
    }

    @Override
    protected String failureMessage()
    {
        return "loginpopup test case failed";
    }
    
    //TODO verify if login popup is present on click
}
