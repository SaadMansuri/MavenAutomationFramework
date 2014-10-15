package com.agorafy.automation.testcases.subnavigation;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.subnavigationmenu.SearchPropertiesPage;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;

/**
 * Test whether 'Search Properties' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 */

public class SubnavigationSearchPropertiesAction extends AutomationTestCaseVerification
{
    public SubnavigationSearchPropertiesAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        SubNavigation subnavigation = Page.subNavigation();
        HashMap<String, String> propertySearchExpectedData = testCaseData.get("SearchProp");

        SearchPropertiesPage searchProperties = subnavigation.clickLinkSearchProperties();
        Assert.assertEquals(searchProperties.currentURL(), searchProperties.getURL(), "Search Properties Page URL is not as expected after clicking the link.");
        Assert.assertEquals(searchProperties.currentPageTitle(), propertySearchExpectedData.get("title"), "Search Properties Page title does not match to the expected");
        Assert.assertEquals(searchProperties.pageHeading(), propertySearchExpectedData.get("heading"), "Search Properties Page is not loaded with correct Heading");
        AutomationLog.info("Search Properties page is correctly loaded");
    }

    @Override
    protected String successMessage()
    {
        return "Search Properties link in Subnavigation tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Test for Search Properties link in subnavigation failed";
    }
}
