package com.agorafy.automation.testcases;

import java.util.HashMap;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.AccountSettings;
import com.agorafy.automation.pageobjects.Dashboard;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;

public abstract class AccountSettingsBaseAction extends AutomationTestCaseVerification
{
    protected Homepage homePage = null;
    protected HeaderLoginForm loginForm = null;
    protected Dashboard dashboard = null;
    protected Header header = null;
    protected AccountSettings accountSettings = null;
    protected SubNavigation subnavigation = null;;

    protected AccountSettingsBaseAction()
    {
        super(AccountSettingsBaseAction.class.getSimpleName());
    }

    @Override
    public void setup()
    {
        super.setup();
        try
        {
            homePage = Homepage.homePage();
            header = Header.header();
            loginForm = header.openHeaderLoginForm();
            HashMap<String, String> expectedLoginData = testCaseData.get("validCredential");
            homePage = loginForm.doSuccessfulLogin(expectedLoginData.get("username"),expectedLoginData.get("password"));
            WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
            header = Header.header();

            subnavigation = Page.subNavigation();
            dashboard = subnavigation.clickLinkMyDashboard();
            accountSettings = dashboard.accountSettings();
        }
        catch (Exception e)
        {
             AutomationLog.error("Navigation to Account Settings Page failed");
        }
    }
}