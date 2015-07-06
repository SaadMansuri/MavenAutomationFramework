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
        verifyHomePagePrimaryContents();
    }

    public void verifyHomePagePrimaryContents() throws Exception
    {
        HashMap<String, String> homepageData =  testCaseData.get("homepageData");
        Assert.assertEquals(homePage.currentPageTitle(), homepageData.get("homepageTitle"), "This is not the correct home page after login. Home Page title is Not as Expected");
        AutomationLog.info("Home Page title is as Expected");

        Assert.assertEquals(homePage.currentURL(), homePage.homepageUrl(), "This is not the correct home page after login. Homepage url is Not as Expected");
        AutomationLog.info("Homepage url is as Expected");

        Assert.assertEquals(header.greeting(), homepageData.get("greeting"),"This is not the correct home page after login. Home Page Greeting Text is Not as Expected");
        AutomationLog.info("Home Page Greeting Text is as Expected");

        AutomationLog.info("This is the correct home page after login.");
    }

    @Override
    protected String successMessage()
    {
        return "Home Page Verification After Login tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Home Page Verification After Login Failed";
    }
}
