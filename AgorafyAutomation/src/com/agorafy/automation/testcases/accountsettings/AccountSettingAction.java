package com.agorafy.automation.testcases.accountsettings;

import java.util.HashMap;

import org.testng.Assert;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.accountsettings.ChangePasswordTab;
import com.agorafy.automation.pageobjects.accountsettings.PersonalInfo;
import com.agorafy.automation.pageobjects.subnavigationmenu.EditProfile;

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
    PersonalInfo personalInfo = null;
    ChangePasswordTab changePasswordTab = null;
    EditProfile editprofile = null;

    public AccountSettingAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        HashMap<String, String> expectedAccountSettingsData = testCaseData.get("AccountSettings");
        verifyAccountSettingsPagePrimaryContents(expectedAccountSettingsData);

        verifyPersonalInformationtab(expectedAccountSettingsData);

        verifyChangePasswordTab(expectedAccountSettingsData);

        HashMap<String, String> editprofiledata = testCaseData.get("EditProfileData");

        verifyIfClickedOnHereLink(editprofiledata);

    }

    public void verifyAccountSettingsPagePrimaryContents(HashMap<String, String> expectedAccountSettingsData) throws Exception 
    {
        String expectedPageUrl = accountSettings.getApplicationUrl() + expectedAccountSettingsData.get("pageUrl");
        Assert.assertEquals(accountSettings.currentURL(), expectedPageUrl, "Account Settings link on Dashboard did not navigate to correct page Url");
        AutomationLog.info("Account Settings link on Dashboard redirected to correct page url");

        Assert.assertEquals(dashboard.getCurrentlyActiveLinkInLeftMenuLinks(), dashboard.link_AccountSettingText(), "Left Menu does not show Account Settings link as active link");
        AutomationLog.info("Account Settings on Left menu shows Account Settings Link Active");


        Assert.assertEquals(accountSettings.currentPageTitle(), expectedAccountSettingsData.get("title"), "Account Settings Page does not show correct Page Title");
        AutomationLog.info("Account Settings Page shows correct Page Title");

        Assert.assertEquals(accountSettings.pageHeading(), expectedAccountSettingsData.get("heading"), "Account Settings Page does not show correct Page Heading");
        AutomationLog.info("Account Setting Page shows correct Page Heading");

        AutomationLog.info("Account Settings Page is correctly loaded");
    }

    public void verifyPersonalInformationtab(HashMap<String, String> expectedAccountSettingsData) throws Exception
    {
        personalInfo = accountSettings.clickOnPersonalInfoTab();
        String expectedActiveElementCssClass = expectedAccountSettingsData.get("status");
        String actualActiveElementCssClass = accountSettings.isPersonalInfoTabActive();
        Assert.assertEquals(actualActiveElementCssClass, expectedActiveElementCssClass, "Clicking Personal Information Tab did not show Personal Information Tab active");
        Assert.assertTrue(personalInfo.form_PersonalInfo().isDisplayed(), "Expected Personal Information form not shown");
        AutomationLog.info("Clicking Personal Information Tab opened Personal Information Form");
    }

    public void verifyChangePasswordTab(HashMap<String, String> expectedAccountSettingsData) throws Exception 
    {
        changePasswordTab = accountSettings.clickOnChangePasswordTab();
        String expectedActiveElementCssClass = expectedAccountSettingsData.get("status");
        String actualActiveElementCssClass = accountSettings.isChangePasswordTabActive();
        Assert.assertEquals(actualActiveElementCssClass, expectedActiveElementCssClass, "Clicking Change Password Tab did not show Change Password Tab active");
        Assert.assertTrue(changePasswordTab.form_ChangePassword().isDisplayed(), "Expected Change Pasword form not shown");
        AutomationLog.info("Clicking Change Password Tab opened Change Password Form");
    }

    public void verifyIfClickedOnHereLink(HashMap<String, String> editprofiledata) throws Exception 
    {
        editprofile  = accountSettings.clickOnHereLink();
        String url = editprofile.getApplicationUrl() + editprofiledata.get("editProfilePageUrl");
        editprofiledata.put("url", url);
        Assert.assertEquals(editprofile.currentURL(), editprofiledata.get("url"), "Expected page url is not found");
        Assert.assertEquals(editprofile.currentPageTitle(), editprofiledata.get("title"), "Expected page title not found");
        Assert.assertEquals(editprofile.pageHeading(), editprofiledata.get("heading"), "Expected page heading not found");
        AutomationLog.info("Clicking here link redirects to Edit profile page");
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