package com.agorafy.automation.testcases;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.AccountSettings;
import com.agorafy.automation.pageobjects.Dashboard;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;

public class AccountSettingAction extends AutomationTestCaseVerification
{
    private Homepage homePage = null;
    private HeaderLoginForm loginForm = null;
    private Header header = null;
    private Dashboard dashboard = null;
    private AccountSettings accountSettings = null;

    public AccountSettingAction()
    {
        super();
    }

    @Override
    public void setup()
    {
       super.setup();
       homePage = Homepage.homePage();
       try
       {
           loginForm = homePage.openHeaderLoginForm();
           homePage = loginForm.doSuccessfulLogin("rohan.dixit@cuelogic.co.in", "rohan123");
           WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
           header = Homepage.header();
           header.openActiveProfile();
           dashboard = header.openDashboard();
           accountSettings = dashboard.accountSettings();
       }
       catch (Exception e)
       {
            AutomationLog.error("Navigation to Account Settings Page failed");
       }
    }

    @Override
    protected void verifyTestCases()
    {
        try
        {

             AutomationLog.info("Account Settings Page opened successfully");

             Assert.assertEquals(accountSettings.currentURL(), "https://www.agorafy.com/account/","Account Settings link on Dashboard did not navigate to correct page Url");
             AutomationLog.info("Account Settings link on Dashboard redirected to correct page url");

             Assert.assertEquals(dashboard.getCurrentlyActiveLink(), dashboard.link_AccountSettingText(),"Left Menu does not show Account Settings link as active link");
             AutomationLog.info("Account Settings on Left menu shows Account Settings Link Active");

             Assert.assertEquals(accountSettings.currentPageTitle(), "AGORAFY", "Account Settings Page does not show correct Page Title");
             AutomationLog.info("Account Settings Page shows correct Page Title");

             Assert.assertEquals(accountSettings.headingText(), "Account Settings", "Account Settings Page does not show correct Page Heading");
             AutomationLog.info("Account Setting Page shows correct Page Heading");

             accountSettings.clickOnPersonalInfoTab();
             Assert.assertEquals(accountSettings.isPersonalInfoTabActive(), "active", "Clicking Personal Information Tab did not open Personal Information page");
             AutomationLog.info("Clicking Personal Information Tab opened Personal Information Page");

             accountSettings.clickOnChangePasswordTab();
             Assert.assertEquals(accountSettings.isChangePasswordTabActive(), "active", "Clicking Change Password Tab did not open Change Password page");
             AutomationLog.info("Clicking Change Password Tab opened Personal Information Page");
        }
        catch (Exception e)
        {
            AutomationLog.error("Either Account Settings Page did not open successfully or Account Settings Page verification failed");
        }
    }

    @Override
    protected String successMessage()
    {
        return "Account Settings link tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Account Settings Action failed";
    }
}