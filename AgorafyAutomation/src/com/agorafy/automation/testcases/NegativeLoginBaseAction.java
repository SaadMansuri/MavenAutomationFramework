package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.LoginPage;
import com.agorafy.automation.pageobjects.Page;

public abstract class NegativeLoginBaseAction extends AutomationTestCaseVerification
{
    protected Homepage homePage;
    protected LoginPage loginPage;
    protected HeaderLoginForm headerLogin;
    protected Header header;

    protected NegativeLoginBaseAction()
    {
        super(NegativeLoginBaseAction.class.getSimpleName());
    }

    @Override
    public void setup()
    {
        super.setup();
        try
        {
            homePage = Homepage.homePage();
            header = Page.header();
            headerLogin =  homePage.openHeaderLoginForm();
            loginPage = headerLogin.doInvalidLogin("", "");
        }
        catch(Exception e)
        {
            AutomationLog.error("Error Logging In");
        }
    }

    public void verifyUrlAndErrorMessage(LoginPage loginPage) throws Exception
    {
        WaitFor.waitForPageToLoad(Page.driver);
        HashMap<String, String> loginData =  testCaseData.get("verifyUrlAndErrorMessage");
        Assert.assertEquals(loginPage.currentURL(), loginPage.getPageUrl(), "Login page not seen after failed attempt");
        AutomationLog.info("Login Page is seen after failed login attempt");
        Assert.assertEquals(loginPage.message_InvalidEmailPassword().getText(), loginData.get("message"), "Error message displayed is Not as Expected");

        // TODO: Check for login attempts before captcha appears         
    }
}