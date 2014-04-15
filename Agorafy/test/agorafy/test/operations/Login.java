/*
 * @author Chandrani
 * This class is for the script to login the system
 */

package agorafy.test.operations;

import org.openqa.selenium.*;


public class Login {
    
public static boolean LoginFrontend(WebDriver driver, String baseUrl) throws Exception
{
    driver.get(baseUrl+"login");
    driver.findElement(By.xpath(VariableDeclarations.XPATH_USERNAME_FIELD)).clear();
    driver.findElement(By.xpath(VariableDeclarations.XPATH_USERNAME_FIELD)).sendKeys("chandrani.bhagat@cuelogic.co.in");
    driver.findElement(By.xpath(VariableDeclarations.XPATH_PASSWORD_FIELD)).clear();
    driver.findElement(By.xpath(VariableDeclarations.XPATH_PASSWORD_FIELD)).sendKeys("cuelogic77");
    driver.findElement(By.className(VariableDeclarations.NAME_LOGIN_BUTTON)).click();
      
    return true;
}

    
}




