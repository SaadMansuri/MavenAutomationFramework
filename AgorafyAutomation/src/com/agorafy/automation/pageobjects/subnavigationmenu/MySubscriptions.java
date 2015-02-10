package com.agorafy.automation.pageobjects.subnavigationmenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
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
	
	
}
