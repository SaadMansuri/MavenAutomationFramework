package com.agorafy.automation.pageobjects.subnavigationmenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
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

}
