package com.agorafy.automation.automationframework;

import java.util.HashMap;

import com.agorafy.automation.pageobjects.Page;

public class AutomationTestCase 
{
    protected HashMap<String, HashMap<String, String>> testCaseData;

    private String executingTestCaseName = null;
    private String executingTestCaseFileName = null;

    public AutomationTestCase() 
    {
        this.executingTestCaseName = this.getClass().getSimpleName();
        this.executingTestCaseFileName = executingTestCaseName;
    }

    protected AutomationTestCase(String executingTestCaseName) 
    {
        this.executingTestCaseName = this.getClass().getSimpleName();
        this.executingTestCaseFileName = executingTestCaseName;
    }

    public void setup() 
    {
        AutomationLog.startTestCase(executingTestCaseName);
        String browserToUse = Configuration.getConfigurationValueForProperty("browser");
        new Page(AppDriver.getDriver(browserToUse));
       // populate test case data from csv
        testCaseData = TestDataProvider.getTestData(executingTestCaseFileName);
    }

    public static Credentials userCredentials()
    {
        String email = Configuration.getConfigurationValueForProperty("email");
        String password = Configuration.getConfigurationValueForProperty("password");
        Credentials credential =new Credentials(email, password);
        return credential;
    }

    public void cleanup() 
    {
        AutomationLog.endTestCase(executingTestCaseName);

        if (testCaseData != null)
            testCaseData.clear();

        AppDriver.clearBrowserContext(Page.driver);
    }

    public void testcasePassed(String customMessage) 
    {
        AutomationLog.info(executingTestCaseName + " " + customMessage);
    }

    public void testcaseFailed(String customMessage) 
    {
        AutomationLog.info(executingTestCaseName + " " + customMessage);
    }
}
