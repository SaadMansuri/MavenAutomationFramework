package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.agorafy.automation.automationframework.Init;
import com.agorafy.automation.testcases.showings.AdminShowingsAction;
import com.agorafy.automation.testcases.showings.FrontEndShowingsAction;

public class ShowingsTest 
{
    @BeforeSuite
    public void Init()
    {
        Init.globalConfiguration();
    }

    @Test
    public void AdminShowingsTestCases() throws Exception
    {
        try
        {
            new AdminShowingsAction().Execute();
        }
        catch (Exception e)
        {
            throw (e);
        }
    }

    @Test
    public void FrontEndShowingsTestCases() throws Exception
    {
        try
        {
            new FrontEndShowingsAction().Execute();
        }
        catch (Exception e)
        {
            throw (e);
        }
    }
}
