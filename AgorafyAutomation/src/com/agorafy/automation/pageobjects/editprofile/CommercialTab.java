package com.agorafy.automation.pageobjects.editprofile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Page;


public class CommercialTab extends Page
{
    private WebElement element = null;
    private List<WebElement> options;

    public CommercialTab(WebDriver driver) 
    {
        super(driver);
    }

    public WebElement tab_Commercial() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='tabs']/li[2]/a"));
            AutomationLog.info("Found Commercial tab ");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Commercial tab ");
            throw(e);
        }
        return element;
    }

    public WebElement txtbx_ExclusiveTenantRepresentation() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("tenantsText"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find textbox for Exclusive Tenant Representation");
            throw(e);
        }
        return element;
    }

    public WebElement txtbx_TenantRequirements() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("requirementsText"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find textbox for Tenant Requirements");
            throw(e);
        }
        return element;
    }

    public WebElement txt_CharactersRemainingExclusiveTenant() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("tenantCharLimit"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find characters remaining text for ExclusiveTenant");
            throw(e);
        }
        return element;
    }

    public WebElement txt_CharactersRemainingTenantRequirement() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("tenantReqCharLimit"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find characters remaining text for TenantRequirement");
            throw(e);
        }
        return element;
    }

    public WebElement btn_save() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("commercialSubmit"));
        }
        catch(Exception e)
        {
            AutomationLog.error("could not find save button");
            throw(e);
        }
        return element;
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

    public void clickOnSaveButton() throws Exception
    {
        try
        {
            btn_save().click();
            WaitFor.waitForPageToLoad(driver, "Success!", successMessageLocator());
            AutomationLog.info("Successfully clicked on save button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on save button");
            throw(e);
        }
    }

    public void markCheckBoxInAreasOFExpertise() throws Exception
    {
        try
        {
            WebElement select = driver.findElement(By.xpath(".//*[@id='commercialForm']/div[1]/div"));
            options = select.findElements(By.name("expertises[]"));
            for(WebElement option:options)
            {
                option.click();
            }
            AutomationLog.info("Successfully marked checkboxes under Areas Of Expertise");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not mark all checkboxes in areas of expertise");
            throw(e);
        }
        
    }

    public void markCheckBoxInAreasOFFocus() throws Exception
    {
        try
        {
            WebElement select = driver.findElement(By.xpath(".//*[@id='commercialForm']/div[2]/div"));
            options = select.findElements(By.name("representations[]"));
            for(WebElement option:options)
            {
                option.click();
            }
            AutomationLog.info("Successfully marked checkboxes under Areas Of Focus");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not mark all checkboxes in areas of focus");
            throw(e);
        }
        
    }

    public void clickOnCommercialTab() throws Exception
    {
        try
        {
            tab_Commercial().click();
            AutomationLog.info("Succesfully clicked on commercial tab ");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on commercial tab");
            throw(e);
        }
    }

    public void enterTextInExclusiveTenantRepresentationTextBox(String text) throws Exception
    {
        try
        {
            txtbx_ExclusiveTenantRepresentation().sendKeys(text);
            AutomationLog.info("successfully entered text in ExclusiveTenantRepresentation text box");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not enter text in ExclusiveTenantRepresentation text box");
            throw(e);
        }
    }

    public void enterTextInTenantRequirementsTextBox(String text) throws Exception
    {
        try
        {
            txtbx_TenantRequirements().sendKeys(text);
            AutomationLog.info("successfully entered text in TenantRequirements text box");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not enter text in TenantRequirements text box");
            throw(e);
        }
    }

    public void RemoveCharactersFromExclusiveTenantRepresentationTextBox(int number) throws Exception
    {
        try
        {
           for(int i=0;i<number;i++)
           {
               txtbx_ExclusiveTenantRepresentation().sendKeys(Keys.BACK_SPACE);
           }
           AutomationLog.info("Successfully removed specified no of characters from Exclusive Tenant Representation TextBox ");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not remove specified no of characters from Exclusive Tenant Representation TextBox");
            throw(e);
        }
    }

    public void RemoveCharactersFromTenantRequirementsTextBox(int number) throws Exception
    {
        try
        {
           for(int i=0;i<number;i++)
           {
               txtbx_TenantRequirements().sendKeys(Keys.BACK_SPACE);
           }
           AutomationLog.info("Successfully removed specified no of characters from Tenant Requirements TextBox");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not remove specified no of characters from Tenant Requirements TextBox");
            throw(e);
        }
    }
}
