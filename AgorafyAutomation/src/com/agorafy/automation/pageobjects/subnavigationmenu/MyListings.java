package com.agorafy.automation.pageobjects.subnavigationmenu;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.FrontEndShowings;
import com.agorafy.automation.pageobjects.Page;


public class MyListings extends Page 
{
    private WebElement element;
    private int count;

    public MyListings(WebDriver driver) 
    {
        super(driver);
    }	

    public void setCount(int cnt)
    {
        count = cnt;
    }

    public int getCount()
    {
        return count;
    }

    public WebElement MyListingsContentBlock() throws Exception
    {
        try 
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[2]"));
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
            element = MyListingsContentBlock().findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[2]/ul/li[1]/a")); 
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
            element = MyListingsContentBlock().findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[2]/ul/li[2]/a")); 
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
        try 
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[1]/h2")); 
            AutomationLog.info("My listing heading found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find My listings heading");
            throw (e);
        }
        return element;
    }

    public String getURL()
    {
        return applicationUrl() + "/manage/listings/";
    }

    public String pageHeading() throws Exception
    {
        return element_PageHeading().getText();
    }

    //Showings on my listings
    public WebElement listingsContainer() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("DataTables_Table_0")).findElement(By.tagName("tbody"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Couid not find listing container");
            throw(e);
        }
        return element;
    }

    public WebElement getListingName(String listingName) throws Exception
    {
        int cnt = -1;
        List<WebElement> list = new ArrayList<WebElement>();
        List<WebElement> list1 = new ArrayList<WebElement>();
        WebElement listingrow = null;
        list = listingsContainer().findElements(By.tagName("tr"));
        for(WebElement opt : list)
        {
            cnt++;
            list1 = opt.findElements(By.tagName("td"));
            element = list1.get(0).findElement(By.className("listing-details")).findElement(By.tagName("a"));
            if(element.getText().equals(listingName))
            {
                listingrow = opt;
                break;
            }
        }
        setCount(cnt);
        return listingrow;
    }

    public WebElement getShowingsLink(String listingName) throws Exception
    {
        element = getListingName(listingName).findElements(By.tagName("td")).get(2);
        WebElement showing = null;
        showing = element.findElement(By.tagName("a"));
        return showing;
    }

    public FrontEndShowings clickOnShowingsLink(String listingName) throws Exception 
    {
        FrontEndShowings frontendshowing = null;
        try
        {
            getShowingsLink(listingName).click();
            WaitFor.sleepFor(2000);
            frontendshowing = new FrontEndShowings(driver);
            AutomationLog.info("Successfully clicked on Showings link");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Showings link");
            throw(e);
        }
        return frontendshowing;
    }

    public void clickOnUpcomingShowingsLink() throws Exception
    {
        element = listingsContainer().findElements(By.tagName("tr")).get(getCount());
        WebElement showing = element.findElements(By.tagName("td")).get(2).findElement(By.tagName("a"));
        showing.click();
        AutomationLog.info("Succesfully clicked on upcoming showings link");
    }

}
