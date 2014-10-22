package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;

/**
 * Verify Login was successful.
 * Verify Home Page is loaded with correct Title
 * Verify Home Page redirects to correct URL
 * Verify Home Page Greeting Text
 */
public class HomepageAction extends LoginBaseAction
{
    public HomepageAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        HashMap<String, String> homepageData =  testCaseData.get("homepageData");
        Assert.assertEquals(homePage.currentPageTitle(), homepageData.get("homepageTitle"), "This is not the correct home page after login. Home Page title is not correct");
        AutomationLog.info("Home Page title is correct");

        Assert.assertEquals(homePage.currentURL(), homePage.homepageUrl(), "This is not the correct home page after login. Homepage url is not correct");
        AutomationLog.info("Homepage url is correct");

        Assert.assertEquals(header.greeting(), homepageData.get("greeting"),"This is not the correct home page after login. Home Page Greeting Text is not correct");
        AutomationLog.info("Home Page Greeting Text is correct");

        AutomationLog.info("This is the correct home page after login.");
    }

    @Override
    protected String successMessage()
    {
        return "testSuccessfulLogin is successfully performed";
    }

    @Override
    protected String failureMessage()
    {
        return "SignIn Action  Failed";
    }
}
