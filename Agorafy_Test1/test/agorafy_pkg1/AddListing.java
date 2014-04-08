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
    public String baseUrl;
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
        
        this.Login();
        this.test_case1();
        this.test_case2();
        this.test_case3();
        Thread.sleep(4000);
        this.test_case4();
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
    public void test_case1() 
    {
        driver.findElement(By.id(AllVariables.ADMIN_ID_ADDLISTING_BUTTON)).click();         //test case1 
        if(!(this.isElementPresent(By.xpath(AllVariables.ADMIN_ADDLISTING_ALERT1))))
            System.out.println("ERROR: dialog box for selecting type of listing not seen");  
        
    }
    public void test_case2()
    {
        driver.findElement(By.id(AllVariables.ADMIN_ADDLISTING_ALERT1_RESIDENTIAL_BUTTON_ID)).click();
        if(!(this.isElementPresent(By.xpath(AllVariables.ADMIN_ADDLISTING_ALERT1))))            //test case 2
            System.out.println("ERROR: dialog box for selecting type of listing not seen");    
        if(!(this.isElementPresent(By.id(AllVariables.ADMIN_ADDLISTING_ALERT2_SALE_BUTTON_ID)))) 
            System.out.println("ERROR: dialog box for selecting type of listing not seen");  
        
    }
    public void test_case3()
    {
        if(!(this.isElementPresent(By.xpath(AllVariables.ADMIN_ADDLISTING_ALERT12_BACK_XPATH)))) //test 3
            System.out.println("ERROR: back button on pop up not seen");  
        if(!(this.isElementPresent(By.xpath(AllVariables.ADMIN_ADDLISTING_ALERT12_CANCEL_XPATH)))) 
            System.out.println("ERROR: cancel button on pop up not seen");  
        
    }
    
    public void test_case4() 
    {
       driver.findElement(By.id(AllVariables.ADMIN_ADDLISTING_ALERT2_SALE_BUTTON_ID)).click();
       if(!driver.getCurrentUrl().contains("manage/admin/listing/add/residential"))
            System.out.println("ERROR: not the expected page");       
       
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
  
  public void write(String t,int row,int col) throws WriteException, IOException {
  
      try
      {
       f = new FileOutputStream("D:\\chandrani\\Agorafy\\results.xls");    //refer http://seleniumbeginnersguide.blogspot.in/2013_02_01_archive.html
       book = Workbook.createWorkbook(f);
       sheet = book.createSheet("output", 0);
        
     Label l = new Label(row,col,t);
     sheet.addCell(l);
     book.write();
     book.close();
   }
  catch (Exception e)
  {
   e.printStackTrace();
  } 
 
 }
}


