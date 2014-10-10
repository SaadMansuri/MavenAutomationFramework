package com.agorafy.automation.testcases;

import org.testng.Assert;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCase;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.LoginPage;

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

public class LoginNegativeTestsHeaderFormAction extends AutomationTestCase
{
    private Homepage homePage;
    private LoginPage loginPage;
    private HeaderLoginForm headerLogin;
    private Header header;

	public LoginNegativeTestsHeaderFormAction()
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
            header = Page.header();
            headerLogin =  homePage.openHeaderLoginForm();
            loginPage = headerLogin.doInvalidLogin("", "");
            verifyUrlAndErrorMessage(loginPage);

            testWrongEmailRightPassword();
            testRightEmailWrongPassword();
            testWrongEmailPassword();
            testEmptyEmail();
            testMismatchValidCredentials();
        } 
        catch (Exception e) 
        {
            testcaseFailed("For wrong login details Login page is not loaded");
            throw(e);
        }
        catch(Throwable throwable)
        {
        	testcaseFailed("For wrong login details Login page is not loaded");
        }
        finally 
        {
            cleanup();
        }
    }

    public void testWrongEmailRightPassword() throws Exception
    {
        header.link_Login().click();
        loginPage = headerLogin.doInvalidLogin("chandrani.bhaga@cuelogic.co.in", "cuelogic77");
        verifyUrlAndErrorMessage(loginPage);
        AutomationLog.info("Test for Wrong Email and Right Password performed and passed");
    }

    public void testRightEmailWrongPassword() throws Exception
    {
        header.link_Login().click();
        loginPage = headerLogin.doInvalidLogin("rohan.dixit@cuelogic.co.in", "12345678");
        verifyUrlAndErrorMessage(loginPage);
        AutomationLog.info("Test for Right Email and Wrong Password performed and passed");
    }

    public void testWrongEmailPassword() throws Exception
    {
        header.link_Login().click();
        loginPage = headerLogin.doInvalidLogin("abc@cuelogic.co.in", "12345678");
        verifyUrlAndErrorMessage(loginPage);
        AutomationLog.info("Test for Wrong Email and Password performed and passed");
    }

    public void testEmptyEmail() throws Exception
    {
        header.link_Login().click();
        loginPage = headerLogin.doInvalidLogin("", "cuelogic77");
        verifyUrlAndErrorMessage(loginPage);
        AutomationLog.info("Test for Empty email performed and passed");
    }

    public void testMismatchValidCredentials() throws Exception
    {
        header.link_Login().click();
        loginPage = headerLogin.doInvalidLogin("rohan.dixit@cuelogic.co.in", "cuelogic77");
        verifyUrlAndErrorMessage(loginPage);
        AutomationLog.info("Test for Mismatching Valid Credentials performed and passed");
    }

    public void verifyUrlAndErrorMessage(LoginPage loginPage) throws Exception
    {
        Assert.assertEquals(loginPage.currentURL(), loginPage.getPageUrl(), "Login page not seen after failed attempt");
        AutomationLog.info("Login Page is seen after failed login attempt");
        Assert.assertEquals(loginPage.message_InvalidEmailPassword().getText(), "Invalid email or password", "Error message displayed is incorrect");

        // TODO: Check for login attempts before captcha appears 		
	}
}
