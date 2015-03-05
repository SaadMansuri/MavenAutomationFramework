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
    private SubNavigation subnavigation;
    private HowItWorks howItWorks;
    private HashMap<String, String> expectedHowItWorksData = new HashMap<>();
    private ContentPagesLeftMenu leftMenu;

    public SubnavigationHowItWorksAction()
    {
        super();
    }

    @Override
    public void setup() 
    {
        super.setup();
        try 
        {
            subnavigation = Page.subNavigation();
            howItWorks = subnavigation.clickLinkHowitWorks();

            expectedHowItWorksData  = testCaseData.get("HowItWorks");
            expectedHowItWorksData.put("url", howItWorks.howItWorksPageUrl());

            leftMenu = Page.contentPagesLeftMenu();
            AutomationLog.info("Redirection to How it works passed");
        } 
        catch (Exception e) 
        {
            AutomationLog.error("Redirection to How it works failed");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifyLink(howItWorks, expectedHowItWorksData);

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
