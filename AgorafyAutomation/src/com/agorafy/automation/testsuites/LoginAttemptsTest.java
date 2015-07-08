package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.automationframework.Init;
import com.agorafy.automation.testcases.LoginAttemptsAction;

public class LoginAttemptsTest
{
    @BeforeSuite
    public void Init()
    {
        Init.globalConfiguration();
    }

    @Test
    public void testCaptchaAppearance() throws Exception
    {
        try
        {
            new LoginAttemptsAction().Execute();
        }
        catch (Exception e)
        {
            throw (e);
        }
    }
}
