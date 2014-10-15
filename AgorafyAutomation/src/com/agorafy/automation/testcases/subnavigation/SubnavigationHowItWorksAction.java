package com.agorafy.automation.testcases.subnavigation;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.HowItWorks;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;

/**
 * Test whether 'How It Works' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 */

public class SubnavigationHowItWorksAction extends AutomationTestCaseVerification
{
    public SubnavigationHowItWorksAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        SubNavigation subnavigation = Page.subNavigation();
        HashMap<String, String> howItWorksExpectedData = testCaseData.get("HowItWorks");

        HowItWorks howItWorks = subnavigation.clickLinkHowitWorks();
        Assert.assertEquals(howItWorks.currentURL(), howItWorks.howItWorksPageUrl(), "How it Works Page URL is not as expected after clicking the link.");
        Assert.assertEquals(howItWorks.currentPageTitle(), howItWorksExpectedData.get("title"), "How it Works Page title does not match to the expected");
        Assert.assertEquals(howItWorks.headingText(), howItWorksExpectedData.get("heading"), "How it Works Page is not loaded with correct Heading");
        AutomationLog.info("How it Works page is correctly loaded");
    }

    @Override
    protected String successMessage()
    {
        return "How It Works link in Subnavigation tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Test for How It Works link in subnavigation failed";
    }

}
