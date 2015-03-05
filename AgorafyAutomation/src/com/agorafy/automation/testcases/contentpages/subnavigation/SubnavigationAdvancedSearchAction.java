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
    private SubNavigation subnavigation;
    private AdvancedSearchPage advancedSearch;
    private HashMap<String, String> expectedAdvancedSearchData = new HashMap<>();

    public SubnavigationAdvancedSearchAction()
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
            advancedSearch = subnavigation.clickLinkAdvancedSearch();
            expectedAdvancedSearchData  = testCaseData.get("AdvancedSearch");
            expectedAdvancedSearchData.put("url", advancedSearch.getURL());

            AutomationLog.info("Redirection to Adavance search passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Redirection to Adavance search failed");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
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
