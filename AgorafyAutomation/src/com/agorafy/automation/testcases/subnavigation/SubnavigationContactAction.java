package com.agorafy.automation.testcases.subnavigation;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.Contact;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;

/**
 * Test whether 'Contact' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 */

public class SubnavigationContactAction extends AutomationTestCaseVerification
{
    public SubnavigationContactAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        SubNavigation subnavigation = Page.subNavigation();
        HashMap<String, String> contactExpectedData = testCaseData.get("Contact");

        Contact contactPage = subnavigation.clickLinkContact();
        Assert.assertEquals(contactPage.currentURL(), contactPage.contactPageUrl(), "Contact page URL is not as expected after clicking the link");
        Assert.assertEquals(contactPage.currentPageTitle(), contactExpectedData.get("title"), "Contact page title does not match to the expected");
        Assert.assertEquals(contactPage.headingText(), contactExpectedData.get("heading"), "Contact page is not loaded with correct Heading");
        AutomationLog.info("Contact page is correctly loaded");
    }

    @Override
    protected String successMessage()
    {
        return "Contact link in Subnavigation tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Test for Contact link in Subnavigation Failed";
    }
}
