package com.agorafy.automation.testcases;

import java.util.HashMap;

import com.agorafy.automation.automationframework.AutomationLog;


/**
 * Precondition: home page is loaded.
 * 
 * Test negative test cases of HEADER LOGIN form for
 * Wrong/invalid email and valid password
 * Valid email and invalid password
 * Invalid/wrong email password combination
 * empty email and password
 * empty email and valid password
 * combination of incorrect set of valid email and password
 * Not writing scripts for Captcha tests
 */

public class LoginNegativeTestsHeaderFormAction extends NegativeLoginBaseAction
{
    

    public LoginNegativeTestsHeaderFormAction()
    {
       super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifyUrlAndErrorMessage();
        testWrongEmailRightPassword();
        testRightEmailWrongPassword();
        testWrongEmailPassword();
        testEmptyEmail();
        testEmptyPassword();
        testMismatchValidCredentials();
    }

    public void testWrongEmailRightPassword() throws Exception
    {
        HashMap<String, String> loginData =  testCaseData.get("testWrongEmailRightPassword");
        header.link_Login().click();
        loginPage = headerLogin.doInvalidLogin(loginData.get("username"), loginData.get("password"));
        verifyUrlAndErrorMessage();
        AutomationLog.info("Test for Wrong Email and Right Password performed and passed");
    }

    public void testRightEmailWrongPassword() throws Exception
    {
        HashMap<String, String> loginData =  testCaseData.get("testRightEmailWrongPassword");
        header.link_Login().click();
        loginPage = headerLogin.doInvalidLogin(loginData.get("username"), loginData.get("password"));
        verifyUrlAndErrorMessage();
        AutomationLog.info("Test for Right Email and Wrong Password performed and passed");
    }

    public void testWrongEmailPassword() throws Exception
    {
        HashMap<String, String> loginData =  testCaseData.get("testWrongEmailPassword");
        header.link_Login().click();
        loginPage = headerLogin.doInvalidLogin(loginData.get("username"), loginData.get("password"));
        verifyUrlAndErrorMessage();
        AutomationLog.info("Test for Wrong Email and Password performed and passed");
    }

    public void testEmptyEmail() throws Exception
    {
        HashMap<String, String> loginData =  testCaseData.get("testEmptyEmail");
        loginData.put("username", "");
        header.link_Login().click();
        loginPage = headerLogin.doInvalidLogin(loginData.get("username"), loginData.get("password"));
        verifyUrlAndErrorMessage();
        AutomationLog.info("Test for Empty email performed and passed");
    }

    public void testEmptyPassword() throws Exception
    {
        HashMap<String, String> loginData =  testCaseData.get("testEmptyPassword");
        loginData.put("password", "");
        header.link_Login().click();
        loginPage = headerLogin.doInvalidLogin(loginData.get("username"), loginData.get("password"));
        verifyUrlAndErrorMessage();
        AutomationLog.info("Test for Empty email performed and passed");
    }

    public void testMismatchValidCredentials() throws Exception
    {
        HashMap<String, String> loginData =  testCaseData.get("testMismatchValidCredentials");
        header.link_Login().click();
        loginPage = headerLogin.doInvalidLogin(loginData.get("username"), loginData.get("password"));
        verifyUrlAndErrorMessage();
        AutomationLog.info("Test for Mismatching Valid Credentials performed and passed");
    }

    @Override
    protected String successMessage()
    {
        return "Negative Scenario for Header Login tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Negative Scenario for Header Login Failed";
    }
}