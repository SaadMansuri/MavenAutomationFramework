package com.agorafy.automation.testcases.contentpages.subnavigation;

import java.util.HashMap;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.subnavigationmenu.SearchPropertiesPage;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;

/**
 * Test whether 'Search Properties' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 */

public class SubnavigationSearchPropertiesAction extends ContentPagesVerification
{
    public SubnavigationSearchPropertiesAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        SubNavigation subnavigation = Page.subNavigation();
        SearchPropertiesPage searchProperties = subnavigation.clickLinkSearchProperties();

        HashMap<String, String> expectedSearchPropData = testCaseData.get("SearchProperties");
        expectedSearchPropData.put("url", searchProperties.getURL());
        verifyLink(searchProperties, expectedSearchPropData);

        AutomationLog.info("Search Properties Page is correctly loaded");
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
