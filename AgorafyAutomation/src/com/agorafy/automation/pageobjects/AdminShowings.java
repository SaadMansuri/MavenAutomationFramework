package com.agorafy.automation.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.agorafy.automation.automationframework.AutomationLog;

public class AdminShowings extends Page
{
    private WebElement element = null;

    public AdminShowings(WebDriver driver) 
    {
        super(driver);
    }

    public WebElement getShowingsPopUpLocator() throws Exception
    {
        element = getVisibleElement(By.cssSelector(".ui-dialog.ui-widget.ui-widget-content.ui-corner-all"));
        return element;
    }

    public WebElement popup_AdminShowings() throws Exception
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
            element = popup_AdminShowings().findElement(By.id("datepicker"));
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
            element = popup_AdminShowings().findElement(By.id("startTime"));
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
        select.selectByValue(endtime);
    }

    public String getSelectedStartTime() throws Exception 
    {
        Select select = new Select(dropdown_StartTime());
        return select.getFirstSelectedOption().getText();
    }

    public String getSelectedEndTime() throws Exception 
    {
        Select select = new Select(dropdown_EndTime());
        return select.getFirstSelectedOption().getText();
    }

    public WebElement dropdown_EndTime() throws Exception
    {
        try
        {
            element = popup_AdminShowings().findElement(By.id("endTime"));
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
           element = popup_AdminShowings().findElement(By.className("ui-dialog-buttonset")).findElements(By.tagName("button")).get(0);
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
           element = popup_AdminShowings().findElement(By.className("ui-dialog-buttonset")).findElements(By.tagName("button")).get(1);
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
            AutomationLog.info("Successfully clicked Save button on AdminShowingsPopUp ");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click Save button on AdminShowingsPopUp");
        }
    }

    public void clickOnCloseButton() throws Exception
    {
        try
        {
            btn_Close().click();
            AutomationLog.info("Successfully clicked Close button on AdminShowingsPopUp");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click Close button on AdminShowingsPopUp");
        }
    }

    public WebElement text_MessageBar() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("messageBar"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Message bar text");
            throw(e);
        }
        return element;
    }

}
