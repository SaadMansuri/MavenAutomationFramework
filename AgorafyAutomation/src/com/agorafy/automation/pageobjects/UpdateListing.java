package com.agorafy.automation.pageobjects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;

public class UpdateListing extends Page 
{

    WebElement element;
    public UpdateListing(WebDriver driver) 
    {
        super(driver);
    }

    public String txt_ListingName()
    {
        String listingName = null;
        try 
        {
            element = driver.findElement(By.className("listing-id-name")).findElement(By.tagName("h4"));
            listingName = element.getText();
            AutomationLog.info("Sucessfully found listing name located at upper corner at RHS");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to find listing name located at upper corner at RHS");
        }
        return listingName;
    }

    public WebElement element_PageHeading() throws Exception
    {
        WebElement parent;
        try 
        {
            parent = driver.findElements(By.className("content-block")).get(0);
            element = parent.findElement(By.tagName("h2"));
            AutomationLog.info("My listing heading found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find My listings heading");
            throw (e);
        }
        return element;
    }

    public WebElement emailId() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("from"));
            AutomationLog.info("Email id is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Email id");
            throw (e);
        }
        return element;
    }

    public WebElement radioBtnNo() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("ls_availability_no"));
            AutomationLog.info("Radio btn No is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Radio btn No");
            throw (e);
        }
        return element;
    }

    public WebElement reasonBlock() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("ls_availability_reason"));
            AutomationLog.info("Reason block is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Reason block");
            throw (e);
        }
        return element;
    }

    public WebElement notesBlock() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("availability_reason_other"));
            AutomationLog.info("notes block is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find notes block");
            throw (e);
        }
        return element;
    }

    public WebElement radioBtnYes() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("ls_availability_yes"));
            AutomationLog.info("Radio btn Yes is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Radio btn Yes");
            throw (e);
        }
        return element;
    }

    public WebElement dropdownReason() throws Exception
    {
        try 
        {
            element = driver.findElement(By.className("select-wrapper"));
            AutomationLog.info("reason dropdown is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find reason dropdown");
            throw (e);
        }
        return element;
    }

    public Collection<String> dropdownReasonOptions() throws Exception
    {
        Collection<String> dropdownReasonOptions = new ArrayList<>();
        List<WebElement> elements_DropdownReasonOptions;
        try 
        {
            element = driver.findElement(By.className("form-control"));
            elements_DropdownReasonOptions = element.findElements(By.tagName("option"));
            for(WebElement singleElement : elements_DropdownReasonOptions)
            {
                dropdownReasonOptions.add(singleElement.getAttribute("value"));
            }
            AutomationLog.info("all options for reason dropdown are found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find all options for reason dropdown");
            throw (e);
        }
        return dropdownReasonOptions;
    }

    public WebElement btn_SaveAndContinue() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("saveLocation"));
            AutomationLog.info("Save and Continue btn is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Save and Continue btn");
            throw (e);
        }
        return element;
    }

    public WebElement form_Details() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("listingSubmitForm"));
            AutomationLog.info("details form is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find details form");
            throw (e);
        }
        return element;
    }

    public WebElement dropdown_AskingPriceUnits() throws Exception
    {
        try 
        {
            element = driver.findElement(By.name("ls_unit"));
            AutomationLog.info("Asking price unit dropdown is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Asking price unit dropdown");
            throw (e);
        }
        return element;
    }

    public Collection<String> askingPriceUnits() throws Exception
    {
        List<WebElement> elements_AskingPriceUnits = new ArrayList<>();
        List<String> askingPriceunits = new ArrayList<>();
        try 
        {
            elements_AskingPriceUnits = dropdown_AskingPriceUnits().findElements(By.tagName("option"));
            for(WebElement singleAskingPriceUnit : elements_AskingPriceUnits)
            {
                askingPriceunits.add(singleAskingPriceUnit.getAttribute("value"));
            }
            AutomationLog.info("Asking price unit dropdown is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Asking price unit dropdown");
            throw (e);
        }
        return askingPriceunits;
    }

    public WebElement form_Property() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("property"));
            AutomationLog.info("property form is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find property form");
            throw (e);
        }
        return element;
    }

    public int count_NoOfTextBoxesInDetailsForm() throws Exception
    {
        int count_TextBoxes = 0;
        try 
        {
             count_TextBoxes = form_Property().findElements(By.tagName("div")).size();
            AutomationLog.info("No of text boxes in respective details form counted successfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to count text boxes in respective details form");
            throw (e);
        }
        return count_TextBoxes;
    }

    public WebElement btn_Back() throws Exception
    {
        try 
        {
            element = driver.findElement(By.className("back-step"));
            AutomationLog.info("back btn is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find back btn");
            throw (e);
        }
        return element;
    }

    public WebElement txt_AskingPrice() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("ls_price_min"));
            AutomationLog.info("Asking price txt box is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Asking price txt box");
            throw (e);
        }
        return element;
    }

    public void setAskingPrice(String askingPrice) throws Exception
    {
        try 
        {
            txt_AskingPrice().sendKeys(askingPrice);
            AutomationLog.info("set asking price successfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to set Asking price");
            throw (e);
        }
    }

    public void setListingLinkUrl(String listingLinkUrl) throws Exception
    {
        try 
        {
            txt_ListingLink().sendKeys(listingLinkUrl);
            AutomationLog.info("set listing link successfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to set listing link");
            throw (e);
        }
    }

    public void setDescription(String description) throws Exception
    {
        try 
        {
            txt_Description().sendKeys(description);
            AutomationLog.info("set description box successfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to set description box");
            throw (e);
        }
    }

    public WebElement txt_Description() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("ls_notes"));
            AutomationLog.info("Description txt box is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Description txt box");
            throw (e);
        }
        return element;
    }

    public WebElement txt_ListingLink() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("ls_url"));
            AutomationLog.info("Listing link Url txt box is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Listing link Url txt box");
            throw (e);
        }
        return element;
    }

    public String pageHeading() throws Exception
    {
        return element_PageHeading().getText();
    }
}
