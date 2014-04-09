/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agorafy_pkg1;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author comp-53
 */
public class Subscriptions {
    private WebDriver driver;
  private String baseUrl;
    
    @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://preview.agorafy.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

    
    @Test
    public void testSubscriptions() throws InterruptedException{
    driver.get(baseUrl+"about");
    driver.findElement(By.id("searchInput")).clear();
    driver.findElement(By.id("searchInput")).sendKeys("10001");
    driver.findElement(By.id("searchFormButton")).click();
    assertTrue(isElementPresent(By.linkText("Subscribe to this search")));
    driver.findElement(By.className("subscribeCallout")).click();
    Thread.sleep(3000);
   
    driver.findElement(By.xpath("//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']/div[@id='upsellPopup']/form/ol/li[1]/input[@name='_username']")).sendKeys("chandrani.bhagat@cuelogic.co.in");
    driver.findElement(By.xpath("//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']/div[@id='upsellPopup']/form/ol/li[2]/input[@name='_password']")).sendKeys("cuelogic77");
    driver.findElement(By.xpath("//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']/div[@id='upsellPopup']/form/ol/li[3]/input[@class='btn-blue']")).click();

    driver.findElement(By.id("subscriptions_dropBox")).click(); //click on the subscriptions link below header
    assertTrue(isElementPresent(By.linkText("Subscribe")));  //is the subscribe button present on the dropbox
    assertTrue(isElementPresent(By.id("subscriptionsLabel")));  //is the subscribe text present in the text box
    String strTextinDropbox = driver.findElement(By.id("subscriptionsLabel")).getText(); //store the text in the text box
    try {
      assertTrue(driver.findElement(By.cssSelector("h2")).getText().equals(strTextinDropbox));
    } catch (Error e) {
      //verificationErrors.append(e.toString());
    }
    //driver.findElement(By.linkText("Subscribe to this search")).click();
    assertTrue(isElementPresent(By.linkText("Subscribe to this search")));
    //driver.findElement(By.linkText("Subscribe to this search")).click();
    driver.findElement(By.linkText("Subscribe")).click();
    assertFalse(isElementPresent(By.linkText("Subscribe to this search")));
    // ERROR: Caught exception [ERROR: Unsupported command [focus | css=#subscriptionsContainer > blockquote | ]]
    driver.findElement(By.linkText("View All Subscriptions")).click();
    String strCurrentUrl1 = driver.getCurrentUrl();
    assertEquals("http://preview.agorafy.com/manage/subscriptions/", driver.getCurrentUrl());
    driver.findElement(By.cssSelector("li.subscriptionSearch65c1afc0984249378ea7816a045d3d2c > a.subscriptionsRemoveLink")).click();
    driver.get("http://preview.agorafy.com/about/");
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
