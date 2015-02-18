package com.agorafy.automation.testsuites;


import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.testcases.submitlisting.SubmitListingContactsFormAction;
import com.agorafy.automation.testcases.submitlisting.SubmitListingDetailsFormOfficeAction;
import com.agorafy.automation.testcases.submitlisting.SubmitListingDetailsFormPropertyAction;
import com.agorafy.automation.testcases.submitlisting.SubmitListingDetailsFormResidentialAction;
import com.agorafy.automation.testcases.submitlisting.SubmitListingDetailsFormRetailAction;
import com.agorafy.automation.testcases.submitlisting.SubmitListingLocationFormAction;
import com.agorafy.automation.testcases.submitlisting.SubmitListingMediaFormAction;
import com.agorafy.automation.testcases.submitlisting.SubmitListingPreviewAndSubmitFormAction;

public class SubmitListingTest
{
    @BeforeSuite
    public void Init()
    {
         String globalConfigureationFileWithPath = "src/com/agorafy/automation/configuration/config.properties";
         AutomationFramework.initWithGlobalConfiguration(globalConfigureationFileWithPath);
    }

    @Test(priority = 1)
    public void testSubmitListingLocationFormTestCases() throws Exception 
    {
        try
        {
            new SubmitListingLocationFormAction().Execute();
        } 
        catch (Exception e) 
        {
            throw (e);
        }
    }

    @Test( priority = 2)
    public void testSubmitListingDetailsFormTestCases() throws Exception 
    {
        try
        {
            new SubmitListingDetailsFormRetailAction().Execute();
            new SubmitListingDetailsFormOfficeAction().Execute();
            new SubmitListingDetailsFormResidentialAction().Execute();
            new SubmitListingDetailsFormPropertyAction().Execute();
        } 
        catch (Exception e) 
        {
            throw (e);
        }
    }

    @Test(priority = 3)
    public void testSubmitListingMediaFormTestCases() throws Exception 
    {
        try
        {
            new SubmitListingMediaFormAction().Execute();
        } 
        catch (Exception e) 
        {
            throw (e);
        }
    }

    @Test(priority = 4)
    public void testSubmitListingContactsFormTestCases() throws Exception 
    {
        try
        {
            new SubmitListingContactsFormAction().Execute();
        } 
        catch (Exception e) 
        {
            throw (e);
        }
    }

    @Test(priority = 5)
    public void testSubmitListingPreviewAndSubmitFormTestCases() throws Exception 
    {
        try
        {
            new SubmitListingPreviewAndSubmitFormAction().Execute();
        } 
        catch (Exception e) 
        {
            throw (e);
        }
    }

}
