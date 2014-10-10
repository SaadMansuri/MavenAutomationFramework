package com.agorafy.automation.testcases;

import java.util.HashMap;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCase;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
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
public class LoginAction  extends AutomationTestCase
{
    private Homepage homePage = null;
    private HeaderLoginForm headerLoginForm = null;
    public LoginAction()
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
        headerLoginForm = null;
    }

    public void testSuccessfulLogin() throws Exception
    {
    	headerLoginForm = homePage.openHeaderLoginForm();
        AutomationLog.info("Click action is perfromed on My login link");

        // Get Test data from CSV
        HashMap<String, String> loginData =  testCaseData.get("validCredential");
        String sUserName = loginData.get("username");
        String sPassword = loginData.get("password");

        homePage = headerLoginForm.doSuccessfulLogin(sUserName, sPassword);

        // Wait for home page to appear after login
        WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());

        // Verify homepage is loaded correctly.
        // First check title of home page.
        HashMap<String, String> homepageData =  testCaseData.get("homepageData");
        String homepageTitle = homepageData.get("homepageTitle");
        if (!homepageTitle.equals(homePage.getTitle())) 
        {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the correct home page after login. Home Page title is not correct");
        }
        
        // Now check the url of Home page.
        String homepageUrl = homepageData.get("homepageUrl");
        if (!homepageUrl.equals(homePage.homepageUrl()))
        {
            throw new IllegalStateException("This is not the correct home page after login. Homepage url is not correct");
        }
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
