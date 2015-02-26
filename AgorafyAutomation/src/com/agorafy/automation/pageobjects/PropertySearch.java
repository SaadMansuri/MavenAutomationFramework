package com.agorafy.automation.pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.subnavigationmenu.MySubscriptions;
import com.agorafy.automation.pageobjects.upsellpopups.ListingDetailPage;
import com.agorafy.automation.pageobjects.upsellpopups.LoginPopUp;


public class PropertySearch extends Page
{
    private WebElement element=null;
    private List<WebElement> elements = null;

    public PropertySearch(WebDriver driver)
    {
        super(driver);
    }

    public WebElement link_SubscribeToThisSearch() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='subscribeCalloutContainer']/a"));
            AutomationLog.info("Found link Subscribe to this search ");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found link Subscribe to this search");
            throw(e);
        }
        return element;
    }

    public WebElement title_SearchResult() throws Exception 
    {
        try
        {
            element = driver.findElement(By.className("page-title"));
            AutomationLog.info("title found on Search Result page");
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not found title on Search result page");
            throw(e);
        }
        return element;
    }

    public WebElement btn_CreateYourProfile() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("createProfileButton"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Create Profile Button");
            throw(e);
        }
        return element;
    }

    public WebElement FilterText_Size() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("filterText"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not find Filter text for advance search(Size)");
            throw(e);
        }
        return element;
    }

    public LoginPopUp clickOnCreateProfileButton() throws Exception
    {
        LoginPopUp loginpopup = null;
        try
        {
            btn_CreateYourProfile().click();
            loginpopup = new LoginPopUp(driver);
            AutomationLog.info("Successfully clicked on Create Profile Button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Create Profile Button");
            throw(e);
        }
        return loginpopup;
    }

    public WebElement FilterText_Beds() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("filterText"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Filter text for advance search(Beds)");
            throw(e);
        }
        return element;
    }

    public WebElement FilterText_Price() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("filterText"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Filter text for advance search(Price)");
            throw(e);
        }
        return element;
    }

    public String NoOfBedsInPropertiesSearch() throws Exception
    {
        String number = null;
        number = FilterText_Beds().getText();
        return number;
        
    }

    public String NoOfBathsInPropertiesSearch() throws Exception
    {
        String number = null;
        number = FilterText_Bath().getText();
        return number;
        
    }

    public Page clickOnSubscribeToThisSearchLink(boolean loginstatus) throws Exception
    {
        Page page = null;
        try
        {
            link_SubscribeToThisSearch().click();
            if(loginstatus)
            {
                 page = new MySubscriptions(driver);
            }
            else
            {
                page = new LoginPopUp(driver);
            }
            AutomationLog.info("Successfully clicked on Subscribe to this search link ");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not clicked on Subscribe to this search link");
            throw(e);
        }
        return page;
    }


    public void closeLoginPoPup(LoginPopUp loginpopup) throws Exception
    {
        try
        {
            element = loginpopup.icon_CloseOnLoginPopUp();
            element.click();
            AutomationLog.info("Successfully closed Login Pop up");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not close Login Pop up ");
            throw(e);
        }
    }

    public String getTitleForLoginPopUp(LoginPopUp loginpopup) throws Exception
    {
        String title=null;
        try
        {
            title=loginpopup.title_LoginPopUp().getText();
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not get title for login pop up ");
            throw(e);
        }
        return title;
    }

    public boolean loginPopUpIsDisplayed(LoginPopUp loginpopup) throws Exception
    {
        boolean val;
        try
        {
            val=loginpopup.popUp_Login().isDisplayed();
            AutomationLog.info("login pop up is displayed");
        }
        catch(Exception e)
        {
            AutomationLog.error("Login pop up is not displayed");
            throw(e);
        }
        return val;
    }
    

    public WebElement FilterText_Bath() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//a[@data-filtertarget='numBaths']"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Textbox for bath in advance search form    ");
            throw(e);
        }
        return element;
    }

    public WebElement loadingMessage() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("loadingMessage"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not loadingMessage om Property Search section");
            throw(e);
        }
        return element;
    }

    public WebElement icon_AddToReport() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("pinCushion")).findElement(By.tagName("a"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not found AddToReport icon");
            throw(e);
        }
        return element;
    }

    public void clickOnAddToReportIcon() throws Exception
    {
        try
        {
            icon_AddToReport().click();
            AutomationLog.info("Successfully clicked on Add To Report icon");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Add To Report icon");
            throw(e);
        }
    }

    public void hoverOnAddToReportIcon() throws Exception
    {
        Actions builder = new Actions(driver);
        Action hover = builder.moveToElement(icon_AddToReport()).build();
        hover.perform();
    }

    public By Tooltiplocator() throws Exception
    {
        return By.className("Zebra_Tooltip_Message");
    }

    public WebElement tooltip_AddToReport() throws Exception
    {
        try
        {
            element = driver.findElement(Tooltiplocator());
            AutomationLog.info("tooltip  found");
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not found tooltip ");
            throw(e);
        }
        return element;
    }

    public WebElement tile_firstSearchResult() throws Exception
    {
        return resultSet().get(0);
    }

    public void hoverOnFirstSearchResultTile() throws Exception
    {
        Actions builder = new Actions(driver);
        Action hover = builder.moveToElement(tile_firstSearchResult()).build();
        hover.perform();
    }

    public ListingDetailPage clickSearchResult()
    {
        element = resultSet().get(0).findElement(By.className("caption")).findElement(By.tagName("a"));
        element.click();
        return new ListingDetailPage(driver);
    }

    public List<WebElement> resultSet()
    {
        elements = driver.findElement(By.className("resultsSet")).findElements(By.tagName("li"));
        return elements;
    }

    public WebElement element_NoOfSearchResults() throws Exception 
    {
        try 
        {
            element = driver.findElement(By.xpath(".//*[@id='resultsHeader']/div[1]/div/div[1]/p"));
        } 
        catch (Exception e) 
        {
            AutomationLog.error("Failed to find No Of Search Results element");
        }
        return element; 
    }

    public String noOfSearchResults() throws Exception 
    {
        String noOfSearchResults;
        noOfSearchResults = element_NoOfSearchResults().getText();
        return noOfSearchResults;
    }

    public WebElement element_SearchResultsContainer() 
    {
        try 
        {
            element = driver.findElement(By.id("resultsLineItems"));
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to find Search Results Container element");
        }
        return element;
    }

    public List<WebElement> elements_PropertyListings() 
    {
        List<WebElement> allPropertyListings = null;
        try 
        {
            WebElement parent = element_SearchResultsContainer().findElement(By.className("ul-reset"));
            allPropertyListings = parent.findElements(By.tagName("li"));
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to find all property listings elements");
        }
        return allPropertyListings;
    }

    public Page selectFirstListingOnPropertySearchPage(String destinationPage) 
    {
        Page page = null;
        List<WebElement> allPropertyListings;
        allPropertyListings = elements_PropertyListings();
        if(allPropertyListings != null)
        {
            for(WebElement element : allPropertyListings)
            {
                WebElement imageElement = element.findElement(By.tagName("img"));
                imageElement.click();
                break;
            }
        }
        switch (destinationPage)
        {
            case "IntermidiatePage":
            page = new IntermidiatePage(driver);
            AutomationLog.info("Since more than one listings present on this property, intermidiate page is opened");
            break;

            case "ListingDetailPage":
            page = new ListingDetailPage(driver);
            AutomationLog.info("Since only one listing is present on this property, listing details page is opened");
            break;
         }
        return page;
    }

    public boolean checkForMultiplelistingsInFirstProperty() throws Exception
    {
        boolean multipleListingsStatus = false;
        List<WebElement> allPropertyListings;
        try 
        {
            allPropertyListings = elements_PropertyListings();
            for(WebElement element : allPropertyListings)
                {
                    if(element.findElements(By.className("listing-badge")).size()>0)
                    {
                        multipleListingsStatus = true;
                    }
                    else
                    {
                        multipleListingsStatus = false;
                    }
                    break;
                }
        }
        catch (Exception e) 
        {
            AutomationLog.error("Checking whether multiple listings are present in selected property failed");
            throw (e);
            
        }
        return multipleListingsStatus;
    }

}
