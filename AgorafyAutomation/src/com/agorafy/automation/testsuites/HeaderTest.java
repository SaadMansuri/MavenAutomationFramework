package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.Init;
import com.agorafy.automation.testcases.HeaderAction;

public class HeaderTest
{
    @BeforeSuite
    public void Init()
    {
        Init.globalConfiguration();
    }

    @Test
    public void testHeaderActionTestCases() throws Exception
    {
        try
        {
            new HeaderAction().Execute();
        }
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            throw (e);
        }
    }
}
