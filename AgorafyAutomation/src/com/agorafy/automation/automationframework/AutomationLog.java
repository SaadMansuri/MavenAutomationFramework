package com.agorafy.automation.automationframework;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class AutomationLog 
{
    private Logger logger = Logger.getLogger(AutomationLog.class.getSimpleName());
    private static AutomationLog automationLogInstance = null;

    private AutomationLog()
    {
        logger.setUseParentHandlers(false);
        LogFormatter formatter = new LogFormatter();
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(formatter);
 
        logger.addHandler(handler);
    }

    private static AutomationLog getAutomationLog()
    {
        if (automationLogInstance == null)
        {
            automationLogInstance = new AutomationLog();
        }
        return automationLogInstance;
    }
    
    private static Logger getLogger()
    {
        return AutomationLog.getAutomationLog().logger;
    }

    public static void startTestCase(String sTestCaseName)
    {
        getLogger().info("Begin Test case : " + sTestCaseName);
    }

    public static void endTestCase(String sTestCaseName)
    {
        getLogger().info("End Test case : " + sTestCaseName);
    }

    public static void info(String message) 
    {
        getLogger().info(message);
    }

    public static void warn(String message) 
    {
        getLogger().warning(message);
    }

    public static void error(String message) 
    {
        getLogger().severe(message);
    }

    public static void fatal(String message) 
    {
        getLogger().severe(message);
    }

    class LogFormatter extends Formatter
    {
        // TODO: Get the format from global config file.
        // Create a DateFormat to format the logger timestamp.
        private final DateFormat df = new SimpleDateFormat(Configuration.getConfigurationValueForProperty("dateformat-logging"));

        // TODO: Get this from global config.
        private final String applicationName = Configuration.getConfigurationValueForProperty("applicationName");
     
        public String format(LogRecord record) {
            StringBuilder builder = new StringBuilder(1000);
            builder.append(df.format(new Date(record.getMillis()))).append(" - ");
            builder.append("[").append(applicationName).append(" ");
            builder.append(record.getSourceMethodName()).append("] - ");
            builder.append("[").append(record.getLevel()).append("] - ");
            builder.append(formatMessage(record));
            builder.append("\n");
            return builder.toString();
        }

        public String getHead(Handler h) {
            return super.getHead(h);
        }

        public String getTail(Handler h) {
            return super.getTail(h);
        }
    }

}
