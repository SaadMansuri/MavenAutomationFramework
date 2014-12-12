package com.agorafy.automation.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;

public class PropertySearch extends Page
{
    private WebElement element=null;

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
        txtbx_BedsInAdvanceSearchForm().sendKeys(val);
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
 
    public String NoOfBedsInPropertiesSearch() throws Exception
    {
        String number = null;
        number = FilterText_Beds().getText();
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
            AutomationLog.info("Title found on login pop up");
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
    
    public void BedsInAdvanceSearchForm(String bathNo) throws Exception
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
}
