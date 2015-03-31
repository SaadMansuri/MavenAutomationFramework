package com.agorafy.automation.testcases;

import java.util.HashMap;


import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Page;

public class LoginPositiveTestPageFormAction extends NegativeLoginBaseAction
{
    public LoginPositiveTestPageFormAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifyUrlAndErrorMessage(loginPage);

        Credentials ValidCredentials = userCredentials();
        homePage = loginPage.doSuccessfulLogin(ValidCredentials.getEmail(), ValidCredentials.getPassword());

        WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());

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
        return "Postive Scenario for Login from Login Page tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Positive Scenario for Login from Login Page failed";
    }
}