package com.agorafy.automation.utilities;

import java.util.HashMap;
import java.util.HashSet;

import org.openqa.selenium.WebDriver;


public class HandlingWindows 
{
    public static HashMap<Integer, String> allWindowhandles(WebDriver driver) 
    {
        HashMap<Integer, String> allWindowHandles = new HashMap<>();
        HashSet<String> allWindowHandlesHashSet = (HashSet<String>) driver.getWindowHandles();
        Integer windowNo = 1;
        for(String singleWindowHandle : allWindowHandlesHashSet)
        {
            allWindowHandles.put(windowNo, singleWindowHandle);
            windowNo++;
        }
        return allWindowHandles;
    }

    public static void switchToWindow(WebDriver driver, Integer windowNoToSwitch)
    {
        HashMap<Integer, String> allWindowHandles = allWindowhandles(driver);
        driver.switchTo().window(allWindowHandles.get(windowNoToSwitch));
    }

}
