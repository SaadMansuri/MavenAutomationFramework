package com.agorafy.automation.testcases.contentpages.subnavigation;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.subnavigationmenu.EditProfile;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;
/**
 * Test whether 'Edit Profile' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 *
 */
public class SubnavigationEditProfileAction extends ContentPagesVerification 
{

    private Homepage homePage;
    private HeaderLoginForm headerLoginForm;
    private EditProfile editProfilePage;
    private HashMap<String, String> expectedEditProfileData;
    private SubNavigation subnavigation;
	private ContentPagesLeftMenu leftMenu;
	private Header header;

    public SubnavigationEditProfileAction() 
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
        subnavigation = Page.subNavigation();
        header = Header.header();
        headerLoginForm = header.openHeaderLoginForm();
        Credentials ValidCredentials = userCredentials();
        homePage = headerLoginForm.doSuccessfulLogin(ValidCredentials.getEmail(), ValidCredentials.getPassword());
        WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
        editProfilePage = subnavigation.clickLinkEditProfile(); 
        expectedEditProfileData = testCaseData.get("EditProfile");
        String url = editProfilePage.getApplicationUrl() + expectedEditProfileData.get("editProfilePageUrl");
        expectedEditProfileData.put("url", url);
        verifyLink(editProfilePage, expectedEditProfileData);

        AutomationLog.info("Testing whether same link is active in left side started...");
        verifyLeftMenu();
    }
    private void verifyLeftMenu() throws Exception 
    {
        leftMenu = Page.contentPagesLeftMenu();
        Assert.assertEquals(leftMenu.getCurrentlyActiveLink(), leftMenu.EditProfileLinkText(),"Left menu does not show Edit/View My Profile link as Active Link");
        AutomationLog.info("Left menu shows Edit/View My Profile link as Active Link");
    }

	@Override
    protected String successMessage() 
    {
        return "Sucessfully tested Subnavigation Edit Profile page";
    }

    @Override
    protected String failureMessage() 
    {
        return "Failed to test Subnavigation Edit Profile page";
    }

}
