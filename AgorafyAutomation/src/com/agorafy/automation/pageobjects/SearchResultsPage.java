package com.agorafy.automation.pageobjects;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.subnavigationmenu.MySubscriptions;
import com.agorafy.automation.pageobjects.upsellpopups.ListingDetailPage;
import com.agorafy.automation.pageobjects.upsellpopups.LoginPopUp;


public class SearchResultsPage extends Page
{
    private WebElement element = null;
    private List<WebElement> elements = null;

    public SearchResultsPage(WebDriver driver)
    {
        super(driver);
    }

    protected boolean isSecured()
    {
        return true;
    }


    public WebElement link_SubscribeToThisSearch() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("subscribeCalloutContainer")).findElement(By.tagName("a"));
            AutomationLog.info("Found link Subscribe to this search ");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found link Subscribe to this search ");
            throw(e);
        }
        return element;
    }

    public WebElement title_SearchResult() throws Exception 
    {
        try
        {
            element = driver.findElement(By.className("page-header-section")).findElement(By.className("page-title"));
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
            element = getVisibleElement(By.id("createProfileButton"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Create Profile Button");
            throw(e);
        }
        return element;
    }

    public boolean isCreateYourProfileButtonPresent() throws Exception
    {
        boolean val = false;
        val = driver.findElements(By.id("createProfileButton")).size() > 0;
        return val;
    }

    public WebElement FilterText_Size() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//a[@data-filtertarget='size']"));
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
            element = driver.findElement(By.xpath("//a[@data-filtertarget='numBeds']"));
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
            element = driver.findElement(By.xpath("//a[@data-filtertarget='price']"));
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
        String title = null;
        try
        {
            title = loginpopup.title_LoginPopUp().getText();
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
            val = loginpopup.popUp_Login().isDisplayed();
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

    public WebElement icon_PinCushionReport() throws Exception
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

    public void clickOnPinCushionReportIcon() throws Exception
    {
        try
        {
            icon_PinCushionReport().click();
            AutomationLog.info("Successfully clicked on PinCushionReport icon");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on PinCushionReport icon");
            throw(e);
        }
    }

    public void hoverOnPinCushionReportIcon() throws Exception
    {
        Actions builder = new Actions(driver);
        Action hover = builder.moveToElement(icon_PinCushionReport()).build();
        WaitFor.sleepFor(1000);
        hover.perform();
        AutomationLog.info("Successfully hovered on PinCushionReport icon");
    }

    public By Tooltiplocator() throws Exception
    {
        return By.className("Zebra_Tooltip_Message");
    }

    public WebElement tooltip_PinCushionReport() throws Exception
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
        WaitFor.sleepFor(1000);
        hover.perform();
    }

    public WebElement tile_Searchresult(int index) throws Exception
    {
        return resultSetListings().get(index);
    }

    public void hoverOnSearchResult(int index) throws Exception
    {
        Actions builder = new Actions(driver);
        Action hover = builder.moveToElement(tile_Searchresult(index)).build();
        WaitFor.sleepFor(1000);
        hover.perform();
    }

    public WebElement icon_PinCushion(int index) throws Exception
    {
        return tile_Searchresult(index).findElement(By.className("pinCushion")).findElement(By.tagName("a"));
    }

    public void hoverAndClickOnPincushionIcon(int index) throws Exception 
    {
        Actions builder = new Actions(driver);
        Action hover = builder.moveToElement(icon_PinCushion(index)).build();
        WaitFor.sleepFor(1000);
        hover.perform();
        icon_PinCushion(index).click();
        AutomationLog.info("Successfully hovered And Clicked PinCushionReport icon");
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

    public List<WebElement> resultSetListings() throws Exception
    {
        List<WebElement> list = new ArrayList<WebElement>();
        for(WebElement element : resultSet())
        {
            if(element.isDisplayed())
            {
                list.add(element);
            }
        }
        return list;
    }

    public int getResultSetListingsConut() throws Exception
    {
        return resultSetListings().size();
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

    public WebElement noResultsErrorMsg() throws Exception 
    {
        try 
        {
            element = driver.findElement(By.className("result-error-msg"));
        } 
        catch (Exception e) 
        {
            AutomationLog.error("Failed to find no results error msg");
        }
        return element; 
    }

    public String noOfSearchResults() throws Exception 
    {
        String noOfSearchResults;
        noOfSearchResults = element_NoOfSearchResults().getText();
        return noOfSearchResults;
    }

    public WebElement searchResultsContainer() 
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

    public Page selectFirstListingOnPropertySearchPage(boolean multipleListingStatus) 
    {
        Page page = null;
        clickSearchResult();
        if(multipleListingStatus)
        {
            page = new IntermidiatePage(driver);
            AutomationLog.info("Since more than one listings present on this property, intermidiate page is opened");
        }
        else
        {
            page = new ListingDetailPage(driver);
            AutomationLog.info("Since only one listing is present on this property, listing details page is opened");
        }
        return page;
    }

    public boolean checkForMultiplelistingsInFirstProperty() throws Exception
    {
        boolean multipleListingsStatus = false;
        try 
        {
            element = resultSet().get(0);
            if(element.findElements(By.className("listing-badge")).size()>0)
            {
                multipleListingsStatus = true;
            }
            else
            {
                multipleListingsStatus = false;
            }
        }
        catch (Exception e) 
        {
            AutomationLog.error("Checking whether multiple listings are present in selected property failed");
            throw (e);
            
        }
        return multipleListingsStatus;
    }

    public WebElement popup_ErrorDialog() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("errorDialog"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find error dialog pop up");
            throw(e);
        }
        return element;
    }

    public boolean checkMultipleListings(int index) throws Exception
    {
        boolean val;
        try
        {
            if(tile_Searchresult(index).findElements(By.className("listing-badge")).size()>0)
            {
                val = true;
            }
            else 
            {
                val = false;
            }
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not perform check for multiple listings ");
            throw(e);
        }
        return val;
    }

    public WebElement Listing_Badge(int index) throws Exception 
    {
        try
        {
            element = tile_Searchresult(index).findElement(By.className("listing-badge"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Listing badge ");
            throw(e);
        }
        return element;
    }

    public int getListingBadgeCount(int index) throws Exception
    {
        String text = Listing_Badge(index).getText();
        String retext = text.replaceAll(" Listings", "");
        int count = Integer.parseInt(retext);
        return count;
    }

    public WebElement icon_CloseOnErrorDialogPopup() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("ui-dialog-titlebar-close"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Close icon on ErrorDialog PopUp");
            throw(e);
        }
        return element;
    }

    public void clickCloseIconOnErrorDialogPopUp() throws Exception
    {
        try
        {
            icon_CloseOnErrorDialogPopup().click();
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on close icon on Error dialog popup");
            throw(e);
        }
    }

    public List<WebElement> view_ToggleButtons() throws Exception
    {
        List<WebElement> list = new ArrayList<WebElement>();
        element = getVisibleElement(By.className("view-toggle"));
        list = element.findElements(By.tagName("button"));
        return list;
    }

    public WebElement btn_AnalyticsView() throws Exception
    {
        try
        {
            element = view_ToggleButtons().get(0);
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Analytics View button");
            throw(e);
        }
        return element;
    }

    public WebElement btn_ListView() throws Exception
    {
        try
        {
            element = view_ToggleButtons().get(1);
       }
        catch(Exception e)
        {
            AutomationLog.error("Could not find List View button");
            throw(e);
        }
        return element;
    }

    public WebElement btn_MapView() throws Exception
    {
        try
        {
            element = view_ToggleButtons().get(2);
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Map View button");
            throw(e);
        }
        return element;
    }

    public Page clickOnAnalyticsViewButton(boolean isLoggedIn) throws Exception
    {
        Page obj = null;
        try
        {
            btn_AnalyticsView().click();
            if(isLoggedIn)
            {
                obj = new SearchResultsPage(driver);
            }
            else
            {
                obj = new LoginPopUp(driver);
            }
            AutomationLog.info("Successfully clicked on Analytics View button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Analytics view button");
            throw(e);
        }
        return obj;
    }

    public void clickOnMapViewButton() throws Exception 
    {
        try
        {
            btn_MapView().click();
            AutomationLog.info("Successfully clicked on Map View button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Map view button");
            throw(e);
        }
    }

    public void clickOnListViewButton() throws Exception
    {
        try
        {
            btn_ListView().click();
            AutomationLog.info("Successfully clicked on List View button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on List view button");
            throw(e);
        }
    }

    public boolean isAnalyticsViewButtonPresent() throws Exception 
    {
        boolean val;
        try
        {
            element = driver.findElement(By.className("btn-group"));
            val = element.findElements(By.className("fa-line-chart")).size() > 0;
        }
        catch(Exception e)
        {
            throw(e);
        }
        return val;
    }

    public boolean isMapViewButtonPresent() throws Exception 
    {
        boolean val;
        try
        {
            element = driver.findElement(By.className("btn-group"));
            val = element.findElements(By.className("fa-map-marker")).size() > 0;
        }
        catch(Exception e)
        {
            throw(e);
        }
        return val;
    }

    public boolean isListViewButtonPresent() throws Exception 
    {
        boolean val;
        try
        {
            element = driver.findElement(By.className("btn-group"));
            val = element.findElements(By.className("fa-list")).size() > 0;
        }
        catch(Exception e)
        {
            throw(e);
        }
        return val;
    }

    public WebElement FilterSize_SquareFeet_From() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("sqft-range")).findElement(By.className("irs-from"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Filter square feet from");
            throw(e);
        }
        return element;
    }

    public WebElement FilterSize_SquareFeet_To() throws Exception
    {
         try
         {
             element = driver.findElement(By.className("sqft-range")).findElement(By.className("irs-to"));
         }
         catch(Exception e)
         {
             AutomationLog.error("Could not find Filter square feet to");
             throw(e);
         }
         return element;
    }

    public WebElement FilterPrice_From() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("price-range")).findElement(By.className("irs-from"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Filter square feet from");
            throw(e);
        }
        return element;
    }

    public WebElement FilterPrice_To() throws Exception
    {
         try
         {
             element = driver.findElement(By.className("price-range")).findElement(By.className("irs-to"));
         }
         catch(Exception e)
         {
             AutomationLog.error("Could not find Filter square feet to");
             throw(e);
         }
         return element;
    }

    public String getCurrentUrl() throws Exception
    {
        return driver.getCurrentUrl();
    }

    public Map<String, String> getQueryMap(String query)  
   {  
       String[] quryparams = query.split("\\?"); 
       String[] params = quryparams[1].split("&");  
       Map<String, String> map = new HashMap<String, String>();  
       for (String param : params)  
       {  String [] p=param.split("=");
           String name = p[0];  
           if(p.length>1)
           {
               String value = p[1];  
               map.put(name, value);
           }   
       }  
       return map;  
   }

    public WebElement btn_Exports() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("exportAnalytics"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Exports button");
            throw(e);
        }
        return element;
    }

    public void clickOnExportsButton() throws Exception 
    {
        try
        {
            btn_Exports().click();
            AutomationLog.info("Successfully clicked on Exports button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Exports button");
            throw(e);
        }
    }

    public WebElement div_Advertisement() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("advDiv")).findElement(By.className("adDescriptor"));
            AutomationLog.info("Advertisement div found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Advertisement div");
            throw(e);
        }
        return element;
    }

    public String getApplicationUrl() throws Exception 
    {
        return applicationUrl();
    }

}
