package com.agorafy.automation.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;

public class SubmitListingLocationFormPage extends Page 
{
    private WebElement element = null;

    public SubmitListingLocationFormPage(WebDriver driver) 
    {
        super(driver);
    }
    
    public static SubmitListingLocationFormPage getSubmitListingLocationFormPageObject()
    {
    	return new SubmitListingLocationFormPage(driver);
	}
    
    public By getAddressLocator()
    {
        return By.id("ls_address");
    }

    public By getBackBtnOnDetailsPageLocator()
    {
        return By.xpath(".//*[@id='property']/div[19]/div/button[1]");
    }

    public By getdetailsPageLocator()
    {
        return By.id("property");
    }

    public WebElement txtbx_Address() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("ls_address"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Address txt box is not found");
            throw(e);
        }
            return element;
    }

    public void	 setAddress(String address) throws Exception 
    {
        try
        {
            txtbx_Address().sendKeys(address);
            AutomationLog.info("Address txt box is set to:"+ address);
        }
        catch(Exception e)
        {
            AutomationLog.error("Address txt box is not set to:"+ address);
            throw(e);
        }
    }

    public WebElement txtbx_City() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("ls_city"));
        }
        catch(Exception e)
        {
            AutomationLog.error("city txt box is not found");
            throw(e);
        }
        return element;
    }

    public void	 setCity(String city) throws Exception 
    {
        try
        {
            txtbx_City().sendKeys(city);
            AutomationLog.info("city txt box is set to:"+ city);
        }
        catch(Exception e)
        {
            AutomationLog.error("city txt box is not set to:"+ city);
            throw(e);
        }
    }

    public WebElement txtbx_State() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("ls_state"));
        }
        catch(Exception e)
        {
            AutomationLog.error("state txt box is not found");
            throw(e);
        }
        return element;
    }

    public void	 setState(String state) throws Exception 
    {
        try
        {
            txtbx_State().sendKeys(state);
            AutomationLog.info("State txt box is set to:"+ state);
        }
        catch(Exception e)
        {
            AutomationLog.error("State txt box is not set to:"+ state);
            throw(e);
        }
    }

    public WebElement txtbx_ZipCode() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("ls_zipcode"));
        }
        catch(Exception e)
        {
            AutomationLog.error("zipCode txt box is not found");
            throw(e);
        }
        return element;
    }

    public void	 setZipCode(String zipCode) throws Exception 
    {
        try
        {
            txtbx_ZipCode().sendKeys(zipCode);
            AutomationLog.info("zipCode txt box is set to:"+ zipCode);
        }
        catch(Exception e)
        {
            AutomationLog.error("zipCode txt box is not set to:"+ zipCode);
            throw(e);
        }
    }

    public WebElement btn_SaveAndContinue() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("saveLocation"));
        }
        catch(Exception e)
        {
            AutomationLog.error("saveAndContinue Btn is not found");
            throw(e);
        }
        return element;
    }

    public void	 clickSaveAndContinue() throws Exception 
    {
        try
        {
            btn_SaveAndContinue().click();
        }
        catch(Exception e)
        {
            AutomationLog.error("saveAndContinue Btn failed to click");
            throw(e);
        }
    }

    public WebElement btn_BackOnDetails() throws Exception 
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='property']/div[19]/div/button[1]"));
        }
        catch(Exception e)
        {
            AutomationLog.error("backBtnOnDetails is not found");
            throw(e);
        }
        return element;
    }

    public void	 clickBackBtnOnDetails() throws Exception 
    {
        try
        {
            btn_BackOnDetails().click();
        }
        catch(Exception e)
        {
            AutomationLog.error("backBtnOnDetails is failed to click");
            throw(e);
        }
    }

    public void clearLocationFields() throws Exception
    {
        try
        {
            txtbx_Address().clear();
            txtbx_City().clear();
            txtbx_State().clear();
            txtbx_ZipCode().clear();
            AutomationLog.info("clearLocationFields successfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("clearLocationFields failed");
            throw(e);
        }
    }
}
	