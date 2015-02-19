package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
//import com.agorafy.automation.testcases.SubscriptionsAction;
/*Test Subscription Pages*/


public class SubscriptionsTest 
{
    @BeforeSuite
    public void Init() throws Exception
    {
        String globalConfigureationFileWithPath = "src/com/agorafy/automation/configuration/config.properties";
        AutomationFramework.initWithGlobalConfiguration(globalConfigureationFileWithPath);
    }

    @Test
    public void testSubscriptionsLink() throws Exception
    {
        try
        {
            new SubscriptionsAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }
}
