package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.Init;
import com.agorafy.automation.testcases.SignUpNegativeAction;

public class SignUpTest
{
    @BeforeSuite
    public void Init()
    {
        Init.globalConfiguration();
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
              throw (e);
         }
     }
}
