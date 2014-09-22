package com.agorafy.automation.automationframework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration 
{
    private Properties properties;
    private static Configuration globalConfiguration = null;
    private static String DEFAULT_CONFIG_FILE_PATH = "config.properties";
    
    protected Configuration(String configFilePath){
        loadAllProperties(configFilePath);
    }
    
    private void loadAllProperties(String configFilePath) {
        properties = new Properties();
        try {
            String configFilePathToUse = (configFilePath != null) ? configFilePath : DEFAULT_CONFIG_FILE_PATH;
            properties.load(new FileInputStream(configFilePathToUse));
        } catch (IOException e) {
          //  throw new RuntimeException("Could not read the properties file");
        }
    }

    public void setGlobalConfigurationFile(String configFile)
    {
        reloadAllProperties(configFile);
    }
    
    private void reloadAllProperties(String configFile)
    {
        loadAllProperties(configFile);
    }

    public static Configuration globalConfiguration()
    {
        if (globalConfiguration == null)
        {
            globalConfiguration = new Configuration(DEFAULT_CONFIG_FILE_PATH);
        }
        return globalConfiguration;
    }
    
    public String readConfigurationProperty(String propertyName) 
    {
        String defaultValue = "";
        return properties.getProperty(propertyName, defaultValue);
    }
}
