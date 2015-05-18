package com.agorafy.automation.pageobjects;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;

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
            AutomationLog.info("Could not find Showing popup");
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
        AutomationLog.info("Successfully entered date in datePicker textbox");
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
        AutomationLog.info("Successfully entered start time ");
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

    public void deleteUpcomingShowings(int count) throws Exception 
    {
        for(int i=0;i<count;i++)
        {
            hoverOnShowing(i);
            clickOnDeleteShowingIcon(i);
        }
        AutomationLog.error("Successfully deleted upcoming showings");
    }

    public void clearAllUpcomingShowings() throws Exception
    {
        
        for(int i=0;i<getUpcomingShowingsList().size();i++)
        {
            hoverOnShowing(i);
            clickOnDeleteShowingIcon(i);
            WaitFor.sleepFor(1000);
        }
        clickOnSaveButton();
        WaitFor.sleepFor(2000);
        AutomationLog.info("Successfully deleted all Upcoming showings");
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

    public List<WebElement> editDeleteShowingsIcons(int index) throws Exception
    {
        return getUpcomingShowingsList().get(index).findElements(By.tagName("i"));
    }

    public void hoverOnShowing(int index) throws Exception
    {
        Actions builder = new Actions(driver);
        Action hover = builder.moveToElement(getUpcomingShowingsList().get(index)).build();
        WaitFor.sleepFor(1000);
        hover.perform();
    }

    public WebElement icon_DeleteShowing(int index) throws Exception 
    {
        try
        {
            element = editDeleteShowingsIcons(index).get(0);
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find delete icon");
        }
        return element;
    }

    public void clickOnDeleteShowingIcon(int index) throws Exception 
    {
        try
        {
            icon_DeleteShowing(index).click();
            AutomationLog.info("Successfully clicked on delete showing icon");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on delete showing icon");
            throw(e);
        }
    }

    public WebElement icon_EditShowing(int index) throws Exception 
    {
        try
        {
            element = editDeleteShowingsIcons(index).get(1);
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find edit icon");
        }
        return element;
    }

    public void clickOnEditShowingIcon(int index) throws Exception 
    {
        try
        {
            icon_EditShowing(index).click();
            AutomationLog.info("Successfully clicked on edit showing icon");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on edit showing icon");
            throw(e);
        }
    }

    public WebElement getUpcomingShowingDate() throws Exception
    {
        try
        {
            element = getFirstUpcomingShowing().findElements(By.tagName("span")).get(0);
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Upcoming showing date");
            throw(e);
        }
        return element;
    }

    public WebElement getUpcomingShowingTime() throws Exception
    {
        try
        {
            element = getFirstUpcomingShowing().findElements(By.tagName("span")).get(1);
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Upcoming showing date");
            throw(e);
        }
        return element;
    }

    public String changeDateFormat() throws Exception
    {
        SimpleDateFormat formatter = new SimpleDateFormat("E, MMM dd, yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String dateInString = getUpcomingShowingDate().getText();
        String newdate = null;
        try
        {
            Date date = formatter.parse(dateInString);
            newdate = sdf.format(date);
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not get date from upcoming showing");
        }
        return newdate;
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

    public String[] getTime() throws Exception 
    {
        String time = getUpcomingShowingTime().getText();
        String[] time2 = time.split(" - ");
        return time2;
    }

    public int getNoOfAddedShowings() throws Exception
    {
        return getUpcomingShowingsList().size();
    }

    public WebElement text_MessageBar() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("messageBar"));
            AutomationLog.info("Messagebar text found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Message bar text");
            throw(e);
        }
        return element;
    }

    public String getSelectedDate() throws Exception 
    {
        String date = null;
        try
        {
            date = txtbx_DatePicker().getAttribute("value");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not get selected date form datepicker text box");
            throw(e);
        }
        return date;
    }

    public List<String> startTimeList() throws Exception
    {
        List<String> times = new ArrayList<String>();
        Select select = new Select(dropdown_StartTime());
        for(WebElement option : select.getOptions())
        {
            times.add(option.getText());
        }
        return times;
    }

    public String getFirstStartTime() throws Exception 
    {
        String t= startTimeList().get(0);
        return t;
    }

}
