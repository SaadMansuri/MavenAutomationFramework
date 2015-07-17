package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.FacebookLogin;
import com.agorafy.automation.pageobjects.GooglePlusLogin;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;

public class LoginPositiveTestHeaderFormAction extends AutomationTestCaseVerification
{
    private Header header = Header.header();
    private HeaderLoginForm headerlogin = null;
    private FacebookLogin facebooklogin = null;
    private Homepage homepage = null;
    private GooglePlusLogin googlepluslogin;

    public LoginPositiveTestHeaderFormAction()
    {
        super("NegativeLoginBaseAction");
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifyLoginUsingFacebook();
        precondition();
        verifyLoginUsingGooglePlus();
    }

    public void precondition() throws Exception
    {
        Page.header().logout();
    }

    public void verifyLoginUsingFacebook() throws Exception 
    {
        HashMap<String, String> fblogindata = testCaseData.get("facebookHomeData");
        headerlogin = header.clickOnLoginLinkInTheHeader();
        WaitFor.ElementToBeDisplayed(Page.driver, headerlogin.getHeaderLoginFormLocator());
        WaitFor.sleepFor(2000);
        facebooklogin = headerlogin.clickOnFacebookLinkInHeaderLoginForm();
        homepage  = facebooklogin.doSuccessFullLoginUsingFacebook(fblogindata.get("email"), fblogindata.get("pass"));
        String url = homepage.getApplicationURL() + "/home/#_=_";
        fblogindata.put("url", url);
        testHomePageContents(fblogindata, homepage);
        AutomationLog.info("Login using Facebook is successfull");
    }

    public void verifyLoginUsingGooglePlus() throws Exception
    {
        HashMap<String, String> gpdata = testCaseData.get("googlePlusHomeData");
        headerlogin = header.clickOnLoginLinkInTheHeader();
        WaitFor.ElementToBeDisplayed(Page.driver, headerlogin.getHeaderLoginFormLocator());
        WaitFor.sleepFor(2000);
        googlepluslogin = headerlogin.clickOnGooglePlusLinkInHeaderLoginForm();
        homepage = googlepluslogin.doSuccessFullLoginUsingGooglePlus(gpdata.get("email"), gpdata.get("pass"));
        String url = homepage.getApplicationURL() + gpdata.get("homePageUrl");
        gpdata.put("url", url);
        testHomePageContents(gpdata,homepage);
        AutomationLog.info("Login using GooglePlus is successfull");
    }

    public void testHomePageContents(HashMap<String, String> homepageData, Homepage homepage) throws Exception
    {

        Assert.assertEquals(homepage.currentPageTitle(), homepageData.get("homepageTitle"), "This is not the correct home page after login. Home Page title is Not as Expected");
        AutomationLog.info("Home Page title is as Expected");

        Assert.assertEquals(homepage.currentURL(), homepageData.get("url"), "This is not the correct home page after login. Homepage url is Not as Expected");
        AutomationLog.info("Homepage url is as Expected");

        Assert.assertEquals(header.greeting(), homepageData.get("greeting"),"This is not the correct home page after login. Home Page Greeting Text is Not as Expected");
        AutomationLog.info("Home Page Greeting Text is as Expected");
    }

    @Override
    protected String successMessage()
    {
        return "test cases for header login form passed";
    }

    @Override
    protected String failureMessage()
    {
        return "test cases for header login form failed";
    }

}
