package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.testcases.AdminShowingsAction;
import com.agorafy.automation.testcases.FrontEndShowingsAction;

public class AdminShowingsTest 
{
    @BeforeSuite
    public void Init()
    {
        String globalConfigureationFileWithPath = "src/com/agorafy/automation/configuration/config.properties";
        AutomationFramework.initWithGlobalConfiguration(globalConfigureationFileWithPath);
    }

    @Test
    public void AdminShowingsTestCases() throws Exception
    {
        try
        {
            new AdminShowingsAction().Execute();
        }
        catch (Exception e)
        {
            throw (e);
        }
    }

    @Test
    public void FrontEndShowingsTestCases() throws Exception
    {
        try
        {
            new FrontEndShowingsAction().Execute();
        }
        catch (Exception e)
        {
            throw (e);
        }
    }
}
