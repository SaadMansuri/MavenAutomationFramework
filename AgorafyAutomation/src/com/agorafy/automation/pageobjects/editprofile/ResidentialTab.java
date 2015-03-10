package com.agorafy.automation.pageobjects.editprofile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Page;

public class ResidentialTab extends Page
{
    private WebElement element = null;
    public ResidentialTab(WebDriver driver) 
    {
        super(driver);
    }

    public WebElement tab_Residential() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='tabs']/li[3]/a"));
            AutomationLog.info("Residential tab found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Residential Tab");
            throw(e);
        }
        return element;
        
    }

    public WebElement btn_Save() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("residentialSubmit"));
            AutomationLog.info("Save button found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Save button");
            throw(e);
        }
        return element;
        
    }

    public void clickOnResidentialTab() throws Exception
    {
        try
        {
            tab_Residential().click();
            AutomationLog.info("Successfully clicked on Residential Tab");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on residential tab");
            throw(e);
        }
    }

    public void clickOnSaveButton() throws Exception
    {
        try
        {
            btn_Save().click();
            WaitFor.waitForPageToLoad(driver, "Success!", successMessageLocator());
            AutomationLog.info("Successfully clicked on Save button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Save button");
            throw(e);
        }
    }


    public void markAllCheckboxesInAreasofExpertise() throws Exception
    {
        try
        {
            WebElement select = driver.findElement(By.xpath(".//*[@id='residentialForm']/div[1]/div"));
            List<WebElement> options = select.findElements(By.name("resiExpertises[]"));
            for(WebElement option:options)
            {
                option.click();
            }
            AutomationLog.info("Successfully marked all checkboxes in Areas of Expertise");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not mark all checkboxes in Areas of Expertise");
            throw(e);
        }
    }

    public void markAllCheckboxesInAreasofFocus() throws Exception
    {
        try
        {
            WebElement select = driver.findElement(By.xpath(".//*[@id='residentialForm']/div[2]/div"));
            List<WebElement> options = select.findElements(By.name("representations[]"));
            for(WebElement option:options)
            {
                option.click();
            }
            AutomationLog.info("Successfully marked all checkboxes in Areas of Focus");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not mark all checkboxes in Areas of Focus");
            throw(e);
        }
    }

    public By successMessageLocator() throws Exception
    {
        return By.xpath("//div[@style='display: block;']");
    }

    public WebElement msg_Success() throws Exception
    {
        try
        {
            element = driver.findElement(successMessageLocator());
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find success message");
            throw(e);
        }
        return element;
    }
}
