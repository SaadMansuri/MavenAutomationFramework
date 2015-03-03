package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.testcases.LoginAttemptsAction;

public class LoginAttemptsTest
{
    @BeforeSuite
    public void Init() throws Exception
    {
        // TODO: Move this to some TestNg XML configuration file, so that we can set config file path
        // when running in headless mode.
        String globalConfigureationFileWithPath = "src/com/agorafy/automation/configuration/config.properties";
        AutomationFramework.initWithGlobalConfiguration(globalConfigureationFileWithPath);
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
