
package agorafy.test.utils;

/**
 * @author : Chandrani
 * This class logs out the user
 * 
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Logout {
    
    //logout from admin end 
    public static void LogoutAdmin(WebDriver driver)
    {
        driver.findElement(By.className("btn-icon-logout")).click();
        
    }
    
    //logout from front end
    public static void LogoutFrontend(WebDriver driver)
    {
        driver.findElement(By.className("dropdown-open")).click();
        driver.findElement(By.linkText("Logout")).click();
        
    }
}
