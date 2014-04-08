/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.thoughtworks.selenium.*;

/**
 *
 * @author comp-53
 */
//package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewEmptyJUnitTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.agorafy.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testExamplejunit() throws Exception {
    driver.get("http://www.agorafy.com/search/results/residential/826056/?listingIds=[%227994%22,%228001%22,%229230%22,%229220%22,%229011%22,%228894%22,%228633%22]&searchParams={%22listingType%22:%22residential%22,%22neighborhoodId%22:%22%22,%22street%22:%22%22,%22propertyType%22:%22%22,%22borough%22:%22manhattan%22,%22listingCategory%22:%22residential%22,%22zipcode%22:%2210001%22,%22sort%22:%22dateD%22,%22searchTerm%22:%22Residential%20in%2010001%22,%22offeringType%22:%22%22,%22price%22:%22%22,%22priceRange%22:%22%22,%22priceUnits%22:%22%22,%22size%22:%22%22,%22sizeRange%22:%22%22,%22numBeds%22:%22%22,%22bedRange%22:%22%22,%22numBaths%22:%22%22,%22bathRange%22:%22%22}");
    assertEquals("7 matches at this property", driver.findElement(By.cssSelector("p")).getText());
    assertTrue(isElementPresent(By.xpath("//div[@id='details']/blockquote/table/thead/tr/th[1]")));
    assertTrue(isElementPresent(By.xpath("//div[@id='details']/blockquote/table/thead/tr/th[2]")));
    assertTrue(isElementPresent(By.xpath("//div[@id='details']/blockquote/table/thead/tr/th[3]")));
    assertTrue(isElementPresent(By.xpath("//div[@id='details']/blockquote/table/thead/tr/th[4]")));
    assertTrue(isElementPresent(By.xpath("//div[@id='details']/blockquote/table/thead/tr/th[5]")));
    assertTrue(isElementPresent(By.xpath("//div[@id='details']/blockquote/table/thead/tr/th[6]")));
    assertTrue(isElementPresent(By.xpath("//div[@id='details']/blockquote/table/thead/tr/th[7]")));
    assertTrue(isElementPresent(By.cssSelector("img[alt=\"Interior view\"]")));
    assertTrue(isElementPresent(By.cssSelector("div.right-column.property-info")));
    assertTrue(isElementPresent(By.cssSelector("div.right-column.property-info > h2")));
    assertTrue(isElementPresent(By.cssSelector("div.left-column > ul")));
    assertTrue(isElementPresent(By.linkText("See full property details")));
    assertTrue(isElementPresent(By.id("add-info")));
    assertTrue(isElementPresent(By.cssSelector("a.prev.fancybox-prev")));
    assertTrue(isElementPresent(By.cssSelector("a.next.fancybox-next")));
    driver.findElement(By.linkText("See full property details")).click();
    Thread.sleep(4000);
    //assertTrue(isElementPresent(By.linkText("Details")));
    assertTrue(isElementPresent(By.linkText("Tenants")));
    assertTrue(isElementPresent(By.linkText("News")));
    assertTrue(isElementPresent(By.id("property-box")));
    assertTrue(isElementPresent(By.id("printProperty")));
    assertTrue(isElementPresent(By.cssSelector("div.right-column.property-info")));
    assertTrue(isElementPresent(By.id("owner-box")));
    assertTrue(isElementPresent(By.cssSelector("#availableListings > h2")));
    assertTrue(isElementPresent(By.id("propertyDetails")));
    // this is for miscellaneous block
    assertTrue(isElementPresent(By.xpath("//div[@id='details']/blockquote[3]")));
    // for neighborhood photos
    assertTrue(isElementPresent(By.id("panoramioPhotos")));
    // location overview
    assertTrue(isElementPresent(By.cssSelector("div.col")));
    // building and unit details
    assertTrue(isElementPresent(By.xpath("//blockquote[@id='propertyDetails']/div/div[2]")));
    // zoning and floor area ratio
    assertTrue(isElementPresent(By.xpath("//blockquote[@id='propertyDetails']/div[2]/div")));
    // financial details
    assertTrue(isElementPresent(By.xpath("//blockquote[@id='propertyDetails']/div[2]/div[2]")));
    // check available listings
    assertTrue(isElementPresent(By.id("availableListings")));
    assertTrue(isElementPresent(By.xpath("//BLOCKQUOTE[@id=\"availableListings\"]/TABLE/TBODY/TR[4]/TD[1]/A")));
    // listing detail page
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
