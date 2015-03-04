package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.testcases.HomepageAction;
import com.agorafy.automation.testcases.LoginAttemptsAction;
import com.agorafy.automation.testcases.LoginNegativeTestsHeaderFormAction;
import com.agorafy.automation.testcases.LoginNegativeTestsPageFormAction;
import com.agorafy.automation.testcases.LoginPositiveTestPageFormAction;

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

    @Test(priority = 3)
    public void testSignIn() throws Exception
    {
        try
        {
           new HomepageAction().Execute();
        }
        catch (Exception e)
        {
            throw (e);
        }
    }

    @Test(priority = 2)
    public void testNegativeTestsLoginPageForm() throws Exception
    {
        try
        {
            new LoginNegativeTestsPageFormAction().Execute();
        }
        catch (Exception e)
        {
            throw (e);
        }
    }

    @Test(priority = 4)
    public void testNegativeTestsHeaderLoginPageForm() throws Exception
    {
        try
        {
            new LoginNegativeTestsHeaderFormAction().Execute();
        }
        catch (Exception e)
        {
            throw (e);
        }
    }

    @Test(priority = 1)
    public void testPositiveTestLoginPageForm() throws Exception
    {
        try
        {
            new LoginPositiveTestPageFormAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }
}
