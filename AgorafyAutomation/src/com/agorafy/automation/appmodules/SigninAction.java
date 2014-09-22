package com.agorafy.automation.appmodules;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCase;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.LoginPage;
import com.agorafy.automation.pageobjects.Page;

/**
 * Preconditions: Home page is loaded.
 *
 * Get Login link in Home Page
 * Click Login link in Home Page.
 * Verify Login form is opened.
 * Verify Username text box is present.
 * Verify Password text box is present.
 * Verify submit button is present.
 * Populate Username text box with test user name.
 * Populate Password text box with test password.
 * Click submit.
 * Verify Login was successful.
 * Verify Home page greeting message is displayed.
 */
public class SigninAction  extends AutomationTestCase
{
    private Homepage homePage = null;
    private LoginPage loginpage = null;

    public SigninAction()
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
        homePage = null;
        loginpage = null;
    }

    public void testSuccessfulLogin() throws Exception
    {
        loginpage = homePage.gotoLoginPage();
        AutomationLog.info("Click action is perfromed on My login link");

        // Get data from CSV
//        HashMap<String, String> loginData =  testCaseData.get("Valid Profile");
//        String sUserName = loginData.get("userName");
//        String sPassword = loginData.get("password");;
        homePage = loginpage.doSuccessfulLogin("chandrani.bhagat@cuelogic.co.in", "cuelogic77");

        WaitFor.presenceOfTheElement(Page.driver, homePage.getGreetingsLocator());
        AutomationLog.info("testSuccessfulLogin is successfully perfomred");
    }

    public void Execute() throws Exception
    {
        try 
        {
            setup();
            testSuccessfulLogin();
            testcasePassed("testSuccessfulLogin is successfully perfomred");
        } 
        catch (Exception e) 
        {
            testcaseFailed("SignIn Action  Failed");
            throw(e);
        }
        finally 
        {
            cleanup();
        }
    }
}
