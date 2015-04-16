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

    public WebElement btn_SaveAndContinueOnDetailsForm() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("saveProperty"));
            AutomationLog.info("Save and Continue btn on details form is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Save and Continue btn on details form");
            throw (e);
        }
        return element;
    }

    public WebElement form_Details() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("property"));
            AutomationLog.info("details form is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find details form");
            throw (e);
        }
        return element;
    }

    public WebElement form_Media() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("media"));
            AutomationLog.info("media form is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find media form");
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

    public WebElement btn_BackOnMediaForm() throws Exception
    {
        WebElement parent;
        try 
        {
            parent = driver.findElement(By.className("col-md-12"));
            element = parent.findElements(By.tagName("button")).get(0);
            AutomationLog.info("back btn on media form is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find back btn on media form");
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

    public WebElement txt_AskingPriceMin() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("ls_price_min"));
            AutomationLog.info("Asking price min txt box is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Asking price min txt box");
            throw (e);
        }
        return element;
    }

    public WebElement txt_AskingPriceMax() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("ls_price_max"));
            AutomationLog.info("Asking price max txt box is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Asking price max txt box");
            throw (e);
        }
        return element;
    }

    public WebElement txt_SpaceSizeMin() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("ls_residential_space_size_min"));
            AutomationLog.info("Space Size Min min txt box is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Space Size min txt box");
            throw (e);
        }
        return element;
    }

    public WebElement txt_PropertyName() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("ls_residential_property_name"));
            AutomationLog.info("Property Name txt box is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Property Name txt box");
            throw (e);
        }
        return element;
    }

    public WebElement txt_Bedrooms() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("ls_bedrooms"));
            AutomationLog.info("Bedrooms txt box is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Bedrooms txt box");
            throw (e);
        }
        return element;
    }

    public WebElement txt_Bathrooms() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("ls_bathrooms"));
            AutomationLog.info("Bathrooms txt box is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Bathrooms txt box");
            throw (e);
        }
        return element;
    }

    public void setSpaceSizeMin(String spaceSizeMin) throws Exception
    {
        try 
        {
            txt_SpaceSizeMin().sendKeys(spaceSizeMin);
            AutomationLog.info("set space Size Min successfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to set space Size Min");
            throw (e);
        }
    }

    public void setAskingPriceMin(String askingPriceMin) throws Exception
    {
        try 
        {
            txt_AskingPriceMin().sendKeys(askingPriceMin);
            AutomationLog.info("set asking Price Min successfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to set asking Price Min");
            throw (e);
        }
    }

    public void setAskingPriceMax(String askingPriceMax) throws Exception
    {
        try 
        {
            txt_AskingPriceMax().sendKeys(askingPriceMax);
            AutomationLog.info("set asking Price Max successfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to set asking Price Max");
            throw (e);
        }
    }

    public void setSpaceSizeMax(String spaceSizeMax) throws Exception
    {
        try 
        {
            txt_SpaceSizeMax().sendKeys(spaceSizeMax);
            AutomationLog.info("set space Size Max successfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to set space Size Max");
            throw (e);
        }
    }

    public WebElement txt_SpaceSizeMax() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("ls_residential_space_size_max"));
            AutomationLog.info("Space Size Max txt box is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Space Size Max txt box");
            throw (e);
        }
        return element;
    }

    
    public WebElement txt_BidDeadline() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("ls_bidDeadline"));
            AutomationLog.info("Bid deadline txt box is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Bid deadline txt box");
            throw (e);
        }
        return element;
    }

    public void setBidDeadline(String bidDeadline) throws Exception
    {
        try 
        {
            txt_BidDeadline().sendKeys(bidDeadline);
            AutomationLog.info("set bid Deadline txt box successfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to set bid Deadline");
            throw (e);
        }
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

    public Integer noOfSpacesAdded() 
    {
        Integer noOfSapcesAdded = 0;
        try 
        {
            if(txt_NoOfSpacesAdded().isDisplayed())
            {
                 String txt_NoOfSpaces = txt_NoOfSpacesAdded().getText();
                 txt_NoOfSpaces = txt_NoOfSpaces.substring(0, 1);
                 noOfSapcesAdded = Integer.parseInt(txt_NoOfSpaces);
            }
            else
            {
                noOfSapcesAdded = 0;
            }
            AutomationLog.info("Successfully found No of space added");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find No of space added");
        }
        return noOfSapcesAdded;
    }

    public WebElement txt_NoOfSpacesAdded() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("numSpaces"));
            AutomationLog.info("No of spaces added txt box is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Asking price txt box");
            throw (e);
        }
        return element;
    }

    public List<WebElement> elements_NoOfSpacesAdded() throws Exception
    {
        List<WebElement> elements_NoOfSpacesAdded = new ArrayList<>();
        WebElement parent;
        try 
        {
            parent = driver.findElement(By.id("added-spaces"));
            element = parent.findElement(By.className("ul-reset"));
            elements_NoOfSpacesAdded = element.findElements(By.tagName("li"));
            AutomationLog.info("all elements for No of spaces added txt box is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find all elements for no of added spaces");
            throw (e);
        }
        return elements_NoOfSpacesAdded;
    }

    public void deleteAllSpaces() throws Exception
    {
        List<WebElement> allAddedSpaces = elements_NoOfSpacesAdded();
        try 
        {
            for(WebElement singleSpace : allAddedSpaces)
            {
                element = singleSpace.findElement(By.tagName("p"));
                element.findElements(By.tagName("a")).get(1).click();
            }
            AutomationLog.info("deleted all spaces successfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to delete all spaces");
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

    public WebElement txt_CeilingHeight()
    {
        try 
        {
            element = driver.findElement(By.id("ls_ceiling_height"));
            AutomationLog.info("Sucessfully found Ceiling height");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to find Ceiling height");
        }
        return element;
    }

    public WebElement txt_Frontage()
    {
        try 
        {
            element = driver.findElement(By.id("ls_frontage"));
            AutomationLog.info("Sucessfully found Frontage");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to find Frontage");
        }
        return element;
    }

    public WebElement radioBtn_FoodYes()
    {
        try 
        {
            element = driver.findElement(By.xpath(".//*[@id='property']/div[6]/div/p[1]/label[2]/input"));
            AutomationLog.info("Sucessfully found radio btn food yes");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to find radio btn food yes");
        }
        return element;
    }

    public WebElement radioBtn_FoodNo()
    {
        try 
        {
            element = driver.findElement(By.xpath(".//*[@id='property']/div[6]/div/p[1]/label[3]/input"));
            AutomationLog.info("Sucessfully found radio btn food no");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to find radio btn food no");
        }
        return element;
    }

    public WebElement radioBtn_CookingYes()
    {
        try 
        {
            element = driver.findElement(By.xpath(".//*[@id='property']/div[6]/div/p[2]/label[2]/input"));
            AutomationLog.info("Sucessfully found radio btn cooking yes");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to find radio btn cooking yes");
        }
        return element;
    }

    public WebElement radioBtn_CookingNo()
    {
        try 
        {
            element = driver.findElement(By.xpath(".//*[@id='property']/div[6]/div/p[2]/label[3]/input"));
            AutomationLog.info("Sucessfully found radio btn cooking no");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to find radio btn cooking no");
        }
        return element;
    }

    public WebElement txt_Combinable()
    {
        try 
        {
            element = driver.findElement(By.id("ls_combinable"));
            AutomationLog.info("Sucessfully found Combinable");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to find Combinable");
        }
        return element;
    }

    public void setCombinable(String combinable) throws Exception
    {
        try 
        {
            txt_Combinable().sendKeys(combinable);
            AutomationLog.info("set combinable box successfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to set combinable box");
            throw (e);
        }
    }

    public WebElement txt_Electricity()
    {
        try 
        {
            element = driver.findElement(By.id("ls_electricity"));
            AutomationLog.info("Sucessfully found Electricity");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to find Electricity");
        }
        return element;
    }

    public void setElectricity(String electricity) throws Exception
    {
        try 
        {
            txt_Electricity().sendKeys(electricity);
            AutomationLog.info("set electricity box successfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to set electricity box");
            throw (e);
        }
    }

    public void selectSpaceType(String spaceType) throws Exception
    {
        try 
        {
            element = dropdown_SpaceType();
            org.openqa.selenium.support.ui.Select dropdown = new org.openqa.selenium.support.ui.Select(element);
            dropdown.selectByVisibleText(spaceType);
            AutomationLog.info("selected space type successfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to select space type");
            throw (e);
        }
    }

    public void selectSpaceName() throws Exception
    {
        try 
        {
            dropdown_SpaceName().click();
            element = driver.findElement(By.className("chzn-results"));
            element.findElements(By.tagName("li")).get(0).click();
            AutomationLog.info("selected one of the space name successfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to select one of the space name");
            throw (e);
        }
    }

    public WebElement dropdown_SpaceType()
    {
        try 
        {
            element = driver.findElement(By.id("ls_space_type"));
            AutomationLog.info("Sucessfully found space type dropdown");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to find space type dropdown");
        }
        return element;
    }

    public WebElement dropdown_SpaceName()
    {
        try 
        {
            element = driver.findElement(By.className("chzn-single"));
            AutomationLog.info("Sucessfully found space name dropdown");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to find space name dropdown");
        }
        return element;
    }

    public WebElement txt_SpaceSize() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("ls_space_size"));
            AutomationLog.info("Space Size txt box is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Space Size txt box");
            throw (e);
        }
        return element;
    }

    public WebElement txt_SpaceSizeWithCSS() throws Exception
    {
        try 
        {
            element = driver.findElement(By.className("sqft-badge"));
            AutomationLog.info("Space Size with css txt box is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Space Size with css txt box");
            throw (e);
        }
        return element;
    }

    public void setSpaceSize(String spaceSize) throws Exception
    {
        try 
        {
            txt_SpaceSize().sendKeys(spaceSize);
            AutomationLog.info("set Space Size txt box successfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to set Space Size");
            throw (e);
        }
    }

    public void setCeilingHeight(String ceilingHeight) throws Exception
    {
        try 
        {
            txt_CeilingHeight().sendKeys(ceilingHeight);
            AutomationLog.info("set ceiling Height txt box successfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to set ceiling Height");
            throw (e);
        }
    }

    public WebElement btn_AddSpace() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("add-space"));
            AutomationLog.info("Add Space btn is found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Add Space btn");
            throw (e);
        }
        return element;
    }

    public String pageHeading() throws Exception
    {
        return element_PageHeading().getText();
    }
}
