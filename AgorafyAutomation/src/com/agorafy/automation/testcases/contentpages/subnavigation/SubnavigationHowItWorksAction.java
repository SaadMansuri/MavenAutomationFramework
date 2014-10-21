package com.agorafy.automation.testcases.contentpages.subnavigation;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.HowItWorks;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;

/**
 * Test whether 'How It Works' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 */

public class SubnavigationHowItWorksAction extends ContentPagesVerification
{
    public SubnavigationHowItWorksAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        SubNavigation subnavigation = Page.subNavigation();
        HowItWorks howItWorks = subnavigation.clickLinkHowitWorks();

        HashMap<String, String> expectedHowItWorksData = testCaseData.get("HowItWorks");
        expectedHowItWorksData.put("url", howItWorks.howItWorksPageUrl());
        verifyLink(howItWorks, expectedHowItWorksData);

        ContentPagesLeftMenu leftMenu = Page.contentPagesLeftMenu();
        Assert.assertEquals(leftMenu.getCurrentlyActiveLink(), leftMenu.howItWorksLinkText(),"Left menu does not show How It Works link as Active Link");
        AutomationLog.info("Left menu shows How It Works link as Active Link");

        AutomationLog.info("How It Works Page is correctly loaded");
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
