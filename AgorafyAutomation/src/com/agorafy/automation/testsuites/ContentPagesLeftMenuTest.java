package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.testcases.contentpages.ContentPagesLeftMenuAction;

public class ContentPagesLeftMenuTest {
    @BeforeSuite
    public void Init()
    {
        // TODO: Move this to some TestNg XML configuration file, so that we can set config file path
        // when running in headless mode.
        String globalConfigureationFileWithPath = "src/com/agorafy/automation/configuration/config.properties";
        AutomationFramework.initWithGlobalConfiguration(globalConfigureationFileWithPath);
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
