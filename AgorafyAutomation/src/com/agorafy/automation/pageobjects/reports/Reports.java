package com.agorafy.automation.pageobjects.reports;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.Page;

public class Reports extends Page 
{
    private WebElement element = null;
    private Header header = Header.header();

    public Reports(WebDriver driver) 
    {
        super(driver);
    }

    public static Reports reports() throws Exception
    {
        return PageFactory.initElements(driver, Reports.class);
    }

    public WebElement link_AddToReport() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("addToReport"));
            AutomationLog.info("AddToReport link found");
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not find Add To report link");
            throw(e);
        }
        return element;
    }

    public By getReportBoxLocator() throws Exception
    {
        return By.id("reportBox");
    }

    public WebElement reportBox() throws Exception
    {
        try
        {
            element = driver.findElement(getReportBoxLocator());
            AutomationLog.info("ReportBox found");
        }
        catch (Exception e)
        {
            AutomationLog.error("could not find ReportBox");
            throw(e);
        }
        return element;
    }

    public By getUserDropdownLocator() throws Exception
    {
        return By.className("userDropdown");
    }

    public String getReportCount() throws Exception
    {
        String count;
        header.clickOnProfileNameDropdownArrow();//Open profile name dropdown
        WaitFor.presenceOfTheElement(driver, getUserDropdownLocator());
        WaitFor.sleepFor(1000);
        count = header.reportCount().getText();
        header.clickOnProfileNameDropdownArrow();//Close profile name dropdown
        WaitFor.sleepFor(1000);
        AutomationLog.info("Successfully got Reports Count");
        return count;
    }

    public WebElement icon_ReportWindowClose() throws Exception
    {
        try
        {
            element = reportBox().findElement(By.id("reportWindowClose"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find close icon");
            throw(e);
        }
        return element;
    }

    public void clickOnReportWindowCloseIcon() throws Exception
    {
        try
        {
            icon_ReportWindowClose().click();
            AutomationLog.info("Successfully clicked on Reports Box Close icon");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Reports Box Close icon");
            throw(e);
        }
    }

    public WebElement link_Clear() throws Exception 
    {
        try
        {
            element = reportBox().findElement(By.id("clearReport"));
            AutomationLog.info("Clear link found on Reports box");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find clear link Reports box");
            throw(e);
        }
        return element;
    }

    public void clickOnClearLink() throws Exception 
    {
        try
        {
            link_Clear().click();
            AutomationLog.info("Successfully Clicked on Clear link");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Clear link");
            throw(e);
        }
    }

    public WebElement Report_List() throws Exception
    {
        try
        {
            element = reportBox().findElement(By.id("reportList"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Report list");
            throw(e);
        }
        return element;
    }

    public List<WebElement> resultsetReportList() throws Exception
    {
        return Report_List().findElements(By.tagName("li"));
    }

    public WebElement link_Print() throws Exception 
    {
        try
        {
            element = reportBox().findElement(By.id("printReport"));
            AutomationLog.info("Print link found on Reports box");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Print link on Reports box");
            throw(e);
        }
        return element;
    }

    public ReportsPopUp clickOnPrintLink() throws Exception 
    {
        ReportsPopUp reportspopup = null;
        try
        {
            link_Print().click();
            WaitFor.ElementToBeDisplayed(driver, By.id("customizeReport"));
            reportspopup = new ReportsPopUp(driver);
            AutomationLog.info("Successfully Clicked on Print link");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Print link");
            throw(e);
        }
        return reportspopup;
    }

    public WebElement icon_DeleteListing() throws Exception
    {
        try
        {
            element = DeleteListingIconList().get(0);
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Delete Listing icon");
            throw(e);
        }
        return element;
    }

    public void hoverOnFirstDeleteListingIcon() throws Exception
    {
        Actions builder = new Actions(driver);
        Action hover = builder.moveToElement(FirstListingInReportList()).build();
        WaitFor.sleepFor(1000);
        hover.perform();
        AutomationLog.info("Successfully hovered on DeleteListing icon");
    }

    public WebElement FirstListingInReportList() throws Exception
    {
        return resultsetReportList().get(0);
    }

    public void clickOnFirstDeleteListingIcon() throws Exception
    {
        try
        {
            icon_DeleteListing().click();
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on first delete listing icon");
            throw(e);
        }
    }

    public List<WebElement> DeleteListingIconList() throws Exception
    {
        return Report_List().findElements(By.className("del-listing"));
    }

}
