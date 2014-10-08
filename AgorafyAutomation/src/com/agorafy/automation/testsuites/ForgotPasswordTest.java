package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.testcases.ForgotPasswordAction;

public class ForgotPasswordTest 
{
    @BeforeSuite
    public void Init()
     {
        String globalConfigureationFileWithPath = "src/com/agorafy/automation/configuration/config.properties";
        AutomationFramework.initWithGlobalConfiguration(globalConfigureationFileWithPath);
     }

    @Test
    public void ForgotPasswordActionTest() throws Exception 
    {
        try
        {
            new ForgotPasswordAction().Execute();
        }
        catch (Exception e) 
        {
            AutomationLog.error(e.getMessage());
            throw (e);
        }
    }
}