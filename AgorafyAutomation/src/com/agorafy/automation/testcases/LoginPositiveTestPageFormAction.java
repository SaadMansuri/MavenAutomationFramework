package com.agorafy.automation.testcases;

import java.util.HashMap;
import org.testng.Assert;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.FacebookLogin;
import com.agorafy.automation.pageobjects.GooglePlusLogin;
import com.agorafy.automation.pageobjects.Page;

public class LoginPositiveTestPageFormAction extends NegativeLoginBaseAction
{
    FacebookLogin facebooklogin = null;
    GooglePlusLogin googlepluslogin = null;

    public LoginPositiveTestPageFormAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifyUrlAndErrorMessage();

        verifyLoginUsingFacebook();

        precondition();

        verifyLoginUsingGooglePlus();

        precondition();

        verifyHomePagePrimaryContents();

    }

    public void verifyHomePagePrimaryContents() throws Exception
    {
        Credentials ValidCredentials = userCredentials();
        Page.urlStatus = false;
        homePage = loginPage.doSuccessfulLogin(ValidCredentials.getEmail(), ValidCredentials.getPassword());

        WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
        HashMap<String, String> homepageData =  testCaseData.get("homepageData");
        String url = homePage.getApplicationURL() + homepageData.get("homePageUrl");
        homepageData.put("url", url);
        testHomePageContents(homepageData);

        AutomationLog.info("This is the correct home page after login.");
    }

    public void testHomePageContents(HashMap<String, String> homepageData) throws Exception
    {

        Assert.assertEquals(homePage.currentPageTitle(), homepageData.get("homepageTitle"), "This is not the correct home page after login. Home Page title is Not as Expected");
        AutomationLog.info("Home Page title is as Expected");

        Assert.assertEquals(homePage.currentURL(), homepageData.get("url"), "This is not the correct home page after login. Homepage url is Not as Expected");
        AutomationLog.info("Homepage url is as Expected");

        Assert.assertEquals(header.greeting(), homepageData.get("greeting"),"This is not the correct home page after login. Home Page Greeting Text is Not as Expected");
        AutomationLog.info("Home Page Greeting Text is as Expected");
    }

    public void precondition() throws Exception 
    {
        Page.header().logout();
        headerLogin = header.openHeaderLoginForm();
        WaitFor.sleepFor(1000);
        headerLogin.btn_LogInHeaderDropdown().click();
        WaitFor.waitForPageToLoad(Page.driver);
        verifyUrlAndErrorMessage();
    }

    public void verifyLoginUsingGooglePlus() throws Exception
    {
        HashMap<String, String> gpdata = testCaseData.get("googlePlusHomeData");
        googlepluslogin = loginPage.clickOnGooglePlusLink();
        homePage = googlepluslogin.doSuccessFullLoginUsingGooglePlus(gpdata.get("email"), gpdata.get("pass"));
        String url = homePage.getApplicationURL() + gpdata.get("homePageUrl");
        gpdata.put("url", url);
        testHomePageContents(gpdata);
        AutomationLog.info("Login using GooglePlus is successfull");
    }

    public void verifyLoginUsingFacebook() throws Exception
    {
        HashMap<String, String> fbdata = testCaseData.get("facebookHomeData");
        facebooklogin = loginPage.clickOnFacebookLink();
        homePage = facebooklogin.doSuccessFullLoginUsingFacebook(fbdata.get("email"), fbdata.get("pass"));
        String url = homePage.getApplicationURL() + "/home/#_=_";
        fbdata.put("url", url);
        testHomePageContents(fbdata);
        AutomationLog.info("Login using Facebook is successfull");
    }


    @Override
    protected String successMessage()
    {
        return "Postive Scenario for Login from Login Page tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Positive Scenario for Login from Login Page failed";
    }
}