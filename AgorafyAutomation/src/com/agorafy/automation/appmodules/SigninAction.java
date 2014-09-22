package com.agorafy.automation.appmodules;


import java.util.HashMap;

import org.openqa.selenium.By;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCase;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.LoginPage;
import com.agorafy.automation.pageobjects.Page;

public class SigninAction  extends AutomationTestCase
{
    private Homepage homePage = null;
    private LoginPage loginpage = null;

    public SigninAction()
    {
        super(SigninAction.class.getName());
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
