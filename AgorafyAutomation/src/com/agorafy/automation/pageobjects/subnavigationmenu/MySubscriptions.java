package com.agorafy.automation.pageobjects.subnavigationmenu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Page;

public class MySubscriptions extends Page 
{
    WebElement element;

    public MySubscriptions(WebDriver driver) 
    {
        super(driver);
    }

    public WebElement SubscriptionFeedBlock() throws Exception
    {
        try 
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[2]/div[1]"));
            AutomationLog.info("Subscription Feed block found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Subscription Feed block");
            throw (e);
        }
        return element;
    }

    public WebElement ListingSubscriptionsBlock() throws Exception
    {
        try 
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[2]/div[2]/div"));
            AutomationLog.info("Listing Subscriptions block found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Listing Subscriptions block");
            throw (e);
        }
        return element;
    }

    public void closeSubscriptionWindow() throws Exception
    {
        try
        {
            element_SubscriptionWindowCloseCross().click();
            AutomationLog.info("Successfully closed Subscription Window under User's Avatar");
        }
        catch(Exception e)
        {
            AutomationLog.error("failed to close Subscription Window under User's Avatar");
            throw(e);
        }
    }

    public void clickSubscribeInSubscriptionWindow() throws Exception
    {
        try
        {
            btn_SubscribeInSubscriptionWindow().click();
            AutomationLog.info("Successfully clicked Subscribe button in Subscription Window under User's Avatar");
        }
        catch(Exception e)
        {
            AutomationLog.error("failed to click Subscribe button in Subscription Window under User's Avatar");
            throw(e);
        }
    }

    public WebElement btn_SubscribeInSubscriptionWindow() throws Exception
    {
        try
        {
            /*Wait until subscription window under user name displays*/
            WaitFor.waitUntilElementIsLoaded(driver, By.xpath(".//*[@id='subscriptionsContainer']/blockquote"));
            Thread.sleep(2000);
            element = driver.findElement(By.xpath(".//*[@id='subscriptionsContainer']/blockquote/div[2]/div[2]/a"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not locate button Subscribe in Subscription Window under User's Avatar");
            throw(e);
        }
        return element;
    }

    public WebElement element_SubscriptionWindowCloseCross() throws Exception
    {
        try
        {
            /*Wait until subscription window under user name displays*/
            WaitFor.waitUntilElementIsLoaded(driver, By.xpath(".//*[@id='subscriptionsContainer']/blockquote"));
            element = driver.findElement(By.id("subscriptionsWindowClose"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not locate Cross used to Close Subscription Window under User's Avatar");
            throw(e);
        }
        return element;
    }

    public WebElement element_SubscriptionWindow() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("subscriptionsContainer"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not locate Subscription Window under User Name Avatar");
            throw(e);
        }
        return element;
    }

    public WebElement TitleElement() throws Exception
    {
        try 
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[1]/h2"));
            AutomationLog.info("Title element found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Title element");
            throw (e);
        }
        return element;
    }

    public WebElement element_PageHeading() throws Exception
    {
        try 
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[1]/h2"));
            AutomationLog.info("Page heading found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find Page heading");
            throw (e);
        }
        return element;
    }

    public String getURL()
    {
        return applicationUrl() + "/manage/subscriptions/";
    }

    public String pageHeading() throws Exception
    {
        return element_PageHeading().getText();
    }

    public WebElement txtbx_SearchStringInSubscriptionWindow() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("subscriptionsLabel"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not locate text box Search String in Subscribe Window under User's Avatar");
            throw(e);
        }
        return element;
    }

    public String getSearchStringInSubscriptionWindow() throws Exception
    {
        String searchString = txtbx_SearchStringInSubscriptionWindow().getAttribute("value");
        return searchString;
    }

    public WebElement element_SearchSubscriptionsContainer() throws Exception 
    {
        try 
        {
            element = driver.findElement(By.id("manage_search"));
        }
        catch (Exception e) 
        {
            AutomationLog.error("Search Subscriptions Container on RHS in MySubscriptions page not found");
            throw (e);
        }
        return element;
    }

    public List<WebElement> list_AllSubscribedSearches() throws Exception 
    {
        List<WebElement> list_AllSubscribedSearches = element_SearchSubscriptionsContainer().findElements(By.tagName("li"));
        return list_AllSubscribedSearches;
    }

    public void deleteSubscribedSearchOnRHS(WebElement subscribeToSearchLink) 
    {
        try 
        {
            element = subscribeToSearchLink.findElement(By.tagName("i"));
            element.click();
            AutomationLog.info("Sucessfully deleted subscribed search on RHS of My Subscriptions page");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to delete subscribed search on RHS of My Subscriptions page");
        }
    }

    public WebElement link_ViewMoreSubscriptions() throws Exception 
    {
        try 
        {
        	/*Wait until subscription window under user name displays*/
            WaitFor.waitUntilElementIsLoaded(driver, By.xpath(".//*[@id='subscriptionsContainer']/blockquote"));
            element = driver.findElement(By.xpath(".//*[@id='subscriptionsContainer']/blockquote/div[5]/a"));
        }
        catch (Exception e) 
        {
            AutomationLog.error("View more subscriptions link is not found on subscription window below profile pic");
            throw (e);
        }
        return element;
    }
}
