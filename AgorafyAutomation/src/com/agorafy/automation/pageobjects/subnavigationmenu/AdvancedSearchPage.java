package com.agorafy.automation.pageobjects.subnavigationmenu;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.PropertySearch;

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
            AutomationLog.error("Could not found radio button for commercial listing");
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
            AutomationLog.error("Could not found radio button for residential listing");
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
            AutomationLog.info("Successfully clicked on residential radio butoon");
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not click on residential radio button");
            throw(e);
        }
    }

    public WebElement dropdown_ResidentialOnly() throws Exception
    {
        try 
        {
            element = driver.findElement(By.xpath(".//*[@id='advancedSearchFormContainer']/div[5]"));
            AutomationLog.info("Drop down for Residential Only is found");
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not found drop down for residential only");
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
            AutomationLog.error("Could not fould Search Input text box");
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
            AutomationLog.error("Could not fould Size Input text box");
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
            AutomationLog.error("Could not fould Price text box");
            throw(e);
        }
        return element;
    }

    public WebElement txtboxes_ResidentialOnly() throws Exception
    {
        try 
        {
            element = driver.findElement(By.cssSelector(".row.clearfix.residential-only"));
            AutomationLog.info("Residential Only text boxes found");
        }
        catch (Exception e)
        {
            AutomationLog.error("could not fould text boxes for residential only");
            throw(e);
        }
        return element;
    }

    public WebElement btn_Search() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("searchFormAdvancedButton"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not fould Search button");
            throw(e);
        }
        return element;
    }

    public PropertySearch clickOnSearchButton() throws Exception
    {
        PropertySearch search = null;
        try
        {
            btn_Search().click();
            search = new PropertySearch(driver);
            AutomationLog.info("Successfully clicked on search button");
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not click on search button");
            throw(e);
        }
        return search;
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
