package com.agorafy.automation.testcases.smoketest;

import java.util.HashMap;

import com.agorafy.automation.testcases.SearchResultsAction;

public class SearchResultsSmokeAction extends SearchResultsAction
{
    public SearchResultsSmokeAction()
    {
        super("SearchResultsAction");
    }

    @Override
    public void setup()
    {
        super.setup();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        HashMap<String, String> viewtype = testCaseData.get("ViewType");
        verifySearchResultsForShortSearchTerm();
        verifySearchResultsForLongSearchTerm();
        verifyLoginOnAnalyticsButtonClick(viewtype);
    }
}
