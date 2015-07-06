package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.testcases.smoketest.EditProfileOverviewSmokeAction;
import com.agorafy.automation.testcases.smoketest.ListingDetailsSmokeAction;
import com.agorafy.automation.testcases.smoketest.LoginSmokeAction;
import com.agorafy.automation.testcases.smoketest.MyListingSmokeAction;
import com.agorafy.automation.testcases.smoketest.PersonalInfoSmokeAction;
import com.agorafy.automation.testcases.smoketest.ReportsSmokeAction;
import com.agorafy.automation.testcases.smoketest.SearchProfessionalsSmokeAction;
import com.agorafy.automation.testcases.smoketest.SearchResultsSmokeAction;
import com.agorafy.automation.testcases.smoketest.ShowingsSmokeAction;
import com.agorafy.automation.testcases.smoketest.SubmitListingSmokeAction;
import com.agorafy.automation.testcases.smoketest.SubscribeToListingSmokeAction;
import com.agorafy.automation.testcases.smoketest.SubscribeToSearchSmokeAction;

public class SmokeTest 
{
    @BeforeSuite
    public void Init()
    {
        String globalConfigureationFileWithPath = "src/com/agorafy/automation/configuration/config.properties";
        AutomationFramework.initWithGlobalConfiguration(globalConfigureationFileWithPath);
    }

    @Test
    public void testLogin() throws Exception
    {
        try
        {
            new LoginSmokeAction().Execute();
        }
        catch (Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testSearchProfessionals() throws Exception
    {
        try
        {
            new SearchProfessionalsSmokeAction().Execute();
        }
        catch (Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testReports() throws Exception
    {
        try
        {
            new ReportsSmokeAction().Execute();
        }
        catch (Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testShowings() throws Exception
    {
        try
        {
            new ShowingsSmokeAction().Execute();
        }
        catch (Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void tesSubmitListing() throws Exception
    {
        try
        {
            new SubmitListingSmokeAction().Execute();
        }
        catch (Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testMyListing() throws Exception
    {
        try
        {
            new MyListingSmokeAction().Execute();
        }
        catch (Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testListingDetails() throws Exception
    {
        try
        {
            new ListingDetailsSmokeAction().Execute();
        }
        catch (Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testSubscribeToListing() throws Exception
    {
        try
        {
            new SubscribeToListingSmokeAction().Execute();
        }
        catch (Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testSubscribeToSearch() throws Exception
    {
        try
        {
            new SubscribeToSearchSmokeAction().Execute();
        }
        catch (Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testSearchResults() throws Exception
    {
        try
        {
            new SearchResultsSmokeAction().Execute();
        }
        catch (Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testEditProfile() throws Exception
    {
        try
        {
            new EditProfileOverviewSmokeAction().Execute();
        }
        catch (Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testPersonalInfo() throws Exception
    {
        try
        {
            new PersonalInfoSmokeAction().Execute();
        }
        catch (Exception e)
        {
            throw(e);
        }
    }

}
