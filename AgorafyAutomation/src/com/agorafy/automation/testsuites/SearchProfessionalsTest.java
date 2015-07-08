package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.automationframework.Init;
import com.agorafy.automation.testcases.SearchProfessionalsAction;

public class SearchProfessionalsTest 
{
    @BeforeSuite
    public void Init()
    {
        Init.globalConfiguration();
    }

    @Test
    public void searchProfessionalsTestCases() throws Exception
    {
        try
        {
            new SearchProfessionalsAction().Execute();
        }
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            throw (e);
        }
    }
}