package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.testcases.subscriptions.SubscribeToListingAction;
import com.agorafy.automation.testcases.subscriptions.SubscribeToSearchAction;
/*Test Subscription related Pages*/

public class SubscriptionsTest 
{
    @BeforeSuite
    public void Init() throws Exception
    {
        String globalConfigureationFileWithPath = "src/com/agorafy/automation/configuration/config.properties";
        AutomationFramework.initWithGlobalConfiguration(globalConfigureationFileWithPath);
    }

    @Test
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

    @Test
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
