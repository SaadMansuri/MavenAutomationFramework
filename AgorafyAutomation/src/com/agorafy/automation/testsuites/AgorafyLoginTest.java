package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.testcases.LoginActionNegativeTestsLoginPageForm;
import com.agorafy.automation.testcases.SigninAction;

public class AgorafyLoginTest 
{
    @BeforeSuite
    public void Init() throws Exception
    {
        // TODO: Move this to some TestNg XML configuration file, so that we can set config file path
        // when running in headless mode.
        String globalConfigureationFileWithPath = "src/com/agorafy/automation/configuration/config.properties";
        AutomationFramework.initWithGlobalConfiguration(globalConfigureationFileWithPath);
    }

    @Test
  public void testSign() throws Exception
  {
      try
      {
         new SigninAction().Execute();
      }
      catch (Exception e)
      {
          AutomationLog.error(e.getMessage());
          // Again throwing the exception to fail the test completely in the TestNG results
          throw (e);
      }
  }

//  @Test
  public void testNegativeLoginScenarios() throws Exception
  {
      try
      {
          new LoginActionNegativeTestsLoginPageForm().Execute();
          //new LoginActionNegativeTestsHeaderForm().Execute();
      }
      catch (Exception e)
      {
          AutomationLog.error(e.getMessage());
          // Again throwing the exception to fail the test completely in the TestNG results
          throw (e);
      }
  }
}
