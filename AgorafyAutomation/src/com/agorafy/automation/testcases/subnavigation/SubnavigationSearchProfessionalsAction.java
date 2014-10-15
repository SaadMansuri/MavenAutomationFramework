package com.agorafy.automation.testcases.subnavigation;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.subnavigationmenu.SearchProfessionalsPage;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;

/**
 * Test whether 'Search Professionals' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 */

public class SubnavigationSearchProfessionalsAction extends AutomationTestCaseVerification
{
    public SubnavigationSearchProfessionalsAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        SubNavigation subnavigation = Page.subNavigation();
        HashMap<String, String> searchProfessionalsExpectedData = testCaseData.get("SearchProff");

        SearchProfessionalsPage searchProfessionals = subnavigation.clickLinkSearchProfessionals();
        Assert.assertEquals(searchProfessionals.currentURL(), searchProfessionals.getURL(), "Search Professionals page URL is not as expected after clicking the link");
        Assert.assertEquals(searchProfessionals.currentPageTitle(), searchProfessionalsExpectedData.get("title"), "Search Professionals page title does not match to the expected");
        Assert.assertEquals(searchProfessionals.pageHeading(), searchProfessionalsExpectedData.get("heading"), "Search Professionals page is not loaded with correct Heading");
        AutomationLog.info("Search Professionals page is correctly loaded");
    }

    @Override
    protected String successMessage()
    {
        return "Search Professionals link in subnavigation tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Test for Search Professionals link in subnavigation Failed";
    }
}
