package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.testcases.PropertyDetailAction;

public class PropertyDetailTest 
{
    @BeforeSuite
    public void Init()
     {
        String globalConfigureationFileWithPath = "src/com/agorafy/automation/configuration/config.properties";
        AutomationFramework.initWithGlobalConfiguration(globalConfigureationFileWithPath);
     }

    @Test
    public void testHeaderActionTestCases() throws Exception
    {
        try
        {
            new PropertyDetailAction().Execute();
        }
        catch (Exception e) 
        {
        	System.out.println(e.getMessage());
            throw (e);
        }
    }
}