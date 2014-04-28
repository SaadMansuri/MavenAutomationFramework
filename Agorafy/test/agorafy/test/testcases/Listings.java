
/**
 *
 * @author : Chandrani
 * This class is designed for testing Add listing functionality from the admin end 
 * 
 */

package agorafy.test.testcases;


import agorafy.test.utils.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import agorafy.test.testcases.VariableDeclarations.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import agorafy.test.operations.Login;
import agorafy.test.operations.Logout;
import org.openqa.selenium.support.ui.Select;


public class Listings {
    
    WebDriver driver;
    public String baseUrl, propertyPageUrl;
   
       
    @Before
    public void setUp() throws InterruptedException {
        try {
            driver = BrowserInstance.BrowserInstance("firefox");  //chrome or firefox or ie
            baseUrl = BaseUrl.getBaseUrl();
            Thread.sleep(6000);
            
            driver.manage().window().maximize();
            
            Login.LoginFrontend(driver, baseUrl); 
        } catch (Exception ex) {
            Logger.getLogger(Listings.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        driver.get(baseUrl + "manage/admin/property/16921");
    }
    
    @After
    public void tearDown() {
        
        driver.get(propertyPageUrl);
        driver.findElement(By.xpath(VariableDeclarations.ADMIN_LOGOUT_ICON_XPATH)).click();
        driver.findElement(By.name("deleteButton")).click();
        boolean isAlertFound = isAlertPresent.isAlertPresent(driver);
        System.out.println(isAlertFound);
        driver.switchTo().alert().accept();
        Logout.LogoutAdmin(driver);
        driver.quit();
    }
        
    @Test
    public void testAddListing() throws InterruptedException{
        
        this.test_addListingTypePopup();
        this.test_listingSaleTypePopup();
        this.test_cancelAndBackOnPopup();
        Thread.sleep(4000);
        this.test_urlChangeToManageListingUrl();
        this.test_saveEmptyListing();
        this.test_emptyListingStatusNotPublished();
        this.test_emptyNewListingIsOnMarket();
        this.test_verifyButtonDisabledForIncompleteListing();
        test_addResidentialListing();
       // test_mediaDecriptionPopup();
        
    }
    
   
    public void test_addListingTypePopup() //creating new listing, check for pop-up
    {
        propertyPageUrl = driver.getCurrentUrl();
        driver.findElement(By.id(VariableDeclarations.ADMIN_ID_ADDLISTING_BUTTON)).click();         //test case1 
        if(!(isElementPresent.isElementPresent(By.xpath(VariableDeclarations.ADMIN_ADDLISTING_ALERT1) , driver)))
            System.out.println("ERROR: dialog box for selecting type of listing not seen");  
        
    }
    public void test_listingSaleTypePopup()    //creating new listing, check for pop-up
    {
        driver.findElement(By.id(VariableDeclarations.ADMIN_ADDLISTING_ALERT1_RESIDENTIAL_BUTTON_ID)).click();
        if(!(isElementPresent.isElementPresent(By.xpath(VariableDeclarations.ADMIN_ADDLISTING_ALERT1) , driver)))            //test case 2
            System.out.println("ERROR: dialog box for selecting type of listing not seen");    
        if(!(isElementPresent.isElementPresent(By.id(VariableDeclarations.ADMIN_ADDLISTING_ALERT2_SALE_BUTTON_ID), driver))) 
            System.out.println("ERROR: dialog box for selecting type of listing not seen");  
        
    }
    public void test_cancelAndBackOnPopup()    //creating new listing, check for cancel and back buttons
    {
        if(!(isElementPresent.isElementPresent(By.xpath(VariableDeclarations.ADMIN_ADDLISTING_ALERT12_BACK_XPATH), driver))) //test 3
            System.out.println("ERROR: back button on pop up not seen");  
        if(!(isElementPresent.isElementPresent(By.xpath(VariableDeclarations.ADMIN_ADDLISTING_ALERT12_CANCEL_XPATH), driver))) 
            System.out.println("ERROR: cancel button on pop up not seen");  
        
    }
    
    public void test_urlChangeToManageListingUrl()    //check if manage listing page is seen after add listing operation
    {
       driver.findElement(By.id(VariableDeclarations.ADMIN_ADDLISTING_ALERT2_SALE_BUTTON_ID)).click();
       if(!driver.getCurrentUrl().contains("manage/admin/listing/add/residential"))
            System.out.println("ERROR: not the expected page");       
       
    }
    
    public void test_saveEmptyListing()    //after save, listing should get added, appearance of buttons changes
    {
        String DisplayName = driver.findElement(By.id(VariableDeclarations.ADMIN_ID_DISPLAYNAME_LISTING)).getText();
        driver.findElement(By.id(VariableDeclarations.ADMIN_ID_NEWLISTING_SAVE_BUTTON)).click();
        if(!isElementPresent.isElementPresent(By.id(VariableDeclarations.ADMIN_ID_CLONE_BUTTON), driver))
            System.out.println("ERROR: Listing did not get saved");        
    }
    
    public void test_emptyListingStatusNotPublished()    //incomplete listing should show Not Published
    {
               
        if(!(driver.findElement(By.id("formContainer")).getText().contains("Not Published")))
            System.out.println("ERROR: status id is not 'Not Published'");
        
    }
    
    public void test_emptyNewListingIsOnMarket()   //check if new listing is "On market" by default
    {
        if(!(driver.findElement(By.id("formContainer")).getText().contains("On the Market")))
            System.out.println("ERROR: status of listing is not 'On the Market'");
    }
    
    public void test_verifyButtonDisabledForIncompleteListing() //check if verify button is disabled for incomplete listing
    {
       if(!driver.findElement(By.id("verifyToggle")).getAttribute("aria-disabled").contentEquals("true"))
          //aria-disabled is TRUE if verify button is disabled
          System.out.println("ERROR: verify button is not disabled");
    }
      
    public void test_addResidentialListing() throws InterruptedException
    {
        
        driver.findElement(By.id(VariableDeclarations.ADMIN_ID_DISPLAYNAME_LISTING)).sendKeys("Residential R - Sale");
        
        Select dropdownForSpaceType = new Select(driver.findElement(By.id("spaceType")));   //wrapping the web element in select object
        dropdownForSpaceType.selectByVisibleText("Unit");      
        
        driver.findElement(By.id(VariableDeclarations.ADMIN_RESIDENTIAL_LISTING_SPACE_ID)).clear();
        driver.findElement(By.id(VariableDeclarations.ADMIN_RESIDENTIAL_LISTING_SPACE_ID)).sendKeys("Apt #1");
        Thread.sleep(3000);
        driver.findElement(By.id(VariableDeclarations.ADMIN_RESIDENTIAL_NUMBEROFBEDS_ID)).clear();
        driver.findElement(By.id(VariableDeclarations.ADMIN_RESIDENTIAL_NUMBEROFBEDS_ID)).sendKeys("2");
        Thread.sleep(3000);
        driver.findElement(By.id(VariableDeclarations.ADMIN_RESIDENTIAL_NUMBEROFBATHS_ID)).clear();
        driver.findElement(By.id(VariableDeclarations.ADMIN_RESIDENTIAL_NUMBEROFBATHS_ID)).sendKeys("2");
        Thread.sleep(3000);
        driver.findElement(By.name("form[unitPrice]")).clear();
        driver.findElement(By.name("form[unitPrice]")).sendKeys("109,090");
        
        driver.findElement(By.name("form[unitSquareFootage][]")).clear();
        driver.findElement(By.name("form[unitSquareFootage][]")).sendKeys("800");
        
        driver.findElement(By.name("form[maintenance]")).clear();
        driver.findElement(By.name("form[maintenance]")).sendKeys("250");
        Thread.sleep(3000);
        driver.findElement(By.id("addContactLink")).click();
        Thread.sleep(3000);
        System.out.println(isElementPresent.isElementPresent(By.id("contactNewContainer"), driver));
        System.out.println(driver.findElement(By.id("contactNewContainer")));
        
        //for autocomplete this is how it is to be handled
        WebElement popupContactSearch = driver.switchTo().activeElement().findElement(By.id("contactSearch"));
        popupContactSearch.sendKeys("Pranoop R", Keys.PAUSE);
        Thread.sleep(5000);
        popupContactSearch.sendKeys( Keys.DOWN);
        popupContactSearch.sendKeys( Keys.TAB);
        Thread.sleep(5000);
        driver.findElement(By.id("addContactButton")).click();
        Thread.sleep(5000);
        
        if(driver.findElement(By.id("dropzone")).getAttribute("class").equalsIgnoreCase("redborder"))
        {
            System.out.println("Message: Incomplete residential form");
            if(!driver.findElement(By.id("publishedDiv")).getText().equalsIgnoreCase("not published"))
                System.out.println("ERROR: Form is incomplete but Not Published text is missing");
                
        }
                              
        
        driver.findElement(By.id("save")).click();
    }
    
    public void test_mediaDecriptionPopup()
    {
        driver.get("http://preview.agorafy.com/manage/admin/listing/470");
        driver.findElement(By.className("dropzoneThumbnail ui-draggable")).click();
        if(!(isElementPresent.isElementPresent(By.className("ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable"), driver)))
            System.out.println("ERROR: Media description pop-up not seen");
        
        
    }
    
  
 
}


