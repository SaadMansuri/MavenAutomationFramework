package com.agorafy.automation.testcases;

import java.util.HashMap;

import com.agorafy.automation.pageobjects.Page;

/**
 * Precondition: home page is loaded
 * Test negative test cases of LOGIN form on Login page for
 * Wrong/invalid email and valid password
 * Valid email and invalid password
 * Invalid/wrong email password combination
 * empty email and password
 * empty email and valid password
 * combination of incorrect set of valid email and password
 * Not writing scripts for Captcha tests
 */

public class LoginNegativeTestsPageFormAction extends NegativeLoginBaseAction
{
    public LoginNegativeTestsPageFormAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifyUrlAndErrorMessage(loginPage);
        Page.urlStatus = true;
        testWrongEmailRightPassword();
        testRightEmailWrongPassword();
        testWrongEmailPassword();
        testEmptyEmail();
        testEmptyEmailPassword();
        testMismatchValidCredentials();
        Page.urlStatus = false;
    }

    public void testWrongEmailRightPassword() throws Exception
    {
        HashMap<String, String> logindata = testCaseData.get("testWrongEmailRightPassword");
        loginPage = loginPage.doInvalidLogin(logindata.get("username"), logindata.get("password"));
        verifyUrlAndErrorMessage(loginPage);
    }

    public void testRightEmailWrongPassword() throws Exception
    {
        HashMap<String, String> logindata = testCaseData.get("testRightEmailWrongPassword");
        loginPage = loginPage.doInvalidLogin(logindata.get("username"), logindata.get("password"));
        verifyUrlAndErrorMessage(loginPage);
    }

    public void testWrongEmailPassword() throws Exception
    {
        HashMap<String, String> logindata = testCaseData.get("testWrongEmailPassword");
        loginPage = loginPage.doInvalidLogin(logindata.get("username"), logindata.get("password"));
        verifyUrlAndErrorMessage(loginPage);
    }

    public void testEmptyEmailPassword() throws Exception
    {
        loginPage = loginPage.doInvalidLogin("", "");
        verifyUrlAndErrorMessage(loginPage);
    }

    public void testEmptyEmail() throws Exception
    {
        HashMap<String, String> logindata = testCaseData.get("testEmptyEmail");
        logindata.put("username", "");
        loginPage = loginPage.doInvalidLogin(logindata.get("username"), logindata.get("password"));
        verifyUrlAndErrorMessage(loginPage);
    }

    public void testMismatchValidCredentials() throws Exception
    {
        HashMap<String, String> logindata = testCaseData.get("testMismatchValidCredentials");
        loginPage = loginPage.doInvalidLogin(logindata.get("username"), logindata.get("password"));
        verifyUrlAndErrorMessage(loginPage);
    }

    @Override
    protected String successMessage()
    {
        return "Negative Scenario for Page Login tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Negative Scenario for Page Login Failed";
    }
}