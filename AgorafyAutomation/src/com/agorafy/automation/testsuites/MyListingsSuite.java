package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.Init;
import com.agorafy.automation.testcases.contentpages.subnavigation.MyListingsAction;

public class MyListingsSuite 
{
    @BeforeSuite
    public void Init()
    {
        Init.globalConfiguration();
    }

    @Test(priority = 1)
    public void testMyListings() throws Exception
    {
        try
        {
            new MyListingsAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }

}
