package com.agorafy.automation.pageobjects.upsellpopups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class PropertyDetailPage extends Page 
{
    private WebElement element = null;
    
    public PropertyDetailPage(WebDriver driver) {
        super(driver);
    }
    
    public PropertyDetailPage() {
        super(driver);
    }

    public WebElement link_PropertyRecordsSignIn() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("property_records")).findElement(By.tagName("a"));
            AutomationLog.info("Sign in link found in property records");
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not found Sign in link on the Property Detail Page");
            throw(e);
        }

        return element;
    }

    public LoginPopUp clickOnPropertyRecordsSignInLink() throws Exception
    {
        LoginPopUp loginpopup;
        try
        {
            link_PropertyRecordsSignIn().click();
            loginpopup = new LoginPopUp(driver);
            AutomationLog.info("Successfully clicked on PropertyRecords Signin link");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on PropertyRecords Signin link");
            throw(e);
        }
        return loginpopup;
    }

    public WebElement propertyRecordSection_element() throws Exception
    {
        try 
        {
            element = driver.findElement(By.xpath("//div[@class='property-record-col row']"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Property Record Section is not found");
            throw(e);
        }
        return element;
    }
    
    public boolean checkingPropertyRecordSection() throws Exception
    {
        boolean bool;
        try
        {
            bool=propertyRecordSection_element().isDisplayed();
        }
        catch(Exception e)
        {
            AutomationLog.error("Property Record Section is not displayed");
            throw(e);
        }
        return bool;
     }
    
    public WebElement link_ContactInformationSignIn() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("owner-box")).findElement(By.tagName("ul")).findElement(By.tagName("a"));
            AutomationLog.info("Sign In link found under Contact Information");
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not find Sign In link under Contact Information");
            throw(e);
        }
        return element;
    }
    
    public LoginPopUp clickOnContactInformationSignInLink() throws Exception
    {
        LoginPopUp loginpopup = null;
        try
        {
            Page.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebElement mapObject = link_ContactInformationSignIn();
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", mapObject);
            Page.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            loginpopup = new LoginPopUp(driver);
            AutomationLog.info("Clicked on 'Sign in to see contact information' link");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to Click on 'Sign in to see contact information' link");
            throw(e);
        }
        return loginpopup;
    }

}
