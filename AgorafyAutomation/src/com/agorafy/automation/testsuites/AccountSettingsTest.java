package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.agorafy.automation.automationframework.Init;
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
        Init.globalConfiguration();
    }

    @Test
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

    @Test
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

    @Test
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

    @Test
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