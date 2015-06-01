package com.agorafy.automation.testcases;


import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.utilities.Login;

/**
 * Preconditions: Home page is loaded.
 * Get Login link in Home Page
 * Click Login link in Home Page.
 * Verify Login form is opened.
 * Verify Username text box is present.
 * Verify Password text box is present.
 * Verify submit button is present.
 * Populate Username text box with test user name.
 * Populate Password text box with test password.
 * Click submit.
 */
public abstract class LoginBaseAction extends AutomationTestCaseVerification
{
    protected Homepage homePage = null;
    protected HeaderLoginForm headerLoginForm = null;
    protected Header header = null;

    public LoginBaseAction() 
    {
        super();
    }

    @Override
    public void setup()
    {
        super.setup();
        try 
        {
            homePage = Login.doSuccessfullLoginFromHeaderLoginForm();
            header = Header.header();
            WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
        }
        catch (Exception e)
        {
            AutomationLog.error("Login Action Failed");
        }
    }
}
