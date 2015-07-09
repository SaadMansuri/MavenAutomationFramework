package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.Init;
import com.agorafy.automation.testcases.SearchResultsAction;

public class SearchResultsTest 
{
    @BeforeSuite
    public void Init()
    {
        Init.globalConfiguration();
    }

    @Test
    public void propertySearchActionTestCases() throws Exception
    {
        try
        {
            new SearchResultsAction().Execute();
        }
        catch (Exception e) 
        {
            throw (e);
        }
    }
}
