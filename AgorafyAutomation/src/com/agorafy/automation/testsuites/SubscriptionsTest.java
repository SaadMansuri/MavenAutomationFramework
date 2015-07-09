package com.agorafy.automation.testsuites;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.Init;
import com.agorafy.automation.testcases.subscriptions.SubscribeToListingAction;
import com.agorafy.automation.testcases.subscriptions.SubscribeToSearchAction;



public class SubscriptionsTest
{
    @BeforeSuite
    public void Init()
    {
        Init.globalConfiguration();
    }

    @Test(priority = 1)
    public void testSubscribeToSearchLink() throws Exception
    {
        try
        {
            new SubscribeToSearchAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }

    @Test(priority = 2)
    public void testSubscribeToListingLink() throws Exception
    {
        try
        {
            new SubscribeToListingAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }

}
