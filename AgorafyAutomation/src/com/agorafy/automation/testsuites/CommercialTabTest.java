package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.testcases.CommercialTabAction;

public class CommercialTabTest 
{
    @BeforeSuite
    public void Init()
    {
        String globalConfigureationFileWithPath = "src/com/agorafy/automation/configuration/config.properties";
        AutomationFramework.initWithGlobalConfiguration(globalConfigureationFileWithPath);
    }

    @Test
    public void testCommercialTabTestCase() throws Exception
    {
        try
        {
            new CommercialTabAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }
}
