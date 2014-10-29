package com.agorafy.automation.testcases.contentpages.subnavigation;

import java.util.HashMap;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.subnavigationmenu.AdvancedSearchPage;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;

/**
 * Test whether 'Advanced Search' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 */

public class SubnavigationAdvancedSearchAction extends ContentPagesVerification
{
    public SubnavigationAdvancedSearchAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        SubNavigation subnavigation = Page.subNavigation();
        AdvancedSearchPage advancedSearch = subnavigation.clickLinkAdvancedSearch();

        HashMap<String, String> expectedAdvancedSearchData = testCaseData.get("AdvancedSearch");
        expectedAdvancedSearchData.put("url", advancedSearch.getURL());
        verifyLink(advancedSearch, expectedAdvancedSearchData);

        AutomationLog.info("Advanced Search page is correctly loaded");
    }

    @Override
    protected String successMessage()
    {
        return "Advanced Search link in subnavigation tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Test for Advanced Search link in subnavigation Failed";
    }
}
