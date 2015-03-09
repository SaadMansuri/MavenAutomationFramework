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
    private SubNavigation subnavigation;
    private SearchPropertiesPage searchProperties;
    private HashMap<String, String> expectedSearchPropData = new HashMap<>();

    public SubnavigationSearchPropertiesAction()
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
            searchProperties = subnavigation.clickLinkSearchProperties();
            expectedSearchPropData  = testCaseData.get("SearchProperties");
            expectedSearchPropData.put("url", searchProperties.getURL());
            AutomationLog.info("Redirection to search properties page sucessful");
        } 
        catch (Exception e) 
        {
            AutomationLog.error("Redirection to search properties page failed");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
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
