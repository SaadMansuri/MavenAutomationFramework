package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;

/**
 * To Test Account Settings Page
 * Verify Account Settings Page is loaded 
 * Verify Url of Account Settings Page
 * Verify Title and Page Heading
 * Verify Left Menu shows Account Settings link active
 * verify Clicking PersonalInformation and ChangePassword Tabs open respective pages
 */
public class AccountSettingAction extends AccountSettingsBaseAction
{
    public AccountSettingAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        Assert.assertEquals(accountSettings.currentURL(), accountSettings.accountSettingsPageUrl(), "Account Settings link on Dashboard did not navigate to correct page Url");
        AutomationLog.info("Account Settings link on Dashboard redirected to correct page url");

        Assert.assertEquals(dashboard.getCurrentlyActiveLink(), dashboard.link_AccountSettingText(), "Left Menu does not show Account Settings link as active link");
        AutomationLog.info("Account Settings on Left menu shows Account Settings Link Active");

        HashMap<String, String> expectedAccountSettingsData = testCaseData.get("AccountSettings");
        Assert.assertEquals(accountSettings.currentPageTitle(),expectedAccountSettingsData.get("title"), "Account Settings Page does not show correct Page Title");
        AutomationLog.info("Account Settings Page shows correct Page Title");

        Assert.assertEquals(accountSettings.pageHeading(),expectedAccountSettingsData.get("heading"), "Account Settings Page does not show correct Page Heading");
        AutomationLog.info("Account Setting Page shows correct Page Heading");

        accountSettings.clickOnPersonalInfoTab();
        String expectedActiveElementCssClass = expectedAccountSettingsData.get("status");
        String actualActiveElementCssClass = accountSettings.isPersonalInfoTabActive();
        Assert.assertEquals(actualActiveElementCssClass, expectedActiveElementCssClass, "Clicking Personal Information Tab did not open Personal Information page");
        AutomationLog.info("Clicking Personal Information Tab opened Personal Information Page");

        accountSettings.clickOnChangePasswordTab();
        actualActiveElementCssClass = accountSettings.isChangePasswordTabActive();
        Assert.assertEquals(actualActiveElementCssClass, expectedActiveElementCssClass, "Clicking Change Password Tab did not open Change Password page");
        AutomationLog.info("Clicking Change Password Tab opened Personal Information Page");

        AutomationLog.info("Account Settings Page is correctly loaded");
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