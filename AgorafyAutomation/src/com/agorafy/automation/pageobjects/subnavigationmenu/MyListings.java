package com.agorafy.automation.pageobjects.subnavigationmenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Page;

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

    public void clickUpdateOfFirstListing() 
    {
        try 
        {
             Actions actions = new Actions(driver);
             actions.moveToElement(updateListing()).click().build().perform();
             AutomationLog.info("Sucessfully clicked update link found after hovering over first listing");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to click update link found after hovering over first listing");
        }
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
