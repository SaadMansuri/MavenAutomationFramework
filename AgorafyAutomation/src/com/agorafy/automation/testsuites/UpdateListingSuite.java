package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.testcases.updateListing.*;

public class UpdateListingSuite 
{

    @BeforeSuite
    public void Init() throws Exception
    {
        //  Move this to some TestNg XML configuration file, so that we can set config file path
        // when running in headless mode.
        String globalConfigureationFileWithPath = "src/com/agorafy/automation/configuration/config.properties";
        AutomationFramework.initWithGlobalConfiguration(globalConfigureationFileWithPath);
    }

    @Test(priority = 1)
    public void testUpdateListingAvailabilityForm() throws Exception
    {
        try
        {
            new AvailabilityFormAction().Execute();
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to test update listing availibility form");
        }
    }

    @Test(priority = 2)
    public void testUpdateListingDetailsForm() throws Exception
    {
        try
        {
            new DetailsFormAction().Execute();
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to test Details form");
        }
    }

    @Test(priority = 3)
    public void testUpdateListingMediaForm() throws Exception
    {
        try
        {
            new MediaFormAction().Execute();
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to test media form");
        }
    }

    @Test(priority = 4)
    public void testUpdateListingContactsForm() throws Exception
    {
        try
        {
            new ContactsFormAction().Execute();
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to test Contacts form");
        }
    }

    @Test(priority = 5)
    public void testUpdateListingPreviewAndSubmitForm() throws Exception
    {
        try
        {
             new PreviewAndSubmitAction().Execute();
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to test preview and submit form");
        }
    }
}
