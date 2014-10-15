package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.testcases.OverviewAction;
import com.agorafy.automation.testcases.OverviewTabNegativeAction;

public class ProfileOverviewTest
{
    @BeforeSuite
    public void Init()
    {
        // TODO: Move this to some TestNg XML configuration file, so that we can set config file path
        // when running in headless mode.
        String globalConfigureationFileWithPath = "src/com/agorafy/automation/configuration/config.properties";
        AutomationFramework.initWithGlobalConfiguration(globalConfigureationFileWithPath);
    }
    //@Test
    public void OverviewActionTest() throws Exception
    {
        try
        {
            new OverviewAction().Execute();
        }
        catch (Exception e)
        {
            AutomationLog.error(e.getMessage());
        throw (e);
        }
    }

    @Test
    public void OverviewTabNegativeActionTest() throws Exception
    {
        try
        {
            new OverviewTabNegativeAction().Execute();
        }
        catch (Exception e)
        {
            AutomationLog.error(e.getMessage());
            throw (e);
        }
    }
}
