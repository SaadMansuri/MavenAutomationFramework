package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.testcases.UpdateListingAction;

public class UpdateListingSuite 
{

    @BeforeSuite
    public void Init() throws Exception
    {
        //  Move this to some TestNg XML configuration file, so that we can set config file path
        // when running in headless mode.
        String globalConfigureationFileWithPath = "src/com/agorafy/automation/configuration/config.properties";
        AutomationFramework.initWithGlobalConfiguration(globalConfigureationFileWithPath);
    }

    @Test(priority = 1)
    public void testUpdateListing() throws Exception
    {
        try
        {
            new UpdateListingAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }
}
