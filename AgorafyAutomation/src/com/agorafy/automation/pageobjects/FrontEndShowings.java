package com.agorafy.automation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.agorafy.automation.automationframework.AutomationLog;

public class FrontEndShowings extends Page
{
    private WebElement element = null;

    public FrontEndShowings(WebDriver driver)
    {
        super(driver);
    }

    public WebElement getShowingsPopUpLocator() throws Exception
    {
        element = getVisibleElement(By.cssSelector(".ui-dialog.ui-widget.ui-widget-content.ui-corner-all"));
        return element;
    }

    public WebElement popup_FrontEndShowings() throws Exception
    {
        try
        {
            element = getShowingsPopUpLocator();
        }
        catch(Exception e)
        {
            AutomationLog.info("Could not find Showing popuoo");
            throw(e);
        }
        return element;
    }

    public WebElement txtbx_DatePicker() throws Exception
    {
        try
        {
            element = popup_FrontEndShowings().findElement(By.id("datepicker"));
        }
        catch(Exception e)
        {
           AutomationLog.error("Could not find Date Picker textbox");
           throw(e);
        }
        return element;
    }

    public void enterDateInDatePickerTextBox(String date) throws Exception
    {
        txtbx_DatePicker().clear();
        txtbx_DatePicker().sendKeys(date); 
    }

    public WebElement dropdown_StartTime() throws Exception
    {
        try
        {
            element = popup_FrontEndShowings().findElement(By.id("startTime"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Start Time Drop down");
            throw(e);
        }
        return element;
    }

    public void selectStartTime(String starttime) throws Exception
    {
        Select select = new Select(dropdown_StartTime());
        select.selectByVisibleText(starttime);
    }

    public void selectEndTime(String endtime) throws Exception
    {
        Select select = new Select(dropdown_EndTime());
        select.selectByVisibleText(endtime);
    }

    public WebElement dropdown_EndTime() throws Exception
    {
        try
        {
            element = popup_FrontEndShowings().findElement(By.id("endTime"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find End Time Drop down");
            throw(e);
        }
        return element;
    }

    public WebElement btn_Save() throws Exception
    {
       try 
       {
           element = popup_FrontEndShowings().findElement(By.className("btn-send"));
       }
       catch(Exception e)
       {
           AutomationLog.error("Could not find Save Button");
           throw(e);
       }
       return element;
    }

    public WebElement btn_Close() throws Exception
    {
       try 
       {
           element = popup_FrontEndShowings().findElement(By.id("btnCancelDialog"));
       }
       catch(Exception e)
       {
           AutomationLog.error("Could not find Close Button");
           throw(e);
       }
       return element;
    }

    public void clickOnSaveButton() throws Exception
    {
        try
        {
            btn_Save().click();
            AutomationLog.info("Successfully clicked on Save button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Save button");
        }
    }

    public void clickOnCloseButton() throws Exception
    {
        try
        {
            btn_Close().click();
            AutomationLog.info("Successfully clicked on Close button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Close button");
        }
    }

    public List<WebElement> getUpcomingShowingsList() throws Exception
    {
        return driver.findElement(By.id("showingFormContainer")).findElements(By.tagName("li"));
    }

    public WebElement getFirstUpcomingShowing() throws Exception 
    {
        try
        {
            element = getUpcomingShowingsList().get(0);
        }
        catch(Exception e)
        {
            AutomationLog.error("could not find Upcoming showing");
            throw(e);
        }
        return element;
    }

    public int getNoOfAddedShowings() throws Exception
    {
        return getUpcomingShowingsList().size();
    }

}
