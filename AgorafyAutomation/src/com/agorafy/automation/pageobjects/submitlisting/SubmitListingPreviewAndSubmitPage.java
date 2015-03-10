package com.agorafy.automation.pageobjects.submitlisting;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class SubmitListingPreviewAndSubmitPage extends Page
{
    private WebElement element = null;
    private SubmitListingMediaFormPage media = new SubmitListingMediaFormPage(driver);
    private SubmitListingContactsFormPage contacts = new SubmitListingContactsFormPage(driver);
    private SubmitListingLocationFormPage locationPage = new SubmitListingLocationFormPage(driver);
    private SubmitListingDetailsFormRetailPage detailsRetailPage = new SubmitListingDetailsFormRetailPage(driver);

    public SubmitListingPreviewAndSubmitPage(WebDriver driver)
    {
        super(driver);
    }

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
        return locationPage.form_Location().isDisplayed();
    }

    public boolean Details_Displayed() throws Exception
    {
        return detailsRetailPage.form_Property().isDisplayed();
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

    public String Location_Address() throws Exception
    {
        return locationPage.txtbx_Address().getAttribute("value");
    }

    public String Location_City() throws Exception
    {
        return locationPage.txtbx_City().getAttribute("value");
    }

    public String Location_State() throws Exception
    {
        return locationPage.txtbx_State().getAttribute("value");
    }

    public String Location_ZipCode() throws Exception
    {
        return locationPage.txtbx_ZipCode().getAttribute("value");
    }

    public String Details_AskingPrice() throws Exception
    {
        return detailsRetailPage.txtbx_AskingPrice().getAttribute("value");
    }

    public String Details_Frontage() throws Exception
    {
        return detailsRetailPage.txtbx_Frontage().getAttribute("value");
    }

    public String Details_CeilingHeight() throws Exception
    {
        return detailsRetailPage.txtbx_CeilingHeight().getAttribute("value");
    }

    public String Details_Description() throws Exception
    {
        return detailsRetailPage.txtbx_Description().getAttribute("value");
    }

}
