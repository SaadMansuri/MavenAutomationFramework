package com.agorafy.automation.pageobjects.submitlisting;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class SubmitListingDetailsFormBasePage extends Page 
{
    public WebElement element;
    public Select dropdown;

    public SubmitListingDetailsFormBasePage(WebDriver driver) 
    {
        super(driver);
    }
    
    public WebElement form_Property() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("property")); 
        }
        catch (Exception e) 
        {
            AutomationLog.error("form element not found");
            throw (e);
        }
        return element;
    }

    public List<WebElement> allListingTypes() throws Exception 
    {
        List<WebElement> allListingTypes;
        try
        {
            element = dropdown_ListingType();
            allListingTypes = element.findElements(By.tagName("option"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Listing Types  not found");
            throw (e);
        }
        return allListingTypes;
    }

    public ArrayList<String> txt_AllDisplayedListingTypes() throws Exception 
    {
        ArrayList<String> stringAllDisplayedListingTypes = new ArrayList<>();
        List<WebElement> allListingTypes;
        String display;
        try
        {
            allListingTypes = allListingTypes(); 
            for (WebElement element : allListingTypes)
            {
                display = element.getCssValue("display");
                if(display.equals("block"))
                     stringAllDisplayedListingTypes.add(element.getText());
            }
        }
        catch(Exception e)
        {
            AutomationLog.error("Listing Types  not found");
            throw (e);
        }
        return stringAllDisplayedListingTypes;
    }

    public WebElement dropdown_ListingType() throws Exception 
    {
        try
        {
            element = driver.findElement(By.name("ls_listing_type"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("Listing Type dropdown not found");
            throw e;
        }
    }	

    public Page selectListingTypeDropdown(String listingType) throws Exception
    {
        Page page = null;

        try 
        {
            dropdown = new Select(dropdown_ListingType());
            dropdown.selectByVisibleText(listingType);
            AutomationLog.info(listingType+" selected");

            switch (listingType)
            {
                case "Retail":
                     page = new SubmitListingDetailsFormRetailPage(driver);
                     break;

                case "Office":
                     page = new SubmitListingDetailsFormOfficePage(driver);
                     break;

                case "Residential":
                     page = new SubmitListingDetailsFormResidentialPage(driver);
                     break;

                case "Property":
                     page = new SubmitListingDetailsFormPropertyPage(driver);
                     break;
            }
        }
        catch (Exception e) 
        {
            AutomationLog.error(listingType+" failed to select");
            throw e;
        }
        return page;
    }

    public WebElement dropdown_ListingOffer() throws Exception 
    {
        try
        {
            element = driver.findElement(By.name("ls_listing_offer"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("Listing Offer dropdown not found");
            throw e;
        }
    }

    public List<WebElement> allListingOfferTypes() throws Exception 
    {
        List<WebElement> allListingOfferTypes;
        try
        {
            element = dropdown_ListingOffer();
            allListingOfferTypes = element.findElements(By.tagName("option"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Listing Offer Types not found");
            throw (e);
        }
        return allListingOfferTypes;
    }

    public ArrayList<String> txt_AllDisplayedListingOfferTypes() throws Exception 
    {
        ArrayList<String> stringAllDisplayedListingOfferTypes = new ArrayList<>();
        List<WebElement> allListingOfferTypes;
        String display;
        try
        {
            allListingOfferTypes = allListingOfferTypes(); 
            for (WebElement element : allListingOfferTypes)
            {
                display = element.getCssValue("display");
                if(display.equals("block") )
                stringAllDisplayedListingOfferTypes.add(element.getText());
            }
        }
        catch(Exception e)
        {
            AutomationLog.error("Listing Offer Types not found");
            throw (e);
        }
        return stringAllDisplayedListingOfferTypes;
    }

    public List<WebElement> allAskingPriceUnits() throws Exception 
    {
        List<WebElement> allAskingPriceUnits;
        try
        {
            element = dropdown_AskingPriceUnit();
            allAskingPriceUnits = element.findElements(By.tagName("option"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Asking Price Units not found");
            throw (e);
        }
        return allAskingPriceUnits;
    }

    public ArrayList<String> txt_AllDisplayedAskingPriceUnits() throws Exception 
    {
        ArrayList<String> stringAllDisplayedAskingPriceUnits = new ArrayList<>();
        List<WebElement> allAskingPriceUnits;
        String display;
        try
        {
            allAskingPriceUnits = allAskingPriceUnits(); 
            for (WebElement element : allAskingPriceUnits)
            {
                display = element.getCssValue("display");
                if(display.equals("block") )
                stringAllDisplayedAskingPriceUnits.add(element.getText());
            }
        }
        catch(Exception e)
        {
            AutomationLog.error("Asking Price Units not found");
            throw (e);
        }
        return stringAllDisplayedAskingPriceUnits;
    }

    public void selectListingOfferDropdown(String listingOffer) throws Exception
    {
        try 
        {
            dropdown = new Select(dropdown_ListingOffer());
            dropdown.selectByVisibleText(listingOffer);
            AutomationLog.info(listingOffer+" selected");
        }
        catch (Exception e) 
        {
            AutomationLog.error(listingOffer+" failed to select");
            throw e;
        }
    }

    public WebElement dropdown_SpaceName() throws Exception 
    {
        try
        {
            element = driver.findElement(By.className("chzn-single"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Space Name dropdown not found");
            throw e;
        }
        return element;
    }

    public void selectSpaceName() throws Exception
    {
        try 
        {
            dropdown_SpaceName().click();
            WebElement parentElement = driver.findElement(By.className("chzn-results"));
            element = parentElement.findElement(By.id("ls_space_name_chzn_o_2"));
            element.click();
            AutomationLog.info("selected one of the space name");
        }
        catch (Exception e) 
        {
            AutomationLog.error(" failed to select space name");
            throw e;
        }
    }

    public WebElement txt_SpaceName() throws Exception 
    {
        try
        {
            element = dropdown_SpaceName().findElement(By.tagName("span"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Space Name txt not found");
            throw e;
        }
        return element;
    }	

    public String getSpaceName() throws Exception
    {
        String spaceName=null;
        try
        {
            spaceName = txt_SpaceName().getText(); 
        }
        catch (Exception e) 
        {
            AutomationLog.error(" failed to get space name");
            throw e;
        }
        return spaceName;
    }

    public WebElement txtbx_SpaceSize() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("ls_space_size"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("Space size txt Box not found");
            throw e;
        }
    }

    public void setSpaceSize(String spaceSize) throws Exception
    {
        try 
        {
            txtbx_SpaceSize().sendKeys(spaceSize);;
            AutomationLog.info("space size set to:"+spaceSize);
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to set space size to:"+spaceSize);
            throw e;
        }
    }

    public void clearSpaceSize() throws Exception
    {
        try 
        {
            txtbx_SpaceSize().clear();
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to clear space size");
            throw e;
        }
    }

    public String getSpaceSize() throws Exception
    {
        String spaceSize= null;
        try 
        {
            spaceSize = txtbx_SpaceSize().getAttribute("value"); 
        }
        catch (Exception e) 
        {
            AutomationLog.error("space size not found");
            throw e;
        }
        return spaceSize;
    }

    public WebElement btn_Save() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("save-space"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("btn Save not found");
            throw e;
        }
    }

    public void clickSave() throws Exception
    {
        try 
        {
            btn_Save().click();
            AutomationLog.info("Save btn is clicked");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Save btn is not clicked");
            throw e;
        }
    }

    public WebElement btn_Cancel() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("cancel-space"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("btn Cancel not found");
            throw e;
        }
    }

    public void clickCancel() throws Exception
    {
        try 
        {
            btn_Cancel().click();
            AutomationLog.info("Cancel btn is clicked");
        }
        catch (Exception e) 
        {
            AutomationLog.error("btn Cancel is not clicked");
            throw e;
        }
    }

    public WebElement txtbx_AskingPrice() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("ls_price_min"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("Asking Price txt Box not found");
            throw e;
        }
    }

    public void setAskingPrice(String askingprice) throws Exception
    {
        try 
        {
            txtbx_AskingPrice().sendKeys(askingprice); 
            AutomationLog.info("asking price is set to:" +askingprice);
        }
        catch (Exception e) 
        {
            AutomationLog.error("asking price not found");
            throw e;
        }
    }

    public void clearAskingPrice() throws Exception
    {
        try 
        {
            txtbx_AskingPrice().clear();
            AutomationLog.info("cleared asking price sucessfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to clear AskingPrice");
            throw (e);
        }
    }

    public WebElement dropdown_AskingPriceUnit() throws Exception 
    {
        try
        {
            element = driver.findElement(By.name("ls_unit"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("Asking Price Unit dropdown not found");
            throw e;
        }
    }

    public void selectAskingPriceUnit(String askingPriceUnit) throws Exception
    {
        Select dropdown = null; 
        try 
        {
            dropdown = new Select(dropdown_AskingPriceUnit());
            dropdown.selectByVisibleText(askingPriceUnit);
            AutomationLog.info("selected asking price Unit:" + askingPriceUnit);

        }
        catch (Exception e) 
        {
            AutomationLog.error(" failed to select asking price unit:" + askingPriceUnit);
            throw e;
        }
    }

    public WebElement txtbx_Description() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("ls_notes"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("Description txt Box not found");
            throw e;
        }
    }

    public void setDescription(String description) throws Exception
    {
        try 
        {
            txtbx_Description().sendKeys(description);
            AutomationLog.info("description set to:" + description);
        }
        catch (Exception e) 
        {
            AutomationLog.error("Description not found");
            throw e;
        }
    }

    public void clearDescription() throws Exception
    {
        try 
        {
            txtbx_Description().clear();
            AutomationLog.info("cleared description sucessfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to clear Description");
            throw (e);
        }
    }

    public WebElement btn_AddSpace() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("add-space"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("btn Add Space not found");
            throw e;
        }
    }

    public void clickAddSpace() throws Exception
    {
        try 
        {
            btn_AddSpace().click();
            AutomationLog.info("Add Space btn is clicked");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Add Space btn is not clicked");
            throw e;
        }
    }

    public Integer noOfSpacesAddedSeenInSpaceHeader() 
    {
        Integer noOfSpacesAdded=null;
        element = driver.findElement(By.id("numSpaces"));
        String str = element.getText();
        if(str.contains("space"))
        {
            str = str.substring(0, 1);
            noOfSpacesAdded =  Integer.parseInt(str);
        }
        else
        {
            noOfSpacesAdded = 0;
        }
        return noOfSpacesAdded;
    }

    public java.util.List<WebElement> allSpaceElements()
    {
        List<WebElement> parent1 = driver.findElements(By.id("added-spaces"));
        WebElement child = parent1.get(0).findElement(By.className("ul-reset"));
        List<WebElement> allSpaces = child.findElements(By.tagName("li"));
        return allSpaces;
    }

    public WebElement getSingleSpace()
    {
        List<WebElement> allSpaces = allSpaceElements();
        for(WebElement element1 : allSpaces)
        {
            element = element1;
            break;
        }
        return element;
    }

    public String getSpaceInfo()
    {
        return getSingleSpace().getText();
    }

    public WebElement icon_EditSpace() throws Exception
    {
        try
        {
            element = getSingleSpace().findElement(By.className("edit"));
        }
        catch(Exception e)
        {
            AutomationLog.error("icon edit space icon ");
            throw e;
        }
        return element;
    }

    public void clickEditSpace() throws Exception
    {
        try 
        {
            icon_EditSpace().click();
        }
        catch (Exception e) 
        {
            AutomationLog.error("edit space icon clicked successfully");
            throw e;
        }
    }

    public Integer noOfSpacesAddedSeenSpaceInList() 
    {
         return allSpaceElements().size();
    }

    public void removeSpaceElement(int spaceElementNo)
    {
        List<WebElement> allSpaceElements = allSpaceElements();
        allSpaceElements.get(spaceElementNo).findElement(By.className("remove")).click();
    }

    public WebElement btn_Back() throws Exception 
    {
        try
        {
            element = form_Property().findElement(By.className("back-step"));
            AutomationLog.info("Back button found");
        }
        catch(Exception e)
        {
            AutomationLog.error("btn back not found");
            throw e;
        }
        return element;
    }

    public void clickBack() throws Exception
    {
        try 
        {	
            btn_Back().click();
            AutomationLog.info("Back btn is clicked");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Back btn is not clicked");
            throw e;
        }
    }

    public WebElement btn_SaveAndContinue() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("saveProperty"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("btn SaveAndContinue not found");
            throw e;
        }
    }

    public void clickSaveAndContinue() throws Exception
    {
        try 
        {
            btn_SaveAndContinue().click();
            AutomationLog.info("SaveAndContinue btn is clicked");
        }
        catch (Exception e) 
        {
            AutomationLog.error("SaveAndContinue btn is not clicked");
            throw e;
        }
    }

    public WebElement txtbx_CeilingHeight() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("ls_ceiling_height"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("CeilingHeight txt Box not found");
            throw e;
        }
    }

    public void setCeilingHeight(String ceilingHeight) throws Exception
    {
        try 
        {
            txtbx_CeilingHeight().sendKeys(ceilingHeight);
            AutomationLog.info("CeilingHeight is set to:" +ceilingHeight );
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to set Frontage to:" +ceilingHeight);
            throw e;
        }
    }

    public void clearCeilingHeight() throws Exception
    {
        try 
        {
            txtbx_CeilingHeight().clear();
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to clear CeilingHeight");
            throw (e);
        }
    }
}
