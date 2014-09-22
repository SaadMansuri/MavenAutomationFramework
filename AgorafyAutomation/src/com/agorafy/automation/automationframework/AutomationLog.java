package com.agorafy.automation.automationframework;

public class AutomationLog {

    public static void startTestCase(String sTestCaseName)
    {
        System.out.println("Begin Test case : " + sTestCaseName);
    }

    public static void endTestCase(String sTestCaseName)
    {
        System.out.println("End Test case : " + sTestCaseName);
    }

    public static void info(String message) 
    {
        System.out.println("Log info: " + message);
    }

    public static void warn(String message) 
    {
        System.out.println("Log info: " + message);
    }

    public static void error(String message) 
    {
        System.out.println("Log info: " + message);
    }

    public static void fatal(String message) 
    {
        System.out.println("Log info: " + message);
    }

    public static void debug(String message) 
    {
        System.out.println("Log info: " + message);
    }
}
