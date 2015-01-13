package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.upsellpopups.ListingDetailPage;
import com.agorafy.automation.pageobjects.upsellpopups.LoginPopUp;

import java.util.List;

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

    public WebElement searchResultsList() throws Exception
    {
        try
        {
            driver.findElement(By.id("resultsLineItems"));
            AutomationLog.info("Results container found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Results container Not found");
        }
        return element;
    }

    public WebElement searchResultsResultSet() throws Exception
    {
        try
        {
            element=driver.findElement(By.className("resultsSet"));
            AutomationLog.info("Result set is returned");
        }
        catch(Exception e)
        {
            AutomationLog.error("Result set returned is NULL");
        }
        return element;
    }

    public List<WebElement> searchResultsReturned() throws Exception
    {
        List<WebElement> elements = null;
        try
        {
            elements = searchResultsResultSet().findElements(By.tagName("li"));
            System.out.println(element);
        }
        catch(Exception e)
        {
            AutomationLog.error("Unable to locate result thumbnail");
        }
        return elements;
    }

    public ListingDetailPage clickSearchResult() throws Exception
    {
        ListingDetailPage listingPage = null;
        List<WebElement> imageThumbnail = null;
        WebElement listings = null;
        try
        {
            listings = searchResultsReturned().get(0).findElement(By.tagName("div"));
            imageThumbnail = listings.findElements(By.tagName("div"));
            imageThumbnail.get(0).findElement(By.tagName("a")).click();
            listingPage = new ListingDetailPage(driver);
            //System.out.println("Clicked on the first result of the result set returned");
        }
        catch(Exception e)
        {
            System.out.println("Could not perform click operation");
        }
        return listingPage;
    }
}


/*package com.agorafy.automation.pageobjects;

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
}
*/