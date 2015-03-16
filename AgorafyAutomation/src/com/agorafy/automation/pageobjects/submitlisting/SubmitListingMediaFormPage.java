package com.agorafy.automation.pageobjects.submitlisting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Page;


public class SubmitListingMediaFormPage extends Page
{
    private WebElement element = null;
    public SubmitListingMediaFormPage(WebDriver driver) 
    {
        super(driver);
    }

    public WebElement btn_AddFiles() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("files"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Add files button");
            throw(e);
        }
        return element;
    }

    public WebElement btn_Back() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("media")).findElement(By.className("back-step"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Back button");
            throw(e);
        }
        return element;
    }	

    public SubmitListingDetailsFormBasePage clickOnBackButton() throws Exception
    {
        SubmitListingDetailsFormBasePage details = null;
        try 
        {
            btn_Back().click();
            details = new SubmitListingDetailsFormBasePage(driver);
            AutomationLog.info("Successfully clicked on Back button ");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Could not click on Back button");
            throw(e);
        }
        return details;
    }

        public void clickOnAddFilesButton() throws Exception
    {
         try
         {
             btn_AddFiles().click();
             AutomationLog.info("Successfully clicked on Add files button");
         }
         catch(Exception e)
         {
             AutomationLog.error("Could not click on Add files button");
             throw(e);
         }
    }

    public WebElement btn_Cancel() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("cancel")).findElement(By.tagName("button"));
            AutomationLog.info("Cancel button found after image is selected");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find cancel button ");
            throw(e);
        }
        return element;
    }

    public WebElement form_Media() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("media"));
            AutomationLog.info("Media form found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find media form");
            throw(e);
        }
        return element;
    }

    public WebElement btn_SaveAndContinue() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("saveMedia"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Save and Continue button");
            throw(e);
        }
        return element;
    }

    public void clickOnSaveAndContinueButton() throws Exception
    {
        try
        {
            btn_SaveAndContinue().click();
            AutomationLog.info("Successfully clicked on Save and Continue Button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Save and Continue Button");
            throw(e);
        }
    }

    public WebElement msg_MediaError() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("mediaErrorMsg"));
            AutomationLog.info("Media Error Message found ");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could Not find Media Error Message");
            throw(e);
        }
        return element;
    }

    @SuppressWarnings("static-access")
    public By listingImageLocator() throws Exception
    {
        return By.className("fade").tagName("canvas");
    }

    public WebElement img_Listing() throws Exception
    {
        try
        {
            element = driver.findElement(listingImageLocator());
            AutomationLog.info("Listing image found for upload");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not find listing image for upload");
            throw(e);
        }
        return element;
    }

    public boolean template_Upload() throws Exception 
    {
        WebElement select = driver.findElement(By.className("files"));
        List<WebElement> options = select.findElements(By.tagName("li"));
        if(options.size() > 0)
        {
            return true; 
        }
        else
            return false;
    }

    public WebElement txt_image() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("file_name_tooltip"));
            AutomationLog.info("Image name text found");
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not find image name text");
            throw(e);
        }
        return element;
    }

    public By uploadImagelocator() throws Exception
    {
        return By.xpath(".//*[@id='file-upload-cont']/div/div/div/ul/li/div/div/p/img");
    }

    public WebElement img_Uploaded() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='file-upload-cont']/div/div/div/ul/li/div/div/p/img"));
            AutomationLog.info("image found");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not find image");
            throw(e);
        }
        return element;
    }

    public WebElement btn_deleteUploadedImage() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("delete")).findElement(By.tagName("button"));
            AutomationLog.info("Delete button found on uploaded image");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not find delete button on uploaded image");
            throw(e);
        }
        return element;
    }

    public void clickOnDeleteButton() throws Exception
    {
        try
        {
            btn_deleteUploadedImage().click();
            AutomationLog.info("Successfully clicked on delete button ");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on delete button");
            throw(e);
        }
    }

    public void clickOnCancelBbutton() throws Exception
    {
        try
        {
            btn_Cancel().click();
            WaitFor.waitForPageToLoad(driver);
            AutomationLog.info("Successfully clicked on cancel Button");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not click on cancel button");
            throw(e);
        }
    }

    public WebElement btn_StartUpload() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='file-upload-cont']/div/div/button"));
            AutomationLog.info("Start Upload Button Found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Start Upload Button");
            throw(e);
        }
        return element;
    }

    public void clickOnStartUploadButton() throws Exception
    {
        try
        {
            btn_StartUpload().click();
            AutomationLog.info("Successfully clicked on Start Upload Button");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not click on Start Upload button");
            throw(e);
        }
    }

}

