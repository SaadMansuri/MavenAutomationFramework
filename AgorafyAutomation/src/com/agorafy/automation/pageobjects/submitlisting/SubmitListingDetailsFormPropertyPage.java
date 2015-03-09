package com.agorafy.automation.pageobjects.submitlisting;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.agorafy.automation.automationframework.AutomationLog;

public class SubmitListingDetailsFormPropertyPage extends SubmitListingDetailsFormBasePage 
{

    public SubmitListingDetailsFormPropertyPage(WebDriver driver) 
    {
        super(driver);
    }

    public WebElement dropdown_PropertyType() throws Exception 
    {
        try
        {
            element = driver.findElement(By.name("ls_property_type"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("Property Type dropdown not found");
            throw e;
        }
    }

    public void selectPropertyTypeDropdown(String propertyType) throws Exception
    {
        try 
        {
            dropdown = new Select(dropdown_PropertyType());
            dropdown.selectByVisibleText(propertyType);
            AutomationLog.info(propertyType+" selected");
        }
        catch (Exception e) 
        {
            AutomationLog.error(propertyType+" failed to select");
            throw e;
        }
    }

    public List<WebElement> allPropertyTypes() throws Exception 
    {
        List<WebElement> allPropertyTypes;
        try
        {
            element = dropdown_PropertyType();
            allPropertyTypes = element.findElements(By.tagName("option"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Property Types not found");
            throw (e);
       }
        return allPropertyTypes;
    }

    public ArrayList<String> txt_AllDisplayedPropertyTypes() throws Exception 
    {
        ArrayList<String> stringAllDisplayedPropertyTypes = new ArrayList<>();
        List<WebElement> allPropertyTypes;
        String display;
        try
        {
            allPropertyTypes = allPropertyTypes(); 
            for (WebElement element : allPropertyTypes)
            {
                display = element.getCssValue("display");
                if(display.equals("block") )
                stringAllDisplayedPropertyTypes.add(element.getText());
            }
        }
        catch(Exception e)
        {
            AutomationLog.error("Property Types not found");
            throw (e);
        }
        return stringAllDisplayedPropertyTypes;
    }

    public WebElement txtbx_Block() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("ls_block"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("Block txt Box not found");
            throw e;
        }
    }

    public void setBlock(String block) throws Exception
    {
        try 
        {
            txtbx_Block().sendKeys(block);
            AutomationLog.info("Block is set to:" +block );
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to set Block to:" +block);
            throw e;
        }
    }

    public void clearBlock() throws Exception
    {
        try 
        {
            txtbx_Block().clear();
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to clear Block");
            throw e;
        }
    }

    public WebElement txtbx_Lot() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("ls_lot"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("Lot txt Box not found");
            throw e;
        }
    }

    public void setLot(String lot) throws Exception
    {
        try 
        {
            txtbx_Lot().sendKeys(lot);
            AutomationLog.info("Lot is set to:" +lot );
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to set Lot to:" +lot);
            throw e;
        }
    }

    public void clearLot() throws Exception
    {
        try 
        {
            txtbx_Lot().clear();
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to clear Lot");
            throw e;
        }
    }

    public WebElement txtbx_ListingLink() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("ls_lLink"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("Listing Link txt Box not found");
            throw e;
        }
    }

    public void setListingLink(String listingLink) throws Exception
    {
        try 
        {
            txtbx_ListingLink().sendKeys(listingLink);
            AutomationLog.info("ListingLink is set to:" +listingLink );
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to set ListingLink to:" +listingLink);
            throw e;
        }
    }

    public void clearListingLink() throws Exception
    {
        try 
        {
            txtbx_ListingLink().clear();
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to clear ListingLink");
            throw e;
        }
    }
}
