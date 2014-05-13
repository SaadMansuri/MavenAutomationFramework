/*
 * @author Chandrani
 * This class is for the script to login the system
 */

package agorafy.test.utils;

import agorafy.test.utils.VariableDeclarations;
import org.openqa.selenium.*;


public class Login {
    
public static boolean LoginFrontend(WebDriver driver, String baseUrl) throws Exception
{
    driver.get(baseUrl+"login");
    driver.findElement(By.xpath(VariableDeclarations.XPATH_USERNAME_FIELD)).clear();
    driver.findElement(By.xpath(VariableDeclarations.XPATH_USERNAME_FIELD)).sendKeys(VariableDeclarations.EMAIL_ID);
    driver.findElement(By.xpath(VariableDeclarations.XPATH_PASSWORD_FIELD)).clear();
    driver.findElement(By.xpath(VariableDeclarations.XPATH_PASSWORD_FIELD)).sendKeys(VariableDeclarations.PASSWORD);
    driver.findElement(By.className(VariableDeclarations.NAME_LOGIN_BUTTON)).click();
      
    return true;
}

    
}




