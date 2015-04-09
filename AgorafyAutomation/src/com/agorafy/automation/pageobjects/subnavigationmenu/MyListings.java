package com.agorafy.automation.pageobjects.subnavigationmenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.UpdateListing;
import com.agorafy.automation.pageobjects.submitlisting.SubmitListingMediaFormPage;

public class MyListings extends Page 
{
    WebElement element;

    public MyListings(WebDriver driver) 
    {
        super(driver);
    }	

    public WebElement MyListingsContentBlock() throws Exception
    {
        try 
        {
            element = driver.findElement(By.className("content-block tabContainer"));
            AutomationLog.info("My listings content block found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find my listings content block");
            throw (e);
        }
        return element;
    }

    public WebElement link_OnMarket() throws Exception
    {
        try 
        {
            element = MyListingsContentBlock().findElement(By.linkText("On-market")); 
            AutomationLog.info("My listings On-market link found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find My listings On-market link");
            throw (e);
        }
        return element;
    }

    public WebElement link_OffMarket() throws Exception
    {
        try 
        {
            element = MyListingsContentBlock().findElement(By.linkText("Off-market")); 
            AutomationLog.info("My listings Off-market link found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find My listings Off-market link");
            throw (e);
        }
        return element;
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

    public WebElement firstOnMarketListing() throws Exception
    {
        WebElement parent;
        WebElement child;
        try 
        {
           parent = driver.findElement(By.id("DataTables_Table_0")).findElement(By.tagName("tbody"));
           child = parent.findElements(By.tagName("tr")).get(0);
           element = child.findElements(By.tagName("td")).get(0);
           AutomationLog.info("first On Market Listing found");
        }
        catch (Exception e)
        {
            AutomationLog.error("failed to find first On Market Listing");
            throw (e);
        }
        return element;
    }

    public String txt_FirstListing() throws Exception
    {
        String firstListing = null;
        try
        {
           element = firstOnMarketListing().findElement(By.className("listing-details")).findElement(By.tagName("h4"));
           firstListing = element.getText();
           AutomationLog.info("Sucessfully found txt of first listing");
        }
        catch (Exception e)
        {
            AutomationLog.error("failed to found txt of first listing");
            throw (e);
        }
        return firstListing;
    }

    public WebElement hoverOverFirstListing() throws Exception
    {
        try
        {
           
           Actions actions = new Actions(driver);
           element = firstOnMarketListing();
           actions.moveToElement(element).build().perform();;
           AutomationLog.info("Sucessfully performed mouse hovering over first listing");
        }
        catch (Exception e)
        {
            AutomationLog.error("failed to perform mouse hovering over first listing");
            throw (e);
        }
        return element;
    }

    public WebElement hoverOverUpdate() throws Exception
    {
        try
        {
           Actions actions = new Actions(driver);
           element = updateListing();
           WaitFor.sleepFor(2000);
           actions.moveToElement(element).build().perform();
           AutomationLog.info("Sucessfully performed mouse hovering over update");
        }
        catch (Exception e)
        {
            AutomationLog.error("failed to perform mouse hovering over update");
            throw (e);
        }
        return element;
    }

    public WebElement hoverOverReportLeased() throws Exception
    {
        try
        {
           Actions actions = new Actions(driver);
           element = reportLeased();
           WaitFor.sleepFor(2000);
           actions.moveToElement(element).build().perform();
           AutomationLog.info("Sucessfully performed mouse hovering over Report Leased");
        }
        catch (Exception e)
        {
            AutomationLog.error("failed to perform mouse hovering over Report Leased");
            throw (e);
        }
        return element;
    }

    public WebElement updateListing() throws Exception
    {
        WebElement parent;
        try
        {
           parent = firstOnMarketListing().findElement(By.className("listing-details")).findElement(By.className("listing-actions"));
           element = parent.findElements(By.tagName("a")).get(0);
           AutomationLog.info("Sucessfully found update link on first listing");
        }
        catch (Exception e)
        {
            AutomationLog.error("failed to found update link on first listing");
            throw (e);
        }
        return element;
    }

    public WebElement reportLeased() throws Exception
    {
        WebElement parent;
        try
        {
           parent = firstOnMarketListing().findElement(By.className("listing-details")).findElement(By.className("listing-actions"));
           element = parent.findElement(By.className("report-leased"));
           AutomationLog.info("Sucessfully found Report Leased link on first listing");
        }
        catch (Exception e)
        {
            AutomationLog.error("failed to found Report Leased link on first listing");
            throw (e);
        }
        return element;
    }

    public WebElement renew() throws Exception
    {
        WebElement parent;
        try
        {
           parent = firstOnMarketListing().findElement(By.className("listing-details")).findElement(By.className("listing-actions"));
           element = parent.findElement(By.className("renew"));
           AutomationLog.info("Sucessfully found Renew link on first listing");
        }
        catch (Exception e)
        {
            AutomationLog.error("failed to found Renew link on first listing");
            throw (e);
        }
        return element;
    }

    public WebElement addMedia() throws Exception
    {
        WebElement parent;
        try
        {
           parent = firstOnMarketListing().findElement(By.className("listing-details")).findElement(By.className("listing-actions"));
           element = parent.findElement(By.className("add-media"));
           AutomationLog.info("Sucessfully found Add Media link on first listing");
        }
        catch (Exception e)
        {
            AutomationLog.error("failed to found Add Media link on first listing");
            throw (e);
        }
        return element;
    }

    public UpdateListing clickUpdateOfFirstListing() 
    {
        UpdateListing updateListingPage = null;
        try 
        {
             Actions actions = new Actions(driver);
             actions.moveToElement(updateListing()).click().build().perform();
             updateListingPage = new UpdateListing(driver);
             AutomationLog.info("Sucessfully clicked update link found after hovering over first listing");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to click update link found after hovering over first listing");
        }
        return updateListingPage;
    }

    public SubmitListingMediaFormPage clickAddMediaOfFirstListing() 
    {
        SubmitListingMediaFormPage mediaPage = null;
        try 
        {
             Actions actions = new Actions(driver);
             actions.moveToElement(addMedia()).click().build().perform();
             mediaPage = new SubmitListingMediaFormPage(driver);
             AutomationLog.info("Sucessfully clicked Add Media link found after hovering over first listing");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to click Add Media link found after hovering over first listing");
        }
        return mediaPage;
    }

    public List<WebElement> allListingElements() 
    {
        List<WebElement> allListingElements = new ArrayList<>();
        WebElement parent;
        try 
        {
            parent = driver.findElement(By.id("DataTables_Table_0")).findElement(By.tagName("tbody"));
            allListingElements = parent.findElements(By.tagName("tr"));
            AutomationLog.info("All listing elements are located successfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to locate all listing elements");
        }
        return allListingElements;
    }

    public HashMap<String, String> allListingTypes() 
    {
        HashMap<String, String> allListingTypes = new HashMap<>();
        List<WebElement> allListingElements = new ArrayList<>();
        WebElement parent;
        try 
        {
            allListingElements = allListingElements();
            String listingName = null;
            String listingType = null;
            for(WebElement singleListing : allListingElements)
            {
                 parent = singleListing.findElements(By.tagName("td")).get(0);
                 element = parent.findElements(By.tagName("div")).get(1);
                 listingName = element.findElement(By.tagName("h4")).findElement(By.tagName("a")).getText();
                 element = singleListing.findElements(By.tagName("td")).get(1);
                 listingType = element.findElement(By.tagName("div")).getText();
                 allListingTypes.put(listingType,listingName);
            }
            AutomationLog.info("Successfully got all listing types on My Listings page");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to get all listing types on My Listings page");
        }
        return allListingTypes;
    }

    public void clickThisListingsUpdate(WebElement singleListing) 
    {
        WebElement parent;
        WebElement update;
        Actions hover = new Actions(driver);
        try 
        {
            parent = singleListing.findElements(By.tagName("td")).get(0);
            element = parent.findElements(By.tagName("div")).get(1);
            update = element.findElement(By.id("update"));
            pageScrollDown(0, singleListing.getLocation().getX());
            hover.moveToElement(singleListing);
            hover.moveToElement(update).click().build().perform();
            AutomationLog.info("Successfully clicked single listings update");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to click single listings update");
        }
    }

    public String getSingleListingName(WebElement singleListing) 
    {
        WebElement parent;
        WebElement name;
        String listingName = null;
        try 
        {
            parent = singleListing.findElements(By.tagName("td")).get(0);
            element = parent.findElements(By.tagName("div")).get(1);
            name = element.findElement(By.tagName("h4"));
            listingName = name.findElement(By.tagName("a")).getText();
            AutomationLog.info("Successfully got selected listings name");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to get selected listings name");
        }
        return listingName;
    }

    public UpdateListing selectRequiredListingsUpdate(String expectedListingName)
    {
        List<WebElement> allListingElements = new ArrayList<>();
        String actualListingName;
        UpdateListing updateListingPage = null;
        try
        {
            allListingElements = allListingElements();
            for(WebElement singleListing : allListingElements)
            {
                actualListingName = getSingleListingName(singleListing);
                if(actualListingName.equals(expectedListingName))
                {
                    clickThisListingsUpdate(singleListing);
                    updateListingPage = new UpdateListing(driver);
                    break;
                }
            }
            AutomationLog.info("Successfully selected required listing depending upon listing type");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to select required listing depending upon listing type");
        }
        return updateListingPage;
    }

    public String getURL()
    {
        return applicationUrl() + "/manage/listings/";
    }

    public String pageHeading() throws Exception
    {
        return element_PageHeading().getText();
    }

}
