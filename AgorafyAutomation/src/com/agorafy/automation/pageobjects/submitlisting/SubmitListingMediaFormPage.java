package com.agorafy.automation.pageobjects.submitlisting;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
            element = driver.findElement(By.xpath(".//*[@id='files']"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found Add files button");
            throw(e);
        }
        return element;
    }

    public WebElement btn_Back() throws Exception 
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='media']/div[3]/div/button[1]"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found Back button");
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
            element = driver.findElement(By.xpath(".//*[@id='file-upload-cont']/div/div/div/ul/li/div/p[2]/button"));
            AutomationLog.info("Cancel button found after image is selected");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found cancel button ");
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
            AutomationLog.error("Could not found media form");
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
            AutomationLog.error("Could not found Save and Continue button");
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
            AutomationLog.error("Could Not foung Media Error Message");
            throw(e);
        }
        return element;

    }

    public By listingImageLocator() throws Exception
    {
        return By.xpath(".//*[@id='file-upload-cont']/div/div/div/ul/li/p/span/canvas");
    }

    public WebElement img_Listing() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='file-upload-cont']/div/div/div/ul/li/p/span/canvas"));
            AutomationLog.info("Listing image found for upload");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not found listing image for upload");
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
            AutomationLog.error("Could not found image name text");
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
            AutomationLog.error("could not found image");
            throw(e);
        }
        return element;
    }

    public WebElement btn_deleteUploadedImage() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='file-upload-cont']/div/div/div/ul/li/div/div/div/button"));
            AutomationLog.info("Delete button found on uploaded image");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not found delete button on uploaded image");
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

    public void watiUntilElementIsRemoved() throws Exception
    {
    	WebElement select = driver.findElement(By.className("files"));
        List<WebElement> options = select.findElements(By.tagName("li"));
        if(options.size() > 0)
        {
             driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
            AutomationLog.error("Could not found Start Upload Button");
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

    public SubmitListingContactsFormPage moveToContactsForm() throws Exception
    {
        SubmitListingContactsFormPage contact = null;
        try
        {
            clickOnAddFilesButton();
            Runtime.getRuntime().exec("C:\\Users\\admin\\Desktop\\upload.exe");
            WaitFor.presenceOfTheElement(driver, listingImageLocator()); 
            clickOnStartUploadButton();
            WaitFor.presenceOfTheElement(driver, uploadImagelocator());
            clickOnSaveAndContinueButton();
            contact = new SubmitListingContactsFormPage(driver);
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not go to Contacts form ");
            throw(e);
        }
        return contact;
        
    }
}

/*    public void gotomediaform() throws Exception
    {
        driver.findElement(By.id("ls_address")).sendKeys("asdf");
        driver.findElement(By.id("ls_city")).sendKeys("asdf");
        driver.findElement(By.id("ls_state")).sendKeys("asdf");
        driver.findElement(By.id("ls_zipcode")).sendKeys("asdf");
        
        driver.findElement(By.id("saveLocation")).click();
        Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.findElement(By.xpath(".//*[@id='ls_space_name_chzn']/a")).click();
        driver.findElement(By.xpath(".//*[@id='ls_space_name_chzn_o_47']")).click();
        driver.findElement(By.xpath(".//*[@id='ls_space_size']")).sendKeys("sadfsf");
        Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//*[@id='add-space']")).click();
        driver.findElement(By.xpath(".//*[@id='ls_price_min']")).sendKeys("sadfsf");
        Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("saveProperty")).click();
        Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
}

*/
