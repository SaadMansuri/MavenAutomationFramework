package com.agorafy.automation.testcases;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.appmodules.SigninAction;
import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.automationframework.AutomationLog;

public class AgorafyLoginTest 
{
    @BeforeSuite
    public void Init()
    {
        // TODO: Move this to some TestNg XML configuration file, so that we can set config file path
        // when running in headless mode.
        String globalConfigureationFileWithPath = "src/com/agorafy/automation/configuration/config.properties";
        AutomationFramework.initWithGlobalConfiguration(globalConfigureationFileWithPath);
    }

  @Test
  public void Main() throws Exception
  {
      try
      {
          new SigninAction().Execute();
      }
      catch (Exception e)
      {
          //Utils.takeScreenshot(driver, sTestCaseName);
          // This will print the error log message
          AutomationLog.error(e.getMessage());
          // Again throwing the exception to fail the test completely in the TestNG results
          throw (e);
      }
  }

}
