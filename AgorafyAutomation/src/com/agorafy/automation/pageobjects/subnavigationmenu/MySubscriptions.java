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
            SubscriptionWindowCloseCross().click();
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
            WaitFor.waitUntilElementIsLoaded(driver, subscriptionsWindow());
            WaitFor.sleepFor(2000);
            element = driver.findElement(By.xpath(".//*[@id='subscriptionsContainer']/blockquote/div[2]/div[2]/a"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not locate button Subscribe in Subscription Window under User's Avatar");
            throw(e);
        }
        return element;
    }

    public WebElement SubscriptionWindowCloseCross() throws Exception
    {
        try
        {
            /*Wait until subscription window under user name displays*/
            WaitFor.waitUntilElementIsLoaded(driver, subscriptionsWindow());
            element = driver.findElement(By.id("subscriptionsWindowClose"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not locate Cross used to Close Subscription Window under User's Avatar");
            throw(e);
        }
        return element;
    }

    public WebElement SubscriptionWindow() throws Exception
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
    public WebElement pageHeadingSection() throws Exception
    {
        try 
        {
            element = driver.findElement(By.className("page-column")).findElement(By.className("content-block"));
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find page Heading section");
            throw (e);
        }
        return element;
    }

    public WebElement PageHeading() throws Exception
    {
        try 
        {
            element = pageHeadingSection().findElement(By.tagName("h2"));
            AutomationLog.info("My subscriptions page heading found");
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to find My subscriptions page heading");
            throw (e);
        }
        return element;
    }

    public String getApplicationUrl()
    {
        return applicationUrl();
    }

    public String pageHeading() throws Exception
    {
        return PageHeading().getText();
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

    public WebElement SearchSubscriptionsContainer() throws Exception 
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
        List<WebElement> list_AllSubscribedSearches = SearchSubscriptionsContainer().findElements(By.tagName("li"));
        return list_AllSubscribedSearches;
    }

    public void deleteSubscribedSearchOnRHS(WebElement subscribeToSearchLink) 
    {
        try 
        {
            element = subscribeToSearchLink.findElement(By.className("fa-times"));//findElement(By.tagName("i"));
            WaitFor.sleepFor(2000);
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
            WaitFor.waitUntilElementIsLoaded(driver, subscriptionsWindow());
            //element = subscriptionsWindow().findElement(By.linkText("View More Subscriptions"));
            WaitFor.sleepFor(1000);
            element = subscriptionsWindow().findElement(By.linkText("View More Subscriptions"));
        }
        catch (Exception e) 
        {
            AutomationLog.error("View more subscriptions link is not found on subscription window below profile pic");
            throw (e);
        }
        return element;
    }

    public WebElement subscriptionsWindow() throws Exception 
    {
        try 
        {
            WebElement parentElement = driver.findElement(By.id("subscriptionsContainer"));
            element = parentElement.findElement(By.tagName("blockquote")); 
        }
        catch (Exception e) 
        {
            AutomationLog.error("Subscriptions window container is not found on subscription window below profile pic");
            throw (e);
        }
        return element;
    }

    public WebElement option_SubscribeToRespectiveListing() throws Exception 
    {
        try 
        {
            /*Wait until subscription window under user name displays*/
            WaitFor.waitUntilElementIsLoaded(driver, By.xpath(".//*[@id='subscriptionsContainer']/blockquote"));
            element = driver.findElement(By.xpath(".//*[@id='subscriptionsContainer']/blockquote/div[2]/div[2]/a"));
        }
        catch (Exception e) 
        {
            AutomationLog.error("Subscribe To Respective Listing link is not found in subscription window below profile pic");
            throw (e);
        }
        return element;
    }

    public void clickSubscribeToRespectiveListingInSubscriptionWindow() throws Exception
    {
        try
        {
            WaitFor.sleepFor(1000);
            option_SubscribeToRespectiveListing().click();
            AutomationLog.info("Successfully clicked Subscribe To Respective Listing in Subscription Window under User's pic");
        }
        catch(Exception e)
        {
            AutomationLog.error("failed to click Subscribe To Respective Listing in Subscription Window under User's Pic");
            throw(e);
        }
    }

    public String txt_SubscribeToRespectiveListingInSubscriptionWindow() throws Exception
    {
        String txt_SubscribeToRespectiveListing = null;
        try
        {
            txt_SubscribeToRespectiveListing = option_SubscribeToRespectiveListing().getText();
            AutomationLog.info("Successfully got Subscribe To Respective Listing txt in Subscription Window");
        }
        catch(Exception e)
        {
            AutomationLog.error("failed to get text of Subscribe To Respective Listing  in Subscription Window");
            throw(e);
        }
        return txt_SubscribeToRespectiveListing;
    }

    public WebElement option_UnsubscribeFromRespectiveListing() throws Exception 
    {
        try 
        {
            //Wait until subscription window under user name displays
            WaitFor.waitUntilElementIsLoaded(driver, getViewMoreSubscriptionsLocator());
            element = driver.findElement(By.xpath(".//*[@id='subscriptionsContainer']/blockquote/div[2]/div[1]/a"));
        }
        catch (Exception e) 
        {
            AutomationLog.error("Unsubscribe from Respective Listing link is not found in subscription window below profile pic");
            throw (e);
        }
        return element;
    }

    public String txt_UnsubscrubeFromRespectiveListingInSubscriptionWindow() throws Exception
    {
        String txt_UnsubscrubeFromRespectiveListing = null;
        try
        {
            txt_UnsubscrubeFromRespectiveListing = option_UnsubscribeFromRespectiveListing().getText();
            AutomationLog.info("Successfully got txt of Unsubscribe from Respective Listing  in Subscription Window");
        }
        catch(Exception e)
        {
            AutomationLog.error("failed to get text of Unsubscribe from Respective Listing txt in Subscription Window");
            throw(e);
        }
        return txt_UnsubscrubeFromRespectiveListing;
    }

    public void clickUnsubscribeFromRespectiveListingInSubscriptionWindow() throws Exception
    {
        try
        {
        	option_UnsubscribeFromRespectiveListing().click();
            AutomationLog.info("Successfully clicked Unsubscribe From Respective Listing in Subscription Window under User's pic");
        }
        catch(Exception e)
        {
            AutomationLog.error("failed to click Unsubscribe From Respective Listing in Subscription Window under User's Pic");
            throw(e);
        }
    }

    public void clickViewMoreSubscriptionsInSubscriptionWindow() throws Exception
    {
        try
        {
            link_ViewMoreSubscriptions().click();
            AutomationLog.info("Successfully clicked View More Subscriptions in Subscription Window under User's pic");
        }
        catch(Exception e)
        {
            AutomationLog.error("failed to click View More Subscriptions in Subscription Window under User's Pic");
            throw(e);
        }
    }

    public WebElement ListingSubscriptionsContainer() throws Exception 
    {
        try 
        {
            element = driver.findElement(By.id("manage_listing"));
        }
        catch (Exception e) 
        {
            AutomationLog.error("Listing Subscriptions Container on RHS in MySubscriptions page not found");
            throw (e);
        }
        return element;
    }

    public List<WebElement> list_AllSubscribedListings() throws Exception 
    {
        /*Wait until Listing Subscriptions Container on RHS in MySubscriptions page*/ 
        WaitFor.waitUntilElementIsLoaded(driver, ListingSubscriptionsContainer());
        List<WebElement> list_AllSubscribedListings = ListingSubscriptionsContainer().findElements(By.tagName("li"));
        return list_AllSubscribedListings;
    }

    @SuppressWarnings("static-access")
	public By getViewMoreSubscriptionsLocator() throws Exception
    {
       return By.id("subscriptionsContainer").linkText("View More Subscriptions");
    }

}
