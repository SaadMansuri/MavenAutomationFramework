package com.agorafy.automation.testcases.contentpages.subnavigation;

import java.util.HashMap;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.subnavigationmenu.SearchProfessionalsPage;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;

/**
 * Test whether 'Search Professionals' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 */

public class SubnavigationSearchProfessionalsAction extends ContentPagesVerification
{
    private SubNavigation subnavigation;
    private SearchProfessionalsPage searchProfessionals;
    private HashMap<String, String> expectedSearchProfData = new HashMap<>();

    public SubnavigationSearchProfessionalsAction()
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
             searchProfessionals = subnavigation.clickLinkSearchProfessionals();

             expectedSearchProfData  = testCaseData.get("SearchProfessionals");
             expectedSearchProfData.put("url", searchProfessionals.getURL());

            AutomationLog.info("Redirection to Search Professionals page passed");
         }
         catch (Exception e) 
         {
             AutomationLog.error("Redirection to Search Professionals page failed");
         }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
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
