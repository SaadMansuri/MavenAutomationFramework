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
