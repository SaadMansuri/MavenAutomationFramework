package com.agorafy.automation.automationframework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Pattern;

public class TestDataProvider 
{
    public static HashMap<String, HashMap<String, String>> readTestDataFromCSV(String testFilenameWithCSVExtension)
    {
        String testDataDir = Configuration.getConfigurationValueForProperty("test-data-directory");
        String testDataFilePath = testDataDir + testFilenameWithCSVExtension;

        HashMap<String, HashMap<String, String>> testData = new HashMap<String, HashMap<String,String>>();
        parseTestData(testDataFilePath, testData);

        return testData;
    }

    private static void parseTestData(String testDataFilePath, HashMap<String, HashMap<String, String>> testData)
    {
        final String KEY_DELIMITER = ",";
        final String RECORD_DELIMITER = ";";
        final String VALUE_DELIMITER = "=";
        
        BufferedReader fileReader = null;
        String line = "";
        //Create the file reader
        try {
            fileReader = new BufferedReader(new FileReader(testDataFilePath));
            while ((line = fileReader.readLine()) != null) 
            {
                //Get all keys available in line
                String[] keys = parseCSVLine(line, KEY_DELIMITER);
                if (keys.length > 0)
                {
                    HashMap<String,String> data = new HashMap<String, String>();
                    String[] records = parseCSVLine(keys[1], RECORD_DELIMITER);
                    for(String recordData : records)
                    {
                          String [] datavalues = parseCSVLine(recordData, VALUE_DELIMITER);
                          if (datavalues.length > 0)
                          {
                              //data.put(datavalues[0], datavalues[1]);
                              data.put(new String(datavalues[0]), new String(datavalues[1]));
                          }
                    }
                    testData.put(new String(keys[0]), data);
                }
            }
        }
        catch(FileNotFoundException fnfe)
        {
        	AutomationLog.info("Not able to read config file due to " + fnfe.toString() + " test data loading failed.");
        }
        catch (Exception e) 
        {
            AutomationLog.info("Not able to read config file due to " + e.toString() + " test data loading failed.");
        } 
        finally
        {
            try 
            {
                fileReader.close();
            }
            catch (IOException e) 
            {
                AutomationLog.info("Not able to close config file due to " + e.toString() + " test data might not have loaded correctly.");
            }
        }
    }

    public static String[] parseCSVLine(String line, String delimiter) {
        // Create a pattern to match breaks
        Pattern p =
            Pattern.compile(delimiter + "(?=([^\"]*\"[^\"]*\")*(?![^\"]*\"))");
        // Split input with the pattern
        String[] fields = p.split(line);
        for (int i = 0; i < fields.length; i++) {
            // Get rid of residual double quotes
            fields[i] = fields[i].replace("\"", "");
        }
        return fields;
    }

    /**
     * Unused. Kept for Testing. TODO: Remove this function after CSV parsing is stable.
     * @param testDataFilePath
     * @param testData
     */
    private static void parseTestDataBySplitting(String testDataFilePath, HashMap<String, HashMap<String, String>> testData)
    {
        BufferedReader fileReader = null;

        //TODO: if possible read the delimiters from config file.
        // Delimiter used in CSV file.
        final String KEY_DELIMITER = ",";
        final String RECORD_DELIMITER = ";";
        final String VALUE_DELIMITER = ":";
        try
        {
            String line = "";
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(testDataFilePath));

            //Read the file line by line
            while ((line = fileReader.readLine()) != null) 
            {
                //Get all keys available in line
                String[] keys = line.split(KEY_DELIMITER);
                if (keys.length > 0)
                {
                    HashMap<String,String> data = new HashMap<String, String>();
                    String[] records = keys[1].split(RECORD_DELIMITER);
                    for(String recordData : records)
                      {
                            String [] datavalues = recordData.split(VALUE_DELIMITER);
                            if (datavalues.length > 0)
                            {
                                //data.put(datavalues[0], datavalues[1]);
                                data.put(new String(datavalues[0]), new String(datavalues[1]));
                            }
                      }
                    testData.put(new String(keys[0]), data);
                }
            }
        } 
        catch (Exception e) 
        {
            AutomationLog.info("Not able to read config file due to " + e.toString() + " test data loading failed.");
        } 
        finally
        {
            try 
            {
                fileReader.close();
            }
            catch (IOException e) 
            {
                AutomationLog.info("Not able to close config file due to " + e.toString() + " test data might not have loaded correctly.");
            }
        }
    }
}
