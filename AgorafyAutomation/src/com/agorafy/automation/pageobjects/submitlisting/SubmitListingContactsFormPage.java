package com.agorafy.automation.pageobjects.submitlisting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class SubmitListingContactsFormPage extends Page
{
    private WebElement element = null;
    public SubmitListingContactsFormPage(WebDriver driver) 
    {
        super(driver);
    }

    public WebElement btn_AddContact() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("add-contact"));
            AutomationLog.info("Add contacts button found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found Add contacts button");
            throw(e);
        }
        return element;
    }

    public void clickOnAddContactsButton() throws Exception
    {
        try
        {
            btn_AddContact().click();
            AutomationLog.info("Successfully clicked on Add contacts button");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not click on Add contacts button");
            throw(e);
        }
    }

    public int getNoOfContactsAdded() throws Exception
    {
        int count = 0;
        try 
        {
            WebElement select = driver.findElement(By.id("added-contacts"));
            List<WebElement> options = select.findElements(By.tagName("li"));
            count = options.size();
            AutomationLog.info("Successfully get No of contacts added");
        } 
        catch (Exception e) 
        {
            AutomationLog.error("Could not get No of contacts added");
            throw(e);
        }
        return count;
        
    }
    
    public void deleteAllAddedContacts() throws Exception
    {
        try
        {
            WebElement select = driver.findElement(By.id("added-contacts"));
            List<WebElement> options = select.findElements(By.className("remove"));
            for(WebElement option : options)
            {
                option.click();
            }
            AutomationLog.info("Successfully deleted all contacts from added contacts");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not delete added contacts");
            throw(e);
        }
    }

    public WebElement dropdown_RepresentingAs() throws Exception
    {
        try
        {
            element =  driver.findElement(By.id("ls_represent"));
        }
        catch(Exception e)
        {
            AutomationLog.error("could not found drop down for Representing as");
            throw(e);
        }
        return element;
    }
    
    public WebElement btn_SaveAndContinue() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("saveContacts"));
            AutomationLog.info("Save And Continue button found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found Save And Continue  button");
            throw(e);
        }
        return element;
    }

    public WebElement btn_Back() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='contacts']/div[5]/div/button[1]"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found back button");
            throw(e);
        }
        return element;
    }

    public SubmitListingMediaFormPage clickOnBackButton() throws Exception
    {
        SubmitListingMediaFormPage mediaform = null;
        try
        {
            btn_Back().click();
            mediaform = new SubmitListingMediaFormPage(driver);
            AutomationLog.info("Successfully clicked on back button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on back button");
            throw(e);
        }
        return mediaform;
    }

    public WebElement txt_NoOfContactsAdded() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("numContacts"));
            AutomationLog.info("No of contacts found");
        } 
        catch (Exception e) 
        {
            AutomationLog.error("Could not found No of contacts");
            throw(e);
        }
        return element;
        
    }

    public WebElement form_Contacts() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("contacts"));
            AutomationLog.info("Contacts form found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found contacts form");
            throw(e);
        }
        return element;
    }

    public WebElement txtbx_Name() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("ls_name"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found Name textbox");
            throw(e);
        }
        return element;
    }

    public WebElement txtbx_Company() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("ls_company"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found Company textbox");
            throw(e);
        }
        return element;
    }

    public WebElement txtbx_Email() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("ls_email"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found Email textbox");
            throw(e);
        }
        return element;
    }

    public WebElement txtbx_Phone() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("ls_phone"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found Phone textbox");
            throw(e);
        }
        return element;
    }

    public WebElement txt_AddedContactName() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("contact-name-1"));
            AutomationLog.info("Contact Name found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found contact name");
            throw(e);
        }
        return element;
    }

    public WebElement btn_CancelContact() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("cancel-contact"));
            AutomationLog.info("Cancel button found");
        } 
        catch (Exception e) 
        {
            AutomationLog.error("Could not found cancel button ");
            throw(e);
        }
        return element;
    }

    public void clickOnCancelContactButton() throws Exception
    {
        try 
        {
            btn_CancelContact().click();
            AutomationLog.info("Successfully clicked on cancel button");
        } 
        catch (Exception e) 
        {
            AutomationLog.error("could not click on Cancel Button");
            throw(e);
        }
    }

    public WebElement btn_SaveContact() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("save-contact"));
            AutomationLog.info("Save button found");
        } 
        catch (Exception e) 
        {
            AutomationLog.error("Could not found Save button ");
            throw(e);
        }
        return element;
    }

    public void clickOnSaveContactButton() throws Exception
    {
        try 
        {
            btn_SaveContact().click();
            AutomationLog.info("Successfully clicked on Save button");
        } 
        catch (Exception e) 
        {
            AutomationLog.error("could not click on Save Button");
            throw(e);
        }
    }



    public WebElement icon_EditAddedContact() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("contact-edit-1"));
            AutomationLog.info("Edit icon found on added contact");
        } 
        catch (Exception e) 
        {
            AutomationLog.error("Could not found edit icon on added contacts");
            throw(e);
        }
        return element;
    }

    public void clickEditIconOnAddedContact() throws Exception
    {
        try
        {
            icon_EditAddedContact().click();
            AutomationLog.info("Successfully clicked on edit icon in Added contacts");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Edit icon");
            throw(e);
        }
    }


    public WebElement icon_DeleteAddedContact() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("contact-delete-1"));
            AutomationLog.info("Delete icon found on added contact");
        } 
        catch (Exception e) 
        {
            AutomationLog.error("Could not found Delete icon on added contacts");
            throw(e);
        }
        return element;
    }

    public void clickDeleteIconOnAddedContact() throws Exception
    {
        try
        {
            icon_DeleteAddedContact().click();
            AutomationLog.info("Successfully clicked on Delete icon in Added contacts");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Delete icon");
            throw(e);
        }
    }

    
    public WebElement txtbx_Address() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("ls_address2"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found Address textbox");
            throw(e);
        }
        return element;
    }

    public WebElement added_Contacts() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("added-contacts"));
            AutomationLog.info("Added contacts found ");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not found added contacts");
            throw(e);
        }
        return element;
    }

    public WebElement msg_ContactsError() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("contactErrorMsg"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found error message");
            throw(e);
        }
        return element;
    }

    public void selectValueFromRepresentingAsDropDown(String option) throws Exception
    {
        Select options = new Select(dropdown_RepresentingAs());
        options.selectByVisibleText(option);
    }

    public void clickOnSaveAndContinueButton() throws Exception
    {
        try
        {
            btn_SaveAndContinue().click();
            AutomationLog.info("Successfully clicked on Save And Continue button");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not click on Save And Continue button");
            throw(e);
        }
    }
}
