/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agorafy_pkg1;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.events.EventFiringWebDriver;
/**
 *
 * @author comp-53
 */
public class Login {
    
    private WebDriver d;
    private String baseUrl;
    private EventFiringWebDriver driver;
    
@Before
public void setUp() throws Exception
{
    d = new FirefoxDriver();
    driver = new EventFiringWebDriver(d);
    baseUrl = "http://www.agorafy.com/";
    
        
}

@Test
public void testLogin() throws Exception
{
    driver.get(baseUrl+"about/");
    
    //driver.findElement(By.xpath("//DIV[@id='mainHeader']/DIV[@id='mainNav']/UL/LI[1]/A")).click();
    driver.findElement(By.linkText(AllVariables.LOGIN_LINK)).click();
    driver.findElement(By.name("_username")).sendKeys("chandrani.bhagat@cuelogic.co.in");
    driver.findElement(By.name("_password")).sendKeys("cuelogic");
    //Assert.assertFalse("element not found", isElementPresent(By.linkText("Logout")));
    if(!(isElementPresent(By.linkText("Logout"))))
            System.out.println("failure1: Logout link not found\n");
    
    //driver.executeScript("alert('element not found')");
    
    Thread.sleep(3000);
    //driver.findElement(By.className("btn-blue")).click();
    //System.out.println("print this");
     driver.findElement(By.id("searchInput")).clear();
    driver.findElement(By.id("searchInput")).sendKeys("100");
    driver.findElement(By.id("searchFormButton")).click();
    //driver.quit();
    
    
}




private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
    
}




