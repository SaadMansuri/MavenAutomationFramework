package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.testcases.reports.AddToReportsAction;
import com.agorafy.automation.testcases.reports.ReportsAction;
import com.agorafy.automation.testcases.reports.ReportsPopUpAction;


public class ReportsTest 
{
    @BeforeSuite
    public void Init()
    {
        String globalConfigureationFileWithPath = "src/com/agorafy/automation/configuration/config.properties";
        AutomationFramework.initWithGlobalConfiguration(globalConfigureationFileWithPath);
    }

    @Test
    public void testReportsTestCase() throws Exception
    {
        try
        {
            new ReportsAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testAddToReportsTestCase() throws Exception
    {
        try
        {
            new AddToReportsAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testReportsPopUpTestCase() throws Exception
    {
        try
        {
            new ReportsPopUpAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }

}
