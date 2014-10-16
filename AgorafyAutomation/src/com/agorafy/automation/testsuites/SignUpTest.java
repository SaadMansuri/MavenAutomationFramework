package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.testcases.SignUpNegativeAction;

public class SignUpTest
{
     @BeforeSuite
     public void Init()
     {
          String globalConfigureationFileWithPath = "src/com/agorafy/automation/configuration/config.properties";
          AutomationFramework.initWithGlobalConfiguration(globalConfigureationFileWithPath);
     }

     @Test
     public void testsignUpNegativeTestCases() throws Exception
     {
         try
         {
              new SignUpNegativeAction().Execute();
         }
         catch (Exception e)
         {
              AutomationLog.error(e.getMessage());
              throw (e);
         }
     }
}
