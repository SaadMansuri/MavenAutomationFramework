package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;

public class UpdateListingPopUp extends Page
{
    private WebElement element;

    public UpdateListingPopUp(WebDriver driver)
    {
        super(driver);
    }

    public By getUpdateListingPopUpLocator() throws Exception
    {
        return By.id("listingUpdatePopup");
    }

    public WebElement popup_UpdateListing() throws Exception
    {
         try
         {
             element = driver.findElement(getUpdateListingPopUpLocator());
             AutomationLog.info("Update listing pop up found");
         }
         catch(Exception e)
         {
             AutomationLog.error("could not find Update listing popUpp ");
             throw(e);
         }
         return element;
    }

    public WebElement txtbx_SquareFootage() throws Exception
    {
        try
        {
            element = popup_UpdateListing().findElement(By.id("updateSF"));
            AutomationLog.info("Square Footage text box found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Square Footage textbox");
            throw(e);
        }
        return element;
    }

    public WebElement txtbx_AskingPrice() throws Exception
    {
        try
        {
            element = popup_UpdateListing().findElement(By.id("updatePrice"));
            AutomationLog.info("Asking price textbox found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Asking price textbox");
            throw(e);
        }
        return element;
    }

    public WebElement txtarea_Description() throws Exception
    {
        try
        {
            element = popup_UpdateListing().findElement(By.id("updateNotes"));
            AutomationLog.info("Text area for Description found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Description text area ");
            throw(e);
        }
        return element;
    }

    public WebElement btn_Send() throws Exception 
    {
        try
        {
            element = driver.findElement(By.className("btn-send"));
            AutomationLog.info("Send button found");
        
        }
        catch(Exception e)
        {
             AutomationLog.error("Could not find send button");
             throw(e);
        }
        return element;
    }

    public WebElement btn_Close() throws Exception 
    {
        try
        {
            element = driver.findElement(By.className("btn-cancel"));
            AutomationLog.info("Close button found");
        
        }
        catch(Exception e)
        {
             AutomationLog.error("Could not find Close button");
             throw(e);
        }
        return element;
    }

    public boolean isUpdateListingPopUpVisible() throws Exception
    {
        boolean value = false;
        try
        {
            value = popup_UpdateListing().isDisplayed();
        }
        catch(Exception e)
        {
            AutomationLog.error("Update listing pop up is not displayed");
        }
        return value;
    }

    public void clickOnCloseButton() throws Exception
    {
        try
        {
            btn_Close().click();
            AutomationLog.info("Successfully clicked close button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on close button");
            throw(e);
        }
    }

}
