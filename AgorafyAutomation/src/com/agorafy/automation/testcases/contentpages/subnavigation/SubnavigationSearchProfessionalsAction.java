package com.agorafy.automation.testcases.subnavigation;

import java.util.HashMap;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.subnavigationmenu.SearchProfessionalsPage;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.ContentPagesVerification;

/**
 * Test whether 'Search Professionals' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 */

public class SubnavigationSearchProfessionalsAction extends ContentPagesVerification
{
    public SubnavigationSearchProfessionalsAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        SubNavigation subnavigation = Page.subNavigation();
        SearchProfessionalsPage searchProfessionals = subnavigation.clickLinkSearchProfessionals();

        HashMap<String, String> expectedSearchProfData = testCaseData.get("SearchProfessionals");
        expectedSearchProfData.put("url", searchProfessionals.getURL());
        verifyLink(searchProfessionals, expectedSearchProfData);

        AutomationLog.info("Search Professionals Page is correctly loaded");
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
