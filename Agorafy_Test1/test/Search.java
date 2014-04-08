//package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import java.awt.Robot; //for pointing mouse at a particular location on screen
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class Search {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private Robot r;

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://preview.agorafy.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSearchSubscription() throws Exception {
    driver.get(baseUrl + "about/");
    
    //performing empty search
    driver.findElement(By.id("searchFormButton")).click();
    Assert.assertTrue("message not found", this.isElementPresent(By.xpath("//DIV[@class='Zebra_Tooltip']/DIV[1]")));
    
    //serach for random invalid numbers, not valid zip code
    driver.findElement(By.id("searchInput")).clear();
    driver.findElement(By.id("searchInput")).sendKeys("100");
    driver.findElement(By.id("searchFormButton")).click();
    if(!this.isElementPresent(By.xpath("//DIV[@id='main']/DIV[2]/DIV/UL")))
         System.out.println("error: correct zip code suggestions are not seen");
    Thread.sleep(3000);
    driver.findElement(By.id("searchInput")).clear();
    
    //zero baths zero beds criteria search
    driver.findElement(By.xpath("//DIV[@id='subHeader']/FORM[@id='searchForm']/DIV[@id='searchFormContainer']/DIV[@id='listingCategorySelect']/DIV/SPAN")).click();
    driver.findElement(By.xpath("//DIV[@id='subHeader']/FORM[@id='searchForm']/DIV[@id='searchFormContainer']/DIV[@id='listingCategorySelect']/UL/LI[2]/A/label")).click();
    driver.findElement(By.id("searchInput")).sendKeys("10001");
    driver.findElement(By.xpath("//DIV[@id='subHeader']/FORM[@id='searchForm']/DIV[@id='searchFormContainer']/A[@id='advancedSearch']")).click();
    driver.findElement(By.id("bedsInput")).sendKeys("0");
    driver.findElement(By.id("bathsInput")).sendKeys("0");
    driver.findElement(By.id("searchFormAdvancedButton")).click();
    if(!(driver.findElement(By.xpath("//DIV[@id='main']/DIV[2]/DIV[3]")).getText().contentEquals("No results found.")))
        System.out.println("error: no results found message is not displayed");
        //System.out.println(driver.findElement(By.xpath("//DIV[@id='main']/DIV[2]/DIV[3]")).getText());
     
   /* //test for 'Add to report' picushion for retail properties
    driver.findElement(By.xpath("//DIV[@id='subHeader']/FORM[@id='searchForm']/DIV[@id='searchFormContainer']/DIV[@id='listingCategorySelect']/UL/LI[2]/A/label")).click();
    driver.findElement(By.id("searchInput")).sendKeys("Retail"); 
    driver.findElement(By.id("advancedSearch")).click();
    driver.findElement(By.id("borough")).click();
    driver.findElement(By.xpath("//SELECT[@id='borough']/OPTION[1]")).click();
    driver.findElement(By.id("advancedSearch")).click();   
    driver.findElement(By.id("searchFormButton")).click();
    r = new Robot();
    r.mouseMove(595, 575);
    Thread.sleep(3000);
    */
    
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
