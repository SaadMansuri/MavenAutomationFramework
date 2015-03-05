package com.agorafy.automation.pageobjects.submitlisting;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class SubmitListingLocationFormPage extends Page 
{
    private WebElement element = null;

    public SubmitListingLocationFormPage(WebDriver driver) 
    {
        super(driver);
    }

    public By getAddressLocator()
    {
        return By.id("ls_address");
    }

    public WebElement form_Location()
    {
        try 
        {
             element = driver.findElement(By.id("location")); 
        }
        catch (Exception e) 
        {
            AutomationLog.error("form element not found");
            throw (e);
        }
        return element;
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

    public void clearAddress() throws Exception 
    {
        try
        {
            txtbx_Address().clear();
        }
        catch(Exception e)
        {
            AutomationLog.error("Address txt box is not cleared");
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

    public void clearCity() throws Exception 
    {
        try
        {
            txtbx_City().clear();
        }
        catch(Exception e)
        {
            AutomationLog.error("City txt box is not cleared");
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

    public void clearState() throws Exception 
    {
        try
        {
            txtbx_State().clear();
        }
        catch(Exception e)
        {
            AutomationLog.error("state txt box is not cleared");
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

    public void clearZipCode() throws Exception 
    {
        try
        {
            txtbx_ZipCode().clear();
        }
        catch(Exception e)
        {
            AutomationLog.error("zipcode txt box is not cleared");
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
            AutomationLog.info("save and continue button clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("save and continue button failed to click");
            throw(e);
        }
    }

    public void fillingLocationForm(HashMap<String , String> dummyLocationData) throws Exception
    {
        try 
        {
            setAddress(dummyLocationData.get("address"));
            setCity(dummyLocationData.get("city"));
            setState(dummyLocationData.get("state"));
            setZipCode(dummyLocationData.get("zipcode"));
            AutomationLog.info("location form filled successfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to fill location form");
            throw(e);
        }
    }

    /*following function fills the location form and clicks save and continue and returns details Retail page object*/
    public SubmitListingDetailsFormRetailPage fillLocationFormAndClickSaveAndContinue(HashMap<String, String> dummyLocationData) throws Exception 
    {
        SubmitListingDetailsFormRetailPage detailsRetailPage;
        try 
        {
            fillingLocationForm(dummyLocationData);
            clickSaveAndContinue();
            detailsRetailPage = new SubmitListingDetailsFormRetailPage(Page.driver);
        }
        catch (Exception e)
        {
            AutomationLog.error("fill location and click save and continue failed");
            throw (e);
        }
        return detailsRetailPage;
    }

    /*this method does the same work but used for setup of preview and submit only*/
    /*following function fills the location form and clicks save and continue and returns details Retail page object*/
    public SubmitListingDetailsFormRetailPage moveToDetailsForm(HashMap<String, HashMap<String, String>> data) throws Exception 
    {
        SubmitListingDetailsFormRetailPage detailsRetailPage;
        try 
        {
            fillingLocationForm(data.get("LocationCombination16"));
            clickSaveAndContinue();
            detailsRetailPage = new SubmitListingDetailsFormRetailPage(Page.driver);
        }
        catch (Exception e)
        {
            AutomationLog.error("fill location and click save and continue failed");
            throw (e);
        }
        return detailsRetailPage;
    }
}	