/**
 *
 * @author : Chandrani
 */
package agorafy.test.testcases.listings;

import agorafy.test.utils.isElementPresent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ResidentialListings {
    
     public static void test_addResidentialListing(WebDriver driver) throws InterruptedException
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
    
    public static void test_editResidentialListingLeaseToSale(WebDriver driver)
    {
        driver.findElement(By.id(VariableDeclarations.ADMIN_ID_EDITLISTING_BUTTON)).click();
        driver.findElement(By.id(VariableDeclarations.ADMIN_ADDLISTING_ALERT2_LEASE_BUTTON_ID));
        driver.findElement(By.id(VariableDeclarations.ADMIN_ADDLISTING_ALERT2_SALE_BUTTON_ID));
        if(!driver.findElement(By.id("financing")).isDisplayed())
            System.out.println("ERROR: change of sale type did not introduce the field FINANCE");
        
    }
    
}
