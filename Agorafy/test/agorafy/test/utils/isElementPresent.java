/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agorafy.test.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author comp-53
 */
public class isElementPresent {
    
    //static WebDriver driver;
    public static boolean isElementPresent(By by , WebDriver driver) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  
    
}
