package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.testcases.LoginPopUpAction;

public class LoginPopUpTest 
{
    @BeforeSuite
    public void Init()
     {
        String globalConfigureationFileWithPath = "src/com/agorafy/automation/configuration/config.properties";
        AutomationFramework.initWithGlobalConfiguration(globalConfigureationFileWithPath);
     }

    @Test
    public void testForgotPasswordActionTestCases() throws Exception
    {
        try
        {
            new LoginPopUpAction().Execute();
        }
        catch (Exception e) 
        {
            throw (e);
        }
    }
}
