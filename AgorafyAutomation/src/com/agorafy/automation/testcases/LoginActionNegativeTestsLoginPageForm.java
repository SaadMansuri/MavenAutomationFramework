package com.agorafy.automation.testcases;

import org.testng.Assert;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCase;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.LoginPage;

/**
 * Precondition: home page is loaded
 * Test negative test cases of LOGIN form on Login page for
 * Wrong/invalid email and valid password
 * Valid email and invalid password
 * Invalid/wrong email password combination
 * empty email and password
 * empty email and valid password
 * combination of incorrect set of valid email and password
 *
 * Not writing scripts for Captcha tests
 */

public class LoginActionNegativeTestsLoginPageForm extends AutomationTestCase
{
    private Homepage homePage;
    private LoginPage loginPage;
    private HeaderLoginForm headerlogin;
    
	public LoginActionNegativeTestsLoginPageForm()
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
            
            testWrongEmailRightPassword();
            testRightEmailWrongPassword();
            testWrongEmailPassword();
            testEmptyEmail();
            testEmptyEmailPassword();
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
             throw(new Exception(throwable.getMessage()));
        }
        finally 
        {
            cleanup();
        }
	}

	public void testWrongEmailRightPassword() throws Exception
	{
		loginPage = loginPage.doInvalidLogin("chandrani.bhaga@cuelogic.co.in", "cuelogic77");
		verifyInvalidLogin(loginPage);	
	}

	public void testRightEmailWrongPassword() throws Exception
	{
		loginPage = loginPage.doInvalidLogin("rohan.dixit@cuelogic.co.in", "12345678");
		verifyInvalidLogin(loginPage);	
	}

	public void testWrongEmailPassword() throws Exception
	{
        loginPage = loginPage.doInvalidLogin("abc@cuelogic.co.in", "12345678");
        verifyInvalidLogin(loginPage);	
	}

	public void testEmptyEmailPassword() throws Exception
	{
		loginPage = loginPage.doInvalidLogin("", "");
		verifyInvalidLogin(loginPage);	
	}

	public void testEmptyEmail() throws Exception
	{
		loginPage = loginPage.doInvalidLogin("", "cuelogic77");
		verifyInvalidLogin(loginPage);	
	}

	public void testMismatchValidCredentials() throws Exception
	{
		loginPage = loginPage.doInvalidLogin("rohan.dixit@cuelogic.co.in", "cuelogic77");
		verifyInvalidLogin(loginPage);	
	}

	public void verifyInvalidLogin(LoginPage loginPage) throws Exception
	{
        if(loginPage.getLoginPageUrl().contentEquals("https://preview.agorafy.com/login"))
		{
            System.out.println("Obtained current URL is correct");
            AutomationLog.info("Login Page is seen after failed login attempt");
		}

        Assert.assertEquals(loginPage.message_InvalidEmailPassword().getText(), "Invalid email or password", "Error message displayed is incorrect");
        
        // TODO: Check for login attempts before captcha appears 
	}
}
