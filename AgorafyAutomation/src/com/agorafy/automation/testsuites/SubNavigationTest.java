package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.testcases.SubNavigationAction;

public class SubNavigationTest
{
    @BeforeSuite
    public void Init() throws Exception
    {
        String globalConfigureationFileWithPath = "src/com/agorafy/automation/configuration/config.properties";
        AutomationFramework.initWithGlobalConfiguration(globalConfigureationFileWithPath);
    }

    @Test
    public void testSubnavigationLinks() throws Exception
    {
        try
        {
            new SubNavigationAction().Execute();
        }
        catch(Exception e)
        {
            AutomationLog.error(e.getMessage());
            throw(e);
        }
    }
}
