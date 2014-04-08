/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author comp-53
 */

import junit.framework.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.WebDriver;
import java.net.URL;

public class Seleniumdriver1 {
    
    public static void main(String[] args)
    {
        WebDriver chrome = new ChromeDriver();
        chrome.get("www.agorafy.com");
        Assert.assertEquals("Commercial & residential listings in one place.", "Commercial & residential listings in one place.");
        chrome.quit();
        try{
            URL url = new URL("www.agorafy.com/property/826056/9-West-31-Street-Garment-District-New-York");
            String query = url.getQuery();
        }
        catch(Exception e){}
        
        
        
    }
    
}
