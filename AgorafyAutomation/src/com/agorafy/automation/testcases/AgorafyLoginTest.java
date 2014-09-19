package com.agorafy.automation.testcases;

import org.testng.annotations.Test;

import com.agorafy.automation.appmodules.SigninAction;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.PageElement;


public class AgorafyLoginTest 
{
  @Test
  public void Main() throws Exception
  {
      try
      {
          new SigninAction().Execute();

          if(PageElement.bResult==true){
              // If the value of boolean variable is True, then your test is complete pass and do this
             AutomationLog.info("Test case Passed Verification");
             
          }else{
              // If the value of boolean variable is False, then your test is fail, and you like to report it accordingly
              // This is to throw exception in case of fail test, this exception will be caught by catch block below
              AutomationLog.info("Test Case Failed because of Verification");
          }
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
