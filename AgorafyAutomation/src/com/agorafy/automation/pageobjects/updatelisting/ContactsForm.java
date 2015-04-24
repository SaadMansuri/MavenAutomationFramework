package com.agorafy.automation.pageobjects.updatelisting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class ContactsForm extends Page
{
    private WebElement element;

	public ContactsForm(WebDriver driver) 
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
            AutomationLog.error("Could not find Add contacts button");
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
            AutomationLog.error("could not find drop down for Representing as");
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
            AutomationLog.error("Could not find Save And Continue  button");
            throw(e);
        }
        return element;
    }

    public WebElement btn_Back() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("contacts")).findElement(By.className("back-step"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find back button");
            throw(e);
        }
        return element;
    }

    public MediaForm clickOnBackButton() throws Exception
    {
        MediaForm media = null;
        try
        {
            btn_Back().click();
            media = new MediaForm(driver);
            AutomationLog.info("Successfully clicked on back button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on back button");
            throw(e);
        }
        return media;
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
            AutomationLog.error("Could not find No of contacts");
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
            AutomationLog.error("Could not find contacts form");
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
            AutomationLog.error("Could not find Company textbox");
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
            AutomationLog.error("Could not find Email textbox");
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
            AutomationLog.error("Could not find Phone textbox");
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
            AutomationLog.error("Could not find contact name");
            throw(e);
        }
        return element;
    }

    public List<WebElement> element_AllAddedContacts() 
    {
        List<WebElement> allAddedContacts = new ArrayList<>();
        WebElement parent;
        try 
        {
            parent = driver.findElement(By.id("added-contacts"));
            element = parent.findElement(By.className("ul-reset"));
            allAddedContacts = element.findElements(By.tagName("li"));
            AutomationLog.info("Successfully found all added contacts");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to find all added contacts");
        }
        return allAddedContacts;
    }

    public List<String> allAddedContacts() 
    {
        List<String> allAddedContacts = new ArrayList<>();
        List<WebElement> elements_AllAddedContacts = new ArrayList<>();
        String contactName = null;
        try 
        {
            elements_AllAddedContacts = element_AllAddedContacts();
            for(WebElement singleContact : elements_AllAddedContacts)
            {
                 contactName = singleContact.findElement(By.tagName("span")).getText();
                 allAddedContacts.add(contactName);
            }
            AutomationLog.info("Failed to find all added contacts");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Successfully found all added contacts");
        }
        return allAddedContacts;
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
            AutomationLog.error("Could not find cancel button ");
            throw(e);
        }
        return element;
    }

    public void clickEditIconForSingleContact(WebElement singleContact) 
    {
        WebElement parent;
        try 
        {
            parent = singleContact.findElement(By.tagName("p"));
            element = parent.findElements(By.tagName("a")).get(0);
            element.click();
            AutomationLog.info("Successfully clicked edit icon for single contact");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to click edit icon for single contact");
        }
    }

    public void clickDeleteIconForSingleContact(WebElement singleContact) 
    {
        WebElement parent;
        try 
        {
            parent = singleContact.findElement(By.tagName("p"));
            element = parent.findElements(By.tagName("a")).get(1);
            element.click();
            AutomationLog.info("Successfully deleted single contact");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to delete single contact");
        }
    }

    public String getContactName(WebElement singleContact) 
    {
        String singleContactName =null;
        try 
        {
            element = singleContact.findElement(By.tagName("span"));
            singleContactName = element.getText();
            AutomationLog.info("Successfully got name for single contact");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to get name of single contact");
        }
        return singleContactName;
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
            AutomationLog.error("Could not find Save button ");
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
            AutomationLog.error("Could not find edit icon on added contacts");
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
            AutomationLog.error("Could not find Delete icon on added contacts");
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
            AutomationLog.error("Could not find Address textbox");
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
            AutomationLog.error("could not find added contacts");
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
            AutomationLog.error("Could not find error message");
            throw(e);
        }
        return element;
    }

    public WebElement btn_UseMyContactInformation() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("ls_use_my_contact"));
            AutomationLog.info("Found button UseMyContactInformation");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find button UseMyContactInformation");
            throw(e);
        }
        return element;
    }

    public void clickOnUseMyContactInformationbutton() throws Exception
    {
        try
        {
            btn_UseMyContactInformation().click();
            AutomationLog.info("Successfully clicked on UseMyContactInformation button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on UseMyContactInformation button");
            throw(e);
        }
    }

    public void selectValueFromRepresentingAsDropDown(String option) throws Exception
    {
        Select options = new Select(dropdown_RepresentingAs());
        options.selectByVisibleText(option);
    }

    public PreviewAndSubmitForm clickOnSaveAndContinueButton() throws Exception
    {
        PreviewAndSubmitForm previewAndSubmitForm = null;
        try
        {
            btn_SaveAndContinue().click();
            previewAndSubmitForm = new PreviewAndSubmitForm(driver);
            AutomationLog.info("Successfully clicked on Save And Continue button");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not click on Save And Continue button");
            throw(e);
        }
        return previewAndSubmitForm;
    }

    public Integer noOfContactsAdded() 
    {
        Integer noOfContactsAdded = 0;
        String noOfContacts;
        try 
        {
            element = driver.findElement(By.id("numContacts"));
            noOfContacts = element.getText();
            noOfContacts = noOfContacts.substring(0, 1);
            noOfContactsAdded = Integer.parseInt(noOfContacts);
            AutomationLog.info("Successfully counted no of contacts added");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to count No of contacts added");
        }
        return noOfContactsAdded;
    }

    public Collection<String> allRepresentingAsOptions() 
    {
        List<String> allRepresentingAsOptions = new ArrayList<>();
        Collection<WebElement> elements_allRepresentingAsOptions = new ArrayList<>();
        try 
        {
            element = driver.findElement(By.id("ls_represent"));
            elements_allRepresentingAsOptions = element.findElements(By.tagName("option"));
            for(WebElement singleOption : elements_allRepresentingAsOptions)
            {
                allRepresentingAsOptions.add(singleOption.getAttribute("value"));
            }
            AutomationLog.info("successfully found all Representing As Options dropdowns");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to find all Representing As Options dropdowns");
        }
        return allRepresentingAsOptions;
    }

}
