package com.agorafy.automation.automationframework;

public class Init {

    public static void globalConfiguration()
    {
        // TODO: Move this to some TestNg XML configuration file, so that we can set config file path
        // when running in headless mode.
       final String globalConfigurationFilePath = "src/com/agorafy/automation/configuration/config.properties";
       AutomationFramework.initWithGlobalConfiguration(globalConfigurationFilePath);
    }
}
