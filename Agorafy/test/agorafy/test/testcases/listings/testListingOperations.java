
package agorafy.test.testcases.listings;

import agorafy.test.utils.Login;
import agorafy.test.utils.Logout;
import agorafy.test.configurations.BaseUrl;
import agorafy.test.configurations.BrowserInstance;
import agorafy.test.utils.isAlertPresent;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author : Chandrani
 * 
 * This is the class from where all the operations on listings will be done and tested
 */
public class testListingOperations {
    
    
    public String baseUrl, propertyPageUrl;
    WebDriver driver;
       
    @Before
    public void setUp() throws InterruptedException {
        try {
            driver = BrowserInstance.BrowserInstance("firefox");  //chrome or firefox or ie
            baseUrl = BaseUrl.getBaseUrl();
            Thread.sleep(6000);
            
            driver.manage().window().maximize();
            
            Login.LoginFrontend(driver, baseUrl); 
        } catch (Exception ex) {
            Logger.getLogger(ListingOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        driver.get(baseUrl + "manage/admin/property/16921");
    }
    
    @After
    public void tearDown() {
        
        driver.get(ListingOperations.propertyPageUrl);
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
        
        ListingOperations ObjectOfOperations = new ListingOperations();
        
        ObjectOfOperations.test_addListingTypePopup(driver);
        ObjectOfOperations.test_listingSaleTypePopup(driver);
        ObjectOfOperations.test_cancelAndBackOnPopup(driver);
        Thread.sleep(4000);
        ObjectOfOperations.test_urlChangeToManageListingUrl(driver);
        ObjectOfOperations.test_saveEmptyListing(driver);
        ObjectOfOperations.test_emptyListingStatusNotPublished(driver);
        ObjectOfOperations.test_emptyNewListingIsOnMarket(driver);
        ObjectOfOperations.test_verifyButtonDisabledForIncompleteListing(driver);
        ResidentialListings.test_addResidentialListing(driver);
        ResidentialListings.test_editResidentialListingLeaseToSale(driver);
        ObjectOfOperations.test_AddFeatures(driver);
        ObjectOfOperations.test_deleteAddedFeatureContacts(driver);
       // test_mediaDecriptionPopup();
        
    }
    
}
