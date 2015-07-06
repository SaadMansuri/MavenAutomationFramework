package com.agorafy.automation.testcases.smoketest;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.upsellpopups.LoginPopUp;
import com.agorafy.automation.utilities.Login;

public class LoginSmokeAction extends AutomationTestCaseVerification
{
    private Homepage homepage = null;
    private Header header = Header.header();
    private LoginPopUp loginpopup = null;

    public LoginSmokeAction()
    {
        super("SmokeTestData");
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
        HashMap<String, String> testdata = testCaseData.get("Login");
        verifyPositiveLoginFromHeader(testdata);
        preConditionForNextTest();
        verifyLoginUsingUpsell(testdata);
    }

    public void verifyPositiveLoginFromHeader(HashMap<String, String> testdata) throws Exception
    {
        homepage = Login.doSuccessfullLoginFromHeaderLoginForm();
        WaitFor.ElementToBeDisplayed(Page.driver, homepage.getHomepageGreetingsLocator());
        Assert.assertEquals(header.greeting(), testdata.get("greeting"), "Expected greeting not found");
        AutomationLog.info("Login using Header Login form is Successfull");
    }

    public void preConditionForNextTest() throws Exception 
    {
        Page.header().logout();
    }

    public void verifyLoginUsingUpsell(HashMap<String, String> testdata) throws Exception
    {
        boolean loginStatus = false;
        Credentials ValidCredentials = userCredentials();
        loginpopup = (LoginPopUp) header.clickSubmitListing(loginStatus);
        WaitFor.ElementToBeDisplayed(Page.driver, loginpopup.getLoginPopUpLocator());
        Assert.assertTrue(loginpopup.checkingLogInPopUp(), "Expected LoginPopUp is not shown");
        loginpopup.populateHomePageLoginPopUpData(ValidCredentials.getEmail(), ValidCredentials.getPassword());
        WaitFor.ElementToBeDisplayed(Page.driver, homepage.getHomepageGreetingsLocator());
        Assert.assertEquals(header.greeting(), testdata.get("greeting"), "Expected greeting not found");
        AutomationLog.info("Login using Upsell is Successfull");
    }

    @Override
    protected String successMessage()
    {
        return "Smoke test for Login passed";
    }

    @Override
    protected String failureMessage()
    {
        return "Smoke test for Login failed";
    }
}
