/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agorafy_pkg1;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
//import org.openqa.selenium.By;
//import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import static agorafy_pkg1.AllVariables.*;

import jxl.*;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


/**
 *
 * @author sharp com
 */

public class AddListing {
    
    WebDriver driver;
    public String baseUrl, propertyPageUrl;
    FileOutputStream f;
    WritableWorkbook book;
    WritableSheet sheet;
    public int row = 2, col=4;
    
    
   /*Workbook wrk1 =  Workbook.getWorkbook(new File("D:\chandrani\Agorafy\Agorafy Basic Features.xls"));
    //Worksheet sheet=workbook.getActiveWorksheet();
    
    //define an Excel Work Book
  HSSFWorkbook workbook;
  //define an Excel Work sheet
  HSSFSheet sheet;
  //define a test result data object
  Map<String, Object[]> testresultdata;
  * */
    
   @BeforeClass
    public static void oneTimeSetUp() throws FileNotFoundException, IOException {
       
          
        // one-time initialization code   
    }
 
    @AfterClass
    public static void oneTimeTearDown() {
        // one-time cleanup code
         
    }
    
    @Before
    public void setUp() throws InterruptedException {
        
        
        
        driver = new FirefoxDriver();
        baseUrl = "http://preview.agorafy.com/";
        Thread.sleep(6000);
        
    }
    
    @After
    public void tearDown() {
        
        driver.quit();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testAddListing() throws InterruptedException{
        
        driver.manage().window().maximize();
        this.Login();
        this.test_case1();
        this.test_case2();
        this.test_case3();
        Thread.sleep(4000);
        this.test_case4();
        //this.test_case5();
        this.test_case9();
        this.test_case10();
        this.test_case11();
        test_case22();
    }
    
    public void Login()
    {
        driver.get(baseUrl + "login");
        driver.findElement(By.xpath(XPATH_USERNAME_FIELD)).clear();
        driver.findElement(By.xpath(AllVariables.XPATH_USERNAME_FIELD)).sendKeys("chandrani.bhagat@cuelogic.co.in");
        driver.findElement(By.xpath(AllVariables.XPATH_PASSWORD_FIELD)).clear();
        driver.findElement(By.xpath(AllVariables.XPATH_PASSWORD_FIELD)).sendKeys("cuelogic77");
        driver.findElement(By.className(AllVariables.NAME_LOGIN_BUTTON)).click();

        driver.get(baseUrl + "manage/admin/property/16921");
    }
    public void test_case1() //creating new listing, check for pop-up
    {
        propertyPageUrl = driver.getCurrentUrl();
        driver.findElement(By.id(AllVariables.ADMIN_ID_ADDLISTING_BUTTON)).click();         //test case1 
        if(!(this.isElementPresent(By.xpath(AllVariables.ADMIN_ADDLISTING_ALERT1))))
            System.out.println("ERROR: dialog box for selecting type of listing not seen");  
        
    }
    public void test_case2()    //creating new listing, check for pop-up
    {
        driver.findElement(By.id(AllVariables.ADMIN_ADDLISTING_ALERT1_RESIDENTIAL_BUTTON_ID)).click();
        if(!(this.isElementPresent(By.xpath(AllVariables.ADMIN_ADDLISTING_ALERT1))))            //test case 2
            System.out.println("ERROR: dialog box for selecting type of listing not seen");    
        if(!(this.isElementPresent(By.id(AllVariables.ADMIN_ADDLISTING_ALERT2_SALE_BUTTON_ID)))) 
            System.out.println("ERROR: dialog box for selecting type of listing not seen");  
        
    }
    public void test_case3()    //creating new listing, check for cancel and back buttons
    {
        if(!(this.isElementPresent(By.xpath(AllVariables.ADMIN_ADDLISTING_ALERT12_BACK_XPATH)))) //test 3
            System.out.println("ERROR: back button on pop up not seen");  
        if(!(this.isElementPresent(By.xpath(AllVariables.ADMIN_ADDLISTING_ALERT12_CANCEL_XPATH)))) 
            System.out.println("ERROR: cancel button on pop up not seen");  
        
    }
    
    public void test_case4()    //check if manage listing page is seen after add listing operation
    {
       driver.findElement(By.id(AllVariables.ADMIN_ADDLISTING_ALERT2_SALE_BUTTON_ID)).click();
       if(!driver.getCurrentUrl().contains("manage/admin/listing/add/residential"))
            System.out.println("ERROR: not the expected page");       
       
    }
    
    public void test_case5()    //after save listing should get added, appearance of buttons changes
    {
        String DisplayName = driver.findElement(By.id(AllVariables.ADMIN_ID_DISPLAYNAME_LISTING)).getText();
        driver.findElement(By.id(AllVariables.ADMIN_ID_NEWLISTING_SAVE_BUTTON)).click();
        if(!this.isElementPresent(By.id(AllVariables.ADMIN_ID_CLONE_BUTTON)))
            System.out.println("ERROR: Listing did not get saved");        
    }
    
    public void test_case9()    //incomplete listing should dhow Not Published
    {
       /* String notPublished = driver.findElement(By.id("published")).getAttribute(disabled);
        System.out.println(notPublished);
        if(!notPublished.contentEquals("disabled"))
            System.out.println("ERROR: status id not 'Not Published'");*/
        
        if(!(driver.findElement(By.id("formContainer")).getText().contains("Not Published")))
            System.out.println("ERROR: status id is not 'Not Published'");
        
    }
    
    public void test_case10()   //check if new listing is "On market" by default
    {
        if(!(driver.findElement(By.id("formContainer")).getText().contains("On the Market")))
            System.out.println("ERROR: status of listing is not 'On the Market'");
    }
    
    public void test_case11()
    {
       if(!driver.findElement(By.id("verifyToggle")).getAttribute("aria-disabled").contentEquals("true"))
          //aria-disabled is TRUE if verify button is disabled
          System.out.println("ERROR: verify button is not disabled");
    }
    
    public void test_case22()
    {
        driver.get("http://preview.agorafy.com/manage/admin/listing/470");
        driver.findElement(By.className("dropzoneThumbnail ui-draggable")).click();
        if(!(this.isElementPresent(By.className("ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable"))))
            System.out.println("ERROR: Media description pop-up not seen");
        
        
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
  
 
}


