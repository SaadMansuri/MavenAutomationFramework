package com.agorafy.automation.automationframework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration 
{
    Properties properties;
    private static String DEFAULT_CONFIG_FILE_PATH = "config.properties";
    
    public Configuration(String configFilePath){
        loadAllProperties(configFilePath);
    }
    
    private void loadAllProperties(String configFilePath) {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(configFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Could not read the properties file");
        }
    }

    public String readItem(String propertyName) {
        return properties.getProperty(propertyName);
    }
}
