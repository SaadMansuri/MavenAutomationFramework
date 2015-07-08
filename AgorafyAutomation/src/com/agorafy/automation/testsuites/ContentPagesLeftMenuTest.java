package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.automationframework.Init;
import com.agorafy.automation.testcases.contentpages.ContentPagesLeftMenuAction;

public class ContentPagesLeftMenuTest {
    @BeforeSuite
    public void Init()
    {
        Init.globalConfiguration();
    }

    @Test
    public void testContentPagesLeftMenu() throws Exception
    {
        try
        {
            new ContentPagesLeftMenuAction().Execute();
        }
        catch (Exception e)
        {
            throw(e);
        }
    }
}
