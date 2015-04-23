package com.agorafy.automation.pageobjects.updatelisting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class PreviewAndSubmitForm extends Page
{
    public PreviewAndSubmitForm(WebDriver driver) 
    {
        super(driver);
    }

    private WebElement element = null;
    private AvailabilityAndDetailsForm availabilityAndDetailsForm = new AvailabilityAndDetailsForm(Page.driver);
    private MediaForm media = new MediaForm(Page.driver);
    private ContactsForm contacts = new ContactsForm(Page.driver);

    public WebElement form_PreviewAndSubmit() throws Exception
    {
       try 
       {
           element = driver.findElement(By.id("listingSubmitForm"));
           AutomationLog.info("Listing Submit form Found");
       } 
       catch (Exception e) 
       {
           AutomationLog.error("Could not find Listing Submit form");
           throw(e);
       }
       return element;
    }

    public boolean location_Displayed() throws Exception
    {
        return availabilityAndDetailsForm.form_Availability().isDisplayed();
    }

    public boolean Details_Displayed() throws Exception
    {
        return availabilityAndDetailsForm.form_Property().isDisplayed();
    }

    public boolean Media_Displayed() throws Exception
    {
        return media.form_Media().isDisplayed();
    }

    public boolean Contacts_Displayed() throws Exception
    {
        return contacts.form_Contacts().isDisplayed();
    }

    public String Media_ImageText() throws Exception
    {
        return media.txt_image().getText();
    }

    public String AddedContact_Name() throws Exception
    {
        return contacts.txt_AddedContactName().getText();
    }

    public String Contact_Name() throws Exception
    {
        return contacts.txtbx_Name().getAttribute("value");
    }

    public String Contact_RepresentingAs() throws Exception
    {
        return contacts.dropdown_RepresentingAs().getAttribute("value");
    }

    public String Contact_Company() throws Exception
    {
        return contacts.txtbx_Company().getAttribute("value");
    }

    public String Contact_Email() throws Exception
    {
        return contacts.txtbx_Email().getAttribute("value");
    }

    public String Contact_Phone() throws Exception
    {
        return contacts.txtbx_Phone().getAttribute("value");
    }

    public String Contact_Address() throws Exception
    {
        return contacts.txtbx_Address().getAttribute("value");
    }
}
