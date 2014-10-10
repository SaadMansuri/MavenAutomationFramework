package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.testcases.LoginAction;
import com.agorafy.automation.testcases.LoginNegativeTestsHeaderFormAction;
import com.agorafy.automation.testcases.LoginNegativeTestsPageFormAction;

public class LoginTest 
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
    public void testSign() throws Exception
    {
        try
        {
           new LoginAction().Execute();
        }
        catch (Exception e)
        {
            AutomationLog.error(e.getMessage());
            // Again throwing the exception to fail the test completely in the TestNG results
            throw (e);
        }
    }

    @Test
    public void testNegativeTestsLoginPageForm() throws Exception
    {
        try
        {
            new LoginNegativeTestsPageFormAction().Execute();
        }
        catch (Exception e)
        {
            AutomationLog.error(e.getMessage());
            // Again throwing the exception to fail the test completely in the TestNG results
            throw (e);
        }
    }
    @Test
    public void testNegativeTestsHeaderLoginPageForm() throws Exception
    {
        try
        {
            new LoginNegativeTestsHeaderFormAction().Execute();
        }
        catch (Exception e)
        {
            AutomationLog.error(e.getMessage());
            // Again throwing the exception to fail the test completely in the TestNG results
            throw (e);
        }
    }
}
