package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.testcases.AccountSettingAction;
import com.agorafy.automation.testcases.ChangePasswordNegativeAction;
import com.agorafy.automation.testcases.ChangePasswordPositiveAction;
import com.agorafy.automation.testcases.PersonalInfoNegativeAction;
import com.agorafy.automation.testcases.PersonalInfoPositiveAction;

public class AccountSettingsTest
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
    public void testAccountSettingsPage() throws Exception
    {
        try
        {
            new AccountSettingAction().Execute();
        }
        catch (Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testChangePasswordNegativeTestcases() throws Exception
    {
        try
        {
           new ChangePasswordNegativeAction().Execute();
        }
        catch (Exception e)
        {
           throw (e);
        }
    }

    //@Test
    public void testChangePasswordPositiveTestcases() throws Exception
    {
        try
        {
            new ChangePasswordPositiveAction().Execute();
        }
        catch (Exception e)
        {
            throw (e);
        }
    }

    //@Test
    public void testPersonalInfoPositive() throws Exception
    {
        try
        {
            new PersonalInfoPositiveAction().Execute();
        }
        catch (Exception e)
        {
            throw(e);
        }
    }

    //@Test
    public void testPersonalInfoNegative() throws Exception
    {
        try
        {
            new PersonalInfoNegativeAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }
}