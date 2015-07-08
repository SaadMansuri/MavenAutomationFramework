package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.automationframework.Init;
import com.agorafy.automation.testcases.editprofile.CommercialTabAction;
import com.agorafy.automation.testcases.editprofile.OverviewTabAction;
import com.agorafy.automation.testcases.editprofile.OverviewTabNegativeAction;
import com.agorafy.automation.testcases.editprofile.ResidentialTabAction;
import com.agorafy.automation.testcases.editprofile.SocialMediaTabAction;

public class EditProfileTest
{
    @BeforeSuite
    public void Init()
    {
        Init.globalConfiguration();
    }

    @Test
    public void testOverviewTabPositiveTestCases() throws Exception
    {
        try
        {
            new OverviewTabAction().Execute();
        }
        catch (Exception e)
        {
            throw (e);
        }
    }

    @Test
    public void testOverviewTabNegativeTestCases() throws Exception
    {
        try
        {
            new OverviewTabNegativeAction().Execute();
        }
        catch (Exception e)
        {
            throw (e);
        }
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

    @Test
    public void testResidentialTabTestCase() throws Exception
    {
        try
        {
            new ResidentialTabAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testSocialMediaTabTestCase() throws Exception
    {
        try
        {
            new SocialMediaTabAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }
}
