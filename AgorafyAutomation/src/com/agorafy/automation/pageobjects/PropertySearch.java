package com.agorafy.automation.pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.agorafy.automation.automationframework.AutomationLog;
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
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div/ul/li[1]/div/h2"));
            AutomationLog.info("title found on Search Result page");
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not found title on Search result page");
            throw(e);
        }
        return element;
    }

    public WebElement icon_AdvanceSearchDropDown() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("advancedSearch"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find AdvanceSearch Dropdown icon ");
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

    public void clickOnCreateProfileButton() throws Exception
    {
        try
        {
            btn_CreateYourProfile().click();
            AutomationLog.info("Successfully clicked on Create Profile Button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Create Profile Button");
            throw(e);
        }
    }

    public void clickOnAdvanceSearchDropDownIcon() throws Exception
    {
        try
        {
            icon_AdvanceSearchDropDown().click();
            AutomationLog.info("Successfully clicked on AdvanceSearch DropDown icon");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on AdvanceSearch DropDown icon");
        }
        
    }

    public WebElement txtbx_BedsInAdvanceSearchForm() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("bedsInput"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Textbox for beds in advance search form    ");
            throw(e);
        }
        return element;
    }

    public WebElement btn_SearchOnAdvanceSearchForm() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("searchFormAdvancedButton"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find search button on advance search form");
            throw(e);
        }
        return element;
    }

    public void clickOnSearchButtonOnAdvanceSearchform() throws Exception
    {

        try
        {
            btn_SearchOnAdvanceSearchForm().click();
            AutomationLog.info("Successfully clicked on Search button on Advanced search form");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not click on Search button on Advanced search form");
            throw(e);
        }
    }

    public void searchByNoOfBeds(String val) throws Exception
    {
        clickOnAdvanceSearchDropDownIcon();
        txtbx_BedsInAdvanceSearchForm().clear();
        txtbx_BedsInAdvanceSearchForm().sendKeys(val);
        AutomationLog.info("Successfully entered Search text for no of beds ");
        clickOnSearchButtonOnAdvanceSearchform();
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

    public void searchByNoOfBaths(String val) throws Exception
    {
        clickOnAdvanceSearchDropDownIcon();
        txtbx_BathInAdvanceSearchForm().clear();
        txtbx_BathInAdvanceSearchForm().sendKeys(val);
        AutomationLog.info("Successfully entered Search text for no of baths ");
        clickOnSearchButtonOnAdvanceSearchform();
    }

    public String NoOfBathsInPropertiesSearch() throws Exception
    {
        String number = null;
        number = FilterText_Bath().getText();
        return number;
        
    }
    public void clickOnSubscribeToThisSearchLink() throws Exception
    {
        try
        {
            link_SubscribeToThisSearch().click();
            AutomationLog.info("Successfully clicked on Subscribe to this search link ");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not clicked on Subscribe to this search link");
            throw(e);
        }
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

    public WebElement title_LoginPopUp() throws Exception
    {
        try
        {
            element=driver.findElement(By.id("ui-dialog-title-upsellPopup"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found title on login pop up");
            throw(e);
        }
        return element;
    }

    public String getTitleForLoginPopUp() throws Exception
    {
        String title=null;
        try
        {
            title=title_LoginPopUp().getText();
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
    
    public WebElement txtbx_BathInAdvanceSearchForm() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("bathsInput"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Textbox for beds in advance search form    ");
            throw(e);
        }
        return element;
    }
    
    public void BathInAdvanceSearchForm(String bathNo) throws Exception
    {
        try
        {
            txtbx_BathInAdvanceSearchForm().sendKeys(bathNo);
            AutomationLog.error("Could put the "+bathNo+"number of both");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not put the "+bathNo+"number of both");
            throw(e);
        }
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
            element = driver.findElement(By.xpath("//div[@class='loadingMessage'][contains(text(),'No results found')]"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not loadingMessage om Property Search section");
            throw(e);
        }
        return element;
    }
    
    public void BedsInAdvanceSearchForm(String badNo) throws Exception
    {
        try
        {
        	txtbx_BedsInAdvanceSearchForm().sendKeys(badNo);
            AutomationLog.error("Could put the "+badNo+"number of both");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not put the "+badNo+"number of both");
            throw(e);
        }
    }

    public WebElement icon_AddToReport() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("prop-14289"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not found AddToReport icon");
            throw(e);
        }
        return element;
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

}
