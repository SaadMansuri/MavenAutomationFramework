package com.agorafy.automation.automationframework;

import java.util.HashMap;

import com.agorafy.automation.pageobjects.Page;

public class AutomationTestCase 
{
    protected HashMap<String, HashMap<String, String>> testCaseData;
    private static String TESTDATA_FILE_EXTENSION = ".csv";
    
    private String executingTestCaseName = null;

    public AutomationTestCase() 
    {
        executingTestCaseName = this.getClass().getSimpleName();
    }

    public void setup() 
    {
        AutomationLog.startTestCase(executingTestCaseName);
        String browserToUse = Configuration.getConfigurationValueForProperty("browser");
        new Page(AppDriver.getDriver(browserToUse));
       // populate test case data from csv
        testCaseData = TestDataProvider.readTestDataFromCSV(executingTestCaseName + TESTDATA_FILE_EXTENSION);
    }

    public void cleanup() 
    {
        AutomationLog.endTestCase(executingTestCaseName);
        Page.driver.quit();
    }

    public void testcasePassed(String customMessage) 
    {
        AutomationLog.info(executingTestCaseName + customMessage);
    }

    public void testcaseFailed(String customMessage) 
    {
        AutomationLog.info(executingTestCaseName + customMessage);
    }
}
