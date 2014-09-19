package com.agorafy.automation.automationframework;

import java.util.HashMap;

import com.agorafy.automation.pageobjects.PageElement;

public class AutomationTestCase 
{
	protected HashMap<String, HashMap<String, String>> data;

    public void setup() 
    {
    	PageElement.driver = AppDriver.getDriver();
    }

    public void cleanup() 
    {
    	PageElement.driver.quit();
    }

    public void testcasePassed(String customMessage) 
    {
    }

    public void testcaseFailed(String customMessage) 
    {
        
    }
}
