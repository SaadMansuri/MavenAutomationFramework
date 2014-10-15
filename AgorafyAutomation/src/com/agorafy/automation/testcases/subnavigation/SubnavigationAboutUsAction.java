package com.agorafy.automation.testcases.subnavigation;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.AboutUs;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;

/**
 * Test whether 'About Us' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 *
 */

public class SubnavigationAboutUsAction extends AutomationTestCaseVerification
{
    public SubnavigationAboutUsAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        SubNavigation subnavigation = Page.subNavigation();
        HashMap<String, String> aboutusExpectedData = testCaseData.get("Aboutus");

        AboutUs aboutUs = subnavigation.clickLinkAboutUs();
        Assert.assertEquals(aboutUs.currentURL(), aboutUs.aboutUsPageUrl(), "About Us Page URL is not as expected after clicking the link.");
        Assert.assertEquals(aboutUs.currentPageTitle(), aboutusExpectedData.get("title"), "About Us Page title does not match to the expected");
        Assert.assertEquals(aboutUs.headingText(), aboutusExpectedData.get("heading"), "About Us Page is not loaded with correct Heading");
        AutomationLog.info("About Us page is correctly loaded");
    }

    @Override
    protected String successMessage()
    {
        return "About Us link in Subnavigation tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Test for About Us link in Subnavigation Failed";
    }
}
