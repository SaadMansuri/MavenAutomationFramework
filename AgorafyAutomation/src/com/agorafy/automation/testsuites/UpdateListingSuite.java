package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
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

    //@Test(priority = 1)
    public void testUpdateListingAvailabilityForm() throws Exception
    {
        try
        {
            new AvailabilityFormAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }

    //@Test(priority = 2)
    public void testUpdateListingDetailsForm() throws Exception
    {
        try
        {
            new DetailsFormAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }

    //@Test(priority = 3)
    public void testUpdateListingMediaForm() throws Exception
    {
        try
        {
            new MediaFormAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }

    //@Test(priority = 4)
    public void testUpdateListingContactsForm() throws Exception
    {
        try
        {
            new ContactsFormAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
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
            throw(e);
        }
    }
}
