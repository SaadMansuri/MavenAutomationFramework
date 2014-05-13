
/**
 *
 * @author : Chandrani
 * This class is designed for testing Add listing functionality from the admin end
 * All the functions are test cases or combination of test cases related to functionalities at the admin end
 * on Add Listing page
 * 
 */

package agorafy.test.testcases.listings;


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
import agorafy.test.utils.Login;
import agorafy.test.utils.Logout;
import agorafy.test.testcases.listings.*;
import java.util.List;
import org.openqa.selenium.support.ui.Select;


public class ListingOperations {
    
    public static String propertyPageUrl;
    private static WebElement ContactsList, FeaturesList;
    
    
   
    public void test_addListingTypePopup(WebDriver driver) //creating new listing, check for pop-up
    {
        propertyPageUrl = driver.getCurrentUrl();
        driver.findElement(By.id(VariableDeclarations.ADMIN_ID_ADDLISTING_BUTTON)).click();         //test case1 
        if(!(isElementPresent.isElementPresent(By.xpath(VariableDeclarations.ADMIN_ADDLISTING_ALERT1) , driver)))
            System.out.println("ERROR: dialog box for selecting type of listing not seen");  
        
    }
    public void test_listingSaleTypePopup(WebDriver driver)    //creating new listing, check for pop-up
    {
        driver.findElement(By.id(VariableDeclarations.ADMIN_ADDLISTING_ALERT1_RESIDENTIAL_BUTTON_ID)).click();
        if(!(isElementPresent.isElementPresent(By.xpath(VariableDeclarations.ADMIN_ADDLISTING_ALERT1) , driver)))            //test case 2
            System.out.println("ERROR: dialog box for selecting type of listing not seen");    
        if(!(isElementPresent.isElementPresent(By.id(VariableDeclarations.ADMIN_ADDLISTING_ALERT2_SALE_BUTTON_ID), driver))) 
            System.out.println("ERROR: dialog box for selecting type of listing not seen");  
        
    }
    public void test_cancelAndBackOnPopup(WebDriver driver)    //creating new listing, check for cancel and back buttons
    {
        if(!(isElementPresent.isElementPresent(By.xpath(VariableDeclarations.ADMIN_ADDLISTING_ALERT12_BACK_XPATH), driver))) //test 3
            System.out.println("ERROR: back button on pop up not seen");  
        if(!(isElementPresent.isElementPresent(By.xpath(VariableDeclarations.ADMIN_ADDLISTING_ALERT12_CANCEL_XPATH), driver))) 
            System.out.println("ERROR: cancel button on pop up not seen");  
        
    }
    
    public void test_urlChangeToManageListingUrl(WebDriver driver)    //check if manage listing page is seen after add listing operation
    {
       driver.findElement(By.id(VariableDeclarations.ADMIN_ADDLISTING_ALERT2_SALE_BUTTON_ID)).click();
       if(!driver.getCurrentUrl().contains("manage/admin/listing/add/residential"))
            System.out.println("ERROR: not the expected page");       
       
    }
    
    public void test_saveEmptyListing(WebDriver driver)    //after save, listing should get added, appearance of buttons changes
    {
        String DisplayName = driver.findElement(By.id(VariableDeclarations.ADMIN_ID_DISPLAYNAME_LISTING)).getText();
        driver.findElement(By.id(VariableDeclarations.ADMIN_ID_NEWLISTING_SAVE_BUTTON)).click();
        if(!isElementPresent.isElementPresent(By.id(VariableDeclarations.ADMIN_ID_CLONE_BUTTON), driver))
            System.out.println("ERROR: Listing did not get saved");        
    }
    
    public void test_emptyListingStatusNotPublished(WebDriver driver)    //incomplete listing should show Not Published
    {
               
        if(!(driver.findElement(By.id("formContainer")).getText().contains("Not Published")))
            System.out.println("ERROR: status id is not 'Not Published'");
        
    }
    
    public void test_emptyNewListingIsOnMarket(WebDriver driver)   //check if new listing is "On market" by default
    {
        if(!(driver.findElement(By.id("formContainer")).getText().contains("On the Market")))
            System.out.println("ERROR: status of listing is not 'On the Market'");
    }
    
    public void test_verifyButtonDisabledForIncompleteListing(WebDriver driver) //check if verify button is disabled for incomplete listing
    {
       if(!driver.findElement(By.id("verifyToggle")).getAttribute("aria-disabled").contentEquals("true"))
          //aria-disabled is TRUE if verify button is disabled
          System.out.println("ERROR: verify button is not disabled");
    }
      
    public void test_AddFeatures(WebDriver driver)
    { 
        try {
            driver.findElement(By.className("featuresDialogLink")).click();
            if(!isElementPresent.isElementPresent(By.id("featuresDialog"), driver))
            {
                System.out.println("ERROR MESSAGE: Features popup not seen");
            }
            else
            {
                WebElement FeaturesList = driver.findElement(By.id("featuresDialogContent"));
                List<WebElement> list = FeaturesList.findElements(By.className("row"));
                WebElement element3 = FeaturesList.findElements(By.className("row")).get(2);

                driver.findElement(By.id("featureCheckbox24")).click();
                driver.findElement(By.id("featuresDialogCancelButton")).click();
                Thread.sleep(5000);
                if(!driver.findElement(By.id("featuresListDiv")).isDisplayed())
                    System.out.println("ERROR MESSAGE: Feature list not seen");
                Thread.sleep(5000);
            }
            
            driver.findElement(By.className("featuresDialogLink")).click();
            Thread.sleep(5000);
            driver.findElement(By.id("featureCheckbox24")).click();
            if(!driver.findElement(By.id("featureCheckbox24")).isSelected())
                System.out.println("ERROR MESSAGE: check box is not selected");
            Thread.sleep(5000);
            driver.findElement(By.id("featuresDialogSaveButton")).click();
            if(!driver.findElement(By.id("featuresListDiv")).isDisplayed())
                System.out.println("ERROR MESSAGE: Feature was not added");
        } catch (InterruptedException ex) {
            Logger.getLogger(ListingOperations.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
    public void test_deleteAddedFeatureContacts(WebDriver driver)
    {
        driver.get("http://preview.agorafy.com/manage/admin/listing/13032");
        if(isElementPresent.isElementPresent(By.id("featuresListDiv"), driver))
        {
            FeaturesList = driver.findElement(By.id("featuresListDiv"));
            String deleteFeature = FeaturesList.findElements(By.className("propertyFeature")).get(0).getText();
            FeaturesList.findElements(By.className("btn-icon-del")).get(0).click(); //deletes the first feature from the list of features 
            
            if(FeaturesList.getText().contains(deleteFeature))
            System.out.println("feature NOT deleted");
        
        
        ContactsList = driver.findElement(By.id("contacts"));
        WebElement DeleteContact = ContactsList.findElements(By.className("contactDiv")).get(0);
        String contactName = DeleteContact.findElement(By.className("heading1")).getText();
        System.out.println(contactName);

        DeleteContact.findElement(By.className("btn-icon-del")).click();
        if(ContactsList.getText().contains(contactName))
            System.out.println("Contact NOT deleted");
            
        }
        
        
    }
    
    public void test_mediaDecriptionPopup(WebDriver driver)
    {
        driver.get("http://preview.agorafy.com/manage/admin/listing/470");
        driver.findElement(By.className("dropzoneThumbnail ui-draggable")).click();
        if(!(isElementPresent.isElementPresent(By.className("ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable"), driver)))
            System.out.println("ERROR: Media description pop-up not seen");
        
        
    }
    
  
 
}


