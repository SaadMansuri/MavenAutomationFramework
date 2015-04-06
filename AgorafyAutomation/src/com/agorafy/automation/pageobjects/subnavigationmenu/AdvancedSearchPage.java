package com.agorafy.automation.pageobjects.subnavigationmenu;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.SearchResultsPage;

public class AdvancedSearchPage extends Page
{
    WebElement element;
    public AdvancedSearchPage(WebDriver driver)
    {
        super(driver);
    }

    public WebElement pageHeadingElement() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("page-desc"));
            AutomationLog.info("Advanced Search page - heading is found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Advanced Search page - heading is not found");
            throw(e);
        }
        return element;
    }

    public void selectBorough(String boroughname) throws Exception
    {
        Select boroughs = new Select(driver.findElement(By.id("borough")));
        boroughs.selectByVisibleText(boroughname);
    }

    public List<String> listingType() throws Exception
    {
        List<String> list = new ArrayList<String>();
        Select ele = new Select(driver.findElement(By.id("offeringType")));
        List<WebElement> els = ele.getOptions();
        for(WebElement opt : els)
        {
             list.add(opt.getText());
        }
        return list;
        
    }

    public void selectListingType(String listingtype) throws Exception
    {
        Select type = new Select(driver.findElement(By.id("offeringType")));
        type.selectByVisibleText(listingtype);
    }

    public void selectPropertyType(String propertytype) throws Exception
    {
        Select type = new Select(driver.findElement(By.id("propertyType")));
        type.selectByVisibleText(propertytype);
    }

    public void selectPriceType(String pricetype) throws Exception
    {
         Select type = new Select(driver.findElement(By.id("priceType")));
        type.selectByVisibleText(pricetype);
    }

    public List<String> priceType() throws Exception
    {
        List<String> list = new ArrayList<String>();
        Select ele = new Select(driver.findElement(By.id("priceType")));
        List<WebElement> els = ele.getOptions();
        for(WebElement opt : els)
        {
             list.add(opt.getText());
        }
        return list;
        
    }

    public WebElement radiobtn_Commercial() throws Exception
    {
        try 
        {
            element = driver.findElement(By.xpath(".//*[@id='advancedSearchFormContainer']/div[2]/label[1]/input"));
        } 
        catch (Exception e) 
        {
            AutomationLog.error("Could not find radio button for commercial listing");
            throw(e);
        }
        return element;
    }

    public WebElement radiobtn_Residential() throws Exception
    {
        try 
        {
            element = driver.findElement(By.xpath(".//*[@id='advancedSearchFormContainer']/div[2]/label[2]/input"));
        } 
        catch (Exception e) 
        {
            AutomationLog.error("Could not find radio button for residential listing");
            throw(e);
        }
        return element;
    }

    public void clickOnCommercialRadioButton() throws Exception
    {
        try 
        {
            radiobtn_Commercial().click();
            AutomationLog.info("Successfully clicked on Commercial radio butoon");
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not click on Commercial radio button");
            throw(e);
        }
    }

    public void clickOnResidentialRadioButton() throws Exception
    {
        try 
        {
            radiobtn_Residential().click();
            AutomationLog.info("Successfully clicked on Residential radio butoon");
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not click on Residential radio button");
            throw(e);
        }
    }

    public WebElement dropdown_PropertyType() throws Exception
    {
        try 
        {
            element = driver.findElement(By.xpath(".//*[@id='advancedSearchFormContainer']/div[5]"));
            AutomationLog.info("PropertyType drop down is found");
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not find drop down for PropertyType");
            throw(e);
        }
        return element;
    }

    public WebElement txtbx_SearchInput() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("searchInput"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not find Search Input text box");
            throw(e);
        }
        return element;
    }

    public WebElement txtbx_SizeInput() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("sizeInput"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not find Size Input text box");
            throw(e);
        }
        return element;
    }

    public WebElement txtbx_Price() throws Exception
    {
        try
        {
            element = driver.findElement(By.name("price"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not find Price text box");
            throw(e);
        }
        return element;
    }

    public WebElement txtboxes_BedsNBaths() throws Exception
    {
        try 
        {
            element = driver.findElement(By.cssSelector(".row.clearfix.residential-only"));
            AutomationLog.info("Text boxes for Beds and Baths found");
        }
        catch (Exception e)
        {
            AutomationLog.error("could not find text boxes for Beds and Baths");
            throw(e);
        }
        return element;
    }

    public WebElement txtbx_BedsInput() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("bedsInput"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Textbox for Beds ");
            throw(e);
        }
        return element;
    }

    public WebElement txtbx_BathsInput() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("bathsInput"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Textbox for Baths");
            throw(e);
        }
        return element;
    }

    public void searchByNoOfBeds(String val) throws Exception
    {
        txtbx_BedsInput().clear();
        txtbx_BedsInput().sendKeys(val);
        AutomationLog.info("Successfully entered Search text for no of beds ");
    }

    public void searchByNoOfBaths(String val) throws Exception
    {
        txtbx_BathsInput().clear();
        txtbx_BathsInput().sendKeys(val);
        AutomationLog.info("Successfully entered Search text for no of baths ");
    }

    public WebElement btn_Search() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("searchFormAdvancedButton"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not find Search button");
            throw(e);
        }
        return element;
    }

    public SearchResultsPage clickOnSearchButton() throws Exception
    {
        SearchResultsPage search = null;
        try
        {
            btn_Search().click();
            search = new SearchResultsPage(driver);
            AutomationLog.info("Successfully clicked on search button");
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not click on search button");
            throw(e);
        }
        return search;
    }

    public By getAutocompleteSearchListLocator() throws Exception
    {
       return By.className("ui-autocomplete");
    }

    public WebElement autoComplete_SearchBox() throws Exception
    {
        try
        {
            element = driver.findElement(getAutocompleteSearchListLocator());
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not find auto-complete box");
            throw(e);
        }
        return element;
    }

    public WebElement selected_PropertyType() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='advancedSearchFormContainer']/div[5]/span/span"));
        }
        catch(Exception e)
        {
           AutomationLog.error("Could not find selected property type");
           throw(e);
        }
        return element;
    }

    public WebElement selected_Borough() throws Exception
    {
    	try
        {
            element = driver.findElement(By.xpath(".//*[@id='advancedSearchFormContainer']/div[1]/span/span"));
        }
        catch(Exception e)
        {
           AutomationLog.error("Could not find selected borough");
           throw(e);
        }
        return element;
    }

    public WebElement selected_ListingType() throws Exception 
    {
    	 try
         {
             element = driver.findElement(By.xpath(".//*[@id='advancedSearchFormContainer']/div[4]/span/span"));
         }
         catch(Exception e)
         {
            AutomationLog.error("Could not find selected Listing type");
            throw(e);
         }
         return element;
    }

    public List<WebElement> list_AutoCompleteSearch() throws Exception 
    {
        return autoComplete_SearchBox().findElements(By.className("ui-menu-item"));
    }

    public WebElement getFirstSearchSuggestionFromAutoCompleteList() throws Exception
    {
        try
        {
            element = list_AutoCompleteSearch().get(0).findElement(By.tagName("a"));
        }
        catch(Exception e)
        {
           AutomationLog.error("Could not get first search suggestion form autocomplete list");
           throw(e);
        }
        return element;
    }

    public void clickOnFirstSearchSuggestionFromAutoCompleteList() throws Exception 
    {
        try
        {
            
            getFirstSearchSuggestionFromAutoCompleteList().click();
            AutomationLog.info("Successfully clicked on First Search Suggestion From AutoComplete List");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on First Search Suggestion From AutoComplete List");
            throw(e);
        }
    }

    @Override
    public String pageHeading() throws Exception
    {
        return pageHeadingElement().getText();
    }

    public String getURL()
    {
        return applicationUrl() + "/search/advancedsearch/";
    }
}
