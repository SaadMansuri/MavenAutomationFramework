/**
 *
 * @author : Chandrani
 * This class will check if the said alert is present 
 */
package agorafy.test.utils;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;


public class isAlertPresent {
    
    
    public static boolean isAlertPresent(WebDriver driver) {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
    
}
